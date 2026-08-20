package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    public void testSetStock() {

        Producto producto = new Producto();

        producto.setStock(10);

        assertEquals(10, producto.getStock());
    }

    @Test
    public void testSetPrecio() {

        Producto producto = new Producto();

        producto.setPrecio(2500.0);

        assertEquals(2500.0, producto.getPrecio());
    }

    @Test
    public void testSetNombre() {

        Producto producto = new Producto();

        producto.setNombre("Alimento");

        assertEquals("Alimento", producto.getNombre());
    }

    @Test
    public void testFechaVencimiento() {

        Producto producto = new Producto();

        producto.setFechaVencimiento("2026-12-31");

        assertEquals(
                "2026-12-31",
                producto.getFechaVencimiento()
        );
    }
}