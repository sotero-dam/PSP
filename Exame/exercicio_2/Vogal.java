package exercicio_2;

public class Vogal extends Thread{
    protected char idVogal;
    private Texto simuTexto;
    public Vogal(char idVogal, Texto simuTexto){
        this.idVogal=idVogal;
        this.simuTexto=simuTexto;
    }
    @Override
    public void run(){
        simuTexto.leerVogais(idVogal);
    }
}