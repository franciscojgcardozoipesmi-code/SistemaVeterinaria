package modelo;

public class ProcedimientoMedico {

    private int idProcedimiento;
    private String tipo;
    private boolean emergencia;
    private double monto;
    private int idAnimal;
    private String fecha;
    private String descripcion;
    private String animal;
    private boolean activo;
    public ProcedimientoMedico() {
    }

    public ProcedimientoMedico(int idProcedimiento,
                           String tipo,
                           boolean emergencia,
                           double monto,
                           int idAnimal,
                           String fecha,
                           String descripcion,
                           boolean activo) {

        this.idProcedimiento = idProcedimiento;
        this.tipo = tipo;
        this.emergencia = emergencia;
        this.monto = monto;
        this.idAnimal = idAnimal;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEmergencia() {
        return emergencia;
    }

    public void setEmergencia(boolean emergencia) {
        this.emergencia = emergencia;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}