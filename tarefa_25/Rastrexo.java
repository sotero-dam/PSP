package tarefa_25;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Rastrexo {
    private static final List<Integer> PORTOS = Arrays.asList(21, 22, 80, 443);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String host = "";

        System.out.println("Rastrexo de portos");
        System.out.println("Escanea 21, 22, 80, 443.");

        while (!host.equalsIgnoreCase("salir")) {
            System.out.print("Escribe a tua IP ou localhost, para sair esctibr sair: ");
            host = scanner.nextLine().trim();
            if (host.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.println("\n Escaneo de" + host );
            for (int porto : PORTOS) {
                rastrexar(host, porto);
            }
        }

        System.out.println("\n Rematado :)");
        scanner.close();
    }
    private static void rastrexar(String host, int porto) {

        Socket socket = null;
        try {
            socket = new Socket(host, porto);
            System.out.printf("Porto %d: aberto \n", porto);
        } catch (IOException e) {
            System.out.printf("Porto %d: pechado \n", porto);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ignored) {}
            }
        }
    }
}