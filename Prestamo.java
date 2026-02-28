public class Prestamo {
    //Atributos de Prestamo
    private Usuario usuario;
    private MaterialBiblioteca material;
    private String fechaPrestamo;
    private boolean activo;

    // Constructor de Prestamo 
    public Prestamo(Usuario usuario, MaterialBiblioteca material, String fechaPrestamo) {
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.activo = true;
    }

    // Metodo para devolver material y calcular multa
    public double devolverMaterial(int diasRetraso) {
        this.activo = false;

        if (diasRetraso > 0) {
            return material.calcularMulta(diasRetraso);
        }

        return 0;
    }

    // Getters
    public Usuario getUsuario() {
        return usuario;
    }

    public MaterialBiblioteca getMaterial() {
        return material;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Prestamo -> Usuario: " + usuario.getIdUsuario() +
               ", Material: " + material.getIdMaterial() +
               ", Fecha: " + fechaPrestamo +
               ", Activo: " + activo;
    }
}