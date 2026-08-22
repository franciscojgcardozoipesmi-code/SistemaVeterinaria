package factory;

import estado.EstadoCancelado;
import estado.EstadoEnAtencion;
import estado.EstadoFinalizado;
import estado.EstadoPendiente;
import estado.EstadoVencido;
import interfaces.EstadoTurno;

public class EstadoTurnoFactory {

    public static EstadoTurno crearEstado(String nombre) {

        if (nombre == null) {
            return new EstadoPendiente();
        }

        switch (nombre) {

            case "EN ATENCIÓN":
                return new EstadoEnAtencion();

            case "FINALIZADO":
                return new EstadoFinalizado();

            case "CANCELADO":
                return new EstadoCancelado();

            case "PENDIENTE":
            default:
                return new EstadoPendiente();
            case "VENCIDO":
                return new EstadoVencido();
        }
    }
}