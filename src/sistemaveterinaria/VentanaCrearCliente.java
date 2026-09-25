package sistemaveterinaria;

import controller.ClienteController;

    public class VentanaCrearCliente extends javax.swing.JFrame {

        private String rolUsuario;
        private int idCliente = -1;
        private javax.swing.JLabel lblTituloFormulario;
        private VentanaPrincipal ventanaPrincipal;
        private final javax.swing.JLabel lblTelefono =
            new javax.swing.JLabel("Teléfono");

        private final javax.swing.JLabel lblDireccion =
                new javax.swing.JLabel("Dirección");

        private final javax.swing.JLabel lblCorreo =
                new javax.swing.JLabel("Correo");

        private final javax.swing.JLabel lblObservaciones =
                new javax.swing.JLabel("Observaciones");

        private final javax.swing.JTextField txtTelefono =
                new javax.swing.JTextField();

        private final javax.swing.JTextField txtDireccion =
                new javax.swing.JTextField();

        private final javax.swing.JTextField txtCorreo =
                new javax.swing.JTextField();

        private final javax.swing.JTextArea txtObservaciones =
                new javax.swing.JTextArea(3, 20);

        private final javax.swing.JScrollPane scrollObservaciones =
                new javax.swing.JScrollPane(txtObservaciones);
        private static final java.util.logging.Logger logger =
                java.util.logging.Logger.getLogger(
                        VentanaCrearCliente.class.getName()
                );
        public VentanaCrearCliente() {

            initComponents();

            setExtendedState(
                    javax.swing.JFrame.MAXIMIZED_BOTH
            );

            aplicarDiseñoCrearEditarClientes();
        }
        public VentanaCrearCliente(String rolUsuario) {
            initComponents();

            this.rolUsuario = rolUsuario;

            setExtendedState(
                    javax.swing.JFrame.MAXIMIZED_BOTH
            );

            aplicarDiseñoCrearEditarClientes();
        }

        public VentanaCrearCliente(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        aplicarDiseñoCrearEditarClientes();
    }

        public void cargarDatos(
                        int id,
                        String nombre,
                        String dni
                ) {

                    idCliente = id;

                    txtNombre.setText(nombre);
                    txtDni.setText(dni);

                    if (lblTituloFormulario != null) {

                        lblTituloFormulario.setText(
                                "EDITAR CLIENTE"
                        );
                    }

                    setTitle(
                            "Henry System Vet - Editar cliente"
                    );
                }

                public void cargarDatos(
                int id,
                String nombre,
                String dni,
                String telefono,
                String direccion,
                String correo,
                String observaciones
        ) {
            idCliente = id;

            txtNombre.setText(nombre);
            txtDni.setText(dni);
            txtTelefono.setText(telefono);
            txtDireccion.setText(direccion);
            txtCorreo.setText(correo);
            txtObservaciones.setText(observaciones);

            if (lblTituloFormulario != null) {
                lblTituloFormulario.setText(
                        "EDITAR CLIENTE"
                );
            }

            setTitle(
                    "Henry System Vet - Editar cliente"
            );
        }
        
        
    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setText("Nombre");

        lblDni.setText("DNI");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDni)
                                .addGap(79, 79, 79)
                                .addComponent(txtDni))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(64, 64, 64)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(83, 83, 83)
                        .addComponent(btnGuardar)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGuardar))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String nombre =
                    txtNombre.getText().trim();

            String dni =
                    txtDni.getText().trim();

            String telefono =
                    txtTelefono.getText().trim();

            String direccion =
                    txtDireccion.getText().trim();

            String correo =
                    txtCorreo.getText().trim();

            String observaciones =
                    txtObservaciones.getText().trim();

            if (nombre.isEmpty()
                    || dni.isEmpty()
                    || telefono.isEmpty()) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Completá nombre, DNI y teléfono"
                );

                return;
            }

            if (!correo.isEmpty()
                    && (!correo.contains("@")
                    || !correo.contains("."))) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Ingresá un correo válido"
                );

                return;
            }

            ClienteController.guardarCliente(
                    nombre,
                    dni,
                    telefono,
                    direccion,
                    correo,
                    observaciones,
                    idCliente
            );

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    idCliente == -1
                            ? "Cliente guardado correctamente"
                            : "Cliente actualizado correctamente"
            );

            if (ventanaPrincipal != null) {
                ventanaPrincipal.mostrarClientes();

            } else {
                VentanaClientes vc =
                        new VentanaClientes(rolUsuario);

                vc.setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {
            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo guardar el cliente"
            );
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
            

        if (ventanaPrincipal != null) {

            ventanaPrincipal.mostrarClientes();

        } else {

            VentanaClientes vc =
                    new VentanaClientes(rolUsuario);

            vc.setVisible(true);

            this.dispose();
        }
    
    }//GEN-LAST:event_btnVolverActionPerformed


    private void aplicarDiseñoCrearEditarClientes() {

            setTitle(
                    "Henry System Vet - Nuevo cliente"
            );

            setIconImage(
                    new javax.swing.ImageIcon(
                            getClass().getResource(
                                    "/imagenes/HenrySystemVet.png"
                            )
                    ).getImage()
            );

            getContentPane().removeAll();

            getContentPane().setBackground(
                    Estilos.VERDE_PRINCIPAL
            );

            getContentPane().setLayout(
                    new java.awt.BorderLayout()
            );

            javax.swing.JPanel panelPrincipal =
                    new javax.swing.JPanel(
                            new java.awt.BorderLayout()
                    );

            panelPrincipal.setOpaque(false);

            panelPrincipal.setBorder(
                    javax.swing.BorderFactory.createEmptyBorder(
                            45,
                            60,
                            40,
                            60
                    )
            );

            javax.swing.JPanel panelEncabezado =
                    new javax.swing.JPanel();

            panelEncabezado.setOpaque(false);

            panelEncabezado.setLayout(
                    new javax.swing.BoxLayout(
                            panelEncabezado,
                            javax.swing.BoxLayout.Y_AXIS
                    )
            );

            lblTituloFormulario =
                    new javax.swing.JLabel(
                            "NUEVO CLIENTE"
                    );

            lblTituloFormulario.setFont(
                    Estilos.fuente(26f)
            );

            lblTituloFormulario.setForeground(
                    Estilos.BLANCO
            );

            javax.swing.JPanel panelTitulo =
                    new javax.swing.JPanel(
                            new java.awt.FlowLayout(
                                    java.awt.FlowLayout.CENTER,
                                    25,
                                    12
                            )
                    );

            panelTitulo.setBackground(
                    Estilos.VERDE_OSCURO
            );

            panelTitulo.add(
                    lblTituloFormulario
            );

            javax.swing.JPanel contenedorTitulo =
                    new javax.swing.JPanel(
                            new java.awt.FlowLayout(
                                    java.awt.FlowLayout.CENTER,
                                    0,
                                    0
                            )
                    );

            contenedorTitulo.setOpaque(false);

            contenedorTitulo.add(
                    panelTitulo
            );

            panelEncabezado.add(
                    contenedorTitulo
            );

            panelEncabezado.add(
                    javax.swing.Box.createVerticalStrut(10)
            );

            javax.swing.JPanel contenedorFormulario =
                    new javax.swing.JPanel(
                            new java.awt.GridBagLayout()
                    );

            contenedorFormulario.setOpaque(false);

            javax.swing.JPanel tarjetaFormulario =
                    new javax.swing.JPanel(
                            new java.awt.GridBagLayout()
                    );

            tarjetaFormulario.setBackground(
                    Estilos.BLANCO
            );
            
            tarjetaFormulario.setPreferredSize(
                    new java.awt.Dimension(560, 550)
            );

            tarjetaFormulario.setBorder(
                    javax.swing.BorderFactory.createCompoundBorder(
                            javax.swing.BorderFactory.createLineBorder(
                                    Estilos.VERDE_OSCURO,
                                    1,
                                    true
                            ),
                            javax.swing.BorderFactory.createEmptyBorder(
                                    40,
                                    50,
                                    40,
                                    50
                            )
                    )
            );

            java.awt.GridBagConstraints gbc =
                    new java.awt.GridBagConstraints();

            gbc.insets =
                    new java.awt.Insets(
                            12,
                            10,
                            12,
                            10
                    );

            gbc.anchor =
                    java.awt.GridBagConstraints.WEST;

            lblNombre.setFont(
                    Estilos.fuenteNormal()
            );

            lblDni.setFont(
                    Estilos.fuenteNormal()
            );

            lblNombre.setForeground(
                    Estilos.VERDE_OSCURO
            );

            lblDni.setForeground(
                    Estilos.VERDE_OSCURO
            );

            txtNombre.setFont(
                    Estilos.fuenteNormal()
            );

            txtDni.setFont(
                    Estilos.fuenteNormal()
            );

            txtNombre.setPreferredSize(
                    new java.awt.Dimension(
                            300,
                            38
                    )
            );

            txtDni.setPreferredSize(
                    new java.awt.Dimension(
                            300,
                            38
                    )
            );

            gbc.gridx = 0;
            gbc.gridy = 0;

            tarjetaFormulario.add(
                    lblNombre,
                    gbc
            );

            gbc.gridx = 1;

            tarjetaFormulario.add(
                    txtNombre,
                    gbc
            );

            gbc.gridx = 0;
            gbc.gridy = 1;

            tarjetaFormulario.add(
                    lblDni,
                    gbc
            );

            gbc.gridx = 1;

            tarjetaFormulario.add(
                    txtDni,
                    gbc
            );

            Estilos.estilizarBoton(
                    btnGuardar
            );

            Estilos.estilizarBoton(
                    btnVolver
            );

            btnGuardar.setPreferredSize(
                    new java.awt.Dimension(
                            140,
                            38
                    )
            );

            btnVolver.setPreferredSize(
                    new java.awt.Dimension(
                            120,
                            38
                    )
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
                    btnGuardar
            );

            panelBotones.add(
                    btnVolver
            );

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;

            gbc.anchor =
                    java.awt.GridBagConstraints.CENTER;

            gbc.insets =
                    new java.awt.Insets(
                            30,
                            10,
                            0,
                            10
                    );

            tarjetaFormulario.add(
                    panelBotones,
                    gbc
            );

            contenedorFormulario.add(
                    tarjetaFormulario
            );

            panelPrincipal.add(
                    panelEncabezado,
                    java.awt.BorderLayout.NORTH
            );

            panelPrincipal.add(
                    contenedorFormulario,
                    java.awt.BorderLayout.CENTER
            );

            getContentPane().add(
                    panelPrincipal,
                    java.awt.BorderLayout.CENTER
            );

            revalidate();
            repaint();
        }
    
    public javax.swing.JPanel obtenerPanelCrearEditarCliente() {

        javax.swing.JPanel panel =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panel.setBackground(
                Estilos.VERDE_PRINCIPAL
        );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelPrincipal.setOpaque(false);

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        45,
                        60,
                        40,
                        60
                )
        );

        javax.swing.JPanel panelEncabezado =
                new javax.swing.JPanel();

        panelEncabezado.setOpaque(false);

        panelEncabezado.setLayout(
                new javax.swing.BoxLayout(
                        panelEncabezado,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        if (lblTituloFormulario == null) {

            lblTituloFormulario =
                    new javax.swing.JLabel(
                            idCliente == -1
                                    ? "NUEVO CLIENTE"
                                    : "EDITAR CLIENTE"
                    );
        }

        lblTituloFormulario.setText(
                idCliente == -1
                        ? "NUEVO CLIENTE"
                        : "EDITAR CLIENTE"
        );

        lblTituloFormulario.setFont(
                Estilos.fuente(26f)
        );

        lblTituloFormulario.setForeground(
                Estilos.BLANCO
        );

        javax.swing.JPanel panelTitulo =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                25,
                                12
                        )
                );

        panelTitulo.setBackground(
                Estilos.VERDE_OSCURO
        );

        panelTitulo.add(
                lblTituloFormulario
        );

        javax.swing.JPanel contenedorTitulo =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                0
                        )
                );

        contenedorTitulo.setOpaque(false);
        contenedorTitulo.add(panelTitulo);

        panelEncabezado.add(contenedorTitulo);

        panelEncabezado.add(
                javax.swing.Box.createVerticalStrut(10)
        );

        javax.swing.JPanel contenedorFormulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        contenedorFormulario.setOpaque(false);

        javax.swing.JPanel tarjetaFormulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        tarjetaFormulario.setBackground(
                Estilos.BLANCO
        );
        
        tarjetaFormulario.setPreferredSize(
                new java.awt.Dimension(560, 550)
        );

        tarjetaFormulario.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                25,
                                50,
                                25,
                                50
                        )
                )
        );

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.insets =
                new java.awt.Insets(
                        12,
                        10,
                        12,
                        10
                );

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        javax.swing.JLabel[] etiquetas = {
            lblNombre,
            lblDni,
            lblTelefono,
            lblDireccion,
            lblCorreo,
            lblObservaciones
        };

        for (javax.swing.JLabel etiqueta : etiquetas) {
            etiqueta.setFont(Estilos.fuenteNormal());
            etiqueta.setForeground(Estilos.VERDE_OSCURO);
        }

        javax.swing.JTextField[] campos = {
            txtNombre,
            txtDni,
            txtTelefono,
            txtDireccion,
            txtCorreo
        };

        for (javax.swing.JTextField campo : campos) {
            campo.setFont(Estilos.fuenteNormal());
            campo.setColumns(22);

            campo.setPreferredSize(
                    new java.awt.Dimension(300, 38)
            );

            campo.setMinimumSize(
                    new java.awt.Dimension(300, 38)
            );
        }

        txtObservaciones.setFont(
                Estilos.fuenteNormal()
        );

        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);

        scrollObservaciones.setPreferredSize(
                new java.awt.Dimension(300, 85)
        );

        scrollObservaciones.setMinimumSize(
                new java.awt.Dimension(300, 85)
        );

        for (int i = 0; i < campos.length; i++) {

            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.gridwidth = 1;

            gbc.anchor =
                    java.awt.GridBagConstraints.WEST;

            gbc.insets =
                    new java.awt.Insets(
                            12,
                            10,
                            12,
                            10
                    );

            tarjetaFormulario.add(
                    etiquetas[i],
                    gbc
            );

            gbc.gridx = 1;

            tarjetaFormulario.add(
                    campos[i],
                    gbc
            );
        }

        gbc.gridx = 0;
        gbc.gridy = 6;

        tarjetaFormulario.add(
                lblObservaciones,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                scrollObservaciones,
                gbc
        );

        Estilos.estilizarBoton(
                btnGuardar
        );
        java.awt.Dimension tamañoBotonGuardar =
                new java.awt.Dimension(
                        140,
                        38
                );

        btnGuardar.setPreferredSize(
                tamañoBotonGuardar
        );

        btnGuardar.setMinimumSize(
                tamañoBotonGuardar
        );

        btnGuardar.setMaximumSize(
                tamañoBotonGuardar
        );
        btnVolver.setText(
                ""
        );

        javax.swing.ImageIcon iconoVolver =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/iconos/volver.png"
                        )
                );

        java.awt.Image imagenVolver =
                iconoVolver.getImage().getScaledInstance(
                        26,
                        26,
                        java.awt.Image.SCALE_SMOOTH
                );

        btnVolver.setIcon(
                new javax.swing.ImageIcon(
                        imagenVolver
                )
        );

        btnVolver.setBackground(
                Estilos.VERDE_OSCURO
        );

        btnVolver.setForeground(
                Estilos.BLANCO
        );

        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(true);
        btnVolver.setOpaque(true);
        btnVolver.setFocusPainted(false);

        btnVolver.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        btnVolver.setMargin(
                new java.awt.Insets(
                        0,
                        0,
                        0,
                        0
                )
        );

        java.awt.Dimension tamañoBotonVolver =
                new java.awt.Dimension(
                        38,
                        38
                );

        btnVolver.setPreferredSize(
                tamañoBotonVolver
        );

        btnVolver.setMinimumSize(
                tamañoBotonVolver
        );

        btnVolver.setMaximumSize(
                tamañoBotonVolver
        );

        btnVolver.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent evt
                    ) {
                        btnVolver.setBackground(
                                Estilos.VERDE_PRINCIPAL
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt
                    ) {
                        btnVolver.setBackground(
                                Estilos.VERDE_OSCURO
                        );
                    }
                }
        );
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        gbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        15,
                        0
                );

        tarjetaFormulario.add(
                btnVolver,
                gbc
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
                btnGuardar
        );

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        gbc.insets =
                new java.awt.Insets(
                        15,
                        10,
                        0,
                        10
                );

        tarjetaFormulario.add(
                panelBotones,
                gbc
        );

        contenedorFormulario.add(
                tarjetaFormulario
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                contenedorFormulario,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaCrearCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
