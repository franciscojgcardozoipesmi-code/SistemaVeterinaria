package sistemaveterinaria;
import controller.ProductoController;
public class VentanaProductos extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaProductos.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JTextField campoBusquedaProductos;
    public VentanaProductos() {
        initComponents();
        inicializarBotonesProductos();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoProductos();
    }
    
    public VentanaProductos(
            String rolUsuario
    ) {
        initComponents();
        inicializarBotonesProductos();

        this.rolUsuario =
                rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoProductos();
    }
    public VentanaProductos(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {
        initComponents();
        inicializarBotonesProductos();

        this.rolUsuario =
                rolUsuario;

        this.ventanaPrincipal =
                ventanaPrincipal;

        cargarTabla();

        configurarDiseñoProductos();
    }

    private void cargarTabla() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {
                return column == 5;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Fecha vencimiento");
        modelo.addColumn("Acciones");

        for (Object[] fila
                : ProductoController.listarProductos()) {

            Object[] filaCompleta =
                    java.util.Arrays.copyOf(
                            fila,
                            6
                    );

            filaCompleta[5] = "";

            modelo.addRow(filaCompleta);
        }

        tblProductos.setModel(modelo);

        configurarColumnasProductos();
        aplicarColorVencimiento();
    }
    
    private void buscarProductos(
            String filtro
    ) {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {
                return column == 5;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Fecha vencimiento");
        modelo.addColumn("Acciones");

        for (Object[] fila
                : ProductoController.buscarProductos(filtro)) {

            Object[] filaCompleta =
                    java.util.Arrays.copyOf(
                            fila,
                            6
                    );

            filaCompleta[5] = "";

            modelo.addRow(filaCompleta);
        }

        tblProductos.setModel(modelo);

        configurarColumnasProductos();
        aplicarColorVencimiento();
    }
    
    private void configurarColumnasProductos() {

        if (tblProductos.getColumnCount() < 6) {
            return;
        }

        javax.swing.table.TableColumn columnaId =
                tblProductos.getColumnModel()
                        .getColumn(0);

        columnaId.setMinWidth(0);
        columnaId.setMaxWidth(0);
        columnaId.setPreferredWidth(0);
        columnaId.setResizable(false);
        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblProductos.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        tblProductos.getColumnModel()
                .getColumn(3)
                .setCellRenderer(centrado);

        javax.swing.table.TableColumn columnaAcciones =
                tblProductos.getColumnModel()
                        .getColumn(5);

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

        tblProductos.addMouseMotionListener(
                new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseMoved(
                    java.awt.event.MouseEvent e
            ) {

                int fila =
                        tblProductos.rowAtPoint(
                                e.getPoint()
                        );

                int columnaVista =
                        tblProductos.columnAtPoint(
                                e.getPoint()
                        );

                boolean sobreAcciones =
                        fila >= 0
                        && columnaVista >= 0
                        && tblProductos.convertColumnIndexToModel(
                                columnaVista
                        ) == 5;

                tblProductos.setCursor(
                        sobreAcciones
                                ? java.awt.Cursor.getPredefinedCursor(
                                        java.awt.Cursor.HAND_CURSOR
                                )
                                : java.awt.Cursor.getDefaultCursor()
                );

                tblProductos.repaint();
            }
        });

        tblProductos.addMouseListener(
                new java.awt.event.MouseAdapter() {

            @Override
            public void mouseExited(
                    java.awt.event.MouseEvent e
            ) {

                tblProductos.setCursor(
                        java.awt.Cursor.getDefaultCursor()
                );

                tblProductos.repaint();
            }
        });

        tblProductos.setRowHeight(32);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        scrollProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrearProducto.setText("Crear producto");
        btnCrearProducto.addActionListener(this::btnCrearProductoActionPerformed);

        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addActionListener(this::btnEliminarProductoActionPerformed);

        btnEditarProducto.setText("Editar producto");
        btnEditarProducto.addActionListener(this::btnEditarProductoActionPerformed);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollProductos.setViewportView(tblProductos);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCrearProducto)
                        .addGap(61, 61, 61)
                        .addComponent(btnEliminarProducto)
                        .addGap(92, 92, 92)
                        .addComponent(btnEditarProducto)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(301, 301, 301))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProducto)
                    .addComponent(btnEliminarProducto)
                    .addComponent(btnCrearProducto))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
          ventanaPrincipal.mostrarCrearProducto();
    }//GEN-LAST:event_btnCrearProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int fila = tblProductos.getSelectedRow();

        if (fila == -1) {
            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un producto"
            );
            return;
        }

        int idProducto = Integer.parseInt(
                tblProductos.getValueAt(fila, 0).toString()
        );

        String nombreProducto =
                tblProductos.getValueAt(fila, 1).toString();

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
                        "¿Seguro que querés eliminar el producto "
                        + nombreProducto + "?",
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
                ProductoController.eliminarProducto(idProducto);

                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Operación exitosa",
                        "Producto eliminado correctamente"
                );

                cargarTabla();

            } catch (Exception ex) {
                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Error",
                        "No se pudo eliminar el producto"
                );
            }
        });

        dialogo.setContentPane(panelPrincipal);
        dialogo.setSize(440, 180);
        dialogo.setLocationRelativeTo(ventanaPadre);
        dialogo.setVisible(true);
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        int fila = tblProductos.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un producto"
            );

            return;
        }

        int idProducto = Integer.parseInt(
                tblProductos.getValueAt(fila, 0).toString()
        );

        String nombre =
                tblProductos.getValueAt(fila, 1).toString();

        double precio = Double.parseDouble(
                tblProductos.getValueAt(fila, 2).toString()
        );

        int stock = Integer.parseInt(
                tblProductos.getValueAt(fila, 3).toString()
        );

        Object valorFecha =
                tblProductos.getValueAt(fila, 4);

        String fechaVencimiento = "";

        if (valorFecha != null) {
            fechaVencimiento =
                    valorFecha.toString();
        }

        ventanaPrincipal.mostrarEditarProducto(
                idProducto,
                nombre,
                precio,
                stock,
                fechaVencimiento
        );
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp = new VentanaPrincipal(rolUsuario);
        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    private void configurarDiseñoProductos() {

        setTitle(
                "Henry System Vet - Gestión de productos"
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
                        "GESTIÓN DE PRODUCTOS"
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


        javax.swing.JPanel tarjetaProductos =
                new javax.swing.JPanel();

        tarjetaProductos.setBackground(
                Estilos.BLANCO
        );

        tarjetaProductos.setLayout(
                new java.awt.BorderLayout(
                        0,
                        20
                )
        );

        tarjetaProductos.setBorder(
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
                tblProductos
        );

        scrollProductos.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollProductos.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        400
                )
        );


        


        tarjetaProductos.add(
                scrollProductos,
                java.awt.BorderLayout.CENTER
        );


        Estilos.estilizarBoton(
                btnCrearProducto
        );

        Estilos.estilizarBoton(
                btnEditarProducto
        );

        Estilos.estilizarBoton(
                btnEliminarProducto
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


        java.awt.Dimension tamañoBoton =
                new java.awt.Dimension(
                        175,
                        38
                );

        btnCrearProducto.setPreferredSize(
                tamañoBoton
        );

        btnEditarProducto.setPreferredSize(
                tamañoBoton
        );

        btnEliminarProducto.setPreferredSize(
                tamañoBoton
        );


        panelBotones.add(
                btnCrearProducto
        );

        panelBotones.add(
                btnEditarProducto
        );

        panelBotones.add(
                btnEliminarProducto
        );


        tarjetaProductos.add(
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
                tarjetaProductos,
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
        aplicarColorVencimiento();
        revalidate();
        repaint();
    }
    
    private void aplicarColorVencimiento() {

        tblProductos.getColumnModel()
                .getColumn(4)
                .setCellRenderer(
                        new javax.swing.table.DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable tabla,
                    Object valor,
                    boolean seleccionado,
                    boolean tieneFoco,
                    int fila,
                    int columna
            ) {

                java.awt.Component componente =
                        super.getTableCellRendererComponent(
                                tabla,
                                valor,
                                seleccionado,
                                false,
                                fila,
                                columna
                        );

                setHorizontalAlignment(
                        javax.swing.SwingConstants.CENTER
                );

                componente.setFont(
                        Estilos.fuenteNormal()
                );

                if (seleccionado) {

                    componente.setBackground(
                            Estilos.VERDE_OSCURO
                    );

                    componente.setForeground(
                            Estilos.BLANCO
                    );

                    return componente;
                }

                componente.setBackground(
                        Estilos.BLANCO
                );

                componente.setForeground(
                        Estilos.VERDE_OSCURO
                );

                if (valor != null) {

                    try {

                        java.time.format.DateTimeFormatter formato =
                                java.time.format.DateTimeFormatter.ofPattern(
                                        "dd/MM/yyyy"
                                );

                        java.time.LocalDate fechaVencimiento =
                                java.time.LocalDate.parse(
                                        valor.toString(),
                                        formato
                                );

                        java.time.LocalDate hoy =
                                java.time.LocalDate.now();

                        java.time.LocalDate limite =
                                hoy.plusDays(7);

                        if (fechaVencimiento.isBefore(hoy)) {

                            componente.setBackground(
                                    new java.awt.Color(
                                            255,
                                            218,
                                            218
                                    )
                            );

                            componente.setForeground(
                                    new java.awt.Color(
                                            145,
                                            25,
                                            25
                                    )
                            );

                            componente.setFont(
                                    Estilos.fuenteNormal()
                                            .deriveFont(
                                                    java.awt.Font.BOLD
                                            )
                            );

                        } else if (!fechaVencimiento.isAfter(
                                limite
                        )) {

                            componente.setBackground(
                                    new java.awt.Color(
                                            255,
                                            235,
                                            190
                                    )
                            );

                            componente.setForeground(
                                    new java.awt.Color(
                                            135,
                                            80,
                                            0
                                    )
                            );

                            componente.setFont(
                                    Estilos.fuenteNormal()
                                            .deriveFont(
                                                    java.awt.Font.BOLD
                                            )
                            );
                        }

                    } catch (Exception e) {

                        componente.setBackground(
                                Estilos.BLANCO
                        );

                        componente.setForeground(
                                Estilos.VERDE_OSCURO
                        );
                    }
                }

                return componente;
            }
        });
    }
    
    public javax.swing.JPanel obtenerPanelProductos() {

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
                        "Gestión de productos"
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

        javax.swing.JPanel tarjetaProductos =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaProductos.setBackground(
                Estilos.BLANCO
        );

        tarjetaProductos.setBorder(
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
                tblProductos
        );

        scrollProductos.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        

        tarjetaProductos.add(
                scrollProductos,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnCrearProducto
        );

        Estilos.estilizarBotonEditar(
                btnEditarProducto
        );

        Estilos.estilizarBotonEliminar(
                btnEliminarProducto
        );

        Estilos.estilizarBoton(
                btnBuscarProducto
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );

        Estilos.aplicarIcono(
                btnCrearProducto,
                "/imagenes/iconos/agregar.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnEditarProducto,
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

        btnEliminarProducto.setIcon(
                null
        );

        btnBuscarProducto.setText("");

        btnBuscarProducto.setToolTipText(
                "Buscar producto"
        );

        Estilos.aplicarIcono(
                btnBuscarProducto,
                "/imagenes/iconos/buscar.png",
                20,
                20
        );

        java.awt.Dimension tamañoBuscar =
                new java.awt.Dimension(
                        42,
                        38
                );

        btnBuscarProducto.setPreferredSize(
                tamañoBuscar
        );

        btnBuscarProducto.setMinimumSize(
                tamañoBuscar
        );

        btnBuscarProducto.setMaximumSize(
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

        campoBusquedaProductos =
                new javax.swing.JTextField(
                        "Buscar por nombre"
                );

        campoBusquedaProductos.setFont(
                Estilos.fuenteNormal()
        );

        campoBusquedaProductos.setForeground(
                new java.awt.Color(140, 140, 140)
        );

        campoBusquedaProductos.setPreferredSize(
                new java.awt.Dimension(280, 38)
        );

        campoBusquedaProductos.setBorder(
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

        campoBusquedaProductos.setCaretPosition(0);

        campoBusquedaProductos.addFocusListener(
                new java.awt.event.FocusAdapter() {

            @Override
            public void focusGained(
                    java.awt.event.FocusEvent e
            ) {

                if (campoBusquedaProductos.getText()
                        .equals("Buscar por nombre")) {

                    campoBusquedaProductos.setText("");

                    campoBusquedaProductos.setForeground(
                            Estilos.VERDE_OSCURO
                    );
                }
            }

            @Override
            public void focusLost(
                    java.awt.event.FocusEvent e
            ) {

                if (campoBusquedaProductos.getText()
                        .trim().isEmpty()) {

                    campoBusquedaProductos.setText(
                            "Buscar por nombre"
                    );

                    campoBusquedaProductos.setForeground(
                            new java.awt.Color(
                                    140,
                                    140,
                                    140
                            )
                    );

                    campoBusquedaProductos.setCaretPosition(0);
                }
            }
        });

        campoBusquedaProductos.addActionListener(e ->
                btnBuscarProducto.doClick()
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
        panelBusqueda.add(campoBusquedaProductos);
        panelBusqueda.add(btnBuscarProducto);

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

        tarjetaProductos.add(
                panelAccionesSuperiores,
                java.awt.BorderLayout.NORTH
        );

        btnCrearProducto.setPreferredSize(
                new java.awt.Dimension(
                        185,
                        38
                )
        );

        btnEditarProducto.setPreferredSize(
                new java.awt.Dimension(
                        185,
                        38
                )
        );

        btnEliminarProducto.setPreferredSize(
                new java.awt.Dimension(
                        185,
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
                btnCrearProducto
        );       

        tarjetaProductos.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaProductos,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        aplicarColorVencimiento();

        return panel;
    }
    
    private void inicializarBotonesProductos() {

        btnBuscarProducto =
                new javax.swing.JButton("Buscar");

        btnMostrarTodos =
                new javax.swing.JButton("Mostrar todos");

        btnBuscarProducto.addActionListener(e ->
                buscarDesdeCampo()
        );

        btnMostrarTodos.addActionListener(e -> {

            cargarTabla();

            if (campoBusquedaProductos != null) {

                campoBusquedaProductos.setText(
                        "Buscar por nombre"
                );

                campoBusquedaProductos.setForeground(
                        new java.awt.Color(140, 140, 140)
                );

                campoBusquedaProductos.setCaretPosition(0);
            }
        });
    }
    
    private void buscarDesdeCampo() {

        if (campoBusquedaProductos == null) {
            return;
        }

        String texto =
                campoBusquedaProductos
                        .getText()
                        .trim();

        if (texto.isEmpty()
                || texto.equals(
                        "Buscar por nombre"
                )) {

            cargarTabla();
            return;
        }

        buscarProductos(texto);
    }
        private void mostrarDialogoBuscarProductos() {

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(
                        this
                );

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Buscar producto",
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
                        "BUSCAR PRODUCTO",
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
                        "Buscar por ID o nombre:"
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
                        280,
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

                buscarProductos(
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
                370,
                200
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(
                true
        );
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

                    tblProductos.setRowSelectionInterval(
                            fila,
                            fila
                    );

                    btnEditarProductoActionPerformed(null);
                }
            });

            btnEliminar.addActionListener(e -> {

                int fila = filaActual;

                fireEditingStopped();

                if (fila >= 0) {

                    tblProductos.setRowSelectionInterval(
                            fila,
                            fila
                    );

                    btnEliminarProductoActionPerformed(null);
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

        boton.setToolTipText("Editar producto");
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

        boton.setToolTipText("Eliminar producto");
        boton.setFocusable(false);

        boton.setCursor(
                java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return boton;
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaProductos().setVisible(true));
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}