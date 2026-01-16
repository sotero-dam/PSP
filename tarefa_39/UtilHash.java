import java.security.MessageDigest;
import java.util.HexFormat;

public class UtilHash {
    public static String xerar(String texto) {
        try {
            byte[] bytes = MessageDigest.getInstance("SHA-256").digest(texto.getBytes());
            return HexFormat.of().formatHex(bytes);
        } catch (Exception e) { return ""; }
    }
}