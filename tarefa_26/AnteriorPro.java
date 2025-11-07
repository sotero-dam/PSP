package tarefa_26;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class AnteriorPro {
    private static final int PORTO = 5000;

    public static void main(String[] args) {
        System.out.println("Servidor no porto " + PORTO);
        System.out.println("Iniciando chat alumnas PSP");
        try (ServerSocket servidor = new ServerSocket(PORTO);
             Socket cliente = servidor.accept();

             BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
             PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true)
        ) {
            System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
            String liña;
            while ((liña = entrada.readLine()) != null) {
                if (liña.equalsIgnoreCase("adios")) {
                    break;
                }
                System.out.println("Recibido: " + liña);
                saida.println( liña);
            }
        } catch (IOException e) {
            System.err.println("Erro no Servidor: " + e.getMessage());
        }
        System.out.println("Fin =_=");
    }
}
