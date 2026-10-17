package dao;

import interfaces.CrudDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.ProcedimientoMedico;
import sistemaveterinaria.Conexion;

public class ProcedimientoMedicoDAO implements CrudDAO<ProcedimientoMedico> {
    @Override
    public void guardar(ProcedimientoMedico procedimiento) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            boolean editando =
                    (procedimiento.getIdProcedimiento() != -1);

            if (editando) {

                String sql =
                        "UPDATE procedimientos_medicos "
                        + "SET tipo = ?, emergencia = ?, monto = ?, id_animal = ?, fecha = ?, descripcion = ? "
                        + "WHERE id_procedimiento = ?";
                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setString(1, procedimiento.getTipo());
                pst.setBoolean(2, procedimiento.isEmergencia());
                pst.setDouble(3, procedimiento.getMonto());
                pst.setInt(4, procedimiento.getIdAnimal());
                pst.setString(5, procedimiento.getFecha());
                pst.setString(6, procedimiento.getDescripcion());
                pst.setInt(7, procedimiento.getIdProcedimiento());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO procedimientos_medicos "
                        + "(tipo, emergencia, monto, id_animal, fecha, descripcion, activo) "
                        + "VALUES (?, ?, ?, ?, ?, ?, 1)";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setString(1, procedimiento.getTipo());
                pst.setBoolean(2, procedimiento.isEmergencia());
                pst.setDouble(3, procedimiento.getMonto());
                pst.setInt(4, procedimiento.getIdAnimal());
                pst.setString(5, procedimiento.getFecha());
                pst.setString(6, procedimiento.getDescripcion());
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
    public ArrayList<ProcedimientoMedico> listar() {

        ArrayList<ProcedimientoMedico> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT p.*, "
                    + "a.nombre AS animal, "
                    + "c.nombre AS cliente, "
                    + "c.dni AS dni_cliente "
                    + "FROM procedimientos_medicos p "
                    + "JOIN animales a "
                    + "ON p.id_animal = a.id_animal "
                    + "JOIN clientes c "
                    + "ON a.id_cliente = c.id_cliente "
                    + "WHERE p.activo = 1";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ProcedimientoMedico procedimiento =
                        new ProcedimientoMedico(
                                rs.getInt("id_procedimiento"),
                                rs.getString("tipo"),
                                rs.getBoolean("emergencia"),
                                rs.getDouble("monto"),
                                rs.getInt("id_animal"),
                                rs.getString("fecha"),
                                rs.getString("descripcion"),
                                rs.getBoolean("activo")
                        );
                procedimiento.setAnimal(
                        rs.getString("animal")
                );
                procedimiento.setCliente(
                        rs.getString("cliente")
                );

                procedimiento.setDniCliente(
                        rs.getString("dni_cliente")
                );
                lista.add(procedimiento);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al listar procedimientos: " + e
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

    @Override
    public void eliminar(int idProcedimiento) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "UPDATE procedimientos_medicos "
                    + "SET activo = 0 "
                    + "WHERE id_procedimiento = ?";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, idProcedimiento);

            pst.executeUpdate();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar procedimiento: " + e
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

    public ArrayList<ProcedimientoMedico> buscarProcedimientos(
            String filtro) {

        ArrayList<ProcedimientoMedico> lista =
                new ArrayList<>();

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT p.*, "
                    + "a.nombre AS animal, "
                    + "c.nombre AS cliente, "
                    + "c.dni AS dni_cliente "
                    + "FROM procedimientos_medicos p "
                    + "JOIN animales a "
                    + "ON p.id_animal = a.id_animal "
                    + "JOIN clientes c "
                    + "ON a.id_cliente = c.id_cliente "
                    + "WHERE p.activo = 1 "
                    + "AND ("
                    + "p.tipo LIKE ? "
                    + "OR a.nombre LIKE ? "
                    + "OR c.nombre LIKE ? "
                    + "OR c.dni LIKE ? "
                    + "OR p.fecha LIKE ?"
                    + ")";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            String valor = "%" + filtro + "%";

                pst.setString(1, valor);
                pst.setString(2, valor);
                pst.setString(3, valor);
                pst.setString(4, valor);
                pst.setString(5, valor);        

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                ProcedimientoMedico procedimiento =
                        new ProcedimientoMedico(
                                rs.getInt("id_procedimiento"),
                                rs.getString("tipo"),
                                rs.getBoolean("emergencia"),
                                rs.getDouble("monto"),
                                rs.getInt("id_animal"),
                                rs.getString("fecha"),
                                rs.getString("descripcion"),
                                rs.getBoolean("activo")
                        );
                        procedimiento.setAnimal(
                                rs.getString("animal")
                        );
                        procedimiento.setCliente(
                                rs.getString("cliente")
                        );

                        procedimiento.setDniCliente(
                                rs.getString("dni_cliente")
                        );    
                lista.add(procedimiento);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al buscar procedimientos: " + e
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
    public ArrayList<ProcedimientoMedico> listarPorAnimal(int idAnimal) {

        ArrayList<ProcedimientoMedico> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT p.*, a.nombre AS animal "
                    + "FROM procedimientos_medicos p "
                    + "JOIN animales a ON p.id_animal = a.id_animal "
                    + "WHERE p.id_animal = ? "
                    + "ORDER BY date("
                    + "substr(p.fecha, 7, 4) || '-' || "
                    + "substr(p.fecha, 4, 2) || '-' || "
                    + "substr(p.fecha, 1, 2)"
                    + ") DESC";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, idAnimal);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ProcedimientoMedico procedimiento =
                        new ProcedimientoMedico(
                                rs.getInt("id_procedimiento"),
                                rs.getString("tipo"),
                                rs.getBoolean("emergencia"),
                                rs.getDouble("monto"),
                                rs.getInt("id_animal"),
                                rs.getString("fecha"),
                                rs.getString("descripcion"),
                                rs.getBoolean("activo")
                        );

                procedimiento.setAnimal(
                        rs.getString("animal")
                );

                lista.add(procedimiento);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al listar historial médico: "
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