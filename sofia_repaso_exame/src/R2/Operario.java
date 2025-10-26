package R2;

public class Operario extends Thread {
    protected final int numOperario;
    private final Cadea simuCadea;

    public Operario(int numOperario, Cadea simuCadea) {
        this.numOperario = numOperario;
        this.simuCadea = simuCadea;
    }

    @Override
    public void run() {
            simuCadea.procesarOperario(numOperario);
    }
    }

