package modelo;

public class Turno {

    private int idTurno;
    private int idAnimal;
    private String dueno;
    private String dni;
    private String animal;
    private String fecha;
    private String hora;
    private String motivo;

    public Turno() {
    }

    public Turno(int idTurno, String dueno, String dni,
             int idAnimal, String animal, String fecha,
             String hora, String motivo) {

        this.idTurno = idTurno;
        this.dueno = dueno;
        this.dni = dni;
        this.animal = animal;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idAnimal = idAnimal;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
}