package dao;

import interfaces.CrudDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Turno;
import sistemaveterinaria.Conexion;
import factory.EstadoTurnoFactory;
public class TurnoDAO implements CrudDAO<Turno> {
    @Override
    public void guardar(Turno turno) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            boolean editando = (turno.getIdTurno() != -1);

            if (editando) {

                String sql =
                        "UPDATE turnos SET id_animal = ?, fecha = ?, hora = ?, motivo = ?, estado = ? "
                        + "WHERE id = ?";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setInt(1, turno.getIdAnimal());
                pst.setString(2, turno.getFecha());
                pst.setString(3, turno.getHora());
                pst.setString(4, turno.getMotivo());
                pst.setString(5, turno.getEstado().getNombre());
                pst.setInt(6, turno.getIdTurno());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO turnos(id_animal, fecha, hora, motivo, estado) "
                        + "VALUES(?, ?, ?, ?, ?)";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setInt(1, turno.getIdAnimal());
                pst.setString(2, turno.getFecha());
                pst.setString(3, turno.getHora());
                pst.setString(4, turno.getMotivo());
                pst.setString(5, turno.getEstado().getNombre());
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
                       t.motivo,
                       t.estado
                FROM turnos t
                JOIN animales a ON t.id_animal = a.id_animal
                JOIN clientes c ON a.id_cliente = c.id_cliente
                WHERE t.estado <> 'VENCIDO'         
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
                        rs.getString("motivo"),
                        EstadoTurnoFactory.crearEstado(
                            rs.getString("estado")
                        )
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
                       t.motivo,
                       t.estado
                FROM turnos t
                JOIN animales a ON t.id_animal = a.id_animal
                JOIN clientes c ON a.id_cliente = c.id_cliente
                WHERE t.estado <> 'VENCIDO'
                  AND (
                       c.dni LIKE ?
                       OR c.nombre LIKE ?
                       OR a.nombre LIKE ?
                  )
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
                        rs.getString("motivo"),
                        EstadoTurnoFactory.crearEstado(
                                rs.getString("estado")
                        )
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
    
    public String obtenerEstado(int idTurno) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT estado FROM turnos WHERE id = ?";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, idTurno);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String estado = rs.getString("estado");

                rs.close();
                pst.close();

                return estado;
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al obtener estado del turno: " + e
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

        return "PENDIENTE";
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
                       t.motivo,
                       t.estado
                FROM turnos t
                JOIN animales a ON t.id_animal = a.id_animal
                JOIN clientes c ON a.id_cliente = c.id_cliente
                WHERE t.estado = 'PENDIENTE'
                  AND date(
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
                        rs.getString("motivo"),
                        EstadoTurnoFactory.crearEstado(
                                rs.getString("estado")
                        )
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

        public void cambiarEstado(int idTurno, String nuevoEstado) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "UPDATE turnos SET estado = ? WHERE id = ?";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, nuevoEstado);
            pst.setInt(2, idTurno);

            pst.executeUpdate();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al cambiar estado del turno: "
                    + e.getMessage(),
                    e
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
    }
    public Turno buscarPorId(int idTurno) {

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
                       t.motivo,
                       t.estado
                FROM turnos t
                JOIN animales a ON t.id_animal = a.id_animal
                JOIN clientes c ON a.id_cliente = c.id_cliente
                WHERE t.id = ?
            """;

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, idTurno);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Turno turno = new Turno(
                        rs.getInt("id"),
                        rs.getString("dueno"),
                        rs.getString("dni"),
                        rs.getInt("id_animal"),
                        rs.getString("animal"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getString("motivo"),
                        EstadoTurnoFactory.crearEstado(
                                rs.getString("estado")
                        )
                );

                rs.close();
                pst.close();

                return turno;
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al buscar turno: "
                    + e.getMessage(),
                    e
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

        return null;
    }

    public ArrayList<Turno> listarTurnosActivos() {

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
                       t.motivo,
                       t.estado
                FROM turnos t
                JOIN animales a
                    ON t.id_animal = a.id_animal
                JOIN clientes c
                    ON a.id_cliente = c.id_cliente
                WHERE t.estado = 'PENDIENTE'
                   OR t.estado = 'EN ATENCIÓN'
                ORDER BY date(
                    substr(t.fecha, 7, 4) || '-' ||
                    substr(t.fecha, 4, 2) || '-' ||
                    substr(t.fecha, 1, 2)
                ), t.hora
            """;

            PreparedStatement pst =
                    conn.prepareStatement(sql);

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
                        rs.getString("motivo"),
                        EstadoTurnoFactory.crearEstado(
                                rs.getString("estado")
                        )
                );

