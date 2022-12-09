package bootCampDia2;
import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Arrays;
/*2. Cargar un array de manera aleatoria con 100 números enteros del -30 al 30. Imprimirlo en
pantalla y computar cuál es el elemento que más veces se repite, y cuáles son los números
que no están presentes (si es que hay alguno).*/
public class Ejercicio02 {
    public static void main(String[] args) {
        int intArray[] = new int[100];
        int min=-30;
        int max=30;
        int contadorMasAlto = 0;
        int mayorFrecuencia = 0;
        Random random = new Random();
        //Generar la lista con los numeros random
        System.out.println("La lista es:");
        for (int x=0; x<100; x++){
            intArray[x]=random.nextInt(max-min)+min;
            System.out.printf(intArray[x]+ " ");
        }
        //Saber elementos que no estan presentes
        System.out.println("\nLos numeros que no estan en la lista son: ");
        for (int x=0; x<100; x++){
            int finalX = x;
            if(!Arrays.stream(intArray).anyMatch(i -> i == finalX)){
                System.out.printf(finalX+" ");
            };
        }
        //Saber cual es el elemento que mas se repite
        for (int x =0; x<100; x++){
            int count = 0;
            for (int j=0; j<100; j++){
                if (intArray[x]==intArray[j])
                {
                    count++;
                }
            }
            if (count>contadorMasAlto){
                contadorMasAlto = count;
                mayorFrecuencia = intArray[x];
            }
        }
        System.out.println("\nEl numero que mas se repite en la lista es "+mayorFrecuencia);
        System.out.println();

    }
}
