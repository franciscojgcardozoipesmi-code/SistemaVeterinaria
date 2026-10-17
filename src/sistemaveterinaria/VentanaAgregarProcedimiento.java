package sistemaveterinaria;
import controller.AnimalController;
import controller.ProcedimientoMedicoController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import controller.TipoProcedimientoController;
public class VentanaAgregarProcedimiento extends javax.swing.JFrame {
    private String rolUsuario;
    private int idProcedimiento = -1;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAgregarProcedimiento.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    private final javax.swing.JComboBox<String> cmbTipo =
        new javax.swing.JComboBox<>();
    public VentanaAgregarProcedimiento() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarAnimales();
        configurarTipos();
    }

    public VentanaAgregarProcedimiento(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarAnimales();
        configurarTipos();
    }
    
    public VentanaAgregarProcedimiento(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarAnimales();
        configurarTipos();
    }
    
    public void cargarDatos(
            int idProcedimiento,
            String tipo,
            boolean emergencia,
            double monto,
            int idAnimal,
            String fecha,
            String descripcion
    ) {

        this.idProcedimiento =
                idProcedimiento;

        cmbTipo.setSelectedItem(
                tipo
        );

        chkEmergencia.setSelected(
                emergencia
        );

        txtMonto.setText(
                String.valueOf(monto)
        );

        txtFecha.setText(
                fecha
        );

        txtDescripcion.setText(
                descripcion
        );

        for (int i = 0;
                i < cmbAnimal.getItemCount();
                i++) {

            String item =
                    cmbAnimal.getItemAt(i);

            if (item.startsWith(
                    idAnimal + " - "
            )) {

                cmbAnimal.setSelectedIndex(i);
                break;
            }
        }
    }
    private void configurarTipos() {

        TipoProcedimientoController.inicializarCatalogo();

        java.awt.Dimension tamañoTipo =
                new java.awt.Dimension(
                        250,
                        32
                );

        cmbTipo.setFont(
                Estilos.fuenteNormal()
        );

        cmbTipo.setPreferredSize(
                tamañoTipo
        );

        cmbTipo.setMinimumSize(
                tamañoTipo
        );

        cmbTipo.removeAllItems();

        for (String tipo
                : TipoProcedimientoController.listarTipos()) {

            cmbTipo.addItem(
                    tipo
            );
        }
    }
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
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblEmergencia = new javax.swing.JLabel();
        chkEmergencia = new javax.swing.JCheckBox();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        lblAnimal = new javax.swing.JLabel();
        cmbAnimal = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTipo.setText("Tipo");

        txtTipo.addActionListener(this::txtTipoActionPerformed);

        lblEmergencia.setText("Emergencia");

        chkEmergencia.setText("Emergencia");

        lblMonto.setText("Monto");

        lblAnimal.setText("Animal");

        cmbAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        lblFecha.setText("Fecha");

        jLabel1.setText("Descripción/obervaciones");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblFecha)
                        .addGap(103, 103, 103)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmergencia)
                                .addGap(104, 104, 104)
                                .addComponent(chkEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMonto)
                                    .addComponent(lblTipo)
                                    .addComponent(lblAnimal))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(28, 28, 28)
                        .addComponent(btnVolver))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cmbAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(135, 135, 135))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmergencia)
                    .addComponent(chkEmergencia))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnimal)
                    .addComponent(cmbAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo))
                .addGap(29, 29, 29)
                .addComponent(lblMonto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVolver)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
            try {

            Object tipoSeleccionado =
                    cmbTipo.getSelectedItem();

            String montoTexto =
                    txtMonto.getText().trim();

            String fecha =
                    txtFecha.getText().trim();

            String descripcion =
                    txtDescripcion.getText().trim();

            if (tipoSeleccionado == null
                    || montoTexto.isEmpty()
                    || fecha.isEmpty()
                    || descripcion.isEmpty()
                    || cmbAnimal.getSelectedItem() == null) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "Completá todos los campos obligatorios"
                );

                return;
            }

            try {

                DateTimeFormatter formato =
                        DateTimeFormatter
                                .ofPattern("dd/MM/uuuu")
                                .withResolverStyle(
                                        ResolverStyle.STRICT
                                );

                LocalDate.parse(
                        fecha,
                        formato
                );

            } catch (DateTimeParseException e) {

                Estilos.mostrarAdvertencia(
                        this,
                        "Atención",
                        "La fecha debe tener formato dd/MM/yyyy y ser válida"
                );

                return;
            }

            String tipo =
                    tipoSeleccionado.toString();

            double monto =
                    Double.parseDouble(
                            montoTexto
                    );

            boolean emergencia =
                    chkEmergencia.isSelected();

            String animalSeleccionado =
                    cmbAnimal.getSelectedItem().toString();

            int idAnimal =
                    Integer.parseInt(
                            animalSeleccionado.split(" - ")[0]
                    );

            ProcedimientoMedicoController.guardarProcedimiento(
                    tipo,
                    emergencia,
                    monto,
                    idAnimal,
                    fecha,
                    descripcion,
                    idProcedimiento
            );

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "Procedimiento guardado correctamente"
            );

            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarProcedimientos();

            } else {

                VentanaProcedimientosMedicos vp =
                        new VentanaProcedimientosMedicos(
                                rolUsuario
                        );

                vp.setVisible(true);

                dispose();
            }

        } catch (NumberFormatException e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "El monto debe ser un número válido"
            );

        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo guardar el procedimiento: "
                    + e.getMessage()
            );
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (ventanaPrincipal != null) {

            ventanaPrincipal.mostrarProcedimientos();

        } else {

            VentanaProcedimientosMedicos vp =
                    new VentanaProcedimientosMedicos(rolUsuario);

            vp.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    public javax.swing.JPanel obtenerPanelCrearEditarProcedimiento() {

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

        javax.swing.JLabel lblTituloFormulario =
                new javax.swing.JLabel(
                        idProcedimiento == -1
                                ? "NUEVO PROCEDIMIENTO"
                                : "EDITAR PROCEDIMIENTO"
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

        javax.swing.JPanel contenido =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        contenido.setOpaque(false);

        javax.swing.JPanel tarjeta =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        tarjeta.setBackground(
                Estilos.BLANCO
        );

        tarjeta.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                25,
                                40,
                                25,
                                40
                        )
                )
        );

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        javax.swing.JLabel[] etiquetas = {
            lblFecha,
            lblAnimal,
            lblTipo,
            lblEmergencia,
            lblMonto,
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

        java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        250,
                        32
                );

        txtFecha.setFont(
                Estilos.fuenteNormal()
        );

        txtFecha.setPreferredSize(
                tamañoCampo
        );

        txtFecha.setMinimumSize(
                tamañoCampo
        );

        txtMonto.setFont(
                Estilos.fuenteNormal()
        );

        txtMonto.setPreferredSize(
                tamañoCampo
        );

        txtMonto.setMinimumSize(
                tamañoCampo
        );

        cmbAnimal.setFont(
                Estilos.fuenteNormal()
        );

        cmbAnimal.setPreferredSize(
                tamañoCampo
        );

        cmbAnimal.setMinimumSize(
                tamañoCampo
        );

        cmbTipo.setFont(
                Estilos.fuenteNormal()
        );

        cmbTipo.setPreferredSize(
                tamañoCampo
        );

        cmbTipo.setMinimumSize(
                tamañoCampo
        );

        chkEmergencia.setFont(
                Estilos.fuenteNormal()
        );

        txtDescripcion.setFont(
                Estilos.fuenteNormal()
        );

        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);

        java.awt.Dimension tamañoDescripcion =
                new java.awt.Dimension(
                        250,
                        100
                );

        jScrollPane1.setPreferredSize(
                tamañoDescripcion
        );

        jScrollPane1.setMinimumSize(
                tamañoDescripcion
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
        gbc.fill =
                java.awt.GridBagConstraints.NONE;
        gbc.anchor =
                java.awt.GridBagConstraints.WEST;
        gbc.insets =
                new java.awt.Insets(
                        0,
                        8,
                        15,
                        0
                );

        tarjeta.add(
                btnVolver,
                gbc
        );

        gbc.gridwidth = 1;
        gbc.fill =
                java.awt.GridBagConstraints.HORIZONTAL;
        gbc.anchor =
                java.awt.GridBagConstraints.WEST;
        gbc.insets =
                new java.awt.Insets(
                        8,
                        8,
                        8,
                        8
                );

        gbc.gridx = 0;
        gbc.gridy = 1;

        tarjeta.add(
                lblFecha,
                gbc
        );

        gbc.gridx = 1;

        tarjeta.add(
                txtFecha,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        tarjeta.add(
                lblAnimal,
                gbc
        );

        gbc.gridx = 1;

        tarjeta.add(
                cmbAnimal,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 3;

        tarjeta.add(
                lblTipo,
                gbc
        );

        gbc.gridx = 1;

        tarjeta.add(
                cmbTipo,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 4;

        tarjeta.add(
                lblEmergencia,
                gbc
        );

        gbc.gridx = 1;

        chkEmergencia.setText(
                ""
        );

        tarjeta.add(
                chkEmergencia,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 5;

        tarjeta.add(
                lblMonto,
                gbc
        );

        gbc.gridx = 1;

        tarjeta.add(
                txtMonto,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor =
                java.awt.GridBagConstraints.NORTHWEST;

        tarjeta.add(
                jLabel1,
                gbc
        );

        gbc.gridx = 1;

        tarjeta.add(
                jScrollPane1,
                gbc
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
        gbc.fill =
                java.awt.GridBagConstraints.NONE;
        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;
        gbc.insets =
                new java.awt.Insets(
                        15,
                        8,
                        0,
                        8
                );

        tarjeta.add(
                panelBotones,
                gbc
        );

        contenido.add(
                tarjeta
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                contenido,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(() -> new VentanaAgregarProcedimiento().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkEmergencia;
    private javax.swing.JComboBox<String> cmbAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnimal;
    private javax.swing.JLabel lblEmergencia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
