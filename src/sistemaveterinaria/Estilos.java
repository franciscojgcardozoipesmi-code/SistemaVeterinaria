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
        boton.addMouseListener(
            new java.awt.event.MouseAdapter() {

                @Override
                public void mouseEntered(
                        java.awt.event.MouseEvent evt) {

                    boton.setBackground(
                            VERDE_PRINCIPAL
                    );
                }

                @Override
                public void mouseExited(
                        java.awt.event.MouseEvent evt) {

                    boton.setBackground(
                            VERDE_OSCURO
                    );
                }
            }
        );
    }
    public static void estilizarBoton(
            javax.swing.JButton boton
    ) {

        boton.setFont(
                fuenteBoton()
        );

        boton.setBackground(
                VERDE_OSCURO
        );

        boton.setForeground(
                BLANCO
        );

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);

        boton.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        boton.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent evt) {

                        boton.setBackground(
                                VERDE_PRINCIPAL
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt) {

                        boton.setBackground(
                                VERDE_OSCURO
                        );
                    }
                }
        );
    }
    public static void estilizarTabla(
            javax.swing.JTable tabla
    ) {

        tabla.setFont(
                fuenteNormal()
        );

        tabla.setForeground(
                VERDE_OSCURO
        );

        tabla.setBackground(
                BLANCO
        );

        tabla.setRowHeight(32);

        tabla.setGridColor(
                new java.awt.Color(
                        220,
                        235,
                        228
                )
        );

        tabla.setSelectionBackground(
                VERDE_PRINCIPAL
        );

        tabla.setSelectionForeground(
                VERDE_OSCURO
        );

        tabla.getTableHeader().setFont(
                fuenteBoton()
        );

        tabla.getTableHeader().setBackground(
                VERDE_OSCURO
        );

        tabla.getTableHeader().setForeground(
                BLANCO
        );

        tabla.getTableHeader().setReorderingAllowed(
                false
        );
        
        tabla.setCellSelectionEnabled(false);

        tabla.setColumnSelectionAllowed(false);

        tabla.setRowSelectionAllowed(true);

        tabla.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        tabla.setSelectionBackground(
                VERDE_OSCURO
        );

        tabla.setSelectionForeground(
                BLANCO
        );                                   
    }
    public static void estilizarBotonEliminar(
            javax.swing.JButton boton
    ) {

        java.awt.Color rojo =
                new java.awt.Color(210, 70, 70);

        java.awt.Color rojoHover =
                new java.awt.Color(235, 95, 95);

        boton.setFont(
                fuenteBoton()
        );

        boton.setBackground(
                rojo
        );

        boton.setForeground(
                BLANCO
        );

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);

        boton.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        boton.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent evt
                    ) {
                        boton.setBackground(
                                rojoHover
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt
                    ) {
                        boton.setBackground(
                                rojo
                        );
                    }
                }
        );
    }
}