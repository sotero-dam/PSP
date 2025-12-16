package tarefa_35;

import java.io.IOException;
import java.util.Scanner;

public class AppCripto {

    public static void main(String[] argumentos) {

        ServizoCoinGecko servizo = new ServizoCoinGecko();
        Scanner lectorConsola = new Scanner(System.in);

        System.out.println("O CRIPTO-CONSULTOR DO PEPE (NON VENDAS O TEU RIÑON)");
        System.out.println("Pon a moeda, Pepe. Pero non metas outra merdacoin.");
        System.out.println("Introduce o nome da moeda:");

        String entradaDoPepe = lectorConsola.nextLine();

        if (entradaDoPepe.isBlank()) {
            System.out.println("Mal: O Pepe non sabe nin escribir. Consulta abortada.");
            lectorConsola.close();
            return;
        }

        try {
            System.out.println("Buscando a ver se a tua inversion vale algo...");

            CriptoMoeda moeda = servizo.obterDatosCripto(entradaDoPepe);

            if (moeda != null) {
                amosarDatosMoeda(moeda);
            } else {
                System.out.println("Moneda not found");
            }

        } catch (IOException | InterruptedException erroPeticion) {
            System.out.println("Problema de rede O teu PC non quere cooperar co teu 'trading'. Mensaxe: " + erroPeticion.getMessage());
        } catch (Exception erroXeral) {
            System.out.println("Non che sei: Se o teu programa falla, o teu portfolio tamén.");
        } finally {
            lectorConsola.close();
        }
    }

    private static void amosarDatosMoeda(CriptoMoeda moeda) {

        double variacion24h = moeda.getVariacion24h();

        String sinalVariacion = (variacion24h >= 0) ? "+" : "-";

        System.out.println("DATOS FRESCOS");
        System.out.printf("Nome e Simbolo: %s (%s)\n", moeda.getNome(), moeda.getSimbolo());
        System.out.printf("Prezo en USD: $%.2f\n", moeda.getPrezoUSD());
        System.out.printf("Posto no Ranking: #%d (Seguro que baixara maña)\n", moeda.getRanking());
        System.out.printf("Variacion 24h: %s%.2f%%\n", sinalVariacion, Math.abs(variacion24h));

        if (variacion24h >= 0) {
            System.out.println("Booooom!Vende antes de que baixe de novo.");
        } else {
            System.out.println("Perdidas. Normal. Deixa o telefono, Pepe.");
        }
    }
}
