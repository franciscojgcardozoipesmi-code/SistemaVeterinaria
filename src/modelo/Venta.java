package modelo;

import java.util.ArrayList;

public class Venta {
    private String medioPago;
    private int idVenta;
    private String fecha;
    private double total;
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
}