package tarefa_32;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    private static final int PORTO = 5000;

    public static void main(String[] args) {


        try (DatagramSocket socketServidor = new DatagramSocket(PORTO)) {
            byte[] recepcionBuffer = new byte[1024];

            while (true) {
                DatagramPacket paqueteEntrante = new DatagramPacket(recepcionBuffer, recepcionBuffer.length);
                socketServidor.receive(paqueteEntrante);
                String mensaxe = new String(paqueteEntrante.getData(), 0, paqueteEntrante.getLength());
                System.out.println("Cliente enviou: " + mensaxe);
                String[] listaPalabras = mensaxe.split("\\s+");
                String palabraMaisLonga = "";
                int lonxitudeMaxima = 0;

                for (String palabra : listaPalabras) {
                    if (palabra.length() > lonxitudeMaxima) {
                        lonxitudeMaxima = palabra.length();
                        palabraMaisLonga = palabra;
                    }
                }
                String respostaTexto = "A palabra máis longa é: '" + palabraMaisLonga + " e ten " + lonxitudeMaxima + " letras";
                byte[] bufferEnvio = respostaTexto.getBytes();
                InetAddress enderezoCliente = paqueteEntrante.getAddress();
                int portoCliente = paqueteEntrante.getPort();
                DatagramPacket paqueteSaida = new DatagramPacket(bufferEnvio, bufferEnvio.length, enderezoCliente, portoCliente);
                socketServidor.send(paqueteSaida);
            }
        } catch (Exception erro) {
            System.err.println("Erro no servidor: " + erro.getMessage());
        }
    }
}