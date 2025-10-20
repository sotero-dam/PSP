package tarefa_19;

import java.util.Scanner;

public class ContadorVogaisConcorrente {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame o texto que queres analizar :3:");
        String textoBase = scanner.nextLine();
        scanner.close();
        contadorTotal contadorCompartido = new contadorTotal();
        char[] vogais = {'a', 'e', 'i', 'o', 'u'};
        Thread[] fios = new Thread[5];
        for (int i = 0; i < vogais.length; i++) {
            fios[i] = new FioContadorVogal("Fío-" + vogais[i], textoBase, vogais[i], contadorCompartido);
            fios[i].start();
        }
        for (Thread f : fios) {
            f.join();
        }
        System.out.println("O total de vogais é: " + contadorCompartido.obterTotal());
    }
}