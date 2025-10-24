package tarefa_21_optativa;
import java.util.Scanner;
import java.util.ArrayList;

public class estructura {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("PARKING HELLO-CAR introduce os datos pra simular:");
        System.out.print("Cantas prazas queres no teu parking? : ");

        while (!entrada.hasNextInt()) {
            System.out.println("Entrada non válida. Introduce un número enteiro.");
            entrada.next();
        }
        final int NUM_PRAZAS = entrada.nextInt();

        System.out.print("Cantos coches queres no teu parking? : ");
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada errada. Introduce un número enteiro.");
            entrada.next();
        }
        final int NUM_COCHES = entrada.nextInt();
        entrada.nextLine();
        Parking parking = new Parking(NUM_PRAZAS);
        ArrayList<Coche> listaCoches = new ArrayList<>();

        for (int i = 1; i <= NUM_COCHES; i++) {
            Coche coche = new Coche(i, parking);
            listaCoches.add(coche);
            coche.start();
        }
        System.out.println("\n Inicio do parking");
        System.out.println("O parking ten " + NUM_PRAZAS + " prazas e " + NUM_COCHES + " coches.");

        boolean executando = true;
        while (executando) {
            System.out.print("\nMENU: Preme 'enter' para PARAR todos os fíos e saír: ");
            String opcion = entrada.nextLine().toLowerCase();

            if (opcion.equals("")) {
                System.out.println("\nRECIBINA PARADA .");
                for (Coche coche : listaCoches) {
                    if (coche.isAlive()) {
                        coche.interrupt();
                    }
                }
                for (Coche coche : listaCoches) {
                    try {
                        coche.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Todos os fíos parados. Parking pausado.");
                executando = false;
            } else {
                System.out.println("NON CONOCIDO :(. Preme 'enter' para deter.");
            }
        }
        entrada.close();
    }
}