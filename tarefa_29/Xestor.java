package tarefa_29;

import java.net.Socket;
import java.io.*;

public class Xestor extends Thread {
    private Socket conexión;

    public Xestor(Socket conexión) {
        this.conexión = conexión;
    }

    @Override
    public void run() {
        try (
                BufferedReader lector = new BufferedReader(new InputStreamReader(conexión.getInputStream()));
                PrintWriter escritor = new PrintWriter(conexión.getOutputStream(), true)
        ) {
            String liñaCliente;

            while ((liñaCliente = lector.readLine()) != null) {
                System.out.println("Recibido de " + conexión.getInetAddress().getHostAddress() + ": " + liñaCliente);

                if (liñaCliente.equalsIgnoreCase("ADIOS")) {
                    break;
                }

                String resposta = procesarPetición(liñaCliente);

                escritor.println(resposta);
            }
        } catch (IOException erro) {
            System.out.println("Erro co cliente: " + erro.getMessage());
        } finally {
            try {
                if (conexión != null) {
                    conexión.close();
                    System.out.println("Cliente desconectado.");
                }
            } catch (IOException erro) {

            }
        }
    }

    private String procesarPetición(String petición) {
        String[] partes = petición.trim().split("\\s+");//https://codegym.cc/es/groups/posts/es.512.metodo-java-string-split-

        if (partes.length < 3) {
            return "Formato incorrecto";
        }

        String operación = partes[0].toUpperCase();
        double num1, num2;

        try {
            num1 = Double.parseDouble(partes[1]);
            num2 = Double.parseDouble(partes[2]);
        } catch (NumberFormatException erro) {
            return "Erro !!! non validos.";
        }
        try {
            double resultado;
            switch (operación) {
                case "SUMA":
                    resultado = num1 + num2;
                    break;
                case "RESTA":
                    resultado = num1 - num2;
                    break;
                case "MULTIPLICACION":
                    resultado = num1 * num2;
                    break;
                case "DIVISION":
                    if (num2 == 0) throw new ArithmeticException("Division por cero.");
                    resultado = num1 / num2;
                    break;
                default:
                    return "Erro!!!! non posible calcular: " + operación;
            }
            return "OK " + resultado;
        } catch (Exception erro) {
            return "ERRO " + erro.getMessage();
        }
    }
}