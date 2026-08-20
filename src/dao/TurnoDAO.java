package dao;

import interfaces.CrudDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Turno;
import sistemaveterinaria.Conexion;

public class TurnoDAO implements CrudDAO<Turno> {
    @Override
    public void guardar(Turno turno) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            boolean editando = (turno.getIdTurno() != -1);

            if (editando) {

                String sql =
                        "UPDATE turnos SET id_animal = ?, fecha = ?, hora = ?, motivo = ? "
                        + "WHERE id = ?";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setInt(1, turno.getIdAnimal());
                pst.setString(2, turno.getFecha());
                pst.setString(3, turno.getHora());
                pst.setString(4, turno.getMotivo());
                pst.setInt(5, turno.getIdTurno());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO turnos(id_animal, fecha, hora, motivo) "
                        + "VALUES(?, ?, ?, ?)";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setInt(1, turno.getIdAnimal());
                pst.setString(2, turno.getFecha());
                pst.setString(3, turno.getHora());
                pst.setString(4, turno.getMotivo());

                pst.executeUpdate();
                pst.close();
            }

        } catch (Exception e) {

            System.out.println("Error: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Turno> listar() {

        ArrayList<Turno> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = """
                SELECT t.id,
                       c.nombre AS dueno,
                       c.dni,
                       a.id_animal AS id_animal,
                       a.nombre AS animal,
                       t.fecha,
                       t.hora,
                       t.motivo
                FROM turnos t
                JOIN animales a ON t.id_animal = a.id_animal
                JOIN clientes c ON a.id_cliente = c.id_cliente
            """;

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Turno turno = new Turno(
                        rs.getInt("id"),
                        rs.getString("dueno"),
                        rs.getString("dni"),
                        rs.getInt("id_animal"),
                        rs.getString("animal"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getString("motivo")
                );

                lista.add(turno);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println("Error al listar turnos: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    @Override
    public void eliminar(int idTurno) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = "DELETE FROM turnos WHERE id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idTurno);
            pst.executeUpdate();

            pst.close();

        } catch (Exception e) {

            System.out.println("Error al eliminar turno: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Turno> buscarTurnos(String filtro) {

        ArrayList<Turno> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = """
                SELECT t.id,
                       c.nombre AS dueno,
                       c.dni,
                       a.id_animal AS id_animal,
                       a.nombre AS animal,
                       t.fecha,
                       t.hora,
                       t.motivo
                FROM turnos t
                JOIN animales a ON t.id_animal = a.id_animal
                JOIN clientes c ON a.id_cliente = c.id_cliente
                WHERE c.dni LIKE ?
                   OR c.nombre LIKE ?
                   OR a.nombre LIKE ?
            """;

            PreparedStatement pst = conn.prepareStatement(sql);

            String valor = "%" + filtro + "%";

            pst.setString(1, valor);
            pst.setString(2, valor);
            pst.setString(3, valor);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Turno turno = new Turno(
                        rs.getInt("id"),
                        rs.getString("dueno"),
                        rs.getString("dni"),
                        rs.getInt("id_animal"),
                        rs.getString("animal"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getString("motivo")
                );

                lista.add(turno);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println("Error al buscar turnos: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    public boolean turnoOcupado(String fecha, String hora) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT COUNT(*) FROM turnos WHERE fecha = ? AND hora = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, fecha);
            pst.setString(2, hora);

            ResultSet rs = pst.executeQuery();

            boolean ocupado = false;

            if (rs.next()) {
                ocupado = rs.getInt(1) > 0;
            }

            rs.close();
            pst.close();

            return ocupado;

        } catch (Exception e) {

            System.out.println(
                    "Error al verificar turno: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public ArrayList<Turno> listarTurnosProximos() {

        ArrayList<Turno> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = """
                SELECT t.id,
                       c.nombre AS dueno,
                       c.dni,
                       a.id_animal AS id_animal,
                       a.nombre AS animal,
                       t.fecha,
                       t.hora,
                       t.motivo
                FROM turnos t
                JOIN animales a ON t.id_animal = a.id_animal
                JOIN clientes c ON a.id_cliente = c.id_cliente
                WHERE date(
                        substr(t.fecha, 7, 4) || '-' ||
                        substr(t.fecha, 4, 2) || '-' ||
                        substr(t.fecha, 1, 2)
                      ) >= date('now', 'localtime')
                  AND date(
                        substr(t.fecha, 7, 4) || '-' ||
                        substr(t.fecha, 4, 2) || '-' ||
                        substr(t.fecha, 1, 2)
                      ) <= date('now', 'localtime', '+1 day')
                ORDER BY date(
                        substr(t.fecha, 7, 4) || '-' ||
                        substr(t.fecha, 4, 2) || '-' ||
                        substr(t.fecha, 1, 2)
                      ), t.hora
            """;

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Turno turno = new Turno(
                        rs.getInt("id"),
                        rs.getString("dueno"),
                        rs.getString("dni"),
                        rs.getInt("id_animal"),
                        rs.getString("animal"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getString("motivo")
                );

                lista.add(turno);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al listar turnos próximos: " + e
            );

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}