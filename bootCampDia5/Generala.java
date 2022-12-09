import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
public class Generala
{
    // ESTA ES LA FUNCIÓN QUE HAY QUE IMPLEMENTAR
    // TAMBIÉN PUEDEN AGREGAR OTRAS FUNCIONES y/o CLASES
    // QUE NECESITEN PARA RESOLVER EL EJERCICIO DE LA
    // MANERA MÁS ORDENADA POSIBLE
    String jugada(String dados)
    {
        int iguales = 0;
        for (int x = 0; x<datos.length(); x++){
            if (datos[x] == datos[x+1]){
                iguales++;
            }
            System.out.println(iguales);
        }
// ESTO SI SE EJECUTA PARA USTEDES
    }
    public static void main(String[] args) {
        Generala g = new Generala();
        g.jugada("2222")
    }
}