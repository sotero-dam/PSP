package tarefa_35;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServizoCoinGecko {

    private static final String URL_BASE_API =
            "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=";

    public CriptoMoeda obterDatosCripto(String nomeOuSimbolo) throws IOException, InterruptedException {

        String idMoeda = nomeOuSimbolo.trim().toLowerCase();
        String urlCompleta = URL_BASE_API + idMoeda;

        HttpClient clienteHttp = HttpClient.newHttpClient();

        HttpRequest peticionGet = HttpRequest.newBuilder()
                .uri(URI.create(urlCompleta))
                .header("accept", "application/json")
                .build();

        HttpResponse<String> resposta = clienteHttp.send(peticionGet, HttpResponse.BodyHandlers.ofString());

        if (resposta.statusCode() != 200) {
            throw new IOException("API caida, Pepe. Vas ter que facerte influencer. Codigo de estado: " + resposta.statusCode());
        }

        String jsonTexto = resposta.body();
        JSONArray arrayMoedas = new JSONArray(jsonTexto);

        if (arrayMoedas.length() == 0) {
            return null;
        }

        JSONObject datos = arrayMoedas.getJSONObject(0);

        return new CriptoMoeda(
                datos.getString("name"),
                datos.getString("symbol").toUpperCase(),
                datos.getDouble("current_price"),
                datos.getInt("market_cap_rank"),
                datos.getDouble("price_change_percentage_24h")
        );
    }
}
