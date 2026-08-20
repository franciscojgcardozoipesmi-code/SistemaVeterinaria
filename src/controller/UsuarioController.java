package controller;

import dao.UsuarioDAO;
import java.util.ArrayList;
import modelo.Usuario;
import factory.ModeloFactory;

public class UsuarioController {

    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static boolean iniciarSesion(String usuario, String password) {
        return usuarioDAO.login(usuario, password);
    }

    public static void registrarUsuario(String nombreUsuario,
                                        String password,
                                        String rol) {

        Usuario usuario = ModeloFactory.crearUsuario(
                -1,
                nombreUsuario,
                password,
                rol
        );

        usuarioDAO.guardar(usuario);
    }

    public static ArrayList<Object[]> listarUsuarios() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Usuario usuario : usuarioDAO.listar()) {

            lista.add(new Object[]{
                usuario.getIdUsuario(),
                usuario.getUsuario(),
                usuario.getPassword(),
                usuario.getRol()
            });
        }

        return lista;
    }

    public static void editarUsuario(int idUsuario,
                                     String nombreUsuario,
                                     String password,
                                     String rol) {

        Usuario usuario = ModeloFactory.crearUsuario(
                idUsuario,
                nombreUsuario,
                password,
                rol
        );

        usuarioDAO.guardar(usuario);
    }

    public static void eliminarUsuario(int idUsuario) {
        usuarioDAO.eliminar(idUsuario);
    }

    public static String obtenerRol(String usuario, String password) {
        return usuarioDAO.obtenerRol(usuario, password);
    }
}