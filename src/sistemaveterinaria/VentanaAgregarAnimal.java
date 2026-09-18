package sistemaveterinaria;
import controller.ClienteController;
import controller.AnimalController;
public class VentanaAgregarAnimal extends javax.swing.JFrame {
    private String rolUsuario;
    private int idAnimal = -1;
    private javax.swing.JLabel lblTituloFormulario;
    private VentanaPrincipal ventanaPrincipal;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAgregarAnimal.class.getName());

    
    public VentanaAgregarAnimal() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarClientes();
        aplicarDiseñoCrearEditarAnimales();
    }

    public VentanaAgregarAnimal(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarClientes();
        aplicarDiseñoCrearEditarAnimales();
    }
    
    public VentanaAgregarAnimal(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarClientes();
        aplicarDiseñoCrearEditarAnimales();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblEspecie = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        lblRaza = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setText("Nombre");

        lblEspecie.setText("Especie");

        lblRaza.setText("Raza");

        lblEdad.setText("Edad");

        lblCliente.setText("Cliente");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblEspecie)
                                    .addComponent(lblRaza)
                                    .addComponent(lblEdad))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEspecie)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRaza, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnGuardar)
                        .addGap(57, 57, 57)
                        .addComponent(btnVolver)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecie)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaza)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {

            String nombre = txtNombre.getText().trim();
            String especie = txtEspecie.getText().trim();
            String raza = txtRaza.getText().trim();
            String edadTexto = txtEdad.getText().trim();

            if (nombre.isEmpty()
                    || especie.isEmpty()
                    || edadTexto.isEmpty()
                    || cmbCliente.getSelectedItem() == null) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Completá todos los campos obligatorios"
                );

                return;
            }

            int edad = Integer.parseInt(edadTexto);

            String clienteSeleccionado =
                    cmbCliente.getSelectedItem().toString();

            int idCliente = Integer.parseInt(
                    clienteSeleccionado.split(" - ")[0]
            );

            AnimalController.guardarAnimal(
                    nombre,
                    especie,
                    raza,
                    edad,
                    idCliente,
                    idAnimal
            );

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "Animal guardado correctamente"
            );

            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarAnimales();

            } else {

                VentanaAnimales va =
                        new VentanaAnimales(rolUsuario);

                va.setVisible(true);

                this.dispose();
            }

        Estilos.mostrarAdvertencia(
                this,
                "Atención",
                "La edad debe ser un número válido"
        );

        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo guardar el animal: "
                    + e.getMessage()
            );
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    private void cargarClientes() {

        cmbCliente.removeAllItems();

        for (Object[] fila : ClienteController.listarClientesParaCombo()) {

            int idCliente = Integer.parseInt(
                    fila[0].toString()
            );

            String nombre = fila[1].toString();
            String dni = fila[2].toString();

            cmbCliente.addItem(
                    idCliente + " - " + nombre + " - " + dni
            );
        }
    }
    
    public void cargarDatos(int idAnimal,
                            String nombre,
                            String especie,
                            String raza,
                            int edad,
                            int idCliente) {

        this.idAnimal = idAnimal;

        txtNombre.setText(nombre);
        txtEspecie.setText(especie);
        txtRaza.setText(raza);
        txtEdad.setText(String.valueOf(edad));

        for (int i = 0; i < cmbCliente.getItemCount(); i++) {

            String item = cmbCliente.getItemAt(i);

            if (item.startsWith(idCliente + " - ")) {
                cmbCliente.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cmbCliente.getItemCount(); i++) {

            String item = cmbCliente.getItemAt(i);

            if (item.startsWith(idCliente + " - ")) {
                cmbCliente.setSelectedIndex(i);
                break;
            }
        }

        if (lblTituloFormulario != null) {
            lblTituloFormulario.setText("EDITAR ANIMAL");
        }

        setTitle("Henry System Vet - Editar animal");
    }
    private void aplicarDiseñoCrearEditarAnimales() {

        setTitle(
                "Henry System Vet - Nuevo animal"
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
                        "NUEVO ANIMAL"
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
            lblEspecie,
            lblRaza,
            lblEdad,
            lblCliente
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
            txtEspecie,
            txtRaza,
            txtEdad
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

        cmbCliente.setFont(
                Estilos.fuenteNormal()
        );

        cmbCliente.setPreferredSize(
                new java.awt.Dimension(
                        300,
                        38
                )
        );

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
                lblEspecie,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtEspecie,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        tarjetaFormulario.add(
                lblRaza,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtRaza,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 3;

        tarjetaFormulario.add(
                lblEdad,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                txtEdad,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 4;

        tarjetaFormulario.add(
                lblCliente,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                cmbCliente,
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
        gbc.gridy = 5;
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
    public javax.swing.JPanel obtenerPanelCrearEditarAnimal() {

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

        if (lblTituloFormulario == null) {

            lblTituloFormulario =
                    new javax.swing.JLabel();
        }

        lblTituloFormulario.setText(
                idAnimal == -1
                        ? "NUEVO ANIMAL"
                        : "EDITAR ANIMAL"
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
        contenedorTitulo.add(panelTitulo);

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
            lblEspecie,
            lblRaza,
            lblEdad,
            lblCliente
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
            txtEspecie,
            txtRaza,
            txtEdad
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

        cmbCliente.setFont(
                Estilos.fuenteNormal()
        );

        cmbCliente.setPreferredSize(
                new java.awt.Dimension(
                        300,
                        38
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        tarjetaFormulario.add(lblNombre, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        tarjetaFormulario.add(lblEspecie, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtEspecie, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        tarjetaFormulario.add(lblRaza, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtRaza, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        tarjetaFormulario.add(lblEdad, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtEdad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        tarjetaFormulario.add(lblCliente, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(cmbCliente, gbc);

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
        gbc.gridy = 5;
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

        java.awt.EventQueue.invokeLater(() -> new VentanaAgregarAnimal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRaza;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRaza;
    // End of variables declaration//GEN-END:variables
}
