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

    public PanelTiposProcedimiento(
            VentanaPrincipal ventanaPrincipal
    ) {

        this.ventanaPrincipal =
                ventanaPrincipal;

        TipoProcedimientoController.inicializarCatalogo();

        construirPanel();
        cargarTipos();
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
                                30,
                                35,
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

        tarjeta.add(
                panelFormulario,
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

        listaTipos.setFont(
                Estilos.fuenteNormal()
        );

        listaTipos.setForeground(
                Estilos.VERDE_OSCURO
        );

        listaTipos.setBackground(
                new java.awt.Color(
                        235,
                        250,
                        244
                )
        );

        listaTipos.setFixedCellHeight(
                32
        );

        listaTipos.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        javax.swing.JScrollPane scrollTipos =
                new javax.swing.JScrollPane(
                        listaTipos
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
        
        javax.swing.JButton btnEditar =
                new javax.swing.JButton(
                        "Editar tipo"
                );

        Estilos.estilizarBotonEditar(
                btnEditar
        );

        btnEditar.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );

        javax.swing.JButton btnEliminar =
                new javax.swing.JButton(
                        "Eliminar tipo"
                );

        Estilos.estilizarBotonEliminar(
                btnEliminar
        );

        btnEliminar.setPreferredSize(
                new java.awt.Dimension(
                        180,
                        38
                )
        );

        javax.swing.JButton btnVolver =
                new javax.swing.JButton(
                        "Volver a procedimientos"
                );

        Estilos.estilizarBoton(
                btnVolver
        );

        btnVolver.setPreferredSize(
                new java.awt.Dimension(
                        230,
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
                btnEditar
        );

        panelBotones.add(
                btnEliminar
        );

        panelBotones.add(
                btnVolver
        );

        panelBotones.add(
                btnVolver
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

        btnAgregar.addActionListener(
                evento -> agregarTipo()
        );

        btnEliminar.addActionListener(
                evento -> eliminarTipo()
        );
        btnEditar.addActionListener(
                evento -> editarTipo()
        );
        btnVolver.addActionListener(
                evento ->
                        ventanaPrincipal.mostrarProcedimientos()
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
}