package sistemaveterinaria;

import controller.UsuarioController;
public class VentanaLogin extends javax.swing.JFrame {
    private javax.swing.JPanel panelFormulario;
    private final javax.swing.JButton btnSalir =
        new javax.swing.JButton("⏻");
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaLogin.class.getName());

   
    public VentanaLogin() {

        initComponents();

        setTitle("Henry System Vet - Iniciar sesión");

        setIconImage(
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/HenrySystemVet.png"
                        )
                ).getImage()
        );

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        getRootPane().setDefaultButton(
                btnIngresar
        );

        configurarDiseñoLogin();
        cargarLogo();
    }
    
    

 
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        chkMostrarPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btnIngresar.setText("Iniciar sesión");
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);

        lblPassword.setText("Contraseña:");

        lblUsuario.setText("Usuario:");

        chkMostrarPassword.setText("Mostrar contraseña");
        chkMostrarPassword.addActionListener(this::chkMostrarPasswordActionPerformed);

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addGap(9, 9, 9)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnIngresar)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addGap(51, 51, 51)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkMostrarPassword)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword)
                    .addComponent(chkMostrarPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresar)
                .addContainerGap())
        );

        getContentPane().add(panelLogin, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String usuario = txtUsuario.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (usuario.isEmpty() || password.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Completar usuario y contraseña"
            );
            return;
        }

        boolean valido = UsuarioController.iniciarSesion(usuario, password);

        if (valido) {

            String rol = UsuarioController.obtenerRol(
                    usuario,
                    password
            );

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Bienvenido"
            );

            VentanaPrincipal vp = new VentanaPrincipal(rol);
            vp.setVisible(true);

            this.dispose();

        } else {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Usuario o contraseña incorrectos"
            );

            txtPassword.setText("");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void chkMostrarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarPasswordActionPerformed
    

        if (chkMostrarPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('•');
        }
    }//GEN-LAST:event_chkMostrarPasswordActionPerformed

    private void cargarLogo() {

        javax.swing.ImageIcon icono =
                new javax.swing.ImageIcon(
                        getClass().getResource("/imagenes/HenrySystemVet.png")
                );

        java.awt.Image imagen =
                icono.getImage().getScaledInstance(
                        lblLogo.getWidth(),
                        lblLogo.getHeight(),
                        java.awt.Image.SCALE_SMOOTH
                );

        lblLogo.setIcon(
                new javax.swing.ImageIcon(imagen)
        );
    }
    private class PanelFranjas extends javax.swing.JPanel {

        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);

            java.awt.Graphics2D g2 =
                    (java.awt.Graphics2D) g.create();

            int ancho = getWidth();
            int alto = getHeight();

            int grosorPrincipal = 45;
            int grosorClaro = 18;
            int longitud = (int) (ancho * 0.75);
            int corte = 40;

            g2.setColor(Estilos.VERDE_PRINCIPAL);

            g2.fillRect(
                    0,
                    0,
                    ancho,
                    grosorPrincipal
            );

            g2.fillRect(
                    0,
                    alto - grosorPrincipal,
                    ancho,
                    grosorPrincipal
            );

            g2.setColor(
                    new java.awt.Color(112, 224, 180)
            );

            java.awt.Polygon franjaClaraSuperior =
                    new java.awt.Polygon(
                            new int[]{
                                0,
                                longitud,
                                longitud - corte,
                                0
                            },
                            new int[]{
                                grosorPrincipal,
                                grosorPrincipal,
                                grosorPrincipal + grosorClaro,
                                grosorPrincipal + grosorClaro
                            },
                            4
                    );

            java.awt.Polygon franjaClaraInferior =
                    new java.awt.Polygon(
                            new int[]{
                                ancho - longitud + corte,
                                ancho,
                                ancho,
                                ancho - longitud
                            },
                            new int[]{
                                alto - grosorPrincipal - grosorClaro,
                                alto - grosorPrincipal - grosorClaro,
                                alto - grosorPrincipal,
                                alto - grosorPrincipal
                            },
                            4
                    );

            g2.fillPolygon(franjaClaraSuperior);
            g2.fillPolygon(franjaClaraInferior);

            g2.dispose();
        }
    } 
    private void configurarDiseñoLogin() {
        getContentPane().removeAll();

        getContentPane().setLayout(
                new java.awt.BorderLayout()
        );

        PanelFranjas panelFondo =
                new PanelFranjas();

        panelFondo.setBackground(
                Estilos.BLANCO
        );

        panelFondo.setLayout(
                new java.awt.BorderLayout()
        );

        javax.swing.JPanel panelCentro =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        panelCentro.setOpaque(false);

        panelLogin.setLayout(null);
        panelLogin.setOpaque(false);

        panelLogin.setPreferredSize(
                new java.awt.Dimension(400, 580)
        );
        
        panelLogin.setMinimumSize(
                new java.awt.Dimension(400, 550)
        );

        lblLogo.setBounds(
                50,
                55,
                300,
                300
        );

        lblLogo.setOpaque(false);

        panelFormulario =
                new javax.swing.JPanel();

        panelFormulario.setLayout(null);
        panelFormulario.setBackground(Estilos.BLANCO);
        panelFormulario.setOpaque(true);

        panelFormulario.setBounds(
                75,
                355,
                250,
                195
        );

        panelFormulario.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        2,
                        true
                )
        );

        lblUsuario.setBounds(
                30,
                10,
                190,
                20
        );

        txtUsuario.setBounds(
                30,
                33,
                190,
                27
        );

        lblPassword.setBounds(
                30,
                72,
                190,
                20
        );

        txtPassword.setBounds(
                30,
                95,
                190,
                27
        );

        chkMostrarPassword.setBounds(
                30,
                124,
                190,
                20
        );

        btnIngresar.setBounds(
                30,
                158,
                190,
                30
        );

        lblUsuario.setFont(
                Estilos.fuenteNormal()
        );

        lblPassword.setFont(
                Estilos.fuenteNormal()
        );

        txtUsuario.setFont(
                Estilos.fuenteNormal()
        );

        txtPassword.setFont(
                Estilos.fuenteNormal()
        );

        chkMostrarPassword.setFont(
                Estilos.fuente(12f)
        );

        lblUsuario.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblPassword.setForeground(
                Estilos.VERDE_OSCURO
        );

        chkMostrarPassword.setForeground(
                Estilos.VERDE_OSCURO
        );

        chkMostrarPassword.setOpaque(false);

        javax.swing.border.Border bordeCampos =
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                2,
                                5,
                                2,
                                5
                        )
                );

        txtUsuario.setBorder(bordeCampos);
        txtPassword.setBorder(bordeCampos);

        Estilos.estilizarBoton(
                btnIngresar
        );

        panelFormulario.add(lblUsuario);
        panelFormulario.add(txtUsuario);
        panelFormulario.add(lblPassword);
        panelFormulario.add(txtPassword);
        panelFormulario.add(chkMostrarPassword);
        panelFormulario.add(btnIngresar);

        panelLogin.add(lblLogo);
        panelLogin.add(panelFormulario);

        panelCentro.add(
                panelLogin,
                new java.awt.GridBagConstraints()
        );

        Estilos.estilizarBotonEliminar(
                btnSalir
        );

        btnSalir.setText("");

        btnSalir.setToolTipText(
                "Salir del sistema"
        );

        Estilos.aplicarIcono(
                btnSalir,
                "/imagenes/iconos/apagado.png",
                20,
                20
        );

        java.awt.Dimension tamañoSalir =
                new java.awt.Dimension(38, 38);

        btnSalir.setPreferredSize(tamañoSalir);
        btnSalir.setMinimumSize(tamañoSalir);
        btnSalir.setMaximumSize(tamañoSalir);

        btnSalir.addActionListener(e ->
                System.exit(0)
        );

        javax.swing.JPanel panelSalida =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                8,
                                5
                        )
                );

        panelSalida.setOpaque(false);

        panelSalida.setPreferredSize(
                new java.awt.Dimension(0, 95)
        );
        panelSalida.add(
                btnSalir
        );

        panelFondo.add(
                panelCentro,
                java.awt.BorderLayout.CENTER
        );

        panelFondo.add(
                panelSalida,
                java.awt.BorderLayout.SOUTH
        );

        getContentPane().add(
                panelFondo,
                java.awt.BorderLayout.CENTER
        );

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    
    
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new VentanaLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JCheckBox chkMostrarPassword;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
