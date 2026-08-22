package estado;

import interfaces.EstadoTurno;
import modelo.Turno;

public class EstadoFinalizado implements EstadoTurno {

    @Override
    public String getNombre() {
        return "FINALIZADO";
    }

    @Override
    public void aplicar(Turno turno) {
        turno.setEstado(this);
    }
}