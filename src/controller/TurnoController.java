package controller;

import dao.TurnoDAO;
import java.util.ArrayList;
import modelo.Turno;
import factory.ModeloFactory;
import excepciones.TurnoOcupadoException;

public class TurnoController {

    private static final TurnoDAO turnoDAO = new TurnoDAO();

    public static ArrayList<Object[]> listarTurnos() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Turno turno : turnoDAO.listar()) {

            lista.add(new Object[]{
                turno.getIdTurno(),
                turno.getDueno(),
                turno.getDni(),
                turno.getAnimal(),
                turno.getFecha(),
                turno.getHora(),
                turno.getMotivo()
            });
        }

        return lista;
    }

    public static ArrayList<Object[]> buscarTurnos(String filtro) {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Turno turno : turnoDAO.buscarTurnos(filtro)) {

            lista.add(new Object[]{
                turno.getIdTurno(),
                turno.getDueno(),
                turno.getDni(),
                turno.getAnimal(),
                turno.getFecha(),
                turno.getHora(),
                turno.getMotivo()
            });
        }

        return lista;
    }

    public static void eliminarTurno(int idTurno) {
        turnoDAO.eliminar(idTurno);
    }

    public static void guardarTurno(String dueno,
                                String dni,
                                int idAnimal,
                                String animal,
                                String fecha,
                                String hora,
                                String motivo,
                                int idTurno)
                                throws TurnoOcupadoException {

        if (idTurno == -1 && turnoDAO.turnoOcupado(fecha, hora)) {

            throw new TurnoOcupadoException(
                    "Ya existe un turno para esa fecha y hora"
            );
        }

        Turno turno = ModeloFactory.crearTurno(
                idTurno,
                dueno,
                dni,
                idAnimal,
                animal,
                fecha,
                hora,
                motivo
        );

        turnoDAO.guardar(turno);
    }

    public static ArrayList<Object[]> listarTurnosProximos() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Turno turno : turnoDAO.listarTurnosProximos()) {

            lista.add(new Object[]{
                turno.getIdTurno(),
                turno.getDueno(),
                turno.getDni(),
                turno.getAnimal(),
                turno.getFecha(),
                turno.getHora(),
                turno.getMotivo()
            });
        }

        return lista;
    }

    public static int contarTurnosProximos() {

        return turnoDAO.listarTurnosProximos().size();
    }
}