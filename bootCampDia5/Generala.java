import java.util.*;
public class Generala
{
    // ESTA ES LA FUNCIÓN QUE HAY QUE IMPLEMENTAR
    // TAMBIÉN PUEDEN AGREGAR OTRAS FUNCIONES y/o CLASES
    // QUE NECESITEN PARA RESOLVER EL EJERCICIO DE LA
    // MANERA MÁS ORDENADA POSIBLE
    HashMap<Integer, Integer> Diccionario = new HashMap<>();
    private int[] intArray = new int[5];
    String jugada()
    {
        //Se encarga de generar los dados y determinar que clase de jugada es
        generarDados();
        if (generala()){return ": GENERALA";}
        if (poker()){return ": POKER";}
        if (full()){return ": FULL";}
        if (escalera()){return ": ESCALERA";}
        else{
            return ": NADA";
    }
    }
    public boolean generala(){
        //Retorna generala si los 5 dados son iguales
        return Diccionario.size() == 1;
    }
    public boolean poker(){
        //Retorna poker si 4 dados son iguales
        return Diccionario.containsValue(4);
    }
    public boolean escalera(){
        //Retorna escalera si los numeros son consecutivos
        int contadorEscalera = 1;
        if(Diccionario.size() == 5){
            for (int x =0; x<5; x++){
                for (int j=x; j<4; j++ ){
                    if (intArray[x] == intArray[j+1]-1){
                        contadorEscalera++;
                    } else if (intArray[x] == 6 && intArray[j+1] ==1 && x == 3) {
                        contadorEscalera++;
                    }
                }
            }
        }
        return contadorEscalera == 5;
    }
    public void stringToHashMap(String dados){
        //Hashmap para obtener poker, full y generala
        int numero = Integer.parseInt(dados);
            if (Diccionario.containsKey(numero)) {
                Diccionario.put(Integer.parseInt(dados), Integer.parseInt("1") + Diccionario.get(Integer.parseInt(dados)));}
            else if(Integer.parseInt(dados)>0 && Integer.parseInt(dados)<=6)
            {Diccionario.put(Integer.parseInt(dados), 1);}
        }
    public boolean full() {
        //Retorna full si 3 dados son iguales y los otros dos tambien son iguales entre ellos
        return Diccionario.size() == 2 && Diccionario.containsValue(3);
    }
    public void generarDados(){
        //Genera 5 dados y los añade al array de dados
        System.out.print("Dados: ");
        for (int x = 0; x<5; x++){
            int dado;
            dado = 1 + (int)(Math.random() * ((6 - 1) + 1));
            System.out.print(dado);
            intArray[x] = dado;
            stringToHashMap(Integer.toString(dado));
        }
    }
    public static void main(String[] args) {
        Generala g = new Generala();
        System.out.println(g.jugada());
    }
}