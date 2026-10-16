package modelo;

public class Cliente extends Persona {

    private int idCliente;
    private String nombre;
    private String dni;
    private String telefono;
    private String direccion;
    private String correo;
    private String observaciones;
    private boolean activo = true;

    public Cliente() {
        super(-1);
    }

    public Cliente(int idCliente, String nombre, String dni) {
        super(idCliente);
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Cliente(
            int idCliente,
            String nombre,
            String dni,
            String telefono,
            String direccion,
            String correo,
            String observaciones
    ) {
        super(idCliente);
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.observaciones = observaciones;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String getIdentificacion() {
        return dni;
    }
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}