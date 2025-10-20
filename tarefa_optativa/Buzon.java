package tarefa_optativa;
public class Buzon {
    private String carta;
    private boolean baleiro = true;
    public synchronized void escribir(String novaCarta, String nomeEscritor) {
        while (!baleiro) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        carta = novaCarta;
        baleiro = false;
        System.out.println(nomeEscritor + " escribiu: " + carta);
        notifyAll();
    }
    public synchronized String ler(String nomeLector) {
        while (baleiro) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String lida = carta;
        carta = null;
        baleiro = true;
        System.out.println(nomeLector + " leu: " + lida);
        notifyAll();
        return lida;
    }
}
