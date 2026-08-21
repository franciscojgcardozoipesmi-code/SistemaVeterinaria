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
                "INSERT INTO ventas (fecha, total, medio_pago) "
                + "VALUES (?, ?, ?)";

            PreparedStatement pstVenta = conn.prepareStatement(
                    sqlVenta,
                    java.sql.Statement.RETURN_GENERATED_KEYS
            );

            pstVenta.setString(1, venta.getFecha());
            pstVenta.setDouble(2, venta.getTotal());
            pstVenta.setString(3, venta.getMedioPago());
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

            String sql = "SELECT * FROM ventas";

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

    @Override
    public void eliminar(int idVenta) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            conn.setAutoCommit(false);

            String sqlBuscarDetalles =
                    "SELECT id_producto, cantidad "
                    + "FROM detalle_venta "
                    + "WHERE id_venta = ?";

            PreparedStatement pstBuscarDetalles =
                    conn.prepareStatement(sqlBuscarDetalles);

            pstBuscarDetalles.setInt(1, idVenta);

            ResultSet rsDetalles =
                    pstBuscarDetalles.executeQuery();

            while (rsDetalles.next()) {

                int idProducto =
                        rsDetalles.getInt("id_producto");

                int cantidad =
                        rsDetalles.getInt("cantidad");

                String sqlStock =
                        "UPDATE productos "
                        + "SET stock = stock + ? "
                        + "WHERE id_producto = ?";

                PreparedStatement pstStock =
                        conn.prepareStatement(sqlStock);

                pstStock.setInt(1, cantidad);
                pstStock.setInt(2, idProducto);

                pstStock.executeUpdate();
                pstStock.close();
            }

            rsDetalles.close();
            pstBuscarDetalles.close();

            String sqlDetalle =
                    "DELETE FROM detalle_venta WHERE id_venta = ?";

            PreparedStatement pstDetalle =
                    conn.prepareStatement(sqlDetalle);

            pstDetalle.setInt(1, idVenta);
            pstDetalle.executeUpdate();
            pstDetalle.close();

            String sqlVenta =
                    "DELETE FROM ventas WHERE id_venta = ?";

            PreparedStatement pstVenta =
                    conn.prepareStatement(sqlVenta);

            pstVenta.setInt(1, idVenta);
            pstVenta.executeUpdate();
            pstVenta.close();

            conn.commit();

        } catch (Exception e) {

            try {

                if (conn != null) {
                    conn.rollback();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            throw new RuntimeException(
                    "Error al eliminar venta: "
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
                       v.medio_pago
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
                    rs.getString("medio_pago")
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
}