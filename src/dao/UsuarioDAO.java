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
                        "UPDATE usuarios SET usuario = ?, password = ?, rol = ?, correo = ? "
                        + "WHERE id_usuario = ?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, usuario.getUsuario());
                pst.setString(2, usuario.getPassword());
                pst.setString(3, usuario.getRol());
                pst.setString(4, usuario.getCorreo());
                pst.setInt(5, usuario.getIdUsuario());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO usuarios (usuario, password, rol, correo) "
                        + "VALUES (?, ?, ?, ?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, usuario.getUsuario());
                pst.setString(2, usuario.getPassword());
                pst.setString(3, usuario.getRol());
                pst.setString(4, usuario.getCorreo());

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
                
                usuario.setCorreo(
                        rs.getString("correo")
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
                    + "OR LOWER(COALESCE(correo, '')) LIKE LOWER(?) "
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
            
            pst.setString(
                    4,
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
                
                usuario.setCorreo(
                        rs.getString("correo")
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
    public boolean existeCorreo(String correo) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT 1 FROM usuarios "
                    + "WHERE LOWER(correo) = LOWER(?) "
                    + "LIMIT 1";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(
                    1,
                    correo.trim()
            );

            ResultSet rs =
                    pst.executeQuery();

            boolean existe =
                    rs.next();

            rs.close();
            pst.close();

            return existe;

        } catch (Exception e) {

            System.out.println(
                    "Error al buscar correo: " + e
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
    public boolean guardarCodigoRecuperacion(
            String correo,
            String codigoProtegido,
            String vencimiento
    ) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "UPDATE usuarios "
                    + "SET codigo_recuperacion = ?, "
                    + "vencimiento_codigo = ? "
                    + "WHERE LOWER(correo) = LOWER(?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(
                    1,
                    codigoProtegido
            );

            pst.setString(
                    2,
                    vencimiento
            );

            pst.setString(
                    3,
                    correo.trim()
            );

            int filasActualizadas =
                    pst.executeUpdate();

            pst.close();

            return filasActualizadas > 0;

        } catch (Exception e) {

            System.out.println(
                    "Error al guardar código de recuperación: " + e
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
    public String[] obtenerDatosRecuperacion(
            String correo
    ) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT codigo_recuperacion, vencimiento_codigo "
                    + "FROM usuarios "
                    + "WHERE LOWER(correo) = LOWER(?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(
                    1,
                    correo.trim()
            );

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                String[] datos = {
                    rs.getString("codigo_recuperacion"),
                    rs.getString("vencimiento_codigo")
                };

                rs.close();
                pst.close();

                return datos;
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al obtener datos de recuperación: " + e
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
    public boolean cambiarPasswordPorCorreo(
            String correo,
            String nuevaPassword
    ) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "UPDATE usuarios "
                    + "SET password = ?, "
                    + "codigo_recuperacion = NULL, "
                    + "vencimiento_codigo = NULL "
                    + "WHERE LOWER(correo) = LOWER(?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(
                    1,
                    nuevaPassword
            );

            pst.setString(
                    2,
                    correo.trim()
            );

            int filasActualizadas =
                    pst.executeUpdate();

            pst.close();

            return filasActualizadas > 0;

        } catch (Exception e) {

            System.out.println(
                    "Error al cambiar la contraseña: " + e
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
    public Usuario buscarPorNombreUsuario(
            String nombreUsuario
    ) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT id_usuario, usuario, rol, correo "
                    + "FROM usuarios "
                    + "WHERE LOWER(usuario) = LOWER(?) "
                    + "LIMIT 1";

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(
                    1,
                    nombreUsuario.trim()
            );

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                Usuario usuario =
                        new Usuario(
                                rs.getInt("id_usuario"),
                                rs.getString("usuario"),
                                ""
                        );

                usuario.setRol(
                        rs.getString("rol")
                );

                usuario.setCorreo(
                        rs.getString("correo")
                );

                rs.close();
                pst.close();

                return usuario;
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al obtener el usuario actual: "
                    + e.getMessage()
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
}