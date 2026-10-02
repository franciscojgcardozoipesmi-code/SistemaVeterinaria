package sistemaveterinaria;

public final class SesionUsuario {

    private static String nombreUsuario;
    private static String rol;

    private SesionUsuario() {
    }

    public static void iniciar(
            String usuario,
            String rolUsuario
    ) {

        nombreUsuario = usuario;
        rol = rolUsuario;
    }

    public static String getNombreUsuario() {

        return nombreUsuario;
    }

    public static String getRol() {

        return rol;
    }

    public static boolean haySesionActiva() {

        return nombreUsuario != null
                && !nombreUsuario.isBlank();
    }

    public static void cerrar() {

        nombreUsuario = null;
        rol = null;
    }
}