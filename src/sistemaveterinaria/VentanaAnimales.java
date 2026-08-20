
package sistemaveterinaria;
import controller.AnimalController;
public class VentanaAnimales extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAnimales.class.getName());

   
    public VentanaAnimales() {
        initComponents();
        cargarTabla();
    }
    
    public VentanaAnimales(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        cargarTabla();
    }
    
    private void cargarTabla() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");
        modelo.addColumn("ID Cliente");

        for (Object[] fila : AnimalController.listarAnimales()) {
            modelo.addRow(fila);
        }

        tblAnimales.setModel(modelo);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollAnimales = new javax.swing.JScrollPane();
        tblAnimales = new javax.swing.JTable();
        btnAgregarAnimal = new javax.swing.JButton();
        btnEditarAnimal = new javax.swing.JButton();
        btnDarDeBajaRegistro = new javax.swing.JButton();
        txtBuscar = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAnimales.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollAnimales.setViewportView(tblAnimales);

        btnAgregarAnimal.setText("Agregar animal");
        btnAgregarAnimal.addActionListener(this::btnAgregarAnimalActionPerformed);

        btnEditarAnimal.setText("Editar animal");
        btnEditarAnimal.addActionListener(this::btnEditarAnimalActionPerformed);

        btnDarDeBajaRegistro.setText("Dar de baja el registro");
        btnDarDeBajaRegistro.addActionListener(this::btnDarDeBajaRegistroActionPerformed);

        txtBuscar.setText("Buscar");
        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        btnMostrarTodos.setText("Mostrar todos");
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnDarDeBajaRegistro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnMostrarTodos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregarAnimal)
                            .addComponent(btnEditarAnimal))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(scrollAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrollAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnAgregarAnimal)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarAnimal)
                        .addGap(18, 18, 18)
                        .addComponent(btnDarDeBajaRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar)
                        .addGap(26, 26, 26)
                        .addComponent(btnMostrarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVolver)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAnimalActionPerformed
        VentanaAgregarAnimal vaa = new VentanaAgregarAnimal(rolUsuario);

        vaa.setVisible(true);

        this.dispose();
    
    }//GEN-LAST:event_btnAgregarAnimalActionPerformed

    private void btnDarDeBajaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaRegistroActionPerformed
  
        int fila = tblAnimales.getSelectedRow();

        if (fila == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un animal"
            );

            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que querés dar de baja este registro?",
                "Confirmar",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (opcion != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        int idAnimal = Integer.parseInt(
                tblAnimales.getValueAt(fila, 0).toString()
        );

        AnimalController.eliminarAnimal(idAnimal);

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Registro dado de baja correctamente"
        );

        cargarTabla();
    }//GEN-LAST:event_btnDarDeBajaRegistroActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        VentanaPrincipal vp =
                new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAnimalActionPerformed
        
        int fila = tblAnimales.getSelectedRow();

        if (fila == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un animal"
            );

            return;
        }

        int idAnimal = Integer.parseInt(
                tblAnimales.getValueAt(fila, 0).toString()
        );

        String nombre =
                tblAnimales.getValueAt(fila, 1).toString();

        String especie =
                tblAnimales.getValueAt(fila, 2).toString();

        String raza =
                tblAnimales.getValueAt(fila, 3).toString();

        int edad = Integer.parseInt(
                tblAnimales.getValueAt(fila, 4).toString()
        );

        int idCliente = Integer.parseInt(
                tblAnimales.getValueAt(fila, 5).toString()
        );

        VentanaAgregarAnimal vaa =
                new VentanaAgregarAnimal(rolUsuario);

        vaa.cargarDatos(
                idAnimal,
                nombre,
                especie,
                raza,
                edad,
                idCliente
        );

        vaa.setVisible(true);

        this.dispose();
    
    }//GEN-LAST:event_btnEditarAnimalActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
      
        String texto = javax.swing.JOptionPane.showInputDialog(
                this,
                "Buscar por nombre, especie o raza:"
        );

        if (texto != null && !texto.isEmpty()) {
            buscarAnimales(texto);
        }
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed

        cargarTabla();

    }//GEN-LAST:event_btnMostrarTodosActionPerformed
    private void buscarAnimales(String filtro) {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");
        modelo.addColumn("ID Cliente");

        for (Object[] fila : AnimalController.buscarAnimales(filtro)) {
            modelo.addRow(fila);
        }

        tblAnimales.setModel(modelo);
    }

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new VentanaAnimales().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAnimal;
    private javax.swing.JButton btnDarDeBajaRegistro;
    private javax.swing.JButton btnEditarAnimal;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollAnimales;
    private javax.swing.JTable tblAnimales;
    private javax.swing.JButton txtBuscar;
    // End of variables declaration//GEN-END:variables
}
