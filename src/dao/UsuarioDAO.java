package dao;

import interfaces.CrudDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Usuario;
import sistemaveterinaria.Conexion;

public class UsuarioDAO implements CrudDAO<Usuario> {

    @Override
    public void guardar(Usuario usuario) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            boolean editando = (usuario.getIdUsuario() != -1);

            if (editando) {

                String sql =
                        "UPDATE usuarios SET usuario = ?, password = ?, rol = ? WHERE id_usuario = ?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, usuario.getUsuario());
                pst.setString(2, usuario.getPassword());
                pst.setString(3, usuario.getRol());
                pst.setInt(4, usuario.getIdUsuario());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO usuarios (usuario, password, rol) VALUES (?, ?, ?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, usuario.getUsuario());
                pst.setString(2, usuario.getPassword());
                pst.setString(3, usuario.getRol());

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
    public ArrayList<Usuario> listar() {

        ArrayList<Usuario> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = "SELECT * FROM usuarios";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("usuario"),
                        rs.getString("password")
                );
                
                usuario.setRol(
                        rs.getString("rol")
                );

                lista.add(usuario);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println("Error al listar usuarios: " + e);

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
    public ArrayList<Usuario> buscarUsuarios(
            String filtro
    ) {
        ArrayList<Usuario> lista =
                new ArrayList<>();

        Connection conn = null;

        try {

            conn =
                    Conexion.getInstancia().conectar();

            String sql =
                    "SELECT * FROM usuarios "
                    + "WHERE CAST(id_usuario AS TEXT) LIKE ? "
                    + "OR LOWER(usuario) LIKE LOWER(?) "
                    + "OR LOWER(rol) LIKE LOWER(?) "
                    + "ORDER BY usuario";

            PreparedStatement pst =
                    conn.prepareStatement(
                            sql
                    );

            String busqueda =
                    "%" + filtro.trim() + "%";

            pst.setString(
                    1,
                    busqueda
            );

            pst.setString(
                    2,
                    busqueda
            );

            pst.setString(
                    3,
                    busqueda
            );

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Usuario usuario =
                        new Usuario(
                                rs.getInt(
                                        "id_usuario"
                                ),
                                rs.getString(
                                        "usuario"
                                ),
                                rs.getString(
                                        "password"
                                )
                        );

                usuario.setRol(
                        rs.getString(
                                "rol"
                        )
                );

                lista.add(
                        usuario
                );
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al buscar usuarios: " + e
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
    public void eliminar(int idUsuario) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "DELETE FROM usuarios WHERE id_usuario = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idUsuario);
            pst.executeUpdate();

            pst.close();

        } catch (Exception e) {

            System.out.println("Error al eliminar usuario: " + e);

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

    public boolean login(String nombreUsuario, String password) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nombreUsuario);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            boolean valido = rs.next();

            rs.close();
            pst.close();

            return valido;

        } catch (Exception e) {

            System.out.println("Error en login: " + e);

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

    public String obtenerRol(String nombreUsuario, String password) {

        String rol = null;
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT rol FROM usuarios WHERE usuario = ? AND password = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nombreUsuario);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                rol = rs.getString("rol");
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al obtener rol: " + e
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

        return rol;
    }
}