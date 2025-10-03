package tarefa_11;

import java.util.Random;

public class FichaDomino extends Thread { //fonte: https://www.tutorialesprogramacionya.com/javaya/detalleconcepto.php?codigo=180
    private final String nombre;
    private FichaDomino siguienteFicha;

    public FichaDomino(String nombre) {
        super(nombre);
        this.nombre = nombre;
       // this.volta = volta;
    }

    public void setSiguienteFicha(FichaDomino siguienteFicha) {
        this.siguienteFicha = siguienteFicha;
    }

    @Override
    public void run() {
        System.out.println("Inicia" + nombre + " _");

        if (siguienteFicha != null) {
            System.out.println("FIo " + nombre + " lanza o fio" + siguienteFicha.nombre);
            siguienteFicha.start();
        }

        Random random = new Random();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Son o fio [" + nombre + "] volta: [" + i + "]");
            try {
                int tiempoEspera = random.nextInt(501) + 100;
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        if (siguienteFicha != null) {
            try {
                System.out.println("Hilo " + nombre + " espera a que " + siguienteFicha.nombre + " termine.");
                siguienteFicha.join();
                System.out.println("Hilo " + siguienteFicha.nombre + " terminou. Fio " + nombre + " continúa.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            System.out.println("Fio" + nombre + " Último rematou bucle.");
        }
        System.out.println("Rematou o fio " + nombre + "_");
    }
}