package tarefa_34;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PeticionWeb {

    private static final HttpClient CLIENTE = HttpClient.newHttpClient();

    public static Resultado obterDatos(String urlString) {
        Resultado resultado = new Resultado(urlString);

        System.out.println("Procesando: " + urlString + "...");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET()
                    .build();

            long inicioTempo = System.currentTimeMillis();

            HttpResponse<String> response = CLIENTE.send(request, BodyHandlers.ofString());

            long finTempo = System.currentTimeMillis();

            resultado.setTempoRespostaMs(finTempo - inicioTempo);

            if (response.body() != null) {
                resultado.setTamanoContido(response.body().length());
            } else {
                resultado.setTamanoContido(0);
            }

            if (response.statusCode() / 100 != 2) {
                System.err.println("Erro" + response.statusCode() + " (" + response.uri() + ")");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Problema procesar" + urlString + ": " + e.getMessage());
            resultado.setTempoRespostaMs(Long.MAX_VALUE);
            resultado.setTamanoContido(0);
        }

        return resultado;
    }
}