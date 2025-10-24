package tarefa_21_optativa;
import java.util.Random;
public class Coche extends Thread {
    private final int idCoche;
    private final Parking parkingCompartido;
    private final Random xeradorAleatorio = new Random();

    public Coche(int id, Parking parking) {
        this.idCoche = id;
        this.parkingCompartido = parking;
    }
    @Override
    public void run() {
        while (parkingCompartido.sistemaActivo) {
            try {
                parkingCompartido.entrarParking(idCoche);
                if (!parkingCompartido.sistemaActivo) break;
                long tempoAparcado = 1000 + xeradorAleatorio.nextInt(500);
                System.out.println("Park: Coche " + idCoche + " aparcado por " + tempoAparcado + "ms.");
                Thread.sleep(tempoAparcado);
                parkingCompartido.saírParking(idCoche);
                long tempoFora = 500 + xeradorAleatorio.nextInt(500);
                System.out.println("Fora: Coche " + idCoche + " fóra por " + tempoFora + "ms.");
                Thread.sleep(tempoFora);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//fonte:https://oregoom.com/java/interrupcion-de-hilos/
                System.out.println("Interrupción: Coche " + idCoche + " foi detido.");
                break;
            }
        }
        System.out.println("Fin fío: Coche " + idCoche + " rematado.");
    }
}