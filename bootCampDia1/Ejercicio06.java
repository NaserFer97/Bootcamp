package com.bootCamp;
/*6. Lee un número por teclado que pida el precio de un producto (puede tener
decimales) y calcule el precio final con IVA. El IVA sera una constante que sera del
10%.*/

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Boolean flag = true;
        final int IVA = 10;
        String numero = null;
        float flotante = 0;
        Scanner Objeto = new Scanner(System.in);
        while (flag == true){
            System.out.println("Ingrese el precio de un producto");
            numero = Objeto.nextLine();
            try{
                flotante = Float.parseFloat(numero);
                flag = false;
            }catch(Exception e){
                System.out.println("El valor es invalido. Vuelva a intentarlo\n");
            }
    }
        System.out.format("El precio final del producto con %d porciento de IVA es %f guaranies.", IVA, flotante-(flotante*(float)IVA)/100);
    }
}