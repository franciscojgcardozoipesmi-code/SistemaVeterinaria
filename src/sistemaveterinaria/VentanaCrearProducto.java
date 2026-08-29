package sistemaveterinaria;
import controller.ProductoController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class VentanaCrearProducto extends javax.swing.JFrame {
    
    private int idProducto = -1;
    private String rolUsuario;
    private javax.swing.JLabel lblTituloFormulario;
    private VentanaPrincipal ventanaPrincipal;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCrearProducto.class.getName());

    public VentanaCrearProducto() {
        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        aplicarDiseñoCrearEditarProductos();
    }

    public VentanaCrearProducto(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        aplicarDiseñoCrearEditarProductos();
    }
    
    public VentanaCrearProducto(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        aplicarDiseñoCrearEditarProductos();
    }

 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFechaVencimiento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setText("Nombre");

        lblPrecio.setText("Precio");

        lblStock.setText("Stock");

        txtNombre.addActionListener(this::txtNombreActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        jLabel1.setText("Fecha de vencimiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPrecio)
                            .addComponent(lblNombre)
                            .addComponent(lblStock))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(99, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar)
                                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecio)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGuardar))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {

            String nombre = txtNombre.getText();
            String precioTexto = txtPrecio.getText();
            String stockTexto = txtStock.getText();
            String fechaTexto = txtFechaVencimiento.getText().trim();

            if (nombre.isEmpty()
                    || precioTexto.isEmpty()
                    || stockTexto.isEmpty()
                    || fechaTexto.isEmpty()) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Completar todos los campos"
                );

                return;
            }

            DateTimeFormatter formatoEntrada =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate fecha =
                    LocalDate.parse(fechaTexto, formatoEntrada);

            String fechaVencimiento =
                    fecha.toString();
            double precio = Double.parseDouble(precioTexto);
            int stock = Integer.parseInt(stockTexto);
            ProductoController.guardarProducto(nombre, precio, stock, fechaVencimiento, idProducto);

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "Producto guardado correctamente"
            );
            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarProductos();

            } else {

                VentanaProductos vp =
                        new VentanaProductos(rolUsuario);

                vp.setVisible(true);

                this.dispose();
            }
        } catch (DateTimeParseException e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "La fecha debe tener formato DD/MM/AAAA"
            );

        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e
            );
        }
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (ventanaPrincipal != null) {

            ventanaPrincipal.mostrarProductos();

        } else {

            VentanaProductos vp =
                    new VentanaProductos(rolUsuario);

            vp.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed
    public void cargarDatos(int idProducto, String nombre,
                            double precio, int stock, String fechaVencimiento) {

        txtFechaVencimiento.setText(fechaVencimiento);
        this.idProducto = idProducto;

        txtNombre.setText(nombre);
        txtPrecio.setText(String.valueOf(precio));
        txtStock.setText(String.valueOf(stock));
        if (lblTituloFormulario != null) {
            lblTituloFormulario.setText(
                    "EDITAR PRODUCTO"
            );
        }

        setTitle(
                "Henry System Vet - Editar producto"
        );
    }
    private void aplicarDiseñoCrearEditarProductos() {

        setTitle(
                "Henry System Vet - Nuevo producto"
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

        lblTituloFormulario =
                new javax.swing.JLabel(
                        "NUEVO PRODUCTO"
                );

        lblTituloFormulario.setFont(
                Estilos.fuente(26f)
        );

        lblTituloFormulario.setForeground(
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
                lblTituloFormulario
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
                javax.swing.Box.createVerticalStrut(30)
        );

        javax.swing.JPanel contenedorFormulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        contenedorFormulario.setOpaque(false);

        javax.swing.JPanel tarjetaFormulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        tarjetaFormulario.setBackground(
                Estilos.BLANCO
        );

        tarjetaFormulario.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                40,
                                50,
                                40,
                                50
                        )
                )
        );

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.insets =
                new java.awt.Insets(
                        10,
                        10,
                        10,
                        10
                );

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        javax.swing.JLabel[] etiquetas = {
            lblNombre,
            lblPrecio,
            lblStock,
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

        javax.swing.JTextField[] campos = {
            txtNombre,
            txtPrecio,
            txtStock,
            txtFechaVencimiento
        };

        for (javax.swing.JTextField campo : campos) {

            campo.setFont(
                    Estilos.fuenteNormal()
            );

            campo.setPreferredSize(
                    new java.awt.Dimension(
                            300,
                            38
                    )
            );
        }

        gbc.gridx = 0;
        gbc.gridy = 0;

        tarjetaFormulario.add(
                lblNombre,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtNombre,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 1;

        tarjetaFormulario.add(
                lblPrecio,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtPrecio,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        tarjetaFormulario.add(
                lblStock,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtStock,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 3;

        tarjetaFormulario.add(
                jLabel1,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtFechaVencimiento,
                gbc
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
                                java.awt.FlowLayout.CENTER,
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

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        gbc.insets =
                new java.awt.Insets(
                        25,
                        10,
                        0,
                        10
                );

        tarjetaFormulario.add(
                panelBotones,
                gbc
        );

        contenedorFormulario.add(
                tarjetaFormulario
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                contenedorFormulario,
                java.awt.BorderLayout.CENTER
        );

        getContentPane().add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        revalidate();
        repaint();
    }
    
    public javax.swing.JPanel obtenerPanelCrearEditarProducto() {

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

        lblTituloFormulario =
                new javax.swing.JLabel(
                        idProducto == -1
                                ? "NUEVO PRODUCTO"
                                : "EDITAR PRODUCTO"
                );

        lblTituloFormulario.setFont(
                Estilos.fuente(26f)
        );

        lblTituloFormulario.setForeground(
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
                lblTituloFormulario
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
                javax.swing.Box.createVerticalStrut(30)
        );

        javax.swing.JPanel contenedorFormulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        contenedorFormulario.setOpaque(false);

        javax.swing.JPanel tarjetaFormulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        tarjetaFormulario.setBackground(
                Estilos.BLANCO
        );

        tarjetaFormulario.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                40,
                                50,
                                40,
                                50
                        )
                )
        );

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.insets =
                new java.awt.Insets(
                        10,
                        10,
                        10,
                        10
                );

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        javax.swing.JLabel[] etiquetas = {
            lblNombre,
            lblPrecio,
            lblStock,
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

        javax.swing.JTextField[] campos = {
            txtNombre,
            txtPrecio,
            txtStock,
            txtFechaVencimiento
        };

        for (javax.swing.JTextField campo : campos) {

            campo.setFont(
                    Estilos.fuenteNormal()
            );

            campo.setPreferredSize(
                    new java.awt.Dimension(
                            300,
                            38
                    )
            );
        }

        gbc.gridx = 0;
        gbc.gridy = 0;

        tarjetaFormulario.add(
                lblNombre,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtNombre,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 1;

        tarjetaFormulario.add(
                lblPrecio,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtPrecio,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        tarjetaFormulario.add(
                lblStock,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtStock,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 3;

        tarjetaFormulario.add(
                jLabel1,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtFechaVencimiento,
                gbc
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
                                java.awt.FlowLayout.CENTER,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(false);

        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        gbc.insets =
                new java.awt.Insets(
                        25,
                        10,
                        0,
                        10
                );

        tarjetaFormulario.add(
                panelBotones,
                gbc
        );

        contenedorFormulario.add(
                tarjetaFormulario
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                contenedorFormulario,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(() -> new VentanaCrearProducto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTextField txtFechaVencimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
