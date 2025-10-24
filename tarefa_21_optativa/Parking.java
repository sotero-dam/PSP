package tarefa_21_optativa;
import java.util.Arrays;

public class Parking {
    private final int[] estadoPrazas;
    private int prazasOcupadas;
    private final int capacidadeMaxima;
    public volatile boolean sistemaActivo = true;//fonte!!:https://www.baeldung.com/java-wait-notify

    public Parking(int capacidade) {
        this.capacidadeMaxima = capacidade;
        this.estadoPrazas = new int[capacidade];
        Arrays.fill(estadoPrazas, 0);
        this.prazasOcupadas = 0;
    }
    public synchronized void entrarParking(int idCoche) throws InterruptedException {//fonte: https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.makigas.es/series/concurrencia-en-java/bloque-synchronized&ved=2ahUKEwi96_Se372QAxXNhP0HHU-WFGcQFnoECB0QAQ&usg=AOvVaw19VN9c3crDx2GqDN1GHaqR
        while (prazasOcupadas == capacidadeMaxima && sistemaActivo) {
            System.out.println("ESPERA: Coche " + idCoche + " espera. Parking Cheo.");
            wait();
        }
        if (!sistemaActivo) {
            System.out.println("PARADA: Coche " + idCoche + " detén o intento de entrada.");
            return;
        }
        int indicePraza = -1;
        for (int i = 0; i < capacidadeMaxima; i++) {
            if (estadoPrazas[i] == 0) {
                indicePraza = i;
                break;
            }
        }
        if (indicePraza != -1) {
            estadoPrazas[indicePraza] = idCoche;
            prazasOcupadas++;
            System.out.println("ENTRADA: Coche " + idCoche + " aparca na praza " + indicePraza + ".");
            mostrarEstado();
        }
    }
    public synchronized void saírParking(int idCoche) {
        int indicePraza = -1;
        for (int i = 0; i < capacidadeMaxima; i++) {
            if (estadoPrazas[i] == idCoche) {
                indicePraza = i;
                break;
            }
        }

        if (indicePraza != -1) {
            estadoPrazas[indicePraza] = 0;
            prazasOcupadas--;
            System.out.println("SAÍDA : Coche " + idCoche + " saíndo da praza " + indicePraza + ".");
            mostrarEstado();
            notifyAll();
        } else {
            System.err.println("ERRO: Coche " + idCoche + " intentou saír pero non se atopou.");
        }
    }
    public void deterSistema() {
        sistemaActivo = false;
        synchronized (this) {
            notifyAll();
        }
    }
    private void mostrarEstado() {
        System.out.print("Estado Parking: ");
        for (int i = 0; i < capacidadeMaxima; i++) {
            System.out.print(estadoPrazas[i] + (i < capacidadeMaxima - 1 ? ", " : ""));
        }
        System.out.println(" Prazas Libres: " + (capacidadeMaxima - prazasOcupadas));
    }
}