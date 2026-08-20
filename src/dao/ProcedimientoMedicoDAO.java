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
                        + "SET tipo = ?, emergencia = ?, monto = ?, id_animal = ? "
                        + "WHERE id_procedimiento = ?";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setString(1, procedimiento.getTipo());
                pst.setBoolean(2, procedimiento.isEmergencia());
                pst.setDouble(3, procedimiento.getMonto());
                pst.setInt(4, procedimiento.getIdAnimal());
                pst.setInt(5, procedimiento.getIdProcedimiento());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO procedimientos_medicos "
                        + "(tipo, emergencia, monto, id_animal) "
                        + "VALUES (?, ?, ?, ?)";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setString(1, procedimiento.getTipo());
                pst.setBoolean(2, procedimiento.isEmergencia());
                pst.setDouble(3, procedimiento.getMonto());
                pst.setInt(4, procedimiento.getIdAnimal());

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
                    "SELECT * FROM procedimientos_medicos";

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
                                rs.getInt("id_animal")
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
                    "DELETE FROM procedimientos_medicos "
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
                    "SELECT * FROM procedimientos_medicos "
                    + "WHERE tipo LIKE ?";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(
                    1,
                    "%" + filtro + "%"
            );

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                ProcedimientoMedico procedimiento =
                        new ProcedimientoMedico(
                                rs.getInt("id_procedimiento"),
                                rs.getString("tipo"),
                                rs.getBoolean("emergencia"),
                                rs.getDouble("monto"),
                                rs.getInt("id_animal")
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
}