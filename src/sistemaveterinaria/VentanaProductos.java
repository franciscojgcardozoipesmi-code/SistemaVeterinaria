package sistemaveterinaria;
import controller.ProductoController;
public class VentanaProductos extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaProductos.class.getName());

    public VentanaProductos() {
        initComponents();
        cargarTabla();
    }
    
    public VentanaProductos(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        cargarTabla();
    }

    private void cargarTabla() {

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Fecha vencimiento");

        for (Object[] fila : ProductoController.listarProductos()) {
            modelo.addRow(fila);
        }

        tblProductos.setModel(modelo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        scrollProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrearProducto.setText("Crear producto");
        btnCrearProducto.addActionListener(this::btnCrearProductoActionPerformed);

        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addActionListener(this::btnEliminarProductoActionPerformed);

        btnEditarProducto.setText("Editar producto");
        btnEditarProducto.addActionListener(this::btnEditarProductoActionPerformed);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollProductos.setViewportView(tblProductos);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCrearProducto)
                        .addGap(61, 61, 61)
                        .addComponent(btnEliminarProducto)
                        .addGap(92, 92, 92)
                        .addComponent(btnEditarProducto)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(301, 301, 301))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProducto)
                    .addComponent(btnEliminarProducto)
                    .addComponent(btnCrearProducto))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
        VentanaCrearProducto vcp = new VentanaCrearProducto(rolUsuario);
        vcp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnCrearProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
            int fila = tblProductos.getSelectedRow();

            if (fila == -1) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Seleccioná un producto"
                );
                return;
            }

            int opcion = javax.swing.JOptionPane.showConfirmDialog(
                    this,
                    "¿Seguro que querés eliminar este producto?",
                    "Confirmar eliminación",
                    javax.swing.JOptionPane.YES_NO_OPTION
            );

            if (opcion != javax.swing.JOptionPane.YES_OPTION) {
                return;
            }

            int idProducto = Integer.parseInt(
                    tblProductos.getValueAt(fila, 0).toString()
            );

            ProductoController.eliminarProducto(idProducto);

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Producto eliminado"
            );

            cargarTabla();    
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        int fila = tblProductos.getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un producto"
            );
            return;
        }

        int idProducto = Integer.parseInt(
                tblProductos.getValueAt(fila, 0).toString()
        );

        String nombre = tblProductos.getValueAt(fila, 1).toString();

        double precio = Double.parseDouble(
                tblProductos.getValueAt(fila, 2).toString()
        );

        int stock = Integer.parseInt(
                tblProductos.getValueAt(fila, 3).toString()
        );
        
        Object valorFecha = tblProductos.getValueAt(fila, 4);

        String fechaVencimiento = "";

        if (valorFecha != null) {
            fechaVencimiento = valorFecha.toString();
        }

        VentanaCrearProducto vcp = new VentanaCrearProducto(rolUsuario);

        vcp.cargarDatos(idProducto, nombre, precio, stock, fechaVencimiento);

        vcp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp = new VentanaPrincipal(rolUsuario);
        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaProductos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}