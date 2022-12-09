package com.bootCamp;
/*1. Declara dos variables numéricas (con el valor que desees), muestra por consola la
        suma, resta, multiplicación, división y módulo (resto de la división).*/
public class Ejercicio01 {
    public static void main(String[] args) {

        int valor1 = 10;
        int valor2 = 5;
        System.out.format("The sum of %d and %d is: %d\n", valor1, valor2, valor1+valor2);
        System.out.format("The substraction of %d and %d is: %d\n", valor1, valor2, valor1-valor2);
        System.out.format("The multiplication of %d and %d is: %d\n", valor1, valor2, valor1*valor2);
        System.out.format("The division of %d and %d is: %d\n", valor1, valor2, valor1/valor2);
        System.out.format("The module of %d and %d is: %d\n", valor1, valor2, valor1%valor2);
    }
}