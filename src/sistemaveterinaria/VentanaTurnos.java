package sistemaveterinaria;
import controller.TurnoController;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class VentanaTurnos extends javax.swing.JFrame {
    private String rolUsuario;
    private VentanaPrincipal ventanaPrincipal;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaTurnos.class.getName());
    private javax.swing.JTextField campoBusquedaTurnos;
    public VentanaTurnos() {
        initComponents();

        TurnoController.marcarTurnosVencidos();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoTurnos();
    }
    
    public VentanaTurnos(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        TurnoController.marcarTurnosVencidos();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoTurnos();
    }
    public VentanaTurnos(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        TurnoController.marcarTurnosVencidos();

        cargarTabla();
        configurarDiseñoTurnos();
    }

        private void cargarTabla() {

            javax.swing.table.DefaultTableModel modelo =
                    new javax.swing.table.DefaultTableModel() {

                @Override
                public boolean isCellEditable(
                        int row,
                        int column
                ) {
                    return column == 7
                            || column == 8;
                }
            };

            modelo.addColumn("ID");
            modelo.addColumn("Dueño");
            modelo.addColumn("DNI");
            modelo.addColumn("Animal");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Motivo");
            modelo.addColumn("Estado");
            modelo.addColumn("Acciones");

            for (Object[] fila
                    : TurnoController.listarTurnos()) {

                Object[] filaCompleta =
                        java.util.Arrays.copyOf(
                                fila,
                                9
                        );

                filaCompleta[8] = "";

                modelo.addRow(filaCompleta);
            }

            tblTurnos.setModel(modelo);

            aplicarColoresEstado();
            configurarColumnasTurnos();
            configurarEditorEstado();
        }
    
    private void buscarTurnos(
            String filtro
    ) {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {
                return column == 7
                        || column == 8;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Dueño");
        modelo.addColumn("DNI");
        modelo.addColumn("Animal");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Motivo");
        modelo.addColumn("Estado");
        modelo.addColumn("Acciones");

        for (Object[] fila
                : TurnoController.buscarTurnos(filtro)) {

            Object[] filaCompleta =
                    java.util.Arrays.copyOf(
                            fila,
                            9
                    );

            filaCompleta[8] = "";

            modelo.addRow(filaCompleta);
        }

        tblTurnos.setModel(modelo);

        aplicarColoresEstado();
        configurarColumnasTurnos();
        configurarEditorEstado();
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
        cmbEstado = new javax.swing.JComboBox<>();
        btnCambiarEstado = new javax.swing.JButton();
        btnVencidos = new javax.swing.JButton();

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

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "EN ATENCIÓN", "FINALIZADO", "CANCELADO", "VENCIDO" }));

        btnCambiarEstado.setText("Cambiar estado");
        btnCambiarEstado.addActionListener(this::btnCambiarEstadoActionPerformed);

        btnVencidos.setText("Vencidos");
        btnVencidos.addActionListener(this::btnVencidosActionPerformed);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarTurno)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnCambiarEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVencidos)))
                .addGap(27, 27, 27)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
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
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCambiarEstado)
                            .addComponent(btnVencidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVolver)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearTurno))))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTurnoActionPerformed
             ventanaPrincipal.mostrarCrearTurno();  
    }//GEN-LAST:event_btnCrearTurnoActionPerformed

    private void btnEliminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTurnoActionPerformed
        int fila = tblTurnos.getSelectedRow();

        if (fila == -1) {
            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un turno"
            );
            return;
        }

        int idTurno = Integer.parseInt(
                tblTurnos.getValueAt(fila, 0).toString()
        );

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Confirmar eliminación",
                        java.awt.Dialog.ModalityType.APPLICATION_MODAL
                );

        dialogo.setUndecorated(true);

        java.awt.Color rojo =
                new java.awt.Color(210, 70, 70);

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(0, 15)
                );

        panelPrincipal.setBackground(Estilos.BLANCO);

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                rojo,
                                2
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                0,
                                20,
                                18,
                                20
                        )
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "CONFIRMAR ELIMINACIÓN",
                        javax.swing.SwingConstants.CENTER
                );

        lblTitulo.setFont(Estilos.fuente(20f));
        lblTitulo.setForeground(Estilos.BLANCO);

        javax.swing.JPanel panelTitulo =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelTitulo.setBackground(rojo);

        panelTitulo.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        10,
                        15,
                        10,
                        15
                )
        );

        panelTitulo.add(
                lblTitulo,
                java.awt.BorderLayout.CENTER
        );

        javax.swing.JLabel lblMensaje =
                new javax.swing.JLabel(
                        "¿Seguro que querés eliminar el turno seleccionado?",
                        javax.swing.SwingConstants.CENTER
                );

        lblMensaje.setFont(Estilos.fuente(13f));
        lblMensaje.setForeground(Estilos.VERDE_OSCURO);

        javax.swing.JButton btnCancelarDialogo =
                new javax.swing.JButton("Cancelar");

        javax.swing.JButton btnConfirmarDialogo =
                new javax.swing.JButton("Confirmar");

        Estilos.estilizarBoton(btnCancelarDialogo);
        Estilos.estilizarBotonEliminar(btnConfirmarDialogo);

        btnCancelarDialogo.setPreferredSize(
                new java.awt.Dimension(115, 34)
        );

        btnConfirmarDialogo.setPreferredSize(
                new java.awt.Dimension(125, 34)
        );

        javax.swing.JPanel panelBotones =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(false);
        panelBotones.add(btnCancelarDialogo);
        panelBotones.add(btnConfirmarDialogo);

        javax.swing.JPanel contenido =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(0, 15)
                );

        contenido.setOpaque(false);

        contenido.add(
                lblMensaje,
                java.awt.BorderLayout.CENTER
        );

        contenido.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelTitulo,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                contenido,
                java.awt.BorderLayout.CENTER
        );

        btnCancelarDialogo.addActionListener(e ->
                dialogo.dispose()
        );

        btnConfirmarDialogo.addActionListener(e -> {
            try {
                TurnoController.eliminarTurno(idTurno);

                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Operación exitosa",
                        "Turno eliminado correctamente"
                );

                cargarTabla();

            } catch (Exception ex) {
                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Error",
                        "No se pudo eliminar el turno"
                );
            }
        });

        dialogo.setContentPane(panelPrincipal);
        dialogo.setSize(450, 180);
        dialogo.setLocationRelativeTo(ventanaPadre);
        dialogo.setVisible(true);

        
    }//GEN-LAST:event_btnEliminarTurnoActionPerformed

    private void btnEditarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTurnoActionPerformed
        int fila =
             tblTurnos.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un turno"
            );

            return;
        }

        int id =
                Integer.parseInt(
                        tblTurnos.getValueAt(
                                fila,
                                0
                        ).toString()
                );

        String dueno =
                tblTurnos.getValueAt(
                        fila,
                        1
                ).toString();

        String dni =
                tblTurnos.getValueAt(
                        fila,
                        2
                ).toString();

        String animal =
                tblTurnos.getValueAt(
                        fila,
                        3
                ).toString();

        String fecha =
                tblTurnos.getValueAt(
                        fila,
                        4
                ).toString();

        String hora =
                tblTurnos.getValueAt(
                        fila,
                        5
                ).toString();

        String motivo =
                tblTurnos.getValueAt(
                        fila,
                        6
                ).toString();

        ventanaPrincipal.mostrarEditarTurno(
                id,
                dueno,
                animal,
                fecha,
                hora,
                motivo,
                dni
        );
    }//GEN-LAST:event_btnEditarTurnoActionPerformed

    private void btnBuscarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTurnoActionPerformed
        String texto =
                campoBusquedaTurnos.getText().trim();

        if (texto.isEmpty()
                || texto.equals(
                        "Buscar por DNI, dueño o animal"
                )) {

            cargarTabla();
            return;
        }

        buscarTurnos(texto);
    }//GEN-LAST:event_btnBuscarTurnoActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
            cargarTabla();

       campoBusquedaTurnos.setText(
               "Buscar por DNI, dueño o animal"
       );

       campoBusquedaTurnos.setForeground(
               new java.awt.Color(140, 140, 140)
       );

       campoBusquedaTurnos.setCaretPosition(0);
    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp =
                new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        int fila = tblTurnos.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un turno"
            );

            return;
        }

        int idTurno = Integer.parseInt(
                tblTurnos.getValueAt(fila, 0).toString()
        );

        String nuevoEstado =
                cmbEstado.getSelectedItem().toString();

        try {

            TurnoController.cambiarEstado(
                    idTurno,
                    nuevoEstado
            );

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "Estado actualizado correctamente"
            );

            cargarTabla();

        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo actualizar el estado: "
                    + e.getMessage()
            );
        }
    }//GEN-LAST:event_btnCambiarEstadoActionPerformed

    private void btnVencidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVencidosActionPerformed
            ventanaPrincipal.mostrarTurnosVencidos();
            
    }//GEN-LAST:event_btnVencidosActionPerformed
    private void aplicarColoresEstado() {

        javax.swing.table.DefaultTableCellRenderer renderEstado =
                new javax.swing.table.DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column
            ) {

                java.awt.Component componente =
                        super.getTableCellRendererComponent(
                                table,
                                value,
                                isSelected,
                                hasFocus,
                                row,
                                column
                        );

                componente.setBackground(
                        java.awt.Color.WHITE
                );

                componente.setForeground(
                        Estilos.VERDE_OSCURO
                );

                if (value != null) {

                    String estado =
                            value.toString()
                                    .trim()
                                    .toUpperCase();

                    switch (estado) {

                        case "PENDIENTE":
                            componente.setBackground(
                                    new java.awt.Color(
                                            255,
                                            243,
                                            176
                                    )
                            );

                            componente.setForeground(
                                    new java.awt.Color(
                                            145,
                                            105,
                                            0
                                    )
                            );
                            break;

                        case "EN ATENCIÓN":
                            componente.setBackground(
                                    new java.awt.Color(
                                            190,
                                            225,
                                            255
                                    )
                            );

                            componente.setForeground(
                                    new java.awt.Color(
                                            30,
                                            95,
                                            160
                                    )
                            );
                            break;

                        case "FINALIZADO":
                            componente.setBackground(
                                    new java.awt.Color(
                                            190,
                                            245,
                                            205
                                    )
                            );

                            componente.setForeground(
                                    new java.awt.Color(
                                            30,
                                            125,
                                            70
                                    )
                            );
                            break;

                        case "CANCELADO":
                            componente.setBackground(
                                    new java.awt.Color(
                                            255,
                                            205,
                                            205
                                    )
                            );

                            componente.setForeground(
                                    new java.awt.Color(
                                            180,
                                            55,
                                            55
                                    )
                            );
                            break;

                        case "VENCIDO":
                            componente.setBackground(
                                    new java.awt.Color(
                                            255,
                                            220,
                                            175
                                    )
                            );

                            componente.setForeground(
                                    new java.awt.Color(
                                            190,
                                            90,
                                            20
                                    )
                            );
                            break;
                    }
                }

                setHorizontalAlignment(
                        javax.swing.SwingConstants.CENTER
                );

                return componente;
            }
        };

        tblTurnos.getColumnModel()
                .getColumn(7)
                .setCellRenderer(
                        renderEstado
                );
    }
    private void configurarColumnasTurnos() {

        if (tblTurnos.getColumnCount() < 9) {
            return;
        }

        javax.swing.table.TableColumn columnaId =
                tblTurnos.getColumnModel().getColumn(0);

        columnaId.setMinWidth(0);
        columnaId.setMaxWidth(0);
        columnaId.setPreferredWidth(0);
        columnaId.setResizable(false);
        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblTurnos.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        tblTurnos.getColumnModel()
                .getColumn(4)
                .setCellRenderer(centrado);

        tblTurnos.getColumnModel()
                .getColumn(5)
                .setCellRenderer(centrado);

        javax.swing.table.TableColumn columnaAcciones =
                tblTurnos.getColumnModel().getColumn(8);

        columnaAcciones.setMinWidth(95);
        columnaAcciones.setMaxWidth(95);
        columnaAcciones.setPreferredWidth(95);
        columnaAcciones.setResizable(false);

        columnaAcciones.setCellRenderer(
                new RenderizadorAcciones()
        );

        columnaAcciones.setCellEditor(
                new EditorAcciones()
        );
        tblTurnos.addMouseMotionListener(
                new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseMoved(
                    java.awt.event.MouseEvent e
            ) {

                int fila =
                        tblTurnos.rowAtPoint(
                                e.getPoint()
                        );

                int columnaVista =
                        tblTurnos.columnAtPoint(
                                e.getPoint()
                        );

                boolean sobreAcciones =
                        fila >= 0
                        && columnaVista >= 0
                        && tblTurnos.convertColumnIndexToModel(
                                columnaVista
                        ) == 8;

                tblTurnos.setCursor(
                        sobreAcciones
                                ? java.awt.Cursor.getPredefinedCursor(
                                        java.awt.Cursor.HAND_CURSOR
                                )
                                : java.awt.Cursor.getDefaultCursor()
                );

                tblTurnos.repaint();
            }
        });

        tblTurnos.addMouseListener(
                new java.awt.event.MouseAdapter() {

            @Override
            public void mouseExited(
                    java.awt.event.MouseEvent e
            ) {

                tblTurnos.setCursor(
                        java.awt.Cursor.getDefaultCursor()
                );

                tblTurnos.repaint();
            }
        });
        tblTurnos.setRowHeight(32);
    }
    private void configurarEditorEstado() {

        javax.swing.JComboBox<String> comboEstados =
                new javax.swing.JComboBox<>(
                        new String[]{
                            "PENDIENTE",
                            "EN ATENCIÓN",
                            "FINALIZADO",
                            "CANCELADO",
                            "VENCIDO"
                        }
                );

        comboEstados.setFont(
                Estilos.fuenteNormal()
        );

        comboEstados.setForeground(
                Estilos.VERDE_OSCURO
        );

        tblTurnos.getColumnModel()
                .getColumn(7)
                .setCellEditor(
                        new javax.swing.DefaultCellEditor(
                                comboEstados
                        )
                );
        tblTurnos.getModel().addTableModelListener(
                evento -> {

                    if (evento.getType()
                            != javax.swing.event.TableModelEvent.UPDATE
                            || evento.getColumn() != 7) {

                        return;
                    }

                    int fila =
                            evento.getFirstRow();

                    if (fila < 0) {
                        return;
                    }

                    int idTurno =
                            Integer.parseInt(
                                    tblTurnos.getModel()
                                            .getValueAt(
                                                    fila,
                                                    0
                                            )
                                            .toString()
                            );

                    String nuevoEstado =
                            tblTurnos.getModel()
                                    .getValueAt(
                                            fila,
                                            7
                                    )
                                    .toString();

                    try {

                        TurnoController.cambiarEstado(
                                idTurno,
                                nuevoEstado
                        );

                        javax.swing.SwingUtilities.invokeLater(() -> {

                            tblTurnos.clearSelection();
                            aplicarColoresEstado();
                            tblTurnos.repaint();
                        });

                    } catch (Exception e) {

                        Estilos.mostrarAdvertencia(
                                this,
                                "Error",
                                "No se pudo actualizar el estado"
                        );

                        javax.swing.SwingUtilities.invokeLater(
                                this::cargarTabla
                        );
                    }
                }
        );
    }
    private void configurarDiseñoTurnos() {

        setTitle(
                "Henry System Vet - Gestión de turnos"
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
                new javax.swing.JPanel();

        panelPrincipal.setOpaque(false);

        panelPrincipal.setLayout(
                new java.awt.BorderLayout()
        );

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


        lblTitulo.setText(
                "Gestión de turnos"
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


        javax.swing.JPanel tarjetaTurnos =
                new javax.swing.JPanel();

        tarjetaTurnos.setBackground(
                Estilos.BLANCO
        );

        tarjetaTurnos.setLayout(
                new java.awt.BorderLayout(
                        0,
                        20
                )
        );

        tarjetaTurnos.setBorder(
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
                tblTurnos
        );

        scrollTurnos.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollTurnos.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        400
                )
        );

        tarjetaTurnos.add(
                scrollTurnos,
                java.awt.BorderLayout.CENTER
        );


        Estilos.estilizarBoton(btnCrearTurno);
        Estilos.estilizarBoton(btnEditarTurno);
        Estilos.estilizarBoton(btnEliminarTurno);
        Estilos.estilizarBoton(btnBuscarTurno);
        Estilos.estilizarBoton(btnMostrarTodos);
        Estilos.estilizarBoton(btnCambiarEstado);
        Estilos.estilizarBoton(btnVencidos);
        Estilos.estilizarBoton(btnVolver);


        javax.swing.JPanel panelAcciones =
                new javax.swing.JPanel();

        panelAcciones.setOpaque(false);

        panelAcciones.setLayout(
                new javax.swing.BoxLayout(
                        panelAcciones,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );


        javax.swing.JPanel filaPrincipal =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        filaPrincipal.setOpaque(false);


        java.awt.Dimension tamañoBoton =
                new java.awt.Dimension(
                        160,
                        38
                );

        btnCrearTurno.setPreferredSize(tamañoBoton);
        btnEditarTurno.setPreferredSize(tamañoBoton);
        btnEliminarTurno.setPreferredSize(tamañoBoton);
        btnBuscarTurno.setPreferredSize(tamañoBoton);
        btnMostrarTodos.setPreferredSize(tamañoBoton);
        btnVencidos.setPreferredSize(tamañoBoton);


        filaPrincipal.add(btnCrearTurno);
        filaPrincipal.add(btnEditarTurno);
        filaPrincipal.add(btnEliminarTurno);
        filaPrincipal.add(btnBuscarTurno);
        filaPrincipal.add(btnMostrarTodos);
        filaPrincipal.add(btnVencidos);


        javax.swing.JPanel filaEstado =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        filaEstado.setOpaque(false);


        javax.swing.JLabel lblEstado =
                new javax.swing.JLabel(
                        "ESTADO:"
                );

        lblEstado.setFont(
                Estilos.fuenteBoton()
        );

        lblEstado.setForeground(
                Estilos.VERDE_OSCURO
        );


        cmbEstado.setFont(
                Estilos.fuenteNormal()
        );

        cmbEstado.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );


        btnCambiarEstado.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );


        filaEstado.add(lblEstado);
        filaEstado.add(cmbEstado);
        filaEstado.add(btnCambiarEstado);


        panelAcciones.add(
                filaPrincipal
        );

        panelAcciones.add(
                javax.swing.Box.createVerticalStrut(12)
        );

        panelAcciones.add(
                filaEstado
        );


        tarjetaTurnos.add(
                panelAcciones,
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
                tarjetaTurnos,
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

        aplicarColoresEstado();

        revalidate();
        repaint();
       
    }
    public javax.swing.JPanel obtenerPanelTurnos() {

        javax.swing.JPanel panel =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panel.setBackground(
                Estilos.VERDE_PRINCIPAL
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

        lblTitulo.setText(
                "GESTIÓN DE TURNOS"
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

        javax.swing.JPanel tarjetaTurnos =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaTurnos.setBackground(
                Estilos.BLANCO
        );

        tarjetaTurnos.setBorder(
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
                tblTurnos
        );

        scrollTurnos.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );       

        tarjetaTurnos.add(
                scrollTurnos,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnCrearTurno
        );

        Estilos.estilizarBotonEditar(
                btnEditarTurno
        );

        Estilos.estilizarBotonEliminar(
                btnEliminarTurno
        );

        Estilos.estilizarBoton(
                btnBuscarTurno
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );

        

       

        Estilos.aplicarIcono(
                btnCrearTurno,
                "/imagenes/iconos/agregar.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnEditarTurno,
                "/imagenes/iconos/editar.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnMostrarTodos,
                "/imagenes/iconos/mostrar_todos.png",
                18,
                18
        );

        
        
        

        btnEliminarTurno.setIcon(
                null
        );

        btnBuscarTurno.setText("");

        btnBuscarTurno.setToolTipText(
                "Buscar turno"
        );

        Estilos.aplicarIcono(
                btnBuscarTurno,
                "/imagenes/iconos/buscar.png",
                20,
                20
        );

        java.awt.Dimension tamañoBuscar =
                new java.awt.Dimension(
                        42,
                        38
                );

        btnBuscarTurno.setPreferredSize(
                tamañoBuscar
        );

        btnBuscarTurno.setMinimumSize(
                tamañoBuscar
        );

        btnBuscarTurno.setMaximumSize(
                tamañoBuscar
        );

        javax.swing.JButton btnInicio =
                new javax.swing.JButton(
                        "Inicio"
                );

        Estilos.estilizarBoton(
                btnInicio
        );

        Estilos.aplicarIcono(
                btnInicio,
                "/imagenes/iconos/inicio.png",
                18,
                18
        );

        btnInicio.setPreferredSize(
                new java.awt.Dimension(
                        110,
                        38
                )
        );

        btnInicio.addActionListener(e -> {

            if (ventanaPrincipal != null) {
                ventanaPrincipal.mostrarInicio();
            }
        });

        javax.swing.JPanel panelInicio =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                0,
                                0
                        )
                );

        panelInicio.setOpaque(false);

        panelInicio.add(
                btnInicio
        );

        campoBusquedaTurnos =
                new javax.swing.JTextField(
                        "Buscar por DNI, dueño o animal"
                );

        campoBusquedaTurnos.setFont(
                Estilos.fuenteNormal()
        );

        campoBusquedaTurnos.setForeground(
                new java.awt.Color(140, 140, 140)
        );

        campoBusquedaTurnos.setPreferredSize(
                new java.awt.Dimension(300, 38)
        );

        campoBusquedaTurnos.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                0,
                                10,
                                0,
                                10
                        )
                )
        );

        campoBusquedaTurnos.setCaretPosition(0);

        campoBusquedaTurnos.addFocusListener(
                new java.awt.event.FocusAdapter() {

            @Override
            public void focusGained(
                    java.awt.event.FocusEvent e
            ) {

                if (campoBusquedaTurnos.getText().equals(
                        "Buscar por DNI, dueño o animal"
                )) {

                    campoBusquedaTurnos.setText("");

                    campoBusquedaTurnos.setForeground(
                            Estilos.VERDE_OSCURO
                    );
                }
            }

            @Override
            public void focusLost(
                    java.awt.event.FocusEvent e
            ) {

                if (campoBusquedaTurnos.getText()
                        .trim().isEmpty()) {

                    campoBusquedaTurnos.setText(
                            "Buscar por DNI, dueño o animal"
                    );

                    campoBusquedaTurnos.setForeground(
                            new java.awt.Color(
                                    140,
                                    140,
                                    140
                            )
                    );

                    campoBusquedaTurnos.setCaretPosition(0);
                }
            }
        });

        campoBusquedaTurnos.addActionListener(e ->
                btnBuscarTurno.doClick()
        );

        btnMostrarTodos.setText(
                "Actualizar tabla"
        );

        java.awt.Dimension tamañoActualizar =
                new java.awt.Dimension(205, 38);

        btnMostrarTodos.setPreferredSize(tamañoActualizar);
        btnMostrarTodos.setMinimumSize(tamañoActualizar);
        btnMostrarTodos.setMaximumSize(tamañoActualizar);

        javax.swing.JPanel panelBusqueda =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                8,
                                0
                        )
                );

        panelBusqueda.setOpaque(false);

        panelBusqueda.add(btnMostrarTodos);
        panelBusqueda.add(campoBusquedaTurnos);
        panelBusqueda.add(btnBuscarTurno);

        javax.swing.JPanel panelAccionesSuperiores =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelAccionesSuperiores.setOpaque(false);

        panelAccionesSuperiores.add(
                panelInicio,
                java.awt.BorderLayout.WEST
        );

        panelAccionesSuperiores.add(
                panelBusqueda,
                java.awt.BorderLayout.EAST
        );

        tarjetaTurnos.add(
                panelAccionesSuperiores,
                java.awt.BorderLayout.NORTH
        );

        btnCrearTurno.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnEditarTurno.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnEliminarTurno.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );
       
        

        

        javax.swing.JPanel panelAcciones =
                new javax.swing.JPanel();

        panelAcciones.setOpaque(false);

        panelAcciones.setLayout(
                new javax.swing.BoxLayout(
                        panelAcciones,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        javax.swing.JPanel filaPrincipal =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        filaPrincipal.setOpaque(false);

        filaPrincipal.add(
                btnCrearTurno
        );

        

        panelAcciones.add(
                filaPrincipal
        );


        tarjetaTurnos.add(
                panelAcciones,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaTurnos,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        aplicarColoresEstado();

        return panel;
    }
    private class RenderizadorAcciones
            extends javax.swing.JPanel
            implements javax.swing.table.TableCellRenderer {

        private final javax.swing.JButton btnEditar =
                crearBotonEditar();

        private final javax.swing.JButton btnEliminar =
                crearBotonEliminar();

        private final java.awt.Color colorEditarNormal =
                btnEditar.getBackground();

        private final java.awt.Color colorEliminarNormal =
                btnEliminar.getBackground();

        public RenderizadorAcciones() {

            setLayout(
                    new java.awt.FlowLayout(
                            java.awt.FlowLayout.CENTER,
                            4,
                            4
                    )
            );

            setOpaque(true);

            add(btnEditar);
            add(btnEliminar);
        }

    @Override
    public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable tabla,
                Object valor,
                boolean seleccionado,
                boolean tieneFoco,
                int fila,
                int columna
        ) {

            setBackground(
                    seleccionado
                            ? tabla.getSelectionBackground()
                            : tabla.getBackground()
            );

            boolean sobreEditar = false;
            boolean sobreEliminar = false;

            java.awt.Point posicionMouse =
                    tabla.getMousePosition();

            if (posicionMouse != null) {

                int filaMouse =
                        tabla.rowAtPoint(posicionMouse);

                int columnaMouse =
                        tabla.columnAtPoint(posicionMouse);

                if (filaMouse == fila
                        && columnaMouse == columna) {

                    java.awt.Rectangle celda =
                            tabla.getCellRect(
                                    fila,
                                    columna,
                                    false
                            );

                    int posicionDentro =
                            posicionMouse.x - celda.x;

                    if (posicionDentro < celda.width / 2) {
                        sobreEditar = true;
                    } else {
                        sobreEliminar = true;
                    }
                }
            }

            btnEditar.setBackground(
                    sobreEditar
                            ? colorEditarNormal.brighter()
                            : colorEditarNormal
            );

            btnEliminar.setBackground(
                    sobreEliminar
                            ? new java.awt.Color(255, 165, 165)
                            : colorEliminarNormal
            );

            return this;
        }
    }

    private class EditorAcciones
            extends javax.swing.AbstractCellEditor
            implements javax.swing.table.TableCellEditor {

        private final javax.swing.JPanel panel =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                4,
                                4
                        )
                );

        private final javax.swing.JButton btnEditar =
                crearBotonEditar();

        private final javax.swing.JButton btnEliminar =
                crearBotonEliminar();

        private int filaActual = -1;

    public EditorAcciones() {

        panel.setOpaque(true);

        panel.add(btnEditar);
        panel.add(btnEliminar);

        btnEditar.addActionListener(e -> {

            int fila = filaActual;

            fireEditingStopped();

            if (fila >= 0) {

                tblTurnos.setRowSelectionInterval(
                        fila,
                        fila
                );

                btnEditarTurnoActionPerformed(null);
            }
        });

        btnEliminar.addActionListener(e -> {

            int fila = filaActual;

            fireEditingStopped();

            if (fila >= 0) {

                tblTurnos.setRowSelectionInterval(
                        fila,
                        fila
                );

                btnEliminarTurnoActionPerformed(null);
            }
        });
    }

    @Override
    public java.awt.Component getTableCellEditorComponent(
            javax.swing.JTable tabla,
            Object valor,
            boolean seleccionado,
            int fila,
            int columna
    ) {

        filaActual = fila;

        panel.setBackground(
                tabla.getSelectionBackground()
        );

        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}

    private javax.swing.JButton crearBotonEditar() {

        javax.swing.JButton boton =
                new javax.swing.JButton();

        Estilos.estilizarBotonEditar(boton);

        boton.setText("");

        Estilos.aplicarIcono(
                boton,
                "/imagenes/iconos/editar.png",
                14,
                14
        );

        java.awt.Dimension tamaño =
                new java.awt.Dimension(26, 22);

        boton.setPreferredSize(tamaño);
        boton.setMinimumSize(tamaño);
        boton.setMaximumSize(tamaño);

        boton.setToolTipText("Editar turno");
        boton.setFocusable(false);

        boton.setCursor(
                java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return boton;
    }

    private javax.swing.JButton crearBotonEliminar() {

        javax.swing.JButton boton =
                new javax.swing.JButton();

        Estilos.estilizarBotonEliminar(boton);

        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setBorderPainted(false);
        boton.setText("");

        Estilos.aplicarIcono(
                boton,
                "/imagenes/iconos/eliminar.png",
                14,
                14
        );

        java.awt.Dimension tamaño =
                new java.awt.Dimension(30, 22);

        boton.setPreferredSize(tamaño);
        boton.setMinimumSize(tamaño);
        boton.setMaximumSize(tamaño);

        boton.setToolTipText("Eliminar turno");
        boton.setFocusable(false);

        boton.setCursor(
                java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return boton;
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaTurnos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarTurno;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnCrearTurno;
    private javax.swing.JButton btnEditarTurno;
    private javax.swing.JButton btnEliminarTurno;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnVencidos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollTurnos;
    private javax.swing.JTable tblTurnos;
    // End of variables declaration//GEN-END:variables
}
