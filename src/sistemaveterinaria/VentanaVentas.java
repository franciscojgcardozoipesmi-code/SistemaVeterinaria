
package sistemaveterinaria;
import controller.VentaController;

public class VentanaVentas extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaVentas.class.getName());

    public VentanaVentas() {
        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarVentas();

        configurarDiseñoVentas();
    }
    public VentanaVentas(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarVentas();

        configurarDiseñoVentas();
    }
    private void cargarVentas() {
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
        modelo.addColumn("Fecha");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Total");
        modelo.addColumn("Medio de pago");

       for (Object[] fila : VentaController.listarVentasConDetalle()) {
            modelo.addRow(fila);
        }

       tblVentas.setModel(modelo);
   }
       
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearVenta = new javax.swing.JButton();
        scrollVentas = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnEliminarVenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrearVenta.setText("Crear venta");
        btnCrearVenta.addActionListener(this::btnCrearVentaActionPerformed);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollVentas.setViewportView(tblVentas);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        btnEliminarVenta.setText("Anular venta");
        btnEliminarVenta.addActionListener(this::btnEliminarVentaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnEliminarVenta)
                        .addGap(26, 26, 26)
                        .addComponent(btnCrearVenta)
                        .addGap(27, 27, 27)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(scrollVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(scrollVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearVenta)
                    .addComponent(btnVolver)
                    .addComponent(btnEliminarVenta))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVentaActionPerformed
        VentanaCrearVenta vcv = new VentanaCrearVenta(rolUsuario);
        vcv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearVentaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp =
        new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        int fila = tblVentas.getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una venta para anular."
            );
            return;
        }

        int idVenta = Integer.parseInt(
                tblVentas.getValueAt(fila, 0).toString()
        );

        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea anular la venta seleccionada?",
                "Confirmar anulación",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {

            try {

                VentaController.eliminarVenta(idVenta);

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Venta anulada correctamente."
                );

                cargarVentas();

            } catch (Exception e) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Error al anular la venta: " + e.getMessage()
                );
            }
        }
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void configurarDiseñoVentas() {

        setTitle(
                "Henry System Vet - Gestión de ventas"
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


        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "GESTIÓN DE VENTAS"
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


        javax.swing.JPanel tarjetaVentas =
                new javax.swing.JPanel();

        tarjetaVentas.setBackground(
                Estilos.BLANCO
        );

        tarjetaVentas.setLayout(
                new java.awt.BorderLayout(
                        0,
                        20
                )
        );

        tarjetaVentas.setBorder(
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
                tblVentas
        );

        scrollVentas.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollVentas.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        400
                )
        );


        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblVentas.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblVentas.getColumnModel()
                .getColumn(1)
                .setCellRenderer(centrado);

        tblVentas.getColumnModel()
                .getColumn(3)
                .setCellRenderer(centrado);

        tblVentas.getColumnModel()
                .getColumn(4)
                .setCellRenderer(centrado);

        tblVentas.getColumnModel()
                .getColumn(5)
                .setCellRenderer(centrado);

        tblVentas.getColumnModel()
                .getColumn(6)
                .setCellRenderer(centrado);

        tblVentas.getColumnModel()
                .getColumn(7)
                .setCellRenderer(centrado);


        tarjetaVentas.add(
                scrollVentas,
                java.awt.BorderLayout.CENTER
        );


        Estilos.estilizarBoton(
                btnCrearVenta
        );

        Estilos.estilizarBotonEliminar(
                btnEliminarVenta
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


        btnCrearVenta.setPreferredSize(
                new java.awt.Dimension(
                        160,
                        38
                )
        );

        btnEliminarVenta.setPreferredSize(
                new java.awt.Dimension(
                        160,
                        38
                )
        );


        panelBotones.add(
                btnCrearVenta
        );

        panelBotones.add(
                btnEliminarVenta
        );


        tarjetaVentas.add(
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
                tarjetaVentas,
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
    
        java.awt.EventQueue.invokeLater(() -> new VentanaVentas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearVenta;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollVentas;
    private javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables
}
