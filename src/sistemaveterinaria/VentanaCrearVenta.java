
package sistemaveterinaria;

import controller.ProductoController;
import controller.VentaController;
import java.util.HashMap;
import java.util.HashSet;
import excepciones.StockInsuficienteException;
import excepciones.ProductoVencidoException;
import java.time.LocalDate;

public class VentanaCrearVenta extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCrearVenta.class.getName());

    public VentanaCrearVenta() {
        initComponents();
        modelo = new javax.swing.table.DefaultTableModel();

        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");

        tblDetalle.setModel(modelo);

        cargarProductos();
            mapaPrecios = ProductoController.obtenerMapaPrecios();
    }
    
    public VentanaCrearVenta(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;

        modelo = new javax.swing.table.DefaultTableModel();

        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");

        tblDetalle.setModel(modelo);

        cargarProductos();
        mapaPrecios = ProductoController.obtenerMapaPrecios();
    }
    
    private javax.swing.table.DefaultTableModel modelo;
    private HashMap<String, Double> mapaPrecios;
    private HashSet<String> productosAgregados = new HashSet<>();

    private void cargarProductos() {

            cmbProducto.removeAllItems();

        for (String producto : ProductoController.listarNombres()) {
            cmbProducto.addItem(producto);
        }
    }
    private void calcularTotal() {

        double total = 0;

        for (int i = 0; i < tblDetalle.getRowCount(); i++) {
            total += Double.parseDouble(tblDetalle.getValueAt(i, 3).toString());
        }

        lblTotal.setText("Total: " + total);
    }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFecha = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        cmbProducto = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        scrollDetalle = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFecha.setText("Fecha");

        lblProducto.setText("Producto");

        lblCantidad.setText("Cantidad");

        txtFecha.addActionListener(this::txtFechaActionPerformed);

        txtCantidad.addActionListener(this::txtCantidadActionPerformed);

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollDetalle.setViewportView(tblDetalle);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        lblTotal.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProducto)
                        .addGap(86, 86, 86)
                        .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblFecha)
                                    .addGap(57, 57, 57))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCantidad)
                                    .addGap(40, 40, 40)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(txtFecha)))))
                .addGap(18, 18, 18)
                .addComponent(scrollDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(54, 54, 54)
                        .addComponent(btnGuardar)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProducto)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCantidad)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(scrollDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGuardar))
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
   
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
      
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {

            String producto = cmbProducto.getSelectedItem().toString();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            String fechaVencimiento =
                    ProductoController.obtenerFechaVencimiento(producto);

            if (fechaVencimiento != null && !fechaVencimiento.isEmpty()) {

                LocalDate fecha =
                        LocalDate.parse(fechaVencimiento);

                if (fecha.isBefore(LocalDate.now())) {

                    throw new ProductoVencidoException(
                            "El producto se encuentra vencido"
                    );
                }
            }

            if (productosAgregados.contains(producto)) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "El producto ya fue agregado a la venta"
                );

                return;
            }

            int stockDisponible =
                    ProductoController.obtenerStock(producto);

            if (cantidad > stockDisponible) {

                throw new StockInsuficienteException(
                        "Stock insuficiente. Disponible: "
                        + stockDisponible
                );
            }

            double precio = mapaPrecios.get(producto);
            double subtotal = precio * cantidad;

            modelo.addRow(new Object[]{
                producto,
                cantidad,
                precio,
                subtotal
            });

            productosAgregados.add(producto);

            calcularTotal();

        } catch (StockInsuficienteException e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );
        } catch (ProductoVencidoException e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );        
        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getClass().getSimpleName()
                    + " - " + e.getMessage()
            );
        }
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {

            if (tblDetalle.getRowCount() == 0) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Agregá al menos un producto"
                );
                return;
            }

            VentaController.guardarVenta(txtFecha.getText().trim(),tblDetalle);

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Venta guardada correctamente"
            );

            VentanaVentas vv = new VentanaVentas(rolUsuario);
            vv.setVisible(true);

            this.dispose();

        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );
        }  
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaVentas vv = new VentanaVentas(rolUsuario);
        vv.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(() -> new VentanaCrearVenta().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JScrollPane scrollDetalle;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
