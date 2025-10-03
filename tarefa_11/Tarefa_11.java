package tarefa_11;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal que contén o metodo main para iniciar
 * o "efecto dominó" cos fíos .
 * * Encárgase de solicitar o número de fichas ao usuario, xestionar
 * posibles erros na entrada, construír a cadea de dependencias entre
 * os obxectos FichaDomino, iniciar o proceso e medir o tempo total
 * de execución.
 * * @author Sofía Otero
 * @version 1.0
 */
public class Tarefa_11 {

    /**
     * Punto de entrada do programa.
     * * Implementa a lóxica de control:
     * 1. Solicita e valida o número de fichas.
     * 2. Constrúe a cadea de fichas (Chain of Responsibility).
     * 3. Mide o tempo de inicio e lanza o primeiro fío.
     * 4. Monitoriza o estado do primeiro fío cun bucle while e join.
     * 5. Calcula e imprime a duración total do programa
     */
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);
        int NUM_FICHAS = 0;
        boolean inputValido = false;

        do {
            System.out.println("\nIngrese o número de fichas O_O: ");

            try {
                int input = lectorTeclado.nextInt();

                if (input <= 0) {
                    throw new IllegalArgumentException("MAAAAAAL, o teu número de fichas ten que ser maior que 0");
                }
                NUM_FICHAS = input;
                inputValido = true;
            } catch (InputMismatchException e) {//fonte:https://keepcoding.io/blog/error-inputmismatchexception-en-java/
                System.out.println("Entrada non válida. Valor engadido por defecto: 5");
                NUM_FICHAS = 5;
                lectorTeclado.next();
                inputValido = true;
            } catch (IllegalArgumentException e) {//fonte: https://labex.io/es/tutorials/java-how-to-handle-illegalargumentexception-in-java-417309
                System.out.println("Número non válido: " + e.getMessage() + " Valor engadido por defecto 5");
                NUM_FICHAS = 5;
                inputValido = true;
            }
        } while (!inputValido);

        long TempoInicio= System.nanoTime();//fonte:https://www.tutorialspoint.com/java/lang/system_nanotime.htm
        FichaDomino[] fichas = new FichaDomino[NUM_FICHAS];
        for (int i = 0; i < NUM_FICHAS; i++) {
            fichas[i] = new FichaDomino("Ficha-" + (i + 1));
        }

        for (int i = 0; i < NUM_FICHAS - 1; i++) {
            fichas[i].setSiguienteFicha(fichas[i + 1]);
        }

        System.out.println("O fio principal inicia a ficha 1\n");
        fichas[0].start();
        try {
            while (fichas[0].isAlive()) {//fonte:https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
                fichas[0].join(200);//fonte:https://www.makigas.es/series/concurrencia-en-java/como-usar-thread-join
                if (fichas[0].isAlive()) {
                    System.out.println("[Control] A primeira ficha aínda non rematou");
                }
            }
            long TempoFinal= System.nanoTime();
            System.out.println("\nRematáronse as fichas ");
            long DuracionEnNanoS = TempoFinal - TempoInicio;
            double duracionEnSegundos = (double) DuracionEnNanoS/1_000_000_000.0;//ver como convertir https://www.xconvert.com/unit-converter/milliseconds-to-nanoseconds
            System.out.printf("Tempo total de simulación: %.4f segundos.%n ", duracionEnSegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();//fonte:https://docs.oracle.com/javase/7/docs/api/java/lang/InterruptedException.html
        }
        lectorTeclado.close();
    }
}