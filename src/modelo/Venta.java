package modelo;

import java.util.ArrayList;

public class Venta {
    private String medioPago;
    private int idVenta;
    private String fecha;
    private double total;
    private int idCliente = -1;
    private String nombreCliente = "Sin cliente";
    private int idUsuario = -1;
    private String nombreUsuario = "Sin usuario";
    private ArrayList<DetalleVenta> detalles;

    public Venta() {
        detalles = new ArrayList<>();
    }

    public Venta(int idVenta, String fecha, double total, String medioPago) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.medioPago = medioPago;
        this.detalles = new ArrayList<>();
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(
            int idCliente
    ) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(
            String nombreCliente
    ) {

        if (nombreCliente == null
                || nombreCliente.trim().isEmpty()) {

            this.nombreCliente =
                    "Sin cliente";

        } else {

            this.nombreCliente =
                    nombreCliente;
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(
            int idUsuario
    ) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(
            String nombreUsuario
    ) {

        if (nombreUsuario == null
                || nombreUsuario.trim().isEmpty()) {

            this.nombreUsuario =
                    "Sin usuario";

        } else {

            this.nombreUsuario =
                    nombreUsuario;
        }
    }
}