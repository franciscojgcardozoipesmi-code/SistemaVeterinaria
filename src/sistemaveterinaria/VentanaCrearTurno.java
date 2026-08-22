package sistemaveterinaria;
import controller.TurnoController;
import controller.AnimalController;
import javax.swing.JOptionPane;
import controller.ClienteController;

public class VentanaCrearTurno extends javax.swing.JFrame {
    private int idTurno = -1;
    private boolean reprogramando = false;
    private String rolUsuario;
        public void cargarDatosReprogramacion(
            int id,
            String dueno,
            String animal,
            String fecha,
            String hora,
            String motivo,
            String dni) {

        reprogramando = true;

        cargarDatos(
                id,
                dueno,
                animal,
                fecha,
                hora,
                motivo,
                dni
        );
    }
    public VentanaCrearTurno() {
        initComponents();
        cargarAnimales();
    }

    public VentanaCrearTurno(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        cargarAnimales();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnimal = new javax.swing.JLabel();
        lblDueno = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblMotivo = new javax.swing.JLabel();
        txtDueno = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        cmbAnimal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAnimal.setText("Animal");

        lblDueno.setText("Dueño");

        lblFecha.setText("Fecha");

        lblHora.setText("Hora");

        lblMotivo.setText("Motivo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        lblDni.setText("DNI");

        cmbAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAnimal.addActionListener(this::cmbAnimalActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 115, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(54, 54, 54)
                .addComponent(btnGuardar)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnimal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDni)
                                .addComponent(lblDueno)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                            .addComponent(txtDueno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbAnimal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblHora))
                                    .addComponent(lblMotivo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(txtHora))))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnimal)
                    .addComponent(cmbAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDueno)
                    .addComponent(txtDueno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMotivo)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         try {

            String dueno = txtDueno.getText();
            String itemAnimal =
                    cmbAnimal.getSelectedItem().toString();

            int idAnimal = Integer.parseInt(
                    itemAnimal.split(" - ")[0]
            );

            String animal =
                    itemAnimal.split(" - ")[1];
            String dni = txtDni.getText();
            String fecha = txtFecha.getText();
            String hora = txtHora.getText();
            String motivo = txtMotivo.getText();
            
            if (dueno.isEmpty() || animal.isEmpty() || dni.isEmpty() ||
                fecha.isEmpty() || hora.isEmpty() || motivo.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Completar todos los campos");
                return;
            }

            TurnoController.guardarTurno(
                                        dueno,
                                        dni,
                                        idAnimal,
                                        animal,
                                        fecha,
                                        hora,
                                        motivo,
                                        idTurno
                                );
                        if (reprogramando) {
                TurnoController.cambiarEstado(
                        idTurno,
                        "PENDIENTE"
                );
            }                    
            JOptionPane.showMessageDialog(this, "Turno guardado correctamente");
            
            VentanaTurnos vt = new VentanaTurnos(rolUsuario);
            vt.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    public void cargarDatos(int id, String dueno, String animal, String fecha, String hora, String motivo, String dni) {
        idTurno = id;

        txtDueno.setText(dueno);
        cmbAnimal.setSelectedItem(animal);
        txtFecha.setText(fecha);
        txtHora.setText(hora);
        txtMotivo.setText(motivo);
        txtDni.setText(dni);
    }
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaTurnos vt = new VentanaTurnos(rolUsuario);
        vt.setVisible(true);

        this.dispose();        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cmbAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnimalActionPerformed
          if (cmbAnimal.getSelectedItem() == null) {
            return;
        }

        String item =
                cmbAnimal.getSelectedItem().toString();

        int idAnimal = Integer.parseInt(
                item.split(" - ")[0]
        );

        int idCliente =
                AnimalController.obtenerIdClientePorAnimal(idAnimal);

        Object[] cliente =
                ClienteController.obtenerClientePorId(idCliente);

        if (cliente != null) {

            txtDueno.setText(
                    cliente[1].toString()
            );

            txtDni.setText(
                    cliente[2].toString()
            );
        }
    
    }//GEN-LAST:event_cmbAnimalActionPerformed

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
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VentanaCrearTurno().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbAnimal;
    private javax.swing.JLabel lblAnimal;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDueno;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDueno;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables
}
