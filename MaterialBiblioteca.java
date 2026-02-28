public abstract class MaterialBiblioteca {
    //Atributos Base
    private String idMaterial;
    private String titulo;
    private int anioPublicacion;
    private int noEjemplares;
    private int ejemplaresDisponibles;
    //Empezamos el constructor 
    public MaterialBiblioteca(String idMaterial, String titulo, int anioPublicacion, int noEjemplares) {
        this.idMaterial = idMaterial;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.noEjemplares = noEjemplares;
        this.ejemplaresDisponibles = noEjemplares;
    }
    //Metodo para Prestar
    public boolean prestar() {
        if (ejemplaresDisponibles > 0) {
            ejemplaresDisponibles--;
            return true;
        }
        return false;
    }
    //Metodo para Devolver
    public void devolver() {
        if (ejemplaresDisponibles < noEjemplares) {
            ejemplaresDisponibles++;
        }
    }
    //Metodo para Agregar Ejemplares
    public void agregarEjemplares(int cantidad) {
        if (cantidad > 0) {
            noEjemplares += cantidad;
            ejemplaresDisponibles += cantidad;
        }
    }
    //Metodo abstracto
    public abstract double calcularMulta(int diasRetraso);
    //Agregamos Getters
    public String getIdMaterial() {
        return idMaterial;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getNoEjemplares() {
        return noEjemplares;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }
}
