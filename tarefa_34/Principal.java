package tarefa_34;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe enlace 1");
        String urlString1 = scanner.nextLine();

        System.out.println("Escribe enlace 2");
        String urlString2 = scanner.nextLine();

        System.out.println("Procensando peticións");
        Resultado res1 = PeticionWeb.obterDatos(urlString1);
        Resultado res2 = PeticionWeb.obterDatos(urlString2);

        imprimirResultado(res1, res2);

        scanner.close();
    }

    public static void imprimirResultado(Resultado r1, Resultado r2) {

        Resultado maisRapida = (r1.getTempoRespostaMs() <= r2.getTempoRespostaMs()) ? r1 : r2;
        System.out.println(
                "A web mais rapida foiche: " + maisRapida.getUrl() +
                        " con " + maisRapida.getTempoRespostaMs() + " ms."
        );

        Resultado maisContido = (r1.getTamanoContido() >= r2.getTamanoContido()) ? r1 : r2;
        System.out.println(
                "A web con mais contido foiche " + maisContido.getUrl() +
                        " con " + maisContido.getTamanoContido() + " caracteres."
        );
    }
}