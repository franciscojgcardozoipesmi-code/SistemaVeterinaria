
package sistemaveterinaria;
import controller.VentaController;

public class VentanaVentas extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaVentas.class.getName());

    public VentanaVentas() {
        initComponents();
        cargarVentas();
    }
    public VentanaVentas(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        cargarVentas();
    }
    private void cargarVentas() {
            javax.swing.table.DefaultTableModel modelo =
               new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Total");
        modelo.addColumn("Medio de pago");

       for (Object[] fila : VentaController.listarVentasConDetalle()) {
            modelo.addRow(fila);
        }

       tblVentas.setModel(modelo);
   }
       
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearVenta = new javax.swing.JButton();
        scrollVentas = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnEliminarVenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrearVenta.setText("Crear venta");
        btnCrearVenta.addActionListener(this::btnCrearVentaActionPerformed);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollVentas.setViewportView(tblVentas);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        btnEliminarVenta.setText("Anular venta");
        btnEliminarVenta.addActionListener(this::btnEliminarVentaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnEliminarVenta)
                        .addGap(26, 26, 26)
                        .addComponent(btnCrearVenta)
                        .addGap(27, 27, 27)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(scrollVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(scrollVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearVenta)
                    .addComponent(btnVolver)
                    .addComponent(btnEliminarVenta))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVentaActionPerformed
        VentanaCrearVenta vcv = new VentanaCrearVenta(rolUsuario);
        vcv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearVentaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp =
        new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        int fila = tblVentas.getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una venta para anular."
            );
            return;
        }

        int idVenta = Integer.parseInt(
                tblVentas.getValueAt(fila, 0).toString()
        );

        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea anular la venta seleccionada?",
                "Confirmar anulación",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {

            try {

                VentaController.eliminarVenta(idVenta);

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Venta anulada correctamente."
                );

                cargarVentas();

            } catch (Exception e) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Error al anular la venta: " + e.getMessage()
                );
            }
        }
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(() -> new VentanaVentas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearVenta;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollVentas;
    private javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables
}
