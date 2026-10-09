package controller;

import dao.TurnoDAO;
import java.util.ArrayList;
import modelo.Turno;
import factory.ModeloFactory;
import excepciones.TurnoOcupadoException;
import interfaces.EstadoTurno;
import estado.EstadoPendiente;
import factory.EstadoTurnoFactory;
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
                turno.getMotivo(),
                turno.getEstado().getNombre()
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
                turno.getMotivo(),
                turno.getEstado().getNombre()
            });
        }

        return lista;
    }

    public static void eliminarTurno(
            int idTurno
    ) {

        Turno turno =
                turnoDAO.buscarPorId(
                        idTurno
                );

        if (turno == null) {

            throw new RuntimeException(
                    "No se encontró el turno"
            );
        }

        String detalle =
                "Turno N.º "
                + idTurno
                + " | Animal: "
                + turno.getAnimal()
                + " | Dueño: "
                + turno.getDueno()
                + " | Fecha: "
                + turno.getFecha()
                + " | Hora: "
                + turno.getHora()
                + " | Estado: "
                + turno.getEstado().getNombre();

        turnoDAO.eliminar(
                idTurno
        );

        AuditoriaController.registrar(
                "TURNOS",
                "ELIMINAR TURNO",
                detalle
        );
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
        
        EstadoTurno estado = new EstadoPendiente();

        if (idTurno != -1) {
            estado = EstadoTurnoFactory.crearEstado(
                    turnoDAO.obtenerEstado(idTurno)
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
                motivo,
                estado
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
                turno.getMotivo(),
                turno.getEstado().getNombre()
            });
        }

        return lista;
    }

    public static int contarTurnosProximos() {

        return turnoDAO.listarTurnosProximos().size();
    }

    public static void cambiarEstado(
            int idTurno,
            String nuevoEstado) {

        Turno turno = turnoDAO.buscarPorId(idTurno);

        if (turno == null) {
            throw new RuntimeException(
                    "No se encontró el turno"
            );
        }

        EstadoTurno estado =
                EstadoTurnoFactory.crearEstado(nuevoEstado);

        turno.cambiarEstado(estado);

        turnoDAO.cambiarEstado(
                idTurno,
                turno.getEstado().getNombre()
        );
    }
    public static ArrayList<Object[]> listarTurnosActivos() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Turno turno : turnoDAO.listarTurnosActivos()) {

            lista.add(new Object[]{
                turno.getIdTurno(),
                turno.getDueno(),
                turno.getDni(),
                turno.getAnimal(),
                turno.getFecha(),
                turno.getHora(),
                turno.getMotivo(),
                turno.getEstado().getNombre()
            });
        }

        return lista;
    }
    public static ArrayList<Object[]> listarTurnosFinalizados() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Turno turno : turnoDAO.listarTurnosFinalizados()) {

            lista.add(new Object[]{
                turno.getIdTurno(),
                turno.getDueno(),
                turno.getDni(),
                turno.getAnimal(),
                turno.getFecha(),
                turno.getHora(),
                turno.getMotivo(),
                turno.getEstado().getNombre()
            });
        }

        return lista;
    }
    public static ArrayList<Object[]> listarTurnosCancelados() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Turno turno : turnoDAO.listarTurnosCancelados()) {

            lista.add(new Object[]{
                turno.getIdTurno(),
                turno.getDueno(),
                turno.getDni(),
                turno.getAnimal(),
                turno.getFecha(),
                turno.getHora(),
                turno.getMotivo(),
                turno.getEstado().getNombre()
            });
        }

        return lista;
    }

    public static void marcarTurnosVencidos() {
        turnoDAO.marcarTurnosVencidos();
    }
    public static ArrayList<Object[]> listarTurnosVencidos() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Turno turno : turnoDAO.listarTurnosVencidos()) {

            lista.add(new Object[]{
                turno.getIdTurno(),
                turno.getDueno(),
                turno.getDni(),
                turno.getAnimal(),
                turno.getFecha(),
                turno.getHora(),
                turno.getMotivo(),
                turno.getEstado().getNombre()
            });
        }

        return lista;
    }
}