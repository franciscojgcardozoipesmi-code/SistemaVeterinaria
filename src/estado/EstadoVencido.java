package estado;

import interfaces.EstadoTurno;
import modelo.Turno;

public class EstadoVencido implements EstadoTurno {

    @Override
    public String getNombre() {
        return "VENCIDO";
    }

    @Override
    public void aplicar(Turno turno) {
        turno.setEstado(this);
    }
}