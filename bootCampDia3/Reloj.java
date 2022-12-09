package bootCampDia3;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Reloj {
    int horas = 00;
    int minutos = 00;
    int segundos = 00;

    //Constructores
    Reloj() {
        horas = 12;
        minutos = 00;
        segundos = 00;
    }

    Reloj(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    Reloj(int segundo) {
        convertirAHora(segundo);
    }

    //Getters
    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    //Setters
    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    //metodo setReloj para actualizar el valor de la hora, dado segundos como parametro
    public void setReloj(int segundo) {
        horas =00;
        minutos = 00;
        segundos = 00;
        convertirAHora(segundo);
    }

    //Funcion para convertir a hora, minutos y segundos, dado segundos
    public void convertirAHora(int segundos) {
        this.segundos = segundos % 60;
        this.horas = segundos / 60;
        this.minutos = this.horas % 60;
        this.horas = this.horas /60;
    }
    public int convertirASegundo(int horas, int minutos, int segundos){
        while (horas>0 || minutos>0){
            if (horas>0){
                segundos+=3600;
                horas--;
            }
            else if(minutos>0){
                segundos+=60;
                minutos--;
            }
        }
        return segundos;
    }
    //metodo tick, aumenta 1 segundo
    public void tick(){
        if(segundos>=59){
            segundos = 00;
        }
        else{segundos+= 1;}
        }
    //metodo tickDecrement, disminuye 1 segundo
    public void tickDecrement(){
        if(segundos==00){
            segundos=59;
        }else{segundos-=1;}
    }
    public void addReloj(Reloj reloj){
        int segundosTotal=0;
        if(reloj.horas>0){
            reloj.segundos+=3600;
        }
        if(reloj.minutos>0){
            reloj.segundos+= 60;
        }
        segundosTotal = segundos+reloj.segundos;
        convertirAHora(segundosTotal);
    }
    //metodo toString, debe retornar un string representando el objeto reloj en el formato hh:mm:ss
    //Hice que sea void para evitar tantos System.out.println en el codigo
    public void toStringg(){
        System.out.println("La hora es: [" +this.horas+":"+this.minutos+":"+this.segundos+"]");
    }

    //metodo restaReloj, se encarga de obtener la diferencia en horas entre un reloj y otro
    public void restaReloj(Reloj reloj2){
        int segundosReloj1 = convertirASegundo(this.horas, this.minutos, this.segundos);
        int segundosReloj2 = convertirASegundo(reloj2.horas, reloj2.minutos, reloj2.segundos);
        this.segundos= segundosReloj1-segundosReloj2;
        convertirAHora(this.segundos);
    }

    public static void main(String[] args) {
//* instanciar un objeto Reloj, con el constructor de segundos (que
//  pida al usuario ingresar por el teclado)
//* utilizar las funcion tick 10 veces y mostrar la hora cada vez que
//  se ejecuta
//* crear otro objeto reloj y restar la hora con el método
//  restaReloj()
        int segundos = 0;
        Scanner Objeto = new Scanner(System.in);
        System.out.println("Ingrese cantidad de segundos");
        segundos = Objeto.nextInt();

        Reloj reloj = new Reloj(segundos);
        for (int x =0; x<10; x++){
            reloj.tick();
            reloj.toStringg();
        }
        System.out.println("Ingrese cantidad de segundos");
        segundos = Objeto.nextInt();
        Reloj reloj2 = new Reloj(segundos);
        reloj.restaReloj(reloj2);
        reloj.toStringg();
    }
}

