import java.util.Scanner; 

public class E1 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(" - - - Suma y Promedio de N números - - -");
        System.out.println("¿Cuántos Números enteros desea ingresar? ");
        int n = sc.nextInt();
        int[] numeros = new int[n]; //<- se crea el arreglo con la longitud que ingresa el usuario "n"
        for (int i = 0; i < n; i++){ //<- ciclo que nos ayuda a repetir las veces que el usuario ingresa los números
            System.out.println("Ingrese el valor " + (i+1) + " :");
            numeros[i] = sc.nextInt(); //<- guardamos los valores en el arreglo
        }
        int suma = 0;
        for (int j = 0; j < n; j++){ //ciclo que nos ayuda a sumar los valores que contiene el arreglo
            suma = suma + numeros[j];
        }
        Double promedio = (double)suma / n;
        System.out.println("La suma de los valores ingresados es: " + suma);
        System.out.println("EL promedio de los valores ingresados es: " + promedio); //Imprimimos los valores de la suma y del promedio
        
        sc.close();
    }
}
