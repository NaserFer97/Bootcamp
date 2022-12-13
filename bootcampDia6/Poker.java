package bootcampDia6;
import java.util.*;

public class Poker {
    private final HashMap<String, Integer> hashPoker = new HashMap<>();
//    private final String[] valoresNumericos = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
    private final String valoresNumericos = "A23456789TJQK";
    private final String[] palos = {"S","C","H","D"};
    private final String[] cartas = {"", "", "", "", ""};
    private int mayorOcurrencia = 0;
    private String mayorValor = null;
    private int[] indice = new int[5];

    private void getRandom() {
        //Generar un numero random con elementos de Numerico y Palos.
        Random random = new Random();
        String cartaGenerada;
        int cartasGeneradas =0;
        do {
            boolean flag = false;
            int indexNumerico = random.nextInt(13);
            int indexPalos = random.nextInt(4);
            cartaGenerada = String.format("%s%s", valoresNumericos.charAt(indexNumerico), palos[indexPalos]);
            for (int x = 0; x<5; x++) {
                if (cartas[x].equals(cartaGenerada)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                cartas[cartasGeneradas] = cartaGenerada;
                cartasGeneradas++;
            }
        } while (cartasGeneradas < 5);
        hashPoker();
    }
    private String checkClase(){
        if (escalera() && color()){
            return "ESCALERA COLOR";
        }
        if (escalera()){
            return "ESCALERA";
        }
        if (color()){
            return "COLOR";
        }
        if (poker()){
            return "POKER";
        }
        if (fullHouse()){
            return "FULL HOUSE";
        }
        if (par()){
            return "PAR";
        }
        if (parDoble()){
            return "PAR DOBLE";
        }
        if (tercia()){
            return "TERCIA";
        }
        else{
            return cartaAlta();
        }
    }


    public String cartaAlta() {
        if (as()) {
            if (cartas[0].charAt(0) == 'A') {
                mayorValor = cartas[0];
                return "CARTA ALTA: "+mayorValor;
            } else if (cartas[4].charAt(0) == 'A') {
                mayorValor = cartas[4];
                return "CARTA ALTA: "+mayorValor;
            }
        }
        for (int x = 0; x < 5; x++) {
            indice[x] = valoresNumericos.indexOf(cartas[x].charAt(0));
        }
        Arrays.sort(indice);
        for (int x = 0; x < 5; x++) {
            if (cartas[x].charAt(0) ==  valoresNumericos.charAt(indice[4])) {
                return "CARTA ALTA: "+cartas[x];
            }
        }
        return "";
    }
    private boolean color(){
        for (int x = 0; x < 4; x++) {
            String carta = cartas[x];
            String cartaSiguiente = cartas[x + 1];
            if (!String.valueOf(carta.charAt(1)).equals(String.valueOf(cartaSiguiente.charAt(1)))){
                return false;
            }
        }
        return true;
    }
    private int checkMayorValor(){
        //Chequear cuantas veces se repite un numerico dentro de la baraja.
        for (int x =0; x<5; x++) {
            int contador =0;
            String numericoActual = String.valueOf(cartas[x].charAt(0));
            for (int j = 0; j<5; j++){
                String numericoSiguiente = String.valueOf(cartas[j].charAt(0));
                if (Objects.equals(numericoActual, numericoSiguiente)){
                    contador++;
                }
            }
            if (contador>mayorOcurrencia){
                mayorOcurrencia = contador;
                mayorValor = numericoActual;
            }
        }
        return mayorOcurrencia;
    }
    private boolean poker(){
        //Verificar si hay una llave tiene 4 como valor.
        return hashPoker.containsValue(4);
    }
    private boolean fullHouse() {
        //Es Fullhouse si una llave tiene 3 como valor y otra llave tiene 2 como valor.
        return hashPoker.containsValue(3) && hashPoker.containsValue(2);
    }
    private boolean par(){
        //Es par si dos llaves tienen 2 como valor.
        int contador = 0;
        for (int i : hashPoker.values()){
            if (i == 2){
                contador++;
            }
        }
        return contador == 1;
    }
    private void hashPoker() {
        //Pasar los valores numericos a un hashmap.
        for (int x = 0; x < 5; x++) {
            String numerico = String.valueOf(cartas[x].charAt(0));
            if (hashPoker.containsKey(numerico)) {
                hashPoker.put(numerico, hashPoker.get(numerico) + Integer.parseInt("1"));
            } else {
                hashPoker.put(numerico, 1);
            }
        }
    }
    private boolean tercia(){
        //Es tercia si hay una llave con 3 como valor.
        int contador = 0;
        for (int i : hashPoker.values()){
            if (i == 3){
                contador++;
            }
        }
        return contador == 1;
    }
    private boolean parDoble(){
        int contador = 0;
        for (int i : hashPoker.values()){
            if (i == 2){
                contador++;
            }
        }
        return contador == 2;
    }
    private boolean as(){
        return cartas[0].charAt(0) == 'A' || cartas[4].charAt(0) == 'A';
    }
    private boolean escalera() {
        int index1 = -1;
        int index2 = -1;
        //Verificar que A este en la posicion 0 o la ultima. Si no esta en esas posiciones, retornar false.
        if (hashPoker.containsKey("A")){
        if (!String.valueOf(cartas[0].charAt(0)).equals("A") && !String.valueOf(cartas[4].charAt(0)).equals("A")) {
            return false;
        }}
        for (int x = 0; x < 4; x++){
            String carta = cartas[x];
            String cartaSiguiente = cartas[x + 1];
            for (int i = 0; i < 13; i++) {
                if (carta.charAt(0) == valoresNumericos.charAt(i)){
                    index1 = i;
                }
                if (cartaSiguiente.charAt(0) == valoresNumericos.charAt(i)){
                    index2 = i;
                }
            }
            if(index1 == 12 && index2 == 0){
                return true;
            }
            if (index1 != index2 - 1) {
                return false;
            }
        }
            return true;
        }
    public static void main(String[] args) {
            Poker p = new Poker();
            p.getRandom();
            System.out.println(Arrays.toString(p.cartas));
            System.out.println(p.checkClase());
    }
}
