package com.bootCamp;

import java.util.Scanner;

/*10. Crea una aplicación que nos pida un día de la semana y que nos diga si es un dia
laboral o no (“De lunes a viernes consideramos dias laborales”).*/
public class Ejercicio10 {
    public static void main(String[] args) {
        String dia = null;
        Scanner Objeto = new Scanner(System.in);
        String resp = null;
        while (true){
            System.out.println("Introduzca dia de la semana");
            dia = Objeto.nextLine();
            dia = dia.toLowerCase();
            switch(dia)
            {
                case "lunes":
                case "martes":
                case "miercoles":
                case "jueves":
                case "viernes":
                    System.out.println("El dia viernes es un dia laboral.");
                    break;
                case "domingo":
                    System.out.println("El dia domingo no es un dia laboral.");
                    break;
                default:
                    System.out.println("Valor incorrecto.");
            }
            System.out.println("Desea continuar? Y/N");
            resp = Objeto.nextLine();
            if (resp.toLowerCase().equals("n")){
                System.out.println("Gracias por usar el programa.");
                break;
            }
        }
    }
}
