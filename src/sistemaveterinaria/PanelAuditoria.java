package sistemaveterinaria;

import controller.AuditoriaController;

public class PanelAuditoria
        extends javax.swing.JPanel {

    private final VentanaPrincipal ventanaPrincipal;
    private static final String TEXTO_BUSQUEDA =
        "Buscar por usuario, rol, módulo, acción o detalle";
    private final javax.swing.table.DefaultTableModel modelo =
            new javax.swing.table.DefaultTableModel(
                    new Object[]{
                        "ID",
                        "Fecha y hora",
                        "Usuario",
                        "Rol",
                        "Módulo",
                        "Acción",
                        "Observaciones",
                        "Acciones"
                    },
                    0
            ) {

                @Override
                public boolean isCellEditable(
                        int fila,
                        int columna
                ) {

                    return columna == 6
                            || columna == 7;
                }
            };

    private final javax.swing.JTable tabla =
            new javax.swing.JTable(
                    modelo
            );
    private final javax.swing.JTextField txtBuscar =
            new javax.swing.JTextField();

    private final javax.swing.table.TableRowSorter<
            javax.swing.table.DefaultTableModel> ordenador =
            new javax.swing.table.TableRowSorter<>(
                    modelo
            );

    public PanelAuditoria(
            VentanaPrincipal ventanaPrincipal
    ) {

        this.ventanaPrincipal =
                ventanaPrincipal;

        construirPanel();
        configurarColumnaObservaciones();
        configurarColumnaAcciones();
        cargarRegistros();
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
                        25,
                        40,
                        25
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "Gestión de auditoría"
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
                                15
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
                                25,
                                25
                        )
                )
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
                evento ->
                        ventanaPrincipal.mostrarInicio()
        );

        javax.swing.JButton btnActualizar =
                new javax.swing.JButton(
                        "Actualizar tabla"
                );

        Estilos.estilizarBoton(
                btnActualizar
        );

        btnActualizar.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );

        btnActualizar.addActionListener(
                evento -> cargarRegistros()
        );

        txtBuscar.setFont(
                Estilos.fuenteNormal()
        );

        txtBuscar.setPreferredSize(
                new java.awt.Dimension(
                        330,
                        38
                )
        );
        txtBuscar.setText(
                TEXTO_BUSQUEDA
        );

        txtBuscar.setForeground(
                java.awt.Color.GRAY
        );

        txtBuscar.addFocusListener(
                new java.awt.event.FocusAdapter() {

                    @Override
                    public void focusGained(
                            java.awt.event.FocusEvent evento
                    ) {

                        if (txtBuscar.getText().equals(
                                TEXTO_BUSQUEDA
                        )) {

                            txtBuscar.setText(
                                    ""
                            );

                            txtBuscar.setForeground(
                                    Estilos.VERDE_OSCURO
                            );
                        }
                    }

                    @Override
                    public void focusLost(
                            java.awt.event.FocusEvent evento
                    ) {

                        if (txtBuscar.getText().trim().isEmpty()) {

                            txtBuscar.setText(
                                    TEXTO_BUSQUEDA
                            );

                            txtBuscar.setForeground(
                                    java.awt.Color.GRAY
                            );
                        }
                    }
                }
        );
        txtBuscar.setToolTipText(
                "Buscar por usuario, rol, módulo, acción o detalle"
        );

        javax.swing.JButton btnBuscar =
                new javax.swing.JButton();

        Estilos.estilizarBoton(
                btnBuscar
        );

        Estilos.aplicarIcono(
                btnBuscar,
                "/imagenes/iconos/buscar.png",
                18,
                18
        );

        btnBuscar.setPreferredSize(
                new java.awt.Dimension(
                        42,
                        38
                )
        );
        btnBuscar.addActionListener(
                evento -> buscarRegistros()
        );

        txtBuscar.addActionListener(
                evento -> buscarRegistros()
        );
        javax.swing.JPanel panelBusqueda =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.RIGHT,
                                8,
                                0
                        )
                );

        panelBusqueda.setOpaque(false);

        panelBusqueda.add(
                btnActualizar
        );

        panelBusqueda.add(
                txtBuscar
        );

        panelBusqueda.add(
                btnBuscar
        );

        javax.swing.JPanel panelSuperior =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout()
                );

        panelSuperior.setOpaque(false);

        panelSuperior.add(
                btnInicio,
                java.awt.BorderLayout.WEST
        );

        panelSuperior.add(
                panelBusqueda,
                java.awt.BorderLayout.EAST
        );

        tarjeta.add(
                panelSuperior,
                java.awt.BorderLayout.NORTH
        );

        Estilos.estilizarTabla(
                tabla
        );

        tabla.setRowHeight(
                38
        );

        tabla.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );
        tabla.setRowSorter(
                ordenador
        );
        tabla.setAutoResizeMode(
                javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS
        );
        tabla.getTableHeader().setReorderingAllowed(
                false
        );

        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(
                        tabla
                );

        scroll.getViewport().setBackground(
                new java.awt.Color(
                        235,
                        250,
                        244
                )
        );

        scroll.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        1,
                        true
                )
        );

        tarjeta.add(
                scroll,
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
    }
    private void configurarColumnaObservaciones() {

        tabla.getColumnModel()
                .getColumn(6)
                .setCellRenderer(
                        new RenderizadorObservaciones()
                );

        tabla.getColumnModel()
                .getColumn(6)
                .setCellEditor(
                        new EditorObservaciones()
                );
    }
    private void configurarColumnaAcciones() {

        tabla.getColumnModel()
                .getColumn(7)
                .setCellRenderer(
                        new RenderizadorEliminar()
                );

        tabla.getColumnModel()
                .getColumn(7)
                .setCellEditor(
                        new EditorEliminar()
                );

        tabla.addMouseMotionListener(
                new java.awt.event.MouseMotionAdapter() {

                    @Override
                    public void mouseMoved(
                            java.awt.event.MouseEvent evento
                    ) {

                        int columna =
                                tabla.columnAtPoint(
                                        evento.getPoint()
                                );

                        tabla.setCursor(
                                new java.awt.Cursor(
                                        columna == 6 || columna == 7
                                                ? java.awt.Cursor.HAND_CURSOR
                                                : java.awt.Cursor.DEFAULT_CURSOR
                                )
                        );
                    }
                }
        );

        tabla.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evento
                    ) {

                        tabla.setCursor(
                                new java.awt.Cursor(
                                        java.awt.Cursor.DEFAULT_CURSOR
                                )
                        );
                    }
                }
        );
    }
    private void buscarRegistros() {

        String texto =
                txtBuscar.getText().trim();

       if (texto.isEmpty()
        || texto.equals(TEXTO_BUSQUEDA)) {

            ordenador.setRowFilter(
                    null
            );

            return;
        }

        ordenador.setRowFilter(
                javax.swing.RowFilter.regexFilter(
                        "(?i)"
                        + java.util.regex.Pattern.quote(
                                texto
                        )
                )
        );
    }
    private void cargarRegistros() {

        modelo.setRowCount(
                0
        );

        for (Object[] registro
                : AuditoriaController.listarRegistros()) {

            modelo.addRow(
                    new Object[]{
                        registro[0],
                        registro[1],
                        registro[2],
                        registro[3],
                        registro[4],
                        registro[5],
                        registro[6],
                        ""
                    }
            );
        }

        if (tabla.getColumnCount() == 8) {

            javax.swing.table.TableColumn columnaId =
                tabla.getColumnModel()
                        .getColumn(0);

        columnaId.setMinWidth(0);
        columnaId.setPreferredWidth(0);
        columnaId.setMaxWidth(0);
        columnaId.setResizable(false);

        tabla.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(165);

        tabla.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(110);

        tabla.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(135);

        tabla.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(105);

        tabla.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(165);

        tabla.getColumnModel()
                .getColumn(6)
                .setPreferredWidth(165);

        tabla.getColumnModel()
                .getColumn(7)
                .setPreferredWidth(90);

        tabla.getColumnModel()
                .getColumn(7)
                .setMinWidth(90);

        tabla.getColumnModel()
                .getColumn(7)
                .setMaxWidth(90);
        }
    }
    private void eliminarRegistro(
            int idAuditoria
    ) {

        boolean confirmado =
                Estilos.mostrarConfirmacion(
                        this,
                        "Confirmar eliminación",
                        "¿Deseás eliminar el registro de auditoría N.º "
                        + idAuditoria
                        + "?"
                );

        if (!confirmado) {
            return;
        }

        boolean eliminado =
                AuditoriaController.eliminarRegistro(
                        idAuditoria
                );

        if (!eliminado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar el registro de auditoría"
            );

            return;
        }

        cargarRegistros();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Registro de auditoría eliminado correctamente"
        );
    }
    private class RenderizadorObservaciones
        extends javax.swing.JPanel
        implements javax.swing.table.TableCellRenderer {

    private final javax.swing.JButton btnVer =
            crearBotonObservaciones();

    public RenderizadorObservaciones() {

            setLayout(
                    new java.awt.FlowLayout(
                            java.awt.FlowLayout.CENTER,
                            0,
                            4
                    )
            );

            setOpaque(true);

            add(
                    btnVer
            );
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
    private class EditorObservaciones
            extends javax.swing.AbstractCellEditor
            implements javax.swing.table.TableCellEditor {

        private final javax.swing.JPanel panel =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                4
                        )
                );

        private final javax.swing.JButton btnVer =
                crearBotonObservaciones();

        private String observaciones;

        public EditorObservaciones() {

            panel.setOpaque(true);

            panel.add(
                    btnVer
            );

            btnVer.addActionListener(
                    evento -> {

                        fireEditingStopped();

                        Estilos.mostrarAdvertencia(
                                PanelAuditoria.this,
                                "Observaciones del registro",
                                observaciones
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

            observaciones =
                    valor == null
                            ? "Sin observaciones"
                            : valor.toString();

            panel.setBackground(
                    tabla.getSelectionBackground()
            );

            return panel;
        }

        @Override
        public Object getCellEditorValue() {

            return observaciones;
        }
    }
    private class RenderizadorEliminar
            extends javax.swing.JPanel
            implements javax.swing.table.TableCellRenderer {

        private final javax.swing.JButton btnEliminar =
                crearBotonEliminar();

        public RenderizadorEliminar() {

            setLayout(
                    new java.awt.FlowLayout(
                            java.awt.FlowLayout.CENTER,
                            0,
                            4
                    )
            );

            setOpaque(true);

            add(
                    btnEliminar
            );
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

    private class EditorEliminar
            extends javax.swing.AbstractCellEditor
            implements javax.swing.table.TableCellEditor {

        private final javax.swing.JPanel panel =
                new javax.swing.JPanel(
                        new java.awt.FlowLayout(
                                java.awt.FlowLayout.CENTER,
                                0,
                                4
                        )
                );

        private final javax.swing.JButton btnEliminar =
                crearBotonEliminar();

        private int idAuditoria;

        public EditorEliminar() {

            panel.setOpaque(true);

            panel.add(
                    btnEliminar
            );

            btnEliminar.addActionListener(
                    evento -> {

                        fireEditingStopped();

                        eliminarRegistro(
                                idAuditoria
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

            idAuditoria =
                    Integer.parseInt(
                            tabla.getValueAt(
                                    fila,
                                    0
                            ).toString()
                    );

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
    private javax.swing.JButton crearBotonObservaciones() {

        javax.swing.JButton boton =
                new javax.swing.JButton(
                        "Ver"
                );

        java.awt.Dimension tamaño =
                new java.awt.Dimension(
                        70,
                        26
                );

        boton.setPreferredSize(
                tamaño
        );

        boton.setMinimumSize(
                tamaño
        );

        boton.setMaximumSize(
                tamaño
        );

        boton.setFont(
                Estilos.fuenteNormal()
        );

        boton.setBackground(
                new java.awt.Color(
                        70,
                        145,
                        215
                )
        );

        boton.setForeground(
                java.awt.Color.WHITE
        );

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);

        boton.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return boton;
    }
    private javax.swing.JButton crearBotonEliminar() {

        javax.swing.JButton boton =
                new javax.swing.JButton();

        java.awt.Dimension tamaño =
                new java.awt.Dimension(
                        28,
                        26
                );

        boton.setPreferredSize(
                tamaño
        );

        boton.setMinimumSize(
                tamaño
        );

        boton.setMaximumSize(
                tamaño
        );

        boton.setBackground(
                new java.awt.Color(
                        210,
                        70,
                        70
                )
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
                "/imagenes/iconos/eliminar.png",
                14,
                14
        );

        return boton;
    }
}