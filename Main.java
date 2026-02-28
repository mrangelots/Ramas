import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion = 0;

        do {
            //Menú del Sistema 2
            System.out.println("\n===== SISTEMA DE GESTION BIBLIOTECA =====");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Eliminar");
            System.out.println("4. Generar Reporte");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada invalida. Debe ingresar un numero.");
                sc.nextLine();
                opcion = -1;
                continue;
            }

            sc.nextLine();

            switch (opcion) {

                // ================= REGISTRAR =================
                case 1:
                    System.out.println("\n1. Usuario");
                    System.out.println("2. Libro");
                    System.out.println("3. Revista");
                    System.out.println("4. Comic");
                    System.out.println("5. Prestamo");
                    System.out.print("Seleccione una opcion: ");

                    int opReg = sc.nextInt();
                    sc.nextLine();

                    switch (opReg) {

                        case 1:
                            System.out.print("ID: ");
                            String id = sc.nextLine();

                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();

                            System.out.print("Apellido: ");
                            String apellido = sc.nextLine();

                            System.out.print("Correo: ");
                            String correo = sc.nextLine();

                            System.out.print("Telefono: ");
                            String telefono = sc.nextLine();

                            biblioteca.registrarUsuario(id, nombre, apellido, correo, telefono);
                            break;

                        case 2:
                            try {
                                System.out.print("ID: ");
                                String idLibro = sc.nextLine();

                                System.out.print("Titulo: ");
                                String titulo = sc.nextLine();

                                System.out.print("Año: ");
                                int anio = sc.nextInt();

                                System.out.print("Numero de ejemplares: ");
                                int ejemplares = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Autor: ");
                                String autor = sc.nextLine();

                                System.out.print("Editorial: ");
                                String editorial = sc.nextLine();

                                System.out.print("ISBN: ");
                                String isbn = sc.nextLine();

                                System.out.print("Genero: ");
                                String genero = sc.nextLine();

                                biblioteca.registrarLibro(idLibro, titulo, anio, ejemplares, autor, editorial, isbn, genero);

                            } catch (Exception e) {
                                System.out.println("Error en los datos numericos.");
                                sc.nextLine();
                            }
                            break;

                        case 3:
                            try {
                                System.out.print("ID: ");
                                String idRev = sc.nextLine();

                                System.out.print("Titulo: ");
                                String tituloRev = sc.nextLine();

                                System.out.print("Año: ");
                                int anioRev = sc.nextInt();

                                System.out.print("Numero ejemplares: ");
                                int ejRev = sc.nextInt();

                                System.out.print("Numero edicion: ");
                                int numEd = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Editorial: ");
                                String editorialRev = sc.nextLine();

                                System.out.print("Periodicidad: ");
                                String periodicidad = sc.nextLine();

                                biblioteca.registrarRevista(idRev, tituloRev, anioRev, ejRev, editorialRev, numEd, periodicidad);

                            } catch (Exception e) {
                                System.out.println("Error en los datos numericos.");
                                sc.nextLine();
                            }
                            break;

                        case 4:
                            try {
                                System.out.print("ID: ");
                                String idComic = sc.nextLine();

                                System.out.print("Titulo: ");
                                String tituloComic = sc.nextLine();

                                System.out.print("Año: ");
                                int anioComic = sc.nextInt();

                                System.out.print("Numero ejemplares: ");
                                int ejComic = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Autor: ");
                                String autorComic = sc.nextLine();

                                System.out.print("Ilustrador: ");
                                String ilustrador = sc.nextLine();

                                System.out.print("Editorial: ");
                                String editorialComic = sc.nextLine();

                                System.out.print("Universo: ");
                                String universo = sc.nextLine();

                                biblioteca.registrarComic(idComic, tituloComic, anioComic, ejComic, autorComic, ilustrador, editorialComic, universo);

                            } catch (Exception e) {
                                System.out.println("Error en los datos numericos.");
                                sc.nextLine();
                            }
                            break;

                        case 5:
                            System.out.print("ID Usuario: ");
                            String idUser = sc.nextLine();

                            System.out.print("ID Material: ");
                            String idMat = sc.nextLine();

                            System.out.print("Fecha: ");
                            String fecha = sc.nextLine();

                            biblioteca.realizarPrestamo(idUser, idMat, fecha);
                            break;

                        default:
                            System.out.println("Opcion invalida.");
                    }
                    break;

                // ================= CONSULTAR =================
                case 2:
                    System.out.println("\n1. Usuarios");
                    System.out.println("2. Materiales");
                    System.out.println("3. Prestamos");
                    System.out.print("Seleccione: ");

                    int opCons = sc.nextInt();
                    sc.nextLine();

                    switch (opCons) {
                        case 1:
                            biblioteca.mostrarUsuarios();
                            break;
                        case 2:
                            biblioteca.mostrarMateriales();
                            break;
                        case 3:
                            biblioteca.mostrarPrestamos();
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                    }
                    break;

                // ================= ELIMINAR =================
                case 3:
                    System.out.println("\n1. Usuario");
                    System.out.println("2. Material");
                    System.out.println("3. Prestamo");
                    System.out.print("Seleccione: ");

                    int opElim = sc.nextInt();
                    sc.nextLine();

                    switch (opElim) {
                        case 1:
                            System.out.print("ID Usuario: ");
                            biblioteca.eliminarUsuario(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("ID Material: ");
                            biblioteca.eliminarMaterial(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("ID Usuario: ");
                            String u = sc.nextLine();
                            System.out.print("ID Material: ");
                            String m = sc.nextLine();
                            biblioteca.eliminarPrestamo(u, m);
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                    }
                    break;

                // ================= REPORTE =================
                case 4:
                    biblioteca.generarReporte();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}