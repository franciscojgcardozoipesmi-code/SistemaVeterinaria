package sistemaveterinaria;
import controller.TurnoController;
import controller.AnimalController;
import javax.swing.JOptionPane;
import controller.ClienteController;

public class VentanaCrearTurno extends javax.swing.JFrame {
    private int idTurno = -1;
    private boolean reprogramando = false;
    private String rolUsuario;
    private javax.swing.JLabel lblTituloFormulario;
    private VentanaPrincipal ventanaPrincipal;
        public void cargarDatosReprogramacion(
            int id,
            String dueno,
            String animal,
            String fecha,
            String hora,
            String motivo,
            String dni) {

        reprogramando = true;

        cargarDatos(
                id,
                dueno,
                animal,
                fecha,
                hora,
                motivo,
                dni
        );
        if (lblTituloFormulario != null) {
            lblTituloFormulario.setText("REPROGRAMAR TURNO");
        }

        setTitle("Henry System Vet - Reprogramar turno");
    }
    public VentanaCrearTurno() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarAnimales();
        aplicarDiseñoCrearEditarTurnos();
    }

    public VentanaCrearTurno(String rolUsuario) {
            initComponents();
            this.rolUsuario = rolUsuario;
            setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            cargarAnimales();
            aplicarDiseñoCrearEditarTurnos();
        }

        public VentanaCrearTurno(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarAnimales();
        aplicarDiseñoCrearEditarTurnos();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnimal = new javax.swing.JLabel();
        lblDueno = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblMotivo = new javax.swing.JLabel();
        txtDueno = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        cmbAnimal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAnimal.setText("Animal");

        lblDueno.setText("Dueño");

        lblFecha.setText("Fecha");

        lblHora.setText("Hora");

        lblMotivo.setText("Motivo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        lblDni.setText("DNI");

        cmbAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAnimal.addActionListener(this::cmbAnimalActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 115, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(54, 54, 54)
                .addComponent(btnGuardar)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnimal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDni)
                                .addComponent(lblDueno)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                            .addComponent(txtDueno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbAnimal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblHora))
                                    .addComponent(lblMotivo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(txtHora))))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnimal)
                    .addComponent(cmbAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDueno)
                    .addComponent(txtDueno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMotivo)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {

            String dueno = txtDueno.getText().trim();

            if (cmbAnimal.getSelectedItem() == null) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Seleccioná un animal"
                );

                return;
            }

            String itemAnimal =
                    cmbAnimal.getSelectedItem().toString();

            int idAnimal = Integer.parseInt(
                    itemAnimal.split(" - ")[0]
            );

            String animal =
                    itemAnimal.split(" - ")[1];

            String dni = txtDni.getText().trim();
            String fecha = txtFecha.getText().trim();
            String hora = txtHora.getText().trim();
            String motivo = txtMotivo.getText().trim();

            if (dueno.isEmpty()
                    || animal.isEmpty()
                    || dni.isEmpty()
                    || fecha.isEmpty()
                    || hora.isEmpty()
                    || motivo.isEmpty()) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Completá todos los campos obligatorios"
                );

                return;
            }

            TurnoController.guardarTurno(
                    dueno,
                    dni,
                    idAnimal,
                    animal,
                    fecha,
                    hora,
                    motivo,
                    idTurno
            );

            if (reprogramando) {

                TurnoController.cambiarEstado(
                        idTurno,
                        "PENDIENTE"
                );
            }

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "Turno guardado correctamente"
            );

            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarTurnos();

            } else {

                VentanaTurnos vt =
                        new VentanaTurnos(rolUsuario);

                vt.setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo guardar el turno: "
                    + e.getMessage()
            );
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    public void cargarDatos(int id, String dueno, String animal, String fecha, String hora, String motivo, String dni) {
        idTurno = id;

        txtDueno.setText(dueno);
        cmbAnimal.setSelectedItem(animal);
        txtFecha.setText(fecha);
        txtHora.setText(hora);
        txtMotivo.setText(motivo);
        txtDni.setText(dni);
        if (lblTituloFormulario != null) {
            lblTituloFormulario.setText("EDITAR TURNO");
        }

        setTitle("Henry System Vet - Editar turno");
    }
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (ventanaPrincipal != null) {

            if (reprogramando) {

                ventanaPrincipal.mostrarTurnosVencidos();

            } else {

                ventanaPrincipal.mostrarTurnos();
            }

        } else {

            VentanaTurnos vt =
                    new VentanaTurnos(rolUsuario);

            vt.setVisible(true);

            this.dispose();
        }   
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cmbAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnimalActionPerformed
          if (cmbAnimal.getSelectedItem() == null) {
            return;
        }

        String item =
                cmbAnimal.getSelectedItem().toString();

        int idAnimal = Integer.parseInt(
                item.split(" - ")[0]
        );

        int idCliente =
                AnimalController.obtenerIdClientePorAnimal(idAnimal);

        Object[] cliente =
                ClienteController.obtenerClientePorId(idCliente);

        if (cliente != null) {

            txtDueno.setText(
                    cliente[1].toString()
            );

            txtDni.setText(
                    cliente[2].toString()
            );
        }
    
    }//GEN-LAST:event_cmbAnimalActionPerformed

    private void cargarAnimales() {

        cmbAnimal.removeAllItems();

        for (Object[] fila : AnimalController.listarAnimalesParaCombo()) {

            int idAnimal = Integer.parseInt(
                    fila[0].toString()
            );

            String nombre = fila[1].toString();

            cmbAnimal.addItem(
                    idAnimal + " - " + nombre
            );
        }
    }
    
    private void aplicarDiseñoCrearEditarTurnos() {

        setTitle(
                "Henry System Vet - Nuevo turno"
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
                        "NUEVO TURNO"
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
                javax.swing.Box.createVerticalStrut(10)
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
                                25,
                                50,
                                25,
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
            lblAnimal,
            lblDueno,
            lblDni,
            lblFecha,
            lblHora,
            lblMotivo
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
            txtDueno,
            txtDni,
            txtFecha,
            txtHora,
            txtMotivo
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

        cmbAnimal.setFont(
                Estilos.fuenteNormal()
        );

        cmbAnimal.setPreferredSize(
                new java.awt.Dimension(
                        300,
                        38
                )
        );

        txtDueno.setEditable(false);
        txtDni.setEditable(false);

        txtDueno.setBackground(
                new java.awt.Color(
                        245,
                        245,
                        245
                )
        );

        txtDni.setBackground(
                new java.awt.Color(
                        245,
                        245,
                        245
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 1;

        tarjetaFormulario.add(
                lblAnimal,
                gbc
        );

        gbc.gridx = 1;

        tarjetaFormulario.add(
                cmbAnimal,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        tarjetaFormulario.add(
                lblDueno,
                gbc
        );

        gbc.gridx = 2;

        tarjetaFormulario.add(
                txtDueno,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 3;

        tarjetaFormulario.add(
                lblDni,
                gbc
        );

        gbc.gridx = 3;

        tarjetaFormulario.add(
                txtDni,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 4;

        tarjetaFormulario.add(
                lblFecha,
                gbc
        );

        gbc.gridx = 4;

        tarjetaFormulario.add(
                txtFecha,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 5;

        tarjetaFormulario.add(
                lblHora,
                gbc
        );

        gbc.gridx = 5;

        tarjetaFormulario.add(
                txtHora,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 6;

        tarjetaFormulario.add(
                lblMotivo,
                gbc
        );

        gbc.gridx = 6;

        tarjetaFormulario.add(
                txtMotivo,
                gbc
        );

        Estilos.estilizarBoton(
                btnGuardar
        );

      

        btnGuardar.setPreferredSize(
                new java.awt.Dimension(
                        140,
                        38
                )
        );
        btnVolver.setText(
                ""
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
                }
        );
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        gbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        15,
                        0
                );

        tarjetaFormulario.add(
                btnVolver,
                gbc
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
        gbc.gridy = 6;
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
    public javax.swing.JPanel obtenerPanelCrearEditarTurno() {

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

        if (reprogramando) {

            lblTituloFormulario.setText(
                    "REPROGRAMAR TURNO"
            );

        } else if (idTurno == -1) {

            lblTituloFormulario.setText(
                    "NUEVO TURNO"
            );

        } else {

            lblTituloFormulario.setText(
                    "EDITAR TURNO"
            );
        }

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
                javax.swing.Box.createVerticalStrut(10)
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
                                25,
                                50,
                                25,
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
            lblAnimal,
            lblDueno,
            lblDni,
            lblFecha,
            lblHora,
            lblMotivo
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
            txtDueno,
            txtDni,
            txtFecha,
            txtHora,
            txtMotivo
        };

       java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        300,
                        38
                );

        for (javax.swing.JTextField campo : campos) {

            campo.setFont(
                    Estilos.fuenteNormal()
            );

            campo.setPreferredSize(
                    tamañoCampo
            );

            campo.setMinimumSize(
                    tamañoCampo
            );
        }

        cmbAnimal.setFont(
                Estilos.fuenteNormal()
        );

        cmbAnimal.setPreferredSize(
                tamañoCampo
        );

        cmbAnimal.setMinimumSize(
                tamañoCampo
        );

        txtDueno.setEditable(false);
        txtDni.setEditable(false);

        txtDueno.setBackground(
                new java.awt.Color(
                        245,
                        245,
                        245
                )
        );

        txtDni.setBackground(
                new java.awt.Color(
                        245,
                        245,
                        245
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        tarjetaFormulario.add(lblAnimal, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(cmbAnimal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        tarjetaFormulario.add(lblDueno, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtDueno, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        tarjetaFormulario.add(lblDni, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtDni, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        tarjetaFormulario.add(lblFecha, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtFecha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        tarjetaFormulario.add(lblHora, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtHora, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        tarjetaFormulario.add(lblMotivo, gbc);

        gbc.gridx = 1;
        tarjetaFormulario.add(txtMotivo, gbc);

        Estilos.estilizarBoton(
                btnGuardar
        );


        btnGuardar.setPreferredSize(
                new java.awt.Dimension(
                        140,
                        38
                )
        );

        
        btnVolver.setText(
                ""
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
                }
        );
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        gbc.insets =
                new java.awt.Insets(
                        0,
                        10,
                        15,
                        0
                );

        tarjetaFormulario.add(
                btnVolver,
                gbc
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
     
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        gbc.insets =
                new java.awt.Insets(
                        15,
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
        java.awt.EventQueue.invokeLater(() -> new VentanaCrearTurno().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbAnimal;
    private javax.swing.JLabel lblAnimal;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDueno;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDueno;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables
}
