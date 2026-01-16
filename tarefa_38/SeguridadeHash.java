package tarefa_38;

import java.security.MessageDigest;
import java.util.HexFormat;

public class SeguridadeHash {

    public static void main(String[] args) {
        try {# TAREFA 27- MENSAXES ECO CLIENTE

**Desenvolvido por**: Sofía Otero

**Asignatura**: Programación de Servizos e Procesos (PSP)

**Versión**: 1.0
            String textoEntrada = "hellokittywillruntheworld";
            String hashResultante = xerarHashSha256(textoEntrada);
            System.out.println("Texto orixinal: " + textoEntrada);
            System.out.println("Hash SHA-256:   " + hashResultante);

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