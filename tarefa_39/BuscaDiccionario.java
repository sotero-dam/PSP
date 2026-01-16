import java.nio.file.*;
import java.util.List;

public class BuscaDiccionario {
    String hashMeu = "04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb";

    public void buscar() throws Exception {
        List<String> palabras = Files.readAllLines(Paths.get("diccionario.txt"));

        for (String palabra : palabras) {
            if (UtilHash.xerar(palabra).equals(hashMeu)) {
                System.out.println("atopatada " + palabra);
                return;
            }
        }
        System.out.println("Non se atopou");
    }
}