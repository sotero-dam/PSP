package R3;

public class Cliente extends Thread {
    private final Buzon simuBuzon;
    protected final int idCliente;

    public Cliente(Buzon simuBuzon, int idCliente) {
        this.simuBuzon = simuBuzon;
        this.idCliente = idCliente;
    }
    @Override
    public void run(){
        simuBuzon.entrarBuzon(idCliente);
    }
}