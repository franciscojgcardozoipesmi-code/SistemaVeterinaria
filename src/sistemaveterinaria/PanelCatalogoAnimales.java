package sistemaveterinaria;

import controller.CatalogoAnimalController;

public class PanelCatalogoAnimales
        extends javax.swing.JPanel {

    private final VentanaPrincipal ventanaPrincipal;

    private final javax.swing.JTextField txtNuevaEspecie =
            new javax.swing.JTextField();

    private final javax.swing.JTextField txtNuevaRaza =
            new javax.swing.JTextField();

    private final javax.swing.JComboBox<String> cmbEspecies =
            new javax.swing.JComboBox<>();

    private final javax.swing.DefaultListModel<String> modeloRazas =
            new javax.swing.DefaultListModel<>();

    private final javax.swing.JList<String> listaRazas =
            new javax.swing.JList<>(modeloRazas);
    private final javax.swing.table.DefaultTableModel modeloEspecies =
            new javax.swing.table.DefaultTableModel(
                    new Object[]{
                        "Especie",
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

    private final javax.swing.JTable tablaEspecies =
            new javax.swing.JTable(
                    modeloEspecies
            );

    private final javax.swing.table.DefaultTableModel modeloTablaRazas =
            new javax.swing.table.DefaultTableModel(
                    new Object[]{
                        "Raza",
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

    private final javax.swing.JTable tablaRazas =
            new javax.swing.JTable(
                    modeloTablaRazas
            );

    private String especieSeleccionada;
    private final javax.swing.JLabel lblTituloRazas =
        new javax.swing.JLabel(
                "Seleccioná una especie"
        );
    private final javax.swing.JButton btnEliminarEspecie =
            new javax.swing.JButton(
                    "Eliminar especie"
            );

    private final javax.swing.JButton btnEliminarRaza =
            new javax.swing.JButton(
                    "Eliminar raza"
            );
    private final javax.swing.JButton btnEditarEspecie =
            new javax.swing.JButton(
                    "Editar especie"
            );

    private final javax.swing.JButton btnEditarRaza =
            new javax.swing.JButton(
                    "Editar raza"
        );
    public PanelCatalogoAnimales(
            VentanaPrincipal ventanaPrincipal
    ) {

        this.ventanaPrincipal =
                ventanaPrincipal;

        CatalogoAnimalController.inicializarCatalogo();

        construirPanel();
        configurarTablasCatalogo();
        cargarEspecies();
        cargarTablaEspecies();
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
                        "Gestión de especies y razas"
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

        tarjeta.add(
                panelInicio,
                java.awt.BorderLayout.NORTH
        );

        javax.swing.JPanel panelCatalogos =
                new javax.swing.JPanel(
                        new java.awt.GridLayout(
                                1,
                                2,
                                20,
                                0
                        )
                );

        panelCatalogos.setOpaque(false);

        javax.swing.JPanel panelEspecies =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                12
                        )
                );

        panelEspecies.setBackground(
                Estilos.BLANCO
        );

        panelEspecies.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                15,
                                15,
                                15,
                                15
                        )
                )
        );

        javax.swing.JLabel lblEspecies =
                new javax.swing.JLabel(
                        "Especies"
                );

        lblEspecies.setFont(
                Estilos.fuenteSubtitulo()
        );

        lblEspecies.setForeground(
                Estilos.VERDE_OSCURO
        );

        lblEspecies.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );
        
        lblEspecies.setMaximumSize(
                new java.awt.Dimension(
                        Integer.MAX_VALUE,
                        30
                )
        );

        javax.swing.JLabel lblNuevaEspecie =
                new javax.swing.JLabel(
                        "Nueva especie"
                );

        lblNuevaEspecie.setFont(
                Estilos.fuenteNormal()
        );

        lblNuevaEspecie.setForeground(
                Estilos.VERDE_OSCURO
        );

        txtNuevaEspecie.setFont(
                Estilos.fuenteNormal()
        );

        java.awt.Dimension tamañoCampo =
                new java.awt.Dimension(
                        230,
                        38
                );

        txtNuevaEspecie.setPreferredSize(
                tamañoCampo
        );

        txtNuevaEspecie.setMinimumSize(
                tamañoCampo
        );

        javax.swing.JButton btnAgregarEspecie =
                new javax.swing.JButton(
                        "Agregar"
                );

        Estilos.estilizarBoton(
                btnAgregarEspecie
        );

        java.awt.Dimension tamañoBotonAgregar =
                new java.awt.Dimension(
                        120,
                        38
                );

        btnAgregarEspecie.setPreferredSize(
                tamañoBotonAgregar
        );

        btnAgregarEspecie.setMinimumSize(
                tamañoBotonAgregar
        );

        btnAgregarEspecie.addActionListener(
                evento -> agregarEspecie()
        );

        javax.swing.JPanel formularioEspecie =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        formularioEspecie.setOpaque(false);

        java.awt.GridBagConstraints gbcEspecie =
                new java.awt.GridBagConstraints();

        gbcEspecie.insets =
                new java.awt.Insets(
                        5,
                        5,
                        5,
                        5
                );

        gbcEspecie.anchor =
                java.awt.GridBagConstraints.WEST;

        gbcEspecie.gridx = 0;
        gbcEspecie.gridy = 0;
        gbcEspecie.gridwidth = 2;

        formularioEspecie.add(
                lblNuevaEspecie,
                gbcEspecie
        );

        gbcEspecie.gridx = 0;
        gbcEspecie.gridy = 1;
        gbcEspecie.gridwidth = 1;
        gbcEspecie.weightx = 1;
        gbcEspecie.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        formularioEspecie.add(
                txtNuevaEspecie,
                gbcEspecie
        );

        gbcEspecie.gridx = 1;
        gbcEspecie.weightx = 0;
        gbcEspecie.fill =
                java.awt.GridBagConstraints.NONE;

        formularioEspecie.add(
                btnAgregarEspecie,
                gbcEspecie
        );

        javax.swing.JPanel cabeceraEspecies =
                new javax.swing.JPanel();

        cabeceraEspecies.setOpaque(false);

        cabeceraEspecies.setLayout(
                new javax.swing.BoxLayout(
                        cabeceraEspecies,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        lblEspecies.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        formularioEspecie.setAlignmentX(
                java.awt.Component.LEFT_ALIGNMENT
        );

        cabeceraEspecies.add(
                lblEspecies
        );

        cabeceraEspecies.add(
                javax.swing.Box.createVerticalStrut(
                        8
                )
        );

        cabeceraEspecies.add(
                formularioEspecie
        );

        javax.swing.JScrollPane scrollEspecies =
                new javax.swing.JScrollPane(
                        tablaEspecies
                );

        scrollEspecies.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        1,
                        true
                )
        );

        scrollEspecies.setPreferredSize(
                new java.awt.Dimension(
                        400,
                        300
                )
        );

        panelEspecies.add(
                cabeceraEspecies,
                java.awt.BorderLayout.NORTH
        );

        panelEspecies.add(
                scrollEspecies,
                java.awt.BorderLayout.CENTER
        );

        javax.swing.JPanel panelRazas =
                new javax.swing.JPanel(
                        new java.awt.BorderLayout(
                                0,
                                12
                        )
                );

        panelRazas.setBackground(
                Estilos.BLANCO
        );

        panelRazas.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(
                                Estilos.VERDE_OSCURO,
                                1,
                                true
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(
                                15,
                                15,
                                15,
                                15
                        )
                )
        );

        lblTituloRazas.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );
        lblTituloRazas.setMaximumSize(
                new java.awt.Dimension(
                        Integer.MAX_VALUE,
                        30
                )
        );

        javax.swing.JLabel lblNuevaRaza =
                new javax.swing.JLabel(
                        "Nueva raza"
                );

        lblNuevaRaza.setFont(
                Estilos.fuenteNormal()
        );

        lblNuevaRaza.setForeground(
                Estilos.VERDE_OSCURO
        );

        txtNuevaRaza.setFont(
                Estilos.fuenteNormal()
        );

        txtNuevaRaza.setPreferredSize(
                tamañoCampo
        );

        txtNuevaRaza.setMinimumSize(
                tamañoCampo
        );

        javax.swing.JButton btnAgregarRaza =
                new javax.swing.JButton(
                        "Agregar"
                );

        Estilos.estilizarBoton(
                btnAgregarRaza
        );

        btnAgregarRaza.setPreferredSize(
                tamañoBotonAgregar
        );

        btnAgregarRaza.setMinimumSize(
                tamañoBotonAgregar
        );

        btnAgregarRaza.addActionListener(
                evento -> agregarRaza()
        );

        javax.swing.JPanel formularioRaza =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        formularioRaza.setOpaque(false);

        java.awt.GridBagConstraints gbcRaza =
                new java.awt.GridBagConstraints();

        gbcRaza.insets =
                new java.awt.Insets(
                        5,
                        5,
                        5,
                        5
                );

        gbcRaza.anchor =
                java.awt.GridBagConstraints.WEST;

        gbcRaza.gridx = 0;
        gbcRaza.gridy = 0;
        gbcRaza.gridwidth = 2;

        formularioRaza.add(
                lblNuevaRaza,
                gbcRaza
        );

        gbcRaza.gridx = 0;
        gbcRaza.gridy = 1;
        gbcRaza.gridwidth = 1;
        gbcRaza.weightx = 1;
        gbcRaza.fill =
                java.awt.GridBagConstraints.HORIZONTAL;

        formularioRaza.add(
                txtNuevaRaza,
                gbcRaza
        );

        gbcRaza.gridx = 1;
        gbcRaza.weightx = 0;
        gbcRaza.fill =
                java.awt.GridBagConstraints.NONE;

        formularioRaza.add(
                btnAgregarRaza,
                gbcRaza
        );

        javax.swing.JPanel cabeceraRazas =
                new javax.swing.JPanel();

        cabeceraRazas.setOpaque(false);

        cabeceraRazas.setLayout(
                new javax.swing.BoxLayout(
                        cabeceraRazas,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        lblTituloRazas.setAlignmentX(
                java.awt.Component.CENTER_ALIGNMENT
        );

        formularioRaza.setAlignmentX(
                java.awt.Component.LEFT_ALIGNMENT
        );

        cabeceraRazas.add(
                lblTituloRazas
        );

        cabeceraRazas.add(
                javax.swing.Box.createVerticalStrut(
                        8
                )
        );

        cabeceraRazas.add(
                formularioRaza
        );

        javax.swing.JScrollPane scrollRazas =
                new javax.swing.JScrollPane(
                        tablaRazas
                );

        scrollRazas.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        1,
                        true
                )
        );

        scrollRazas.setPreferredSize(
                new java.awt.Dimension(
                        400,
                        300
                )
        );

        panelRazas.add(
                cabeceraRazas,
                java.awt.BorderLayout.NORTH
        );

        panelRazas.add(
                scrollRazas,
                java.awt.BorderLayout.CENTER
        );

        panelCatalogos.add(
                panelEspecies
        );

        panelCatalogos.add(
                panelRazas
        );

        tarjeta.add(
                panelCatalogos,
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
    private void configurarTablasCatalogo() {

        Estilos.estilizarTabla(
                tablaEspecies
        );

        Estilos.estilizarTabla(
                tablaRazas
        );

        tablaEspecies.setRowHeight(
                34
        );

        tablaRazas.setRowHeight(
                34
        );

        tablaEspecies.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        tablaRazas.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        tablaEspecies.getTableHeader().setReorderingAllowed(
                false
        );

        tablaRazas.getTableHeader().setReorderingAllowed(
                false
        );

        tablaEspecies.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(95);

        tablaEspecies.getColumnModel()
                .getColumn(1)
                .setMinWidth(95);

        tablaEspecies.getColumnModel()
                .getColumn(1)
                .setMaxWidth(95);

        tablaRazas.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(95);

        tablaRazas.getColumnModel()
                .getColumn(1)
                .setMinWidth(95);

        tablaRazas.getColumnModel()
                .getColumn(1)
                .setMaxWidth(95);

        lblTituloRazas.setFont(
                Estilos.fuenteSubtitulo()
        );

        lblTituloRazas.setForeground(
                Estilos.VERDE_OSCURO
        );

        tablaEspecies.getSelectionModel()
                .addListSelectionListener(
                        evento -> {

                            if (evento.getValueIsAdjusting()) {
                                return;
                            }

                            int fila =
                                    tablaEspecies.getSelectedRow();

                            if (fila == -1) {

                                especieSeleccionada = null;

                                lblTituloRazas.setText(
                                        "Seleccioná una especie"
                                );

                                modeloTablaRazas.setRowCount(
                                        0
                                );

                                return;
                            }

                            especieSeleccionada =
                                    modeloEspecies.getValueAt(
                                            fila,
                                            0
                                    ).toString();

                            lblTituloRazas.setText(
                                    "Razas de "
                                    + especieSeleccionada
                            );

                            cargarTablaRazas();
                        }
                );
        configurarColumnasAcciones();
    }
    private void configurarColumnasAcciones() {

        javax.swing.table.TableColumn accionesEspecies =
                tablaEspecies.getColumnModel()
                        .getColumn(1);

        accionesEspecies.setCellRenderer(
                new RenderizadorAcciones()
        );

        accionesEspecies.setCellEditor(
                new EditorAcciones(
                        true
                )
        );

        javax.swing.table.TableColumn accionesRazas =
                tablaRazas.getColumnModel()
                        .getColumn(1);

        accionesRazas.setCellRenderer(
                new RenderizadorAcciones()
        );

        accionesRazas.setCellEditor(
                new EditorAcciones(
                        false
                )
        );
    }
    private void cargarTablaEspecies() {

        modeloEspecies.setRowCount(0);

        int filaSeleccionada = -1;
        int posicion = 0;

        for (String especie
                : CatalogoAnimalController.listarEspecies()) {

            modeloEspecies.addRow(
                    new Object[]{
                        especie,
                        ""
                    }
            );

            if (especieSeleccionada != null
                    && especie.equalsIgnoreCase(
                            especieSeleccionada
                    )) {

                filaSeleccionada = posicion;
            }

            posicion++;
        }

        if (filaSeleccionada == -1
                && modeloEspecies.getRowCount() > 0) {

            filaSeleccionada = 0;

            especieSeleccionada =
                    modeloEspecies.getValueAt(
                            0,
                            0
                    ).toString();
        }

        if (filaSeleccionada >= 0) {

            tablaEspecies.setRowSelectionInterval(
                    filaSeleccionada,
                    filaSeleccionada
            );

            lblTituloRazas.setText(
                    "Razas de "
                    + especieSeleccionada
            );

        } else {

            especieSeleccionada = null;

            lblTituloRazas.setText(
                    "Seleccioná una especie"
            );
        }

        cargarTablaRazas();
    }

    private void cargarTablaRazas() {

        modeloTablaRazas.setRowCount(0);

        if (especieSeleccionada == null) {
            return;
        }

        for (String raza
                : CatalogoAnimalController
                        .listarRazasPorEspecie(
                                especieSeleccionada
                        )) {

            modeloTablaRazas.addRow(
                    new Object[]{
                        raza,
                        ""
                    }
            );
        }
    }
    private void cargarEspecies() {

        String seleccionActual =
                cmbEspecies.getSelectedItem() == null
                ? null
                : cmbEspecies.getSelectedItem().toString();

        cmbEspecies.removeAllItems();

        for (String especie
                : CatalogoAnimalController.listarEspecies()) {

            cmbEspecies.addItem(
                    especie
            );
        }

        if (seleccionActual != null) {

            cmbEspecies.setSelectedItem(
                    seleccionActual
            );
        }

        cargarRazas();
    }

    private void cargarRazas() {

        modeloRazas.clear();

        Object especieSeleccionada =
                cmbEspecies.getSelectedItem();

        if (especieSeleccionada == null) {
            return;
        }

        for (String raza
                : CatalogoAnimalController
                        .listarRazasPorEspecie(
                                especieSeleccionada.toString()
                        )) {

            modeloRazas.addElement(
                    raza
            );
        }
    }

    private void agregarEspecie() {

        String nombre =
                normalizar(
                        txtNuevaEspecie.getText()
                );

        if (!nombreValido(nombre)) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá una especie válida sin números"
            );

            return;
        }

        boolean guardado =
                CatalogoAnimalController
                        .agregarEspecie(nombre);

        if (!guardado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "La especie ya existe"
            );

            return;
        }

        txtNuevaEspecie.setText("");

        especieSeleccionada =
                nombre;

        cargarEspecies();
        cargarTablaEspecies();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Especie agregada correctamente"
        );
    }

    private void agregarRaza() {

        String nombre =
                normalizar(
                        txtNuevaRaza.getText()
                );

        if (especieSeleccionada == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una especie"
            );

            return;
        }

        if (!nombreValido(nombre)) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá una raza válida sin números"
            );

            return;
        }

        boolean guardado =
                CatalogoAnimalController.agregarRaza(
                        nombre,
                        especieSeleccionada
                );

        if (!guardado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "La raza ya existe para esa especie"
            );

            return;
        }

        txtNuevaRaza.setText("");

        cargarTablaRazas();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Raza agregada correctamente"
        );
    }

    private boolean nombreValido(
            String nombre
    ) {

        return !nombre.isEmpty()
                && nombre.matches(
                        "[\\p{L} '-]+"
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
    
    private void eliminarEspecie(
            String especie
    ) {

        boolean confirmado =
                Estilos.mostrarConfirmacion(
                        this,
                        "Confirmar eliminación",
                        "¿Deseás eliminar la especie "
                        + especie
                        + "?\nTambién se eliminarán sus razas."
                );

        if (!confirmado) {
            return;
        }

        boolean eliminado =
                CatalogoAnimalController
                        .eliminarEspecie(
                                especie
                        );

        if (!eliminado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar la especie"
            );

            return;
        }

        if (especie.equalsIgnoreCase(
                especieSeleccionada
        )) {

            especieSeleccionada = null;
        }

        cargarEspecies();
        cargarTablaEspecies();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Especie eliminada correctamente"
        );
    }

    private void eliminarRaza(
            String razaSeleccionada
    ) {

        if (especieSeleccionada == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una especie"
            );

            return;
        }

        boolean confirmado =
                Estilos.mostrarConfirmacion(
                        this,
                        "Confirmar eliminación",
                        "¿Deseás eliminar la raza "
                        + razaSeleccionada
                        + "?"
                );

        if (!confirmado) {
            return;
        }

        boolean eliminado =
                CatalogoAnimalController.eliminarRaza(
                        razaSeleccionada,
                        especieSeleccionada
                );

        if (!eliminado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar la raza"
            );

            return;
        }

        cargarTablaRazas();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Raza eliminada correctamente"
        );
    }
    private void editarEspecie(
            String nombreActual
    ) {

        String nombreNuevo =
                Estilos.solicitarTexto(
                        this,
                        "Editar especie",
                        "Nuevo nombre de la especie:",
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
                    "Ingresá un nombre válido sin números"
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

        boolean editado =
                CatalogoAnimalController.editarEspecie(
                        nombreActual,
                        nombreNuevo
                );

        if (!editado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "No se pudo editar. Es posible que la especie ya exista"
            );

            return;
        }

        if (nombreActual.equalsIgnoreCase(
                especieSeleccionada
        )) {

            especieSeleccionada =
                    nombreNuevo;
        }

        cargarEspecies();
        cargarTablaEspecies();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Especie editada correctamente"
        );
    }
    private void editarRaza(
            String nombreActual
    ) {

        if (especieSeleccionada == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una especie"
            );

            return;
        }

        String nombreNuevo =
                Estilos.solicitarTexto(
                        this,
                        "Editar raza",
                        "Nuevo nombre de la raza:",
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
                    "Ingresá un nombre válido sin números"
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

        boolean editado =
                CatalogoAnimalController.editarRaza(
                        nombreActual,
                        nombreNuevo,
                        especieSeleccionada
                );

        if (!editado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "No se pudo editar. Es posible que la raza ya exista"
            );

            return;
        }

        cargarTablaRazas();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Raza editada correctamente"
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

            add(
                    btnEditar
            );

            add(
                    btnEliminar
            );
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

            if (seleccionada) {

                setBackground(
                        tabla.getSelectionBackground()
                );

            } else {

                setBackground(
                        tabla.getBackground()
                );
            }

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

            private final boolean accionesDeEspecies;

            private int filaModelo = -1;

        public EditorAcciones(
                boolean accionesDeEspecies
        ) {

            this.accionesDeEspecies =
                    accionesDeEspecies;

            panel.setOpaque(true);

            panel.add(
                    btnEditar
            );

            panel.add(
                    btnEliminar
            );

            btnEditar.addActionListener(
                    evento -> {

                        int fila =
                                filaModelo;

                        fireEditingStopped();

                        if (fila < 0) {
                            return;
                        }

                        if (accionesDeEspecies) {

                            String especie =
                                    modeloEspecies.getValueAt(
                                            fila,
                                            0
                                    ).toString();

                            editarEspecie(
                                    especie
                            );

                        } else {

                            String raza =
                                    modeloTablaRazas.getValueAt(
                                            fila,
                                            0
                                    ).toString();

                            editarRaza(
                                    raza
                            );
                        }
                    }
            );

            btnEliminar.addActionListener(
                    evento -> {

                        int fila =
                                filaModelo;

                        fireEditingStopped();

                        if (fila < 0) {
                            return;
                        }

                        if (accionesDeEspecies) {

                            String especie =
                                    modeloEspecies.getValueAt(
                                            fila,
                                            0
                                    ).toString();

                            eliminarEspecie(
                                    especie
                            );

                        } else {

                            String raza =
                                    modeloTablaRazas.getValueAt(
                                            fila,
                                            0
                                    ).toString();

                            eliminarRaza(
                                    raza
                            );
                        }
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

        boton.setPreferredSize(
                tamaño
        );

        boton.setMinimumSize(
                tamaño
        );

        boton.setMaximumSize(
                tamaño
        );

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

        boton.setPreferredSize(
                tamaño
        );

        boton.setMinimumSize(
                tamaño
        );

        boton.setMaximumSize(
                tamaño
        );

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