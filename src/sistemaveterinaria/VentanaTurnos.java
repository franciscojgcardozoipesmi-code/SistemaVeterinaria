package sistemaveterinaria;
import controller.TurnoController;

public class VentanaTurnos extends javax.swing.JFrame {
    private String rolUsuario;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaTurnos.class.getName());

    public VentanaTurnos() {
        initComponents();
        cargarTabla();
    }
    
    public VentanaTurnos(String rolUsuario) {
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

            for (Object[] fila : TurnoController.listarTurnos()) {
                modelo.addRow(fila);
            }

            tblTurnos.setModel(modelo);
        }
    
    private void buscarTurnos(String filtro) {

    javax.swing.table.DefaultTableModel modelo =
            new javax.swing.table.DefaultTableModel();

    modelo.addColumn("ID");
    modelo.addColumn("Dueño");
    modelo.addColumn("DNI");
    modelo.addColumn("Animal");
    modelo.addColumn("Fecha");
    modelo.addColumn("Hora");
    modelo.addColumn("Motivo");

    for (Object[] fila : TurnoController.buscarTurnos(filtro)) {
        modelo.addRow(fila);
    }

    tblTurnos.setModel(modelo);
}
    

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnCrearTurno = new javax.swing.JButton();
        scrollTurnos = new javax.swing.JScrollPane();
        tblTurnos = new javax.swing.JTable();
        btnEliminarTurno = new javax.swing.JButton();
        btnEditarTurno = new javax.swing.JButton();
        btnBuscarTurno = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Gestión de turnos");

        btnCrearTurno.setText("Crear turno");
        btnCrearTurno.addActionListener(this::btnCrearTurnoActionPerformed);

        tblTurnos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollTurnos.setViewportView(tblTurnos);

        btnEliminarTurno.setText("Eliminar turno");
        btnEliminarTurno.addActionListener(this::btnEliminarTurnoActionPerformed);

        btnEditarTurno.setText("Editar turno");
        btnEditarTurno.addActionListener(this::btnEditarTurnoActionPerformed);

        btnBuscarTurno.setText("Buscar turno");
        btnBuscarTurno.addActionListener(this::btnBuscarTurnoActionPerformed);

        btnMostrarTodos.setText("Mostrar todos");
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollTurnos)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnEditarTurno)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarTurno)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrearTurno)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(31, 31, 31)))
                .addComponent(btnBuscarTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMostrarTodos)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarTurno)
                            .addComponent(btnEditarTurno)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarTurno)
                            .addComponent(btnMostrarTodos)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearTurno)
                        .addGap(8, 8, 8)
                        .addComponent(btnVolver)))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTurnoActionPerformed

        VentanaCrearTurno vct =
                new VentanaCrearTurno(rolUsuario);

        vct.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnCrearTurnoActionPerformed

    private void btnEliminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTurnoActionPerformed

        int fila = tblTurnos.getSelectedRow();

        if (fila == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un turno"
            );

            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que querés eliminar este turno?",
                "Confirmar eliminación",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (opcion != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        int id = Integer.parseInt(
                tblTurnos.getValueAt(fila, 0).toString()
        );

        TurnoController.eliminarTurno(id);

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Turno eliminado"
        );

        cargarTabla();
    
    }//GEN-LAST:event_btnEliminarTurnoActionPerformed

    private void btnEditarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTurnoActionPerformed
        int fila = tblTurnos.getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccioná un turno");
            return;
        }

        int id = Integer.parseInt(tblTurnos.getValueAt(fila, 0).toString());
        String dueno = tblTurnos.getValueAt(fila, 1).toString();
        String dni = tblTurnos.getValueAt(fila, 2).toString();
        String animal = tblTurnos.getValueAt(fila, 3).toString();
        String fecha = tblTurnos.getValueAt(fila, 4).toString();
        String hora = tblTurnos.getValueAt(fila, 5).toString();
        String motivo = tblTurnos.getValueAt(fila, 6).toString();

        VentanaCrearTurno vct = new VentanaCrearTurno(rolUsuario);
        vct.setVisible(true);

        vct.cargarDatos(id, dueno, animal, fecha, hora, motivo, dni);

        this.dispose();     
    }//GEN-LAST:event_btnEditarTurnoActionPerformed

    private void btnBuscarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTurnoActionPerformed
        String texto = javax.swing.JOptionPane.showInputDialog(this, "Buscar por DNI, dueño o animal:");

        if (texto != null && !texto.isEmpty()) {
            buscarTurnos(texto);
        }
    }//GEN-LAST:event_btnBuscarTurnoActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp =
                new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaTurnos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarTurno;
    private javax.swing.JButton btnCrearTurno;
    private javax.swing.JButton btnEditarTurno;
    private javax.swing.JButton btnEliminarTurno;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollTurnos;
    private javax.swing.JTable tblTurnos;
    // End of variables declaration//GEN-END:variables
}
