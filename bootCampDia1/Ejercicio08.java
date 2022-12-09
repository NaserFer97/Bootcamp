package com.bootCamp;
import java.util.Scanner;
/*8. Lee un número por teclado y comprueba que este numero es mayor o igual que cero, si
        no lo es lo volverá a pedir (do while), después muestra ese número por consola.*/
public class Ejercicio08 {
    public static void main(String[] args) {
        int numero =0;
        Scanner Objeto = new Scanner(System.in);
        do{
            System.out.print("Ingrese un numero");
            numero = Objeto.nextInt();
            if (numero>=0){
                System.out.println("El numero que has seleccionado es: " + numero);
            }
            else{
                System.out.println("El numero no es valido.");
            }
        }while(numero <=0);
    }
}