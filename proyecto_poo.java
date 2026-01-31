import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class proyecto_poo {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" - - - Menú - - - ");
            System.out.println("Bievenido" + "\n" + "1. Registrar" + "\n" + "2. Consultar" + "\n" + "3. Modificar" + "\n" + "4. Eliminar" + "\n" + "5. Generar reporte" + "\n" + "6. Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n"+ " - - - Registrar - - - ");
                    System.out.println("1. Usuario" + "\n" + "2. Libro" + "\n" + "3. Prestamo" + "\n" + "¿Que opcion desea?");
                    break;
                
                case 2:
                    System.out.println(" - - - Consultar - - - ");
                    System.out.println("1. Usuario" + "\n" + "2. Libro" + "\n" + "3. Prestamo" + "\n" + "¿Que opcion desea?");
                    break;
                
                case 6:
                    System.out.println("Hasta luego");
                    break;
                    
                default:
                    break;
            }
        }
    }
}
//comentario para que git me lo suba a la rama 
