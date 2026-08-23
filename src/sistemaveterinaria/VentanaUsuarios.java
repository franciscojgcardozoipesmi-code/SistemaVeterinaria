
package sistemaveterinaria;
import controller.UsuarioController;
public class VentanaUsuarios extends javax.swing.JFrame {
    private String rolUsuario;
    private int idUsuario = -1;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName());

   
    public VentanaUsuarios() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarTabla();
    }

    public VentanaUsuarios(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarTabla();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnEditarUsuario = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsuarios);

        btnEditarUsuario.setText("Editar usuario");
        btnEditarUsuario.addActionListener(this::btnEditarUsuarioActionPerformed);

        btnCrearUsuario.setText("Crear usuario");
        btnCrearUsuario.addActionListener(this::btnCrearUsuarioActionPerformed);

        btnEliminarUsuario.setText("Eliminar usuario");
        btnEliminarUsuario.addActionListener(this::btnEliminarUsuarioActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnEditarUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnCrearUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnEliminarUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnEliminarUsuario)
                        .addGap(53, 53, 53)
                        .addComponent(btnCrearUsuario)
                        .addGap(33, 33, 33)
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp = new VentanaPrincipal(rolUsuario);
        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        int fila = tblUsuarios.getSelectedRow();

        if (fila == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un usuario"
            );

            return;
        }

        int idUsuario = Integer.parseInt(
                tblUsuarios.getValueAt(fila, 0).toString()
        );

        String usuario =
                tblUsuarios.getValueAt(fila, 1).toString();

        String rol =
                tblUsuarios.getValueAt(fila, 2).toString();

        VentanaDatosUsuario vdu =
                new VentanaDatosUsuario(
                        idUsuario,
                        usuario,
                        rol,
                        rolUsuario
                );

        vdu.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        VentanaDatosUsuario vdu =
                new VentanaDatosUsuario(rolUsuario);

        vdu.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        int fila = tblUsuarios.getSelectedRow();

        if (fila == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un usuario"
            );

            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que querés eliminar este usuario?",
                "Confirmar eliminación",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (opcion != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        int idUsuario = Integer.parseInt(
                tblUsuarios.getValueAt(fila, 0).toString()
        );

        UsuarioController.eliminarUsuario(idUsuario);

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Usuario eliminado correctamente"
        );

        cargarTabla();
    
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new VentanaUsuarios().setVisible(true));
    }
    
    private void cargarTabla() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Rol");

        for (Object[] fila : UsuarioController.listarUsuarios()) {

            modelo.addRow(new Object[]{
                fila[0],
                fila[1],
                fila[3]
            });
        }

        tblUsuarios.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
