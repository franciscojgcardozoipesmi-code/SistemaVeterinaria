package sistemaveterinaria;
import controller.ProcedimientoMedicoController;
public class VentanaHistorialMedico extends javax.swing.JFrame {
    private int idAnimal;
    private String nombreAnimal;
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaHistorialMedico.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    public VentanaHistorialMedico() {
        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        aplicarDiseñoHistorialMedico();
    }
    public VentanaHistorialMedico(
                int idAnimal,
                String nombreAnimal,
                String rolUsuario
        ) {

            initComponents();

            this.idAnimal = idAnimal;
            this.nombreAnimal = nombreAnimal;
            this.rolUsuario = rolUsuario;

            setExtendedState(
                    javax.swing.JFrame.MAXIMIZED_BOTH
            );

            cargarHistorial();

            aplicarDiseñoHistorialMedico();
        }

        public VentanaHistorialMedico(
            int idAnimal,
            String nombreAnimal,
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.idAnimal = idAnimal;
        this.nombreAnimal = nombreAnimal;
        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarHistorial();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnimal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAnimal.setText("Historial médico");

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblHistorial);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAnimal)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnVolver)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnVolver)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    if (ventanaPrincipal != null) {

            ventanaPrincipal.mostrarAnimales();

        } else {

            VentanaAnimales va =
                    new VentanaAnimales(rolUsuario);

            va.setVisible(true);

            this.dispose();
        }   
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cargarHistorial() {

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

        modelo.addColumn("Fecha");
        modelo.addColumn("Tipo");
        modelo.addColumn("Emergencia");
        modelo.addColumn("Descripción");
        modelo.addColumn("Monto");

        for (Object[] fila :
                ProcedimientoMedicoController.listarPorAnimal(idAnimal)) {

            modelo.addRow(fila);
        }

        tblHistorial.setModel(modelo);
    }
    private void aplicarDiseñoHistorialMedico() {

        setTitle(
                "Henry System Vet - Historial médico"
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

        String titulo;

        if (nombreAnimal != null
                && !nombreAnimal.trim().isEmpty()) {

            titulo =
                    "HISTORIAL MÉDICO - "
                    + nombreAnimal.toUpperCase();

        } else {

            titulo =
                    "HISTORIAL MÉDICO";
        }

        lblAnimal.setText(
                titulo
        );

        lblAnimal.setFont(
                Estilos.fuente(26f)
        );

        lblAnimal.setForeground(
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
                lblAnimal
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

        javax.swing.JPanel tarjetaHistorial =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaHistorial.setBackground(
                Estilos.BLANCO
        );

        tarjetaHistorial.setBorder(
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
                tblHistorial
        );

        jScrollPane1.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        jScrollPane1.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        400
                )
        );

        if (tblHistorial.getColumnCount() >= 5) {

            javax.swing.table.DefaultTableCellRenderer centrado =
                    new javax.swing.table.DefaultTableCellRenderer();

            centrado.setHorizontalAlignment(
                    javax.swing.SwingConstants.CENTER
            );

            tblHistorial.getColumnModel()
                    .getColumn(0)
                    .setCellRenderer(centrado);

            tblHistorial.getColumnModel()
                    .getColumn(2)
                    .setCellRenderer(centrado);

            tblHistorial.getColumnModel()
                    .getColumn(4)
                    .setCellRenderer(centrado);
        }

        tarjetaHistorial.add(
                jScrollPane1,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnVolver
        );

        btnVolver.setPreferredSize(
                new java.awt.Dimension(
                        120,
                        38
                )
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

        panelInferior.add(
                btnVolver
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaHistorial,
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
    
    public javax.swing.JPanel obtenerPanelHistorialMedico() {

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

        String titulo;

        if (nombreAnimal != null
                && !nombreAnimal.trim().isEmpty()) {

            titulo =
                    "HISTORIAL MÉDICO - "
                    + nombreAnimal.toUpperCase();

        } else {

            titulo = "HISTORIAL MÉDICO";
        }

        lblAnimal.setText(
                titulo
        );

        lblAnimal.setFont(
                Estilos.fuente(26f)
        );

        lblAnimal.setForeground(
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
                lblAnimal
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

        javax.swing.JPanel panelEncabezado =
                new javax.swing.JPanel();

        panelEncabezado.setOpaque(false);

        panelEncabezado.setLayout(
                new javax.swing.BoxLayout(
                        panelEncabezado,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        panelEncabezado.add(
                contenedorTitulo
        );

        panelEncabezado.add(
                javax.swing.Box.createVerticalStrut(25)
        );

        javax.swing.JPanel tarjetaHistorial =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaHistorial.setBackground(
                Estilos.BLANCO
        );

        tarjetaHistorial.setBorder(
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
                tblHistorial
        );

        jScrollPane1.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        if (tblHistorial.getColumnCount() >= 5) {

            javax.swing.table.DefaultTableCellRenderer centrado =
                    new javax.swing.table.DefaultTableCellRenderer();

            centrado.setHorizontalAlignment(
                    javax.swing.SwingConstants.CENTER
            );

            tblHistorial.getColumnModel()
                    .getColumn(0)
                    .setCellRenderer(centrado);

            tblHistorial.getColumnModel()
                    .getColumn(2)
                    .setCellRenderer(centrado);

            tblHistorial.getColumnModel()
                    .getColumn(4)
                    .setCellRenderer(centrado);
        }

        tarjetaHistorial.add(
                jScrollPane1,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnVolver
        );

        btnVolver.setPreferredSize(
                new java.awt.Dimension(
                        120,
                        38
                )
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

        panelInferior.add(
                btnVolver
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaHistorial,
                java.awt.BorderLayout.CENTER
        );

        panelPrincipal.add(
                panelInferior,
                java.awt.BorderLayout.SOUTH
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaHistorialMedico().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnimal;
    private javax.swing.JTable tblHistorial;
    // End of variables declaration//GEN-END:variables
}
