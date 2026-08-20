package sistemaveterinaria;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Conexion instancia;

    private Conexion() {
    }

    public static Conexion getInstancia() {

        if (instancia == null) {
            instancia = new Conexion();
        }

        return instancia;
    }

    public Connection conectar() {

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(
                    "jdbc:sqlite:veterinaria.db"
            );

        } catch (Exception e) {

            System.out.println("Error de conexión: " + e);
        }

        return conn;
    }
}