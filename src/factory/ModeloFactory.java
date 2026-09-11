package factory;

import modelo.Cliente;
import modelo.Producto;
import modelo.Turno;
import modelo.Venta;
import modelo.Usuario;
import interfaces.EstadoTurno;
public class ModeloFactory {

    public static Producto crearProducto(int idProducto,
                                        String nombre,
                                        double precio,
                                        int stock,
                                        String fechaVencimiento) {

            Producto producto = new Producto(
                    idProducto,
                    nombre,
                    precio,
                    stock
            );

            producto.setFechaVencimiento(fechaVencimiento);

            return producto;
    }

    public static Cliente crearCliente(int idCliente,
                                   String nombre,
                                   String dni) {

        return new Cliente(
                idCliente,
                nombre,
                dni
        );
    }
    
    public static Cliente crearCliente(
            int idCliente,
            String nombre,
            String dni,
            String telefono,
            String direccion,
            String correo,
            String observaciones
    ) {
        return new Cliente(
                idCliente,
                nombre,
                dni,
                telefono,
                direccion,
                correo,
                observaciones
        );
    }


    public static Turno crearTurno(int idTurno,
                                    String dueno,
                                    String dni,
                                    int idAnimal,
                                    String animal,
                                    String fecha,
                                    String hora,
                                    String motivo,
                                    EstadoTurno estado) {

         return new Turno(
                 idTurno,
                 dueno,
                 dni,
                 idAnimal,
                 animal,
                 fecha,
                 hora,
                 motivo,
                 estado
         );
     }
    public static Venta crearVenta(int idVenta,
                                String fecha,
                                double total,
                                String medioPago) {

        return new Venta(
                idVenta,
                fecha,
                total,
                medioPago
        );
    }

    public static Usuario crearUsuario(int idUsuario,
                                        String nombreUsuario,
                                        String password,
                                        String rol) {

        Usuario usuario = new Usuario(
                idUsuario,
                nombreUsuario,
                password
        );

        usuario.setRol(rol);

        return usuario;
    }
}
    