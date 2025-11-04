package Tarefa_23;
import java.util.Random;
public class Cliente extends Thread {
    private final int idCliente;
    private final Supermercado supermercado;
    private final Random rand = new Random();

    public Cliente(int idCliente, Supermercado supermercado) {
        this.idCliente = idCliente;
        this.supermercado = supermercado;
    }

    @Override
    public void run() {
        try {
            int tempoCompra = rand.nextInt(300) + 100;
            System.out.println("Cliente " + idCliente + " espera de " + tempoCompra + "ms");
            Thread.sleep(tempoCompra);
            int caixaEscollida = rand.nextInt(supermercado.getNumCaixas()) + 1;
            System.out.println("Cliente " + idCliente + " vai á CAIXA " + caixaEscollida);
            supermercado.rexistrarPago(idCliente, caixaEscollida);
            System.out.println("Cliente" + idCliente + " sae do supermercado");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}