package modelo;

public class DetalleVenta {

    private int idProducto;
    private String producto;
    private int cantidad;
    private double precio;

    public DetalleVenta() {
    }

    public DetalleVenta(int idProducto,
                        String producto,
                        int cantidad,
                        double precio) {

        this.idProducto = idProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return cantidad * precio;
    }
}