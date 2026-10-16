package dao;

import interfaces.CrudDAO;
import modelo.Producto;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import sistemaveterinaria.Conexion;

public class ProductoDAO implements CrudDAO<Producto> {
    public ProductoDAO() {

        new MarcaDAO();
    }
    @Override
    public void guardar(
            Producto producto
    ) {

        Connection conn = null;

        try {

            conn =
                    Conexion.getInstancia()
                            .conectar();

            int idMarca =
                    producto.getIdMarca();

            if (idMarca <= 0) {

                idMarca =
                        obtenerIdSinMarca(
                                conn
                        );
            }

            boolean editando =
                    producto.getIdProducto()
                    != -1;

            if (editando) {

                String sql =
                        "UPDATE productos "
                        + "SET nombre = ?, "
                        + "precio = ?, "
                        + "stock = ?, "
                        + "id_marca = ? "
                        + "WHERE id_producto = ?";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setString(
                        1,
                        producto.getNombre()
                );

                pst.setDouble(
                        2,
                        producto.getPrecio()
                );

                pst.setInt(
                        3,
                        producto.getStock()
                );

                pst.setInt(
                        4,
                        idMarca
                );

                pst.setInt(
                        5,
                        producto.getIdProducto()
                );

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO productos "
                        + "(nombre, precio, stock, "
                        + "fecha_vencimiento, id_marca) "
                        + "VALUES (?, ?, ?, ?, ?)";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setString(
                        1,
                        producto.getNombre()
                );

                pst.setDouble(
                        2,
                        producto.getPrecio()
                );

                pst.setInt(
                        3,
                        producto.getStock()
                );

                pst.setString(
                        4,
                        producto.getFechaVencimiento()
                );

                pst.setInt(
                        5,
                        idMarca
                );

                pst.executeUpdate();
                pst.close();
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al guardar producto: "
                    + e.getMessage()
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private int obtenerIdSinMarca(
            Connection conn
    ) throws Exception {

        String sql =
                "SELECT id_marca "
                + "FROM marcas "
                + "WHERE LOWER(nombre) = "
                + "LOWER('Sin marca')";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        ResultSet rs =
                pst.executeQuery();

        int idMarca = -1;

        if (rs.next()) {

            idMarca =
                    rs.getInt(
                            "id_marca"
                    );
        }

        rs.close();
        pst.close();

        return idMarca;
    }
    @Override
    public ArrayList<Producto> listar() {

        ArrayList<Producto> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "SELECT p.*, "
                    + "m.nombre AS nombre_marca "
                    + "FROM productos p "
                    + "LEFT JOIN marcas m "
                    + "ON p.id_marca = m.id_marca "
                    + "WHERE p.activo = 1 "
                    + "ORDER BY p.nombre";

            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                        
                );

                producto.setFechaVencimiento(
                        rs.getString("fecha_vencimiento")
                );
                producto.setIdMarca(
                        rs.getInt(
                                "id_marca"
                        )
                );

                producto.setNombreMarca(
                        rs.getString(
                                "nombre_marca"
                        )
                );
                producto.setActivo(
                        rs.getInt("activo") == 1
                );
                lista.add(producto);
            }

            rs.close();
            st.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
    
    public ArrayList<Producto> buscarProductos(
            String filtro
    ) {
        ArrayList<Producto> lista =
                new ArrayList<>();

        Connection conn = null;

        try {

            conn =
                    Conexion.getInstancia().conectar();
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "SELECT p.*, "
                    + "m.nombre AS nombre_marca "
                    + "FROM productos p "
                    + "LEFT JOIN marcas m "
                    + "ON p.id_marca = m.id_marca "
                    + "WHERE p.activo = 1 "
                    + "AND (CAST(p.id_producto AS TEXT) LIKE ? "
                    + "OR LOWER(p.nombre) LIKE LOWER(?) "
                    + "OR LOWER(COALESCE(m.nombre, '')) LIKE LOWER(?)) "
                    + "ORDER BY p.nombre";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            String busqueda =
                    "%" + filtro.trim() + "%";

            pst.setString(
                    1,
                    busqueda
            );

            pst.setString(
                    2,
                    busqueda
            );
            pst.setString(
                    3,
                    busqueda
            );
            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Producto producto =
                        new Producto(
                                rs.getInt(
                                        "id_producto"
                                ),
                                rs.getString(
                                        "nombre"
                                ),
                                rs.getDouble(
                                        "precio"
                                ),
                                rs.getInt(
                                        "stock"
                                )
                        );

                producto.setFechaVencimiento(
                        rs.getString(
                                "fecha_vencimiento"
                        )
                );
                producto.setIdMarca(
                        rs.getInt(
                                "id_marca"
                        )
                );

                producto.setNombreMarca(
                        rs.getString(
                                "nombre_marca"
                        )
                );
                producto.setActivo(
                        rs.getInt("activo") == 1
                );
                lista.add(
                        producto
                );
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al buscar productos: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    @Override
    public void eliminar(int idProducto) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "UPDATE productos "
                    + "SET activo = 0 "
                    + "WHERE id_producto = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idProducto);
            pst.executeUpdate();

            pst.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> listarNombres() {

        ArrayList<String> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "SELECT nombre "
                    + "FROM productos "
                    + "WHERE activo = 1 "
                    + "ORDER BY nombre";

            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }

            rs.close();
            st.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al listar nombres de productos: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    public double obtenerPrecio(String nombre) {

        double precio = 0;
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "SELECT precio "
                    + "FROM productos "
                    + "WHERE nombre = ? "
                    + "AND activo = 1";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nombre);

            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                precio = rs.getDouble("precio");
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al obtener precio: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return precio;
    }

    public HashMap<String, Double> obtenerMapaPrecios() {

        HashMap<String, Double> mapa = new HashMap<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "SELECT nombre, precio "
                    + "FROM productos "
                    + "WHERE activo = 1";

            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                mapa.put(
                        rs.getString("nombre"),
                        rs.getDouble("precio")
                );
            }

            rs.close();
            st.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al obtener mapa de precios: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mapa;
    }
    
    public int obtenerStock(String nombre) {

        int stock = 0;
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            
            String sql =
                    "SELECT stock "
                    + "FROM productos "
                    + "WHERE nombre = ? "
                    + "AND activo = 1";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nombre);

            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                stock = rs.getInt("stock");
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al obtener stock: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return stock;
    }

    public String obtenerFechaVencimiento(String nombre) {

        String fechaVencimiento = null;
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "SELECT fecha_vencimiento "
                    + "FROM productos "
                    + "WHERE nombre = ? "
                    + "AND activo = 1";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nombre);

            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                fechaVencimiento = rs.getString("fecha_vencimiento");
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al obtener fecha de vencimiento: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return fechaVencimiento;
    }

