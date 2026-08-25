
package sistemaveterinaria;
import controller.ProcedimientoMedicoController;

public class VentanaProcedimientosMedicos extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaProcedimientosMedicos.class.getName());

    public VentanaProcedimientosMedicos() {
        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoProcedimientos();
    }
    public VentanaProcedimientosMedicos(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoProcedimientos();
    }
    
    private void buscarProcedimientos(String filtro) {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Tipo");
        modelo.addColumn("Emergencia");
        modelo.addColumn("Monto");
        modelo.addColumn("ID Animal");
        modelo.addColumn("Animal");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripción");
        for (Object[] fila :
                ProcedimientoMedicoController.buscarProcedimientos(filtro)) {

            modelo.addRow(fila);
        }

        tblProcedimientos.setModel(modelo);
                tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMinWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMaxWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(0);
    }
    private void cargarTabla() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Tipo");
        modelo.addColumn("Emergencia");
        modelo.addColumn("Monto");
        modelo.addColumn("ID Animal");
        modelo.addColumn("Animal");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripción");

        for (Object[] fila :
                ProcedimientoMedicoController.listarProcedimientos()) {

            modelo.addRow(fila);
        }

        tblProcedimientos.setModel(modelo);
        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMinWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMaxWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollProcedimientos = new javax.swing.JScrollPane();
        tblProcedimientos = new javax.swing.JTable();
        btnAgregarProcedimiento = new javax.swing.JButton();
        btnEditarProcedimiento = new javax.swing.JButton();
        btnDarDeBajaRegistro = new javax.swing.JButton();
        btnBuscarProcedimiento = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProcedimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollProcedimientos.setViewportView(tblProcedimientos);

        btnAgregarProcedimiento.setText("Agregar procedimiento");
        btnAgregarProcedimiento.addActionListener(this::btnAgregarProcedimientoActionPerformed);

        btnEditarProcedimiento.setText("Editar procedimiento");
        btnEditarProcedimiento.addActionListener(this::btnEditarProcedimientoActionPerformed);

        btnDarDeBajaRegistro.setText("Dar de baja el registro");
        btnDarDeBajaRegistro.addActionListener(this::btnDarDeBajaRegistroActionPerformed);

        btnBuscarProcedimiento.setText("Buscar");
        btnBuscarProcedimiento.addActionListener(this::btnBuscarProcedimientoActionPerformed);

        btnMostrarTodos.setText("Mostrar todos");
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollProcedimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnMostrarTodos)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnDarDeBajaRegistro))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAgregarProcedimiento)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditarProcedimiento)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnVolver))
                            .addComponent(btnBuscarProcedimiento))
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollProcedimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarProcedimiento)
                            .addComponent(btnEditarProcedimiento)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVolver)))
                .addGap(3, 3, 3)
                .addComponent(btnBuscarProcedimiento)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDarDeBajaRegistro)
                    .addComponent(btnMostrarTodos))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed


        VentanaPrincipal vp =
                new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProcedimientoActionPerformed
        VentanaAgregarProcedimiento vap =
            new VentanaAgregarProcedimiento(rolUsuario);

        vap.setVisible(true);

        this.dispose();
    
    }//GEN-LAST:event_btnAgregarProcedimientoActionPerformed

    private void btnEditarProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProcedimientoActionPerformed
        int fila = tblProcedimientos.getSelectedRow();

        if (fila == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un procedimiento"
            );

            return;
        }

        int idProcedimiento = Integer.parseInt(
                tblProcedimientos.getValueAt(fila, 0).toString()
        );

        String tipo =
                tblProcedimientos.getValueAt(fila, 1).toString();

        boolean emergencia =
                tblProcedimientos.getValueAt(fila, 2)
                        .toString()
                        .equals("Sí");

        double monto = Double.parseDouble(
                tblProcedimientos.getValueAt(fila, 3).toString()
        );

        int idAnimal = Integer.parseInt(
                tblProcedimientos.getValueAt(fila, 4).toString()
        );

        VentanaAgregarProcedimiento vap =
                new VentanaAgregarProcedimiento(rolUsuario);
        String fecha =
                tblProcedimientos.getValueAt(fila, 6).toString();

        String descripcion =
                tblProcedimientos.getValueAt(fila, 7).toString();
        
        vap.cargarDatos(
                idProcedimiento,
                tipo,
                emergencia,
                monto,
                idAnimal,
                fecha,
                descripcion
        );

        vap.setVisible(true);

        this.dispose();
    
    }//GEN-LAST:event_btnEditarProcedimientoActionPerformed

    private void btnDarDeBajaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaRegistroActionPerformed


        int fila = tblProcedimientos.getSelectedRow();

        if (fila == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccioná un procedimiento"
            );

            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que querés dar de baja este registro?",
                "Confirmar baja",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (opcion != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        int idProcedimiento = Integer.parseInt(
                tblProcedimientos.getValueAt(fila, 0).toString()
        );

        ProcedimientoMedicoController.eliminarProcedimiento(
                idProcedimiento
        );

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Registro dado de baja correctamente"
        );

        cargarTabla();
    
    }//GEN-LAST:event_btnDarDeBajaRegistroActionPerformed

    private void btnBuscarProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProcedimientoActionPerformed
                  String texto = javax.swing.JOptionPane.showInputDialog(
                this,
                "Buscar por tipo, animal o fecha:"
        );

        if (texto != null && !texto.trim().isEmpty()) {
            buscarProcedimientos(texto.trim());
        }
    
    }//GEN-LAST:event_btnBuscarProcedimientoActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        
        cargarTabla();
    
    }//GEN-LAST:event_btnMostrarTodosActionPerformed
    private void configurarDiseñoProcedimientos() {

        setTitle(
                "Henry System Vet - Gestión de procedimientos"
        );

        setIconImage(
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/HenrySystemVet.png"
                        )
                ).getImage()
        );

        getContentPane().removeAll();

        getContentPane().setBackground(
                Estilos.VERDE_PRINCIPAL
        );

        getContentPane().setLayout(
                new java.awt.BorderLayout()
        );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelPrincipal.setOpaque(false);

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        45,
                        60,
                        40,
                        60
                )
        );

        javax.swing.JPanel panelEncabezado =
                new javax.swing.JPanel();

        panelEncabezado.setOpaque(false);

        panelEncabezado.setLayout(
                new javax.swing.BoxLayout(
                        panelEncabezado,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "GESTIÓN DE PROCEDIMIENTOS"
                );

        lblTitulo.setFont(
                Estilos.fuente(26f)
        );

        lblTitulo.setForeground(
                Estilos.BLANCO
        );

        javax.swing.JPanel panelTitulo =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                25,
                                12
                        )
                );

        panelTitulo.setBackground(
                Estilos.VERDE_OSCURO
        );

        panelTitulo.add(
                lblTitulo
        );

        javax.swing.JPanel contenedorTitulo =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                0
                        )
                );

        contenedorTitulo.setOpaque(false);

        contenedorTitulo.add(
                panelTitulo
        );

        panelEncabezado.add(
                contenedorTitulo
        );

        panelEncabezado.add(
                javax.swing.Box.createVerticalStrut(25)
        );

        javax.swing.JPanel tarjetaProcedimientos =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaProcedimientos.setBackground(
                Estilos.BLANCO
        );

        tarjetaProcedimientos.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                25,
                                25,
                                25,
                                25
                        )
                )
        );

        Estilos.estilizarTabla(
                tblProcedimientos
        );

        scrollProcedimientos.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollProcedimientos.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        400
                )
        );

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMinWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMaxWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(0);

        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblProcedimientos.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(3)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(6)
                .setCellRenderer(centrado);

        tarjetaProcedimientos.add(
                scrollProcedimientos,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnAgregarProcedimiento
        );

        Estilos.estilizarBoton(
                btnEditarProcedimiento
        );

        Estilos.estilizarBotonEliminar(
                btnDarDeBajaRegistro
        );

        Estilos.estilizarBoton(
                btnBuscarProcedimiento
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );

        Estilos.estilizarBoton(
                btnVolver
        );

        javax.swing.JPanel panelBotones =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(false);

        btnAgregarProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        220,
                        38
                )
        );

        btnEditarProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        200,
                        38
                )
        );

        btnDarDeBajaRegistro.setPreferredSize(
                new java.awt.Dimension(
                        230,
                        38
                )
        );

        btnBuscarProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        150,
                        38
                )
        );

        btnMostrarTodos.setPreferredSize(
                new java.awt.Dimension(
                        160,
                        38
                )
        );

        panelBotones.add(
                btnAgregarProcedimiento
        );

        panelBotones.add(
                btnEditarProcedimiento
        );

        panelBotones.add(
                btnDarDeBajaRegistro
        );

        panelBotones.add(
                btnBuscarProcedimiento
        );

        panelBotones.add(
                btnMostrarTodos
        );

        tarjetaProcedimientos.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        javax.swing.JPanel panelInferior =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                0,
                                0
                        )
                );

        panelInferior.setOpaque(false);

        btnVolver.setPreferredSize(
                new java.awt.Dimension(
                        120,
                        38
                )
        );

        panelInferior.add(
                btnVolver
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaProcedimientos,
                java.awt.BorderLayout.CENTER
        );

        panelPrincipal.add(
                panelInferior,
                java.awt.BorderLayout.SOUTH
        );

        getContentPane().add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        revalidate();
        repaint();
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaProcedimientosMedicos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProcedimiento;
    private javax.swing.JButton btnBuscarProcedimiento;
    private javax.swing.JButton btnDarDeBajaRegistro;
    private javax.swing.JButton btnEditarProcedimiento;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollProcedimientos;
    private javax.swing.JTable tblProcedimientos;
    // End of variables declaration//GEN-END:variables
}
