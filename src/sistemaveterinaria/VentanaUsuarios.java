package sistemaveterinaria;
import controller.UsuarioController;
public class VentanaUsuarios extends javax.swing.JFrame {
    private String rolUsuario;
    private VentanaPrincipal ventanaPrincipal;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JTextField campoBusquedaUsuarios;
    private javax.swing.JButton btnVerInactivos;
    private boolean mostrandoInactivos = false;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName());

   
    public VentanaUsuarios() {
        initComponents();
        inicializarBotonesUsuarios();
        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoUsuarios();
    }

    public VentanaUsuarios(String rolUsuario) {
        initComponents();
        inicializarBotonesUsuarios();
        this.rolUsuario = rolUsuario;

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        cargarTabla();

        configurarDiseñoUsuarios();
    }
    public VentanaUsuarios(
            String rolUsuario,
            VentanaPrincipal ventanaPrincipal
    ) {

        initComponents();
        inicializarBotonesUsuarios();
        this.rolUsuario = rolUsuario;
        this.ventanaPrincipal = ventanaPrincipal;

        cargarTabla();
    }
    private void cargarTabla() {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {
                return column == 4;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Correo");
        modelo.addColumn("Rol");
        modelo.addColumn("Acciones");

        java.util.ArrayList<Object[]> usuarios =
                mostrandoInactivos
                        ? UsuarioController.listarUsuariosInactivos()
                        : UsuarioController.listarUsuarios();

        for (Object[] fila : usuarios) {

            modelo.addRow(
                    new Object[]{
                        fila[0],
                        fila[1],
                        fila[4],
                        fila[3],
                        ""
                    }
            );
        }

        tblUsuarios.setModel(modelo);

        configurarColumnasUsuarios();
    }
    
    private void buscarUsuarios(
            String filtro
    ) {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {
                return column == 4;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Correo");
        modelo.addColumn("Rol");
        modelo.addColumn("Acciones");

        for (Object[] fila
                : UsuarioController.buscarUsuarios(filtro)) {

            modelo.addRow(new Object[]{
                fila[0],
                fila[1],
                fila[4],
                fila[3],
                ""
            });
        }

        tblUsuarios.setModel(modelo);

        configurarColumnasUsuarios();
    }
    private void configurarColumnasUsuarios() {

        if (tblUsuarios.getColumnCount() < 5) {
            return;
        }

        javax.swing.table.TableColumn columnaId =
                tblUsuarios.getColumnModel()
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

        tblUsuarios.getColumnModel()
                .getColumn(2)
                .setCellRenderer(centrado);

        tblUsuarios.getColumnModel()
                .getColumn(3)
                .setCellRenderer(centrado);

        javax.swing.table.TableColumn columnaAcciones =
                tblUsuarios.getColumnModel()
                        .getColumn(4);

        columnaAcciones.setMinWidth(75);
        columnaAcciones.setMaxWidth(75);
        columnaAcciones.setPreferredWidth(75);
        columnaAcciones.setResizable(false);

        columnaAcciones.setCellRenderer(
                new RenderizadorAcciones()
        );

        columnaAcciones.setCellEditor(
                new EditorAcciones()
        );

        tblUsuarios.setRowHeight(32);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnEditarUsuario = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsuarios);

        btnEditarUsuario.setText("Editar usuario");
        btnEditarUsuario.addActionListener(this::btnEditarUsuarioActionPerformed);

        btnCrearUsuario.setText("Crear usuario");
        btnCrearUsuario.addActionListener(this::btnCrearUsuarioActionPerformed);

        btnEliminarUsuario.setText("Eliminar usuario");
        btnEliminarUsuario.addActionListener(this::btnEliminarUsuarioActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnEditarUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnCrearUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnEliminarUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnEliminarUsuario)
                        .addGap(53, 53, 53)
                        .addComponent(btnCrearUsuario)
                        .addGap(33, 33, 33)
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VentanaPrincipal vp = new VentanaPrincipal(rolUsuario);
        vp.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        int fila = tblUsuarios.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un usuario"
            );

            return;
        }

        int idUsuario = Integer.parseInt(
                tblUsuarios.getValueAt(
                        fila,
                        0
                ).toString()
        );

        String usuario =
                tblUsuarios.getValueAt(
                        fila,
                        1
                ).toString();

        Object valorCorreo =
                tblUsuarios.getValueAt(
                        fila,
                        2
                );

        String correo =
                valorCorreo == null
                        ? ""
                        : valorCorreo.toString();

        String rol =
                tblUsuarios.getValueAt(
                        fila,
                        3
                ).toString();

        ventanaPrincipal.mostrarEditarUsuario(
                idUsuario,
                usuario,
                correo,
                rol
        );
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
            ventanaPrincipal.mostrarCrearUsuario();
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        int fila = tblUsuarios.getSelectedRow();

        if (fila == -1) {
            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un usuario"
            );
            return;
        }

        int idUsuario = Integer.parseInt(
                tblUsuarios.getValueAt(fila, 0).toString()
        );

        String nombreUsuario =
                tblUsuarios.getValueAt(fila, 1).toString();
        if (SesionUsuario.haySesionActiva()
                && nombreUsuario.equalsIgnoreCase(
                        SesionUsuario.getNombreUsuario()
                )) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "No podés dar de baja al usuario "
                    + "con el que tenés la sesión iniciada"
            );

            return;
        }
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
                        "¿Seguro que querés dar de baja al usuario "
                        + nombreUsuario + "?",
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
                UsuarioController.eliminarUsuario(idUsuario);

                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Operación exitosa",
                        "Usuario dado de baja correctamente"
                );

                cargarTabla();

            } catch (Exception ex) {
                dialogo.dispose();

                Estilos.mostrarAdvertencia(
                        this,
                        "Error",
                        "No se pudo dar de baja al usuario"
                );
            }
        });

        dialogo.setContentPane(panelPrincipal);
        dialogo.setSize(440, 180);
        dialogo.setLocationRelativeTo(ventanaPadre);
        dialogo.setVisible(true);
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed
    private final javax.swing.JButton btnReactivar =
        crearBotonReactivar();
    private void configurarDiseñoUsuarios() {

        setTitle(
                "Henry System Vet - Gestión de usuarios"
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
                        "GESTIÓN DE USUARIOS"
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

        javax.swing.JPanel tarjetaUsuarios =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaUsuarios.setBackground(
                Estilos.BLANCO
        );

        tarjetaUsuarios.setBorder(
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
                tblUsuarios
        );

        jScrollPane1.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );

        jScrollPane1.setPreferredSize(
                new java.awt.Dimension(
                        0,
                        400
                )
        );
       
        tarjetaUsuarios.add(
                jScrollPane1,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(
                btnCrearUsuario
        );

        Estilos.estilizarBoton(
                btnEditarUsuario
        );

        Estilos.estilizarBotonEliminar(
                btnEliminarUsuario
        );

        Estilos.estilizarBoton(
                btnVolver
        );

        btnCrearUsuario.setPreferredSize(
                new java.awt.Dimension(
                        170,
                        38
                )
        );

        btnEditarUsuario.setPreferredSize(
                new java.awt.Dimension(
                        170,
                        38
                )
        );

        btnEliminarUsuario.setPreferredSize(
                new java.awt.Dimension(
                        180,
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
                btnCrearUsuario
        );

        panelBotones.add(
                btnEditarUsuario
        );

        panelBotones.add(
                btnEliminarUsuario
        );

        tarjetaUsuarios.add(
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
                tarjetaUsuarios,
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
    public javax.swing.JPanel obtenerPanelUsuarios() {

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
                        "GESTIÓN DE USUARIOS"
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

        javax.swing.JPanel tarjetaUsuarios =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
                );

        tarjetaUsuarios.setBackground(
                Estilos.BLANCO
        );

        tarjetaUsuarios.setBorder(
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
                tblUsuarios
        );
        
        tblUsuarios.addMouseMotionListener(
                new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseMoved(
                    java.awt.event.MouseEvent e
            ) {

                int fila =
                        tblUsuarios.rowAtPoint(
                                e.getPoint()
                        );

                int columnaVista =
                        tblUsuarios.columnAtPoint(
                                e.getPoint()
                        );

                boolean sobreAcciones =
                        fila >= 0
                        && columnaVista >= 0
                        && tblUsuarios.convertColumnIndexToModel(
                                columnaVista
                        ) == 4;

                tblUsuarios.setCursor(
                        sobreAcciones
                                ? java.awt.Cursor.getPredefinedCursor(
                                        java.awt.Cursor.HAND_CURSOR
                                )
                                : java.awt.Cursor.getDefaultCursor()
                );

                tblUsuarios.repaint();
            }
        });

        tblUsuarios.addMouseListener(
                new java.awt.event.MouseAdapter() {

            @Override
            public void mouseExited(
                    java.awt.event.MouseEvent e
            ) {

                tblUsuarios.setCursor(
                        java.awt.Cursor.getDefaultCursor()
                );

                tblUsuarios.repaint();
            }
        });

        jScrollPane1.setBorder(
                javax.swing.BorderFactory.createEmptyBorder()
        );
       
        tarjetaUsuarios.add(
                jScrollPane1,
                java.awt.BorderLayout.CENTER
        );

        Estilos.estilizarBoton(btnCrearUsuario);
        Estilos.estilizarBotonEditar(btnEditarUsuario);
        Estilos.estilizarBotonEliminar(btnEliminarUsuario);
        btnEliminarUsuario.setText(
                "Dar de baja usuario"
        );
        Estilos.estilizarBoton(btnBuscarUsuario);
        Estilos.estilizarBoton(btnMostrarTodos);
        Estilos.estilizarBoton(btnVerInactivos);

        Estilos.aplicarIcono(
                btnCrearUsuario,
                "/imagenes/iconos/agregar.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnEditarUsuario,
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

        btnEliminarUsuario.setIcon(null);

        btnBuscarUsuario.setText("");
        btnBuscarUsuario.setToolTipText("Buscar usuario");

        Estilos.aplicarIcono(
                btnBuscarUsuario,
                "/imagenes/iconos/buscar.png",
                20,
                20
        );

        java.awt.Dimension tamañoBuscar =
                new java.awt.Dimension(42, 38);

        btnBuscarUsuario.setPreferredSize(tamañoBuscar);
        btnBuscarUsuario.setMinimumSize(tamañoBuscar);
        btnBuscarUsuario.setMaximumSize(tamañoBuscar);

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

            java.awt.Window ventana =
                    javax.swing.SwingUtilities.getWindowAncestor(
                            btnInicio
                    );

            if (ventana instanceof VentanaPrincipal) {

                VentanaPrincipal principal =
                        (VentanaPrincipal) ventana;

                principal.mostrarInicio();
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

        campoBusquedaUsuarios =
                new javax.swing.JTextField(
                        "Buscar por usuario, correo o rol"
                );

        campoBusquedaUsuarios.setFont(
                Estilos.fuenteNormal()
        );

        campoBusquedaUsuarios.setForeground(
                new java.awt.Color(140, 140, 140)
        );

        campoBusquedaUsuarios.setPreferredSize(
                new java.awt.Dimension(280, 38)
        );

        campoBusquedaUsuarios.setBorder(
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

        campoBusquedaUsuarios.setCaretPosition(0);

        campoBusquedaUsuarios.addFocusListener(
                new java.awt.event.FocusAdapter() {

            @Override
            public void focusGained(
                    java.awt.event.FocusEvent e
            ) {

                if (campoBusquedaUsuarios.getText()
                        .equals(
                                "Buscar por usuario, correo o rol"
                        )) {

                    campoBusquedaUsuarios.setText("");

                    campoBusquedaUsuarios.setForeground(
                            Estilos.VERDE_OSCURO
                    );
                }
            }

            @Override
            public void focusLost(
                    java.awt.event.FocusEvent e
            ) {

                if (campoBusquedaUsuarios.getText()
                        .trim()
                        .isEmpty()) {

                    campoBusquedaUsuarios.setText(
                            "Buscar por usuario, correo o rol"
                    );

                    campoBusquedaUsuarios.setForeground(
                            new java.awt.Color(140, 140, 140)
                    );

                    campoBusquedaUsuarios.setCaretPosition(0);
                }
            }
        });

        campoBusquedaUsuarios.addActionListener(e ->
                btnBuscarUsuario.doClick()
        );

        btnMostrarTodos.setText(
                "Actualizar tabla"
        );

        java.awt.Dimension tamañoActualizar =
                new java.awt.Dimension(220, 38);

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
        panelBusqueda.add(campoBusquedaUsuarios);
        panelBusqueda.add(btnBuscarUsuario);

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

        tarjetaUsuarios.add(
                panelAccionesSuperiores,
                java.awt.BorderLayout.NORTH
        );
        btnVerInactivos.setPreferredSize(
                new java.awt.Dimension(
                        210,
                        38
                )
        );
        btnCrearUsuario.setPreferredSize(
                new java.awt.Dimension(175, 38)
        );

        btnEditarUsuario.setPreferredSize(
                new java.awt.Dimension(175, 38)
        );

        btnEliminarUsuario.setPreferredSize(
                new java.awt.Dimension(180, 38)
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

        panelBotones.add(btnCrearUsuario);
        panelBotones.add(
                btnVerInactivos
        );

        tarjetaUsuarios.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                java.awt.BorderLayout.NORTH
        );

        panelPrincipal.add(
                tarjetaUsuarios,
                java.awt.BorderLayout.CENTER
        );

        panel.add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        return panel;
    }
    private void inicializarBotonesUsuarios() {

        btnBuscarUsuario =
                new javax.swing.JButton("Buscar");

        btnMostrarTodos =
                new javax.swing.JButton("Actualizar tabla");
        btnVerInactivos =
        new javax.swing.JButton(
                "Ver usuarios inactivos"
        );

        btnVerInactivos.addActionListener(e -> {

            mostrandoInactivos =
                    !mostrandoInactivos;

            btnVerInactivos.setText(
                    mostrandoInactivos
                            ? "Ver usuarios activos"
                            : "Ver usuarios inactivos"
            );

            cargarTabla();

            if (campoBusquedaUsuarios != null) {

                campoBusquedaUsuarios.setText(
                        "Buscar por usuario, correo o rol"
                );

                campoBusquedaUsuarios.setForeground(
                        new java.awt.Color(
                                140,
                                140,
                                140
                        )
                );

                campoBusquedaUsuarios.setCaretPosition(
                        0
                );
            }
        });
        btnBuscarUsuario.addActionListener(e ->
                buscarDesdeCampo()
        );

        btnMostrarTodos.addActionListener(e -> {

            cargarTabla();

            if (campoBusquedaUsuarios != null) {

                campoBusquedaUsuarios.setText(
                        "Buscar por usuario, correo o rol"
                );

                campoBusquedaUsuarios.setForeground(
                        new java.awt.Color(140, 140, 140)
                );

                campoBusquedaUsuarios.setCaretPosition(0);
            }
        });
    }
    private void buscarDesdeCampo() {

        if (campoBusquedaUsuarios == null) {
            return;
        }

        String texto =
                campoBusquedaUsuarios
                        .getText()
                        .trim();

        if (texto.isEmpty()
                || texto.equals(
                        "Buscar por usuario, correo o rol"
                )) {

            cargarTabla();
            return;
        }

        buscarUsuarios(texto);
    }

    private void mostrarDialogoBuscarUsuarios() {

        java.awt.Window ventanaPadre =
                javax.swing.SwingUtilities.getWindowAncestor(
                        this
                );

        javax.swing.JDialog dialogo =
                new javax.swing.JDialog(
                        ventanaPadre,
                        "Buscar usuario",
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
                        "BUSCAR USUARIO",
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
                        "Buscar por ID, usuario o rol:"
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

                buscarUsuarios(
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
                380,
                200
        );

        dialogo.setLocationRelativeTo(
                ventanaPadre
        );

        dialogo.setVisible(
                true
        );
    }
    private void reactivarUsuarioSeleccionado() {

        int fila =
                tblUsuarios.getSelectedRow();

        if (fila == -1) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un usuario"
            );

            return;
        }

        int idUsuario =
                Integer.parseInt(
                        tblUsuarios.getValueAt(
                                fila,
                                0
                        ).toString()
                );

        String nombreUsuario =
                tblUsuarios.getValueAt(
                        fila,
                        1
                ).toString();

        try {

            UsuarioController.reactivarUsuario(
                    idUsuario
            );

            Estilos.mostrarAdvertencia(
                    this,
                    "Operación exitosa",
                    "El usuario "
                    + nombreUsuario
                    + " fue reactivado correctamente"
            );

            cargarTabla();

        } catch (Exception e) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo reactivar el usuario"
            );
        }
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

            if (mostrandoInactivos) {

                add(
                        btnReactivar
                );

            } else {

                add(
                        btnEditar
                );

                add(
                        btnEliminar
                );
            }          
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
            if (mostrandoInactivos) {
                return this;
            }
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
        private final javax.swing.JButton btnReactivar =
                crearBotonReactivar();
        private int filaActual = -1;

        public EditorAcciones() {

            panel.setOpaque(true);

            if (mostrandoInactivos) {

                panel.add(
                        btnReactivar
                );

            } else {

                panel.add(
                        btnEditar
                );

                panel.add(
                        btnEliminar
                );
            }

            btnEditar.addActionListener(e -> {

                int fila = filaActual;

                fireEditingStopped();

                if (fila >= 0) {

                    tblUsuarios.setRowSelectionInterval(
                            fila,
                            fila
                    );

                    btnEditarUsuarioActionPerformed(null);
                }
            });

            btnEliminar.addActionListener(e -> {

                int fila = filaActual;

                fireEditingStopped();

                if (fila >= 0) {

                    tblUsuarios.setRowSelectionInterval(
                            fila,
                            fila
                    );

                    btnEliminarUsuarioActionPerformed(null);
                }
            });
            btnReactivar.addActionListener(e -> {

                int fila =
                        filaActual;

                fireEditingStopped();

                if (fila >= 0) {

                    tblUsuarios.setRowSelectionInterval(
                            fila,
                            fila
                    );

                    reactivarUsuarioSeleccionado();
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
    private javax.swing.JButton crearBotonReactivar() {

        javax.swing.JButton boton =
                new javax.swing.JButton();

        Estilos.estilizarBoton(
                boton
        );

        boton.setText("");

        Estilos.aplicarIcono(
                boton,
                "/imagenes/iconos/flecha_arriba.png",
                14,
                14
        );

        java.awt.Dimension tamaño =
                new java.awt.Dimension(
                        30,
                        22
                );

        boton.setPreferredSize(tamaño);
        boton.setMinimumSize(tamaño);
        boton.setMaximumSize(tamaño);

        boton.setToolTipText(
                "Reactivar usuario"
        );

        boton.setFocusable(false);

        boton.setCursor(
                java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return boton;
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

        boton.setToolTipText("Editar usuario");
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
                "/imagenes/iconos/flecha_abajo.png",
                14,
                14
        );

        java.awt.Dimension tamaño =
                new java.awt.Dimension(30, 22);

        boton.setPreferredSize(tamaño);
        boton.setMinimumSize(tamaño);
        boton.setMaximumSize(tamaño);

        boton.setToolTipText("Dar de baja usuario");
        boton.setFocusable(false);

        boton.setCursor(
                java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return boton;
}
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new VentanaUsuarios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
