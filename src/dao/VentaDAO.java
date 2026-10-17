package dao;

import interfaces.CrudDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.DetalleVenta;
import modelo.Venta;
import sistemaveterinaria.Conexion;

public class VentaDAO implements CrudDAO<Venta> {

    @Override
    public void guardar(Venta venta) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            conn.setAutoCommit(false);

            String sqlVenta =
                    "INSERT INTO ventas "
                    + "(fecha, total, medio_pago, id_cliente, id_usuario) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstVenta = conn.prepareStatement(
                    sqlVenta,
                    java.sql.Statement.RETURN_GENERATED_KEYS
            );

            pstVenta.setString(
                    1,
                    venta.getFecha()
            );

            pstVenta.setDouble(
                    2,
                    venta.getTotal()
            );

            pstVenta.setString(
                    3,
                    venta.getMedioPago()
            );

            if (venta.getIdCliente() > 0) {

                pstVenta.setInt(
                        4,
                        venta.getIdCliente()
                );

            } else {

                pstVenta.setNull(
                        4,
                        java.sql.Types.INTEGER
                );
            }

            if (venta.getIdUsuario() > 0) {

                pstVenta.setInt(
                        5,
                        venta.getIdUsuario()
                );

            } else {

                pstVenta.setNull(
                        5,
                        java.sql.Types.INTEGER
                );
            }

            pstVenta.executeUpdate();
            ResultSet rsVenta = pstVenta.getGeneratedKeys();

            if (!rsVenta.next()) {
                throw new RuntimeException(
                        "No se pudo obtener el ID de la venta"
                );
            }

            int idVenta = rsVenta.getInt(1);

            for (DetalleVenta detalle : venta.getDetalles()) {

                int idProducto = detalle.getIdProducto();

                /*
                 * Si el detalle todavía no tiene el ID del producto,
                 * lo buscamos por nombre.
                 */
                if (idProducto == 0) {

                    String sqlProducto =
                            "SELECT id_producto FROM productos WHERE nombre = ?";

                    PreparedStatement pstProducto =
                            conn.prepareStatement(sqlProducto);

                    pstProducto.setString(1, detalle.getProducto());

                    ResultSet rsProducto =
                            pstProducto.executeQuery();

                    if (!rsProducto.next()) {
                        throw new RuntimeException(
                                "No se encontró el producto: "
                                + detalle.getProducto()
                        );
                    }

                    idProducto =
                            rsProducto.getInt("id_producto");

                    rsProducto.close();
                    pstProducto.close();
                }

                String sqlDetalle =
                        "INSERT INTO detalle_venta "
                        + "(id_venta, id_producto, cantidad, precio) "
                        + "VALUES (?, ?, ?, ?)";

                PreparedStatement pstDetalle =
                        conn.prepareStatement(sqlDetalle);

                pstDetalle.setInt(1, idVenta);
                pstDetalle.setInt(2, idProducto);
                pstDetalle.setInt(3, detalle.getCantidad());
                pstDetalle.setDouble(4, detalle.getPrecio());

                pstDetalle.executeUpdate();
                pstDetalle.close();
                
                String sqlStock =
                        "UPDATE productos SET stock = stock - ? WHERE id_producto = ?";

                PreparedStatement pstStock =
                        conn.prepareStatement(sqlStock);

                pstStock.setInt(1, detalle.getCantidad());
                pstStock.setInt(2, idProducto);

                pstStock.executeUpdate();
                pstStock.close();
            }

            conn.commit();

            rsVenta.close();
            pstVenta.close();

        } catch (Exception e) {

            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            throw new RuntimeException(
                    "Error al guardar la venta: " + e.getMessage(),
                    e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Venta> listar() {

        ArrayList<Venta> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT v.*, "
                    + "COALESCE(c.nombre, 'Sin cliente') "
                    + "AS nombre_cliente, "
                    + "COALESCE(u.usuario, 'Sin usuario') "
                    + "AS nombre_usuario "
                    + "FROM ventas v "
                    + "LEFT JOIN clientes c "
                    + "ON v.id_cliente = c.id_cliente "
                    + "LEFT JOIN usuarios u "
                    + "ON v.id_usuario = u.id_usuario "
                    + "ORDER BY v.id_venta DESC";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Venta venta = new Venta(
                        rs.getInt("id_venta"),
                        rs.getString("fecha"),
                        rs.getDouble("total"),
                        rs.getString("medio_pago")
                );
                venta.setIdCliente(
                        rs.getInt("id_cliente")
                );

                venta.setNombreCliente(
                        rs.getString("nombre_cliente")
                );

                venta.setIdUsuario(
                        rs.getInt("id_usuario")
                );

                venta.setNombreUsuario(
                        rs.getString("nombre_usuario")
                );
                lista.add(venta);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al listar ventas: "
                    + e.getMessage(),
                    e
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
    
    public ArrayList<Object[]> buscarVentas(
            String filtro
    ) {
        ArrayList<Object[]> lista =
                new ArrayList<>();

        Connection conn = null;

        try {

            conn =
                    Conexion.getInstancia().conectar();

            String sql = """
                    SELECT v.id_venta,
                           v.fecha,
                           p.nombre AS producto,
                           d.cantidad,
                           d.precio,
                           (d.cantidad * d.precio) AS subtotal,
                           v.total,
                           v.medio_pago,
                           v.estado
                    FROM ventas v
                    JOIN detalle_venta d
                        ON v.id_venta = d.id_venta
                    JOIN productos p
                        ON d.id_producto = p.id_producto
                    WHERE CAST(v.id_venta AS TEXT) LIKE ?
                       OR v.fecha LIKE ?
                       OR LOWER(p.nombre) LIKE LOWER(?)
                       OR LOWER(v.medio_pago) LIKE LOWER(?)
                    ORDER BY v.id_venta DESC
                    """;

            PreparedStatement pst =
                    conn.prepareStatement(
                            sql
                    );

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

            pst.setString(
                    4,
                    busqueda
            );

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                lista.add(
                        new Object[]{
                            rs.getInt(
                                    "id_venta"
                            ),
                            rs.getString(
                                    "fecha"
                            ),
                            rs.getString(
                                    "producto"
                            ),
                            rs.getInt(
                                    "cantidad"
                            ),
                            rs.getDouble(
                                    "precio"
                            ),
                            rs.getDouble(
                                    "subtotal"
                            ),
                            rs.getDouble(
                                    "total"
                            ),
                            rs.getString(
                                    "medio_pago"
                            )
                        }
                );
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al buscar ventas: "
                    + e.getMessage(),
                    e
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
    public VentaDAO() {

        inicializarEstadoVentas();
        inicializarResponsablesVenta();
    }
    private void inicializarResponsablesVenta() {

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            agregarColumnaSiNoExiste(
                    conn,
                    "id_cliente"
            );

            agregarColumnaSiNoExiste(
                    conn,
                    "id_usuario"
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al preparar los responsables de las ventas: "
                    + e.getMessage(),
                    e
            );
        }
    }

    private void agregarColumnaSiNoExiste(
            Connection conn,
            String nombreColumna
    ) throws Exception {

        boolean existe =
                false;

        String sqlColumnas =
                "PRAGMA table_info(ventas)";

        try (
                PreparedStatement pst =
                        conn.prepareStatement(
                                sqlColumnas
                        );

                ResultSet rs =
                        pst.executeQuery()
        ) {

            while (rs.next()) {

                if (nombreColumna.equalsIgnoreCase(
                        rs.getString("name")
                )) {

                    existe = true;
                    break;
                }
            }
        }

        if (!existe) {

            String sqlAgregar =
                    "ALTER TABLE ventas "
                    + "ADD COLUMN "
                    + nombreColumna
                    + " INTEGER";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(
                                    sqlAgregar
                            )
            ) {

                pst.executeUpdate();
            }
        }
    }
    private void inicializarEstadoVentas() {

        String sql =
                "ALTER TABLE ventas "
                + "ADD COLUMN estado TEXT NOT NULL DEFAULT 'ACTIVA'";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();
                PreparedStatement pst =
                        conn.prepareStatement(sql)
        ) {

            pst.executeUpdate();

        } catch (Exception e) {

            if (!e.getMessage().toLowerCase()
                    .contains("duplicate column")) {

                throw new RuntimeException(
                        "Error al inicializar el estado de las ventas: "
                        + e.getMessage(),
                        e
                );
            }
        }
    }
    public boolean anularVenta(int idVenta) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            conn.setAutoCommit(false);

            String sqlEstado =
                    "SELECT estado "
                    + "FROM ventas "
                    + "WHERE id_venta = ?";

            String estado;

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(sqlEstado)
            ) {

                pst.setInt(1, idVenta);

                try (ResultSet rs = pst.executeQuery()) {

                    if (!rs.next()) {
                        throw new RuntimeException(
                                "No se encontró la venta"
                        );
                    }

                    estado = rs.getString("estado");
                }
            }

            if ("ANULADA".equalsIgnoreCase(estado)) {

                conn.rollback();
                return false;
            }

            String sqlRestaurarStock =
                    "UPDATE productos "
                    + "SET stock = stock + ("
                    + "SELECT COALESCE(SUM(d.cantidad), 0) "
                    + "FROM detalle_venta d "
                    + "WHERE d.id_venta = ? "
                    + "AND d.id_producto = productos.id_producto"
                    + ") "
                    + "WHERE id_producto IN ("
                    + "SELECT id_producto "
                    + "FROM detalle_venta "
                    + "WHERE id_venta = ?"
                    + ")";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(
                                    sqlRestaurarStock
                            )
            ) {

                pst.setInt(1, idVenta);
                pst.setInt(2, idVenta);
                pst.executeUpdate();
            }

            String sqlAnular =
                    "UPDATE ventas "
                    + "SET estado = 'ANULADA' "
                    + "WHERE id_venta = ? "
                    + "AND estado = 'ACTIVA'";

            int filasActualizadas;

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(sqlAnular)
            ) {

                pst.setInt(1, idVenta);
                filasActualizadas =
                        pst.executeUpdate();
            }

            if (filasActualizadas == 0) {

                conn.rollback();
                return false;
            }

            conn.commit();
            return true;

        } catch (Exception e) {

            try {

                if (conn != null) {
                    conn.rollback();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            throw new RuntimeException(
                    "Error al anular la venta: "
                    + e.getMessage(),
                    e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int idVenta) {

        anularVenta(idVenta);
    }

    public ArrayList<Object[]> listarVentasConDetalle() {

        ArrayList<Object[]> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = """
                SELECT v.id_venta,
                       v.fecha,
                       p.nombre AS producto,
                       d.cantidad,
                       d.precio,
                       (d.cantidad * d.precio) AS subtotal,
                       v.total,
                       v.medio_pago,
                       v.estado
                FROM ventas v
                JOIN detalle_venta d
                    ON v.id_venta = d.id_venta
                JOIN productos p
                    ON d.id_producto = p.id_producto
                ORDER BY v.id_venta DESC
            """;

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                lista.add(new Object[]{
                    rs.getInt("id_venta"),
                    rs.getString("fecha"),
                    rs.getString("producto"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio"),
                    rs.getDouble("subtotal"),
                    rs.getDouble("total"),
                    rs.getString("medio_pago"),
                    rs.getString("estado")
                });
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al listar ventas con detalle: "
                    + e.getMessage(),
                    e
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
    
    public ArrayList<Object[]> listarVentasPorFecha(
            String desde,
            String hasta) {

        ArrayList<Object[]> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = """
                    SELECT v.id_venta,
                           v.fecha,
                           p.nombre AS producto,
                           d.cantidad,
                           d.precio,
                           (d.cantidad * d.precio) AS subtotal,
                           v.total,
                           v.medio_pago
                    FROM ventas v
                    JOIN detalle_venta d
                        ON v.id_venta = d.id_venta
                    JOIN productos p
                        ON d.id_producto = p.id_producto
                    WHERE date(
                            substr(v.fecha, 7, 4) || '-' ||
                            substr(v.fecha, 4, 2) || '-' ||
                            substr(v.fecha, 1, 2)
                          )
                          BETWEEN date(
                            substr(?, 7, 4) || '-' ||
                            substr(?, 4, 2) || '-' ||
                            substr(?, 1, 2)
                          )
                          AND date(
                            substr(?, 7, 4) || '-' ||
                            substr(?, 4, 2) || '-' ||
                            substr(?, 1, 2)
                          )
                      AND COALESCE(v.estado, 'ACTIVA') = 'ACTIVA'
                    ORDER BY v.id_venta DESC
                    """;
            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, desde);
            pst.setString(2, desde);
            pst.setString(3, desde);

            pst.setString(4, hasta);
            pst.setString(5, hasta);
            pst.setString(6, hasta);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                lista.add(new Object[]{
                    rs.getInt("id_venta"),
                    rs.getString("fecha"),
                    rs.getString("producto"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio"),
                    rs.getDouble("subtotal"),
                    rs.getDouble("total"),
                    rs.getString("medio_pago")
                });
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al generar reporte de ventas: "
                    + e.getMessage(),
                    e
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