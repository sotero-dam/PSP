package exercicio_2;

public class Estructura {
    public static void main(String args[]){
        System.out.println("Iniciando Contador de Vogais (Concorrente)");

        Texto texto1=new Texto();

        Vogal vogalU = new Vogal('u',texto1);
        Vogal vogalE = new Vogal('e',texto1);
        Vogal vogalI = new Vogal('i',texto1);
        Vogal vogalO = new Vogal('o',texto1);
        Vogal vogalA = new Vogal('a',texto1);

        vogalU.start();
        vogalE.start();
        vogalI.start();
        vogalO.start();
        vogalA.start();
        try {

            vogalU.join();
            vogalE.join();
            vogalI.join();
            vogalA.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("A interrupción dun fío fallou.");
        }

        texto1.imprimirResultados();
    }
}