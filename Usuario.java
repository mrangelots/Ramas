public class Usuario {
    //Atributos de Usuario
    private String idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    //Empezamos el constructor
    public Usuario(String idUsuario, String nombre, String apellido, String correo, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    //Empezamos con los getters
    public String getIdUsuario(){
        return idUsuario;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getCorreo(){
        return correo;
    }
    public String getTelefono(){
        return telefono;
    }

    //Empezamos Setters
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
@Override
public String toString() {
    return "Usuario -> ID: " + idUsuario +
           ", Nombre: " + nombre +
           ", Apellido: " + apellido +
           ", Correo: " + correo +
           ", Telefono: " + telefono;
}
}
