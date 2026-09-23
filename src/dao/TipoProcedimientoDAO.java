package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sistemaveterinaria.Conexion;

public class TipoProcedimientoDAO {

    public void inicializarCatalogo() {

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();
                Statement st =
                        conn.createStatement()
        ) {

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS tipos_procedimiento ("
                    + "id_tipo INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL COLLATE NOCASE UNIQUE, "
                    + "activo INTEGER NOT NULL DEFAULT 1)"
            );

            st.executeUpdate(
                    "INSERT OR IGNORE INTO tipos_procedimiento(nombre) "
                    + "SELECT DISTINCT TRIM(tipo) "
                    + "FROM procedimientos_medicos "
                    + "WHERE tipo IS NOT NULL "
                    + "AND TRIM(tipo) <> ''"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error al inicializar tipos de procedimiento: "
                    + e
            );
        }
    }

    public ArrayList<String> listarTipos() {

        ArrayList<String> lista =
                new ArrayList<>();

        String sql =
                "SELECT nombre "
                + "FROM tipos_procedimiento "
                + "WHERE activo = 1 "
                + "ORDER BY nombre";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();
                PreparedStatement pst =
                        conn.prepareStatement(sql);
                ResultSet rs =
                        pst.executeQuery()
        ) {

            while (rs.next()) {

                lista.add(
                        rs.getString("nombre")
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al listar tipos de procedimiento: "
                    + e
            );
        }

        return lista;
    }

    public boolean agregarTipo(
            String nombre
    ) {

        String reactivar =
                "UPDATE tipos_procedimiento "
                + "SET activo = 1 "
                + "WHERE nombre = ? "
                + "AND activo = 0";

        String insertar =
                "INSERT INTO tipos_procedimiento(nombre) "
                + "VALUES(?)";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(reactivar)
            ) {

                pst.setString(
                        1,
                        nombre.trim()
                );

                if (pst.executeUpdate() > 0) {
                    return true;
                }
            }

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(insertar)
            ) {

                pst.setString(
                        1,
                        nombre.trim()
                );

                pst.executeUpdate();

                return true;
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al agregar tipo de procedimiento: "
                    + e
            );

            return false;
        }
    }
    public boolean eliminarTipo(
            String nombre
    ) {

        String sql =
                "UPDATE tipos_procedimiento "
                + "SET activo = 0 "
                + "WHERE nombre = ? "
                + "AND activo = 1";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();
                PreparedStatement pst =
                        conn.prepareStatement(sql)
        ) {

            pst.setString(1, nombre);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar tipo de procedimiento: "
                    + e
            );

            return false;
        }
    }
    public boolean editarTipo(
            String nombreActual,
            String nombreNuevo
    ) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            conn.setAutoCommit(false);

            String verificar =
                    "SELECT COUNT(*) "
                    + "FROM tipos_procedimiento "
                    + "WHERE nombre = ? COLLATE NOCASE "
                    + "AND nombre <> ? COLLATE NOCASE "
                    + "AND activo = 1";

            PreparedStatement pstVerificar =
                    conn.prepareStatement(verificar);

            pstVerificar.setString(
                    1,
                    nombreNuevo
            );

            pstVerificar.setString(
                    2,
                    nombreActual
            );

            ResultSet rs =
                    pstVerificar.executeQuery();

            boolean nombreRepetido =
                    rs.next()
                    && rs.getInt(1) > 0;

            rs.close();
            pstVerificar.close();

            if (nombreRepetido) {

                conn.rollback();

                return false;
            }

            String actualizarCatalogo =
                    "UPDATE tipos_procedimiento "
                    + "SET nombre = ? "
                    + "WHERE nombre = ? COLLATE NOCASE "
                    + "AND activo = 1";

            PreparedStatement pstCatalogo =
                    conn.prepareStatement(
                            actualizarCatalogo
                    );

            pstCatalogo.setString(
                    1,
                    nombreNuevo
            );

            pstCatalogo.setString(
                    2,
                    nombreActual
            );

            int filasActualizadas =
                    pstCatalogo.executeUpdate();

            pstCatalogo.close();

            if (filasActualizadas == 0) {

                conn.rollback();

                return false;
            }

            String actualizarProcedimientos =
                    "UPDATE procedimientos_medicos "
                    + "SET tipo = ? "
                    + "WHERE tipo = ? COLLATE NOCASE";

            PreparedStatement pstProcedimientos =
                    conn.prepareStatement(
                            actualizarProcedimientos
                    );

            pstProcedimientos.setString(
                    1,
                    nombreNuevo
            );

            pstProcedimientos.setString(
                    2,
                    nombreActual
            );

            pstProcedimientos.executeUpdate();
            pstProcedimientos.close();

            conn.commit();

            return true;

        } catch (Exception e) {

            try {

                if (conn != null) {
                    conn.rollback();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println(
                    "Error al editar tipo: " + e
            );

            return false;

        } finally {

            try {

                if (conn != null) {

                    conn.setAutoCommit(true);
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}