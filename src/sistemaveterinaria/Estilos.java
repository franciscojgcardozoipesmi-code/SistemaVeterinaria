package sistemaveterinaria;

public class Estilos {

    public static final java.awt.Color VERDE_PRINCIPAL =
            new java.awt.Color(58, 222, 158);

    public static final java.awt.Color VERDE_OSCURO =
            new java.awt.Color(35, 160, 110);

    public static final java.awt.Color BLANCO =
            java.awt.Color.WHITE;

    private static java.awt.Font fuenteDekatron;

    private static java.awt.Font cargarDekatron() {

        if (fuenteDekatron != null) {
            return fuenteDekatron;
        }

        try {

            java.io.InputStream fuente =
                    Estilos.class.getResourceAsStream(
                            "/fuentes/Dekatron-SemiBold.otf"
                    );

            fuenteDekatron =
                    java.awt.Font.createFont(
                            java.awt.Font.TRUETYPE_FONT,
                            fuente
                    );

            return fuenteDekatron;

        } catch (Exception e) {

            System.out.println(
                    "No se pudo cargar Dekatron: "
                    + e.getMessage()
            );

            return new java.awt.Font(
                    "Arial",
                    java.awt.Font.BOLD,
                    13
            );
        }
    }

    public static java.awt.Font fuente(float tamaño) {

        return cargarDekatron().deriveFont(tamaño);
    }

    public static java.awt.Font fuenteTitulo() {

        return fuente(20f);
    }

    public static java.awt.Font fuenteSubtitulo() {

        return fuente(16f);
    }

    public static java.awt.Font fuenteBoton() {

        return fuente(14f);
    }

    public static java.awt.Font fuenteNormal() {

        return fuente(13f);
    }
    public static void estilizarBotonMenu(
        javax.swing.JButton boton
    ) {

        boton.setFont(
                fuenteBoton()
        );

        boton.setBackground(
                VERDE_OSCURO
        );

        boton.setForeground(
                java.awt.Color.WHITE
        );

        boton.setFocusPainted(false);

        boton.setBorderPainted(false);

        boton.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        boton.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        boton.setMaximumSize(
                new java.awt.Dimension(
                        190,
                        38
                )
        );

        boton.setPreferredSize(
                new java.awt.Dimension(
                        190,
                        38
                )
        );
    }
}