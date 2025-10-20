package tarefa_19;

public class contadorTotal {
    private int totalVogais = 0;

    public synchronized void incrementar(int cantidade) {
        totalVogais += cantidade;
    }
    public int obterTotal() {
        return totalVogais;
    }
}