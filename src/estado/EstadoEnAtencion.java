package estado;

import interfaces.EstadoTurno;
import modelo.Turno;

public class EstadoEnAtencion implements EstadoTurno {

    @Override
    public String getNombre() {
        return "EN ATENCIÓN";
    }

    @Override
    public void aplicar(Turno turno) {
        turno.setEstado(this);
    }
}