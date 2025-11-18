package tarefa_28;

import java.net.Socket;
import java.io.*;

public class FioCliente implements Runnable {
    private Socket clienteSocket;
    public FioCliente(Socket socket) {
        this.clienteSocket = socket;
    }
    @Override
    public void run() {
        String clienteInfo = clienteSocket.getInetAddress().getHostAddress();
        System.out.println("Cliente conectado: " + clienteInfo);

        try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                PrintWriter saida = new PrintWriter(clienteSocket.getOutputStream(), true)
        ) {
            String liña;
            while ((liña = entrada.readLine()) != null) {
                if (liña.equalsIgnoreCase("adios")) {
                    System.out.println("Cliente " + clienteInfo + " se desconectó con 'adios'.");
                    break;
                }
                System.out.println("Recibido de " + clienteInfo + ": " + liña);
                saida.println("ECO: " + liña);
            }

        } catch (IOException e) {
            System.err.println("Erro de comunicación  " + clienteInfo + ": " + e.getMessage());
        } finally {
            try {
                clienteSocket.close();
            } catch (IOException e) {
                System.err.println("Erro al cerrar socket del cliente: " + e.getMessage());
            }
            System.out.println("Conexión con " + clienteInfo + " cerrada.");
        }
    }
}