    public ArrayList<Producto> listarProximosAVencer() {

        ArrayList<Producto> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "SELECT * FROM productos "
                    + "WHERE activo = 1 "
                    + "AND fecha_vencimiento IS NOT NULL "
                    + "AND fecha_vencimiento != '' "
                    + "AND date(fecha_vencimiento) >= date('now') "
                    + "AND date(fecha_vencimiento) <= date('now', '+7 days') "
                    + "ORDER BY date(fecha_vencimiento)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto();

                producto.setIdProducto(
                        rs.getInt("id_producto")
                );

                producto.setNombre(
                        rs.getString("nombre")
                );

                producto.setPrecio(
                        rs.getDouble("precio")
                );

                producto.setStock(
                        rs.getInt("stock")
                );

                producto.setFechaVencimiento(
                        rs.getString("fecha_vencimiento")
                );

                lista.add(producto);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al listar productos próximos a vencer: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
    private void asegurarColumnaActivo(
            Connection conn
    ) throws Exception {

        boolean existeColumna = false;

        PreparedStatement pstConsultar =
                conn.prepareStatement(
                        "PRAGMA table_info(productos)"
                );

        ResultSet rs =
                pstConsultar.executeQuery();

        while (rs.next()) {

            if ("activo".equalsIgnoreCase(
                    rs.getString("name")
            )) {

                existeColumna = true;
                break;
            }
        }

        rs.close();
        pstConsultar.close();

        if (!existeColumna) {

            PreparedStatement pstCrear =
                    conn.prepareStatement(
                            "ALTER TABLE productos "
                            + "ADD COLUMN activo "
                            + "INTEGER NOT NULL DEFAULT 1"
                    );

            pstCrear.executeUpdate();
            pstCrear.close();
        }
    }
    public ArrayList<Producto> listarInactivos() {

        ArrayList<Producto> lista =
                new ArrayList<>();

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            asegurarColumnaActivo(
                    conn
            );

            String sql =
                    "SELECT p.*, "
                    + "m.nombre AS nombre_marca "
                    + "FROM productos p "
                    + "LEFT JOIN marcas m "
                    + "ON p.id_marca = m.id_marca "
                    + "WHERE p.activo = 0 "
                    + "ORDER BY p.nombre";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(sql);

                    ResultSet rs =
                            pst.executeQuery()
            ) {

                while (rs.next()) {

                    Producto producto =
                            new Producto(
                                    rs.getInt("id_producto"),
                                    rs.getString("nombre"),
                                    rs.getDouble("precio"),
                                    rs.getInt("stock")
                            );

                    producto.setFechaVencimiento(
                            rs.getString(
                                    "fecha_vencimiento"
                            )
                    );

                    producto.setIdMarca(
                            rs.getInt(
                                    "id_marca"
                            )
                    );

                    producto.setNombreMarca(
                            rs.getString(
                                    "nombre_marca"
                            )
                    );

                    producto.setActivo(false);

                    lista.add(
                            producto
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al listar productos inactivos: "
                    + e.getMessage()
            );
        }

        return lista;
    }
    public boolean reactivar(
            int idProducto
    ) {

        String sql =
                "UPDATE productos "
                + "SET activo = 1 "
                + "WHERE id_producto = ? "
                + "AND activo = 0";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            asegurarColumnaActivo(
                    conn
            );

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(sql)
            ) {

                pst.setInt(
                        1,
                        idProducto
                );

                return pst.executeUpdate() > 0;
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al reactivar el producto: "
                    + e.getMessage()
            );

            return false;
        }
    }
}