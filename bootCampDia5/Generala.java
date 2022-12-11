import java.util.*;
public class Generala
{
    // ESTA ES LA FUNCIÓN QUE HAY QUE IMPLEMENTAR
    // TAMBIÉN PUEDEN AGREGAR OTRAS FUNCIONES y/o CLASES
    // QUE NECESITEN PARA RESOLVER EL EJERCICIO DE LA
    // MANERA MÁS ORDENADA POSIBLE
    HashMap<Integer, Integer> Diccionario = new HashMap<>();
    private static int numero = 0;
    private final int[] intArray = new int[5];
    private int contadorEscalera =1;
    String jugada()
    {
        if (generala()){return "GENERALA";}
        if (poker()){return "POKER";}
        if (full()){return "FULL";}
        if (escalera()){return "ESCALERA";}
        else{return "NADA";
    }
    }
    public static boolean isInteger (String str){
        try{
            numero = Integer.parseInt(str);
            return true;
        }catch(NumberFormatException noInteger){
            return false;
        }
    }
    public boolean generala(){
        return Diccionario.size() == 1;
    }
    public boolean poker(){
        return Diccionario.containsValue(4);
    }
    public boolean escalera(){
        return contadorEscalera == 5;
    }
    public void stringToHashMap(String dados){
        int numero = Integer.parseInt(dados);
            if (Diccionario.containsKey(numero)) {
                Diccionario.put(Integer.parseInt(dados), Integer.parseInt("1") + Diccionario.get(Integer.parseInt(dados)));}
            else if(Integer.parseInt(dados)>0 && Integer.parseInt(dados)<=6)
            {Diccionario.put(Integer.parseInt(dados), 1);}
        }
    public boolean full() {
        return Diccionario.size() == 2 && Diccionario.containsValue(3);
    }
    public static void main(String[] args) {
        Generala g = new Generala();
        Scanner Objeto = new Scanner(System.in);
        String userInput;
        System.out.println("Ingresar 5 dados ");
            for (int x =0; x<5; x++){
                do{
                    System.out.format("Ingrese dado %d: ", x+1);
                    userInput = Objeto.nextLine();
                    g.intArray[x] = Integer.parseInt(userInput);
                    if(!g.Diccionario.isEmpty()){
                      if   (g.intArray[x-1] == 6 && Integer.parseInt(userInput) == 1){g.contadorEscalera++;}
                      else if (g.intArray[x-1] == Integer.parseInt(userInput)-1){g.contadorEscalera++;}
                    }
                    g.stringToHashMap(userInput);
                }while(!isInteger(userInput) || numero<1 || numero>6);
            }
            Objeto.close();
        System.out.println(g.jugada());
    }
}