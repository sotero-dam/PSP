package R3;

public class Estructura {

    public static void main(String[] args) {
        Buzon simuPostal = new Buzon(0);
        System.out.println("Iniciando de paquetería...");


        Cliente cliente1 = new Cliente(simuPostal, 1);
        Repartidor repartidor1 = new Repartidor(simuPostal, 1);

        cliente1.start();
        repartidor1.start();

        try {
            cliente1.join();
            repartidor1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El hilo principal fue interrumpido.");
        }

        System.out.println("Proceso Rematado");
    }
}