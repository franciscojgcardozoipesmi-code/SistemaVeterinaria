package sistemaveterinaria;
import controller.UsuarioController;

public class VentanaDatosUsuario extends javax.swing.JFrame {
    private int idUsuario = -1;
    private String rolUsuario;
    private VentanaPrincipal ventanaPrincipal;
    private final javax.swing.JLabel lblCorreo =
        new javax.swing.JLabel("Correo");

    private final javax.swing.JTextField txtCorreo =
            new javax.swing.JTextField();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaDatosUsuario.class.getName());

 
    public VentanaDatosUsuario() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }
    
    public VentanaDatosUsuario(String rolUsuario) {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.rolUsuario = rolUsuario;
    }
    public VentanaDatosUsuario(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        txtPassword.setText("");

        configurarBotonCancelar();
    }
    
    public VentanaDatosUsuario(
            int idUsuario,
            String usuario,
            String rol,
            String correo,
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.idUsuario = idUsuario;
        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        txtUsuario.setText(usuario);
        txtPassword.setText("");
        txtCorreo.setText(correo == null ? "" : correo);
        cmbRol.setSelectedItem(rol);

        configurarBotonCancelar();
    }
    
    public VentanaDatosUsuario(
            int idUsuario,
            String usuario,
            String rol,
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.idUsuario = idUsuario;
        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        txtUsuario.setText(usuario);
        txtPassword.setText("");
        cmbRol.setSelectedItem(rol);

        configurarBotonCancelar();
    }
    
    public VentanaDatosUsuario(int idUsuario,
                                String usuario,
                                String rol,
                                String rolUsuario) {

        initComponents();

        this.idUsuario = idUsuario;
        this.rolUsuario = rolUsuario;

        txtUsuario.setText(usuario);
        cmbRol.setSelectedItem(rol);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        txtUsuario.addActionListener(this::txtUsuarioActionPerformed);

        jLabel2.setText("Contraseña");

        txtPassword.setText("jPasswordField1");

        jLabel3.setText("Rol");

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "COLABORADOR", "VETERINARIO" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario)
                            .addComponent(txtPassword)
                            .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {

            String usuario = txtUsuario.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();
            String correo = txtCorreo.getText().trim();
            String rol = cmbRol.getSelectedItem().toString();

            if (usuario.isEmpty() || password.isEmpty() || correo.isEmpty()) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Completá usuario, contraseña y correo"
                );

                return;
            }
            
            if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Ingresá un correo válido"
                );

                return;
            }

            if (idUsuario == -1) {

                UsuarioController.registrarUsuario(
                        usuario,
                        password,
                        rol,
                        correo
                );

                Estilos.mostrarAdvertencia(
                        this,
                        "Operación exitosa",
                        "Usuario creado correctamente"
                );

            } else {

                UsuarioController.editarUsuario(
                        idUsuario,
                        usuario,
                        password,
                        rol,
                        correo
                );

                Estilos.mostrarAdvertencia(
                        this,
                        "Operación exitosa",
                        "Usuario editado correctamente"
                );
            }

            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarUsuarios();

            } else {

                VentanaUsuarios vu =
                        new VentanaUsuarios(rolUsuario);

                vu.setVisible(true);

                this.dispose();
            }

        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo guardar el usuario: "
                    + e.getMessage()
            );
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    public javax.swing.JPanel obtenerPanelDatosUsuario() {

        javax.swing.JPanel panel =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panel.setBackground(
                Estilos.VERDE_PRINCIPAL
        );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                10
                        )
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

        String titulo;

        if (idUsuario == -1) {

            titulo = "CREAR USUARIO";

        } else {

            titulo = "EDITAR USUARIO";
        }

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        titulo
                );

        lblTitulo.setFont(
                Estilos.fuente(26f)
        );

        lblTitulo.setForeground(
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
                lblTitulo
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

        javax.swing.JPanel tarjeta =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        tarjeta.setBackground(
                Estilos.BLANCO
        );

        tarjeta.setBorder(
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

        javax.swing.JLabel[] etiquetas = {
            jLabel1,
            jLabel2,
            lblCorreo,
            jLabel3
        };

        for (javax.swing.JLabel etiqueta : etiquetas) {

            etiqueta.setFont(
                    Estilos.fuenteNormal()
            );

            etiqueta.setForeground(
                    Estilos.VERDE_OSCURO
            );
        }

        java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        280,
                        38
                );

        txtUsuario.setFont(
                Estilos.fuenteNormal()
        );

        txtUsuario.setPreferredSize(
                tamañoCampo
        );

        txtUsuario.setMinimumSize(
                tamañoCampo
        );

        txtPassword.setFont(
                Estilos.fuenteNormal()
        );

        txtPassword.setPreferredSize(
                tamañoCampo
        );

        txtPassword.setMinimumSize(
                tamañoCampo
        );

        txtCorreo.setFont(
                Estilos.fuenteNormal()
        );

        txtCorreo.setPreferredSize(
                tamañoCampo
        );

        txtCorreo.setMinimumSize(
                tamañoCampo
        );

        cmbRol.setFont(
                Estilos.fuenteNormal()
        );

        cmbRol.setPreferredSize(
                tamañoCampo
        );

        cmbRol.setMinimumSize(
                tamañoCampo
        );

        btnCancelar.setText("");

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

        btnCancelar.setIcon(
                new javax.swing.ImageIcon(
                        imagenVolver
                )
        );

        btnCancelar.setBackground(
                Estilos.VERDE_OSCURO
        );

        btnCancelar.setForeground(
                Estilos.BLANCO
        );

        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(true);
        btnCancelar.setOpaque(true);
        btnCancelar.setFocusPainted(false);

        btnCancelar.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        btnCancelar.setMargin(
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

        btnCancelar.setPreferredSize(
                tamañoBotonVolver
        );

        btnCancelar.setMinimumSize(
                tamañoBotonVolver
        );

        btnCancelar.setMaximumSize(
                tamañoBotonVolver
        );

        btnCancelar.addMouseListener(
                new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(
                    java.awt.event.MouseEvent evt
            ) {

                btnCancelar.setBackground(
                        Estilos.VERDE_PRINCIPAL
                );
            }

            @Override
            public void mouseExited(
                    java.awt.event.MouseEvent evt
            ) {

                btnCancelar.setBackground(
                        Estilos.VERDE_OSCURO
                );
            }
        });

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.fill =
                java.awt.GridBagConstraints.NONE;

        gbc.insets =
                new java.awt.Insets(
                        0,
                        12,
                        10,
                        12
                );

        tarjeta.add(
                btnCancelar,
                gbc
        );

        gbc.gridwidth = 1;

        gbc.insets =
                new java.awt.Insets(
                        12,
                        12,
                        12,
                        12
                );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        gbc.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        tarjeta.add(
                jLabel1,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjeta.add(
                txtUsuario,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        tarjeta.add(
                jLabel2,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjeta.add(
                txtPassword,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;

        tarjeta.add(
                lblCorreo,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjeta.add(
                txtCorreo,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;

        tarjeta.add(
                jLabel3,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjeta.add(
                cmbRol,
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
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 0;

        gbc.fill =
                java.awt.GridBagConstraints.NONE;

        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        gbc.insets =
                new java.awt.Insets(
                        25,
                        12,
                        0,
                        12
                );

        tarjeta.add(
                panelBotones,
                gbc
        );

        javax.swing.JPanel contenedorFormulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        contenedorFormulario.setOpaque(false);

        java.awt.GridBagConstraints gbcFormulario =
                new java.awt.GridBagConstraints();

        gbcFormulario.fill =
                java.awt.GridBagConstraints.NONE;

        gbcFormulario.anchor =
                java.awt.GridBagConstraints.CENTER;

        contenedorFormulario.add(
                tarjeta,
                gbcFormulario
        );

        panelPrincipal.add(
                contenedorTitulo,
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
    private void configurarBotonCancelar() {

        btnCancelar.addActionListener(e -> {

            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarUsuarios();

            } else {

                VentanaUsuarios vu =
                        new VentanaUsuarios(rolUsuario);

                vu.setVisible(true);

                this.dispose();
            }
        });
    }
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(() -> new VentanaDatosUsuario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
