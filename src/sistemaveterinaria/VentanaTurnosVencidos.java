package sistemaveterinaria;
import controller.TurnoController;
public class VentanaTurnosVencidos extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaTurnosVencidos.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    public VentanaTurnosVencidos() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarTabla();
    }
    public VentanaTurnosVencidos(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarTabla();
    }
    public VentanaTurnosVencidos(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarTabla();
    }
    private void cargarTabla() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel(
                        new Object[]{
                            "ID",
                            "Dueño",
                            "DNI",
                            "Animal",
                            "Fecha",
                            "Hora",
                            "Motivo",
                            "Estado",
                            "Acciones"
                        },
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int fila,
                            int columna
                    ) {

                        return columna == 8;
                    }
                };

        for (Object[] fila
                : TurnoController.listarTurnosVencidos()) {

            modelo.addRow(
                    new Object[]{
                        fila[0],
                        fila[1],
                        fila[2],
                        fila[3],
                        fila[4],
                        fila[5],
                        fila[6],
                        fila[7],
                        ""
                    }
            );
        }

        tblTurnosVencidos.setModel(
                modelo
        );

        javax.swing.table.TableColumn columnaId =
                tblTurnosVencidos
                        .getColumnModel()
                        .getColumn(0);

        columnaId.setMinWidth(0);
        columnaId.setPreferredWidth(0);
        columnaId.setMaxWidth(0);
        columnaId.setResizable(false);

        javax.swing.table.TableColumn columnaAcciones =
                tblTurnosVencidos
                        .getColumnModel()
                        .getColumn(8);

        columnaAcciones.setPreferredWidth(
                85
        );

        columnaAcciones.setMinWidth(
                85
        );

        columnaAcciones.setMaxWidth(
                85
        );
        configurarColumnaAcciones();
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
        if (ventanaPrincipal != null) {

            ventanaPrincipal.mostrarTurnos();

        } else {

            VentanaTurnos vt =
                    new VentanaTurnos(rolUsuario);

            vt.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnReprogramarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReprogramarTurnoActionPerformed
            int fila =
                tblTurnosVencidos.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un turno"
            );

            return;
        }

        int id = Integer.parseInt(
                tblTurnosVencidos
                        .getValueAt(fila, 0)
                        .toString()
        );

        String dueno =
                tblTurnosVencidos
                        .getValueAt(fila, 1)
                        .toString();

        String dni =
                tblTurnosVencidos
                        .getValueAt(fila, 2)
                        .toString();

        String animal =
                tblTurnosVencidos
                        .getValueAt(fila, 3)
                        .toString();

        String fecha =
                tblTurnosVencidos
                        .getValueAt(fila, 4)
                        .toString();

        String hora =
                tblTurnosVencidos
                        .getValueAt(fila, 5)
                        .toString();

        String motivo =
                tblTurnosVencidos
                        .getValueAt(fila, 6)
                        .toString();

        ventanaPrincipal.mostrarReprogramarTurno(
                id,
                dueno,
                animal,
                fecha,
                hora,
                motivo,
                dni
        );   
    }//GEN-LAST:event_btnReprogramarTurnoActionPerformed
    private void configurarColumnaAcciones() {

        javax.swing.table.TableColumn columnaAcciones =
                tblTurnosVencidos
                        .getColumnModel()
                        .getColumn(8);

        columnaAcciones.setCellRenderer(
                new RenderizadorEliminar()
        );

        columnaAcciones.setCellEditor(
                new EditorEliminar()
        );
    }

    private void eliminarTurnoVencido(
            int idTurno
    ) {

        boolean confirmado =
                Estilos.mostrarConfirmacion(
                        this,
                        "Confirmar eliminación",
                        "¿Deseás eliminar definitivamente este turno vencido?"
                );

        if (!confirmado) {
            return;
        }

        try {

            TurnoController.eliminarTurno(
                    idTurno
            );

            cargarTabla();

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "Turno vencido eliminado correctamente"
            );

        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar el turno vencido"
            );
        }
    }

    private class RenderizadorEliminar
            extends javax.swing.JPanel
            implements javax.swing.table.TableCellRenderer {

        private final javax.swing.JButton btnEliminar =
                crearBotonEliminar();

        public RenderizadorEliminar() {

            setLayout(
                    new java.awt.FlowLayout(
                            java.awt.FlowLayout.CENTER,
                            0,
                            6
                    )
            );

            setOpaque(
                    true
            );

            add(
                    btnEliminar
            );
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

            return this;
        }
    }

    private class EditorEliminar
            extends javax.swing.AbstractCellEditor
            implements javax.swing.table.TableCellEditor {

        private final javax.swing.JPanel panel =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                6
                        )
                );

        private final javax.swing.JButton btnEliminar =
                crearBotonEliminar();

        private int idTurno;

        public EditorEliminar() {

            panel.setOpaque(
                    true
            );

            panel.add(
                    btnEliminar
            );

            btnEliminar.addActionListener(
                    evento -> {

                        int idSeleccionado =
                                idTurno;

                        fireEditingStopped();

                        eliminarTurnoVencido(
                                idSeleccionado
                        );
                    }
            );
        }

        @Override
        public java.awt.Component getTableCellEditorComponent(
                javax.swing.JTable tabla,
                Object valor,
                boolean seleccionado,
                int fila,
                int columna
        ) {

            int filaModelo =
                    tabla.convertRowIndexToModel(
                            fila
                    );

            idTurno =
                    Integer.parseInt(
                            tabla.getModel()
                                    .getValueAt(
                                            filaModelo,
                                            0
                                    )
                                    .toString()
                    );

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

    private javax.swing.JButton crearBotonEliminar() {

        javax.swing.JButton boton =
                new javax.swing.JButton();

        Estilos.estilizarBotonEliminar(
                boton
        );

        boton.setText("");

        Estilos.aplicarIcono(
                boton,
                "/imagenes/iconos/eliminar.png",
                14,
                14
        );

        java.awt.Dimension tamaño =
                new java.awt.Dimension(
                        30,
                        26
                );

        boton.setPreferredSize(
                tamaño
        );

        boton.setMinimumSize(
                tamaño
        );

        boton.setMaximumSize(
                tamaño
        );

        boton.setToolTipText(
                "Eliminar turno vencido"
        );

        boton.setFocusable(
                false
        );

        boton.setCursor(
                java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return boton;
    }
    public javax.swing.JPanel obtenerPanelTurnosVencidos() {

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
                        20,
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
                "TURNOS VENCIDOS"
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

        panelTitulo.add(lblTitulo);

        javax.swing.JPanel contenedorTitulo =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                0
                        )
                );

        contenedorTitulo.setOpaque(false);
        contenedorTitulo.add(panelTitulo);

        panelEncabezado.add(
                contenedorTitulo
        );

        panelEncabezado.add(
                javax.swing.Box.createVerticalStrut(25)
        );

        javax.swing.JPanel tarjeta =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjeta.setBackground(
                Estilos.BLANCO
        );

        tarjeta.setBorder(
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
                tblTurnosVencidos
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

        btnInicio.addActionListener(
                evento -> ventanaPrincipal.mostrarInicio()
        );

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

        tarjeta.add(
                panelInicio,
                java.awt.BorderLayout.NORTH
        );

        jScrollPane1.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        tarjeta.add(
                jScrollPane1,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnReprogramarTurno
        );

        

        btnReprogramarTurno.setPreferredSize(
                new java.awt.Dimension(
                        190,
                        38
                )
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

        panelBotones.add(
                btnReprogramarTurno
        );

        

        tarjeta.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjeta,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }

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
