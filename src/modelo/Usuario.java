package modelo;

public class Usuario extends Persona {

    private int idUsuario;
    private String usuario;
    private String password;
    private String rol;
    private String correo;

    public Usuario() {
        super(-1);
    }

    public Usuario(int idUsuario, String usuario, String password) {
        super(idUsuario);
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        setId(idUsuario);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getIdentificacion() {
        return usuario;
    }
    
        public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}