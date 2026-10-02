package sistemaveterinaria;

import controller.TipoProcedimientoController;

public class PanelTiposProcedimiento
        extends javax.swing.JPanel {

    private final VentanaPrincipal ventanaPrincipal;

    private final javax.swing.JTextField txtNuevoTipo =
            new javax.swing.JTextField();

    private final javax.swing.DefaultListModel<String> modeloTipos =
            new javax.swing.DefaultListModel<>();

    private final javax.swing.JList<String> listaTipos =
            new javax.swing.JList<>(modeloTipos);
    private final javax.swing.table.DefaultTableModel modeloTablaTipos =
            new javax.swing.table.DefaultTableModel(
                    new Object[]{
                        "Tipo de procedimiento",
                        "Acciones"
                    },
                    0
            ) {

                @Override
                public boolean isCellEditable(
                        int fila,
                        int columna
                ) {

                    return columna == 1;
                }
            };

    private final javax.swing.JTable tablaTipos =
            new javax.swing.JTable(
                    modeloTablaTipos
            );
    public PanelTiposProcedimiento(
            VentanaPrincipal ventanaPrincipal
    ) {

        this.ventanaPrincipal =
                ventanaPrincipal;

        TipoProcedimientoController.inicializarCatalogo();

        construirPanel();
        configurarTablaTipos();
        cargarTipos();
        cargarTablaTipos();
        
    }

    private void construirPanel() {

        setLayout(
                new java.awt.BorderLayout()
        );

        setBackground(
                Estilos.VERDE_PRINCIPAL
        );

        javax.swing.JPanel panelPrincipal =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                25
                        )
                );

        panelPrincipal.setOpaque(false);

        panelPrincipal.setBorder(
                javax.swing.BorderFactory.createEmptyBorder(
                        45,
                        20,
                        40,
                        60
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "Gestión de tipos de procedimiento"
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

        panelPrincipal.add(
                contenedorTitulo,
                java.awt.BorderLayout.NORTH
        );

        javax.swing.JPanel tarjeta =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                20
                        )
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
                                25,
                                30,
                                35
                        )
                )
        );

        javax.swing.JLabel lblNuevoTipo =
                new javax.swing.JLabel(
                        "Nuevo tipo"
                );

        lblNuevoTipo.setFont(
                Estilos.fuenteNormal()
        );

        lblNuevoTipo.setForeground(
                Estilos.VERDE_OSCURO
        );

        txtNuevoTipo.setFont(
                Estilos.fuenteNormal()
        );

        txtNuevoTipo.setPreferredSize(
                new java.awt.Dimension(
                        320,
                        38
                )
        );

        javax.swing.JButton btnAgregar =
                new javax.swing.JButton(
                        "Agregar tipo"
                );

        Estilos.estilizarBoton(
                btnAgregar
        );

        btnAgregar.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );

        javax.swing.JPanel panelFormulario =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.LEFT,
                                12,
                                0
                        )
                );

        panelFormulario.setOpaque(false);

        panelFormulario.add(
                lblNuevoTipo
        );

        panelFormulario.add(
                txtNuevoTipo
        );

        panelFormulario.add(
                btnAgregar
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

        btnInicio.addActionListener(
                evento -> ventanaPrincipal.mostrarInicio()
        );

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

        javax.swing.JPanel panelSuperiorTarjeta =
                new javax.swing.JPanel();

        panelSuperiorTarjeta.setOpaque(false);

        panelSuperiorTarjeta.setLayout(
                new javax.swing.BoxLayout(
                        panelSuperiorTarjeta,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        panelInicio.setAlignmentX(
                java.awt.Component.LEFT_ALIGNMENT
        );

        panelFormulario.setAlignmentX(
                java.awt.Component.LEFT_ALIGNMENT
        );

        panelSuperiorTarjeta.add(
                panelInicio
        );

        panelSuperiorTarjeta.add(
                javax.swing.Box.createVerticalStrut(15)
        );

        panelSuperiorTarjeta.add(
                panelFormulario
        );

        tarjeta.add(
                panelSuperiorTarjeta,
                java.awt.BorderLayout.NORTH
        );

        javax.swing.JPanel panelListado =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                10
                        )
                );

        panelListado.setOpaque(false);

        javax.swing.JLabel lblTiposRegistrados =
                new javax.swing.JLabel(
                        "Tipos de procedimiento registrados"
                );

        lblTiposRegistrados.setFont(
                Estilos.fuenteSubtitulo()
        );

        lblTiposRegistrados.setForeground(
                Estilos.VERDE_OSCURO
        );

       javax.swing.JScrollPane scrollTipos =
                new javax.swing.JScrollPane(
                        tablaTipos
                );

        scrollTipos.setBackground(
                Estilos.BLANCO
        );

        scrollTipos.getViewport().setBackground(
                new java.awt.Color(
                        235,
                        250,
                        244
                )
        );

        scrollTipos.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        1,
                        true
                )
        );

        panelListado.add(
                lblTiposRegistrados,
                java.awt.BorderLayout.NORTH
        );

        panelListado.add(
                scrollTipos,
                java.awt.BorderLayout.CENTER
        );

        tarjeta.add(
                panelListado,
                java.awt.BorderLayout.CENTER
        );
        
        

        panelPrincipal.add(
                tarjeta,
                java.awt.BorderLayout.CENTER
        );

        add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        btnAgregar.addActionListener(
                evento -> agregarTipo()
        );

        
        
        listaTipos.addListSelectionListener(
                evento -> {

                    if (!evento.getValueIsAdjusting()) {

                        String tipoSeleccionado =
                                listaTipos.getSelectedValue();

                        if (tipoSeleccionado != null) {

                            txtNuevoTipo.setText(
                                    tipoSeleccionado
                            );
                        }
                    }
                }
        );
    }
    
    private void configurarTablaTipos() {

        Estilos.estilizarTabla(
                tablaTipos
        );

        tablaTipos.setRowHeight(
                38
        );

        tablaTipos.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        tablaTipos.getTableHeader().setReorderingAllowed(
                false
        );

        tablaTipos.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(700);

        tablaTipos.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(120);

        tablaTipos.getColumnModel()
                .getColumn(1)
                .setMaxWidth(120);
        tablaTipos.getColumnModel()
                .getColumn(1)
                .setCellRenderer(
                        new RenderizadorAcciones()
                );

        tablaTipos.getColumnModel()
                .getColumn(1)
                .setCellEditor(
                        new EditorAcciones()
                );
        tablaTipos.addMouseMotionListener(
                new java.awt.event.MouseMotionAdapter() {

                    @Override
                    public void mouseMoved(
                            java.awt.event.MouseEvent evento
                    ) {

                        int columna =
                                tablaTipos.columnAtPoint(
                                        evento.getPoint()
                                );

                        tablaTipos.setCursor(
                                new java.awt.Cursor(
                                        columna == 1
                                                ? java.awt.Cursor.HAND_CURSOR
                                                : java.awt.Cursor.DEFAULT_CURSOR
                                )
                        );
                    }
                }
        );

        tablaTipos.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evento
                    ) {

                        tablaTipos.setCursor(
                                new java.awt.Cursor(
                                        java.awt.Cursor.DEFAULT_CURSOR
                                )
                        );
                    }
                }
        );
    }
    
    

    private void cargarTablaTipos() {

        modeloTablaTipos.setRowCount(
                0
        );

        for (String tipo
                : TipoProcedimientoController.listarTipos()) {

            modeloTablaTipos.addRow(
                    new Object[]{
                        tipo,
                        ""
                    }
            );
        }
    }
    private void editarTipoTabla(
            String nombreActual
    ) {

        String nombreNuevo =
                Estilos.solicitarTexto(
                        this,
                        "Editar tipo",
                        "Nuevo nombre del tipo:",
                        nombreActual
                );

        if (nombreNuevo == null) {
            return;
        }

        nombreNuevo =
                nombreNuevo.trim()
                        .replaceAll(
                                "\\s+",
                                " "
                        );

        if (nombreNuevo.isEmpty()) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá el nuevo nombre del tipo"
            );

            return;
        }

        if (nombreActual.equalsIgnoreCase(
                nombreNuevo
        )) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Modificá el nombre antes de guardar"
            );

            return;
        }

        boolean editado =
                TipoProcedimientoController.editarTipo(
                        nombreActual,
                        nombreNuevo
                );

        if (!editado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "No se pudo editar. Es posible que el nuevo nombre ya exista"
            );

            return;
        }

        cargarTipos();
        cargarTablaTipos();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Tipo de procedimiento editado correctamente"
        );
    }

    private void eliminarTipoTabla(
            String tipoSeleccionado
    ) {

        boolean confirmado =
                Estilos.mostrarConfirmacion(
                        this,
                        "Confirmar eliminación",
                        "¿Deseás eliminar el tipo "
                        + tipoSeleccionado
                        + "?"
                );

        if (!confirmado) {
            return;
        }

        boolean eliminado =
                TipoProcedimientoController.eliminarTipo(
                        tipoSeleccionado
                );

        if (!eliminado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar el tipo de procedimiento"
            );

            return;
        }

        cargarTipos();
        cargarTablaTipos();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Tipo de procedimiento eliminado correctamente"
        );
    }
    private void cargarTipos() {

        modeloTipos.clear();

        for (String tipo
                : TipoProcedimientoController.listarTipos()) {

            modeloTipos.addElement(
                    tipo
            );
        }
    }

    private void agregarTipo() {

        String nombre =
                txtNuevoTipo.getText()
                        .trim()
                        .replaceAll(
                                "\\s+",
                                " "
                        );

        if (nombre.isEmpty()) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá un tipo de procedimiento"
            );

            return;
        }

        boolean guardado =
                TipoProcedimientoController
                        .agregarTipo(nombre);

        if (!guardado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "El tipo de procedimiento ya existe"
            );

            return;
        }

        txtNuevoTipo.setText("");

        cargarTipos();
        cargarTablaTipos();
        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Tipo de procedimiento agregado correctamente"
        );
    }

    private void eliminarTipo() {

        String tipoSeleccionado =
                listaTipos.getSelectedValue();

        if (tipoSeleccionado == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un tipo de procedimiento"
            );

            return;
        }

        int respuesta =
                javax.swing.JOptionPane.showConfirmDialog(
                        this,
                        "¿Deseás eliminar el tipo \""
                        + tipoSeleccionado
                        + "\"?",
                        "Confirmar eliminación",
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );

        if (respuesta
                != javax.swing.JOptionPane.YES_OPTION) {

            return;
        }

        boolean eliminado =
                TipoProcedimientoController
                        .eliminarTipo(tipoSeleccionado);

        if (!eliminado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar el tipo de procedimiento"
            );

            return;
        }

        cargarTipos();
        cargarTablaTipos();
        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Tipo de procedimiento eliminado correctamente"
        );
    }
    private void editarTipo() {

        String nombreActual =
                listaTipos.getSelectedValue();

        if (nombreActual == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná un tipo de procedimiento"
            );

            return;
        }

        String nombreNuevo =
                txtNuevoTipo.getText()
                        .trim()
                        .replaceAll(
                                "\\s+",
                                " "
                        );

        if (nombreNuevo.isEmpty()) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá el nuevo nombre del tipo"
            );

            return;
        }

        if (nombreActual.equalsIgnoreCase(
                nombreNuevo
        )) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Modificá el nombre antes de guardar"
            );

            return;
        }

        int respuesta =
                javax.swing.JOptionPane.showConfirmDialog(
                        this,
                        "¿Deseás cambiar \""
                        + nombreActual
                        + "\" por \""
                        + nombreNuevo
                        + "\"?",
                        "Confirmar edición",
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.QUESTION_MESSAGE
                );

        if (respuesta
                != javax.swing.JOptionPane.YES_OPTION) {

            return;
        }

        boolean editado =
                TipoProcedimientoController.editarTipo(
                        nombreActual,
                        nombreNuevo
                );

        if (!editado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "No se pudo editar. Es posible que el nuevo nombre ya exista"
            );

            return;
        }

        txtNuevoTipo.setText("");

        listaTipos.clearSelection();

        cargarTipos();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Tipo de procedimiento editado correctamente"
        );
    }
    private class RenderizadorAcciones
            extends javax.swing.JPanel
            implements javax.swing.table.TableCellRenderer {

        private final javax.swing.JButton btnEditar =
                new javax.swing.JButton();

        private final javax.swing.JButton btnEliminar =
                new javax.swing.JButton();

        public RenderizadorAcciones() {

            setLayout(
                    new java.awt.FlowLayout(
                            java.awt.FlowLayout.CENTER,
                            5,
                            4
                    )
            );

            setOpaque(true);

            configurarBotonAccion(
                    btnEditar,
                    new java.awt.Color(
                            70,
                            145,
                            215
                    ),
                    "/imagenes/iconos/editar.png"
            );

            configurarBotonAccion(
                    btnEliminar,
                    new java.awt.Color(
                            210,
                            70,
                            70
                    ),
                    "/imagenes/iconos/eliminar.png"
            );

            add(btnEditar);
            add(btnEliminar);
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
                                5,
                                4
                        )
                );

        private final javax.swing.JButton btnEditar =
                new javax.swing.JButton();

        private final javax.swing.JButton btnEliminar =
                new javax.swing.JButton();

        private String tipoSeleccionado;

        public EditorAcciones() {

            panel.setOpaque(true);

            configurarBotonAccion(
                    btnEditar,
                    new java.awt.Color(
                            70,
                            145,
                            215
                    ),
                    "/imagenes/iconos/editar.png"
            );

            configurarBotonAccion(
                    btnEliminar,
                    new java.awt.Color(
                            210,
                            70,
                            70
                    ),
                    "/imagenes/iconos/eliminar.png"
            );

            panel.add(btnEditar);
            panel.add(btnEliminar);

            btnEditar.addActionListener(
                    evento -> {

                        fireEditingStopped();

                        editarTipoTabla(
                                tipoSeleccionado
                        );
                    }
            );

            btnEliminar.addActionListener(
                    evento -> {

                        fireEditingStopped();

                        eliminarTipoTabla(
                                tipoSeleccionado
                        );
                    }
            );
        }

        @Override
        public java.awt.Component getTableCellEditorComponent(
                javax.swing.JTable tabla,
                Object valor,
                boolean seleccionado,
                int fila,
                int columna
        ) {

            tipoSeleccionado =
                    tabla.getValueAt(
                            fila,
                            0
                    ).toString();

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

    private void configurarBotonAccion(
            javax.swing.JButton boton,
            java.awt.Color color,
            String rutaIcono
    ) {

        java.awt.Dimension tamañoBoton =
                new java.awt.Dimension(
                        28,
                        26
                );

        boton.setPreferredSize(
                tamañoBoton
        );

        boton.setMinimumSize(
                tamañoBoton
        );

        boton.setMaximumSize(
                tamañoBoton
        );

        boton.setBackground(
                color
        );

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);

        boton.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        Estilos.aplicarIcono(
                boton,
                rutaIcono,
                14,
                14
        );
    }
}