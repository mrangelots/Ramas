public class Comic extends MaterialBiblioteca {
    //Atributos de Comic
    private String autor;
    private String ilustrador;
    private String editorial;
    private String universo;
    //Iniciamos el constructor junto con super ya que lo heredamos de la clase padre
    public Comic(String idMaterial, String titulo, int anioPublicacion, int noEjemplares,
                 String autor, String ilustrador, String editorial, String universo) {

        super(idMaterial, titulo, anioPublicacion, noEjemplares);

        this.autor = autor;
        this.ilustrador = ilustrador;
        this.editorial = editorial;
        this.universo = universo;
    }
    //Metodo para Calcular Multa de Comic
    @Override
    public double calcularMulta(int diasRetraso) {
        double multaPorDia = 4.0;
        return diasRetraso * multaPorDia;
    }
    //Agreamos Getters
    public String getAutor() {
        return autor;
    }

    public String getIlustrador() {
        return ilustrador;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getUniverso() {
        return universo;
    }

@Override
public String toString() {
    return "Comic -> ID: " + getIdMaterial() +
           ", Titulo: " + getTitulo() +
           ", Autor: " + autor +
           ", Universo: " + universo +
           ", Disponibles: " + getEjemplaresDisponibles();
}
}
