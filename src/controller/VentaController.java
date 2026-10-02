package controller;

import dao.VentaDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import modelo.DetalleVenta;
import modelo.Venta;
import factory.ModeloFactory;

public class VentaController {

    private static final VentaDAO ventaDAO = new VentaDAO();

    public static ArrayList<Object[]> listarVentas() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Venta venta : ventaDAO.listar()) {

            lista.add(new Object[]{
                venta.getIdVenta(),
                venta.getFecha(),
                venta.getTotal(),
                venta.getMedioPago()
            });
        }

        return lista;
    }

    public static void guardarVenta(String fecha,
                                    String medioPago,
                                    JTable tablaDetalle) {

        Venta venta = ModeloFactory.crearVenta(
                -1,
                fecha,
                0,
                medioPago
        );
        double total = 0;

        for (int i = 0; i < tablaDetalle.getRowCount(); i++) {

            String producto =
                    tablaDetalle.getValueAt(i, 0).toString();

            int cantidad = Integer.parseInt(
                    tablaDetalle.getValueAt(i, 1).toString()
            );

            double precio = Double.parseDouble(
                    tablaDetalle.getValueAt(i, 2).toString()
            );

            DetalleVenta detalle = new DetalleVenta(
                    0,
                    producto,
                    cantidad,
                    precio
            );

            venta.agregarDetalle(detalle);

            total += detalle.getSubtotal();
        }

        venta.setTotal(total);

        ventaDAO.guardar(
                venta
        );

        AuditoriaController.registrar(
                "VENTAS",
                "CREAR VENTA",
                "Se registró una venta por $"
                + String.format(
                        "%.2f",
                        total
                )
                + " mediante "
                + medioPago
                + ", con "
                + tablaDetalle.getRowCount()
                + " producto(s)"
        );
    }
    
    public static ArrayList<Object[]> buscarVentas(
            String filtro
    ) {
        return ventaDAO.buscarVentas(
                filtro
        );
    }

    public static boolean anularVenta(
            int idVenta
    ) {

        return ventaDAO.anularVenta(
                idVenta
        );
    }

    public static ArrayList<Object[]> listarVentasConDetalle() {
        return ventaDAO.listarVentasConDetalle();
    }

    public static ArrayList<Object[]> listarVentasPorFecha(
                                    String desde,
                                    String hasta) {

        return ventaDAO.listarVentasPorFecha(desde, hasta);
    }
}