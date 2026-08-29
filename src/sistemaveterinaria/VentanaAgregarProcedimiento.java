package sistemaveterinaria;
import controller.AnimalController;
import controller.ProcedimientoMedicoController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
public class VentanaAgregarProcedimiento extends javax.swing.JFrame {
    private String rolUsuario;
    private int idProcedimiento = -1;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAgregarProcedimiento.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    public VentanaAgregarProcedimiento() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarAnimales();
    }

    public VentanaAgregarProcedimiento(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarAnimales();
    }
    
    public VentanaAgregarProcedimiento(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarAnimales();
    }
    
    public void cargarDatos(int idProcedimiento,
                            String tipo,
                            boolean emergencia,
                            double monto,
                            int idAnimal,
                            String fecha,
                            String descripcion) {

        this.idProcedimiento = idProcedimiento;
                
        txtTipo.setText(tipo);
        chkEmergencia.setSelected(emergencia);
        txtMonto.setText(String.valueOf(monto));
        txtDescripcion.setText(descripcion);
        for (int i = 0; i < cmbAnimal.getItemCount(); i++) {

            String item = cmbAnimal.getItemAt(i);

            if (item.startsWith(idAnimal + " - ")) {
                cmbAnimal.setSelectedIndex(i);
                break;
            }
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

            String tipo = txtTipo.getText().trim();
            String montoTexto = txtMonto.getText().trim();
            String fecha = txtFecha.getText().trim();
            try {

                DateTimeFormatter formato =
                        DateTimeFormatter.ofPattern("dd/MM/uuuu")
                                .withResolverStyle(ResolverStyle.STRICT);

                LocalDate.parse(fecha, formato);

            } catch (DateTimeParseException e) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "La fecha debe tener formato dd/MM/yyyy y ser válida"
                );

                return;
            }
            String descripcion = txtDescripcion.getText().trim();
            if (tipo.isEmpty()
                    || montoTexto.isEmpty()
                    || fecha.isEmpty()
                    || descripcion.isEmpty()
                    || cmbAnimal.getSelectedItem() == null) {
                
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Completar todos los campos obligatorios"
                );

                return;
            }

            double monto = Double.parseDouble(montoTexto);

            boolean emergencia = chkEmergencia.isSelected();

            String animalSeleccionado =
                    cmbAnimal.getSelectedItem().toString();

            int idAnimal = Integer.parseInt(
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
                        new VentanaProcedimientosMedicos(rolUsuario);

                vp.setVisible(true);

                this.dispose();
            }

        } catch (NumberFormatException e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "El monto debe ser un número válido"
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
                                30,
                                40,
                                30,
                                40
                        )
                )
        );

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.insets =
                new java.awt.Insets(
                        8,
                        8,
                        8,
                        8
                );

        gbc.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        javax.swing.JLabel lblTituloFormulario =
                new javax.swing.JLabel(
                        idProcedimiento == -1
                                ? "NUEVO PROCEDIMIENTO"
                                : "EDITAR PROCEDIMIENTO"
                );

        lblTituloFormulario.setFont(
                Estilos.fuente(24f)
        );

        lblTituloFormulario.setForeground(
                Estilos.VERDE_OSCURO
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        tarjeta.add(
                lblTituloFormulario,
                gbc
        );

        gbc.gridwidth = 1;
        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        lblFecha.setFont(
                Estilos.fuenteNormal()
        );

        lblAnimal.setFont(
                Estilos.fuenteNormal()
        );

        lblTipo.setFont(
                Estilos.fuenteNormal()
        );

        lblEmergencia.setFont(
                Estilos.fuenteNormal()
        );

        lblMonto.setFont(
                Estilos.fuenteNormal()
        );

        jLabel1.setFont(
                Estilos.fuenteNormal()
        );

        gbc.gridx = 0;
        gbc.gridy = 1;
        tarjeta.add(lblFecha, gbc);

        gbc.gridx = 1;
        txtFecha.setPreferredSize(
                new java.awt.Dimension(
                        250,
                        32
                )
        );
        tarjeta.add(txtFecha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        tarjeta.add(lblAnimal, gbc);

        gbc.gridx = 1;
        cmbAnimal.setPreferredSize(
                new java.awt.Dimension(
                        250,
                        32
                )
        );
        tarjeta.add(cmbAnimal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        tarjeta.add(lblTipo, gbc);

        gbc.gridx = 1;
        txtTipo.setPreferredSize(
                new java.awt.Dimension(
                        250,
                        32
                )
        );
        tarjeta.add(txtTipo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        tarjeta.add(lblEmergencia, gbc);

        gbc.gridx = 1;
        tarjeta.add(chkEmergencia, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        tarjeta.add(lblMonto, gbc);

        gbc.gridx = 1;
        txtMonto.setPreferredSize(
                new java.awt.Dimension(
                        250,
                        32
                )
        );
        tarjeta.add(txtMonto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor =
                java.awt.GridBagConstraints.NORTHWEST;

        tarjeta.add(jLabel1, gbc);

        gbc.gridx = 1;

        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);

        jScrollPane1.setPreferredSize(
                new java.awt.Dimension(
                        250,
                        100
                )
        );

        tarjeta.add(jScrollPane1, gbc);

        Estilos.estilizarBoton(
                btnGuardar
        );

        Estilos.estilizarBoton(
                btnVolver
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
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor =
                java.awt.GridBagConstraints.CENTER;

        tarjeta.add(
                panelBotones,
                gbc
        );

        contenido.add(tarjeta);

        panel.add(
                contenido,
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
