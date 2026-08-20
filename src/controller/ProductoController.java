package controller;

import dao.ProductoDAO;
import java.util.ArrayList;
import modelo.Producto;
import factory.ModeloFactory;
import java.util.HashMap;

public class ProductoController {

    private static final ProductoDAO productoDAO = new ProductoDAO();

    public static ArrayList<Object[]> listarProductos() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Producto producto : productoDAO.listar()) {
            String fechaMostrar = producto.getFechaVencimiento();

            if (fechaMostrar != null && !fechaMostrar.isEmpty()) {

                java.time.LocalDate fecha =
                        java.time.LocalDate.parse(fechaMostrar);

                java.time.format.DateTimeFormatter formato =
                        java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

                fechaMostrar = fecha.format(formato);
            }
            lista.add(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                fechaMostrar
            });
        }

        return lista;
    }

    public static void guardarProducto(String nombre,
                                       double precio,
                                       int stock,
                                       String fechaVencimiento,
                                       int idProducto) {

        Producto producto = ModeloFactory.crearProducto(
                idProducto,
                nombre,
                precio,
                stock,
                fechaVencimiento
        );

        productoDAO.guardar(producto);
    }

    public static void eliminarProducto(int idProducto) {
        productoDAO.eliminar(idProducto);
    }

    public static ArrayList<String> listarNombres() {
        return productoDAO.listarNombres();
    }

    public static double obtenerPrecio(String nombre) {
        return productoDAO.obtenerPrecio(nombre);
    }

    public static HashMap<String, Double> obtenerMapaPrecios() {
        return productoDAO.obtenerMapaPrecios();
    }

    public static int obtenerStock(String nombre) {
        return productoDAO.obtenerStock(nombre);
    }

    public static String obtenerFechaVencimiento(String nombre) {
        return productoDAO.obtenerFechaVencimiento(nombre);
    }

    public static ArrayList<Object[]> listarProximosAVencer() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Producto producto : productoDAO.listarProximosAVencer()) {

            lista.add(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getStock(),
                producto.getFechaVencimiento()
            });
        }

        return lista;
    }

    public static int contarProximosAVencer() {

        return productoDAO.listarProximosAVencer().size();
    }
}