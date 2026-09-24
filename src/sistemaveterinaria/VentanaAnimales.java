package sistemaveterinaria;
import controller.AnimalController;
public class VentanaAnimales extends javax.swing.JFrame {
    private String rolUsuario;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaAnimales.class.getName());
    private VentanaPrincipal ventanaPrincipal;
    private javax.swing.JTextField campoBusquedaAnimales;
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

                return column == 6;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");
        modelo.addColumn("Cliente");
        modelo.addColumn("Acciones");

        for (Object[] fila
                : AnimalController.listarAnimales()) {

            Object[] filaCompleta =
                    java.util.Arrays.copyOf(
                            fila,
                            7
                    );

            filaCompleta[6] = "";

            modelo.addRow(
                    filaCompleta
            );
        }

        tblAnimales.setModel(
                modelo
        );

        configurarColumnaAcciones();
        tblAnimales.setModel(
                modelo
        );

        configurarColumnaAcciones();

        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblAnimales.getColumnModel()
                .getColumn(4)
                .setCellRenderer(centrado);

        tblAnimales.getColumnModel()
                .getColumn(5)
                .setCellRenderer(centrado);

        tblAnimales.revalidate();
        tblAnimales.repaint();
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
            String texto =
                campoBusquedaAnimales
                        .getText()
                        .trim();

        if (texto.isEmpty()
                || texto.equals(
                        "Buscar por nombre, especie o raza"
                )) {

            cargarTabla();

            return;
        }

        buscarAnimales(
                texto
        );
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
    private void buscarAnimales(
            String filtro
    ) {

        javax.swing.table.DefaultTableModel modelo =
                new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {

                return column == 6;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especie");
        modelo.addColumn("Raza");
        modelo.addColumn("Edad");
        modelo.addColumn("Cliente");
        modelo.addColumn("Acciones");

        for (Object[] fila
                : AnimalController.buscarAnimales(filtro)) {

            Object[] filaCompleta =
                    java.util.Arrays.copyOf(
                            fila,
                            7
                    );

            filaCompleta[6] = "";

            modelo.addRow(
                    filaCompleta
            );
        }

        tblAnimales.setModel(
                modelo
        );

        configurarColumnaAcciones();
        tblAnimales.setModel(
                modelo
        );

        configurarColumnaAcciones();

        javax.swing.table.DefaultTableCellRenderer centrado =
                new javax.swing.table.DefaultTableCellRenderer();

        centrado.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
        );

        tblAnimales.getColumnModel()
                .getColumn(4)
                .setCellRenderer(centrado);

        tblAnimales.getColumnModel()
                .getColumn(5)
                .setCellRenderer(centrado);

        tblAnimales.revalidate();
        tblAnimales.repaint();
    }
    private void configurarColumnaAcciones() {

        if (tblAnimales.getColumnCount() < 7) {
            return;
        }

        javax.swing.table.TableColumn columnaId =
                tblAnimales.getColumnModel()
                        .getColumn(0);

        columnaId.setMinWidth(0);
        columnaId.setMaxWidth(0);
        columnaId.setPreferredWidth(0);
        columnaId.setResizable(false);

        javax.swing.table.TableColumn columnaAcciones =
                tblAnimales.getColumnModel()
                        .getColumn(6);

        columnaAcciones.setMinWidth(95);
        columnaAcciones.setMaxWidth(95);
        columnaAcciones.setPreferredWidth(95);
        columnaAcciones.setResizable(false);

        columnaAcciones.setCellRenderer(
                new RenderizadorAcciones()
        );

        columnaAcciones.setCellEditor(
                new EditorAcciones()
        );
        tblAnimales.addMouseMotionListener(
                new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseMoved(
                    java.awt.event.MouseEvent e
            ) {

                int fila =
                        tblAnimales.rowAtPoint(
                                e.getPoint()
                        );

                int columnaVista =
                        tblAnimales.columnAtPoint(
                                e.getPoint()
                        );

                boolean sobreAcciones =
                        fila >= 0
                        && columnaVista >= 0
                        && tblAnimales.convertColumnIndexToModel(
                                columnaVista
                        ) == 6;

                if (sobreAcciones) {

                    tblAnimales.setCursor(
                            java.awt.Cursor.getPredefinedCursor(
                                    java.awt.Cursor.HAND_CURSOR
                            )
                    );

                } else {

                    tblAnimales.setCursor(
                            java.awt.Cursor.getDefaultCursor()
                    );
                }
                tblAnimales.repaint();
            }
        });
        tblAnimales.addMouseListener(
                new java.awt.event.MouseAdapter() {

            @Override
            public void mouseExited(
                    java.awt.event.MouseEvent e
            ) {

                tblAnimales.setCursor(
                        java.awt.Cursor.getDefaultCursor()
                );
            }
        });
        tblAnimales.setRowHeight(
                32
        );
        tblAnimales.repaint();
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
                        "Gestión de animales"
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
        
        java.awt.event.MouseAdapter quitarFocoBusqueda =
                new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(
                    java.awt.event.MouseEvent e
            ) {

                tblAnimales.requestFocusInWindow();
            }
        };

        tarjetaAnimales.setFocusable(true);

        tarjetaAnimales.addMouseListener(
                quitarFocoBusqueda
        );

        scrollAnimales.getViewport().addMouseListener(
                quitarFocoBusqueda
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

        Estilos.estilizarBotonEditar(
                btnEditarAnimal
        );

        Estilos.estilizarBotonHistorial(
                btnHistorialMedico
        );

        Estilos.estilizarBotonEliminar(
                btnDarDeBajaRegistro
        );

        Estilos.estilizarBoton(
                txtBuscar
        );

        Estilos.estilizarBoton(
                btnMostrarTodos
        );
        
        btnMostrarTodos.setText(
                "Actualizar tabla"
        );

        btnMostrarTodos.setToolTipText(
                "Actualizar los datos de la tabla"
        );

        Estilos.aplicarIcono(
                btnAgregarAnimal,
                "/imagenes/iconos/agregar.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnEditarAnimal,
                "/imagenes/iconos/editar.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnHistorialMedico,
                "/imagenes/iconos/historial.png",
                18,
                18
        );

        Estilos.aplicarIcono(
                btnMostrarTodos,
                "/imagenes/iconos/mostrar_todos.png",
                18,
                18
        );

        txtBuscar.setText("");

        txtBuscar.setToolTipText(
                "Buscar animal"
        );

        Estilos.aplicarIcono(
                txtBuscar,
                "/imagenes/iconos/buscar.png",
                20,
                20
        );

        txtBuscar.setPreferredSize(
                new java.awt.Dimension(
                        42,
                        38
                )
        );

        txtBuscar.setMinimumSize(
                new java.awt.Dimension(
                        42,
                        38
                )
        );

        txtBuscar.setMaximumSize(
                new java.awt.Dimension(
                        42,
                        38
                )
        );

        btnDarDeBajaRegistro.setText(
                "Dar de baja el registro"
        );

        btnDarDeBajaRegistro.setIcon(
                null
        );

        btnAgregarAnimal.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        btnEditarAnimal.setPreferredSize(
                new java.awt.Dimension(
                        175,
                        38
                )
        );

        btnHistorialMedico.setPreferredSize(
                new java.awt.Dimension(
                        205,
                        38
                )
        );

        java.awt.Dimension tamañoActualizar =
                new java.awt.Dimension(
                        205,
                        38
                );

        btnMostrarTodos.setPreferredSize(
                tamañoActualizar
        );

        btnMostrarTodos.setMinimumSize(
                tamañoActualizar
        );

        btnMostrarTodos.setMaximumSize(
                tamañoActualizar
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

        btnInicio.setMaximumSize(
                tamañoInicio
        );

        btnInicio.setToolTipText(
                "Volver al inicio"
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
                                8,
                                0
                        )
                );

        panelBusqueda.setOpaque(false);

        String textoAyuda =
                "Buscar por nombre, especie o raza";

        campoBusquedaAnimales =
                new javax.swing.JTextField(
                        textoAyuda
                );
        campoBusquedaAnimales.setCaretPosition(0);

        campoBusquedaAnimales.setFont(
                Estilos.fuenteNormal()
        );

        campoBusquedaAnimales.setForeground(
                new java.awt.Color(
                        150,
                        150,
                        150
                )
        );

        campoBusquedaAnimales.setPreferredSize(
                new java.awt.Dimension(
                        320,
                        38
                )
        );

        campoBusquedaAnimales.setBorder(
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

        campoBusquedaAnimales.addFocusListener(
                new java.awt.event.FocusAdapter() {

            @Override
            public void focusGained(
                    java.awt.event.FocusEvent e
            ) {

                if (campoBusquedaAnimales.getText()
                        .equals(textoAyuda)) {

                    campoBusquedaAnimales.setText("");

                    campoBusquedaAnimales.setForeground(
                            Estilos.VERDE_OSCURO
                    );
                }
            }

            @Override
            public void focusLost(
                    java.awt.event.FocusEvent e
            ) {

                if (campoBusquedaAnimales.getText()
                        .trim()
                        .isEmpty()) {

                    campoBusquedaAnimales.setText(
                            textoAyuda
                    );

                    campoBusquedaAnimales.setForeground(
                            new java.awt.Color(
                                    150,
                                    150,
                                    150
                            )
                    );
                    campoBusquedaAnimales.setCaretPosition(0);
                }
            }
        });

        campoBusquedaAnimales.addActionListener(e ->
                txtBuscar.doClick()
        );
        panelBusqueda.add(
                btnMostrarTodos
        );
        panelBusqueda.add(
                campoBusquedaAnimales
        );

        panelBusqueda.add(
                txtBuscar
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

        tarjetaAnimales.add(
                panelAccionesSuperiores,
                java.awt.BorderLayout.NORTH
        );

        javax.swing.JButton btnCatalogo =
                new javax.swing.JButton(
                        "Especies y razas"
                );

        Estilos.estilizarBoton(
                btnCatalogo
        );

        btnCatalogo.setPreferredSize(
                new java.awt.Dimension(
                        220,
                        38
                )
        );

        btnCatalogo.addActionListener(e -> {

            if (ventanaPrincipal != null) {

                ventanaPrincipal.mostrarCatalogoAnimales();
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

        panelBotones.add(
                btnAgregarAnimal
        );

        panelBotones.add(
                btnHistorialMedico
        );

        panelBotones.add(
                btnCatalogo
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

            add(
                    btnEditar
            );

            add(
                    btnEliminar
            );
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column
        ) {

            if (isSelected) {

                setBackground(
                        table.getSelectionBackground()
                );

            } else {

                setBackground(
                        table.getBackground()
                );
            }
            boolean sobreEditar = false;
            boolean sobreEliminar = false;

            java.awt.Point posicionMouse =
                    table.getMousePosition();

            if (posicionMouse != null) {

                int filaMouse =
                        table.rowAtPoint(
                                posicionMouse
                        );

                int columnaMouse =
                        table.columnAtPoint(
                                posicionMouse
                        );

                if (filaMouse == row
                        && columnaMouse == column) {

                    java.awt.Rectangle celda =
                            table.getCellRect(
                                    row,
                                    column,
                                    false
                            );

                    int posicionDentro =
                            posicionMouse.x - celda.x;

                    if (posicionDentro
                            < celda.width / 2) {

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
                            ? new java.awt.Color(
                                    255,
                                    165,
                                    165
                            )
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

    private int filaActual = -1;

    public EditorAcciones() {

            panel.setOpaque(true);

            panel.add(
                    btnEditar
            );

            panel.add(
                    btnEliminar
            );

            btnEditar.addActionListener(e -> {

                int fila =
                        filaActual;

                fireEditingStopped();

                if (fila >= 0) {

                    tblAnimales.setRowSelectionInterval(
                            fila,
                            fila
                    );

                    btnEditarAnimalActionPerformed(
                            null
                    );
                }
            });

            btnEliminar.addActionListener(e -> {

                int fila =
                        filaActual;

                fireEditingStopped();

                if (fila >= 0) {

                    tblAnimales.setRowSelectionInterval(
                            fila,
                            fila
                    );

                    btnDarDeBajaRegistroActionPerformed(
                            null
                    );
                }
            });
        }

        @Override
        public java.awt.Component getTableCellEditorComponent(
                javax.swing.JTable table,
                Object value,
                boolean isSelected,
                int row,
                int column
        ) {

            filaActual = row;

            panel.setBackground(
                    table.getSelectionBackground()
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
                "Editar animal"
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
        
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setBorderPainted(false);

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
                "Dar de baja el animal"
        );

        boton.setFocusable(false);
        boton.setCursor(
                java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );
        return boton;
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
