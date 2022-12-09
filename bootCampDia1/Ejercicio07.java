package com.bootCamp;
import java.util.Scanner;
//7. Muestra los números del 1 al 100 (ambos incluidos) divisibles entre 2 y 3.
public class Ejercicio07 {
    public static void main(String[] args) {
        System.out.println("Numeros divisibles por 2 y 3");
        for (int x = 0; x<=100; x++){
            System.out.println(x);
            if (x%2== 0 && x%3 ==0)
            {
                System.out.printf(x +" ");
            }
        }
    }
}
