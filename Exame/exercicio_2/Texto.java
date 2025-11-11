package exercicio_2;
import java.util.Scanner;

public class Texto {

    private final Scanner scanner = new Scanner(System.in);
    private final String textoTratar;
    private int contadorE = 0;
    private int contadorU = 0;
    private int contadorI = 0;
    private int contadorA = 0;
    private int contadorO = 0;
    private int contadorVogais = 0;

    public Texto(){
        System.out.println("Introduce un texto:");
        textoTratar = scanner.nextLine();
        System.out.println("Texto " + this.textoTratar );
        scanner.close();
    }

    public synchronized void leerVogais(char idVogal){

        if (this.textoTratar == null) return;
        int contadorLocal = 0;
        try {
            for (char c : this.textoTratar.toLowerCase().toCharArray()) {
                if(c == idVogal){
                    contadorLocal++;
                }
            }
            switch (idVogal) {
                case 'e':
                    contadorE += contadorLocal;
                    break;
                case 'a':
                    contadorA += contadorLocal;
                    break;
                case 'u':
                    contadorU += contadorLocal;
                    break;
                case 'i':
                    contadorI += contadorLocal;
                    break;
                case 'o':
                    contadorO += contadorLocal;
                    break;
                default:
                    return;
            }
            contadorVogais += contadorLocal;

        }catch(Exception e){
            Thread.currentThread().interrupt();
            System.out.println("Error co texto");
        }
    }

    public void imprimirResultados() {
        System.out.println("La vocal e aparrece estas veces: " + contadorE);
        System.out.println("La vocal i aparrece estas veces: " + contadorI);
        System.out.println("La vocal a aparrece estas veces: " + contadorA);
        System.out.println("La vocal o aparrece estas veces: " + contadorO);
        System.out.println("Total de vogais atopadas: " + contadorVogais);
        System.out.println("Programa finalizado");
    }
}