package exercicio_1;
public class Secuencia {

    public synchronized void traballarFio(int idFio) {

       int espera = 2;
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(espera);
                System.out.println("Son o fio "+idFio+" estou na iteración"+i);
                System.out.println("Espero"+espera);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } System.out.println("Fio "+idFio+" reamatou posta");
    }
}
