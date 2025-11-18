package tarefa_28;

import java.net.Socket;
import java.io.*;
import java.util.Scanner;

public class Cliente{
    private static final String HOST = "localhost";
    private static final int PORTO = 5000;
    public static void main(String[] args) {
        System.out.println("Falando co meu compañeiro de PSP");
        try (Scanner teclado = new Scanner(System.in);
             Socket socket = new Socket(HOST, PORTO);
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Conectados. Para salir escribe 'adios'");
            String mensaxe;
            while (true) {
                System.out.print("Eu -> ");
                mensaxe = teclado.nextLine();
                saida.println(mensaxe);
                if (mensaxe.equalsIgnoreCase("adios")) {
                    break;
                }
                String eco = entrada.readLine();
                if (eco == null) {
                    System.out.println("Conexión pechada");
                    break;
                }
                System.out.println("Compañeiro -> " + eco);
            }
        } catch (IOException e) {
            System.err.println("Erro na conexion, asegurate de ter iniciado o Servidor");
        }
        System.out.println("Cliente desconectado");
    }
}
