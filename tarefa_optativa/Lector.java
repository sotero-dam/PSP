package tarefa_optativa;
public class Lector implements Runnable {
    private Buzon buzon;
    private String nome;

    public Lector(Buzon buzon, String nome) {
        this.buzon = buzon;
        this.nome = nome;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            buzon.ler(nome);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
