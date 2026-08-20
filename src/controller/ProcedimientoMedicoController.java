package controller;

import dao.ProcedimientoMedicoDAO;
import java.util.ArrayList;
import modelo.ProcedimientoMedico;

public class ProcedimientoMedicoController {

    private static final ProcedimientoMedicoDAO procedimientoDAO =
            new ProcedimientoMedicoDAO();

    public static ArrayList<Object[]> listarProcedimientos() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (ProcedimientoMedico procedimiento : procedimientoDAO.listar()) {

            lista.add(new Object[]{
                procedimiento.getIdProcedimiento(),
                procedimiento.getTipo(),
                procedimiento.isEmergencia(),
                procedimiento.getMonto(),
                procedimiento.getIdAnimal()
            });
        }

        return lista;
    }

    public static ArrayList<Object[]> buscarProcedimientos(
            String filtro) {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (ProcedimientoMedico procedimiento
                : procedimientoDAO.buscarProcedimientos(filtro)) {

            lista.add(new Object[]{
                procedimiento.getIdProcedimiento(),
                procedimiento.getTipo(),
                procedimiento.isEmergencia(),
                procedimiento.getMonto(),
                procedimiento.getIdAnimal()
            });
        }

        return lista;
    }

    public static void guardarProcedimiento(
            String tipo,
            boolean emergencia,
            double monto,
            int idAnimal,
            int idProcedimiento) {

        ProcedimientoMedico procedimiento =
                new ProcedimientoMedico(
                        idProcedimiento,
                        tipo,
                        emergencia,
                        monto,
                        idAnimal
                );

        procedimientoDAO.guardar(procedimiento);
    }

    public static void eliminarProcedimiento(
            int idProcedimiento) {

        procedimientoDAO.eliminar(idProcedimiento);
    }
}