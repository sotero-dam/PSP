package tarefa_29;

import java.net.Socket;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PORTO = 5000;

    public static void main(String[] args) {
        System.out.println("CLIENTE CALCULADORA");

        try (Scanner teclado = new Scanner(System.in);
             Socket conexión = new Socket(HOST, PORTO);

             PrintWriter saída = new PrintWriter(conexión.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(conexión.getInputStream()))
        ) {
            System.out.println("Conectado. Para sair escribe 'ADIOS'");
            System.out.println("Como funciona?: Escribe OPERACION n1 n2 (SUMA 1 5)");
            System.out.println("Operacións dispoñibles : SUMA; RESTA, DIVISION, MULTIPLICACION");
            String petición;

            while (true) {
                System.out.print("Operacion-- ");
                petición = teclado.nextLine();

                saída.println(petición);

                if (petición.equalsIgnoreCase("ADIOS")) {
                    break;
                }

                String resposta = entrada.readLine();

                if (resposta == null) break;

                if (resposta.startsWith("OK")) {
                    System.out.println("Resultado --: " + resposta.substring(3).trim());
                } else if (resposta.startsWith("ERRO")) {
                    System.err.println("ERRO: " + resposta.substring(6).trim());
                } else {
                    System.out.println("Non conocida: " + resposta);
                }
            }
        } catch (IOException erro) {
            System.err.println("Erro, Inicia o Servidor");
        }
        System.out.println("Cliente desconectado.");
    }
}