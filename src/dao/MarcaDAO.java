package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Marca;
import sistemaveterinaria.Conexion;

public class MarcaDAO {

    public MarcaDAO() {
        inicializar();
    }

    private void inicializar() {

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            String crearMarcas =
                    "CREATE TABLE IF NOT EXISTS marcas ("
                    + "id_marca INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL COLLATE NOCASE UNIQUE"
                    + ")";

            try (
                    Statement st =
                            conn.createStatement()
            ) {

                st.executeUpdate(
                        crearMarcas
                );
            }

            String insertarMarcaInicial =
                    "INSERT OR IGNORE INTO marcas (nombre) "
                    + "VALUES ('Sin marca')";

            try (
                    Statement st =
                            conn.createStatement()
            ) {

                st.executeUpdate(
                        insertarMarcaInicial
                );
            }

            if (!existeColumnaMarca(conn)) {

                String agregarColumna =
                        "ALTER TABLE productos "
                        + "ADD COLUMN id_marca INTEGER";

                try (
                        Statement st =
                                conn.createStatement()
                ) {

                    st.executeUpdate(
                            agregarColumna
                    );
                }
            }

            int idSinMarca =
                    obtenerIdSinMarca(conn);

            String actualizarProductos =
                    "UPDATE productos "
                    + "SET id_marca = ? "
                    + "WHERE id_marca IS NULL";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(
                                    actualizarProductos
                            )
            ) {

                pst.setInt(
                        1,
                        idSinMarca
                );

                pst.executeUpdate();
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al inicializar marcas: "
                    + e.getMessage()
            );
        }
    }

    private boolean existeColumnaMarca(
            Connection conn
    ) throws Exception {

        String sql =
                "PRAGMA table_info(productos)";

        try (
                Statement st =
                        conn.createStatement();

                ResultSet rs =
                        st.executeQuery(sql)
        ) {

            while (rs.next()) {

                String nombreColumna =
                        rs.getString("name");

                if ("id_marca".equalsIgnoreCase(
                        nombreColumna
                )) {

                    return true;
                }
            }
        }

        return false;
    }

    private int obtenerIdSinMarca(
            Connection conn
    ) throws Exception {

        String sql =
                "SELECT id_marca "
                + "FROM marcas "
                + "WHERE nombre = 'Sin marca'";

        try (
                Statement st =
                        conn.createStatement();

                ResultSet rs =
                        st.executeQuery(sql)
        ) {

            if (rs.next()) {

                return rs.getInt(
                        "id_marca"
                );
            }
        }

        return -1;
    }

    public boolean guardar(
            Marca marca
    ) {

        String nombre =
                marca.getNombre().trim();

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            if (marca.getIdMarca() == -1) {

                String sql =
                        "INSERT INTO marcas (nombre) "
                        + "VALUES (?)";

                try (
                        PreparedStatement pst =
                                conn.prepareStatement(sql)
                ) {

                    pst.setString(
                            1,
                            nombre
                    );

                    return pst.executeUpdate() > 0;
                }

            } else {

                String sql =
                        "UPDATE marcas "
                        + "SET nombre = ? "
                        + "WHERE id_marca = ?";

                try (
                        PreparedStatement pst =
                                conn.prepareStatement(sql)
                ) {

                    pst.setString(
                            1,
                            nombre
                    );

                    pst.setInt(
                            2,
                            marca.getIdMarca()
                    );

                    return pst.executeUpdate() > 0;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al guardar marca: "
                    + e.getMessage()
            );

            return false;
        }
    }

    public ArrayList<Marca> listar() {

        ArrayList<Marca> marcas =
                new ArrayList<>();

        String sql =
                "SELECT id_marca, nombre "
                + "FROM marcas "
                + "ORDER BY nombre";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();

                Statement st =
                        conn.createStatement();

                ResultSet rs =
                        st.executeQuery(sql)
        ) {

            while (rs.next()) {

                marcas.add(
                        new Marca(
                                rs.getInt(
                                        "id_marca"
                                ),
                                rs.getString(
                                        "nombre"
                                )
                        )
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al listar marcas: "
                    + e.getMessage()
            );
        }

        return marcas;
    }

    public boolean estaEnUso(
            int idMarca
    ) {

        String sql =
                "SELECT COUNT(*) AS cantidad "
                + "FROM productos "
                + "WHERE id_marca = ?";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();

                PreparedStatement pst =
                        conn.prepareStatement(sql)
        ) {

            pst.setInt(
                    1,
                    idMarca
            );

            try (
                    ResultSet rs =
                            pst.executeQuery()
            ) {

                return rs.next()
                        && rs.getInt(
                                "cantidad"
                        ) > 0;
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al comprobar la marca: "
                    + e.getMessage()
            );

            return true;
        }
    }

    public boolean eliminar(
            int idMarca
    ) {

        if (estaEnUso(idMarca)) {
            return false;
        }

        String sql =
                "DELETE FROM marcas "
                + "WHERE id_marca = ? "
                + "AND LOWER(nombre) != LOWER('Sin marca')";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar();

                PreparedStatement pst =
                        conn.prepareStatement(sql)
        ) {

            pst.setInt(
                    1,
                    idMarca
            );

            return pst.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar marca: "
                    + e.getMessage()
            );

            return false;
        }
    }
    public boolean editar(
            int idMarca,
            String nuevoNombre
    ) {

        String sql =
                "UPDATE marcas "
                + "SET nombre = ? "
                + "WHERE id_marca = ?";

        try (
            java.sql.Connection conn =
                    sistemaveterinaria.Conexion
                            .getInstancia()
                            .conectar();

            java.sql.PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    nuevoNombre.trim()
            );

            ps.setInt(
                    2,
                    idMarca
            );

            return ps.executeUpdate() > 0;

        } catch (java.sql.SQLException e) {

            System.out.println(
                    "Error al editar la marca: "
                    + e.getMessage()
            );

            return false;
        }
    }
}