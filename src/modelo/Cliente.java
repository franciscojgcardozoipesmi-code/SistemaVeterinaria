package modelo;

public class Cliente extends Persona {

    private int idCliente;
    private String nombre;
    private String dni;

    public Cliente() {
        super(-1);
    }

    public Cliente(int idCliente, String nombre, String dni) {
        super(idCliente);
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        setId(idCliente);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getIdentificacion() {
        return dni;
    }
}