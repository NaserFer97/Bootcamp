package bootcampDia6;
import java.util.*;

public class Poker {
    private final HashMap<String, Integer> hashPoker = new HashMap<>();
    private final String[] valoresNumericos = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
    private final String[] palos = {"S","C","H","D"};
    private final String[] cartas = {"", "", "", "", ""};
    private int mayorOcurrencia = 0;
    private String mayorValor = null;

    private void getRandom() {
        Random random = new Random();
        String cartaGenerada;
        int cartasGeneradas =0;
        do {
            boolean flag = false;
            int indexNumerico = random.nextInt(13);
            int indexPalos = random.nextInt(4);
            cartaGenerada = String.format("%s%s", valoresNumericos[indexNumerico], palos[indexPalos]);
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
        if (escaleraColor()){
            return "ESCALERA COLOR";
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
        else{return "CARTA ALTA";}
    }
    private int checkMayorValor(){
        for (int x =0; x<5; x++) {
            int contador =0;
            for (int j = 0; j<5; j++){
                if (Objects.equals(String.valueOf(cartas[x].charAt(0)), String.valueOf(cartas[j].charAt(0)))){
                    contador++;
                }
            }
            if (contador>mayorOcurrencia){
                mayorOcurrencia = contador;
                mayorValor = String.valueOf(cartas[x].charAt(0));
            }
        }
        return mayorOcurrencia;
    }
    private boolean poker(){
        if(checkMayorValor()==4) {
            String[] poker = new String[4];
            for (int x = 0; x < 5; x++) {
                if (Objects.equals(String.valueOf(cartas[x].charAt(0)), mayorValor)) {
                    poker[x] = String.valueOf(cartas[x].charAt(1));
                }
            }
            for (int x=0; x<4; x++) {
                for (int j = x+1; j < 4; j++) {
                    if (Objects.equals(poker[x], poker[j])) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    private boolean fullHouse() {
        return hashPoker.containsValue(3) && hashPoker.containsValue(2);
    }
    private boolean par(){
        int contador = 0;
        for (int i : hashPoker.values()){
            if (i == 2){
                contador++;
            }
        }
        return contador == 1;
    }
    private void hashPoker() {
        for (int x = 0; x < 5; x++) {
            if (hashPoker.containsKey(cartas[x])) {
                hashPoker.put(cartas[x], hashPoker.get(cartas[x]) + Integer.parseInt("1"));
            } else {
                hashPoker.put(cartas[x], 1);
            }
        }
    }
    private boolean tercia(){
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
    private boolean escaleraColor() {
        int index1 = -1;
        int index2 = -1;
        //check si los palos son iguales
        for (int x = 0; x < 4; x++) {
            String carta = cartas[x];
            String cartaSiguiente = cartas[x + 1];
            if (!String.valueOf(carta.charAt(1)).equals(String.valueOf(cartaSiguiente.charAt(1)))){
                return false;
            }
        }
        //Verificar que A este en la posicion 0 o la ultima.
        if (!String.valueOf(cartas[0].charAt(0)).equals("A") && !String.valueOf(cartas[4].charAt(0)).equals("A")) {
            return false;
        }
        for (int x = 0; x < 4; x++){
            String carta = cartas[x];
            String cartaSiguiente = cartas[x + 1];
            for (int i = 0; i < 13; i++) {
                if (String.valueOf(carta.charAt(0)).equals(valoresNumericos[i])){
                    index1 = i;
                }
                if (String.valueOf(cartaSiguiente.charAt(0)).equals(valoresNumericos[i])){
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
