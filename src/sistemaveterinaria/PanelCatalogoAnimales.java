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
        cargarEspecies();
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

        javax.swing.JPanel formulario =
                new javax.swing.JPanel(
                        new java.awt.GridBagLayout()
                );

        formulario.setOpaque(false);

        java.awt.GridBagConstraints gbc =
                new java.awt.GridBagConstraints();

        gbc.insets =
                new java.awt.Insets(
                        10,
                        10,
                        10,
                        10
                );

        gbc.anchor =
                java.awt.GridBagConstraints.WEST;

        javax.swing.JLabel lblNuevaEspecie =
                new javax.swing.JLabel(
                        "Nueva especie"
                );

        javax.swing.JLabel lblEspecie =
                new javax.swing.JLabel(
                        "Especie"
                );

        javax.swing.JLabel lblNuevaRaza =
                new javax.swing.JLabel(
                        "Nueva raza"
                );

        javax.swing.JLabel[] etiquetas = {
            lblNuevaEspecie,
            lblEspecie,
            lblNuevaRaza
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
                        300,
                        38
                );

        txtNuevaEspecie.setFont(
                Estilos.fuenteNormal()
        );

        txtNuevaEspecie.setPreferredSize(
                tamañoCampo
        );

        txtNuevaRaza.setFont(
                Estilos.fuenteNormal()
        );

        txtNuevaRaza.setPreferredSize(
                tamañoCampo
        );

        cmbEspecies.setFont(
                Estilos.fuenteNormal()
        );

        cmbEspecies.setPreferredSize(
                tamañoCampo
        );

        javax.swing.JButton btnAgregarEspecie =
                new javax.swing.JButton(
                        "Agregar especie"
                );

        javax.swing.JButton btnAgregarRaza =
                new javax.swing.JButton(
                        "Agregar raza"
                );

        Estilos.estilizarBoton(
                btnAgregarEspecie
        );

        Estilos.estilizarBoton(
                btnAgregarRaza
        );

        btnAgregarEspecie.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );

        btnAgregarRaza.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 0;

        formulario.add(
                lblNuevaEspecie,
                gbc
        );

        gbc.gridx = 1;

        formulario.add(
                txtNuevaEspecie,
                gbc
        );

        gbc.gridx = 2;

        formulario.add(
                btnAgregarEspecie,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 1;

        formulario.add(
                lblEspecie,
                gbc
        );

        gbc.gridx = 1;

        formulario.add(
                cmbEspecies,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        formulario.add(
                lblNuevaRaza,
                gbc
        );

        gbc.gridx = 1;

        formulario.add(
                txtNuevaRaza,
                gbc
        );

        gbc.gridx = 2;

        formulario.add(
                btnAgregarRaza,
                gbc
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

        formulario.setAlignmentX(
                java.awt.Component.LEFT_ALIGNMENT
        );

        panelSuperiorTarjeta.add(
                panelInicio
        );

        panelSuperiorTarjeta.add(
                javax.swing.Box.createVerticalStrut(15)
        );

        panelSuperiorTarjeta.add(
                formulario
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

        javax.swing.JLabel lblRazasRegistradas =
                new javax.swing.JLabel(
                        "Razas registradas para la especie seleccionada"
                );

        lblRazasRegistradas.setFont(
                Estilos.fuenteSubtitulo()
        );

        lblRazasRegistradas.setForeground(
                Estilos.VERDE_OSCURO
        );

        listaRazas.setFont(
                Estilos.fuenteNormal()
        );

        listaRazas.setForeground(
                Estilos.VERDE_OSCURO
        );

        listaRazas.setBackground(
                new java.awt.Color(
                        235,
                        250,
                        244
                )
        );

        listaRazas.setFixedCellHeight(
                30
        );

        javax.swing.JScrollPane scrollRazas =
                new javax.swing.JScrollPane(
                        listaRazas
                );

        scrollRazas.setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        1,
                        true
                )
        );

        panelListado.add(
                lblRazasRegistradas,
                java.awt.BorderLayout.NORTH
        );

        panelListado.add(
                scrollRazas,
                java.awt.BorderLayout.CENTER
        );

        tarjeta.add(
                panelListado,
                java.awt.BorderLayout.CENTER
        );

        
        Estilos.estilizarBotonEditar(
                btnEditarEspecie
        );

        Estilos.estilizarBotonEditar(
                btnEditarRaza
        );
        btnEditarEspecie.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnEditarRaza.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnEliminarEspecie.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );

        btnEliminarRaza.setPreferredSize(
                new java.awt.Dimension(
                        165,
                        38
                )
        );
        Estilos.estilizarBotonEliminar(
                btnEliminarEspecie
        );

        Estilos.estilizarBotonEliminar(
                btnEliminarRaza
        );

        

        btnEliminarEspecie.setPreferredSize(
                new java.awt.Dimension(
                        190,
                        38
                )
        );

        btnEliminarRaza.setPreferredSize(
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
                btnEditarEspecie
        );

        panelBotones.add(
                btnEditarRaza
        );

        panelBotones.add(
                btnEliminarEspecie
        );

        panelBotones.add(
                btnEliminarRaza
        );

        
        

        tarjeta.add(
                panelBotones,
                java.awt.BorderLayout.SOUTH
        );
        panelPrincipal.add(
                tarjeta,
                java.awt.BorderLayout.CENTER
        );

        add(
                panelPrincipal,
                java.awt.BorderLayout.CENTER
        );

        cmbEspecies.addActionListener(
                evento -> cargarRazas()
        );

        btnAgregarEspecie.addActionListener(
                evento -> agregarEspecie()
        );

        btnAgregarRaza.addActionListener(
                evento -> agregarRaza()
        );

        
        
        btnEditarEspecie.addActionListener(
                evento -> editarEspecie()
        );

        btnEditarRaza.addActionListener(
                evento -> editarRaza()
        );
        btnEliminarEspecie.addActionListener(
                evento -> eliminarEspecie()
        );

        btnEliminarRaza.addActionListener(
                evento -> eliminarRaza()
        );
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

        cargarEspecies();

        cmbEspecies.setSelectedItem(
                nombre
        );

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Especie agregada correctamente"
        );
    }

    private void agregarRaza() {

        Object especieSeleccionada =
                cmbEspecies.getSelectedItem();

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
                        especieSeleccionada.toString()
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

        cargarRazas();

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
    private void eliminarEspecie() {

        Object especieSeleccionada =
                cmbEspecies.getSelectedItem();

        if (especieSeleccionada == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una especie"
            );

            return;
        }

        String especie =
                especieSeleccionada.toString();

        int respuesta =
                javax.swing.JOptionPane.showConfirmDialog(
                        this,
                        "¿Deseás eliminar la especie "
                        + especie + "?",
                        "Confirmar eliminación",
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );

        if (respuesta
                != javax.swing.JOptionPane.YES_OPTION) {

            return;
        }

        boolean eliminado =
                CatalogoAnimalController
                        .eliminarEspecie(especie);

        if (!eliminado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar la especie"
            );

            return;
        }

        cargarEspecies();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Especie eliminada correctamente"
        );
    }

    private void eliminarRaza() {

        Object especieSeleccionada =
                cmbEspecies.getSelectedItem();

        String razaSeleccionada =
                listaRazas.getSelectedValue();

        if (especieSeleccionada == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una especie"
            );

            return;
        }

        if (razaSeleccionada == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una raza de la lista"
            );

            return;
        }

        int respuesta =
                javax.swing.JOptionPane.showConfirmDialog(
                        this,
                        "¿Deseás eliminar la raza "
                        + razaSeleccionada + "?",
                        "Confirmar eliminación",
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );

        if (respuesta
                != javax.swing.JOptionPane.YES_OPTION) {

            return;
        }

        boolean eliminado =
                CatalogoAnimalController.eliminarRaza(
                        razaSeleccionada,
                        especieSeleccionada.toString()
                );

        if (!eliminado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Error",
                    "No se pudo eliminar la raza"
            );

            return;
        }

        cargarRazas();

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Raza eliminada correctamente"
        );
    }
    private void editarEspecie() {

        Object seleccion =
                cmbEspecies.getSelectedItem();

        if (seleccion == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una especie"
            );

            return;
        }

        String nombreActual =
                seleccion.toString();

        String nombreNuevo =
                normalizar(
                        txtNuevaEspecie.getText()
                );

        if (!nombreValido(nombreNuevo)) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá el nuevo nombre de la especie sin números"
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

        txtNuevaEspecie.setText("");

        cargarEspecies();

        cmbEspecies.setSelectedItem(
                nombreNuevo
        );

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Especie editada correctamente"
        );
    }
    private void editarRaza() {

        Object especieSeleccionada =
                cmbEspecies.getSelectedItem();

        String nombreActual =
                listaRazas.getSelectedValue();

        if (especieSeleccionada == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una especie"
            );

            return;
        }

        if (nombreActual == null) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Seleccioná una raza de la lista"
            );

            return;
        }

        String nombreNuevo =
                normalizar(
                        txtNuevaRaza.getText()
                );

        if (!nombreValido(nombreNuevo)) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "Ingresá el nuevo nombre de la raza sin números"
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
                CatalogoAnimalController.editarRaza(
                        nombreActual,
                        nombreNuevo,
                        especieSeleccionada.toString()
                );

        if (!editado) {

            Estilos.mostrarAdvertencia(
                    this,
                    "Atención",
                    "No se pudo editar. Es posible que la raza ya exista"
            );

            return;
        }

        txtNuevaRaza.setText("");

        cargarRazas();

        listaRazas.setSelectedValue(
                nombreNuevo,
                true
        );

        Estilos.mostrarAdvertencia(
                this,
                "Operación exitosa",
                "Raza editada correctamente"
        );
    }
}