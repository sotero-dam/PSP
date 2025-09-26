import java.io.IOException;
import java.io.BufferedReader; //fonte:https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
import java.io.InputStreamReader; //fonte:https://docs.oracle.com/javase/8/docs/api/java/io/InputStreamReader.html
import java.util.ArrayList;
import java.util.List;
import java.lang.Process; //fonte:https://docs.oracle.com/javase/8/docs/api/java/lang/Process.html

/**
 * Esta clase encárgase de executar o comando 'ping' dende o sistema,
 * limitando o número de paquetes a 4. Busco lanzar o proceso fillo que executa o ping,
 * capturar tanto a saída estándar
 * como a saída de erro, e devolvela ao proceso pai para que poida ser analizada ou amosada.
 *
 * <p>Creo un proceso co 'ping', redirixp a saída de erro pra
 * que vaia xunto coa saída estándar, e vai lendo as liñas que produce o comando (mirar anoración README).
 * Como se pide a liña é marcada como saída correcta ou erro, dependendo do contido.
 * Devolve toda a saída xunto co código de retorno do proceso.</p>
 *
 * <p>Comprobar a conexión con outro host  desde un programa Java.</p>
 *
 * @autor Sofía Otero
 * @version 1.1
 */
public class ExecutarPing {

    /**
     * Fai o'ping' para o host pedido, enviando 4 paquetes.
     *
     * <p>Crea o comando 'ping -c 4 host', executa o proceso, e captura
     * a saída estándar e de erro do proceso en tempo real. Cada liña lida é
     * e engádese o seu prefixo.</p>
     *
     * <p>Se se produce un erro captúrase e engádese na saida de volta</p>
     *
     * @param hostIP Cadea coa direción IP ou nome do host ao que facer o ping.
     * @return Unha cadea coa saída completa do ping, cos prefixos e o código de saída.
     */
    public String executarPing(String hostIP) {

        List<String> comandoPing = new ArrayList<>();
        comandoPing.add("ping");
        comandoPing.add("-c"); //fonte:https://man7.org/linux/man-pages/man8/ping.8.html , pra indicar o numero de veces
        comandoPing.add("4"); //fonte:https://man7.org/linux/man-pages/man8/ping.8.html , un total de 4 veces
        comandoPing.add(hostIP);

        ProcessBuilder construtorProceso = new ProcessBuilder(comandoPing);

        construtorProceso.redirectErrorStream(true); //fonte:https://docs.oracle.com/javase/8/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream(boolean), revisar README prompt IA sobre como redirixo as saídas

        StringBuilder saida = new StringBuilder(); //fonte:https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
        int codigoSaida = -1;

        boolean enModoError = false;
        try {
            Process procesoPing = construtorProceso.start();
            BufferedReader lectorSaida = new BufferedReader(new InputStreamReader(procesoPing.getInputStream())); //fonte:https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
            String linea;
            while ((linea = lectorSaida.readLine()) != null) { //fonte:https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html#readLine()

                String prefixo;
                if (linea.contains("ping: ") || linea.contains("desconecido") || enModoError) {
                    prefixo = "[ERRO x_x] ";
                    enModoError = true;
                } else {
                    prefixo = "[OK :)] ";
                }

                saida.append(prefixo).append(linea).append("\n");//fonte:https://docs.oracle.com/javase/8/docs/api/java/lang/Appendable.html#append-char- , tamén prompt IA adxuntado no README
            }
            codigoSaida = procesoPing.waitFor(); //fonte:https://docs.oracle.com/javase/8/docs/api/java/lang/Process.html#waitFor() , repasando o que vin en clase

        } catch (IOException | InterruptedException e) { //fonte:https://www.baeldung.com/java-interrupted-exception
            saida.append("[ERROR] ").append("Erro ao lanzar o proceso ping: ").append(e.getMessage()).append("\n");
        }

        saida.append("\nOperación completada. Código de saída: ").append(codigoSaida);
        saida.append("\nFÍN DO PROCESO :)\n");
        return saida.toString();
    }
}
