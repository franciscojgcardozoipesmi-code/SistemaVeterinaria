package modelo;

public class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;
    private String fechaVencimiento;
    private int idMarca = -1;
    private String nombreMarca = "Sin marca";

    public Producto() {
    }

    public Producto(
            int idProducto,
            String nombre,
            double precio,
            int stock
    ) {

        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(
            int idProducto,
            String nombre,
            double precio,
            int stock,
            int idMarca,
            String nombreMarca
    ) {

        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(
            int idProducto
    ) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(
            String nombre
    ) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(
            double precio
    ) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(
            int stock
    ) {
        this.stock = stock;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(
            String fechaVencimiento
    ) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(
            int idMarca
    ) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(
            String nombreMarca
    ) {

        if (nombreMarca == null
                || nombreMarca.trim().isEmpty()) {

            this.nombreMarca =
                    "Sin marca";

        } else {

            this.nombreMarca =
                    nombreMarca;
        }
    }
}