package controller;

import dao.CatalogoAnimalDAO;
import java.util.ArrayList;

public class CatalogoAnimalController {

    private static final CatalogoAnimalDAO catalogoDAO =
            new CatalogoAnimalDAO();

    public static void inicializarCatalogo() {

        catalogoDAO.inicializarCatalogo();
    }

    public static ArrayList<String> listarEspecies() {

        return catalogoDAO.listarEspecies();
    }

    public static ArrayList<String> listarRazasPorEspecie(
            String especie
    ) {

        return catalogoDAO.listarRazasPorEspecie(
                especie
        );
    }

    public static boolean agregarEspecie(
            String nombre
    ) {

        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }

        return catalogoDAO.agregarEspecie(
                nombre.trim()
        );
    }

    public static boolean agregarRaza(
            String nombre,
            String especie
    ) {

        if (nombre == null
                || nombre.trim().isEmpty()
                || especie == null
                || especie.trim().isEmpty()) {

            return false;
        }

        return catalogoDAO.agregarRaza(
                nombre.trim(),
                especie
        );
    }
    public static boolean eliminarEspecie(
            String nombre
    ) {

        if (nombre == null
                || nombre.trim().isEmpty()) {

            return false;
        }

        return catalogoDAO.eliminarEspecie(
                nombre
        );
    }

    public static boolean eliminarRaza(
            String nombre,
            String especie
    ) {

        if (nombre == null
                || especie == null) {

            return false;
        }

        return catalogoDAO.eliminarRaza(
                nombre,
                especie
        );
    }
    public static boolean editarEspecie(
            String nombreActual,
            String nombreNuevo
    ) {

        if (nombreActual == null
                || nombreNuevo == null
                || nombreActual.trim().isEmpty()
                || nombreNuevo.trim().isEmpty()) {

            return false;
        }

        return catalogoDAO.editarEspecie(
                nombreActual.trim(),
                nombreNuevo.trim()
        );
    }

    public static boolean editarRaza(
            String nombreActual,
            String nombreNuevo,
            String especie
    ) {

        if (nombreActual == null
                || nombreNuevo == null
                || especie == null
                || nombreActual.trim().isEmpty()
                || nombreNuevo.trim().isEmpty()
                || especie.trim().isEmpty()) {

            return false;
        }

        return catalogoDAO.editarRaza(
                nombreActual.trim(),
                nombreNuevo.trim(),
                especie.trim()
        );
    }
}