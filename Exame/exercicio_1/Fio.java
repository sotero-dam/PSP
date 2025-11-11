package exercicio_1;

public class Fio extends Thread{
    private final int idFio;
    private final Secuencia simuSecuencia;

    public Fio(int idFio, Secuencia simuSecuencia) {
        this.idFio = idFio;
        this.simuSecuencia = simuSecuencia;
    }
    @Override
    public void run() {
        simuSecuencia.traballarFio(idFio);
    }
}
