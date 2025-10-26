package R2;

public class Estructura {

    public static void main(String[] args) {
        Cadea cadenaProduccion = new Cadea(0);

        Operario operario1 = new Operario(1, cadenaProduccion);
        operario1.setPriority(Thread.MAX_PRIORITY);//non funcionan sempre, mellor empregar wait e notify
        Operario operario2 = new Operario(2, cadenaProduccion);
        operario2.setPriority(Thread.NORM_PRIORITY);
        Operario operario3 = new Operario(3, cadenaProduccion);
        operario3.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Iniciando a simulación da fábrica...");
        operario1.start();
        operario2.start();
        operario3.start();

        try {
            operario1.join();
            operario2.join();
            operario3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El hilo principal fue interrumpido.");
        }

        System.out.println("Produto rematado");
    }
}