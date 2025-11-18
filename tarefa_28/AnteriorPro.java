package tarefa_28;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class AnteriorPro {
    private static final int PORTO = 5000;

    public static void main(String[] args) {
        System.out.println("Servidor no porto " + PORTO);
        System.out.println("Iniciando chat alumnas PSP ");

        try (ServerSocket servidor = new ServerSocket(PORTO)) {
            while (true) {
                System.out.println("Esperando conexión...");
                Socket cliente = servidor.accept();
                FioCliente nuevoCliente = new FioCliente(cliente);
                new Thread(nuevoCliente).start();
            }
        } catch (IOException e) {
            System.err.println("Erro no Servidor Principal: " + e.getMessage());
        }
        System.out.println("Fin =_=");
    }
}
