package estado;

import interfaces.EstadoTurno;
import modelo.Turno;

public class EstadoCancelado implements EstadoTurno {

    @Override
    public String getNombre() {
        return "CANCELADO";
    }

    @Override
    public void aplicar(Turno turno) {
        turno.setEstado(this);
    }
}