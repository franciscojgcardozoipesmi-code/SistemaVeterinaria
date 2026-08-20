package modelo;

public class ProcedimientoMedico {

    private int idProcedimiento;
    private String tipo;
    private boolean emergencia;
    private double monto;
    private int idAnimal;

    public ProcedimientoMedico() {
    }

    public ProcedimientoMedico(int idProcedimiento,
                               String tipo,
                               boolean emergencia,
                               double monto,
                               int idAnimal) {

        this.idProcedimiento = idProcedimiento;
        this.tipo = tipo;
        this.emergencia = emergencia;
        this.monto = monto;
        this.idAnimal = idAnimal;
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
}