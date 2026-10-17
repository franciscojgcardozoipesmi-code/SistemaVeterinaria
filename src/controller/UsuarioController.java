package controller;

import dao.UsuarioDAO;
import java.util.ArrayList;
import modelo.Usuario;
import factory.ModeloFactory;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import servicios.CorreoServicio;

public class UsuarioController {

    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static boolean iniciarSesion(String usuario, String password) {
        return usuarioDAO.login(usuario, password);
    }

    public static void registrarUsuario(String nombreUsuario,
                                        String password,
                                        String rol,
                                        String correo) {

        Usuario usuario = ModeloFactory.crearUsuario(
                -1,
                nombreUsuario,
                password,
                rol
        );

        usuario.setCorreo(correo);

        usuarioDAO.guardar(usuario);
    }

    public static ArrayList<Object[]> listarUsuarios() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Usuario usuario : usuarioDAO.listar()) {

            lista.add(new Object[]{
                usuario.getIdUsuario(),
                usuario.getUsuario(),
                usuario.getPassword(),
                usuario.getRol(),
                usuario.getCorreo()
            });
        }

        return lista;
    }
    
    public static ArrayList<Object[]> buscarUsuarios(
            String filtro
    ) {
        ArrayList<Object[]> lista =
                new ArrayList<>();

        for (Usuario usuario
                : usuarioDAO.buscarUsuarios(filtro)) {

            lista.add(
                    new Object[]{
                        usuario.getIdUsuario(),
                        usuario.getUsuario(),
                        usuario.getPassword(),
                        usuario.getRol(),
                        usuario.getCorreo()
                    }
            );
        }

        return lista;
    }

    public static void editarUsuario(int idUsuario,
                                    String nombreUsuario,
                                    String password,
                                    String rol,
                                    String correo) {

       Usuario usuario = ModeloFactory.crearUsuario(
               idUsuario,
               nombreUsuario,
               password,
               rol
       );

       usuario.setCorreo(correo);

       usuarioDAO.guardar(usuario);
    }
    
    public static void registrarUsuario(String nombreUsuario,
                                        String password,
                                        String rol) {

        registrarUsuario(
                nombreUsuario,
                password,
                rol,
                null
        );
    }
    
    public static void editarUsuario(int idUsuario,
                                    String nombreUsuario,
                                    String password,
                                    String rol) {

       editarUsuario(
               idUsuario,
               nombreUsuario,
               password,
               rol,
               null
       );
   }

    public static void eliminarUsuario(int idUsuario) {
        usuarioDAO.eliminar(idUsuario);
    }

    public static String obtenerRol(String usuario, String password) {
        return usuarioDAO.obtenerRol(usuario, password);
    }
    private static String protegerCodigo(
            String codigo
    ) {

        try {

            MessageDigest digest =
                    MessageDigest.getInstance("SHA-256");

            byte[] resultado =
                    digest.digest(
                            codigo.getBytes(
                                    StandardCharsets.UTF_8
                            )
                    );

            StringBuilder texto =
                    new StringBuilder();

            for (byte valor : resultado) {
                texto.append(
                        String.format(
                                "%02x",
                                valor
                        )
                );
            }

            return texto.toString();

        } catch (Exception e) {

            throw new RuntimeException(
                    "No se pudo proteger el código",
                    e
            );
        }
    }
    public static String generarCodigoRecuperacion(
            String correo
    ) {

        if (correo == null
                || correo.trim().isEmpty()
                || !usuarioDAO.existeCorreo(correo)) {

            return null;
        }

        SecureRandom generador =
                new SecureRandom();

        String codigo =
                String.valueOf(
                        100000
                        + generador.nextInt(900000)
                );

        String codigoProtegido =
                protegerCodigo(codigo);

        String vencimiento =
                LocalDateTime.now()
                        .plusMinutes(10)
                        .toString();

        boolean guardado =
                usuarioDAO.guardarCodigoRecuperacion(
                        correo,
                        codigoProtegido,
                        vencimiento
                );

        if (!guardado) {
            return null;
        }

        return codigo;
    }
    public static boolean validarCodigoRecuperacion(
            String correo,
            String codigo
    ) {

        if (correo == null
                || codigo == null
                || codigo.trim().isEmpty()) {

            return false;
        }

        String[] datos =
                usuarioDAO.obtenerDatosRecuperacion(
                        correo
                );

        if (datos == null
                || datos[0] == null
                || datos[1] == null) {

            return false;
        }

        try {

            LocalDateTime vencimiento =
                    LocalDateTime.parse(
                            datos[1]
                    );

            if (LocalDateTime.now()
                    .isAfter(vencimiento)) {

                return false;
            }

            String codigoIngresadoProtegido =
                    protegerCodigo(
                            codigo.trim()
                    );

            return MessageDigest.isEqual(
                    codigoIngresadoProtegido.getBytes(
                            StandardCharsets.UTF_8
                    ),
                    datos[0].getBytes(
                            StandardCharsets.UTF_8
                    )
            );

        } catch (Exception e) {

            return false;
        }
    }
    public static boolean restablecerPassword(
            String correo,
            String codigo,
            String nuevaPassword
    ) {

        if (nuevaPassword == null
                || nuevaPassword.trim().length() < 6) {

            return false;
        }

        boolean codigoValido =
                validarCodigoRecuperacion(
                        correo,
                        codigo
                );

        if (!codigoValido) {
            return false;
        }

        return usuarioDAO.cambiarPasswordPorCorreo(
                correo,
                nuevaPassword.trim()
        );
    }
    public static boolean enviarCodigoRecuperacion(
            String correo
    ) {

        String codigo =
                generarCodigoRecuperacion(
                        correo
                );

        if (codigo == null) {
            return false;
        }

        try {

            CorreoServicio.enviarCodigoRecuperacion(
                    correo,
                    codigo
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error al enviar el correo: "
                    + e.getMessage()
            );

            return false;
        }
    }
    

        public static Usuario obtenerUsuarioPorNombre(
                String nombreUsuario
        ) {

            if (nombreUsuario == null
                    || nombreUsuario.trim().isEmpty()) {

                return null;
            }

            return usuarioDAO.buscarPorNombreUsuario(
                    nombreUsuario
            );
        }
        
    public static ArrayList<Object[]> listarUsuariosInactivos() {

        ArrayList<Object[]> lista =
                new ArrayList<>();

        for (Usuario usuario
                : usuarioDAO.listarInactivos()) {

            lista.add(
                    new Object[]{
                        usuario.getIdUsuario(),
                        usuario.getUsuario(),
                        usuario.getPassword(),
                        usuario.getRol(),
                        usuario.getCorreo()
                    }
            );
        }

        return lista;
    }

    public static void reactivarUsuario(
            int idUsuario
    ) {

        usuarioDAO.reactivar(
                idUsuario
        );
    }
}