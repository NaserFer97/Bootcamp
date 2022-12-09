package bootcampDia4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Nim {
    private String pila = null;
    private String quitarPila = null;
    private boolean finDelJuego = false;

    //Getters y Setters
    public String getPila() {
        return pila;
    }

    public void setPila(String pila) {
        this.pila = pila;
    }

    public String getQuitarPila() {
        return quitarPila;
    }

    public void setQuitarPila(String quitarPila) {
        this.quitarPila = quitarPila;
    }

    public boolean isFinDelJuego() {
        return finDelJuego;
    }

    public void setFinDelJuego(boolean finDelJuego) {
        this.finDelJuego = finDelJuego;
    }
    //Objeto Hashmap para los valores del juego
    HashMap<String, Integer> Pilas= new HashMap<String, Integer>();
    Nim(){
        //Anadir llaves y valores
        Pilas.put("A", 3);
        Pilas.put("B", 3);
        Pilas.put("C", 3);
    }
    public void turno(String nombre){
        Scanner Objeto = new Scanner(System.in);
        //Bucle hasta que se coloque una pila no vacia
            try{
                do{
                    System.out.println(nombre + ", elija una pila: ");
                    pila = Objeto.nextLine();
                    if(Pilas.get(pila)==0){
                        System.out.println("La pila se encuentra vacia! prueba con otra pila.");
                        System.out.println(nombre + ", elija una pila: ");
                        pila = Objeto.nextLine();
                    }
                }while(Pilas.get(pila)==0);
            }catch(Exception e){
                do{
                    System.out.println(nombre + ", elija una pila: ");
                    pila = Objeto.nextLine();
                    if(Pilas.get(pila)==0){
                        System.out.println("La pila se encuentra vacia! prueba con otra pila.");
                        System.out.println(nombre + ", elija una pila: ");
                        pila = Objeto.nextLine();
                    }
                }while(Pilas.get(pila)==0);
            }
        try{
            do {
                System.out.println("Cuantos quitara de la pila "+ pila + ": ");
                quitarPila = Objeto.nextLine();
                if(Pilas.get(pila) < Integer.parseInt(quitarPila)){
                    System.out.println("La cantidad que quiere quitar es mayor a los numeros almacenados en la pila! Pruebe con otra cantidad.");
                    System.out.println("Cuantos quitara de la pila "+ pila + ": ");
                    quitarPila = Objeto.nextLine();
                }
            }while (Pilas.get(pila) < Integer.parseInt(quitarPila));
            //Bucle hasta que se coloque un numero valido dentro del rango
            }catch(Exception e){
            do {
                System.out.println("Cuantos quitara de la pila "+ pila + ": ");
                quitarPila = Objeto.nextLine();
                if(Pilas.get(pila) < Integer.parseInt(quitarPila)){
                    System.out.println("La cantidad que quiere quitar es mayor a los numeros almacenados en la pila! Pruebe con otra cantidad.");
                    System.out.println("Cuantos quitara de la pila "+ pila + ": ");
                    quitarPila = Objeto.nextLine();
                }
            }while (Pilas.get(pila) < Integer.parseInt(quitarPila));
        }
            jugador(pila, quitarPila);
        }
    //Retornar True si todas las pilas estan vacias
    public void Ganador(){
        if(Pilas.get("A") == 0 && Pilas.get("B") == 0 && Pilas.get("C") == 0)
        {finDelJuego = true;}
    }
    public void jugador(String pila, String quitarPila){
        Pilas.put(pila, Pilas.get(pila)-Integer.parseInt(quitarPila));
        Ganador();
    }
    public void imprimirHashMap(){
        System.out.println("A: " + Pilas.get("A") +"    B: " + Pilas.get("B") + "   C: " + Pilas.get("C"));
    }
    public static void main(String[] args) {
        Nim Juego = new Nim();
        //Nombre de jugadores
        String jugador1 = "";
        String jugador2 = "";
        Scanner Objeto = new Scanner(System.in);
        System.out.println("Jugador 1, ingrese su nombre: ");
        jugador1 = Objeto.nextLine();
        System.out.println("Jugador 2, ingrese su nombre: ");
        jugador2 = Objeto.nextLine();
        while(!Juego.isFinDelJuego()){
            Juego.turno(jugador1);
            Juego.imprimirHashMap();
            if(Juego.isFinDelJuego()){
                {System.out.println(jugador1 + ", ya no quedan contadores, asi que... Ganaste!");
                break;}}
            Juego.turno(jugador2);
            Juego.imprimirHashMap();
            if(Juego.isFinDelJuego()){
                {System.out.println(jugador2 + ", ya no quedan contadores, asi que... Ganaste!");
                break;}}
        }
    }
}