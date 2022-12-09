package com.bootCamp;
import java.sql.SQLOutput;
import java.util.Scanner;
/*5. Lee un número por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es,
        también debemos indicarlo.*/
public class Ejercicio05 {
    public static void main(String[] args) {
        String numero = null;
        int entero = 0;
        Scanner Objeto = new Scanner(System.in);
        Boolean flag = false;
        while (flag == false){
            System.out.println("Ingrese numero: ");
            numero = Objeto.nextLine();
            try {
                entero = Integer.parseInt(numero);
                flag = true;
            } catch (NumberFormatException ex) {
                flag = false;
            }
        }
        if (entero%2 == 0){
            System.out.println("El numero es divisible entre 2.");
        }
        else{
            System.out.println("El numero no es divisible entre 2.");
        }
    }
}
