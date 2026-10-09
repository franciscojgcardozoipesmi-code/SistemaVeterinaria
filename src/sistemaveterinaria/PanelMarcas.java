package sistemaveterinaria;

import controller.MarcaController;
import modelo.Marca;

public class PanelMarcas
        extends javax.swing.JPanel {

    private final VentanaPrincipal ventanaPrincipal;

    private final javax.swing.JTextField txtNuevaMarca =
            new javax.swing.JTextField();

    private final javax.swing.table.DefaultTableModel modeloTabla =
            new javax.swing.table.DefaultTableModel(
                    new Object[]{
                        "ID",
                        "Marca",
                        "Acciones"
                    },
                    0
            ) {

                @Override
                public boolean isCellEditable(
                        int fila,
                        int columna
                ) {

                    return columna == 2;
                }
            };

    private final javax.swing.JTable tablaMarcas =
            new javax.swing.JTable(
                    modeloTabla
            );

    public PanelMarcas(
            VentanaPrincipal ventanaPrincipal
    ) {

        this.ventanaPrincipal =
                ventanaPrincipal;

        MarcaController.inicializarMarcas();

        construirPanel();
        configurarTabla();
        cargarMarcas();
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
                        60,
                        40,
                        60
                )
        );

        javax.swing.JLabel lblTitulo =
                new javax.swing.JLabel(
                        "Gestión de marcas"
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
                                18
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

        java.awt.Dimension tamañoInicio =
                new java.awt.Dimension(
                        110,
                        38
                );

        btnInicio.setPreferredSize(
                tamañoInicio
        );

        btnInicio.setMinimumSize(
                tamañoInicio
        );

        btnInicio.addActionListener(
                evento ->
                        ventanaPrincipal.mostrarInicio()
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

        tarjeta.add(
                panelInicio,
                java.awt.BorderLayout.NORTH
        );

        javax.swing.JPanel contenido =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                15
                        )
                );

        contenido.setOpaque(false);

        javax.swing.JLabel lblNuevaMarca =
                new javax.swing.JLabel(
                        "Nueva marca"
                );

        lblNuevaMarca.setFont(
                Estilos.fuenteNormal()
        );

        lblNuevaMarca.setForeground(
                Estilos.VERDE_OSCURO
        );

        txtNuevaMarca.setFont(
                Estilos.fuenteNormal()
        );

        java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        300,
                        38
                );

        txtNuevaMarca.setPreferredSize(
                tamañoCampo
        );

        txtNuevaMarca.setMinimumSize(
                tamañoCampo
        );

        javax.swing.JButton btnAgregar =
                new javax.swing.JButton(
                        "Agregar marca"
                );

        Estilos.estilizarBoton(
                btnAgregar
        );

        java.awt.Dimension tamañoAgregar =
                new java.awt.Dimension(
                        160,
                        38
                );

        btnAgregar.setPreferredSize(
                tamañoAgregar
        );

        btnAgregar.setMinimumSize(
                tamañoAgregar
        );

        btnAgregar.addActionListener(
                evento -> agregarMarca()
        );

        txtNuevaMarca.addActionListener(
                evento -> agregarMarca()
        );

        javax.swing.JPanel formulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        formulario.setOpaque(false);

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.insets =
                new java.awt.Insets(
                        5,
                        5,
                        5,
                        5
                );

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        formulario.add(
                lblNuevaMarca,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        formulario.add(
                txtNuevaMarca,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.fill =
                java.awt.GridBagConstraints.NONE;

        formulario.add(
                btnAgregar,
                gbc
        );

        contenido.add(
                formulario,
                java.awt.BorderLayout.NORTH
        );

        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(
                        tablaMarcas
                );

        scroll.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        1,
                        true
                )
        );

        contenido.add(
                scroll,
                java.awt.BorderLayout.CENTER
        );

        tarjeta.add(
                contenido,
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

    private void configurarTabla() {

        Estilos.estilizarTabla(
                tablaMarcas
        );

        tablaMarcas.setRowHeight(
                34
        );

        tablaMarcas.setSelectionMode(
                javax.swing.ListSelectionModel
                        .SINGLE_SELECTION
        );

        tablaMarcas.getTableHeader()
                .setReorderingAllowed(false);

        tablaMarcas.getColumnModel()
                .getColumn(0)
                .setMinWidth(0);

        tablaMarcas.getColumnModel()
                .getColumn(0)
                .setMaxWidth(0);

        tablaMarcas.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(0);

        javax.swing.table.TableColumn acciones =
                tablaMarcas.getColumnModel()
                        .getColumn(2);

        acciones.setPreferredWidth(100);
        acciones.setMinWidth(100);
        acciones.setMaxWidth(100);

        acciones.setCellRenderer(
                new RenderizadorAcciones()
        );

        acciones.setCellEditor(
                new EditorAcciones()
        );
    }

    private void cargarMarcas() {

        modeloTabla.setRowCount(0);

        for (Marca marca
                : MarcaController.listarMarcas()) {

            modeloTabla.addRow(
                    new Object[]{
                        marca.getIdMarca(),
                        marca.getNombre(),
                        ""
                    }
            );
        }
    }

    private void agregarMarca() {

        String nombre =
                normalizar(
                        txtNuevaMarca.getText()
                );

        if (!nombreValido(nombre)) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá una marca válida"
            );

            return;
        }

        boolean guardada =
                MarcaController.guardarMarca(
                        -1,
                        nombre
                );

        if (!guardada) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "La marca ya existe"
            );

            return;
        }

        txtNuevaMarca.setText("");

        cargarMarcas();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Marca agregada correctamente"
        );
    }

    private void editarMarca(
            int idMarca,
            String nombreActual
    ) {

        if (nombreActual.equalsIgnoreCase(
                "Sin marca"
        )) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "La marca predeterminada no se puede editar"
            );

            return;
        }

        String nombreNuevo =
                Estilos.solicitarTexto(
                        this,
                        "Editar marca",
                        "Nuevo nombre de la marca:",
                        nombreActual
                );

        if (nombreNuevo == null) {
            return;
        }

        nombreNuevo =
                normalizar(
                        nombreNuevo
                );

        if (!nombreValido(nombreNuevo)) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá una marca válida"
            );

            return;
        }

        if (nombreActual.equalsIgnoreCase(
                nombreNuevo
        )) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "El nuevo nombre debe ser diferente"
            );

            return;
        }

        boolean editada =
                MarcaController.editarMarca(
                        idMarca,
                        nombreNuevo
                );

        if (!editada) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "No se pudo editar. Es posible que la marca ya exista"
            );

            return;
        }

        cargarMarcas();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Marca editada correctamente"
        );
    }

    private void eliminarMarca(
            int idMarca,
            String nombre
    ) {

        if (nombre.equalsIgnoreCase(
                "Sin marca"
        )) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "La marca predeterminada no se puede eliminar"
            );

            return;
        }

        if (MarcaController.marcaEnUso(
                idMarca
        )) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "No se puede eliminar porque está asignada a uno o más productos"
            );

            return;
        }

        boolean confirmado =
                Estilos.mostrarConfirmacion(
                        this,
                        "Confirmar eliminación",
                        "¿Deseás eliminar la marca "
                        + nombre
                        + "?"
                );

        if (!confirmado) {
            return;
        }

        boolean eliminada =
                MarcaController.eliminarMarca(
                        idMarca
                );

        if (!eliminada) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar la marca"
            );

            return;
        }

        cargarMarcas();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Marca eliminada correctamente"
        );
    }

    private String normalizar(
            String texto
    ) {

        return texto == null
                ? ""
                : texto.trim().replaceAll(
                        "\\s+",
                        " "
                );
    }

    private boolean nombreValido(
            String nombre
    ) {

        return !nombre.isEmpty()
                && nombre.matches(
                        "[\\p{L}\\p{N} &'().-]+"
                );
    }

    private class RenderizadorAcciones
            extends javax.swing.JPanel
            implements javax.swing.table.TableCellRenderer {

        private final javax.swing.JButton btnEditar =
                crearBotonEditar();

        private final javax.swing.JButton btnEliminar =
                crearBotonEliminar();

        public RenderizadorAcciones() {

            setLayout(
                    new java.awt.FlowLayout(
                            java.awt.FlowLayout.CENTER,
                            4,
                            4
                    )
            );

            setOpaque(true);

            add(btnEditar);
            add(btnEliminar);
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable tabla,
                Object valor,
                boolean seleccionada,
                boolean tieneFoco,
                int fila,
                int columna
        ) {

            setBackground(
                    seleccionada
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
                                4,
                                4
                        )
                );

        private final javax.swing.JButton btnEditar =
                crearBotonEditar();

        private final javax.swing.JButton btnEliminar =
                crearBotonEliminar();

        private int filaModelo = -1;

        public EditorAcciones() {

            panel.setOpaque(true);

            panel.add(btnEditar);
            panel.add(btnEliminar);

            btnEditar.addActionListener(
                    evento -> {

                        int fila = filaModelo;

                        fireEditingStopped();

                        if (fila < 0) {
                            return;
                        }

                        int idMarca =
                                Integer.parseInt(
                                        modeloTabla.getValueAt(
                                                fila,
                                                0
                                        ).toString()
                                );

                        String nombre =
                                modeloTabla.getValueAt(
                                        fila,
                                        1
                                ).toString();

                        editarMarca(
                                idMarca,
                                nombre
                        );
                    }
            );

            btnEliminar.addActionListener(
                    evento -> {

                        int fila = filaModelo;

                        fireEditingStopped();

                        if (fila < 0) {
                            return;
                        }

                        int idMarca =
                                Integer.parseInt(
                                        modeloTabla.getValueAt(
                                                fila,
                                                0
                                        ).toString()
                                );

                        String nombre =
                                modeloTabla.getValueAt(
                                        fila,
                                        1
                                ).toString();

                        eliminarMarca(
                                idMarca,
                                nombre
                        );
                    }
            );
        }

        @Override
        public java.awt.Component getTableCellEditorComponent(
                javax.swing.JTable tabla,
                Object valor,
                boolean seleccionada,
                int fila,
                int columna
        ) {

            filaModelo =
                    tabla.convertRowIndexToModel(
                            fila
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

    private javax.swing.JButton crearBotonEditar() {

        javax.swing.JButton boton =
                new javax.swing.JButton();

        Estilos.estilizarBotonEditar(
                boton
        );

        boton.setText("");

        Estilos.aplicarIcono(
                boton,
                "/imagenes/iconos/editar.png",
                14,
                14
        );

        java.awt.Dimension tamaño =
                new java.awt.Dimension(
                        26,
                        22
                );

        boton.setPreferredSize(tamaño);
        boton.setMinimumSize(tamaño);
        boton.setMaximumSize(tamaño);

        boton.setToolTipText(
                "Editar"
        );

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

        Estilos.estilizarBotonEliminar(
                boton
        );

        boton.setText("");

        Estilos.aplicarIcono(
                boton,
                "/imagenes/iconos/eliminar.png",
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
                "Eliminar"
        );

        boton.setFocusable(false);

        boton.setCursor(
                java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return boton;
    }
}