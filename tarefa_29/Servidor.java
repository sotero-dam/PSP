package tarefa_29;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Servidor {
    private static final int PORTO = 5000;

    public static void main(String[] args) {
        System.out.println("SERVIDOR DE OPERACIONS");

        try (ServerSocket servidor = new ServerSocket(PORTO)) {
            System.out.println("Servidor esperando clientes no porto " + PORTO);

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado");

                Xestor fío = new Xestor(cliente);
                fío.start();
            }
        } catch (IOException erro) {
            System.err.println("Erro " + erro.getMessage());
        }
    }
}