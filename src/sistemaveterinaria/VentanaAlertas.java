package sistemaveterinaria;
import controller.ProductoController;
import controller.TurnoController;
public class VentanaAlertas extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAlertas.class.getName());

 
    public VentanaAlertas() {
        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        configurarDiseñoAlertas();
        prepararTablaVacia();
    }
    
    public VentanaAlertas(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        configurarDiseñoAlertas();
        prepararTablaVacia();
    }

    private void cargarTurnosProximos() {

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
        modelo.addColumn("Dueño");
        modelo.addColumn("DNI");
        modelo.addColumn("Animal");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Motivo");

        for (Object[] fila :
                TurnoController.listarTurnosProximos()) {

            modelo.addRow(fila);
        }

        tblAlertas.setModel(modelo);
        Estilos.estilizarTabla(
                tblAlertas
        );
        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblAlertas.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblAlertas.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        tblAlertas.getColumnModel()
                .getColumn(4)
                .setCellRenderer(centrado);

        tblAlertas.getColumnModel()
                .getColumn(5)
                .setCellRenderer(centrado);
    }
    private void cargarProductosProximosAVencer() {

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
        modelo.addColumn("Producto");
        modelo.addColumn("Stock");
        modelo.addColumn("Fecha vencimiento");

        for (Object[] fila :
                ProductoController.listarProximosAVencer()) {

            modelo.addRow(fila);
        }

        tblAlertas.setModel(modelo);
        Estilos.estilizarTabla(
                tblAlertas
        );
        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblAlertas.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblAlertas.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        tblAlertas.getColumnModel()
                .getColumn(3)
                .setCellRenderer(centrado);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollAlertas = new javax.swing.JScrollPane();
        tblAlertas = new javax.swing.JTable();
        btnProductosVencer = new javax.swing.JButton();
        btnTurnosProximos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAlertas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollAlertas.setViewportView(tblAlertas);

        btnProductosVencer.setText("Productos Vencer");
        btnProductosVencer.addActionListener(this::btnProductosVencerActionPerformed);

        btnTurnosProximos.setText("Turnos Proximos");
        btnTurnosProximos.addActionListener(this::btnTurnosProximosActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(scrollAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnProductosVencer)
                        .addGap(74, 74, 74)
                        .addComponent(btnTurnosProximos)
                        .addGap(70, 70, 70)
                        .addComponent(btnVolver)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scrollAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductosVencer)
                    .addComponent(btnTurnosProximos)
                    .addComponent(btnVolver))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
          VentanaPrincipal vp =
                new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnProductosVencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosVencerActionPerformed
        cargarProductosProximosAVencer();
    }//GEN-LAST:event_btnProductosVencerActionPerformed

    private void btnTurnosProximosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnosProximosActionPerformed
  

        cargarTurnosProximos();
    
    }//GEN-LAST:event_btnTurnosProximosActionPerformed

    private void configurarDiseñoAlertas() {

        setTitle(
                "Henry System Vet - Alertas"
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
                        "ALERTAS"
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

        javax.swing.JPanel tarjetaAlertas =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaAlertas.setBackground(
                Estilos.BLANCO
        );

        tarjetaAlertas.setBorder(
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
                tblAlertas
        );

        scrollAlertas.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollAlertas.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        400
                )
        );

        tarjetaAlertas.add(
                scrollAlertas,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnProductosVencer
        );

        Estilos.estilizarBoton(
                btnTurnosProximos
        );

        Estilos.estilizarBoton(
                btnVolver
        );

        btnProductosVencer.setText(
                "Productos por vencer"
        );

        btnTurnosProximos.setText(
                "Turnos próximos"
        );

        btnProductosVencer.setPreferredSize(
                new java.awt.Dimension(
                        220,
                        38
                )
        );

        btnTurnosProximos.setPreferredSize(
                new java.awt.Dimension(
                        170,
                        38
                )
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

        panelBotones.add(
                btnProductosVencer
        );

        panelBotones.add(
                btnTurnosProximos
        );

        tarjetaAlertas.add(
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
                tarjetaAlertas,
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
    
    private void prepararTablaVacia() {

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

        tblAlertas.setModel(modelo);
    }
    public javax.swing.JPanel obtenerPanelAlertas() {

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

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "ALERTAS"
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

        javax.swing.JPanel tarjetaAlertas =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaAlertas.setBackground(
                Estilos.BLANCO
        );

        tarjetaAlertas.setBorder(
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
                tblAlertas
        );

        scrollAlertas.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        tarjetaAlertas.add(
                scrollAlertas,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnProductosVencer
        );

        Estilos.estilizarBoton(
                btnTurnosProximos
        );

        btnProductosVencer.setText(
                "Productos por vencer"
        );

        btnTurnosProximos.setText(
                "Turnos próximos"
        );

        btnProductosVencer.setPreferredSize(
                new java.awt.Dimension(
                        220,
                        38
                )
        );

        btnTurnosProximos.setPreferredSize(
                new java.awt.Dimension(
                        170,
                        38
                )
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

        panelBotones.add(
                btnProductosVencer
        );

        panelBotones.add(
                btnTurnosProximos
        );

        tarjetaAlertas.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaAlertas,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new VentanaAlertas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductosVencer;
    private javax.swing.JButton btnTurnosProximos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollAlertas;
    private javax.swing.JTable tblAlertas;
    // End of variables declaration//GEN-END:variables
}
