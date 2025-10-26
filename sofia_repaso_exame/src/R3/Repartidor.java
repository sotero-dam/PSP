package R3;

public class Repartidor extends Thread {
    private final Buzon simuBuzon;
    protected final int idRepartidor;

    public Repartidor(Buzon simuBuzon, int idRepartidor) {
        this.simuBuzon = simuBuzon;
        this.idRepartidor = idRepartidor;
    }
    @Override
    public void run(){
        simuBuzon.colocarPaquete(idRepartidor);
    }
}
