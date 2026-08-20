package excepciones;

public class ProductoVencidoException extends Exception {

    public ProductoVencidoException(String mensaje) {
        super(mensaje);
    }
}