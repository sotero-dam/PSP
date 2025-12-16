package tarefa_35;

public class CriptoMoeda {

    private final String nome;
    private final String simbolo;
    private final double prezoUSD;
    private final int ranking;
    private final double variacion24h;

    public CriptoMoeda(String nome, String simbolo, double prezoUSD, int ranking, double variacion24h) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.prezoUSD = prezoUSD;
        this.ranking = ranking;
        this.variacion24h = variacion24h;
    }

    public String getNome() { return nome; }
    public String getSimbolo() { return simbolo; }
    public double getPrezoUSD() { return prezoUSD; }
    public int getRanking() { return ranking; }
    public double getVariacion24h() { return variacion24h; }
}