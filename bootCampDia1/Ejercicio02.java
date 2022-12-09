package com.bootCamp;
import java.util.*;
/*2. Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos.
        Si son iguales indicarlo también. Ves cambiando los valores para comprobar que funciona.*/
public class Ejercicio02 {
    public static void main(String[] args) {
        String valor1 = null;
        Boolean esInt1 = true;
        Boolean esInt2 = true;
        int Entero1 = 0;
        int Entero2 = 0;
        String valor2 = null;
        Scanner Objeto = new Scanner(System.in);
        do{
            try{System.out.println("Ingrese el primer numero: ");
                valor1 = Objeto.nextLine();
                Entero1 = Integer.parseInt(valor1);
                esInt1 = true;
            }
            catch(Exception e){
                esInt1 = false;
            }
            try{System.out.println("Ingrese el segundo numero: ");
                valor2 = Objeto.nextLine();
                Entero2 = Integer.parseInt(valor2);
                esInt2 = true;
            }
            catch(Exception e){
                esInt2 = false;
            }
            if (esInt1 == false){
                System.out.println("El primer numero no es valido.");
            }
            if (esInt2 == false){
                System.out.println("El segundo numero no es valido.");
            }
        }while(esInt1 == false || esInt2 == false);
                if (Entero1 > Entero2) {
                    System.out.format("El valor mayor es: %d", Entero1);
                } else {
                    System.out.format("El valor mayor es: %d", Entero2);
                }
            }
        }
