package Tarefa_23;
import java.util.Random;
public class Supermercado {
    protected double resultadosTotais;
    private final int numCaixas;
    private final Random rand = new Random();

    public Supermercado(int numCaixas) {
        this.numCaixas = numCaixas;
        this.resultadosTotais = 0.0;
        System.out.println("Supermercado aberto con " + numCaixas + " caixas.");
    }
    public synchronized void rexistrarPago(int idCliente, int caixaEscollida) {
        int tempoAtencion = rand.nextInt(50) + 50;

        try {
            System.out.println(" Caixa " + caixaEscollida + " atendendo a cliente " + idCliente );
            Thread.sleep(tempoAtencion);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        double pago = 5.0 + (100.0 - 5.0) * rand.nextDouble();
        pago = Math.round(pago * 100.0) / 100.0;

        this.resultadosTotais += pago;

        System.out.println("Caixa " + caixaEscollida + "  cliente " + idCliente + " paga: " + pago + "€.");
        System.out.println("Total Recadado: " + String.format("%.2f", this.resultadosTotais) + "€");
    }

    public int getNumCaixas() {
        return numCaixas;
    }

    protected double getResultadosTotais() {
        return this.resultadosTotais;
    }

    protected void amosarEstado() {
        System.out.printf("Recadación total: %.2f€\n", getResultadosTotais());
    }
}