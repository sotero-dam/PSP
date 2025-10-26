package R1;

public class Estructura {
    private static final int NUM_TORNOS = 4;
    private static final int MAX_ENTRADAS_POR_TORNO = 1000;

    public static void main(String[] args) {
        // 1. Crear o recurso compartido (Afluencia)
        Afluencia afluencia = new Afluencia(4000);

        // Array para gardar os fíos (tornos)
        Torno[] tornos = new Torno[NUM_TORNOS];

        System.out.println("O Erizana inicia a entrada con " + NUM_TORNOS + " tornos (1000 persoas/torno).");

        // 2. Crear e iniciar os 4 fíos (Tornos)
        for (int i = 0; i < NUM_TORNOS; i++) {
            // idTorno (i + 1), Recurso compartido, Máx. Entradas
            tornos[i] = new Torno(i + 1, afluencia, MAX_ENTRADAS_POR_TORNO);

            // Inicia o fío
            tornos[i].start();
        }

        // 3. Esperar a que rematen os 4 fíos (join())
        for (int i = 0; i < NUM_TORNOS; i++) {
            try {
                // Espera a que o fío 'tornos[i]' finalice a súa execución
                tornos[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 4. Imprimir o resultado final
        System.out.println("\n-------------------------------------------");
        System.out.println("SIMULACIÓN DE ENTRADA FINALIZADA.");
        afluencia.mostrarEstado(); // Chama ao método para imprimir o resultado
        System.out.println("O total debe ser: " + (NUM_TORNOS * MAX_ENTRADAS_POR_TORNO) + " persoas.");
        System.out.println("-------------------------------------------");
    }
}