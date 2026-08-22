package estado;

import interfaces.EstadoTurno;
import modelo.Turno;

public class EstadoPendiente implements EstadoTurno {

    @Override
    public String getNombre() {
        return "PENDIENTE";
    }

    @Override
    public void aplicar(Turno turno) {
        turno.setEstado(this);
    }
}