package Tarefa_23;
public class Estructura {
    private static int numClientes = 10;
    private static int numCaixas = 2;

    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                numClientes = Integer.parseInt(args[0]);
                numCaixas = Integer.parseInt(args[1]);
                if (numClientes <= 0 || numCaixas <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("O programa recive istos datos <M_clientes> <N_caixas>");
                System.exit(1);
            }
        } else {
            System.out.println("Valores estándar " + numClientes + " Clientes e " + numCaixas + " Caixas.");
        }
        Supermercado supermercado = new Supermercado(numCaixas);

        Cliente[] clientes = new Cliente[numClientes];
        for (int i = 0; i < numClientes; i++) {
            clientes[i] = new Cliente(i + 1, supermercado);
            clientes[i].start();
        }
        for (int i = 0; i < numClientes; i++) {
            try {
                clientes[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("programa finalizado");
        supermercado.amosarEstado();
        System.out.println("Clientes atendidos: " + numClientes);
    }
}