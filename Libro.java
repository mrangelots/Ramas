public class Libro extends MaterialBiblioteca {
    //Atributos de Libro
    private String autor;
    private String editorial;
    private String isbn;
    private String genero;
    //Iniciamos el constructor junto con super ya que lo heredamos de la clase padre
    public Libro(String idMaterial, String titulo, int anioPublicacion, int noEjemplares,
                 String autor, String editorial, String isbn, String genero) {

        super(idMaterial, titulo, anioPublicacion, noEjemplares);

        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.genero = genero;
    }
    //Metodo para Calcular Multa de Libro
    @Override
    public double calcularMulta(int diasRetraso) {
        double multaPorDia = 5.0;
        return diasRetraso * multaPorDia;
    }
    //Agregamos Getters
    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenero() {
        return genero;
    }

@Override
public String toString() {
    return "Libro -> ID: " + getIdMaterial() +
           ", Titulo: " + getTitulo() +
           ", Autor: " + autor +
           ", Genero: " + genero +
           ", Disponibles: " + getEjemplaresDisponibles();
}
}