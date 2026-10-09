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
    private javax.swing.JPanel panelSubmenuAnimales;
    private javax.swing.JButton btnGestionAnimales;
    private javax.swing.JButton btnCatalogoAnimales;
    private javax.swing.JLabel lblFlechaAnimales;
    private boolean submenuAnimalesVisible = false;
    private javax.swing.JPanel panelSubmenuTurnos;
    private javax.swing.JButton btnGestionTurnos;
    private javax.swing.JButton btnTurnosVencidos;
    private javax.swing.JLabel lblFlechaTurnos;
    private boolean submenuTurnosVisible = false;
    private javax.swing.JPanel panelSubmenuProcedimientos;
    private javax.swing.JButton btnGestionProcedimientos;
    private javax.swing.JButton btnTiposProcedimiento;
    private javax.swing.JLabel lblFlechaProcedimientos;
    private boolean submenuProcedimientosVisible = false;
    private javax.swing.JPanel panelSubmenuProductos;
    private javax.swing.JButton btnGestionProductos;
    private javax.swing.JButton btnMarcas;
    private javax.swing.JLabel lblFlechaProductos;
    private boolean submenuProductosVisible = false;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JButton btnAuditoria;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JPanel contenedorNotificaciones;
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
    private boolean bloquearAccesoVeterinario(
            String modulo
    ) {

        if (!"VETERINARIO".equalsIgnoreCase(
                rolUsuario
        )) {

            return false;
        }

        Estilos.mostrarAdvertencia(
                this,
                "Acceso denegado",
                "El veterinario no tiene permisos para acceder a "
                + modulo
        );

        return true;
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
        cerrarOtrosSubmenus(
                panelSubmenuTurnos
        );
        submenuTurnosVisible =
                !submenuTurnosVisible;

        panelSubmenuTurnos.setVisible(
                submenuTurnosVisible
        );

        String rutaFlecha =
                submenuTurnosVisible
                        ? "/imagenes/iconos/flecha_arriba.png"
                        : "/imagenes/iconos/flecha_abajo.png";

        javax.swing.ImageIcon iconoFlecha =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                rutaFlecha
                        )
                );

        lblFlechaTurnos.setIcon(
                new javax.swing.ImageIcon(
                        iconoFlecha.getImage().getScaledInstance(
                                18,
                                18,
                                java.awt.Image.SCALE_SMOOTH
                        )
                )
        );

        panelMenu.revalidate();
        panelMenu.repaint();
    }//GEN-LAST:event_btnTurnosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
           mostrarClientes();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
            cerrarOtrosSubmenus(
               panelSubmenuProductos
       );

       submenuProductosVisible =
               !submenuProductosVisible;

       panelSubmenuProductos.setVisible(
               submenuProductosVisible
       );

       String rutaFlecha =
               submenuProductosVisible
                       ? "/imagenes/iconos/flecha_arriba.png"
                       : "/imagenes/iconos/flecha_abajo.png";

       javax.swing.ImageIcon iconoFlecha =
               new javax.swing.ImageIcon(
                       getClass().getResource(
                               rutaFlecha
                       )
               );

       lblFlechaProductos.setIcon(
               new javax.swing.ImageIcon(
                       iconoFlecha.getImage()
                               .getScaledInstance(
                                       18,
                                       18,
                                       java.awt.Image.SCALE_SMOOTH
                               )
               )
       );

       panelMenu.revalidate();
       panelMenu.repaint();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        if (bloquearAccesoVeterinario(
               "la gestión de ventas"
       )) {

           return;
       }

       mostrarVentas();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        try {

            if (!"ADMINISTRADOR".equals(rolUsuario)) {
                throw new UsuarioNoAutorizadoException(
                        "No tiene permisos para acceder a la gestión de usuarios"
                );
            }

            btnUsuarios.setBackground(
                    new java.awt.Color(
                            70,
                            145,
                            215
                    )
            );

            mostrarUsuarios();

        } catch (UsuarioNoAutorizadoException e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Acceso denegado",
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimalesActionPerformed
        cerrarOtrosSubmenus(
                panelSubmenuAnimales
        );
        submenuAnimalesVisible =
                !submenuAnimalesVisible;

        panelSubmenuAnimales.setVisible(
                submenuAnimalesVisible
        );

        String rutaFlecha =
                submenuAnimalesVisible
                        ? "/imagenes/iconos/flecha_arriba.png"
                        : "/imagenes/iconos/flecha_abajo.png";

        javax.swing.ImageIcon iconoFlecha =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                rutaFlecha
                        )
                );

        lblFlechaAnimales.setIcon(
                new javax.swing.ImageIcon(
                        iconoFlecha.getImage().getScaledInstance(
                                18,
                                18,
                                java.awt.Image.SCALE_SMOOTH
                        )
                )
        );

        panelMenu.revalidate();
        panelMenu.repaint();
    }//GEN-LAST:event_btnAnimalesActionPerformed

    private void btnProcedimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcedimientosActionPerformed
        cerrarOtrosSubmenus(
                panelSubmenuProcedimientos
        );
        submenuProcedimientosVisible =
                !submenuProcedimientosVisible;

        panelSubmenuProcedimientos.setVisible(
                submenuProcedimientosVisible
        );

        String rutaFlecha =
                submenuProcedimientosVisible
                        ? "/imagenes/iconos/flecha_arriba.png"
                        : "/imagenes/iconos/flecha_abajo.png";

        javax.swing.ImageIcon iconoFlecha =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                rutaFlecha
                        )
                );

        lblFlechaProcedimientos.setIcon(
                new javax.swing.ImageIcon(
                        iconoFlecha.getImage().getScaledInstance(
                                18,
                                18,
                                java.awt.Image.SCALE_SMOOTH
                        )
                )
        );

        panelMenu.revalidate();
        panelMenu.repaint();
    }//GEN-LAST:event_btnProcedimientosActionPerformed

    private void btnAlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertasActionPerformed
        mostrarAlertas();
        btnAlertas.setBackground(
                new java.awt.Color(
                        243,
                        156,
                        18
                )
        );
    }//GEN-LAST:event_btnAlertasActionPerformed

    private void btnReportesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesVentasActionPerformed
        if (bloquearAccesoVeterinario(
                "los reportes"
        )) {

            return;
        }

        mostrarReportes();
    }//GEN-LAST:event_btnReportesVentasActionPerformed
    
    private void revisarAlertasProductos() {

        int cantidad =
                ProductoController.contarProximosAVencer();

        boolean panelNotificacionesVisible =
                contenedorNotificaciones != null
                && contenedorNotificaciones.getParent()
                        == panelContenido;

        if (cantidad > 0) {

            if (panelNotificacionesVisible) {

                lblAlertaProductos.setText(
                        cantidad
                        + " producto(s) por vencer"
                );
            }

            if (!alertaProductosMostrada) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Alerta de vencimiento",
                        "Hay "
                        + cantidad
                        + " producto(s) que vencen en los próximos 7 días."
                );

                alertaProductosMostrada =
                        true;
            }

        } else {

            if (panelNotificacionesVisible) {

                lblAlertaProductos.setText(
                        "Sin productos por vencer"
                );
            }
        }
    }

        private void revisarAlertasTurnos() {

        int cantidad =
                TurnoController.contarTurnosProximos();

        if (cantidad > 0) {

            lblAlertaTurnos.setText(
                    cantidad
                    + " turno(s) próximo(s)"
            );

            if (!alertaTurnosMostrada) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Alerta de turnos",
                        "Hay " + cantidad
                        + " turno(s) programado(s) para hoy o mañana."
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
                new java.awt.Dimension(
                        320,
                        0
                )
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
                "Menú principal"
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
        btnProcedimientos.setText(
                "Procedimientos médicos"
        );
        Estilos.estilizarBotonMenu(btnProductos);
        Estilos.estilizarBotonMenu(btnVentas);
        Estilos.estilizarBotonMenu(btnReportesVentas);
        Estilos.estilizarBotonMenu(btnAlertas);
        Estilos.estilizarBotonMenu(btnUsuarios);
        
        btnAnimales.setText(
                "Animales"
        );

        Estilos.aplicarIcono(
                btnAnimales,
                "/imagenes/iconos/animales.png",
                18,
                18
        );
        

        btnAnimales.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaAnimales =
                new javax.swing.JLabel();

        javax.swing.ImageIcon iconoFlecha =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/iconos/flecha_abajo.png"
                        )
                );

        lblFlechaAnimales.setIcon(
                new javax.swing.ImageIcon(
                        iconoFlecha.getImage().getScaledInstance(
                                17,
                                17,
                                java.awt.Image.SCALE_SMOOTH
                        )
                )
        );

        btnAnimales.setLayout(null);

        lblFlechaAnimales.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaAnimales.setVerticalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaAnimales.setBounds(
                4,
                0,
                20,
                38
        );
        btnAnimales.add(
                lblFlechaAnimales
        );

        lblFlechaAnimales.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent evt
                    ) {
                        btnAnimales.doClick();
                    }
                }
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
        btnTurnos.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaTurnos =
                new javax.swing.JLabel();

        javax.swing.ImageIcon iconoFlechaTurnos =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/iconos/flecha_abajo.png"
                        )
                );

        lblFlechaTurnos.setIcon(
                new javax.swing.ImageIcon(
                        iconoFlechaTurnos.getImage().getScaledInstance(
                                18,
                                18,
                                java.awt.Image.SCALE_SMOOTH
                        )
                )
        );

        btnTurnos.setLayout(null);

        lblFlechaTurnos.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaTurnos.setVerticalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaTurnos.setBounds(
                4,
                0,
                20,
                38
        );

        btnTurnos.add(
                lblFlechaTurnos
        );

        lblFlechaTurnos.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent evt
                    ) {
                        btnTurnos.doClick();
                    }
                }
        );
        Estilos.aplicarIcono(
                btnProcedimientos,
                "/imagenes/iconos/procedimientos.png",
                18,
                18
        );
        
        btnProcedimientos.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaProcedimientos =
                new javax.swing.JLabel();

        javax.swing.ImageIcon iconoFlechaProcedimientos =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/iconos/flecha_abajo.png"
                        )
                );

        lblFlechaProcedimientos.setIcon(
                new javax.swing.ImageIcon(
                        iconoFlechaProcedimientos.getImage().getScaledInstance(
                                18,
                                18,
                                java.awt.Image.SCALE_SMOOTH
                        )
                )
        );

        btnProcedimientos.setLayout(null);

        lblFlechaProcedimientos.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaProcedimientos.setVerticalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaProcedimientos.setBounds(
                4,
                0,
                20,
                38
        );

        btnProcedimientos.add(
                lblFlechaProcedimientos
        );

        lblFlechaProcedimientos.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent evt
                    ) {
                        btnProcedimientos.doClick();
                    }
                }
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
        
       
        configurarSubmenuAnimales();
        configurarSubmenuTurnos();
        configurarSubmenuProcedimientos();
        configurarSubmenuProductos();

        panelMenu.add(btnAnimales);
        panelMenu.add(
                panelSubmenuAnimales
        );
        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnClientes);

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnTurnos);

        panelMenu.add(
                panelSubmenuTurnos
        );

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(btnProcedimientos);

        panelMenu.add(
                panelSubmenuProcedimientos
        );

        panelMenu.add(
                javax.swing.Box.createVerticalStrut(8)
        );

        panelMenu.add(
                btnProductos
        );

        panelMenu.add(
                panelSubmenuProductos
        );

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
        btnProductos.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaProductos =
                new javax.swing.JLabel();

        javax.swing.ImageIcon iconoFlechaProductos =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/iconos/flecha_abajo.png"
                        )
                );

        lblFlechaProductos.setIcon(
                new javax.swing.ImageIcon(
                        iconoFlechaProductos
                                .getImage()
                                .getScaledInstance(
                                        18,
                                        18,
                                        java.awt.Image.SCALE_SMOOTH
                                )
                )
        );

        btnProductos.setLayout(
                null
        );

        lblFlechaProductos.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaProductos.setVerticalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        lblFlechaProductos.setBounds(
                4,
                0,
                20,
                38
        );

        btnProductos.add(
                lblFlechaProductos
        );

        lblFlechaProductos.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent evt
                    ) {

                        btnProductos.doClick();
                    }
                }
        );
        java.awt.Dimension tamañoCerrarSesion =
                new java.awt.Dimension(
                        280,
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
        
        panelSuperior =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelSuperior.setOpaque(false);

        panelSuperior.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        20,
                        30,
                        10,
                        30
                )
        );

        javax.swing.JPanel panelSesion =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                8,
                                8
                        )
                );

        panelSesion.setBackground(
                Estilos.BLANCO
        );
       
        panelSesion.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createMatteBorder(
                                0,
                                0,
                                6,
                                6,
                                new java.awt.Color(
                                        24,
                                        135,
                                        95
                                )
                        ),
                        javax.swing.BorderFactory.createCompoundBorder(
                                javax.swing.BorderFactory.createLineBorder(
                                        Estilos.VERDE_OSCURO,
                                        1,
                                        true
                                ),
                                javax.swing.BorderFactory.createEmptyBorder(
                                        2,
                                        10,
                                        2,
                                        10
                                )
                        )
                )
        );

        String nombreCuenta =
                SesionUsuario.getNombreUsuario();

        String rolMostrado =
                SesionUsuario.getRol();

        if (nombreCuenta == null
                || nombreCuenta.isBlank()) {

            nombreCuenta =
                    "Sin usuario";
        }

        if (rolMostrado == null
                || rolMostrado.isBlank()) {

            rolMostrado =
                    rolUsuario == null
                            ? "Sin rol"
                            : rolUsuario;
        }

        lblRolSesion =
                new javax.swing.JLabel(
                        "Sesión actual: "
                        + nombreCuenta
                        + "  |  Rol: "
                        + rolMostrado.toLowerCase()
                );

        lblRolSesion.setFont(
                Estilos.fuente(13f)
        );

        lblRolSesion.setForeground(
                Estilos.VERDE_OSCURO
        );

        panelSesion.add(lblRolSesion);
                btnPerfil =
                new javax.swing.JButton();

        btnPerfil.setToolTipText(
                "Ver información de mi cuenta"
        );

        Estilos.estilizarBoton(
                btnPerfil
        );

        Estilos.aplicarIcono(
                btnPerfil,
                "/imagenes/iconos/usuarios.png",
                18,
                18
        );

        java.awt.Dimension tamañoPerfil =
                new java.awt.Dimension(
                        38,
                        32
                );

        btnPerfil.setPreferredSize(
                tamañoPerfil
        );

        btnPerfil.setMinimumSize(
                tamañoPerfil
        );

        btnPerfil.setMaximumSize(
                tamañoPerfil
        );

        btnPerfil.setMargin(
                new java.awt.Insets(
                        0,
                        0,
                        0,
                        0
                )
        );

        btnPerfil.addActionListener(
                evento -> mostrarInformacionUsuario()
        );

        panelSesion.add(
                btnPerfil
        );

        javax.swing.JPanel panelAccesos =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        panelAccesos.setOpaque(false);
        btnAuditoria =
                new javax.swing.JButton(
                        "Auditoría"
                );

        Estilos.estilizarBoton(
                btnAuditoria
        );
        btnAuditoria.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent evento
                    ) {

                        btnAuditoria.setBackground(
                                new java.awt.Color(
                                        25,
                                        135,
                                        95
                                )
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evento
                    ) {

                        btnAuditoria.setBackground(
                                Estilos.VERDE_OSCURO
                        );
                    }
                }
        );
        Estilos.aplicarIcono(
                btnAuditoria,
                "/imagenes/iconos/historial.png",
                18,
                18
        );

        btnAuditoria.addActionListener(
                evento -> {

                    if (!"ADMINISTRADOR".equalsIgnoreCase(
                            rolUsuario
                    )) {

                        Estilos.mostrarAdvertencia(
                                this,
                                "Acceso denegado",
                                "Solo los administradores pueden acceder a la auditoría"
                        );

                        return;
                    }

                    btnAuditoria.setBackground(
                            Estilos.VERDE_OSCURO
                    );

                    mostrarAuditoria();
                }
        );
        Estilos.estilizarBotonVencidos(
                btnAlertas
        );
        Estilos.estilizarBotonEditar(
                btnUsuarios
        );

        btnAlertas.setPreferredSize(
                new java.awt.Dimension(145, 40)
        );

        btnUsuarios.setPreferredSize(
                new java.awt.Dimension(145, 40)
        );
        btnAuditoria.setPreferredSize(
                new java.awt.Dimension(
                        145,
                        40
                )
        );
        panelAccesos.add(
                btnAlertas
        );

        panelAccesos.add(
                btnAuditoria
        );

        panelAccesos.add(
                btnUsuarios
        );

        panelSuperior.add(
                panelSesion,
                java.awt.BorderLayout.WEST
        );

        panelSuperior.add(
                panelAccesos,
                java.awt.BorderLayout.EAST
        );

        panelContenido.add(
                panelSuperior,
                java.awt.BorderLayout.NORTH
        );


        panelBienvenida =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        panelBienvenida.setOpaque(false);

        javax.swing.JPanel contenidoBienvenida =
                new javax.swing.JPanel();

        contenidoBienvenida.setOpaque(false);

        contenidoBienvenida.setLayout(
                new javax.swing.BoxLayout(
                        contenidoBienvenida,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        javax.swing.JLabel lblBienvenido =
                new javax.swing.JLabel(
                        "Bienvenido a"
                );

        lblBienvenido.setFont(
                Estilos.fuente(32f)
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
                Estilos.fuente(48f)
        );

        lblBienvenida.setForeground(
                Estilos.BLANCO
        );

        lblBienvenida.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        contenidoBienvenida.add(lblBienvenido);

        contenidoBienvenida.add(
                javax.swing.Box.createVerticalStrut(10)
        );

        contenidoBienvenida.add(lblBienvenida);

        java.awt.GridBagConstraints gbcBienvenida =
                new java.awt.GridBagConstraints();

        gbcBienvenida.gridx = 0;
        gbcBienvenida.gridy = 0;
        gbcBienvenida.anchor =
                java.awt.GridBagConstraints.CENTER;

        gbcBienvenida.insets =
                new java.awt.Insets(
                        0,
                        0,
                        20,
                        0
                );

        panelBienvenida.add(
                contenidoBienvenida,
                gbcBienvenida
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
                        390
                )
        );

        panelNotificaciones.setLayout(
                new javax.swing.BoxLayout(
                        panelNotificaciones,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );
        
        panelBienvenida.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        0,
                        0,
                        45,
                        0
                )
        );

        panelNotificaciones.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createMatteBorder(
                                0,
                                0,
                                8,
                                8,
                                new java.awt.Color(
                                        24,
                                        135,
                                        95
                                )
                        ),
                        javax.swing.BorderFactory.createCompoundBorder(
                                javax.swing.BorderFactory.createLineBorder(
                                        Estilos.VERDE_OSCURO,
                                        1,
                                        true
                                ),
                                javax.swing.BorderFactory.createEmptyBorder(
                                        35,
                                        25,
                                        35,
                                        25
                                )
                        )
                )
        );

        lblTituloNotificaciones.setText(
                "Notificaciones"
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
                        javax.swing.BorderFactory.createMatteBorder(
                                0,
                                0,
                                5,
                                5,
                                new java.awt.Color(
                                        190,
                                        220,
                                        208
                                )
                        ),
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

     

        javax.swing.JLabel tituloTurnos =
                new javax.swing.JLabel(
                        "Turnos próximos"
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

        javax.swing.JPanel panelMensajeTurnos =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                8,
                                0
                        )
                );

        panelMensajeTurnos.setOpaque(false);

        javax.swing.ImageIcon iconoCampana =
                Estilos.crearIconoColor(
                        "/imagenes/iconos/alertas.png",
                        18,
                        18,
                        Estilos.VERDE_OSCURO
                );

        javax.swing.JLabel lblCampanaTurnos =
                new javax.swing.JLabel(
                        iconoCampana
                );

        lblCampanaTurnos.setOpaque(false);
        lblCampanaTurnos.setBorder(null);

        panelMensajeTurnos.add(
                lblCampanaTurnos,
                java.awt.BorderLayout.WEST
        );

        panelMensajeTurnos.add(
                lblAlertaTurnos,
                java.awt.BorderLayout.CENTER
        );

        tarjetaTurnos.add(
                panelMensajeTurnos,
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
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createMatteBorder(
                                0,
                                0,
                                5,
                                5,
                                new java.awt.Color(
                                        190,
                                        220,
                                        208
                                )
                        ),
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
                )
        );

        javax.swing.JLabel tituloProductos =
                new javax.swing.JLabel(
                        "Productos por vencer"
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

        javax.swing.JPanel panelMensajeProductos =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                8,
                                0
                        )
                );

        panelMensajeProductos.setOpaque(false);

        javax.swing.JLabel lblCampanaProductos =
                new javax.swing.JLabel(
                        iconoCampana
                );

        lblCampanaProductos.setOpaque(false);
        lblCampanaProductos.setBorder(null);

        panelMensajeProductos.add(
                lblCampanaProductos,
                java.awt.BorderLayout.WEST
        );

        panelMensajeProductos.add(
                lblAlertaProductos,
                java.awt.BorderLayout.CENTER
        );

        tarjetaProductos.add(
                panelMensajeProductos,
                java.awt.BorderLayout.CENTER
        );

        panelNotificaciones.add(
                tarjetaProductos
        );

        contenedorNotificaciones =
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
                java.awt.BorderLayout.NORTH
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
    public void mostrarInicio() {

        cerrarOtrosSubmenus(
                null
        );

        panelContenido.removeAll();

        panelContenido.add(
                panelSuperior,
                java.awt.BorderLayout.NORTH
        );

        panelContenido.add(
                panelBienvenida,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.add(
                contenedorNotificaciones,
                java.awt.BorderLayout.EAST
        );

        revisarAlertasProductos();
        revisarAlertasTurnos();

        panelContenido.revalidate();
        panelContenido.repaint();
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
    private void configurarSubmenuAnimales() {

        panelSubmenuAnimales =
                new javax.swing.JPanel();

        panelSubmenuAnimales.setOpaque(false);

        panelSubmenuAnimales.setLayout(
                new javax.swing.BoxLayout(
                        panelSubmenuAnimales,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        btnGestionAnimales =
                new javax.swing.JButton(
                        " • Gestión de animales"
                );

        btnCatalogoAnimales =
                new javax.swing.JButton(
                        " • Especies y razas"
                );
        btnGestionAnimales.setHorizontalAlignment(
                javax.swing.SwingConstants.LEFT
        );

        btnCatalogoAnimales.setHorizontalAlignment(
                javax.swing.SwingConstants.LEFT
        );

        Estilos.estilizarBotonSubmenu(
                btnGestionAnimales
        );

        Estilos.estilizarBotonSubmenu(
                btnCatalogoAnimales
        );

        java.awt.Dimension tamañoSubmenu =
                new java.awt.Dimension(
                        270,
                        32
                );

        btnGestionAnimales.setPreferredSize(
                tamañoSubmenu
        );

        btnGestionAnimales.setMinimumSize(
                tamañoSubmenu
        );

        btnGestionAnimales.setMaximumSize(
                tamañoSubmenu
        );

        btnCatalogoAnimales.setPreferredSize(
                tamañoSubmenu
        );

        btnCatalogoAnimales.setMinimumSize(
                tamañoSubmenu
        );

        btnCatalogoAnimales.setMaximumSize(
                tamañoSubmenu
        );

        btnGestionAnimales.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnCatalogoAnimales.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnGestionAnimales.setFont(
                Estilos.fuente(12f)
        );

        btnCatalogoAnimales.setFont(
                Estilos.fuente(12f)
        );
        
        btnGestionAnimales.setMargin(
                new java.awt.Insets(
                        0,
                        12,
                        0,
                        2
                )
        );

        btnCatalogoAnimales.setMargin(
                new java.awt.Insets(
                        0,
                        12,
                        0,
                        2
                )
        );

        btnGestionAnimales.addActionListener(e ->
                mostrarAnimales()
        );

        btnCatalogoAnimales.addActionListener(e ->
                mostrarCatalogoAnimales()
        );

        panelSubmenuAnimales.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        panelSubmenuAnimales.add(
                btnGestionAnimales
        );

        panelSubmenuAnimales.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        panelSubmenuAnimales.add(
                btnCatalogoAnimales
        );

        panelSubmenuAnimales.add(
                javax.swing.Box.createVerticalStrut(3)
        );

        panelSubmenuAnimales.setVisible(false);
    }
    private void configurarSubmenuTurnos() {

        panelSubmenuTurnos =
                new javax.swing.JPanel();

        panelSubmenuTurnos.setOpaque(false);

        panelSubmenuTurnos.setLayout(
                new javax.swing.BoxLayout(
                        panelSubmenuTurnos,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        btnGestionTurnos =
                new javax.swing.JButton(
                        " • Gestión de turnos"
                );

        btnTurnosVencidos =
                new javax.swing.JButton(
                        " • Turnos vencidos"
                );

        btnGestionTurnos.setHorizontalAlignment(
                javax.swing.SwingConstants.LEFT
        );

        btnTurnosVencidos.setHorizontalAlignment(
                javax.swing.SwingConstants.LEFT
        );

        Estilos.estilizarBotonSubmenu(
                btnGestionTurnos
        );

        Estilos.estilizarBotonSubmenu(
                btnTurnosVencidos
        );

        java.awt.Dimension tamañoSubmenu =
                new java.awt.Dimension(
                        270,
                        32
                );

        btnGestionTurnos.setPreferredSize(
                tamañoSubmenu
        );

        btnGestionTurnos.setMinimumSize(
                tamañoSubmenu
        );

        btnGestionTurnos.setMaximumSize(
                tamañoSubmenu
        );

        btnTurnosVencidos.setPreferredSize(
                tamañoSubmenu
        );

        btnTurnosVencidos.setMinimumSize(
                tamañoSubmenu
        );

        btnTurnosVencidos.setMaximumSize(
                tamañoSubmenu
        );

        btnGestionTurnos.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnTurnosVencidos.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnGestionTurnos.setFont(
                Estilos.fuente(12f)
        );

        btnTurnosVencidos.setFont(
                Estilos.fuente(12f)
        );

        btnGestionTurnos.setMargin(
                new java.awt.Insets(
                        0,
                        12,
                        0,
                        2
                )
        );

        btnTurnosVencidos.setMargin(
                new java.awt.Insets(
                        0,
                        12,
                        0,
                        2
                )
        );

        btnGestionTurnos.addActionListener(e ->
                mostrarTurnos()
        );

        btnTurnosVencidos.addActionListener(e ->
                mostrarTurnosVencidos()
        );

        panelSubmenuTurnos.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        panelSubmenuTurnos.add(
                btnGestionTurnos
        );

        panelSubmenuTurnos.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        panelSubmenuTurnos.add(
                btnTurnosVencidos
        );

        panelSubmenuTurnos.add(
                javax.swing.Box.createVerticalStrut(3)
        );

        panelSubmenuTurnos.setVisible(false);
    }
    private void configurarSubmenuProcedimientos() {

        panelSubmenuProcedimientos =
                new javax.swing.JPanel();

        panelSubmenuProcedimientos.setOpaque(false);

        panelSubmenuProcedimientos.setLayout(
                new javax.swing.BoxLayout(
                        panelSubmenuProcedimientos,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        btnGestionProcedimientos =
                new javax.swing.JButton(
                        " • Gestión de procedimientos"
                );

        btnTiposProcedimiento =
                new javax.swing.JButton(
                        " • Tipos de procedimiento"
                );

        btnGestionProcedimientos.setHorizontalAlignment(
                javax.swing.SwingConstants.LEFT
        );

        btnTiposProcedimiento.setHorizontalAlignment(
                javax.swing.SwingConstants.LEFT
        );

        Estilos.estilizarBotonSubmenu(
                btnGestionProcedimientos
        );

        Estilos.estilizarBotonSubmenu(
                btnTiposProcedimiento
        );

        java.awt.Dimension tamañoSubmenu =
                new java.awt.Dimension(
                        270,
                        32
                );

        btnGestionProcedimientos.setPreferredSize(
                tamañoSubmenu
        );

        btnGestionProcedimientos.setMinimumSize(
                tamañoSubmenu
        );

        btnGestionProcedimientos.setMaximumSize(
                tamañoSubmenu
        );

        btnTiposProcedimiento.setPreferredSize(
                tamañoSubmenu
        );

        btnTiposProcedimiento.setMinimumSize(
                tamañoSubmenu
        );

        btnTiposProcedimiento.setMaximumSize(
                tamañoSubmenu
        );

        btnGestionProcedimientos.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnTiposProcedimiento.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnGestionProcedimientos.setFont(
                Estilos.fuente(12f)
        );

        btnTiposProcedimiento.setFont(
                Estilos.fuente(12f)
        );

        btnGestionProcedimientos.setMargin(
                new java.awt.Insets(
                        0,
                        12,
                        0,
                        2
                )
        );

        btnTiposProcedimiento.setMargin(
                new java.awt.Insets(
                        0,
                        12,
                        0,
                        2
                )
        );

        btnGestionProcedimientos.addActionListener(e ->
                mostrarProcedimientos()
        );

        btnTiposProcedimiento.addActionListener(e ->
                mostrarTiposProcedimiento()
        );

        panelSubmenuProcedimientos.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        panelSubmenuProcedimientos.add(
                btnGestionProcedimientos
        );

        panelSubmenuProcedimientos.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        panelSubmenuProcedimientos.add(
                btnTiposProcedimiento
        );

        panelSubmenuProcedimientos.add(
                javax.swing.Box.createVerticalStrut(3)
        );

        panelSubmenuProcedimientos.setVisible(false);
    }
    private void cerrarOtrosSubmenus(
            javax.swing.JPanel submenuActivo
    ) {

        javax.swing.ImageIcon iconoOriginal =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/iconos/flecha_abajo.png"
                        )
                );

        javax.swing.ImageIcon flechaAbajo =
                new javax.swing.ImageIcon(
                        iconoOriginal.getImage().getScaledInstance(
                                18,
                                18,
                                java.awt.Image.SCALE_SMOOTH
                        )
                );

        if (submenuActivo != panelSubmenuAnimales) {

            submenuAnimalesVisible = false;

            panelSubmenuAnimales.setVisible(
                    false
            );

            lblFlechaAnimales.setIcon(
                    flechaAbajo
            );
        }

        if (submenuActivo != panelSubmenuTurnos) {

            submenuTurnosVisible = false;

            panelSubmenuTurnos.setVisible(
                    false
            );

            lblFlechaTurnos.setIcon(
                    flechaAbajo
            );
        }

        if (submenuActivo != panelSubmenuProcedimientos) {

            submenuProcedimientosVisible = false;

            panelSubmenuProcedimientos.setVisible(
                    false
            );

            lblFlechaProcedimientos.setIcon(
                    flechaAbajo
            );
        }
        if (submenuActivo != panelSubmenuProductos) {

            submenuProductosVisible =
                    false;

            panelSubmenuProductos.setVisible(
                    false
            );

            lblFlechaProductos.setIcon(
                    flechaAbajo
            );
        }
    }
    private void configurarSubmenuProductos() {

        panelSubmenuProductos =
                new javax.swing.JPanel();

        panelSubmenuProductos.setOpaque(
                false
        );

        panelSubmenuProductos.setLayout(
                new javax.swing.BoxLayout(
                        panelSubmenuProductos,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        btnGestionProductos =
                new javax.swing.JButton(
                        " • Gestión de productos"
                );

        btnMarcas =
                new javax.swing.JButton(
                        " • Marcas"
                );

        btnGestionProductos.setHorizontalAlignment(
                javax.swing.SwingConstants.LEFT
        );

        btnMarcas.setHorizontalAlignment(
                javax.swing.SwingConstants.LEFT
        );

        Estilos.estilizarBotonSubmenu(
                btnGestionProductos
        );

        Estilos.estilizarBotonSubmenu(
                btnMarcas
        );

        java.awt.Dimension tamañoSubmenu =
                new java.awt.Dimension(
                        270,
                        32
                );

        btnGestionProductos.setPreferredSize(
                tamañoSubmenu
        );

        btnGestionProductos.setMinimumSize(
                tamañoSubmenu
        );

        btnGestionProductos.setMaximumSize(
                tamañoSubmenu
        );

        btnMarcas.setPreferredSize(
                tamañoSubmenu
        );

        btnMarcas.setMinimumSize(
                tamañoSubmenu
        );

        btnMarcas.setMaximumSize(
                tamañoSubmenu
        );

        btnGestionProductos.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnMarcas.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        btnGestionProductos.setFont(
                Estilos.fuente(12f)
        );

        btnMarcas.setFont(
                Estilos.fuente(12f)
        );

        btnGestionProductos.setMargin(
                new java.awt.Insets(
                        0,
                        12,
                        0,
                        2
                )
        );

        btnMarcas.setMargin(
                new java.awt.Insets(
                        0,
                        12,
                        0,
                        2
                )
        );

        btnGestionProductos.addActionListener(
                evento -> {

                    if (bloquearAccesoVeterinario(
                            "la gestión de productos"
                    )) {

                        return;
                    }

                    mostrarProductos();
                }
        );

        btnMarcas.addActionListener(
                evento -> mostrarMarcas()
        );

        panelSubmenuProductos.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        panelSubmenuProductos.add(
                btnGestionProductos
        );

        panelSubmenuProductos.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        panelSubmenuProductos.add(
                btnMarcas
        );

        panelSubmenuProductos.add(
                javax.swing.Box.createVerticalStrut(3)
        );

        panelSubmenuProductos.setVisible(
                false
        );
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
    
    public void mostrarCatalogoAnimales() {

        PanelCatalogoAnimales catalogo =
                new PanelCatalogoAnimales(
                        this
                );

        panelContenido.removeAll();

        panelContenido.add(
                catalogo,
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
    public void mostrarTiposProcedimiento() {

        PanelTiposProcedimiento panelTipos =
                new PanelTiposProcedimiento(
                        this
                );

        panelContenido.removeAll();

        panelContenido.add(
                panelTipos,
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
    public void mostrarMarcas() {

        javax.swing.JPanel marcas =
                new PanelMarcas(
                        this
                );

        panelContenido.removeAll();

        panelContenido.add(
                marcas,
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
            String fechaVencimiento,
            String nombreMarca
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
                fechaVencimiento,
                nombreMarca
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
            String correo,
            String rol
    ) {

        VentanaDatosUsuario ventana =
                new VentanaDatosUsuario(
                        idUsuario,
                        usuario,
                        rol,
                        correo,
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
    
    public void mostrarAuditoria() {

        if (!"ADMINISTRADOR".equalsIgnoreCase(
                rolUsuario
        )) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Acceso denegado",
                    "Solo los administradores pueden acceder a la auditoría"
            );

            return;
        }

        PanelAuditoria panelAuditoria =
                new PanelAuditoria(
                        this
                );

        panelContenido.removeAll();

        panelContenido.add(
                panelAuditoria,
                java.awt.BorderLayout.CENTER
        );

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    private void mostrarInformacionUsuario() {

        modelo.Usuario usuarioActual =
                controller.UsuarioController
                        .obtenerUsuarioPorNombre(
                                SesionUsuario.getNombreUsuario()
                        );

        if (usuarioActual == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Mi perfil",
                    "No se pudo obtener la información de la cuenta"
            );

            return;
        }

        String correo =
                usuarioActual.getCorreo();

        if (correo == null
                || correo.isBlank()) {

            correo =
                    "No registrado";
        }

        String rol =
                usuarioActual.getRol();

        if (rol == null
                || rol.isBlank()) {

            rol =
                    "Sin rol";
        }

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        this,
                        true
                );

        dialogo.setUndecorated(
                true
        );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelPrincipal.setBackground(
                Estilos.BLANCO
        );

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        1
                )
        );

        javax.swing.JLabel titulo =
                new javax.swing.JLabel(
                        "Mi perfil",
                        javax.swing.SwingConstants.CENTER
                );

        titulo.setFont(
                Estilos.fuente(17f)
        );

        titulo.setForeground(
                Estilos.BLANCO
        );

        titulo.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        12,
                        20,
                        12,
                        20
                )
        );

        javax.swing.JPanel panelTitulo =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelTitulo.setBackground(
                Estilos.VERDE_OSCURO
        );

        panelTitulo.add(
                titulo,
                java.awt.BorderLayout.CENTER
        );

        javax.swing.JPanel panelInformacion =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        panelInformacion.setBackground(
                Estilos.BLANCO
        );

        panelInformacion.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        15,
                        30,
                        15,
                        30
                )
        );

        javax.swing.JLabel lblNombreTitulo =
                new javax.swing.JLabel(
                        "Nombre de usuario:",
                        javax.swing.SwingConstants.CENTER
                );

        javax.swing.JLabel lblNombreValor =
                new javax.swing.JLabel(
                        usuarioActual.getUsuario(),
                        javax.swing.SwingConstants.CENTER
                );

        javax.swing.JLabel lblCorreoTitulo =
                new javax.swing.JLabel(
                        "Correo electrónico:",
                        javax.swing.SwingConstants.CENTER
                );

        javax.swing.JLabel lblCorreoValor =
                new javax.swing.JLabel(
                        correo,
                        javax.swing.SwingConstants.CENTER
                );

        javax.swing.JLabel lblRolTitulo =
                new javax.swing.JLabel(
                        "Rol en el sistema:",
                        javax.swing.SwingConstants.CENTER
                );

        javax.swing.JLabel lblRolValor =
                new javax.swing.JLabel(
                        rol,
                        javax.swing.SwingConstants.CENTER
                );

        javax.swing.JLabel[] textos = {
            lblNombreTitulo,
            lblNombreValor,
            lblCorreoTitulo,
            lblCorreoValor,
            lblRolTitulo,
            lblRolValor
        };

        for (javax.swing.JLabel texto : textos) {

            texto.setFont(
                    Estilos.fuente(13f)
            );

            texto.setForeground(
                    Estilos.VERDE_OSCURO
            );
        }

        java.awt.GridBagConstraints datosGbc =
                new java.awt.GridBagConstraints();

        datosGbc.gridx = 0;
        datosGbc.weightx = 1;
        datosGbc.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        datosGbc.gridy = 0;
        datosGbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        5,
                        10
                );

        panelInformacion.add(
                lblNombreTitulo,
                datosGbc
        );

        datosGbc.gridy = 1;
        datosGbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        18,
                        10
                );

        panelInformacion.add(
                lblNombreValor,
                datosGbc
        );

        datosGbc.gridy = 2;
        datosGbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        5,
                        10
                );

        panelInformacion.add(
                lblCorreoTitulo,
                datosGbc
        );

        datosGbc.gridy = 3;
        datosGbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        18,
                        10
                );

        panelInformacion.add(
                lblCorreoValor,
                datosGbc
        );

        datosGbc.gridy = 4;
        datosGbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        5,
                        10
                );

        panelInformacion.add(
                lblRolTitulo,
                datosGbc
        );

        datosGbc.gridy = 5;
        datosGbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        0,
                        10
                );

        panelInformacion.add(
                lblRolValor,
                datosGbc
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
                        110,
                        38
                )
        );

        btnAceptar.addActionListener(
                evento -> dialogo.dispose()
        );

        javax.swing.JPanel panelBoton =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                10
                        )
                );

        panelBoton.setBackground(
                Estilos.BLANCO
        );

        panelBoton.add(
                btnAceptar
        );

        panelPrincipal.add(
                panelTitulo,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                panelInformacion,
                java.awt.BorderLayout.CENTER
        );

        panelPrincipal.add(
                panelBoton,
                java.awt.BorderLayout.SOUTH
        );

        dialogo.setContentPane(
                panelPrincipal
        );

        dialogo.setSize(
                400,
                315
        );

        dialogo.setLocationRelativeTo(
                this
        );

        dialogo.setVisible(
                true
        );
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
