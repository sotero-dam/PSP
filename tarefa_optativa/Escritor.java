package tarefa_optativa;
public class Escritor implements Runnable {
    private Buzon buzon;
    private String nome;

    public Escritor(Buzon buzon, String nome) {
        this.buzon = buzon;
        this.nome = nome;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            buzon.escribir("carta " + i + " de " + nome, nome);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
