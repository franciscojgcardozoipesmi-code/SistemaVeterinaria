package interfaces;

import modelo.Turno;

public interface EstadoTurno {

    String getNombre();

    void aplicar(Turno turno);
}