import java.net.URI;
import java.net.http.*;

public class CesarWeb {
    String letras = "10a6e6cc8311a3e2bcc09bf6c199adecd5dd59408c343e926b129c4914f3cb01";

    public void descifrar(String mensaxe) throws Exception {
        mensaxe = mensaxe.toLowerCase();

        for (int salto = 1; salto < letras.length(); salto++) {
            String textoNovo = "";

            for (char letra : mensaxe.toCharArray()) {
                int pos = letras.indexOf(letra);
                if (pos == -1) textoNovo += letra;
                else {
                    int novaPos = pos - salto;
                    if (novaPos < 0) novaPos += letras.length();
                    textoNovo += letras.charAt(novaPos);
                }
            }

            String primeiraPalabra = textoNovo.split(" ")[0];
            String url = "https://api.languagetool.org/v2/check?language=es&text=" + primeiraPalabra;

            HttpClient web = HttpClient.newHttpClient();
            String resposta = web.send(HttpRequest.newBuilder(URI.create(url)).build(), HttpResponse.BodyHandlers.ofString()).body();

            if (!resposta.contains("misspelling")) {
                System.out.println("descifrado " + textoNovo + " (Salto " + salto + ")");
                return;
            }
        }
        System.out.println("Non se puido descifrar.");
    }
}