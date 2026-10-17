package sistemaveterinaria;

import controller.ProductoController;
import controller.VentaController;
import java.util.HashMap;
import java.util.HashSet;
import excepciones.StockInsuficienteException;
import excepciones.ProductoVencidoException;
import java.time.LocalDate;
import controller.ClienteController;

public class VentanaCrearVenta extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCrearVenta.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    private final javax.swing.JLabel lblClienteVenta =
            new javax.swing.JLabel("Cliente");

    private final javax.swing.JComboBox<String> cmbClienteVenta =
            new javax.swing.JComboBox<>();
    private final java.util.ArrayList<Integer> idsClientesVenta =
            new java.util.ArrayList<>();
    private final javax.swing.JLabel lblDniClienteVenta =
            new javax.swing.JLabel("DNI");

    private final javax.swing.JTextField txtDniClienteVenta =
            new javax.swing.JTextField();

    private final java.util.ArrayList<String> dnisClientesVenta =
            new java.util.ArrayList<>();
    private final javax.swing.JLabel lblUsuarioVenta =
            new javax.swing.JLabel("Usuario");

    private final javax.swing.JTextField txtUsuarioVenta =
            new javax.swing.JTextField();
    public VentanaCrearVenta() {
        initComponents();

        modelo = new javax.swing.table.DefaultTableModel();

        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");

        tblDetalle.setModel(modelo);

        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        cargarProductos();
        configurarDatosAutomaticosVenta();

        mapaPrecios =
                ProductoController.obtenerMapaPrecios();

        aplicarDiseñoCrearVenta();
    }
    
    public VentanaCrearVenta(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        modelo = new javax.swing.table.DefaultTableModel();

        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");

        tblDetalle.setModel(modelo);

        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        cargarProductos();
        configurarDatosAutomaticosVenta();

        mapaPrecios =
                ProductoController.obtenerMapaPrecios();

        aplicarDiseñoCrearVenta();
    }
    public VentanaCrearVenta(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        modelo = new javax.swing.table.DefaultTableModel();

        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");

        tblDetalle.setModel(modelo);

        cargarProductos();
        configurarDatosAutomaticosVenta();

        mapaPrecios =
                ProductoController.obtenerMapaPrecios();
    }
    
    private javax.swing.table.DefaultTableModel modelo;
    private HashMap<String, Double> mapaPrecios;
    private HashSet<String> productosAgregados = new HashSet<>();

    private void cargarProductos() {

            cmbProducto.removeAllItems();

        for (String producto : ProductoController.listarNombres()) {
            cmbProducto.addItem(producto);
        }
    }
    private void cargarClientesVenta() {

        cmbClienteVenta.removeAllItems();
        idsClientesVenta.clear();
        dnisClientesVenta.clear();

        for (Object[] cliente
                : ClienteController.listarClientesParaCombo()) {

            idsClientesVenta.add(
                    Integer.parseInt(
                            cliente[0].toString()
                    )
            );

            dnisClientesVenta.add(
                    cliente[2].toString()
            );

            cmbClienteVenta.addItem(
                    cliente[1].toString()
            );
        }

        actualizarDniClienteVenta();
    }
    private void actualizarDniClienteVenta() {

        int indice =
                cmbClienteVenta.getSelectedIndex();

        if (indice >= 0
                && indice < dnisClientesVenta.size()) {

            txtDniClienteVenta.setText(
                    dnisClientesVenta.get(indice)
            );

        } else {

            txtDniClienteVenta.setText("");
        }
    }
    private void configurarDatosAutomaticosVenta() {

        String fechaActual =
                LocalDate.now().format(
                        java.time.format.DateTimeFormatter
                                .ofPattern(
                                        "dd/MM/yyyy"
                                )
                );

        txtFecha.setText(
                fechaActual
        );

        txtFecha.setEditable(false);
        txtFecha.setFocusable(false);

        txtFecha.setBackground(
                new java.awt.Color(
                        235,
                        235,
                        235
                )
        );

        txtFecha.setToolTipText(
                "La fecha se establece automáticamente"
        );

        String nombreUsuario =
                SesionUsuario.haySesionActiva()
                        ? SesionUsuario.getNombreUsuario()
                        : "Sin usuario";

        txtUsuarioVenta.setText(
                nombreUsuario
        );

        txtUsuarioVenta.setEditable(false);
        txtUsuarioVenta.setFocusable(false);

        txtUsuarioVenta.setBackground(
                new java.awt.Color(
                        235,
                        235,
                        235
                )
        );

        txtUsuarioVenta.setToolTipText(
                "Usuario que registra la venta"
        );

        cargarClientesVenta();
        cmbClienteVenta.addActionListener(
                evento -> actualizarDniClienteVenta()
        );

        actualizarDniClienteVenta();

        txtDniClienteVenta.setEditable(false);
        txtDniClienteVenta.setFocusable(false);
        txtDniClienteVenta.setBackground(
                new java.awt.Color(
                        235,
                        235,
                        235
                )
        );
    }
    private void calcularTotal() {

        double total = 0;

        for (int i = 0; i < tblDetalle.getRowCount(); i++) {
            total += Double.parseDouble(tblDetalle.getValueAt(i, 3).toString());
        }

        lblTotal.setText("Total: " + total);
    }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFecha = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        cmbProducto = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        scrollDetalle = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbMedioPago = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFecha.setText("Fecha");

        lblProducto.setText("Producto");

        lblCantidad.setText("Cantidad");

        txtFecha.addActionListener(this::txtFechaActionPerformed);

        txtCantidad.addActionListener(this::txtCantidadActionPerformed);

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollDetalle.setViewportView(tblDetalle);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        lblTotal.setText("Total:");

        jLabel1.setText("Medio de pago:");

        cmbMedioPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Transferencia" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProducto)
                        .addGap(86, 86, 86)
                        .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblFecha)
                                    .addGap(57, 57, 57))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(lblCantidad))
                                    .addGap(40, 40, 40)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCantidad)
                                .addComponent(txtFecha)
                                .addComponent(cmbMedioPago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(scrollDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(54, 54, 54)
                        .addComponent(btnGuardar)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProducto)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCantidad)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbMedioPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(scrollDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGuardar))
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
   
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
      
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {

            String producto = cmbProducto.getSelectedItem().toString();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            String fechaVencimiento =
                    ProductoController.obtenerFechaVencimiento(producto);

            if (fechaVencimiento != null && !fechaVencimiento.isEmpty()) {

                LocalDate fecha =
                        LocalDate.parse(fechaVencimiento);

                if (fecha.isBefore(LocalDate.now())) {

                    throw new ProductoVencidoException(
                            "El producto se encuentra vencido"
                    );
                }
            }

            if (productosAgregados.contains(producto)) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "El producto ya fue agregado a la venta"
                );

                return;
            }

            int stockDisponible =
                    ProductoController.obtenerStock(producto);

            if (cantidad > stockDisponible) {

                throw new StockInsuficienteException(
                        "Stock insuficiente. Disponible: "
                        + stockDisponible
                );
            }

            double precio = mapaPrecios.get(producto);
            double subtotal = precio * cantidad;

            modelo.addRow(new Object[]{
                producto,
                cantidad,
                precio,
                subtotal
            });

            productosAgregados.add(producto);

            calcularTotal();

        } catch (StockInsuficienteException e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Stock insuficiente",
                    e.getMessage()
            );
        } catch (ProductoVencidoException e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Producto vencido",
                    e.getMessage()
            );      
        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo agregar el producto: "
                    + e.getMessage()
            );
        }
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {

            if (tblDetalle.getRowCount() == 0) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Agregá al menos un producto"
                );

                return;
            }

            if (cmbClienteVenta.getSelectedItem() == null) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Seleccioná un cliente"
                );

                return;
            }

            int indiceCliente =
                    cmbClienteVenta.getSelectedIndex();

            int idCliente =
                    idsClientesVenta.get(
                            indiceCliente
                    );

            VentaController.guardarVenta(
                    cmbMedioPago.getSelectedItem().toString(),
                    tblDetalle,
                    idCliente
            );

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "Venta guardada correctamente"
            );

            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarVentas();

            } else {

                VentanaVentas vv =
                        new VentanaVentas(rolUsuario);

                vv.setVisible(true);

                this.dispose();
            }

        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo guardar la venta: "
                    + e.getMessage()
            );
        }  
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
         if (ventanaPrincipal != null) {

            ventanaPrincipal.mostrarVentas();

        } else {

            VentanaVentas vv =
                    new VentanaVentas(rolUsuario);

            vv.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed
    private void aplicarDiseñoCrearVenta() {

        setTitle(
                "Henry System Vet - Nueva venta"
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
                        new java.awt.BorderLayout(
                                0,
                                30
                        )
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

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "NUEVA VENTA"
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

        javax.swing.JPanel panelContenido =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        panelContenido.setOpaque(false);

        java.awt.GridBagConstraints gbcPrincipal =
                new java.awt.GridBagConstraints();

        gbcPrincipal.insets =
                new java.awt.Insets(
                        0,
                        10,
                        0,
                        10
                );

        gbcPrincipal.fill =
                java.awt.GridBagConstraints.BOTH;

        gbcPrincipal.weighty = 1;

        javax.swing.JPanel tarjetaDatos =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        tarjetaDatos.setBackground(
                Estilos.BLANCO
        );

        tarjetaDatos.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                35,
                                40,
                                35,
                                40
                        )
                )
        );

        javax.swing.JLabel[] etiquetas = {
            lblFecha,
            lblClienteVenta,
            lblDniClienteVenta,
            lblUsuarioVenta,
            lblProducto,
            lblCantidad,
            jLabel1
        };

        for (javax.swing.JLabel etiqueta : etiquetas) {

            etiqueta.setFont(
                    Estilos.fuenteNormal()
            );

            etiqueta.setForeground(
                    Estilos.VERDE_OSCURO
            );
        }

        txtFecha.setFont(
                Estilos.fuenteNormal()
        );

        txtCantidad.setFont(
                Estilos.fuenteNormal()
        );

        cmbProducto.setFont(
                Estilos.fuenteNormal()
        );

        cmbMedioPago.setFont(
                Estilos.fuenteNormal()
        );

        java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        260,
                        38
                );

        txtFecha.setPreferredSize(
                tamañoCampo
        );

        txtCantidad.setPreferredSize(
                tamañoCampo
        );

        cmbProducto.setPreferredSize(
                tamañoCampo
        );

        cmbMedioPago.setPreferredSize(
                tamañoCampo
        );

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.insets =
                new java.awt.Insets(
                        6,
                        10,
                        6,
                        10
                );

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;

        tarjetaDatos.add(
                lblFecha,
                gbc
        );

        gbc.gridx = 1;

        tarjetaDatos.add(
                txtFecha,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;

        tarjetaDatos.add(
                lblProducto,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                cmbProducto,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        tarjetaDatos.add(
                lblCantidad,
                gbc
        );

        gbc.gridx = 1;

        tarjetaDatos.add(
                txtCantidad,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        tarjetaDatos.add(
                jLabel1,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                cmbMedioPago,
                gbc
        );

        Estilos.estilizarBoton(
                btnAgregar
        );

        btnAgregar.setPreferredSize(
                new java.awt.Dimension(
                        130,
                        38
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        tarjetaDatos.add(
                btnAgregar,
                gbc
        );

        javax.swing.JPanel tarjetaDetalle =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                15
                        )
                );

        tarjetaDetalle.setBackground(
                Estilos.BLANCO
        );

        tarjetaDetalle.setBorder(
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

        javax.swing.JLabel lblDetalle =
                new javax.swing.JLabel(
                        "DETALLE DE LA VENTA"
                );

        lblDetalle.setFont(
                Estilos.fuente(18f)
        );

        lblDetalle.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblDetalle.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        Estilos.estilizarTabla(
                tblDetalle
        );

        tblDetalle.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        scrollDetalle.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollDetalle.setPreferredSize(
                new java.awt.Dimension(
                        650,
                        320
                )
        );

        lblTotal.setFont(
                Estilos.fuente(20f)
        );

        lblTotal.setForeground(
                Estilos.VERDE_OSCURO
        );

        javax.swing.JPanel panelTotal =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                10,
                                5
                        )
                );

        panelTotal.setOpaque(false);

        panelTotal.add(
                lblTotal
        );

        tarjetaDetalle.add(
                lblDetalle,
                java.awt.BorderLayout.NORTH
        );

        tarjetaDetalle.add(
                scrollDetalle,
                java.awt.BorderLayout.CENTER
        );

        tarjetaDetalle.add(
                panelTotal,
                java.awt.BorderLayout.SOUTH
        );

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 0;
        gbcPrincipal.weightx = 0.47;

        panelContenido.add(
                tarjetaDatos,
                gbcPrincipal
        );

        gbcPrincipal.gridx = 1;
        gbcPrincipal.weightx = 0.53;

        panelContenido.add(
                tarjetaDetalle,
                gbcPrincipal
        );

        Estilos.estilizarBoton(
                btnGuardar
        );

        Estilos.estilizarBoton(
                btnVolver
        );

        btnGuardar.setPreferredSize(
                new java.awt.Dimension(
                        140,
                        38
                )
        );

        btnVolver.setPreferredSize(
                new java.awt.Dimension(
                        120,
                        38
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

        panelBotones.setOpaque(false);

        panelBotones.add(
                btnGuardar
        );

        panelBotones.add(
                btnVolver
        );

        panelPrincipal.add(
                contenedorTitulo,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                panelContenido,
                java.awt.BorderLayout.CENTER
        );

        panelPrincipal.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        getContentPane().add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        revalidate();
        repaint();
    }
    public javax.swing.JPanel obtenerPanelCrearVenta() {

        javax.swing.JPanel panel =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panel.setBackground(
                Estilos.VERDE_PRINCIPAL
        );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                10
                        )
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

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "NUEVA VENTA"
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

        javax.swing.JPanel panelContenido =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        panelContenido.setOpaque(false);

        java.awt.GridBagConstraints gbcPrincipal =
                new java.awt.GridBagConstraints();

        gbcPrincipal.insets =
                new java.awt.Insets(
                        0,
                        10,
                        0,
                        10
                );

        gbcPrincipal.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        gbcPrincipal.weighty = 0;

        javax.swing.JPanel tarjetaDatos =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        tarjetaDatos.setBackground(
                Estilos.BLANCO
        );

        tarjetaDatos.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                25,
                                20,
                                25,
                                20
                        )
                )
        );

        javax.swing.JLabel[] etiquetas = {
            lblFecha,
            lblClienteVenta,
            lblDniClienteVenta,
            lblUsuarioVenta,
            lblProducto,
            lblCantidad,
            jLabel1
        };

        for (javax.swing.JLabel etiqueta : etiquetas) {

            etiqueta.setFont(
                    Estilos.fuenteNormal()
            );

            etiqueta.setForeground(
                    Estilos.VERDE_OSCURO
            );
        }

        txtFecha.setFont(
                Estilos.fuenteNormal()
        );

        txtCantidad.setFont(
                Estilos.fuenteNormal()
        );

        cmbProducto.setFont(
                Estilos.fuenteNormal()
        );

        cmbMedioPago.setFont(
                Estilos.fuenteNormal()
        );
        cmbClienteVenta.setFont(
                Estilos.fuenteNormal()
        );

        txtUsuarioVenta.setFont(
                Estilos.fuenteNormal()
        );
        lblDniClienteVenta.setFont(
                Estilos.fuenteNormal()
        );

        lblDniClienteVenta.setForeground(
                Estilos.VERDE_OSCURO
        );

        txtDniClienteVenta.setFont(
                Estilos.fuenteNormal()
        );

        txtDniClienteVenta.setForeground(
                java.awt.Color.BLACK
        );

        txtDniClienteVenta.setBackground(
                new java.awt.Color(
                        235,
                        235,
                        235
                )
        );

        txtDniClienteVenta.setEditable(false);
        txtDniClienteVenta.setFocusable(false);
        java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        240,
                        38
                );

        txtFecha.setPreferredSize(
                tamañoCampo
        );

        txtFecha.setMinimumSize(
                tamañoCampo
        );

        cmbProducto.setPreferredSize(
                tamañoCampo
        );

        cmbProducto.setMinimumSize(
                tamañoCampo
        );

        txtCantidad.setPreferredSize(
                tamañoCampo
        );

        txtCantidad.setMinimumSize(
                tamañoCampo
        );

        cmbMedioPago.setPreferredSize(
                tamañoCampo
        );

        cmbMedioPago.setMinimumSize(
                tamañoCampo
        );
        cmbClienteVenta.setPreferredSize(
                tamañoCampo
        );

        cmbClienteVenta.setMinimumSize(
                tamañoCampo
        );

        txtUsuarioVenta.setPreferredSize(
                tamañoCampo
        );

        txtUsuarioVenta.setMinimumSize(
                tamañoCampo
        );
        btnVolver.setText("");
        txtDniClienteVenta.setPreferredSize(
                tamañoCampo
        );

        txtDniClienteVenta.setMinimumSize(
                tamañoCampo
        );
        javax.swing.ImageIcon iconoVolver =
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/imagenes/iconos/volver.png"
                        )
                );

        java.awt.Image imagenVolver =
                iconoVolver.getImage().getScaledInstance(
                        26,
                        26,
                        java.awt.Image.SCALE_SMOOTH
                );

        btnVolver.setIcon(
                new javax.swing.ImageIcon(
                        imagenVolver
                )
        );

        btnVolver.setBackground(
                Estilos.VERDE_OSCURO
        );

        btnVolver.setForeground(
                Estilos.BLANCO
        );

        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(true);
        btnVolver.setOpaque(true);
        btnVolver.setFocusPainted(false);

        btnVolver.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        btnVolver.setMargin(
                new java.awt.Insets(
                        0,
                        0,
                        0,
                        0
                )
        );

        java.awt.Dimension tamañoBotonVolver =
                new java.awt.Dimension(
                        38,
                        38
                );

        btnVolver.setPreferredSize(
                tamañoBotonVolver
        );

        btnVolver.setMinimumSize(
                tamañoBotonVolver
        );

        btnVolver.setMaximumSize(
                tamañoBotonVolver
        );

        btnVolver.addMouseListener(
                new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(
                    java.awt.event.MouseEvent evt
            ) {

                btnVolver.setBackground(
                        Estilos.VERDE_PRINCIPAL
                );
            }

            @Override
            public void mouseExited(
                    java.awt.event.MouseEvent evt
            ) {

                btnVolver.setBackground(
                        Estilos.VERDE_OSCURO
                );
            }
        });

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.fill =
                java.awt.GridBagConstraints.NONE;

        gbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        10,
                        10
                );

        tarjetaDatos.add(
                btnVolver,
                gbc
        );

        gbc.gridwidth = 1;

        gbc.insets =
                new java.awt.Insets(
                        6,
                        10,
                        6,
                        10
                );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

        tarjetaDatos.add(
                lblFecha,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                txtFecha,
                gbc
        );

  
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        tarjetaDatos.add(
                lblClienteVenta,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                cmbClienteVenta,
                gbc
        );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;

        tarjetaDatos.add(
                lblDniClienteVenta,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                txtDniClienteVenta,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;

        tarjetaDatos.add(
                lblUsuarioVenta,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                txtUsuarioVenta,
                gbc
        );


        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;

        tarjetaDatos.add(
                lblProducto,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                cmbProducto,
                gbc
        );


        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;

        tarjetaDatos.add(
                lblCantidad,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                txtCantidad,
                gbc
        );


        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0;

        tarjetaDatos.add(
                jLabel1,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        tarjetaDatos.add(
                cmbMedioPago,
                gbc
        );

        Estilos.estilizarBoton(
                btnAgregar
        );

        java.awt.Dimension tamañoBotonAgregar =
                new java.awt.Dimension(
                        130,
                        38
                );

        btnAgregar.setPreferredSize(
                tamañoBotonAgregar
        );

        btnAgregar.setMinimumSize(
                tamañoBotonAgregar
        );

        btnAgregar.setMaximumSize(
                tamañoBotonAgregar
        );

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.weightx = 0;

        gbc.fill =
                java.awt.GridBagConstraints.NONE;

        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        gbc.insets =
            new java.awt.Insets(
                    10,
                    10,
                    0,
                    10
            );

        tarjetaDatos.add(
                btnAgregar,
                gbc
        );

        javax.swing.JPanel tarjetaDetalle =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                15
                        )
                );

        tarjetaDetalle.setBackground(
                Estilos.BLANCO
        );

        tarjetaDetalle.setBorder(
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

        javax.swing.JLabel lblDetalle =
                new javax.swing.JLabel(
                        "DETALLE DE LA VENTA"
                );

        lblDetalle.setFont(
                Estilos.fuente(18f)
        );

        lblDetalle.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblDetalle.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        Estilos.estilizarTabla(
                tblDetalle
        );

        tblDetalle.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        scrollDetalle.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        java.awt.Dimension tamañoDetalle =
                new java.awt.Dimension(
                        650,
                        300
                );

        scrollDetalle.setPreferredSize(
                tamañoDetalle
        );

        scrollDetalle.setMinimumSize(
                tamañoDetalle
        );

        lblTotal.setFont(
                Estilos.fuente(20f)
        );

        lblTotal.setForeground(
                Estilos.VERDE_OSCURO
        );

        javax.swing.JPanel panelTotal =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                10,
                                5
                        )
                );

        panelTotal.setOpaque(false);

        panelTotal.add(
                lblTotal
        );

        tarjetaDetalle.add(
                lblDetalle,
                java.awt.BorderLayout.NORTH
        );

        tarjetaDetalle.add(
                scrollDetalle,
                java.awt.BorderLayout.CENTER
        );

        tarjetaDetalle.add(
                panelTotal,
                java.awt.BorderLayout.SOUTH
        );

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 0;
        gbcPrincipal.weightx = 0.35;
        gbcPrincipal.weighty = 0;

        gbcPrincipal.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        panelContenido.add(
                tarjetaDatos,
                gbcPrincipal
        );

        gbcPrincipal.gridx = 1;
        gbcPrincipal.weightx = 0.65;
        gbcPrincipal.weighty = 1;

        gbcPrincipal.fill =
                java.awt.GridBagConstraints.BOTH;

        panelContenido.add(
                tarjetaDetalle,
                gbcPrincipal
        );

        Estilos.estilizarBoton(
                btnGuardar
        );

        java.awt.Dimension tamañoBotonGuardar =
                new java.awt.Dimension(
                        140,
                        38
                );

        btnGuardar.setPreferredSize(
                tamañoBotonGuardar
        );

        btnGuardar.setMinimumSize(
                tamañoBotonGuardar
        );

        btnGuardar.setMaximumSize(
                tamañoBotonGuardar
        );

        javax.swing.JPanel panelBotones =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(false);

        panelBotones.add(
                btnGuardar
        );

        panelPrincipal.add(
                contenedorTitulo,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                panelContenido,
                java.awt.BorderLayout.CENTER
        );

        panelPrincipal.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(() -> new VentanaCrearVenta().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbMedioPago;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JScrollPane scrollDetalle;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
