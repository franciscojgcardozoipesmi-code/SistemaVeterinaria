package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sistemaveterinaria.Conexion;

public class CatalogoAnimalDAO {

    public void inicializarCatalogo() {

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();
                Statement st =
                        conn.createStatement()
        ) {

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS especies ("
                    + "id_especie INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL COLLATE NOCASE UNIQUE, "
                    + "activo INTEGER NOT NULL DEFAULT 1)"
            );

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS razas ("
                    + "id_raza INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL COLLATE NOCASE, "
                    + "id_especie INTEGER NOT NULL, "
                    + "activo INTEGER NOT NULL DEFAULT 1, "
                    + "UNIQUE(nombre, id_especie), "
                    + "FOREIGN KEY(id_especie) "
                    + "REFERENCES especies(id_especie))"
            );

            st.executeUpdate(
                    "INSERT OR IGNORE INTO especies(nombre) "
                    + "SELECT DISTINCT TRIM(especie) "
                    + "FROM animales "
                    + "WHERE especie IS NOT NULL "
                    + "AND TRIM(especie) <> ''"
            );

            st.executeUpdate(
                    "INSERT OR IGNORE INTO razas(nombre, id_especie) "
                    + "SELECT DISTINCT TRIM(a.raza), e.id_especie "
                    + "FROM animales a "
                    + "INNER JOIN especies e "
                    + "ON LOWER(e.nombre) = LOWER(TRIM(a.especie)) "
                    + "WHERE a.raza IS NOT NULL "
                    + "AND TRIM(a.raza) <> ''"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error al inicializar el catálogo: " + e
            );
        }
    }

    public ArrayList<String> listarEspecies() {

        ArrayList<String> lista = new ArrayList<>();

        String sql =
                "SELECT nombre FROM especies "
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
                lista.add(rs.getString("nombre"));
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al listar especies: " + e
            );
        }

        return lista;
    }

    public ArrayList<String> listarRazasPorEspecie(
            String especie
    ) {

        ArrayList<String> lista = new ArrayList<>();

        String sql =
                "SELECT r.nombre "
                + "FROM razas r "
                + "INNER JOIN especies e "
                + "ON e.id_especie = r.id_especie "
                + "WHERE e.nombre = ? "
                + "AND e.activo = 1 "
                + "AND r.activo = 1 "
                + "ORDER BY r.nombre";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();
                PreparedStatement pst =
                        conn.prepareStatement(sql)
        ) {

            pst.setString(1, especie);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    lista.add(rs.getString("nombre"));
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al listar razas: " + e
            );
        }

        return lista;
    }

    public boolean agregarEspecie(
            String nombre
    ) {

        String reactivar =
                "UPDATE especies "
                + "SET activo = 1 "
                + "WHERE nombre = ? "
                + "AND activo = 0";

        String insertar =
                "INSERT INTO especies(nombre) "
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
                    "Error al agregar especie: " + e
            );

            return false;
        }
    }

   public boolean agregarRaza(
            String nombre,
            String especie
    ) {

        String reactivar =
                "UPDATE razas "
                + "SET activo = 1 "
                + "WHERE nombre = ? "
                + "AND id_especie = ("
                + "SELECT id_especie "
                + "FROM especies "
                + "WHERE nombre = ?"
                + ") "
                + "AND activo = 0";

        String insertar =
                "INSERT INTO razas(nombre, id_especie) "
                + "SELECT ?, id_especie "
                + "FROM especies "
                + "WHERE nombre = ? "
                + "AND activo = 1";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(reactivar)
            ) {

                pst.setString(1, nombre.trim());
                pst.setString(2, especie);

                if (pst.executeUpdate() > 0) {
                    return true;
                }
            }

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(insertar)
            ) {

                pst.setString(1, nombre.trim());
                pst.setString(2, especie);

                return pst.executeUpdate() > 0;
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al agregar raza: " + e
            );

            return false;
        }
    }
    public boolean eliminarEspecie(
            String nombre
    ) {

        String sql =
                "UPDATE especies "
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
                    "Error al eliminar especie: " + e
            );

            return false;
        }
    }

    public boolean eliminarRaza(
            String nombre,
            String especie
    ) {

        String sql =
                "UPDATE razas "
                + "SET activo = 0 "
                + "WHERE nombre = ? "
                + "AND id_especie = ("
                + "SELECT id_especie "
                + "FROM especies "
                + "WHERE nombre = ?"
                + ") "
                + "AND activo = 1";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();
                PreparedStatement pst =
                        conn.prepareStatement(sql)
        ) {

            pst.setString(1, nombre);
            pst.setString(2, especie);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar raza: " + e
            );

            return false;
        }
    }
    public boolean editarEspecie(
            String nombreActual,
            String nombreNuevo
    ) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            conn.setAutoCommit(false);

            String verificar =
                    "SELECT COUNT(*) "
                    + "FROM especies "
                    + "WHERE nombre = ? COLLATE NOCASE "
                    + "AND nombre <> ? COLLATE NOCASE";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(verificar)
            ) {

                pst.setString(1, nombreNuevo);
                pst.setString(2, nombreActual);

                try (ResultSet rs = pst.executeQuery()) {

                    if (rs.next()
                            && rs.getInt(1) > 0) {

                        conn.rollback();

                        return false;
                    }
                }
            }

            String actualizarCatalogo =
                    "UPDATE especies "
                    + "SET nombre = ? "
                    + "WHERE nombre = ? COLLATE NOCASE "
                    + "AND activo = 1";

            int filasActualizadas;

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(
                                    actualizarCatalogo
                            )
            ) {

                pst.setString(1, nombreNuevo);
                pst.setString(2, nombreActual);

                filasActualizadas =
                        pst.executeUpdate();
            }

            if (filasActualizadas == 0) {

                conn.rollback();

                return false;
            }

            String actualizarAnimales =
                    "UPDATE animales "
                    + "SET especie = ? "
                    + "WHERE especie = ? COLLATE NOCASE";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(
                                    actualizarAnimales
                            )
            ) {

                pst.setString(1, nombreNuevo);
                pst.setString(2, nombreActual);

                pst.executeUpdate();
            }

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
                    "Error al editar especie: " + e
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
    public boolean editarRaza(
            String nombreActual,
            String nombreNuevo,
            String especie
    ) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();
            conn.setAutoCommit(false);

            String verificar =
                    "SELECT COUNT(*) "
                    + "FROM razas "
                    + "WHERE nombre = ? COLLATE NOCASE "
                    + "AND nombre <> ? COLLATE NOCASE "
                    + "AND id_especie = ("
                    + "SELECT id_especie "
                    + "FROM especies "
                    + "WHERE nombre = ? COLLATE NOCASE"
                    + ")";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(verificar)
            ) {

                pst.setString(1, nombreNuevo);
                pst.setString(2, nombreActual);
                pst.setString(3, especie);

                try (ResultSet rs = pst.executeQuery()) {

                    if (rs.next()
                            && rs.getInt(1) > 0) {

                        conn.rollback();

                        return false;
                    }
                }
            }

            String actualizarCatalogo =
                    "UPDATE razas "
                    + "SET nombre = ? "
                    + "WHERE nombre = ? COLLATE NOCASE "
                    + "AND id_especie = ("
                    + "SELECT id_especie "
                    + "FROM especies "
                    + "WHERE nombre = ? COLLATE NOCASE"
                    + ") "
                    + "AND activo = 1";

            int filasActualizadas;

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(
                                    actualizarCatalogo
                            )
            ) {

                pst.setString(1, nombreNuevo);
                pst.setString(2, nombreActual);
                pst.setString(3, especie);

                filasActualizadas =
                        pst.executeUpdate();
            }

            if (filasActualizadas == 0) {

                conn.rollback();

                return false;
            }

            String actualizarAnimales =
                    "UPDATE animales "
                    + "SET raza = ? "
                    + "WHERE raza = ? COLLATE NOCASE "
                    + "AND especie = ? COLLATE NOCASE";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(
                                    actualizarAnimales
                            )
            ) {

                pst.setString(1, nombreNuevo);
                pst.setString(2, nombreActual);
                pst.setString(3, especie);

                pst.executeUpdate();
            }

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
                    "Error al editar raza: " + e
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