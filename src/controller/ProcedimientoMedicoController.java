package controller;

import dao.ProcedimientoMedicoDAO;
import java.util.ArrayList;
import modelo.ProcedimientoMedico;

public class ProcedimientoMedicoController {

    private static final ProcedimientoMedicoDAO procedimientoDAO =
            new ProcedimientoMedicoDAO();

    public static ArrayList<Object[]> listarProcedimientos() {

        ArrayList<Object[]> lista =
                new ArrayList<>();

        for (ProcedimientoMedico procedimiento
                : procedimientoDAO.listar()) {

            lista.add(
                    new Object[]{
                        procedimiento.getIdProcedimiento(),
                        procedimiento.getTipo(),
                        procedimiento.isEmergencia()
                                ? "Sí"
                                : "No",
                        procedimiento.getMonto(),
                        procedimiento.getIdAnimal(),
                        procedimiento.getAnimal(),
                        procedimiento.getCliente(),
                        procedimiento.getDniCliente(),
                        procedimiento.getFecha(),
                        procedimiento.getDescripcion()
                    }
            );
        }

        return lista;
    }

    public static ArrayList<Object[]> buscarProcedimientos(
            String filtro
    ) {

        ArrayList<Object[]> lista =
                new ArrayList<>();

        for (ProcedimientoMedico procedimiento
                : procedimientoDAO.buscarProcedimientos(
                        filtro
                )) {

            lista.add(
                    new Object[]{
                        procedimiento.getIdProcedimiento(),
                        procedimiento.getTipo(),
                        procedimiento.isEmergencia()
                                ? "Sí"
                                : "No",
                        procedimiento.getMonto(),
                        procedimiento.getIdAnimal(),
                        procedimiento.getAnimal(),
                        procedimiento.getCliente(),
                        procedimiento.getDniCliente(),
                        procedimiento.getFecha(),
                        procedimiento.getDescripcion()
                    }
            );
        }

        return lista;
    }

    public static void guardarProcedimiento(
                String tipo,
                boolean emergencia,
                double monto,
                int idAnimal,
                String fecha,
                String descripcion,
                int idProcedimiento) {

        ProcedimientoMedico procedimiento =
                    new ProcedimientoMedico(
                            idProcedimiento,
                            tipo,
                            emergencia,
                            monto,
                            idAnimal,
                            fecha,
                            descripcion,
                            true
                    );

        procedimientoDAO.guardar(procedimiento);
    }

    public static void darDeBajaProcedimiento(
            int idProcedimiento
    ) {

        procedimientoDAO.eliminar(
                idProcedimiento
        );
    }
    public static ArrayList<Object[]> listarPorAnimal(int idAnimal) {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (ProcedimientoMedico procedimiento
                : procedimientoDAO.listarPorAnimal(idAnimal)) {

            lista.add(new Object[]{
                procedimiento.getFecha(),
                procedimiento.getTipo(),
                procedimiento.isEmergencia() ? "Sí" : "No",
                procedimiento.getDescripcion(),
                procedimiento.getMonto()
            });
        }

        return lista;
    }
}