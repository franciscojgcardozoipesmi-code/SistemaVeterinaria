
package sistemaveterinaria;

import controller.UsuarioController;
public class VentanaLogin extends javax.swing.JFrame {
    private javax.swing.JPanel panelFormulario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaLogin.class.getName());

   
    public VentanaLogin() {

        initComponents();
        setTitle("Henry System Vet - Iniciar sesión");
        setIconImage(
                new javax.swing.ImageIcon(
                        getClass().getResource("/imagenes/HenrySystemVet.png")
                ).getImage()
        );
        getRootPane().setDefaultButton(btnIngresar);
        btnIngresar.setCursor(
                new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
        );
        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        java.awt.Color verdePrincipal =
                new java.awt.Color(58, 222, 158);
        
        java.awt.Color verdeHover =
            new java.awt.Color(42, 190, 134);
        
        java.awt.Color textoOscuro =
                new java.awt.Color(51, 51, 51);

    
        getContentPane().setBackground(
                java.awt.Color.WHITE
        );

        panelLogin.setBackground(
                java.awt.Color.WHITE
        );

    
        configurarDisenoLogin();

        
        lblUsuario.setForeground(textoOscuro);
        lblPassword.setForeground(textoOscuro);

       
        javax.swing.border.Border bordeVerde =
                javax.swing.BorderFactory.createLineBorder(
                        verdePrincipal,
                        1
                );

        txtUsuario.setBorder(bordeVerde);
        txtPassword.setBorder(bordeVerde);

        
        btnIngresar.setBackground(
                verdePrincipal
        );

        btnIngresar.setForeground(
                java.awt.Color.WHITE
        );

        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorderPainted(false);
        btnIngresar.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent evt) {

                        btnIngresar.setBackground(
                                verdeHover
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt) {

                        btnIngresar.setBackground(
                                verdePrincipal
                        );
                    }
                }
        );
      
        lblLogo.setOpaque(false);

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
    
   private void configurarDisenoLogin() {

        panelLogin.setLayout(null);

        panelLogin.setPreferredSize(
                new java.awt.Dimension(400, 580)
        );

        lblLogo.setBounds(
                50, 10,
                300, 300
        );

        panelFormulario = new javax.swing.JPanel();
        panelFormulario.setLayout(null);
        panelFormulario.setOpaque(false);

        panelFormulario.setBounds(
                75, 335,
                250, 195
        );

        java.awt.Color verdePrincipal =
                new java.awt.Color(58, 222, 158);

        panelFormulario.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        verdePrincipal,
                        2,
                        true
                )
        );

        panelLogin.add(panelFormulario);

        panelFormulario.add(lblUsuario);
        panelFormulario.add(txtUsuario);
        panelFormulario.add(lblPassword);
        panelFormulario.add(txtPassword);
        panelFormulario.add(btnIngresar);

        lblUsuario.setBounds(
                30, 10,
                190, 20
        );

        txtUsuario.setBounds(
                30, 33,
                190, 27
        );

        lblPassword.setBounds(
                30, 72,
                190, 20
        );

        txtPassword.setBounds(
                30, 95,
                190, 27
        );
     
        btnIngresar.setBounds(
                30, 158,
                190, 30
        );

        java.awt.Font fuenteCampos =
                new java.awt.Font(
                        "Segoe UI",
                        java.awt.Font.PLAIN,
                        13
                );

        java.awt.Font fuenteLabels =
                new java.awt.Font(
                        "Segoe UI",
                        java.awt.Font.BOLD,
                        13
                );

        java.awt.Font fuenteBoton =
                new java.awt.Font(
                        "Segoe UI",
                        java.awt.Font.BOLD,
                        13
                );

        lblUsuario.setFont(fuenteLabels);
        lblPassword.setFont(fuenteLabels);

        txtUsuario.setFont(fuenteCampos);
        txtPassword.setFont(fuenteCampos);

        btnIngresar.setFont(fuenteBoton);
        
        panelFormulario.add(chkMostrarPassword);

        chkMostrarPassword.setBounds(
                30, 124,
                190, 20
        );

        chkMostrarPassword.setOpaque(false);

        chkMostrarPassword.setFont(
                new java.awt.Font(
                        "Segoe UI",
                        java.awt.Font.PLAIN,
                        12
                )
        );
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
