
package sistemaveterinaria;
import controller.AnimalController;
import controller.ProcedimientoMedicoController;
public class VentanaAgregarProcedimiento extends javax.swing.JFrame {
    private String rolUsuario;
    private int idProcedimiento = -1;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAgregarProcedimiento.class.getName());

    public VentanaAgregarProcedimiento() {
        initComponents();
        cargarAnimales();
    }

    public VentanaAgregarProcedimiento(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        cargarAnimales();
    }
    
    public void cargarDatos(int idProcedimiento,
                            String tipo,
                            boolean emergencia,
                            double monto,
                            int idAnimal) {

        this.idProcedimiento = idProcedimiento;

        txtTipo.setText(tipo);
        chkEmergencia.setSelected(emergencia);
        txtMonto.setText(String.valueOf(monto));

        for (int i = 0; i < cmbAnimal.getItemCount(); i++) {

            String item = cmbAnimal.getItemAt(i);

            if (item.startsWith(idAnimal + " - ")) {
                cmbAnimal.setSelectedIndex(i);
                break;
            }
        }
    }

    private void cargarAnimales() {

        cmbAnimal.removeAllItems();

        for (Object[] fila : AnimalController.listarAnimalesParaCombo()) {

            int idAnimal = Integer.parseInt(
                    fila[0].toString()
            );

            String nombre = fila[1].toString();

            cmbAnimal.addItem(
                    idAnimal + " - " + nombre
            );
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblEmergencia = new javax.swing.JLabel();
        chkEmergencia = new javax.swing.JCheckBox();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        lblAnimal = new javax.swing.JLabel();
        cmbAnimal = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTipo.setText("Tipo");

        lblEmergencia.setText("Emergencia");

        chkEmergencia.setText("Emergencia");

        lblMonto.setText("Monto");

        lblAnimal.setText("Animal");

        cmbAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblEmergencia, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblTipo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(148, 148, 148)
                                    .addComponent(chkEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(13, 13, 13))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAnimal)
                                    .addComponent(lblMonto))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEmergencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkEmergencia)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMonto)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnimal)
                    .addComponent(cmbAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed


        try {

            String tipo = txtTipo.getText().trim();
            String montoTexto = txtMonto.getText().trim();

            if (tipo.isEmpty()
                    || montoTexto.isEmpty()
                    || cmbAnimal.getSelectedItem() == null) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Completar todos los campos obligatorios"
                );

                return;
            }

            double monto = Double.parseDouble(montoTexto);

            boolean emergencia = chkEmergencia.isSelected();

            String animalSeleccionado =
                    cmbAnimal.getSelectedItem().toString();

            int idAnimal = Integer.parseInt(
                    animalSeleccionado.split(" - ")[0]
            );

            ProcedimientoMedicoController.guardarProcedimiento(
                    tipo,
                    emergencia,
                    monto,
                    idAnimal,
                    idProcedimiento
            );

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Procedimiento guardado correctamente"
            );

            VentanaProcedimientos vp =
                    new VentanaProcedimientos(rolUsuario);

            vp.setVisible(true);

            this.dispose();

        } catch (NumberFormatException e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "El monto debe ser un número válido"
            );

        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e
            );
        }
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaProcedimientos vp =
                new VentanaProcedimientos(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    
    }//GEN-LAST:event_btnVolverActionPerformed


    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(() -> new VentanaAgregarProcedimiento().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkEmergencia;
    private javax.swing.JComboBox<String> cmbAnimal;
    private javax.swing.JLabel lblAnimal;
    private javax.swing.JLabel lblEmergencia;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
