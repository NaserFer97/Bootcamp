package bootCampDia2;
import java.util.Random;
import java.util.*;
/*1. Cargar un array de manera aleatoria con 10 números enteros del -5 al 5. Imprimirlo en
pantalla y computar cuál es el mayor elemento del vector.*/
public class Ejercicio01 {
    public static void main(String[] args) {
        int min = -5;
        int max = 5;
        int intArray[] = new int[10];
        Random random = new Random();
        int mayorNumero= 0;
        for (int x =0; x<10; x++){
            intArray[x]= random.nextInt(max - min) + min;
            System.out.printf(intArray[x] + " ");
            if (x==0){
                mayorNumero = intArray[x];
            }
            else if (mayorNumero<intArray[x]){
                mayorNumero = intArray[x];
            }
        }
        System.out.println("El mayor numero es " + mayorNumero);
    }
}
