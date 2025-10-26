package R3;

import java.util.Arrays;

public class Buzon {
    protected int[] estadoPaquete; // Usamos un array de 1 elemento para manter a túa estrutura.
    protected int paquete;

    public Buzon(int estadoPaquete) {
        this.estadoPaquete = new int[1];
        Arrays.fill(this.estadoPaquete, 0);
    }
    public synchronized void entrarBuzon(int idCliente) {
        try {
            // Usar 'while' para a espera.
            // O cliente espera MENTRES NON haxa paquete (estadoPaquete[0] == 0).
            while (this.estadoPaquete[0] == 0) {
                System.out.println("Cliente esperando: Buzón vacío.");
                wait(); // O fío cliente espera e libera o monitor.
            }

            // Se sae do while, hai paquete.
            this.estadoPaquete[0] = 0; // O cliente colle o paquete.
            System.out.println("Paquete localizado e retirado por Cliente " + idCliente);

            // Notificar aos outros fíos (repartidor) que o estado cambiou.
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error no envio");
        }
    }

    // O repartidor DEBE chamar a notifyAll() para espertar ao cliente.
    public synchronized void colocarPaquete(int idRepartidor) {
        try {
            // Repartidor espera se o buzón XA está cheo.
            while (this.estadoPaquete[0] == 1) {
                System.out.println("Repartidor esperando: Buzón lleno.");
                wait();
            }

            // Coloca o paquete
            this.estadoPaquete[0] = 1;
            System.out.println("Paquete colocado por Repartidor " + idRepartidor);

            // Notificar aos outros fíos (cliente) que o estado cambiou.
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error al colocar el paquete");
        }
    }
}