package sistemaveterinaria;

import controller.ClienteController;
import controller.AnimalController;
public class VentanaClientes extends javax.swing.JFrame {
    private String rolUsuario;
    private VentanaPrincipal ventanaPrincipal;
    private javax.swing.JPanel panelAnimalesCliente;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaClientes.class.getName());

    public VentanaClientes() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        configurarDiseñoClientes();
        cargarTabla();
    }
    
    public VentanaClientes(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        configurarDiseñoClientes();
        cargarTabla();
    }
    
    public VentanaClientes(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();

        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarTabla();
        configurarDiseñoClientes();
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
        modelo.addColumn("DNI");

        for (Object[] fila : ClienteController.listarClientes()) {
            modelo.addRow(fila);
        }

        tblClientes.setModel(modelo);
    }
    
    private void buscarClientes(String filtro) {

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
        modelo.addColumn("DNI");

        for (Object[] fila : ClienteController.buscarClientes(filtro)) {
            modelo.addRow(fila);
        }

        tblClientes.setModel(modelo);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        scrollClientes = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnCrearCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Gestión de clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollClientes.setViewportView(tblClientes);

        btnCrearCliente.setText("Crear cliente");
        btnCrearCliente.addActionListener(this::btnCrearClienteActionPerformed);

        btnEditarCliente.setText("Editar cliente");
        btnEditarCliente.addActionListener(this::btnEditarClienteActionPerformed);

        btnEliminarCliente.setText("Eliminar cliente");
        btnEliminarCliente.addActionListener(this::btnEliminarClienteActionPerformed);

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(this::btnBuscarClienteActionPerformed);

        btnMostrarTodos.setText("Mostrar todos");
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(scrollClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnMostrarTodos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnCrearCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarCliente)
                        .addGap(33, 33, 33)
                        .addComponent(btnEliminarCliente)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnVolver)
                                .addGap(0, 110, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblTitulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(scrollClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCrearCliente)
                                    .addComponent(btnEditarCliente)
                                    .addComponent(btnEliminarCliente)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnBuscarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVolver)))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostrarTodos)
                        .addGap(64, 64, 64))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        cargarTabla();        
    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
            java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Buscar cliente",
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
                        "BUSCAR CLIENTE",
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
                        "Buscar por nombre o DNI:"
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

                buscarClientes(texto);

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
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        int fila = tblClientes.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un cliente"
            );

            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Eliminar cliente?",
                "Confirmar",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (opcion != javax.swing.JOptionPane.YES_OPTION) return;

        try {
            int id = Integer.parseInt(tblClientes.getValueAt(fila, 0).toString());

            ClienteController.eliminarCliente(id);

            javax.swing.JOptionPane.showMessageDialog(this, "Eliminado");

            cargarTabla();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e);
        }        
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        int fila = tblClientes.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un cliente"
            );

            return;
        }

        int id = Integer.parseInt(
                tblClientes.getValueAt(fila, 0).toString()
        );

        String nombre =
                tblClientes.getValueAt(fila, 1).toString();

        String dni =
                tblClientes.getValueAt(fila, 2).toString();

        ventanaPrincipal.mostrarEditarCliente(
                id,
                nombre,
                dni
        );
    
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearClienteActionPerformed
            ventanaPrincipal.mostrarCrearCliente();
    }//GEN-LAST:event_btnCrearClienteActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp =
            new VentanaPrincipal(rolUsuario);

        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    private void mostrarAnimalesDelCliente() {

        int filaVista =
                tblClientes.getSelectedRow();

        if (filaVista == -1
                || panelAnimalesCliente == null) {
            return;
        }

        int filaModelo =
                tblClientes.convertRowIndexToModel(
                        filaVista
                );

        int idCliente =
                Integer.parseInt(
                        tblClientes.getModel()
                                .getValueAt(
                                        filaModelo,
                                        0
                                ).toString()
                );

        String nombreCliente =
                tblClientes.getModel()
                        .getValueAt(
                                filaModelo,
                                1
                        ).toString();

        panelAnimalesCliente.removeAll();

        javax.swing.JLabel lblAnimales =
                new javax.swing.JLabel(
                        "Animales de "
                        + nombreCliente
                        + ":"
                );

        lblAnimales.setFont(
                Estilos.fuenteNormal()
        );

        lblAnimales.setForeground(
                Estilos.VERDE_OSCURO
        );

        panelAnimalesCliente.add(
                lblAnimales
        );

        java.util.ArrayList<Object[]> animales =
                AnimalController.listarAnimalesPorCliente(
                        idCliente
                );

        if (animales.isEmpty()) {

            javax.swing.JLabel lblSinAnimales =
                    new javax.swing.JLabel(
                            "No tiene animales registrados"
                    );

            lblSinAnimales.setFont(
                    Estilos.fuenteNormal()
            );

            lblSinAnimales.setForeground(
                    new java.awt.Color(
                            100,
                            100,
                            100
                    )
            );

            panelAnimalesCliente.add(
                    lblSinAnimales
            );

        } else {

            for (Object[] animal : animales) {

                int idAnimal =
                        Integer.parseInt(
                                animal[0].toString()
                        );

                String nombreAnimal =
                        animal[1].toString();

                javax.swing.JButton btnAnimal =
                        new javax.swing.JButton(
                                nombreAnimal
                        );

                Estilos.estilizarBoton(
                        btnAnimal
                );

                btnAnimal.setPreferredSize(
                        new java.awt.Dimension(
                                135,
                                34
                        )
                );

                btnAnimal.addActionListener(e -> {

                    if (ventanaPrincipal != null) {

                        ventanaPrincipal
                                .mostrarAnimalSeleccionado(
                                        idAnimal
                                );
                    }
                });

                panelAnimalesCliente.add(
                        btnAnimal
                );
            }
        }

        panelAnimalesCliente.setVisible(true);
        panelAnimalesCliente.revalidate();
        panelAnimalesCliente.repaint();
    }
    private void configurarDiseñoClientes() {

        setTitle(
                "Henry System Vet - Gestión de clientes"
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

        lblTitulo.setText(
                "Gestión de clientes"
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

        panelTitulo.add(lblTitulo);
        
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

        lblTitulo.setAlignmentX(
                java.awt.Component.LEFT_ALIGNMENT
        );


        panelEncabezado.add(
                contenedorTitulo
        );


        panelEncabezado.add(
                javax.swing.Box.createVerticalStrut(25)
        );


        javax.swing.JPanel tarjetaClientes =
                new javax.swing.JPanel();

        tarjetaClientes.setBackground(
                Estilos.BLANCO
        );

        tarjetaClientes.setLayout(
                new java.awt.BorderLayout(
                        0,
                        20
                )
        );

        tarjetaClientes.setBorder(
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
                tblClientes
        );
        
        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblClientes.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblClientes.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        scrollClientes.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        tarjetaClientes.add(
                scrollClientes,
                java.awt.BorderLayout.CENTER
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


        Estilos.estilizarBoton(
                btnCrearCliente
        );

        Estilos.estilizarBoton(
                btnEditarCliente
        );

        Estilos.estilizarBoton(
                btnEliminarCliente
        );

        Estilos.estilizarBoton(
                btnBuscarCliente
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );

        Estilos.estilizarBoton(
                btnVolver
        );


        java.awt.Dimension tamañoBoton =
                new java.awt.Dimension(
                        165,
                        38
                );

        btnCrearCliente.setPreferredSize(
                tamañoBoton
        );

        btnEditarCliente.setPreferredSize(
                tamañoBoton
        );

        btnEliminarCliente.setPreferredSize(
                tamañoBoton
        );

        btnBuscarCliente.setPreferredSize(
                tamañoBoton
        );

        btnMostrarTodos.setPreferredSize(
                tamañoBoton
        );


        panelBotones.add(
                btnCrearCliente
        );

        panelBotones.add(
                btnEditarCliente
        );

        panelBotones.add(
                btnEliminarCliente
        );

        panelBotones.add(
                btnBuscarCliente
        );

        panelBotones.add(
                btnMostrarTodos
        );


        tarjetaClientes.add(
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
                tarjetaClientes,
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
    public javax.swing.JPanel obtenerPanelClientes() {

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

        lblTitulo.setText(
                "Gestión de clientes"
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

        javax.swing.JPanel tarjetaClientes =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaClientes.setBackground(
                Estilos.BLANCO
        );

        tarjetaClientes.setBorder(
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
                tblClientes
        );

        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblClientes.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centrado);

        tblClientes.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        scrollClientes.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        tarjetaClientes.add(
                scrollClientes,
                java.awt.BorderLayout.CENTER
        );
        panelAnimalesCliente =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                8
                        )
                );

        panelAnimalesCliente.setBackground(
                new java.awt.Color(
                        245,
                        245,
                        245
                )
        );

        panelAnimalesCliente.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createMatteBorder(
                                1,
                                0,
                                0,
                                0,
                                Estilos.VERDE_OSCURO
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                5,
                                5,
                                5,
                                5
                        )
                )
        );

        panelAnimalesCliente.setVisible(false);

        tblClientes.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        tblClientes.getSelectionModel()
                .addListSelectionListener(e -> {

                    if (!e.getValueIsAdjusting()) {
                        mostrarAnimalesDelCliente();
                    }
                });
        javax.swing.JPanel panelBotones =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        panelBotones.setOpaque(false);

        Estilos.estilizarBoton(
                btnCrearCliente
        );

        Estilos.estilizarBoton(
                btnEditarCliente
        );

        Estilos.estilizarBotonEliminar(
                btnEliminarCliente
        );

        Estilos.estilizarBoton(
                btnBuscarCliente
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );

        java.awt.Dimension tamañoBoton =
                new java.awt.Dimension(
                        165,
                        38
                );

        btnCrearCliente.setPreferredSize(
                tamañoBoton
        );

        btnEditarCliente.setPreferredSize(
                tamañoBoton
        );

        btnEliminarCliente.setPreferredSize(
                tamañoBoton
        );

        btnBuscarCliente.setPreferredSize(
                tamañoBoton
        );

        btnMostrarTodos.setPreferredSize(
                tamañoBoton
        );

        panelBotones.add(
                btnCrearCliente
        );

        panelBotones.add(
                btnEditarCliente
        );

        panelBotones.add(
                btnEliminarCliente
        );

        panelBotones.add(
                btnBuscarCliente
        );

        panelBotones.add(
                btnMostrarTodos
        );

        javax.swing.JPanel zonaInferior =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                12
                        )
                );

        zonaInferior.setOpaque(false);

        zonaInferior.add(
                panelAnimalesCliente,
                java.awt.BorderLayout.CENTER
        );

        zonaInferior.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        tarjetaClientes.add(
                zonaInferior,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaClientes,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(() -> new VentanaClientes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCrearCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
