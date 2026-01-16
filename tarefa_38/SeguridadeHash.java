package tarefa_38;

import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.Scanner;

public class SeguridadeHash {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Rexistrate");
            System.out.print("Crea unha contraseña");
            String contrasinalOrixinal = scanner.nextLine();

            String hashGardado = xerarHashSha256(contrasinalOrixinal);

            System.out.println("Rexistrado, inicia sesión");
            System.out.print("Pon a túa contraseña");
            String contrasinalInput = scanner.nextLine();

            String hashLogin = xerarHashSha256(contrasinalInput);

            if (hashGardado.equals(hashLogin)) {
                System.out.println("ACCESO CONCEDIDO");
            } else {
                System.out.println("Credenciales erroneas");
            }

            scanner.close();

        } catch (Exception erro) {
            System.out.println("Produciuse un erro: " + erro.getMessage());
        }
    }

    public static String xerarHashSha256(String texto) throws Exception {
        MessageDigest dixestor = MessageDigest.getInstance("SHA-256");
        byte[] resumoBytes = dixestor.digest(texto.getBytes());
        return HexFormat.of().formatHex(resumoBytes);
    }
}