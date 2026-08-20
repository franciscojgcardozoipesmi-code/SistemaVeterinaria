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

    @Override
    public void guardar(Producto producto) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            boolean editando = (producto.getIdProducto() != -1);

            if (editando) {

                String sql =
                        "UPDATE productos SET nombre=?, precio=?, stock=?, fecha_vencimiento=? WHERE id_producto=?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, producto.getNombre());
                pst.setDouble(2, producto.getPrecio());
                pst.setInt(3, producto.getStock());
                pst.setString(4, producto.getFechaVencimiento());
                pst.setInt(5, producto.getIdProducto());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO productos (nombre, precio, stock, fecha_vencimiento) VALUES (?, ?, ?, ?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, producto.getNombre());
                pst.setDouble(2, producto.getPrecio());
                pst.setInt(3, producto.getStock());
                pst.setString(4, producto.getFechaVencimiento());

                pst.executeUpdate();
                pst.close();
            }

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

    @Override
    public ArrayList<Producto> listar() {

        ArrayList<Producto> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = "SELECT * FROM productos";

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

    @Override
    public void eliminar(int idProducto) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "DELETE FROM productos WHERE id_producto = ?";

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

            String sql = "SELECT nombre FROM productos";

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

            String sql =
                    "SELECT precio FROM productos WHERE nombre = ?";

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

            String sql = "SELECT nombre, precio FROM productos";

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
                    "SELECT stock FROM productos WHERE nombre = ?";

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

            String sql =
                    "SELECT fecha_vencimiento FROM productos WHERE nombre = ?";

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

            String sql =
                    "SELECT * FROM productos "
                    + "WHERE fecha_vencimiento IS NOT NULL "
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
}