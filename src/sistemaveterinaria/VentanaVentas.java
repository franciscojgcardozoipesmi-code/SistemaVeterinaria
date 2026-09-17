package sistemaveterinaria;
import controller.VentaController;

public class VentanaVentas extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaVentas.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    private javax.swing.JButton btnBuscarVenta;
    private javax.swing.JButton btnMostrarTodos;
    public VentanaVentas() {
        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarVentas();

        configurarDiseñoVentas();
        inicializarBotonesVentas();
    }
    public VentanaVentas(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarVentas();

        configurarDiseñoVentas();
        inicializarBotonesVentas();
    }
    public VentanaVentas(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarVentas();
        inicializarBotonesVentas();
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
        ventanaPrincipal.mostrarCrearVenta();
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
            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una venta para anular"
            );
            return;
        }

        int idVenta = Integer.parseInt(
                tblVentas.getValueAt(fila, 0).toString()
        );

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Confirmar anulación",
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
                        "CONFIRMAR ANULACIÓN",
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
                        "¿Seguro que querés anular la venta seleccionada?",
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
                VentaController.eliminarVenta(idVenta);

                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Operación exitosa",
                        "Venta anulada correctamente"
                );

                cargarVentas();

            } catch (Exception ex) {
                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Error",
                        "No se pudo anular la venta"
                );
            }
        });

        dialogo.setContentPane(panelPrincipal);
        dialogo.setSize(450, 180);
        dialogo.setLocationRelativeTo(ventanaPadre);
        dialogo.setVisible(true);
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
    public javax.swing.JPanel obtenerPanelVentas() {

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
                        "Gestión de ventas"
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
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaVentas.setBackground(
                Estilos.BLANCO
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
                btnBuscarVenta
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );

        Estilos.aplicarIcono(
                btnCrearVenta,
                "/imagenes/iconos/agregar.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnMostrarTodos,
                "/imagenes/iconos/mostrar_todos.png",
                18,
                18
        );

        btnEliminarVenta.setIcon(
                null
        );

        btnBuscarVenta.setText("");

        btnBuscarVenta.setToolTipText(
                "Buscar venta"
        );

        Estilos.aplicarIcono(
                btnBuscarVenta,
                "/imagenes/iconos/buscar.png",
                20,
                20
        );

        java.awt.Dimension tamañoBuscar =
                new java.awt.Dimension(
                        42,
                        38
                );

        btnBuscarVenta.setPreferredSize(
                tamañoBuscar
        );

        btnBuscarVenta.setMinimumSize(
                tamañoBuscar
        );

        btnBuscarVenta.setMaximumSize(
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

        javax.swing.JPanel panelBusqueda =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                0,
                                0
                        )
                );

        panelBusqueda.setOpaque(false);

        panelBusqueda.add(
                btnBuscarVenta
        );

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

        tarjetaVentas.add(
                panelAccionesSuperiores,
                java.awt.BorderLayout.NORTH
        );

        btnCrearVenta.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        btnEliminarVenta.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        btnMostrarTodos.setPreferredSize(
                new java.awt.Dimension(
                        180,
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
                btnCrearVenta
        );

        panelBotones.add(
                btnEliminarVenta
        );

        panelBotones.add(
                btnMostrarTodos
        );

        tarjetaVentas.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaVentas,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    
    private void buscarVentas(
            String filtro
    ) {
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

        modelo.addColumn(
                "ID"
        );

        modelo.addColumn(
                "Fecha"
        );

        modelo.addColumn(
                "Producto"
        );

        modelo.addColumn(
                "Cantidad"
        );

        modelo.addColumn(
                "Precio"
        );

        modelo.addColumn(
                "Subtotal"
        );

        modelo.addColumn(
                "Total"
        );

        modelo.addColumn(
                "Medio de pago"
        );

        for (Object[] fila
                : VentaController.buscarVentas(filtro)) {

            modelo.addRow(
                    fila
            );
        }

        tblVentas.setModel(
                modelo
        );
    }
    private void inicializarBotonesVentas() {

        btnBuscarVenta =
                new javax.swing.JButton(
                        "Buscar"
                );

        btnMostrarTodos =
                new javax.swing.JButton(
                        "Mostrar todos"
                );

        btnBuscarVenta.addActionListener(e ->
                mostrarDialogoBuscarVentas()
        );

        btnMostrarTodos.addActionListener(e ->
                cargarVentas()
        );
    }
    
    private void mostrarDialogoBuscarVentas() {

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(
                        this
                );

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Buscar venta",
                        java.awt.Dialog.ModalityType.APPLICATION_MODAL
                );

        dialogo.setUndecorated(
                true
        );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        panelPrincipal.setBackground(
                Estilos.BLANCO
        );

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                2
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                0,
                                25,
                                25,
                                25
                        )
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "BUSCAR VENTA",
                        javax.swing.SwingConstants.CENTER
                );

        lblTitulo.setFont(
                Estilos.fuente(20f)
        );

        lblTitulo.setForeground(
                Estilos.BLANCO
        );

        javax.swing.JPanel panelTitulo =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelTitulo.setBackground(
                Estilos.VERDE_OSCURO
        );

        panelTitulo.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        12,
                        20,
                        12,
                        20
                )
        );

        panelTitulo.add(
                lblTitulo,
                java.awt.BorderLayout.CENTER
        );

        javax.swing.JLabel lblBuscar =
                new javax.swing.JLabel(
                        "Buscar por ID, fecha, producto o medio de pago:"
                );

        lblBuscar.setFont(
                Estilos.fuenteNormal()
        );

        lblBuscar.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblBuscar.setAlignmentX(
                java.awt.Component.LEFT_ALIGNMENT
        );

        javax.swing.JTextField campoBuscar =
                new javax.swing.JTextField();

        campoBuscar.setFont(
                Estilos.fuenteNormal()
        );

        campoBuscar.setMaximumSize(
                new java.awt.Dimension(
                        Integer.MAX_VALUE,
                        38
                )
        );

        campoBuscar.setPreferredSize(
                new java.awt.Dimension(
                        320,
                        34
                )
        );

        campoBuscar.setAlignmentX(
                java.awt.Component.LEFT_ALIGNMENT
        );

        javax.swing.JPanel panelCentro =
                new javax.swing.JPanel();

        panelCentro.setOpaque(
                false
        );

        panelCentro.setLayout(
                new javax.swing.BoxLayout(
                        panelCentro,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        panelCentro.add(
                lblBuscar
        );

        panelCentro.add(
                javax.swing.Box.createVerticalStrut(
                        10
                )
        );

        panelCentro.add(
                campoBuscar
        );

        javax.swing.JButton btnBuscarDialogo =
                new javax.swing.JButton(
                        "Buscar"
                );

        javax.swing.JButton btnCancelarDialogo =
                new javax.swing.JButton(
                        "Cancelar"
                );

        Estilos.estilizarBoton(
                btnBuscarDialogo
        );

        Estilos.estilizarBoton(
                btnCancelarDialogo
        );

        btnBuscarDialogo.setPreferredSize(
                new java.awt.Dimension(
                        105,
                        34
                )
        );

        btnCancelarDialogo.setPreferredSize(
                new java.awt.Dimension(
                        105,
                        34
                )
        );

        javax.swing.JPanel panelBotones =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(
                false
        );

        panelBotones.add(
                btnCancelarDialogo
        );

        panelBotones.add(
                btnBuscarDialogo
        );

        javax.swing.JPanel contenido =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        contenido.setOpaque(
                false
        );

        contenido.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        5,
                        0,
                        0,
                        0
                )
        );

        contenido.add(
                panelCentro,
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

        btnBuscarDialogo.addActionListener(e -> {

            String texto =
                    campoBuscar.getText().trim();

            if (!texto.isEmpty()) {

                buscarVentas(
                        texto
                );

                dialogo.dispose();
            }
        });

        campoBuscar.addActionListener(e ->
                btnBuscarDialogo.doClick()
        );

        dialogo.getRootPane().setDefaultButton(
                btnBuscarDialogo
        );

        dialogo.setContentPane(
                panelPrincipal
        );

        dialogo.setSize(
                430,
                200
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(
                true
        );
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
