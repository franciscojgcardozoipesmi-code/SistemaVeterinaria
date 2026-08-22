
package sistemaveterinaria;
import controller.TurnoController;
public class VentanaTurnosVencidos extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaTurnosVencidos.class.getName());

    public VentanaTurnosVencidos() {
        initComponents();
        cargarTabla();
    }
    public VentanaTurnosVencidos(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        cargarTabla();
    }
    private void cargarTabla() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Dueño");
        modelo.addColumn("DNI");
        modelo.addColumn("Animal");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Motivo");
        modelo.addColumn("Estado");

        for (Object[] fila :
                TurnoController.listarTurnosVencidos()) {

            modelo.addRow(fila);
        }

        tblTurnosVencidos.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTurnosVencidos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnReprogramarTurno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Turnos vencidos");

        tblTurnosVencidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTurnosVencidos);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        btnReprogramarTurno.setText("Reprogramar turno");
        btnReprogramarTurno.addActionListener(this::btnReprogramarTurnoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(319, 319, 319)
                                .addComponent(btnVolver))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(btnReprogramarTurno)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver)
                .addGap(28, 28, 28)
                .addComponent(btnReprogramarTurno)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaTurnos vt =
          new VentanaTurnos(rolUsuario);

        vt.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnReprogramarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReprogramarTurnoActionPerformed
  

        int fila = tblTurnosVencidos.getSelectedRow();

        if (fila == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un turno"
            );

            return;
        }

        int id = Integer.parseInt(
                tblTurnosVencidos.getValueAt(fila, 0).toString()
        );

        String dueno =
                tblTurnosVencidos.getValueAt(fila, 1).toString();

        String dni =
                tblTurnosVencidos.getValueAt(fila, 2).toString();

        String animal =
                tblTurnosVencidos.getValueAt(fila, 3).toString();

        String fecha =
                tblTurnosVencidos.getValueAt(fila, 4).toString();

        String hora =
                tblTurnosVencidos.getValueAt(fila, 5).toString();

        String motivo =
                tblTurnosVencidos.getValueAt(fila, 6).toString();

        VentanaCrearTurno vct =
                new VentanaCrearTurno(rolUsuario);

        vct.setVisible(true);

        vct.cargarDatosReprogramacion(
                id,
                dueno,
                animal,
                fecha,
                hora,
                motivo,
                dni
        );

        this.dispose();
    
    }//GEN-LAST:event_btnReprogramarTurnoActionPerformed


    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(() -> new VentanaTurnosVencidos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReprogramarTurno;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblTurnosVencidos;
    // End of variables declaration//GEN-END:variables
}
