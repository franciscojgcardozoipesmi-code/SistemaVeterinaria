package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import sistemaveterinaria.Conexion;
import sistemaveterinaria.SesionUsuario;
import java.sql.ResultSet;
import java.util.ArrayList;
public final class AuditoriaController {

    private AuditoriaController() {
    }

    public static void inicializarAuditoria() {

        String sql =
                "CREATE TABLE IF NOT EXISTS auditoria ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "fecha_hora TEXT NOT NULL, "
                + "usuario TEXT NOT NULL, "
                + "rol TEXT NOT NULL, "
                + "modulo TEXT NOT NULL, "
                + "accion TEXT NOT NULL, "
                + "detalle TEXT NOT NULL"
                + ")";

        try (
                Connection conexion =
                        Conexion.getInstancia().conectar();

                Statement sentencia =
                        conexion.createStatement()
        ) {

            sentencia.execute(sql);

        } catch (Exception e) {

            System.out.println(
                    "Error al crear la tabla de auditoría: "
                    + e.getMessage()
            );
        }
    }

    public static boolean registrar(
            String modulo,
            String accion,
            String detalle
    ) {

        inicializarAuditoria();

        String sql =
                "INSERT INTO auditoria "
                + "(fecha_hora, usuario, rol, modulo, accion, detalle) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        String fechaHora =
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern(
                                "dd/MM/yyyy HH:mm:ss"
                        )
                );

        String usuario =
                SesionUsuario.haySesionActiva()
                        ? SesionUsuario.getNombreUsuario()
                        : "SISTEMA";

        String rol =
                SesionUsuario.haySesionActiva()
                        ? SesionUsuario.getRol()
                        : "SISTEMA";

        try (
                Connection conexion =
                        Conexion.getInstancia().conectar();

                PreparedStatement sentencia =
                        conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, fechaHora);
            sentencia.setString(2, usuario);
            sentencia.setString(3, rol);
            sentencia.setString(4, modulo);
            sentencia.setString(5, accion);
            sentencia.setString(6, detalle);

            sentencia.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error al registrar la auditoría: "
                    + e.getMessage()
            );

            return false;
        }
    }
    public static ArrayList<Object[]> listarRegistros() {

        inicializarAuditoria();

        ArrayList<Object[]> registros =
                new ArrayList<>();

        String sql =
                "SELECT id, fecha_hora, usuario, rol, modulo, accion, detalle "
                + "FROM auditoria "
                + "ORDER BY id DESC";

        try (
                Connection conexion =
                        Conexion.getInstancia().conectar();

                Statement sentencia =
                        conexion.createStatement();

                ResultSet resultado =
                        sentencia.executeQuery(sql)
        ) {

            while (resultado.next()) {

                registros.add(
                        new Object[]{
                            resultado.getInt("id"),
                            resultado.getString("fecha_hora"),
                            resultado.getString("usuario"),
                            resultado.getString("rol"),
                            resultado.getString("modulo"),
                            resultado.getString("accion"),
                            resultado.getString("detalle")
                        }
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al listar la auditoría: "
                    + e.getMessage()
            );
        }

        return registros;
    }
}