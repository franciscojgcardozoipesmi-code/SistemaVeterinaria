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

        java.awt.Dimension tamaño =
                new java.awt.Dimension(
                        280,
                        38
                );

        boton.setPreferredSize(
                tamaño
        );

        boton.setMinimumSize(
                tamaño
        );

        boton.setMaximumSize(
                tamaño
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
    public static void estilizarBotonSubmenu(
            javax.swing.JButton boton
    ) {

        estilizarBotonMenu(
                boton
        );

        boton.setBackground(
                BLANCO
        );

        boton.setForeground(
                VERDE_OSCURO
        );

        boton.setBorderPainted(
                true
        );

        boton.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        VERDE_OSCURO,
                        2
                )
        );

        boton.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent evt
                    ) {

                        boton.setBackground(
                                VERDE_PRINCIPAL
                        );

                        boton.setForeground(
                                BLANCO
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt
                    ) {

                        boton.setBackground(
                                BLANCO
                        );

                        boton.setForeground(
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
                        titulo,
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

        dialogo.pack();

        java.awt.Dimension tamañoNecesario =
                dialogo.getPreferredSize();

        dialogo.setSize(
                Math.max(
                        370,
                        tamañoNecesario.width
                ),
                Math.max(
                        170,
                        tamañoNecesario.height
                )
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(true);
    }
    public static boolean mostrarConfirmacion(
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

        final boolean[] confirmado = {
            false
        };

        java.awt.Color rojo =
                new java.awt.Color(
                        210,
                        45,
                        45
                );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                15
                        )
                );

        panelPrincipal.setBackground(
                BLANCO
        );

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                rojo,
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
                fuente(18f)
        );

        lblTitulo.setForeground(
                BLANCO
        );

        javax.swing.JPanel panelTitulo =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelTitulo.setBackground(
                rojo
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

        javax.swing.JPanel panelMensaje =
                new javax.swing.JPanel();

        panelMensaje.setOpaque(false);

        panelMensaje.setLayout(
                new javax.swing.BoxLayout(
                        panelMensaje,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        String[] lineas =
                mensaje.split("\\n");

        for (String linea : lineas) {

            javax.swing.JLabel lblLinea =
                    new javax.swing.JLabel(
                            linea,
                            javax.swing.SwingConstants.CENTER
                    );

            lblLinea.setFont(
                    fuenteNormal()
            );

            lblLinea.setForeground(
                    VERDE_OSCURO
            );

            lblLinea.setAlignmentX(
                    java.awt.Component.CENTER_ALIGNMENT
            );

            panelMensaje.add(
                    lblLinea
            );
        }

        javax.swing.JButton btnCancelar =
                new javax.swing.JButton(
                        "Cancelar"
                );

        estilizarBoton(
                btnCancelar
        );

        javax.swing.JButton btnConfirmar =
                new javax.swing.JButton(
                        "Confirmar"
                );

        estilizarBotonEliminar(
                btnConfirmar
        );
        
        btnCancelar.setFont(
                Estilos.fuenteBoton()
        );

        btnConfirmar.setFont(
                Estilos.fuenteBoton()
        );

        java.awt.Dimension tamañoBoton =
                new java.awt.Dimension(
                        115,
                        36
                );

        btnCancelar.setPreferredSize(
                tamañoBoton
        );

        btnConfirmar.setPreferredSize(
                tamañoBoton
        );

        javax.swing.JPanel panelBotones =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(false);

        panelBotones.add(
                btnCancelar
        );

        panelBotones.add(
                btnConfirmar
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
                panelMensaje,
                java.awt.BorderLayout.CENTER
        );

        contenido.add(
                panelBotones,
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

        btnConfirmar.addActionListener(
                evento -> {

                    confirmado[0] = true;

                    dialogo.dispose();
                }
        );

        btnCancelar.addActionListener(
                evento -> dialogo.dispose()
        );

        dialogo.setContentPane(
                panelPrincipal
        );

        dialogo.setSize(
                430,
                180
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(
                true
        );

        return confirmado[0];
    }
    
    public static String solicitarTexto(
            java.awt.Component padre,
            String titulo,
            String mensaje,
            String textoInicial
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

        final String[] resultado = {
            null
        };

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                12
                        )
                );

        panelPrincipal.setBackground(
                BLANCO
        );

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                VERDE_OSCURO,
                                2
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                0,
                                18,
                                15,
                                18
                        )
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        titulo,
                        javax.swing.SwingConstants.CENTER
                );

        lblTitulo.setFont(
                fuente(18f)
        );

        lblTitulo.setForeground(
                BLANCO
        );

        javax.swing.JPanel panelTitulo =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelTitulo.setBackground(
                VERDE_OSCURO
        );

        panelTitulo.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        9,
                        15,
                        9,
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
                Estilos.fuenteNormal()
        );

        lblMensaje.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblMensaje.setForeground(
                VERDE_OSCURO
        );

        javax.swing.JTextField txtValor =
                new javax.swing.JTextField(
                        textoInicial
                );

        txtValor.setFont(
                fuenteNormal()
        );

       java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        220,
                        32
                );

        txtValor.setPreferredSize(
                tamañoCampo
        );

        txtValor.setMinimumSize(
                tamañoCampo
        );

        txtValor.setMaximumSize(
                tamañoCampo
        );

        javax.swing.JPanel panelCampo =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                7
                        )
                );

        panelCampo.setOpaque(false);

        panelCampo.add(
                lblMensaje,
                java.awt.BorderLayout.NORTH
        );

        javax.swing.JPanel contenedorCampo =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                0
                        )
                );

        contenedorCampo.setOpaque(false);

        contenedorCampo.add(
                txtValor
        );

        panelCampo.add(
                contenedorCampo,
                java.awt.BorderLayout.CENTER
        );

        javax.swing.JButton btnCancelar =
                new javax.swing.JButton(
                        "Cancelar"
                );

        btnCancelar.setFont(
                fuenteBoton()
        );

        btnCancelar.setBackground(
                BLANCO
        );

        btnCancelar.setForeground(
                VERDE_OSCURO
        );

        btnCancelar.setFocusPainted(false);

        btnCancelar.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        VERDE_OSCURO,
                        2
                )
        );

        btnCancelar.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        javax.swing.JButton btnGuardar =
                new javax.swing.JButton(
                        "Guardar"
                );

        estilizarBoton(
                btnGuardar
        );

        java.awt.Dimension tamañoBoton =
                new java.awt.Dimension(
                        110,
                        34
                );

        btnCancelar.setPreferredSize(
                tamañoBoton
        );

        btnGuardar.setPreferredSize(
                tamañoBoton
        );

        javax.swing.JPanel panelBotones =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(false);

        panelBotones.add(
                btnCancelar
        );

        panelBotones.add(
                btnGuardar
        );

        javax.swing.JPanel contenido =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                12
                        )
                );

        contenido.setOpaque(false);

        contenido.add(
                panelCampo,
                java.awt.BorderLayout.CENTER
        );

        contenido.add(
                panelBotones,
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

        btnGuardar.addActionListener(
                evento -> {

                    resultado[0] =
                            txtValor.getText();

                    dialogo.dispose();
                }
        );

        txtValor.addActionListener(
                evento -> {

                    resultado[0] =
                            txtValor.getText();

                    dialogo.dispose();
                }
        );

        btnCancelar.addActionListener(
                evento -> dialogo.dispose()
        );

        dialogo.setContentPane(
                panelPrincipal
        );

        dialogo.setSize(
                330,
                185
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        javax.swing.SwingUtilities.invokeLater(
                () -> {

                    txtValor.requestFocusInWindow();

                    txtValor.selectAll();
                }
        );

        dialogo.setVisible(
                true
        );

        return resultado[0];
    }
    public static javax.swing.ImageIcon crearIconoColor(
            String ruta,
            int ancho,
            int alto,
            java.awt.Color color
    ) {

        javax.swing.ImageIcon original =
                new javax.swing.ImageIcon(
                        Estilos.class.getResource(ruta)
                );

        java.awt.image.BufferedImage imagen =
                new java.awt.image.BufferedImage(
                        ancho,
                        alto,
                        java.awt.image.BufferedImage.TYPE_INT_ARGB
                );

        java.awt.Graphics2D graficos =
                imagen.createGraphics();

        graficos.setRenderingHint(
                java.awt.RenderingHints.KEY_INTERPOLATION,
                java.awt.RenderingHints.VALUE_INTERPOLATION_BICUBIC
        );

        graficos.drawImage(
                original.getImage(),
                0,
                0,
                ancho,
                alto,
                null
        );

        graficos.dispose();

        for (int y = 0; y < alto; y++) {

            for (int x = 0; x < ancho; x++) {

                int pixel = imagen.getRGB(x, y);
                int transparencia = (pixel >>> 24) & 0xFF;

                if (transparencia > 0) {

                    imagen.setRGB(
                            x,
                            y,
                            (transparencia << 24)
                            | (color.getRGB() & 0x00FFFFFF)
                    );
                }
            }
        }

        return new javax.swing.ImageIcon(imagen);
    }
}