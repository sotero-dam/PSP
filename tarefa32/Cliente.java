package tarefa_32;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PORTO_SERVIDOR = 5000;

    public static void main(String[] args) {
        System.out.println("Introduce un texto");

        try (Scanner teclado = new Scanner(System.in);
             DatagramSocket socketCliente = new DatagramSocket()) {

            InetAddress enderezoServidor = InetAddress.getByName(HOST);
            System.out.println("Conectado. Para saír escribe 'adios' ");
            System.out.println("Escribe una frase");

            while (true) {
                System.out.print("Introduce palabras: ");
                String mensaxeUsuario = teclado.nextLine();

                if (mensaxeUsuario.equalsIgnoreCase("ADIOS")) {
                    break;
                }

                if (mensaxeUsuario.trim().isEmpty()) {
                    continue;
                }
                byte[] bufferEnvio = mensaxeUsuario.getBytes();
                DatagramPacket paqueteParaEnviar = new DatagramPacket(bufferEnvio, bufferEnvio.length, enderezoServidor, PORTO_SERVIDOR);
                socketCliente.send(paqueteParaEnviar);
                byte[] bufferRecepcion = new byte[1024];
                DatagramPacket paqueteResposta = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
                socketCliente.receive(paqueteResposta);
                String textoResposta = new String(paqueteResposta.getData(), 0, paqueteResposta.getLength());
                System.out.println(" " + textoResposta);
            }

        } catch (Exception erro) {
            System.err.println("Erro no cliente: " + erro.getMessage());
        }
        System.out.println("Cliente desconectado.");
    }
}