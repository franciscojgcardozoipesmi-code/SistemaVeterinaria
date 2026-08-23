
package sistemaveterinaria;
import controller.ProductoController;
import controller.TurnoController;
public class VentanaAlertas extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAlertas.class.getName());

 
    public VentanaAlertas() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }
    
    public VentanaAlertas(String rolUsuario) {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.rolUsuario = rolUsuario;
    }

    private void cargarTurnosProximos() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Dueño");
        modelo.addColumn("DNI");
        modelo.addColumn("Animal");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Motivo");

        for (Object[] fila :
                TurnoController.listarTurnosProximos()) {

            modelo.addRow(fila);
        }

        tblAlertas.setModel(modelo);
    }
    private void cargarProductosProximosAVencer() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Stock");
        modelo.addColumn("Fecha vencimiento");

        for (Object[] fila :
                ProductoController.listarProximosAVencer()) {

            modelo.addRow(fila);
        }

        tblAlertas.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollAlertas = new javax.swing.JScrollPane();
        tblAlertas = new javax.swing.JTable();
        btnProductosVencer = new javax.swing.JButton();
        btnTurnosProximos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAlertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollAlertas.setViewportView(tblAlertas);

        btnProductosVencer.setText("Productos Vencer");
        btnProductosVencer.addActionListener(this::btnProductosVencerActionPerformed);

        btnTurnosProximos.setText("Turnos Proximos");
        btnTurnosProximos.addActionListener(this::btnTurnosProximosActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(scrollAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnProductosVencer)
                        .addGap(74, 74, 74)
                        .addComponent(btnTurnosProximos)
                        .addGap(70, 70, 70)
                        .addComponent(btnVolver)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scrollAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductosVencer)
                    .addComponent(btnTurnosProximos)
                    .addComponent(btnVolver))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
          VentanaPrincipal vp =
                new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnProductosVencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosVencerActionPerformed
        cargarProductosProximosAVencer();
    }//GEN-LAST:event_btnProductosVencerActionPerformed

    private void btnTurnosProximosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnosProximosActionPerformed
  

        cargarTurnosProximos();
    
    }//GEN-LAST:event_btnTurnosProximosActionPerformed

  
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new VentanaAlertas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductosVencer;
    private javax.swing.JButton btnTurnosProximos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollAlertas;
    private javax.swing.JTable tblAlertas;
    // End of variables declaration//GEN-END:variables
}
