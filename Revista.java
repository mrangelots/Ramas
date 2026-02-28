public class Revista extends MaterialBiblioteca {
    //Atributos de Revista
    private String editorial;
    private int numeroEdicion;
    private String periodicidad;
    //Iniciamos el constructor junto con super ya que lo heredamos de la clase padre
    public Revista(String idMaterial, String titulo, int anioPublicacion, int noEjemplares,
                   String editorial, int numeroEdicion, String periodicidad) {

        super(idMaterial, titulo, anioPublicacion, noEjemplares);

        this.editorial = editorial;
        this.numeroEdicion = numeroEdicion;
        this.periodicidad = periodicidad;
    }
    //Metodo para Calcular Multa de Revista
    @Override
    public double calcularMulta(int diasRetraso) {
        double multaPorDia = 3.0;
        return diasRetraso * multaPorDia;
    }
    //Agregamos Getters
    public String getEditorial() {
        return editorial;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

@Override
public String toString() {
    return "Revista -> ID: " + getIdMaterial() +
           ", Titulo: " + getTitulo() +
           ", Editorial: " + editorial +
           ", Edicion: " + numeroEdicion +
           ", Disponibles: " + getEjemplaresDisponibles();
}
}