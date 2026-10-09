package controller;

import dao.MarcaDAO;
import java.util.ArrayList;
import modelo.Marca;

public class MarcaController {

    private static final MarcaDAO marcaDAO =
            new MarcaDAO();

    public static void inicializarMarcas() {

        marcaDAO.listar();
    }

    public static ArrayList<Marca> listarMarcas() {

        return marcaDAO.listar();
    }

    public static boolean guardarMarca(
            int idMarca,
            String nombre
    ) {

        if (nombre == null
                || nombre.trim().isEmpty()) {

            return false;
        }

        Marca marca =
                new Marca(
                        idMarca,
                        nombre.trim()
                );

        return marcaDAO.guardar(
                marca
        );
    }

    public static boolean eliminarMarca(
            int idMarca
    ) {

        return marcaDAO.eliminar(
                idMarca
        );
    }

    public static boolean marcaEnUso(
            int idMarca
    ) {

        return marcaDAO.estaEnUso(
                idMarca
        );
    }
    public static boolean editarMarca(
            int idMarca,
            String nuevoNombre
    ) {

        if (nuevoNombre == null
                || nuevoNombre.trim().isEmpty()) {

            return false;
        }

        return marcaDAO.editar(
                idMarca,
                nuevoNombre.trim()
        );
    }
}