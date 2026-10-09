package sistemaveterinaria;
import controller.VentaController;
public class VentanaReportesVentas extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaReportesVentas.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    private final PanelGraficoVentas panelGraficoVentas =
        new PanelGraficoVentas();
    public VentanaReportesVentas() {
        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        configurarDiseñoReportes();
        prepararTablaVacia();
        configurarCampoFecha(txtDesde);
        configurarCampoFecha(txtHasta);
    }
    
    public VentanaReportesVentas(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        configurarDiseñoReportes();
        prepararTablaVacia();
        configurarCampoFecha(txtDesde);
        configurarCampoFecha(txtHasta);
    }
    
    public VentanaReportesVentas(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        prepararTablaVacia();
        configurarCampoFecha(txtDesde);
        configurarCampoFecha(txtHasta);
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDesde = new javax.swing.JLabel();
        txtDesde = new javax.swing.JTextField();
        lblHasta = new javax.swing.JLabel();
        txtHasta = new javax.swing.JTextField();
        btnGenerarReporte = new javax.swing.JButton();
        scrollReporteVentas = new javax.swing.JScrollPane();
        tblReporteVentas = new javax.swing.JTable();
        lblTotalVendido = new javax.swing.JLabel();
        lblCantidadVentas = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblProductoMasVendido = new javax.swing.JLabel();
        lblCantidadMasVendida = new javax.swing.JLabel();
        lblMedioPagoMasUtilizado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDesde.setText("Desde");

        lblHasta.setText("Hasta");

        txtHasta.addActionListener(this::txtHastaActionPerformed);

        btnGenerarReporte.setText("Generar reporte");
        btnGenerarReporte.addActionListener(this::btnGenerarReporteActionPerformed);

        tblReporteVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollReporteVentas.setViewportView(tblReporteVentas);

        lblTotalVendido.setText("Total vendido:");

        lblCantidadVentas.setText("Cantidad de ventas:");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        lblProductoMasVendido.setText("Producto más vendido:");

        lblCantidadMasVendida.setText("Cantidad vendida:");

        lblMedioPagoMasUtilizado.setText("Medio de pago más utilizado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalVendido)
                            .addComponent(btnGenerarReporte)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblCantidadVentas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductoMasVendido)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCantidadMasVendida)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMedioPagoMasUtilizado)
                                    .addComponent(btnVolver))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(scrollReporteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesde)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHasta))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnGenerarReporte)
                        .addGap(67, 67, 67)
                        .addComponent(lblTotalVendido)
                        .addGap(28, 28, 28)
                        .addComponent(lblCantidadVentas)
                        .addGap(18, 18, 18)
                        .addComponent(lblProductoMasVendido)
                        .addGap(18, 18, 18)
                        .addComponent(lblCantidadMasVendida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMedioPagoMasUtilizado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollReporteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        try {

            String desde = txtDesde.getText().trim();
            String hasta = txtHasta.getText().trim();

            if (desde.isEmpty() || hasta.isEmpty()) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Completá las fechas Desde y Hasta"
                );

                return;
            }

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

            java.util.ArrayList<Object[]> lista =
                    VentaController.listarVentasPorFecha(
                            desde,
                            hasta
                    );

            double totalVendido = 0;

            java.util.HashSet<Integer> ventasContadas =
                    new java.util.HashSet<>();
            java.util.HashMap<String, Integer> cantidadesPorProducto =
                    new java.util.HashMap<>();
            java.util.HashMap<String, Integer> cantidadPorMedioPago =
                    new java.util.HashMap<>();
            for (Object[] fila : lista) {

                modelo.addRow(fila);
                String producto =
                        fila[2].toString();

                int cantidad =
                        Integer.parseInt(fila[3].toString());

                cantidadesPorProducto.put(
                        producto,
                        cantidadesPorProducto.getOrDefault(producto, 0) + cantidad
                );
                int idVenta =
                        Integer.parseInt(fila[0].toString());

                if (!ventasContadas.contains(idVenta)) {

                    totalVendido += Double.parseDouble(
                            fila[6].toString()
                    );
                    String medioPago = fila[7] != null
                            ? fila[7].toString()
                            : "Sin especificar";

                    cantidadPorMedioPago.put(
                            medioPago,
                            cantidadPorMedioPago.getOrDefault(medioPago, 0) + 1
                    );
                    ventasContadas.add(idVenta);
                }
            }
            String productoMasVendido = "";
            String medioPagoMasUtilizado = "";
            int mayorUso = 0;
            int cantidadEmpatados = 0;

            for (String medioPago : cantidadPorMedioPago.keySet()) {

                int cantidadUsos =
                        cantidadPorMedioPago.get(medioPago);

                if (cantidadUsos > mayorUso) {

                    mayorUso = cantidadUsos;
                    medioPagoMasUtilizado = medioPago;
                    cantidadEmpatados = 1;

                } else if (cantidadUsos == mayorUso) {

                    cantidadEmpatados++;
                }
            }
            if (medioPagoMasUtilizado.isEmpty()) {

                lblMedioPagoMasUtilizado.setText(
                        "Medio de pago más utilizado: Sin datos"
                );

            } else if (cantidadEmpatados > 1) {

                lblMedioPagoMasUtilizado.setText(
                        "Medio de pago más utilizado: Empate"
                );

            } else {

                lblMedioPagoMasUtilizado.setText(
                        "Medio de pago más utilizado: "
                        + medioPagoMasUtilizado
                );
            }
                        int mayorCantidad = 0;

            for (String producto : cantidadesPorProducto.keySet()) {

                int cantidad =
                        cantidadesPorProducto.get(producto);

                if (cantidad > mayorCantidad) {

                    mayorCantidad = cantidad;
                    productoMasVendido = producto;
                }
            }
            if (!productoMasVendido.isEmpty()) {

                lblProductoMasVendido.setText(
                        "Producto más vendido: " + productoMasVendido
                );

                lblCantidadMasVendida.setText(
                        "Cantidad vendida: " + mayorCantidad
                );

            } else {

                lblProductoMasVendido.setText(
                        "Producto más vendido: Sin datos"
                );

                lblCantidadMasVendida.setText(
                        "Cantidad vendida: 0"
                );
            }
            tblReporteVentas.setModel(modelo);
            
            Estilos.estilizarTabla(
                    tblReporteVentas
            );

            javax.swing.table.DefaultTableCellRenderer centrado =
                    new javax.swing.table.DefaultTableCellRenderer();

            centrado.setHorizontalAlignment(
                    javax.swing.SwingConstants.CENTER
            );

            tblReporteVentas.getColumnModel()
                    .getColumn(0)
                    .setCellRenderer(centrado);

            tblReporteVentas.getColumnModel()
                    .getColumn(1)
                    .setCellRenderer(centrado);

            tblReporteVentas.getColumnModel()
                    .getColumn(3)
                    .setCellRenderer(centrado);

            tblReporteVentas.getColumnModel()
                    .getColumn(4)
                    .setCellRenderer(centrado);

            tblReporteVentas.getColumnModel()
                    .getColumn(5)
                    .setCellRenderer(centrado);

            tblReporteVentas.getColumnModel()
                    .getColumn(6)
                    .setCellRenderer(centrado);

            tblReporteVentas.getColumnModel()
                    .getColumn(7)
                    .setCellRenderer(centrado);

            lblTotalVendido.setText(
                    "Total vendido: $" + totalVendido
            );

            lblCantidadVentas.setText(
                    "Cantidad de ventas: "
                    + ventasContadas.size()
            );
            panelGraficoVentas.actualizarDatos(
                    cantidadesPorProducto
            );
        } catch (Exception e) {
            
            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo generar el reporte: "
                    + e.getMessage()
            );
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp =
               new VentanaPrincipal(rolUsuario);

       vp.setVisible(true);

       this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHastaActionPerformed
    private void configurarDiseñoReportes() {

        setTitle(
                "Henry System Vet - Reportes de ventas"
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
                        "REPORTES DE VENTAS"
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
        contenedorTitulo.add(panelTitulo);

        panelEncabezado.add(
                contenedorTitulo
        );

        panelEncabezado.add(
                javax.swing.Box.createVerticalStrut(25)
        );

        javax.swing.JPanel tarjetaReporte =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaReporte.setBackground(
                Estilos.BLANCO
        );

        tarjetaReporte.setBorder(
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

        javax.swing.JPanel panelFiltros =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                12,
                                0
                        )
                );

        panelFiltros.setOpaque(false);

        lblDesde.setFont(
                Estilos.fuenteNormal()
        );

        lblHasta.setFont(
                Estilos.fuenteNormal()
        );

        lblDesde.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblHasta.setForeground(
                Estilos.VERDE_OSCURO
        );

        txtDesde.setFont(
                Estilos.fuenteNormal()
        );

        txtHasta.setFont(
                Estilos.fuenteNormal()
        );

        txtDesde.setPreferredSize(
                new java.awt.Dimension(
                        150,
                        35
                )
        );

        txtHasta.setPreferredSize(
                new java.awt.Dimension(
                        150,
                        35
                )
        );

        Estilos.estilizarBoton(
                btnGenerarReporte
        );

        btnGenerarReporte.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        panelFiltros.add(lblDesde);
        panelFiltros.add(txtDesde);
        panelFiltros.add(lblHasta);
        panelFiltros.add(txtHasta);
        panelFiltros.add(btnGenerarReporte);

        

        Estilos.estilizarTabla(
                tblReporteVentas
        );

        scrollReporteVentas.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollReporteVentas.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        350
                )
        );

        tarjetaReporte.add(
                scrollReporteVentas,
                java.awt.BorderLayout.CENTER
        );

        javax.swing.JPanel panelResumen =
                new javax.swing.JPanel();

        panelResumen.setOpaque(false);

        panelResumen.setLayout(
                new java.awt.GridLayout(
                        3,
                        2,
                        20,
                        12
                )
        );

        javax.swing.JLabel[] indicadores = {
            lblTotalVendido,
            lblCantidadVentas,
            lblProductoMasVendido,
            lblCantidadMasVendida,
            lblMedioPagoMasUtilizado
        };

        for (javax.swing.JLabel indicador : indicadores) {

            indicador.setFont(
                    Estilos.fuenteNormal()
            );

            indicador.setForeground(
                    Estilos.VERDE_OSCURO
            );
        }

        panelResumen.add(lblTotalVendido);
        panelResumen.add(lblCantidadVentas);
        panelResumen.add(lblProductoMasVendido);
        panelResumen.add(lblCantidadMasVendida);
        panelResumen.add(lblMedioPagoMasUtilizado);

        tarjetaReporte.add(
                panelResumen,
                java.awt.BorderLayout.SOUTH
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
        panelInferior.add(btnVolver);

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaReporte,
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

        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Total");
        modelo.addColumn("Medio de pago");

        tblReporteVentas.setModel(modelo);

        Estilos.estilizarTabla(
                tblReporteVentas
        );
    }
    public javax.swing.JPanel obtenerPanelReportes() {

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
                        "Reportes de ventas"
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
        contenedorTitulo.add(panelTitulo);

        panelEncabezado.add(
                contenedorTitulo
        );

        panelEncabezado.add(
                javax.swing.Box.createVerticalStrut(25)
        );

        javax.swing.JPanel tarjetaReporte =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaReporte.setBackground(
                Estilos.BLANCO
        );
        
        tarjetaReporte.setBorder(
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

        javax.swing.JPanel panelFiltros =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                12,
                                0
                        )
                );

        panelFiltros.setOpaque(false);

        lblDesde.setFont(
                Estilos.fuenteNormal()
        );

        lblHasta.setFont(
                Estilos.fuenteNormal()
        );

        lblDesde.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblHasta.setForeground(
                Estilos.VERDE_OSCURO
        );

        txtDesde.setFont(
                Estilos.fuenteNormal()
        );

        txtHasta.setFont(
                Estilos.fuenteNormal()
        );

        txtDesde.setPreferredSize(
                new java.awt.Dimension(
                        150,
                        35
                )
        );

        txtHasta.setPreferredSize(
                new java.awt.Dimension(
                        150,
                        35
                )
        );

        Estilos.estilizarBoton(
                btnGenerarReporte
        );

        btnGenerarReporte.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        panelFiltros.add(lblDesde);
        panelFiltros.add(txtDesde);
        panelFiltros.add(lblHasta);
        panelFiltros.add(txtHasta);
        panelFiltros.add(btnGenerarReporte);
        
        tarjetaReporte.add(
                panelFiltros,
                java.awt.BorderLayout.NORTH
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

        javax.swing.JPanel panelSuperior =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                20,
                                0
                        )
                );

        panelSuperior.setOpaque(false);

        panelSuperior.add(
                panelInicio,
                java.awt.BorderLayout.WEST
        );
        
        panelSuperior.add(
                panelFiltros,
                java.awt.BorderLayout.CENTER
        );

        tarjetaReporte.add(
                panelSuperior,
                java.awt.BorderLayout.NORTH
        );
        Estilos.estilizarTabla(
                tblReporteVentas
        );

        scrollReporteVentas.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        tarjetaReporte.add(
                scrollReporteVentas,
                java.awt.BorderLayout.CENTER
        );

        javax.swing.JPanel panelResumen =
                new javax.swing.JPanel();

        panelResumen.setOpaque(false);

        panelResumen.setLayout(
                new java.awt.GridLayout(
                        5,
                        1,
                        0,
                        6
                )
        );

        javax.swing.JLabel[] indicadores = {
            lblTotalVendido,
            lblCantidadVentas,
            lblProductoMasVendido,
            lblCantidadMasVendida,
            lblMedioPagoMasUtilizado
        };

        for (javax.swing.JLabel indicador : indicadores) {

            indicador.setFont(
                    Estilos.fuenteNormal()
            );

            indicador.setForeground(
                    Estilos.VERDE_OSCURO
            );
        }

        panelResumen.add(
                lblTotalVendido
        );

        panelResumen.add(
                lblCantidadVentas
        );

        panelResumen.add(
                lblProductoMasVendido
        );

        panelResumen.add(
                lblCantidadMasVendida
        );

        panelResumen.add(
                lblMedioPagoMasUtilizado
        );

        panelResumen.setPreferredSize(
                new java.awt.Dimension(
                        380,
                        175
                )
        );

        javax.swing.JPanel panelZonaInferior =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                30,
                                0
                        )
                );

        panelZonaInferior.setOpaque(false);

        panelZonaInferior.add(
                panelResumen,
                java.awt.BorderLayout.WEST
        );

        panelZonaInferior.add(
                panelGraficoVentas,
                java.awt.BorderLayout.CENTER
        );

        tarjetaReporte.add(
                panelZonaInferior,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaReporte,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    private void configurarCampoFecha(
            javax.swing.JTextField campo
    ) {

        javax.swing.text.AbstractDocument documento =
                (javax.swing.text.AbstractDocument)
                        campo.getDocument();

        documento.setDocumentFilter(
                new javax.swing.text.DocumentFilter() {

            private String formatearFecha(
                    String texto
            ) {

                String numeros =
                        texto.replaceAll(
                                "[^0-9]",
                                ""
                        );

                if (numeros.length() > 8) {

                    numeros =
                            numeros.substring(
                                    0,
                                    8
                            );
                }

                StringBuilder resultado =
                        new StringBuilder();

                if (numeros.length() > 0) {

                    resultado.append(
                            numeros.substring(
                                    0,
                                    Math.min(
                                            2,
                                            numeros.length()
                                    )
                            )
                    );
                }

                if (numeros.length() >= 2) {
                    resultado.append("/");
                }

                if (numeros.length() > 2) {

                    resultado.append(
                            numeros.substring(
                                    2,
                                    Math.min(
                                            4,
                                            numeros.length()
                                    )
                            )
                    );
                }

                if (numeros.length() >= 4) {
                    resultado.append("/");
                }

                if (numeros.length() > 4) {

                    resultado.append(
                            numeros.substring(
                                    4
                            )
                    );
                }

                return resultado.toString();
            }

            @Override
            public void insertString(
                    FilterBypass fb,
                    int desplazamiento,
                    String texto,
                    javax.swing.text.AttributeSet atributos
            ) throws javax.swing.text.BadLocationException {

                replace(
                        fb,
                        desplazamiento,
                        0,
                        texto,
                        atributos
                );
            }

            @Override
            public void replace(
                    FilterBypass fb,
                    int desplazamiento,
                    int cantidad,
                    String texto,
                    javax.swing.text.AttributeSet atributos
            ) throws javax.swing.text.BadLocationException {

                String textoActual =
                        fb.getDocument().getText(
                                0,
                                fb.getDocument().getLength()
                        );

                String textoNuevo =
                        textoActual.substring(
                                0,
                                desplazamiento
                        )
                        + (texto == null ? "" : texto)
                        + textoActual.substring(
                                desplazamiento + cantidad
                        );

                fb.replace(
                        0,
                        fb.getDocument().getLength(),
                        formatearFecha(textoNuevo),
                        atributos
                );
            }

            @Override
            public void remove(
                    FilterBypass fb,
                    int desplazamiento,
                    int cantidad
            ) throws javax.swing.text.BadLocationException {

                String textoActual =
                        fb.getDocument().getText(
                                0,
                                fb.getDocument().getLength()
                        );

                if (cantidad == 1
                        && desplazamiento < textoActual.length()
                        && textoActual.charAt(desplazamiento) == '/'
                        && desplazamiento > 0) {

                    desplazamiento--;
                    cantidad = 2;
                }

                String textoNuevo =
                        textoActual.substring(
                                0,
                                desplazamiento
                        )
                        + textoActual.substring(
                                desplazamiento + cantidad
                        );

                fb.replace(
                        0,
                        fb.getDocument().getLength(),
                        formatearFecha(textoNuevo),
                        null
                );
            }
        });
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new VentanaReportesVentas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblCantidadMasVendida;
    private javax.swing.JLabel lblCantidadVentas;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblMedioPagoMasUtilizado;
    private javax.swing.JLabel lblProductoMasVendido;
    private javax.swing.JLabel lblTotalVendido;
    private javax.swing.JScrollPane scrollReporteVentas;
    private javax.swing.JTable tblReporteVentas;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    // End of variables declaration//GEN-END:variables
}
