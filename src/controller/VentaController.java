package controller;

import dao.VentaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;
import modelo.DetalleVenta;
import modelo.Venta;
import factory.ModeloFactory;
import modelo.Usuario;
import sistemaveterinaria.SesionUsuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class VentaController {

    private static final VentaDAO ventaDAO = new VentaDAO();

    public static ArrayList<Object[]> listarVentas() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Venta venta : ventaDAO.listar()) {

            lista.add(
                    new Object[]{
                        venta.getIdVenta(),
                        venta.getFecha(),
                        venta.getNombreCliente(),
                        venta.getNombreUsuario(),
                        venta.getTotal(),
                        venta.getMedioPago()
                    }
            );
        }

        return lista;
    }

    public static void guardarVenta(
            String fecha,
            String medioPago,
            JTable tablaDetalle
    ) {

        guardarVenta(
                medioPago,
                tablaDetalle,
                -1
        );
    }

    public static void guardarVenta(
            String medioPago,
            JTable tablaDetalle,
            int idCliente
    ) {

        String fechaActual =
                LocalDate.now().format(
                        DateTimeFormatter.ofPattern(
                                "dd/MM/yyyy"
                        )
                );

        Venta venta =
                ModeloFactory.crearVenta(
                        -1,
                        fechaActual,
                        0,
                        medioPago
                );

        venta.setIdCliente(
                idCliente
        );

        if (SesionUsuario.haySesionActiva()) {

            Usuario usuarioActual =
                    UsuarioController.obtenerUsuarioPorNombre(
                            SesionUsuario.getNombreUsuario()
                    );

            if (usuarioActual != null) {

                venta.setIdUsuario(
                        usuarioActual.getIdUsuario()
                );

                venta.setNombreUsuario(
                        usuarioActual.getUsuario()
                );
            }
        }

        double total = 0;

        for (int i = 0;
                i < tablaDetalle.getRowCount();
                i++) {

            String producto =
                    tablaDetalle.getValueAt(
                            i,
                            0
                    ).toString();

            int cantidad =
                    Integer.parseInt(
                            tablaDetalle.getValueAt(
                                    i,
                                    1
                            ).toString()
                    );

            double precio =
                    Double.parseDouble(
                            tablaDetalle.getValueAt(
                                    i,
                                    2
                            ).toString()
                    );

            DetalleVenta detalle =
                    new DetalleVenta(
                            0,
                            producto,
                            cantidad,
                            precio
                    );

            venta.agregarDetalle(
                    detalle
            );

            total +=
                    detalle.getSubtotal();
        }

        venta.setTotal(
                total
        );

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
    public static ArrayList<Object[]> listarVentasResumen() {

        ArrayList<Object[]> lista =
                new ArrayList<>();

        HashMap<Integer, String> estados =
                new HashMap<>();

        for (Object[] detalle
                : ventaDAO.listarVentasConDetalle()) {

            int idVenta =
                    Integer.parseInt(
                            detalle[0].toString()
                    );

            String estado =
                    detalle[8] == null
                            ? "ACTIVA"
                            : detalle[8].toString();

            estados.put(
                    idVenta,
                    estado
            );
        }

        for (Venta venta : ventaDAO.listar()) {

            String estado =
                    estados.getOrDefault(
                            venta.getIdVenta(),
                            "ACTIVA"
                    );

            lista.add(
                    new Object[]{
                        venta.getIdVenta(),
                        venta.getFecha(),
                        venta.getNombreCliente(),
                        venta.getNombreUsuario(),
                        venta.getTotal(),
                        venta.getMedioPago(),
                        estado
                    }
            );
        }

        return lista;
    }

    public static ArrayList<Object[]> buscarVentasResumen(
            String filtro
    ) {

        ArrayList<Object[]> resultados =
                new ArrayList<>();

        String texto =
                filtro == null
                        ? ""
                        : filtro.trim().toLowerCase();

        for (Object[] venta
                : listarVentasResumen()) {

            boolean coincide = false;

            for (int columna = 1;
                    columna < venta.length;
                    columna++) {

                Object valor =
                        venta[columna];

                if (valor != null
                        && valor.toString()
                                .toLowerCase()
                                .contains(texto)) {

                    coincide = true;
                    break;
                }
            }

            if (coincide) {
                resultados.add(venta);
            }
        }

        return resultados;
    }
}