package sistemaveterinaria;
import controller.ProcedimientoMedicoController;

public class VentanaProcedimientosMedicos extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaProcedimientosMedicos.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    public VentanaProcedimientosMedicos() {
        initComponents();

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoProcedimientos();
    }
    public VentanaProcedimientosMedicos(String rolUsuario) {
        initComponents();

        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoProcedimientos();
    }
    public VentanaProcedimientosMedicos(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarTabla();
        configurarDiseñoProcedimientos();
    }
    
    private void buscarProcedimientos(String filtro) {

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
        modelo.addColumn("Tipo");
        modelo.addColumn("Emergencia");
        modelo.addColumn("Monto");
        modelo.addColumn("ID Animal");
        modelo.addColumn("Animal");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripción");
        for (Object[] fila :
                ProcedimientoMedicoController.buscarProcedimientos(filtro)) {

            modelo.addRow(fila);
        }

        tblProcedimientos.setModel(modelo);
                tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMinWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMaxWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(0);
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
        modelo.addColumn("Tipo");
        modelo.addColumn("Emergencia");
        modelo.addColumn("Monto");
        modelo.addColumn("ID Animal");
        modelo.addColumn("Animal");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripción");

        for (Object[] fila :
                ProcedimientoMedicoController.listarProcedimientos()) {

            modelo.addRow(fila);
        }

        tblProcedimientos.setModel(modelo);
        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMinWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMaxWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollProcedimientos = new javax.swing.JScrollPane();
        tblProcedimientos = new javax.swing.JTable();
        btnAgregarProcedimiento = new javax.swing.JButton();
        btnEditarProcedimiento = new javax.swing.JButton();
        btnDarDeBajaRegistro = new javax.swing.JButton();
        btnBuscarProcedimiento = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProcedimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollProcedimientos.setViewportView(tblProcedimientos);

        btnAgregarProcedimiento.setText("Agregar procedimiento");
        btnAgregarProcedimiento.addActionListener(this::btnAgregarProcedimientoActionPerformed);

        btnEditarProcedimiento.setText("Editar procedimiento");
        btnEditarProcedimiento.addActionListener(this::btnEditarProcedimientoActionPerformed);

        btnDarDeBajaRegistro.setText("Dar de baja el registro");
        btnDarDeBajaRegistro.addActionListener(this::btnDarDeBajaRegistroActionPerformed);

        btnBuscarProcedimiento.setText("Buscar");
        btnBuscarProcedimiento.addActionListener(this::btnBuscarProcedimientoActionPerformed);

        btnMostrarTodos.setText("Mostrar todos");
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollProcedimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnMostrarTodos)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnDarDeBajaRegistro))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAgregarProcedimiento)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditarProcedimiento)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnVolver))
                            .addComponent(btnBuscarProcedimiento))
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollProcedimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarProcedimiento)
                            .addComponent(btnEditarProcedimiento)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVolver)))
                .addGap(3, 3, 3)
                .addComponent(btnBuscarProcedimiento)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDarDeBajaRegistro)
                    .addComponent(btnMostrarTodos))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed


        VentanaPrincipal vp =
                new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProcedimientoActionPerformed
        ventanaPrincipal.mostrarCrearProcedimiento();    
    }//GEN-LAST:event_btnAgregarProcedimientoActionPerformed

    private void btnEditarProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProcedimientoActionPerformed
        int fila = tblProcedimientos.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un procedimiento"
            );

            return;
        }

        int idProcedimiento = Integer.parseInt(
                tblProcedimientos.getValueAt(fila, 0).toString()
        );

        String tipo =
                tblProcedimientos.getValueAt(fila, 1).toString();

        boolean emergencia =
                tblProcedimientos.getValueAt(fila, 2)
                        .toString()
                        .equals("Sí");

        double monto = Double.parseDouble(
                tblProcedimientos.getValueAt(fila, 3).toString()
        );

        int idAnimal = Integer.parseInt(
                tblProcedimientos.getValueAt(fila, 4).toString()
        );

        String fecha =
                tblProcedimientos.getValueAt(fila, 6).toString();

        String descripcion =
                tblProcedimientos.getValueAt(fila, 7).toString();

        ventanaPrincipal.mostrarEditarProcedimiento(
                idProcedimiento,
                tipo,
                emergencia,
                monto,
                idAnimal,
                fecha,
                descripcion
        );
    }//GEN-LAST:event_btnEditarProcedimientoActionPerformed

    private void btnDarDeBajaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaRegistroActionPerformed
        int fila = tblProcedimientos.getSelectedRow();

        if (fila == -1) {
            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un procedimiento"
            );
            return;
        }

        int idProcedimiento = Integer.parseInt(
                tblProcedimientos.getValueAt(fila, 0).toString()
        );

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Confirmar baja",
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
                        "CONFIRMAR BAJA",
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
                        "¿Seguro que querés dar de baja este procedimiento?",
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
                ProcedimientoMedicoController.eliminarProcedimiento(
                        idProcedimiento
                );

                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Operación exitosa",
                        "Registro dado de baja correctamente"
                );

                cargarTabla();

            } catch (Exception ex) {
                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Error",
                        "No se pudo dar de baja el procedimiento"
                );
            }
        });

        dialogo.setContentPane(panelPrincipal);
        dialogo.setSize(450, 180);
        dialogo.setLocationRelativeTo(ventanaPadre);
        dialogo.setVisible(true);     
    }//GEN-LAST:event_btnDarDeBajaRegistroActionPerformed

    private void btnBuscarProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProcedimientoActionPerformed
        java.awt.Window ventanaPadre =
            javax.swing.SwingUtilities.getWindowAncestor(this);

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Buscar procedimiento",
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
                        "BUSCAR PROCEDIMIENTO",
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
                        "Buscar por tipo, animal o fecha:"
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

        panelCentro.setOpaque(false);

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

                buscarProcedimientos(texto);

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
                390,
                200
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(true);       
    }//GEN-LAST:event_btnBuscarProcedimientoActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        
        cargarTabla();
    
    }//GEN-LAST:event_btnMostrarTodosActionPerformed
    private void configurarDiseñoProcedimientos() {

        setTitle(
                "Henry System Vet - Gestión de procedimientos"
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
                        "GESTIÓN DE PROCEDIMIENTOS"
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

        javax.swing.JPanel tarjetaProcedimientos =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaProcedimientos.setBackground(
                Estilos.BLANCO
        );

        tarjetaProcedimientos.setBorder(
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
                tblProcedimientos
        );

        scrollProcedimientos.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        scrollProcedimientos.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        400
                )
        );

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMinWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMaxWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(0);

        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblProcedimientos.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(3)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(6)
                .setCellRenderer(centrado);

        tarjetaProcedimientos.add(
                scrollProcedimientos,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnAgregarProcedimiento
        );

        Estilos.estilizarBoton(
                btnEditarProcedimiento
        );

        Estilos.estilizarBotonEliminar(
                btnDarDeBajaRegistro
        );

        Estilos.estilizarBoton(
                btnBuscarProcedimiento
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

        btnAgregarProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        220,
                        38
                )
        );

        btnEditarProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        200,
                        38
                )
        );

        btnDarDeBajaRegistro.setPreferredSize(
                new java.awt.Dimension(
                        230,
                        38
                )
        );

        btnBuscarProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        150,
                        38
                )
        );

        btnMostrarTodos.setPreferredSize(
                new java.awt.Dimension(
                        160,
                        38
                )
        );

        panelBotones.add(
                btnAgregarProcedimiento
        );

        panelBotones.add(
                btnEditarProcedimiento
        );

        panelBotones.add(
                btnDarDeBajaRegistro
        );

        panelBotones.add(
                btnBuscarProcedimiento
        );

        panelBotones.add(
                btnMostrarTodos
        );

        tarjetaProcedimientos.add(
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
                tarjetaProcedimientos,
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
    public javax.swing.JPanel obtenerPanelProcedimientos() {

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
                        "Gestión de procedimientos médicos"
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

        javax.swing.JPanel tarjetaProcedimientos =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaProcedimientos.setBackground(
                Estilos.BLANCO
        );

        tarjetaProcedimientos.setBorder(
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
                tblProcedimientos
        );

        scrollProcedimientos.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMinWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setMaxWidth(0);

        tblProcedimientos.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(0);

        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblProcedimientos.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(3)
                .setCellRenderer(centrado);

        tblProcedimientos.getColumnModel()
                .getColumn(6)
                .setCellRenderer(centrado);

        tarjetaProcedimientos.add(
                scrollProcedimientos,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnAgregarProcedimiento
        );

        Estilos.estilizarBotonEditar(
                btnEditarProcedimiento
        );

        Estilos.estilizarBotonEliminar(
                btnDarDeBajaRegistro
        );

        Estilos.estilizarBoton(
                btnBuscarProcedimiento
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );

        Estilos.aplicarIcono(
                btnAgregarProcedimiento,
                "/imagenes/iconos/agregar.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnEditarProcedimiento,
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

        btnDarDeBajaRegistro.setIcon(
                null
        );

        btnBuscarProcedimiento.setText("");

        btnBuscarProcedimiento.setToolTipText(
                "Buscar procedimiento"
        );

        Estilos.aplicarIcono(
                btnBuscarProcedimiento,
                "/imagenes/iconos/buscar.png",
                20,
                20
        );

        java.awt.Dimension tamañoBuscar =
                new java.awt.Dimension(
                        42,
                        38
                );

        btnBuscarProcedimiento.setPreferredSize(
                tamañoBuscar
        );

        btnBuscarProcedimiento.setMinimumSize(
                tamañoBuscar
        );

        btnBuscarProcedimiento.setMaximumSize(
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
                btnBuscarProcedimiento
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

        tarjetaProcedimientos.add(
                panelAccionesSuperiores,
                java.awt.BorderLayout.NORTH
        );

        btnAgregarProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        240,
                        38
                )
        );

        btnEditarProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        225,
                        38
                )
        );

        btnMostrarTodos.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
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

        filaPrincipal.add(
                btnAgregarProcedimiento
        );

        filaPrincipal.add(
                btnEditarProcedimiento
        );

        filaPrincipal.add(
                btnMostrarTodos
        );
        javax.swing.JButton btnTiposProcedimiento =
                new javax.swing.JButton(
                        "Tipos de procedimiento"
                );

        Estilos.estilizarBoton(
                btnTiposProcedimiento
        );

        btnTiposProcedimiento.setPreferredSize(
                new java.awt.Dimension(
                        250,
                        38
                )
        );

        btnTiposProcedimiento.addActionListener(e -> {

            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarTiposProcedimiento();
            }
        });
        javax.swing.JPanel filaBaja =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        filaBaja.setOpaque(false);

        filaBaja.add(
                btnDarDeBajaRegistro
        );
        filaBaja.add(
                btnTiposProcedimiento
        );
        panelBotones.add(
                filaPrincipal
        );

        panelBotones.add(
                javax.swing.Box.createVerticalStrut(
                        10
                )
        );

        panelBotones.add(
                filaBaja
        );

        tarjetaProcedimientos.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaProcedimientos,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaProcedimientosMedicos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProcedimiento;
    private javax.swing.JButton btnBuscarProcedimiento;
    private javax.swing.JButton btnDarDeBajaRegistro;
    private javax.swing.JButton btnEditarProcedimiento;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane scrollProcedimientos;
    private javax.swing.JTable tblProcedimientos;
    // End of variables declaration//GEN-END:variables
}
