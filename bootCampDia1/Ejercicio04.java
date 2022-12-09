package com.bootCamp;
import java.util.Scanner;
/*4. Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir.*/
public class Ejercicio04 {
    public static void main(String[] args) {
        String nombre = null;
        Scanner Objeto = new Scanner(System.in);
        System.out.println("Cual es tu nombre?");
        nombre = Objeto.nextLine();
        System.out.format("Bienvenido %s!", nombre);
    }
}
