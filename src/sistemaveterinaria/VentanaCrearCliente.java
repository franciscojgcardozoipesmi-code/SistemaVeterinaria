package sistemaveterinaria;

import controller.ClienteController;

    public class VentanaCrearCliente extends javax.swing.JFrame {

        private String rolUsuario;
        private int idCliente = -1;
        private javax.swing.JLabel lblTituloFormulario;
        private VentanaPrincipal ventanaPrincipal;
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

            String nombre = txtNombre.getText().trim();
            String dni = txtDni.getText().trim();

            if (nombre.isEmpty() || dni.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Completar todos los campos"
                );
                return;
            }

            ClienteController.guardarCliente(nombre, dni, idCliente);

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Cliente guardado"
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
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e
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
                    javax.swing.Box.createVerticalStrut(30)
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
                javax.swing.Box.createVerticalStrut(30)
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

        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

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