                lista.add(turno);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al listar turnos activos: "
                    + e.getMessage(),
                    e
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
    public ArrayList<Turno> listarTurnosFinalizados() {

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
                       t.motivo,
                       t.estado
                FROM turnos t
                JOIN animales a
                    ON t.id_animal = a.id_animal
                JOIN clientes c
                    ON a.id_cliente = c.id_cliente
                WHERE t.estado = 'FINALIZADO'
                ORDER BY date(
                    substr(t.fecha, 7, 4) || '-' ||
                    substr(t.fecha, 4, 2) || '-' ||
                    substr(t.fecha, 1, 2)
                ) DESC, t.hora DESC
            """;

            PreparedStatement pst =
                    conn.prepareStatement(sql);

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
                        rs.getString("motivo"),
                        EstadoTurnoFactory.crearEstado(
                                rs.getString("estado")
                        )
                );

                lista.add(turno);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al listar turnos finalizados: "
                    + e.getMessage(),
                    e
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
    public ArrayList<Turno> listarTurnosCancelados() {

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
                       t.motivo,
                       t.estado
                FROM turnos t
                JOIN animales a
                    ON t.id_animal = a.id_animal
                JOIN clientes c
                    ON a.id_cliente = c.id_cliente
                WHERE t.estado = 'CANCELADO'
                ORDER BY date(
                    substr(t.fecha, 7, 4) || '-' ||
                    substr(t.fecha, 4, 2) || '-' ||
                    substr(t.fecha, 1, 2)
                ) DESC, t.hora DESC
            """;

            PreparedStatement pst =
                    conn.prepareStatement(sql);

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
                        rs.getString("motivo"),
                        EstadoTurnoFactory.crearEstado(
                                rs.getString("estado")
                        )
                );

                lista.add(turno);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al listar turnos cancelados: "
                    + e.getMessage(),
                    e
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

    public void marcarTurnosVencidos() {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = """
                UPDATE turnos
                SET estado = 'VENCIDO'
                WHERE estado = 'PENDIENTE'
                  AND date(
                        substr(fecha, 7, 4) || '-' ||
                        substr(fecha, 4, 2) || '-' ||
                        substr(fecha, 1, 2)
                      ) < date('now', 'localtime')
            """;

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.executeUpdate();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al marcar turnos vencidos: "
                    + e.getMessage(),
                    e
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
    }
    
    public ArrayList<Turno> listarTurnosVencidos() {

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
                       t.motivo,
                       t.estado
                FROM turnos t
                JOIN animales a
                    ON t.id_animal = a.id_animal
                JOIN clientes c
                    ON a.id_cliente = c.id_cliente
                WHERE t.estado = 'VENCIDO'
                ORDER BY date(
                    substr(t.fecha, 7, 4) || '-' ||
                    substr(t.fecha, 4, 2) || '-' ||
                    substr(t.fecha, 1, 2)
                ) DESC, t.hora DESC
            """;

            PreparedStatement pst =
                    conn.prepareStatement(sql);

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
                        rs.getString("motivo"),
                        EstadoTurnoFactory.crearEstado(
                                rs.getString("estado")
                        )
                );

                lista.add(turno);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al listar turnos vencidos: "
                    + e.getMessage(),
                    e
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