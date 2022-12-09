package bootCampDia2;

import java.util.Scanner;

/*3. Hacer una función que, dada una palabra (String) o frase, diga si la misma es palíndrome o
no. Una palabra/frase palíndrome es aquella que se lee igual tanto de atrás para adelante,
como de adelante para atrás. Ejemplos de palíndromes: "MADAM", "RACECAR", "AMORE,
ROMA", "BORROW OR ROB", "WAS IT A CAR OR A CAT I SAW?".*/
public class Ejercicio03 {
    static boolean esPalindromo(String palabra){
        String palindromo = palabra;
        String invertida = new StringBuilder(palindromo).reverse().toString();
      if(palindromo.equals(invertida)){
          return true;
        }
      else{
          return false;
      }
    }
    public static void main(String[] args) {
        String palabra = null;
        Scanner Objeto = new Scanner(System.in);
        System.out.println("Ingrese una palabra: ");
        palabra = Objeto.nextLine();
        if (esPalindromo(palabra)){
            System.out.println("La palabra es palindrome");
        }
        else{
            System.out.println("La palabra no es palindrome");
        }
    }
}
