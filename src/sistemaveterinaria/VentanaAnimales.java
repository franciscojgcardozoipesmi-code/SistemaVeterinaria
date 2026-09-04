package sistemaveterinaria;
import controller.AnimalController;
public class VentanaAnimales extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAnimales.class.getName());
    private VentanaPrincipal ventanaPrincipal;
   
    public VentanaAnimales() {

        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoAnimales();
    }
    
    public VentanaAnimales(String rolUsuario) {

        initComponents();

        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoAnimales();
    }
    
    public VentanaAnimales(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarTabla();
        configurarDiseñoAnimales();
    }
    
    private void cargarTabla() {

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
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");
        modelo.addColumn("Cliente");

        for (Object[] fila : AnimalController.listarAnimales()) {
            modelo.addRow(fila);
        }

        tblAnimales.setModel(modelo);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollAnimales = new javax.swing.JScrollPane();
        tblAnimales = new javax.swing.JTable();
        btnAgregarAnimal = new javax.swing.JButton();
        btnEditarAnimal = new javax.swing.JButton();
        btnDarDeBajaRegistro = new javax.swing.JButton();
        txtBuscar = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnHistorialMedico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAnimales.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollAnimales.setViewportView(tblAnimales);

        btnAgregarAnimal.setText("Agregar animal");
        btnAgregarAnimal.addActionListener(this::btnAgregarAnimalActionPerformed);

        btnEditarAnimal.setText("Editar animal");
        btnEditarAnimal.addActionListener(this::btnEditarAnimalActionPerformed);

        btnDarDeBajaRegistro.setText("Dar de baja el registro");
        btnDarDeBajaRegistro.addActionListener(this::btnDarDeBajaRegistroActionPerformed);

        txtBuscar.setText("Buscar");
        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        btnMostrarTodos.setText("Mostrar todos");
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        btnHistorialMedico.setText("Historial médico");
        btnHistorialMedico.addActionListener(this::btnHistorialMedicoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnDarDeBajaRegistro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnMostrarTodos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregarAnimal)
                            .addComponent(btnEditarAnimal))
                        .addGap(18, 18, 18)
                        .addComponent(btnHistorialMedico)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrollAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarAnimal)
                            .addComponent(btnHistorialMedico))
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarAnimal)
                        .addGap(18, 18, 18)
                        .addComponent(btnDarDeBajaRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar)
                        .addGap(26, 26, 26)
                        .addComponent(btnMostrarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVolver)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAnimalActionPerformed
                ventanaPrincipal.mostrarCrearAnimal();    
    }//GEN-LAST:event_btnAgregarAnimalActionPerformed

    private void btnDarDeBajaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaRegistroActionPerformed
        int fila = tblAnimales.getSelectedRow();

        if (fila == -1) {

            mostrarAviso(
                    "Aviso",
                    "Seleccioná un animal"
            );

            return;
        }

        int idAnimal = Integer.parseInt(
                tblAnimales.getValueAt(
                        fila,
                        0
                ).toString()
        );

        String nombreAnimal =
                tblAnimales.getValueAt(
                        fila,
                        1
                ).toString();

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Confirmar baja",
                        java.awt.Dialog.ModalityType.APPLICATION_MODAL
                );

        dialogo.setUndecorated(true);

        java.awt.Color ROJO =
                new java.awt.Color(
                        190,
                        45,
                        45
                );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                14
                        )
                );

        panelPrincipal.setBackground(
                Estilos.BLANCO
        );

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                ROJO,
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
                        "CONFIRMAR BAJA",
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
                ROJO
        );

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

        javax.swing.JPanel panelMensaje =
                new javax.swing.JPanel();

        panelMensaje.setOpaque(false);

        panelMensaje.setLayout(
                new javax.swing.BoxLayout(
                        panelMensaje,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        javax.swing.JLabel lblMensaje1 =
                new javax.swing.JLabel(
                        "¿Seguro que querés dar de baja",
                        javax.swing.SwingConstants.CENTER
                );

        lblMensaje1.setFont(
                Estilos.fuente(13f)
        );

        lblMensaje1.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblMensaje1.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        javax.swing.JLabel lblMensaje2 =
                new javax.swing.JLabel(
                        "el registro de "
                        + nombreAnimal
                        + "?",
                        javax.swing.SwingConstants.CENTER
                );

        lblMensaje2.setFont(
                Estilos.fuente(13f)
        );

        lblMensaje2.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblMensaje2.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        panelMensaje.add(
                lblMensaje1
        );

        panelMensaje.add(
                javax.swing.Box.createVerticalStrut(4)
        );

        panelMensaje.add(
                lblMensaje2
        );

        javax.swing.JButton btnCancelarDialogo =
                new javax.swing.JButton(
                        "Cancelar"
                );

        javax.swing.JButton btnConfirmarDialogo =
                new javax.swing.JButton(
                        "Confirmar"
                );

        Estilos.estilizarBoton(
                btnCancelarDialogo
        );

        Estilos.estilizarBotonEliminar(
                btnConfirmarDialogo
        );

        btnCancelarDialogo.setPreferredSize(
                new java.awt.Dimension(
                        115,
                        34
                )
        );

        btnConfirmarDialogo.setPreferredSize(
                new java.awt.Dimension(
                        125,
                        34
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
                btnCancelarDialogo
        );

        panelBotones.add(
                btnConfirmarDialogo
        );

        javax.swing.JPanel contenido =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                12
                        )
                );

        contenido.setOpaque(false);

        contenido.add(
                panelMensaje,
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

        btnCancelarDialogo.addActionListener(e -> {

            dialogo.dispose();
        });

        btnConfirmarDialogo.addActionListener(e -> {

            AnimalController.eliminarAnimal(
                    idAnimal
            );

            dialogo.dispose();

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "Registro dado de baja correctamente"
            );

            cargarTabla();
        });

        dialogo.setContentPane(
                panelPrincipal
        );

        dialogo.setSize(
                400,
                185
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(true);
    }//GEN-LAST:event_btnDarDeBajaRegistroActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        VentanaPrincipal vp =
                new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAnimalActionPerformed
            int fila = tblAnimales.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un animal"
            );

            return;
        }

        int idAnimal = Integer.parseInt(
                tblAnimales.getValueAt(fila, 0).toString()
        );

        String nombre =
                tblAnimales.getValueAt(fila, 1).toString();

        String especie =
                tblAnimales.getValueAt(fila, 2).toString();

        String raza =
                tblAnimales.getValueAt(fila, 3).toString();

        int edad = Integer.parseInt(
                tblAnimales.getValueAt(fila, 4).toString()
        );

        int idCliente =
                AnimalController.obtenerIdClientePorAnimal(
                        idAnimal
                );

        ventanaPrincipal.mostrarEditarAnimal(
                idAnimal,
                nombre,
                especie,
                raza,
                edad,
                idCliente
        );
    }//GEN-LAST:event_btnEditarAnimalActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
            java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Buscar animal",
                        java.awt.Dialog.ModalityType.APPLICATION_MODAL
                );

        dialogo.setUndecorated(true);

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
                        "BUSCAR ANIMAL",
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

        javax.swing.JPanel panelCentro =
                new javax.swing.JPanel();

        panelCentro.setOpaque(false);

        panelCentro.setLayout(
                new javax.swing.BoxLayout(
                        panelCentro,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        javax.swing.JLabel lblBuscar =
                new javax.swing.JLabel(
                        "Buscar por nombre, especie o raza:"
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

        panelCentro.add(
                lblBuscar
        );

        panelCentro.add(
                javax.swing.Box.createVerticalStrut(10)
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

        panelBotones.setOpaque(false);

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

        contenido.setOpaque(false);

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

                buscarAnimales(texto);

                dialogo.dispose();
            }
        });

        campoBuscar.addActionListener(e ->
                btnBuscarDialogo.doClick()
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

        campoBuscar.requestFocusInWindow();

        dialogo.setVisible(true);
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed

        cargarTabla();

    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void btnHistorialMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialMedicoActionPerformed
        int fila = tblAnimales.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un animal"
            );

            return;
        }

        int idAnimal = Integer.parseInt(
                tblAnimales.getValueAt(
                        fila,
                        0
                ).toString()
        );

        String nombreAnimal =
                tblAnimales.getValueAt(
                        fila,
                        1
                ).toString();

        ventanaPrincipal.mostrarHistorialMedico(
                idAnimal,
                nombreAnimal
        );
    }//GEN-LAST:event_btnHistorialMedicoActionPerformed
    private void buscarAnimales(String filtro) {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");
        modelo.addColumn("Cliente");

        for (Object[] fila : AnimalController.buscarAnimales(filtro)) {
            modelo.addRow(fila);
        }

        tblAnimales.setModel(modelo);
    }
    private void configurarDiseñoAnimales() {

        setTitle(
                "Henry System Vet - Gestión de animales"
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
                        "GESTIÓN DE ANIMALES"
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


        javax.swing.JPanel tarjetaAnimales =
                new javax.swing.JPanel();

        tarjetaAnimales.setBackground(
                Estilos.BLANCO
        );

        tarjetaAnimales.setLayout(
                new java.awt.BorderLayout(
                        0,
                        20
                )
        );

        tarjetaAnimales.setBorder(
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
                tblAnimales
        );

        scrollAnimales.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollAnimales.setPreferredSize(
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

        tblAnimales.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblAnimales.getColumnModel()
                .getColumn(4)
                .setCellRenderer(centrado);

        tblAnimales.getColumnModel()
                .getColumn(5)
                .setCellRenderer(centrado);


        tarjetaAnimales.add(
                scrollAnimales,
                java.awt.BorderLayout.CENTER
        );


        Estilos.estilizarBoton(
                btnAgregarAnimal
        );

        Estilos.estilizarBoton(
                btnEditarAnimal
        );

        Estilos.estilizarBoton(
                btnDarDeBajaRegistro
        );

        Estilos.estilizarBoton(
                btnHistorialMedico
        );

        Estilos.estilizarBoton(
                txtBuscar
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
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


        btnAgregarAnimal.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnEditarAnimal.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnDarDeBajaRegistro.setPreferredSize(
                new java.awt.Dimension(
                        210,
                        38
                )
        );

        btnHistorialMedico.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        txtBuscar.setPreferredSize(
                new java.awt.Dimension(
                        130,
                        38
                )
        );

        btnMostrarTodos.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );


        panelBotones.add(
                btnAgregarAnimal
        );

        panelBotones.add(
                btnEditarAnimal
        );

        panelBotones.add(
                btnDarDeBajaRegistro
        );

        panelBotones.add(
                btnHistorialMedico
        );

        panelBotones.add(
                txtBuscar
        );

        panelBotones.add(
                btnMostrarTodos
        );


        tarjetaAnimales.add(
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
                tarjetaAnimales,
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
    
    public javax.swing.JPanel obtenerPanelAnimales() {

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
                        "GESTIÓN DE ANIMALES"
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

        javax.swing.JPanel tarjetaAnimales =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaAnimales.setBackground(
                Estilos.BLANCO
        );

        tarjetaAnimales.setBorder(
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
                tblAnimales
        );

        scrollAnimales.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblAnimales.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblAnimales.getColumnModel()
                .getColumn(4)
                .setCellRenderer(centrado);

        tblAnimales.getColumnModel()
                .getColumn(5)
                .setCellRenderer(centrado);

        tarjetaAnimales.add(
                scrollAnimales,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnAgregarAnimal
        );

        Estilos.estilizarBoton(
                btnEditarAnimal
        );

        Estilos.estilizarBotonEliminar(
                btnDarDeBajaRegistro
        );
        btnDarDeBajaRegistro.setText(
                "Dar de baja el registro"
        );

        Estilos.estilizarBoton(
                btnHistorialMedico
        );

        Estilos.estilizarBoton(
                txtBuscar
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );

        btnAgregarAnimal.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnEditarAnimal.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnDarDeBajaRegistro.setPreferredSize(
                new java.awt.Dimension(
                        260,
                        38
                )
        );

        btnHistorialMedico.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        txtBuscar.setPreferredSize(
                new java.awt.Dimension(
                        130,
                        38
                )
        );

        btnMostrarTodos.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        javax.swing.JPanel panelBotones =
        new javax.swing.JPanel();

        panelBotones.setOpaque(false);

        panelBotones.setLayout(
                new javax.swing.BoxLayout(
                        panelBotones,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        javax.swing.JPanel filaPrincipal =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        filaPrincipal.setOpaque(false);

        javax.swing.JPanel filaBaja =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        filaBaja.setOpaque(false);

        btnAgregarAnimal.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnEditarAnimal.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnHistorialMedico.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        txtBuscar.setPreferredSize(
                new java.awt.Dimension(
                        130,
                        38
                )
        );

        btnMostrarTodos.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnDarDeBajaRegistro.setPreferredSize(
                new java.awt.Dimension(
                        210,
                        38
                )
        );

        filaPrincipal.add(
                btnAgregarAnimal
        );

        filaPrincipal.add(
                btnEditarAnimal
        );

        filaPrincipal.add(
                btnHistorialMedico
        );

        filaPrincipal.add(
                txtBuscar
        );

        filaPrincipal.add(
                btnMostrarTodos
        );

        btnDarDeBajaRegistro.setText(
            "Dar de baja el registro"
        );

        java.awt.Dimension tamañoBotonBaja =
                new java.awt.Dimension(
                        300,
                        38
                );

        btnDarDeBajaRegistro.setPreferredSize(
                tamañoBotonBaja
        );

        btnDarDeBajaRegistro.setMinimumSize(
                tamañoBotonBaja
        );

        btnDarDeBajaRegistro.setMaximumSize(
                tamañoBotonBaja
        );

        filaBaja.add(
                btnDarDeBajaRegistro
        );

        panelBotones.add(
                filaPrincipal
        );

        panelBotones.add(
                javax.swing.Box.createVerticalStrut(10)
        );

        panelBotones.add(
                filaBaja
        );

        tarjetaAnimales.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );
        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaAnimales,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    private void mostrarAviso(
            String titulo,
            String mensaje
    ) {

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        titulo,
                        java.awt.Dialog.ModalityType.APPLICATION_MODAL
                );

        dialogo.setUndecorated(true);

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                15
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
                                20,
                                18,
                                20
                        )
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        titulo.toUpperCase(),
                        javax.swing.SwingConstants.CENTER
                );

        lblTitulo.setFont(
                Estilos.fuente(18f)
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
                        mensaje,
                        javax.swing.SwingConstants.CENTER
                );

        lblMensaje.setFont(
                Estilos.fuente(13f)
        );

        lblMensaje.setForeground(
                Estilos.VERDE_OSCURO
        );

        javax.swing.JButton btnAceptar =
                new javax.swing.JButton(
                        "Aceptar"
                );

        Estilos.estilizarBoton(
                btnAceptar
        );

        btnAceptar.setPreferredSize(
                new java.awt.Dimension(
                        105,
                        34
                )
        );

        javax.swing.JPanel panelBoton =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                0
                        )
                );

        panelBoton.setOpaque(false);

        panelBoton.add(
                btnAceptar
        );

        javax.swing.JPanel contenido =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                12
                        )
                );

        contenido.setOpaque(false);

        contenido.add(
                lblMensaje,
                java.awt.BorderLayout.CENTER
        );

        contenido.add(
                panelBoton,
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

        btnAceptar.addActionListener(e ->
                dialogo.dispose()
        );

        dialogo.getRootPane().setDefaultButton(
                btnAceptar
        );

        dialogo.setContentPane(
                panelPrincipal
        );

        dialogo.setSize(
                330,
                165
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(true);
    }
    
    public void seleccionarAnimal(int idAnimal) {

        for (int filaModelo = 0;
                filaModelo < tblAnimales.getRowCount();
                filaModelo++) {

            int idFila = Integer.parseInt(
                    tblAnimales.getValueAt(
                            filaModelo,
                            0
                    ).toString()
            );

            if (idFila == idAnimal) {

                int filaVista =
                        tblAnimales.convertRowIndexToView(
                                filaModelo
                        );

                tblAnimales.setRowSelectionInterval(
                        filaVista,
                        filaVista
                );

                java.awt.Rectangle rectangulo =
                        tblAnimales.getCellRect(
                                filaVista,
                                0,
                                true
                        );

                tblAnimales.scrollRectToVisible(
                        rectangulo
                );

                tblAnimales.requestFocusInWindow();

                return;
            }
        }
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new VentanaAnimales().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAnimal;
    private javax.swing.JButton btnDarDeBajaRegistro;
    private javax.swing.JButton btnEditarAnimal;
    private javax.swing.JButton btnHistorialMedico;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollAnimales;
    private javax.swing.JTable tblAnimales;
    private javax.swing.JButton txtBuscar;
    // End of variables declaration//GEN-END:variables
}
