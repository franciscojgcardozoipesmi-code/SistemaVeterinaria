package controller;

import dao.TipoProcedimientoDAO;
import java.util.ArrayList;

public class TipoProcedimientoController {

    private static final TipoProcedimientoDAO tipoDAO =
            new TipoProcedimientoDAO();

    public static void inicializarCatalogo() {

        tipoDAO.inicializarCatalogo();
    }

    public static ArrayList<String> listarTipos() {

        return tipoDAO.listarTipos();
    }

    public static boolean agregarTipo(
            String nombre
    ) {

        if (nombre == null
                || nombre.trim().isEmpty()) {

            return false;
        }

        return tipoDAO.agregarTipo(
                nombre.trim()
        );
    }

    public static boolean eliminarTipo(
            String nombre
    ) {

        if (nombre == null
                || nombre.trim().isEmpty()) {

            return false;
        }

        return tipoDAO.eliminarTipo(
                nombre.trim()
        );
    }

    public static boolean editarTipo(
            String nombreActual,
            String nombreNuevo
    ) {

        if (nombreActual == null
                || nombreNuevo == null
                || nombreActual.trim().isEmpty()
                || nombreNuevo.trim().isEmpty()) {

            return false;
        }

        return tipoDAO.editarTipo(
                nombreActual.trim(),
                nombreNuevo.trim()
        );
    }
}