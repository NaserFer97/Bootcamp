package bootCampDia2;
import java.util.Scanner;

/*4. Dada una cadena de caracteres (String) de longitud desconocida que tiene solamente dígitos,
        crear un array de N elementos (donde N es el tamaño de la cadena) que tenga cada uno de los
        valores numéricos de los dígitos.*/
public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner Objeto = new Scanner(System.in);
        String cadena = null;
        int entero = 0;
        boolean bandera = true;
        //Se pide de input un numero
        while(bandera){
            System.out.println("Ingrese el numero de longitud que desee");
            cadena = Objeto.nextLine();
            try{
                entero = Integer.parseInt(cadena);
                bandera = false;
            }catch(Exception e){
                System.out.println("Entrada invalida. Por favor ingrese solo numeros.");
                bandera = true;
            }
        }
        //Se anade los numeros al array
        System.out.println("Los valores de la cadena son: ");
        int intArray[] = new int[cadena.length()];
        for (int x=0; x<cadena.length(); x++){
            intArray[x]=Character.getNumericValue(cadena.charAt(x));
        }
        for(int x=0; x<cadena.length(); x++){
            System.out.printf(intArray[x] + " ");
        }
    }
}
