package sistemaveterinaria;
import excepciones.UsuarioNoAutorizadoException;
import controller.ProductoController;
import controller.TurnoController;
public class VentanaPrincipal extends javax.swing.JFrame {
    private String rolUsuario;
    private static boolean alertaProductosMostrada = false;
    private static boolean alertaTurnosMostrada = false;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelContenido;  
    private javax.swing.JLabel lblLogoMenu;
    private javax.swing.JLabel lblTituloMenu;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblRolSesion;
    private javax.swing.JPanel panelBienvenida;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    public VentanaPrincipal() {

        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        configurarDiseñoPrincipal();
    }
    public VentanaPrincipal(String rolUsuario) {

        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        this.rolUsuario = rolUsuario;

        configurarDiseñoPrincipal();

        revisarAlertasProductos();
        revisarAlertasTurnos();
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnTurnos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnAnimales = new javax.swing.JButton();
        btnProcedimientos = new javax.swing.JButton();
        btnAlertas = new javax.swing.JButton();
        pnlNotificaciones = new javax.swing.JPanel();
        lblTituloNotificaciones = new javax.swing.JLabel();
        lblAlertaProductos = new javax.swing.JLabel();
        lblAlertaTurnos = new javax.swing.JLabel();
        btnReportesVentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Sistema de gestión veterinaria");

        btnTurnos.setText("Turnos");
        btnTurnos.addActionListener(this::btnTurnosActionPerformed);

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(this::btnClientesActionPerformed);

        btnProductos.setText("Productos");
        btnProductos.addActionListener(this::btnProductosActionPerformed);

        btnVentas.setText("Ventas");
        btnVentas.addActionListener(this::btnVentasActionPerformed);

        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(this::btnUsuariosActionPerformed);

        btnAnimales.setText("Animales");
        btnAnimales.addActionListener(this::btnAnimalesActionPerformed);

        btnProcedimientos.setText("Procedimientos");
        btnProcedimientos.addActionListener(this::btnProcedimientosActionPerformed);

        btnAlertas.setText("Alertas");
        btnAlertas.addActionListener(this::btnAlertasActionPerformed);

        lblTituloNotificaciones.setText("Notificaciones");

        javax.swing.GroupLayout pnlNotificacionesLayout = new javax.swing.GroupLayout(pnlNotificaciones);
        pnlNotificaciones.setLayout(pnlNotificacionesLayout);
        pnlNotificacionesLayout.setHorizontalGroup(
            pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblAlertaProductos))
                    .addComponent(lblTituloNotificaciones))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        pnlNotificacionesLayout.setVerticalGroup(
            pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloNotificaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAlertaProductos)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        btnReportesVentas.setText("Reportes");
        btnReportesVentas.addActionListener(this::btnReportesVentasActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnimales)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnTurnos)
                                .addComponent(btnProductos))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnAlertas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReportesVentas)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnVentas)
                                .addComponent(btnProcedimientos)
                                .addComponent(btnClientes)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnUsuarios)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(pnlNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAlertaTurnos)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAlertas)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblTitulo)
                        .addGap(36, 36, 36)
                        .addComponent(btnUsuarios)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnimales)
                        .addGap(16, 16, 16)
                        .addComponent(btnProcedimientos)
                        .addGap(46, 46, 46)
                        .addComponent(btnReportesVentas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTurnos)
                        .addGap(18, 18, 18)
                        .addComponent(btnProductos)
                        .addGap(33, 33, 33)
                        .addComponent(btnClientes)
                        .addGap(28, 28, 28)
                        .addComponent(btnVentas)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(lblAlertaTurnos)
                        .addGap(316, 316, 316))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnosActionPerformed
        mostrarTurnos();
    }//GEN-LAST:event_btnTurnosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
           mostrarClientes();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        mostrarProductos();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        mostrarVentas();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        try {

            if (!"ADMINISTRADOR".equals(rolUsuario)) {
                throw new UsuarioNoAutorizadoException(
                        "No tiene permisos para acceder a la gestión de usuarios"
                );
            }

            mostrarUsuarios();

        } catch (UsuarioNoAutorizadoException e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimalesActionPerformed
        mostrarAnimales();
    }//GEN-LAST:event_btnAnimalesActionPerformed

    private void btnProcedimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcedimientosActionPerformed
         mostrarProcedimientos();
    }//GEN-LAST:event_btnProcedimientosActionPerformed

    private void btnAlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertasActionPerformed
        mostrarAlertas();
    }//GEN-LAST:event_btnAlertasActionPerformed

    private void btnReportesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesVentasActionPerformed
           mostrarReportes();
    }//GEN-LAST:event_btnReportesVentasActionPerformed
    
    private void revisarAlertasProductos() {

        int cantidad =
                ProductoController.contarProximosAVencer();

        if (cantidad > 0) {

            lblAlertaProductos.setText(
                    "⚠ " + cantidad
                    + " producto(s) próximo(s) a vencer"
            );

            if (!alertaProductosMostrada) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Hay " + cantidad
                        + " producto(s) que vencen en los próximos 7 días.",
                        "Alerta de vencimiento",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );

                alertaProductosMostrada = true;
            }

        } else {

            lblAlertaProductos.setText(
                    "Sin productos próximos a vencer"
            );
        }
    }
    
    private void revisarAlertasTurnos() {

        int cantidad =
                TurnoController.contarTurnosProximos();

        if (cantidad > 0) {

            lblAlertaTurnos.setText(
                    "📅 " + cantidad
                    + " turno(s) próximo(s)"
            );

            if (!alertaTurnosMostrada) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Hay " + cantidad
                        + " turno(s) programado(s) para hoy o mañana.",
                        "Alerta de turnos",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );

                alertaTurnosMostrada = true;
            }

        } else {

            lblAlertaTurnos.setText(
                    "Sin turnos próximos"
            );
        }
    }
    
    private void configurarDiseñoPrincipal() {

        setTitle("Henry System Vet - Menú principal");

        setIconImage(
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/HenrySystemVet.png"
                        )
                ).getImage()
        );

        getContentPane().removeAll();

        getContentPane().setLayout(
                new java.awt.BorderLayout()
        );

        panelMenu = new javax.swing.JPanel();

        panelMenu.setBackground(
                Estilos.BLANCO
        );

        panelMenu.setPreferredSize(
                new java.awt.Dimension(230, 0)
        );

        panelMenu.setLayout(
                new javax.swing.BoxLayout(
                        panelMenu,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        lblLogoMenu = new javax.swing.JLabel();

        javax.swing.ImageIcon icono =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/HenrySystemVet.png"
                        )
                );

        java.awt.Image imagen =
                icono.getImage().getScaledInstance(
                        150,
                        150,
                        java.awt.Image.SCALE_SMOOTH
                );

        lblLogoMenu.setIcon(
                new javax.swing.ImageIcon(imagen)
        );

        lblLogoMenu.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        lblTituloMenu = new javax.swing.JLabel(
                "MENÚ PRINCIPAL"
        );

        lblTituloMenu.setFont(
                Estilos.fuenteSubtitulo()
        );

        lblTituloMenu.setForeground(
                Estilos.VERDE_OSCURO
        );
        lblTituloMenu.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(20)
        );

        panelMenu.add(lblLogoMenu);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(10)
        );

        panelMenu.add(lblTituloMenu);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(25)
        );
        Estilos.estilizarBotonMenu(btnAnimales);
        Estilos.estilizarBotonMenu(btnClientes);
        Estilos.estilizarBotonMenu(btnTurnos);
        Estilos.estilizarBotonMenu(btnProcedimientos);
        Estilos.estilizarBotonMenu(btnProductos);
        Estilos.estilizarBotonMenu(btnVentas);
        Estilos.estilizarBotonMenu(btnReportesVentas);
        Estilos.estilizarBotonMenu(btnAlertas);
        Estilos.estilizarBotonMenu(btnUsuarios);
        
        Estilos.aplicarIcono(
                btnAnimales,
                "/imagenes/iconos/animales.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnClientes,
                "/imagenes/iconos/clientes.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnTurnos,
                "/imagenes/iconos/turnos.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnProcedimientos,
                "/imagenes/iconos/procedimientos.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnProductos,
                "/imagenes/iconos/productos.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnVentas,
                "/imagenes/iconos/ventas.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnReportesVentas,
                "/imagenes/iconos/reportes.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnAlertas,
                "/imagenes/iconos/alertas.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnUsuarios,
                "/imagenes/iconos/usuarios.png",
                18,
                18
        );
        
        panelMenu.add(btnAnimales);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnClientes);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnTurnos);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnProcedimientos);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnProductos);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnVentas);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnReportesVentas);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnAlertas);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnUsuarios);
        panelMenu.add(
                javax.swing.Box.createVerticalStrut(
                        8
                )
        );

        javax.swing.JButton btnCerrarSesion =
                new javax.swing.JButton(
                        "Cerrar sesión"
                );

        Estilos.estilizarBotonEliminar(
                btnCerrarSesion
        );
        
        Estilos.aplicarIcono(
        btnCerrarSesion,
                "/imagenes/iconos/cerrar_sesion.png",
                18,
                18
        );

        java.awt.Dimension tamañoCerrarSesion =
                new java.awt.Dimension(
                        190,
                        38
                );

        btnCerrarSesion.setPreferredSize(
                tamañoCerrarSesion
        );

        btnCerrarSesion.setMaximumSize(
                tamañoCerrarSesion
        );

        btnCerrarSesion.setMinimumSize(
                tamañoCerrarSesion
        );

        btnCerrarSesion.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnCerrarSesion.addActionListener(e -> {

            VentanaLogin ventanaLogin =
                    new VentanaLogin();

            ventanaLogin.setLocationRelativeTo(
                    null
            );

            ventanaLogin.setVisible(
                    true
            );

            dispose();
        });

        panelMenu.add(
                btnCerrarSesion
        );
        panelContenido = new javax.swing.JPanel();

        panelContenido.setBackground(
                Estilos.VERDE_PRINCIPAL
        );

        panelContenido.setLayout(
                new java.awt.BorderLayout()
        );
        
        javax.swing.JPanel panelSuperior =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                30,
                                20
                        )
                );

        panelSuperior.setOpaque(false);

        javax.swing.JPanel panelSesion =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                18,
                                10
                        )
                );

        panelSesion.setBackground(
                Estilos.VERDE_OSCURO
        );

        lblRolSesion = new javax.swing.JLabel(
                "Sesión: " + rolUsuario
        );

        lblRolSesion.setFont(
                Estilos.fuenteBoton()
        );

        lblRolSesion.setForeground(
                Estilos.BLANCO
        );

        panelSesion.add(lblRolSesion);

        panelSuperior.add(panelSesion);

        panelContenido.add(
                panelSuperior,
                java.awt.BorderLayout.NORTH
        );


        panelBienvenida = new javax.swing.JPanel();

        panelBienvenida.setOpaque(false);

        panelBienvenida.setLayout(
                new javax.swing.BoxLayout(
                        panelBienvenida,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        javax.swing.JLabel lblBienvenido =
                new javax.swing.JLabel(
                        "Bienvenido a"
                );

        lblBienvenido.setFont(
                Estilos.fuente(26f)
        );

        lblBienvenido.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblBienvenido.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        lblBienvenida = new javax.swing.JLabel(
                "Henry System Vet"
        );

        lblBienvenida.setFont(
                Estilos.fuente(36f)
        );

        lblBienvenida.setForeground(
                Estilos.BLANCO
        );

        lblBienvenida.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        panelBienvenida.add(
                javax.swing.Box.createVerticalGlue()
        );

        panelBienvenida.add(lblBienvenido);

        panelBienvenida.add(
                javax.swing.Box.createVerticalStrut(15)
        );

        panelBienvenida.add(lblBienvenida);

        panelBienvenida.add(
                javax.swing.Box.createVerticalGlue()
        );

        panelContenido.add(
                panelBienvenida,
                java.awt.BorderLayout.CENTER
        );


        javax.swing.JPanel panelNotificaciones =
                new javax.swing.JPanel();

        panelNotificaciones.setBackground(
                Estilos.BLANCO
        );

        panelNotificaciones.setPreferredSize(
                new java.awt.Dimension(
                        380,
                        0
                )
        );

        panelNotificaciones.setLayout(
                new javax.swing.BoxLayout(
                        panelNotificaciones,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        panelNotificaciones.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        35,
                        25,
                        35,
                        25
                )
        );

        lblTituloNotificaciones.setText(
                "NOTIFICACIONES"
        );

        lblTituloNotificaciones.setFont(
                Estilos.fuenteTitulo()
        );

        lblTituloNotificaciones.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblTituloNotificaciones.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        panelNotificaciones.add(
                lblTituloNotificaciones
        );

        panelNotificaciones.add(
                javax.swing.Box.createVerticalStrut(30)
        );


        javax.swing.JPanel tarjetaTurnos =
                new javax.swing.JPanel();

        tarjetaTurnos.setBackground(
                new java.awt.Color(
                        235,
                        250,
                        244
                )
        );
        
        tarjetaTurnos.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                20,
                                20,
                                20,
                                20
                        )
                )
        );

        tarjetaTurnos.setLayout(
                new java.awt.BorderLayout()
        );

        tarjetaTurnos.setMaximumSize(
                new java.awt.Dimension(
                        330,
                        120
                )
        );

        tarjetaTurnos.setPreferredSize(
                new java.awt.Dimension(
                        330,
                        120
                )
        );

        tarjetaTurnos.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                20,
                                20,
                                20,
                                20
                        )
                )
        );

        javax.swing.JLabel tituloTurnos =
                new javax.swing.JLabel(
                        "TURNOS PRÓXIMOS"
                );

        tituloTurnos.setFont(
                Estilos.fuenteSubtitulo()
        );

        tituloTurnos.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblAlertaTurnos.setFont(
                Estilos.fuenteNormal()
        );

        lblAlertaTurnos.setForeground(
                Estilos.VERDE_OSCURO
        );

        tarjetaTurnos.add(
                tituloTurnos,
                java.awt.BorderLayout.NORTH
        );

        tarjetaTurnos.add(
                lblAlertaTurnos,
                java.awt.BorderLayout.CENTER
        );

        panelNotificaciones.add(
                tarjetaTurnos
        );

        panelNotificaciones.add(
                javax.swing.Box.createVerticalStrut(20)
        );


        javax.swing.JPanel tarjetaProductos =
                new javax.swing.JPanel();

        tarjetaProductos.setBackground(
                new java.awt.Color(
                        235,
                        250,
                        244
                )
        );

        tarjetaProductos.setLayout(
                new java.awt.BorderLayout()
        );

        tarjetaProductos.setMaximumSize(
                new java.awt.Dimension(
                        330,
                        120
                )
        );

        tarjetaProductos.setPreferredSize(
                new java.awt.Dimension(
                        330,
                        120
                )
        );

        tarjetaProductos.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );
        
        tarjetaProductos.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                20,
                                20,
                                20,
                                20
                        )
                )
        );

        javax.swing.JLabel tituloProductos =
                new javax.swing.JLabel(
                        "PRODUCTOS POR VENCER"
                );

        tituloProductos.setFont(
                Estilos.fuenteSubtitulo()
        );

        tituloProductos.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblAlertaProductos.setFont(
                Estilos.fuenteNormal()
        );

        lblAlertaProductos.setForeground(
                Estilos.VERDE_OSCURO
        );

        tarjetaProductos.add(
                tituloProductos,
                java.awt.BorderLayout.NORTH
        );

        tarjetaProductos.add(
                lblAlertaProductos,
                java.awt.BorderLayout.CENTER
        );

        panelNotificaciones.add(
                tarjetaProductos
        );

        javax.swing.JPanel contenedorNotificaciones =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        contenedorNotificaciones.setOpaque(false);

        contenedorNotificaciones.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        70,
                        0,
                        70,
                        35
                )
        );

        contenedorNotificaciones.add(
                panelNotificaciones,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.add(
                contenedorNotificaciones,
                java.awt.BorderLayout.EAST
        );

        getContentPane().add(
                panelMenu,
                java.awt.BorderLayout.WEST
        );

        getContentPane().add(
                panelContenido,
                java.awt.BorderLayout.CENTER
        );

        revalidate();
        repaint();
    }
    
    public void mostrarClientes() {

        VentanaClientes ventanaClientes =
                new VentanaClientes(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel clientes =
                ventanaClientes.obtenerPanelClientes();

        panelContenido.removeAll();

        panelContenido.add(
                clientes,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarCrearCliente() {

        VentanaCrearCliente ventanaCrearCliente =
                new VentanaCrearCliente(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel formulario =
                ventanaCrearCliente.obtenerPanelCrearEditarCliente();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarEditarCliente(
            int id,
            String nombre,
            String dni
    ) {

        VentanaCrearCliente ventanaCrearCliente =
                new VentanaCrearCliente(
                        rolUsuario,
                        this
                );

        ventanaCrearCliente.cargarDatos(
                id,
                nombre,
                dni
        );

        javax.swing.JPanel formulario =
                ventanaCrearCliente.obtenerPanelCrearEditarCliente();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarEditarCliente(
            int id,
            String nombre,
            String dni,
            String telefono,
            String direccion,
            String correo,
            String observaciones
    ) {
        VentanaCrearCliente ventanaCrearCliente =
                new VentanaCrearCliente(
                        rolUsuario,
                        this
                );

        ventanaCrearCliente.cargarDatos(
                id,
                nombre,
                dni,
                telefono,
                direccion,
                correo,
                observaciones
        );

        javax.swing.JPanel formulario =
                ventanaCrearCliente.obtenerPanelCrearEditarCliente();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarAnimales() {

        VentanaAnimales ventanaAnimales =
                new VentanaAnimales(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel animales =
                ventanaAnimales.obtenerPanelAnimales();

        panelContenido.removeAll();

        panelContenido.add(
                animales,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarCrearAnimal() {

        VentanaAgregarAnimal ventanaAgregarAnimal =
                new VentanaAgregarAnimal(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel formulario =
                ventanaAgregarAnimal.obtenerPanelCrearEditarAnimal();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarEditarAnimal(
            int idAnimal,
            String nombre,
            String especie,
            String raza,
            int edad,
            int idCliente
    ) {

        VentanaAgregarAnimal ventanaAgregarAnimal =
                new VentanaAgregarAnimal(
                        rolUsuario,
                        this
                );

        ventanaAgregarAnimal.cargarDatos(
                idAnimal,
                nombre,
                especie,
                raza,
                edad,
                idCliente
        );

        javax.swing.JPanel formulario =
                ventanaAgregarAnimal.obtenerPanelCrearEditarAnimal();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarAnimalSeleccionado(
            int idAnimal
    ) {

        VentanaAnimales ventanaAnimales =
                new VentanaAnimales(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel animales =
                ventanaAnimales.obtenerPanelAnimales();

        panelContenido.removeAll();

        panelContenido.add(
                animales,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();

        javax.swing.SwingUtilities.invokeLater(
                () -> ventanaAnimales.seleccionarAnimal(
                        idAnimal
                )
        );
    }
    public void mostrarHistorialMedico(
            int idAnimal,
            String nombreAnimal
    ) {

        VentanaHistorialMedico ventana =
                new VentanaHistorialMedico(
                        idAnimal,
                        nombreAnimal,
                        rolUsuario,
                        this
                );

        javax.swing.JPanel historial =
                ventana.obtenerPanelHistorialMedico();

        panelContenido.removeAll();

        panelContenido.add(
                historial,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarTurnos(){
            VentanaTurnos ventanaTurnos =
                new VentanaTurnos(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel turnos =
                ventanaTurnos.obtenerPanelTurnos();

        panelContenido.removeAll();

        panelContenido.add(
                turnos,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarCrearTurno() {
        VentanaCrearTurno ventanaCrearTurno =
                new VentanaCrearTurno(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel formulario =
                ventanaCrearTurno.obtenerPanelCrearEditarTurno();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarEditarTurno(
            int id,
            String dueno,
            String animal,
            String fecha,
            String hora,
            String motivo,
            String dni
    ) {

        VentanaCrearTurno ventanaCrearTurno =
                new VentanaCrearTurno(
                        rolUsuario,
                        this
                );

        ventanaCrearTurno.cargarDatos(
                id,
                dueno,
                animal,
                fecha,
                hora,
                motivo,
                dni
        );

        javax.swing.JPanel formulario =
                ventanaCrearTurno.obtenerPanelCrearEditarTurno();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarTurnosVencidos() {

        VentanaTurnosVencidos ventana =
                new VentanaTurnosVencidos(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel turnosVencidos =
                ventana.obtenerPanelTurnosVencidos();

        panelContenido.removeAll();

        panelContenido.add(
                turnosVencidos,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarReprogramarTurno(
            int id,
            String dueno,
            String animal,
            String fecha,
            String hora,
            String motivo,
            String dni
    ) {

        VentanaCrearTurno ventanaCrearTurno =
                new VentanaCrearTurno(
                        rolUsuario,
                        this
                );

        ventanaCrearTurno.cargarDatosReprogramacion(
                id,
                dueno,
                animal,
                fecha,
                hora,
                motivo,
                dni
        );

        javax.swing.JPanel formulario =
                ventanaCrearTurno.obtenerPanelCrearEditarTurno();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarProcedimientos() {

        VentanaProcedimientosMedicos ventanaProcedimientos =
                new VentanaProcedimientosMedicos(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel procedimientos =
                ventanaProcedimientos.obtenerPanelProcedimientos();

        panelContenido.removeAll();

        panelContenido.add(
                procedimientos,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarCrearProcedimiento() {

        VentanaAgregarProcedimiento ventana =
                new VentanaAgregarProcedimiento(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel formulario =
                ventana.obtenerPanelCrearEditarProcedimiento();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarEditarProcedimiento(
            int idProcedimiento,
            String tipo,
            boolean emergencia,
            double monto,
            int idAnimal,
            String fecha,
            String descripcion
    ) {

        VentanaAgregarProcedimiento ventana =
                new VentanaAgregarProcedimiento(
                        rolUsuario,
                        this
                );

        ventana.cargarDatos(
                idProcedimiento,
                tipo,
                emergencia,
                monto,
                idAnimal,
                fecha,
                descripcion
        );

        javax.swing.JPanel formulario =
                ventana.obtenerPanelCrearEditarProcedimiento();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarProductos() {

        VentanaProductos ventanaProductos =
                new VentanaProductos(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel productos =
                ventanaProductos.obtenerPanelProductos();

        panelContenido.removeAll();

        panelContenido.add(
                productos,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarCrearProducto() {

        VentanaCrearProducto ventana =
                new VentanaCrearProducto(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel formulario =
                ventana.obtenerPanelCrearEditarProducto();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarEditarProducto(
            int idProducto,
            String nombre,
            double precio,
            int stock,
            String fechaVencimiento
    ) {

        VentanaCrearProducto ventana =
                new VentanaCrearProducto(
                        rolUsuario,
                        this
                );

        ventana.cargarDatos(
                idProducto,
                nombre,
                precio,
                stock,
                fechaVencimiento
        );

        javax.swing.JPanel formulario =
                ventana.obtenerPanelCrearEditarProducto();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarVentas() {

        VentanaVentas ventanaVentas =
                new VentanaVentas(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel ventas =
                ventanaVentas.obtenerPanelVentas();

        panelContenido.removeAll();

        panelContenido.add(
                ventas,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarCrearVenta() {

        VentanaCrearVenta ventana =
                new VentanaCrearVenta(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel formulario =
                ventana.obtenerPanelCrearVenta();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarReportes() {

        VentanaReportesVentas ventanaReportes =
                new VentanaReportesVentas(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel panel =
                ventanaReportes.obtenerPanelReportes();

        panelContenido.removeAll();

        panelContenido.add(
                panel,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarAlertas() {

        VentanaAlertas ventanaAlertas =
                new VentanaAlertas(rolUsuario);

        javax.swing.JPanel alertas =
                ventanaAlertas.obtenerPanelAlertas();

        panelContenido.removeAll();

        panelContenido.add(
                alertas,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarUsuarios() {

        VentanaUsuarios ventanaUsuarios =
                new VentanaUsuarios(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel usuarios =
                ventanaUsuarios.obtenerPanelUsuarios();

        panelContenido.removeAll();

        panelContenido.add(
                usuarios,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    public void mostrarCrearUsuario() {

        VentanaDatosUsuario ventana =
                new VentanaDatosUsuario(
                        rolUsuario,
                        this
                );

        javax.swing.JPanel formulario =
                ventana.obtenerPanelDatosUsuario();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    public void mostrarEditarUsuario(
            int idUsuario,
            String usuario,
            String rol
    ) {

        VentanaDatosUsuario ventana =
                new VentanaDatosUsuario(
                        idUsuario,
                        usuario,
                        rol,
                        rolUsuario,
                        this
                );

        javax.swing.JPanel formulario =
                ventana.obtenerPanelDatosUsuario();

        panelContenido.removeAll();

        panelContenido.add(
                formulario,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlertas;
    private javax.swing.JButton btnAnimales;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnProcedimientos;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReportesVentas;
    private javax.swing.JButton btnTurnos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel lblAlertaProductos;
    private javax.swing.JLabel lblAlertaTurnos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloNotificaciones;
    private javax.swing.JPanel pnlNotificaciones;
    // End of variables declaration//GEN-END:variables
}
