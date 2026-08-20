
package sistemaveterinaria;
import controller.ClienteController;
import controller.AnimalController;
public class VentanaAgregarAnimal extends javax.swing.JFrame {
    private String rolUsuario;
    private int idAnimal = -1;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAgregarAnimal.class.getName());

    
    public VentanaAgregarAnimal() {
        initComponents();
        cargarClientes();
    }

    public VentanaAgregarAnimal(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        cargarClientes();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblEspecie = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        lblRaza = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setText("Nombre");

        lblEspecie.setText("Especie");

        lblRaza.setText("Raza");

        lblEdad.setText("Edad");

        lblCliente.setText("Cliente");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblEspecie)
                                    .addComponent(lblRaza)
                                    .addComponent(lblEdad))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEspecie)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRaza, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnGuardar)
                        .addGap(57, 57, 57)
                        .addComponent(btnVolver)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecie)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaza)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {

            String nombre = txtNombre.getText().trim();
            String especie = txtEspecie.getText().trim();
            String raza = txtRaza.getText().trim();
            String edadTexto = txtEdad.getText().trim();

            if (nombre.isEmpty()
                    || especie.isEmpty()
                    || edadTexto.isEmpty()
                    || cmbCliente.getSelectedItem() == null) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Completar todos los campos obligatorios"
                );

                return;
            }

            int edad = Integer.parseInt(edadTexto);

            String clienteSeleccionado =
                    cmbCliente.getSelectedItem().toString();

            int idCliente = Integer.parseInt(
                    clienteSeleccionado.split(" - ")[0]
            );

            AnimalController.guardarAnimal(
                    nombre,
                    especie,
                    raza,
                    edad,
                    idCliente,
                    idAnimal
            );

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Animal guardado correctamente"
            );

            VentanaAnimales va =
                    new VentanaAnimales(rolUsuario);

            va.setVisible(true);

            this.dispose();

        } catch (NumberFormatException e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "La edad debe ser un número válido"
            );

        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e
            );
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        VentanaAnimales va =
                new VentanaAnimales(rolUsuario);

        va.setVisible(true);

        this.dispose();
    
    }//GEN-LAST:event_btnVolverActionPerformed
    private void cargarClientes() {

        cmbCliente.removeAllItems();

        for (Object[] fila : ClienteController.listarClientesParaCombo()) {

            int idCliente = Integer.parseInt(
                    fila[0].toString()
            );

            String nombre = fila[1].toString();
            String dni = fila[2].toString();

            cmbCliente.addItem(
                    idCliente + " - " + nombre + " - " + dni
            );
        }
    }
    
    public void cargarDatos(int idAnimal,
                            String nombre,
                            String especie,
                            String raza,
                            int edad,
                            int idCliente) {

        this.idAnimal = idAnimal;

        txtNombre.setText(nombre);
        txtEspecie.setText(especie);
        txtRaza.setText(raza);
        txtEdad.setText(String.valueOf(edad));

        for (int i = 0; i < cmbCliente.getItemCount(); i++) {

            String item = cmbCliente.getItemAt(i);

            if (item.startsWith(idCliente + " - ")) {
                cmbCliente.setSelectedIndex(i);
                break;
            }
        }
    }
   
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaAgregarAnimal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRaza;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRaza;
    // End of variables declaration//GEN-END:variables
}
