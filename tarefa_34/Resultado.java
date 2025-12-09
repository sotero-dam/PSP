package tarefa_34;

public class Resultado {
    private final String url;
    private long tempoRespostaMs;
    private int tamanoContido;

    public Resultado(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public long getTempoRespostaMs() {
        return tempoRespostaMs;
    }

    public int getTamanoContido() {
        return tamanoContido;
    }

    public void setTempoRespostaMs(long tempoRespostaMs) {
        this.tempoRespostaMs = tempoRespostaMs;
    }

    public void setTamanoContido(int tamanoContido) {
        this.tamanoContido = tamanoContido;
    }
}