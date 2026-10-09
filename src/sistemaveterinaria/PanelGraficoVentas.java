package sistemaveterinaria;

public class PanelGraficoVentas
        extends javax.swing.JPanel {

    private final java.util.LinkedHashMap<String, Integer>
            cantidadesPorProducto =
                    new java.util.LinkedHashMap<>();

    public PanelGraficoVentas() {

        setBackground(
                Estilos.BLANCO
        );

        setOpaque(true);

        setPreferredSize(
                new java.awt.Dimension(
                        430,
                        175
                )
        );

        setBorder(
                javax.swing.BorderFactory.createLineBorder(
                        Estilos.VERDE_OSCURO,
                        1,
                        true
                )
        );
    }

    public void actualizarDatos(
            java.util.Map<String, Integer> datos
    ) {

        cantidadesPorProducto.clear();

        java.util.ArrayList<
                java.util.Map.Entry<String, Integer>
                > productos =
                new java.util.ArrayList<>(
                        datos.entrySet()
                );

        productos.sort(
                (producto1, producto2) ->
                        Integer.compare(
                                producto2.getValue(),
                                producto1.getValue()
                        )
        );

        int limite =
                Math.min(
                        productos.size(),
                        5
                );

        for (int i = 0; i < limite; i++) {

            java.util.Map.Entry<String, Integer>
                    producto =
                    productos.get(i);

            cantidadesPorProducto.put(
                    producto.getKey(),
                    producto.getValue()
            );
        }

        repaint();
    }

    @Override
    protected void paintComponent(
            java.awt.Graphics graphics
    ) {

        super.paintComponent(graphics);

        java.awt.Graphics2D grafico =
                (java.awt.Graphics2D)
                        graphics.create();

        grafico.setRenderingHint(
                java.awt.RenderingHints.KEY_ANTIALIASING,
                java.awt.RenderingHints.VALUE_ANTIALIAS_ON
        );

        String titulo =
                "Productos más vendidos";

        grafico.setFont(
                Estilos.fuente(15f)
        );

        grafico.setColor(
                Estilos.VERDE_OSCURO
        );

        java.awt.FontMetrics medidasTitulo =
                grafico.getFontMetrics();

        int posicionTitulo =
                (
                        getWidth()
                        - medidasTitulo.stringWidth(
                                titulo
                        )
                ) / 2;

        grafico.drawString(
                titulo,
                posicionTitulo,
                25
        );

        if (cantidadesPorProducto.isEmpty()) {

            String mensaje =
                    "Generá un reporte para visualizar el gráfico";

            grafico.setFont(
                    Estilos.fuenteNormal()
            );

            grafico.setColor(
                    new java.awt.Color(
                            120,
                            120,
                            120
                    )
            );

            java.awt.FontMetrics medidasMensaje =
                    grafico.getFontMetrics();

            int posicionMensaje =
                    (
                            getWidth()
                            - medidasMensaje.stringWidth(
                                    mensaje
                            )
                    ) / 2;

            grafico.drawString(
                    mensaje,
                    posicionMensaje,
                    getHeight() / 2
            );

            grafico.dispose();

            return;
        }

        int margenIzquierdo = 35;
        int margenDerecho = 20;
        int margenSuperior = 45;
        int margenInferior = 35;

        int anchoDisponible =
                getWidth()
                - margenIzquierdo
                - margenDerecho;

        int altoDisponible =
                getHeight()
                - margenSuperior
                - margenInferior;

        int cantidadProductos =
                cantidadesPorProducto.size();

        int espacioProducto =
                anchoDisponible
                / cantidadProductos;

        int anchoBarra =
                Math.min(
                        55,
                        Math.max(
                                18,
                                espacioProducto - 25
                        )
                );

        int mayorCantidad =
                java.util.Collections.max(
                        cantidadesPorProducto.values()
                );

        int lineaBase =
                margenSuperior
                + altoDisponible;

        grafico.setColor(
                new java.awt.Color(
                        190,
                        190,
                        190
                )
        );

        grafico.drawLine(
                margenIzquierdo,
                lineaBase,
                getWidth() - margenDerecho,
                lineaBase
        );

        int posicion = 0;

        for (java.util.Map.Entry<String, Integer>
                producto
                : cantidadesPorProducto.entrySet()) {

            int cantidad =
                    producto.getValue();

            int altoBarra =
                    (int) (
                            (
                                    cantidad
                                    / (double) mayorCantidad
                            )
                            * (
                                    altoDisponible - 20
                            )
                    );

            int centro =
                    margenIzquierdo
                    + (
                            posicion
                            * espacioProducto
                    )
                    + (
                            espacioProducto / 2
                    );

            int x =
                    centro
                    - (
                            anchoBarra / 2
                    );

            int y =
                    lineaBase
                    - altoBarra;

            grafico.setColor(
                    Estilos.VERDE_OSCURO
            );

            grafico.fillRoundRect(
                    x,
                    y,
                    anchoBarra,
                    altoBarra,
                    8,
                    8
            );

            String cantidadTexto =
                    String.valueOf(
                            cantidad
                    );

            grafico.setFont(
                    Estilos.fuente(12f)
            );

            java.awt.FontMetrics medidasCantidad =
                    grafico.getFontMetrics();

            grafico.drawString(
                    cantidadTexto,
                    centro
                    - (
                            medidasCantidad.stringWidth(
                                    cantidadTexto
                            ) / 2
                    ),
                    y - 5
            );

            String nombre =
                    producto.getKey();

            if (nombre.length() > 10) {

                nombre =
                        nombre.substring(
                                0,
                                9
                        )
                        + "…";
            }

            grafico.setFont(
                    Estilos.fuente(11f)
            );

            java.awt.FontMetrics medidasNombre =
                    grafico.getFontMetrics();

            grafico.drawString(
                    nombre,
                    centro
                    - (
                            medidasNombre.stringWidth(
                                    nombre
                            ) / 2
                    ),
                    lineaBase + 18
            );

            posicion++;
        }

        grafico.dispose();
    }
}