package sistemaveterinaria;
import excepciones.UsuarioNoAutorizadoException;
import controller.ProductoController;
import controller.TurnoController;
public class VentanaPrincipal extends javax.swing.JFrame {
private String rolUsuario;
private static boolean alertaProductosMostrada = false;
private static boolean alertaTurnosMostrada = false;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    public VentanaPrincipal() {
        initComponents();
    }
    public VentanaPrincipal(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
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

        btnReportesVentas.setText("Reportes de ventas");
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
        VentanaTurnos vt = new VentanaTurnos(rolUsuario);
        vt.setVisible(true);
    
        this.dispose();
    }//GEN-LAST:event_btnTurnosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        VentanaClientes vc = new VentanaClientes(rolUsuario);
        vc.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        VentanaProductos vp = new VentanaProductos(rolUsuario);
        vp.setVisible(true);

        this.dispose();     
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        VentanaVentas vv = new VentanaVentas(rolUsuario);
        vv.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        try {

            if (!"ADMINISTRADOR".equals(rolUsuario)) {
                throw new UsuarioNoAutorizadoException(
                        "No tiene permisos para acceder a la gestión de usuarios"
                );
            }

            VentanaUsuarios vu = new VentanaUsuarios(rolUsuario);
            vu.setVisible(true);

            this.dispose();

        } catch (UsuarioNoAutorizadoException e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimalesActionPerformed
 
    VentanaAnimales va =
            new VentanaAnimales(rolUsuario);

    va.setVisible(true);

    this.dispose();

    }//GEN-LAST:event_btnAnimalesActionPerformed

    private void btnProcedimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcedimientosActionPerformed
        VentanaProcedimientos vp =
                new VentanaProcedimientos(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnProcedimientosActionPerformed

    private void btnAlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertasActionPerformed
        VentanaAlertas va =
                new VentanaAlertas(rolUsuario);

        va.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnAlertasActionPerformed

    private void btnReportesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesVentasActionPerformed
        VentanaReportesVentas vrv =
                new VentanaReportesVentas(rolUsuario);

        vrv.setVisible(true);

        this.dispose();
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
