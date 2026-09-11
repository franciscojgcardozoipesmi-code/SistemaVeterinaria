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
    public static void aplicarIcono(
                javax.swing.JButton boton,
                String ruta,
                int ancho,
                int alto
        ) {

            java.net.URL recurso =
                    Estilos.class.getResource(
                            ruta
                    );

            if (recurso == null) {

                System.out.println(
                        "No se encontró el ícono: "
                        + ruta
                );

                return;
            }

            javax.swing.ImageIcon iconoOriginal =
                    new javax.swing.ImageIcon(
                            recurso
                    );

            java.awt.Image imagenEscalada =
                    iconoOriginal.getImage()
                            .getScaledInstance(
                                    ancho,
                                    alto,
                                    java.awt.Image.SCALE_SMOOTH
                            );

            boton.setIcon(
                    new javax.swing.ImageIcon(
                            imagenEscalada
                    )
            );

            boton.setIconTextGap(10);

            boton.setHorizontalTextPosition(
                    javax.swing.SwingConstants.RIGHT
            );

            boton.setVerticalTextPosition(
                    javax.swing.SwingConstants.CENTER
            );
        }

        public static void estilizarBotonEditar(
            javax.swing.JButton boton
    ) {

        java.awt.Color azul =
                new java.awt.Color(
                        70,
                        145,
                        215
                );

        java.awt.Color azulHover =
                new java.awt.Color(
                        95,
                        170,
                        235
                );

        boton.setFont(
                fuenteBoton()
        );

        boton.setBackground(
                azul
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
                                azulHover
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt
                    ) {

                        boton.setBackground(
                                azul
                        );
                    }
                }
        );
    }
    public static void estilizarBotonHistorial(
            javax.swing.JButton boton
    ) {

        java.awt.Color rosa =
                new java.awt.Color(
                        215,
                        105,
                        155
                );

        java.awt.Color rosaHover =
                new java.awt.Color(
                        235,
                        130,
                        175
                );

        boton.setFont(
                fuenteBoton()
        );

        boton.setBackground(
                rosa
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
                                rosaHover
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt
                    ) {

                        boton.setBackground(
                                rosa
                        );
                    }
                }
        );
    }
        public static void estilizarBotonVencidos(
            javax.swing.JButton boton
    ) {

        java.awt.Color naranja =
                new java.awt.Color(
                        225,
                        140,
                        45
                );

        java.awt.Color naranjaHover =
                new java.awt.Color(
                        245,
                        165,
                        70
                );

        boton.setFont(
                fuenteBoton()
        );

        boton.setBackground(
                naranja
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
                                naranjaHover
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt
                    ) {

                        boton.setBackground(
                                naranja
                        );
                    }
                }
        );
    }
    public static void mostrarAdvertencia(
            java.awt.Component padre,
            String titulo,
            String mensaje
    ) {

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(
                        padre
                );

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        titulo,
                        java.awt.Dialog.ModalityType.APPLICATION_MODAL
                );

        dialogo.setUndecorated(true);

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                15
                        )
                );

        panelPrincipal.setBackground(
                Estilos.BLANCO
        );

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                2
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                0,
                                20,
                                18,
                                20
                        )
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        titulo.toUpperCase(),
                        javax.swing.SwingConstants.CENTER
                );

        lblTitulo.setFont(
                Estilos.fuente(18f)
        );

        lblTitulo.setForeground(
                Estilos.BLANCO
        );

        javax.swing.JPanel panelTitulo =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelTitulo.setBackground(
                Estilos.VERDE_OSCURO
        );

        panelTitulo.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        10,
                        15,
                        10,
                        15
                )
        );

        panelTitulo.add(
                lblTitulo,
                java.awt.BorderLayout.CENTER
        );

        javax.swing.JLabel lblMensaje =
                new javax.swing.JLabel(
                        mensaje,
                        javax.swing.SwingConstants.CENTER
                );

        lblMensaje.setFont(
                Estilos.fuente(13f)
        );

        lblMensaje.setForeground(
                Estilos.VERDE_OSCURO
        );

        javax.swing.JButton btnAceptar =
                new javax.swing.JButton(
                        "Aceptar"
                );

        Estilos.estilizarBoton(
                btnAceptar
        );

        btnAceptar.setPreferredSize(
                new java.awt.Dimension(
                        105,
                        34
                )
        );

        javax.swing.JPanel panelBoton =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                0
                        )
                );

        panelBoton.setOpaque(false);

        panelBoton.add(
                btnAceptar
        );

        javax.swing.JPanel contenido =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                15
                        )
                );

        contenido.setOpaque(false);

        contenido.add(
                lblMensaje,
                java.awt.BorderLayout.CENTER
        );

        contenido.add(
                panelBoton,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelTitulo,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                contenido,
                java.awt.BorderLayout.CENTER
        );

        btnAceptar.addActionListener(e ->
                dialogo.dispose()
        );

        dialogo.setContentPane(
                panelPrincipal
        );

        dialogo.setSize(
                370,
                170
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(true);
    }
}