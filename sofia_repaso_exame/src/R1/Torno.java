package R1;

public class Torno extends Thread {
    private final int idTorno;
    private final Afluencia afluenciaSimulada;
    private final int maxTorno;

    public Torno(int idTorno, Afluencia afluenciaSimulada, int maxTorno) {
        this.maxTorno = 1000;
        this.idTorno = idTorno;
        this.afluenciaSimulada = afluenciaSimulada;
    }
    @Override
    public void run() {
       for(int i=0; i<maxTorno; i++) {
        afluenciaSimulada.entrarTorno(idTorno);
       }
        }
    }


