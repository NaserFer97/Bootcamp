package com.bootCamp;

import java.util.Scanner;

/*9. Escribe una aplicación con un String que contenga una contraseña cualquiera. Después
se te pedirá que introduzcas la contraseña, con 3 intentos. Cuando aciertes ya no pedirá
mas la contraseña y mostrara un mensaje diciendo “Correcto!”. Piensa bien en la
condición de salida (3 intentos y si acierta sale, aunque le queden intentos, si no acierta
en los 3 intentos mostrar el mensaje “Fallaste jaja!!”).*/
public class Ejercicio09 {
    public static void main(String[] args) {
        String contrasena = "This is my password";
        Scanner Objeto = new Scanner(System.in);
        String userInput = null;
        for (int x = 2; x>=0; x--){
            System.out.println("Introduzca la contrasena ");
            userInput = Objeto.nextLine();
            if (contrasena.equals(userInput)){
                System.out.println("Correcto!");
                break;
            }
            else{
                if (x != 0){System.out.format("Contrasena incorrecta, te queda(n) %d intento(s). \n", x);}
            }
        }
        System.out.println("Fallaste jaja!!");
    }
}