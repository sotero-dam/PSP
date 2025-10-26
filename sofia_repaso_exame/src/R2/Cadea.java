package R2;

import java.util.Arrays;

public class Cadea {
    protected int[] estadoPaso;
    private int numPaso;
    private int siguienteOperario = 1;

    public Cadea(int estadoPaso) {
        this.estadoPaso = new int[4];
        Arrays.fill(this.estadoPaso, 0);
    }

    public synchronized void procesarOperario(int numeroOperario) {
        try {
            while (numeroOperario != siguienteOperario) {
                System.out.println("Operario " + numeroOperario + " esperando turno...");
                wait();}

            int demora;
            if (numeroOperario == 1) {
                demora = 2000;

            } else {
                demora = 1000;
            }

            // Texto de demora solicitado
            System.out.println("Traballa o Operario " + numeroOperario + " demórase " + demora / 1000 + " segundos");
            wait(demora);

            this.numPaso++;
            // Texto de finalización de paso solicitado
            System.out.println("terminamos paso  " + numPaso + " (Completado por Operario " + numeroOperario );

            siguienteOperario++;

            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}