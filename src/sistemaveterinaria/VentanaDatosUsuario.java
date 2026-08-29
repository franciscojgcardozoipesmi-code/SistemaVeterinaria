package sistemaveterinaria;
import controller.UsuarioController;

public class VentanaDatosUsuario extends javax.swing.JFrame {
    private int idUsuario = -1;
    private String rolUsuario;
    private VentanaPrincipal ventanaPrincipal;
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

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "COLABORADOR" }));

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
            String rol = cmbRol.getSelectedItem().toString();

            if (usuario.isEmpty() || password.isEmpty()) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Completá usuario y contraseña"
                );

                return;
            }

            if (idUsuario == -1) {

                UsuarioController.registrarUsuario(
                        usuario,
                        password,
                        rol
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
                        rol
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

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
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
                                30
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
                                40,
                                50,
                                40,
                                50
                        )
                )
        );

        jLabel1.setFont(
                Estilos.fuenteNormal()
        );

        jLabel2.setFont(
                Estilos.fuenteNormal()
        );

        jLabel3.setFont(
                Estilos.fuenteNormal()
        );

        jLabel1.setForeground(
                Estilos.VERDE_OSCURO
        );

        jLabel2.setForeground(
                Estilos.VERDE_OSCURO
        );

        jLabel3.setForeground(
                Estilos.VERDE_OSCURO
        );

        txtUsuario.setFont(
                Estilos.fuenteNormal()
        );

        txtPassword.setFont(
                Estilos.fuenteNormal()
        );

        cmbRol.setFont(
                Estilos.fuenteNormal()
        );

        java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        280,
                        38
                );

        txtUsuario.setPreferredSize(
                tamañoCampo
        );

        txtUsuario.setMinimumSize(
                tamañoCampo
        );

        txtPassword.setPreferredSize(
                tamañoCampo
        );

        txtPassword.setMinimumSize(
                tamañoCampo
        );

        cmbRol.setPreferredSize(
                tamañoCampo
        );

        cmbRol.setMinimumSize(
                tamañoCampo
        );

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.insets =
                new java.awt.Insets(
                        12,
                        12,
                        12,
                        12
                );

        gbc.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

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
        gbc.gridy = 1;
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
        gbc.gridy = 2;
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

        Estilos.estilizarBoton(
                btnCancelar
        );

        btnGuardar.setPreferredSize(
                new java.awt.Dimension(
                        140,
                        38
                )
        );

        btnCancelar.setPreferredSize(
                new java.awt.Dimension(
                        140,
                        38
                )
        );

        javax.swing.JPanel panelBotones =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(false);

        panelBotones.add(
                btnGuardar
        );

        panelBotones.add(
                btnCancelar
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

        panelPrincipal.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
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
