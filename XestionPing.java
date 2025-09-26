import javax.swing.JOptionPane; //fonte:https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html
import javax.swing.JTextArea; //fonte:https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextArea.html
import javax.swing.JScrollPane; //fonte:https://docs.oracle.com/javase/8/docs/api/javax/swing/JScrollPane.html
import java.awt.Color; //fonte:https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
/**
 * Clase principal que gestiona a interfaz usuario pros pings.
 *
 * <p>Utiliza diálogos JOptionPane nun bucle para a interacción.
 * O programa pide un host/IP, fai o ping e mostra a saída completa
 *  nunha ventana de diálogo.</p>
 *
 * @autor Sofía Otero
 * @version 1.1
 */
public class XestionPing {
    public static void main(String[] args) {
        ExecutarPing executor = new ExecutarPing();
        String hostIP;
        while (true) {
            hostIP = JOptionPane.showInputDialog(null, "Introduce o host/IP ('saír' para terminar):", "--- VER OS PINGS ---", JOptionPane.QUESTION_MESSAGE); //fonte:https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html
            if (hostIP == null || hostIP.equalsIgnoreCase("saír")) { //fonte:https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#equalsIgnoreCase(java.lang.String)
                break;
            }
            hostIP = hostIP.trim(); //fonte:https://www.w3api.com/Java/String/trim/
            if (hostIP.isEmpty()) continue; //por si so hai espazos
            String saidaCompleta = executor.executarPing(hostIP);
            JTextArea areaSaida = new JTextArea(saidaCompleta, 15, 40); //fonte:https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextArea.html
            areaSaida.setEditable(false);
            areaSaida.setBackground(new Color(255, 230, 230)); // elexin unha cor personalizada Rosa

            JOptionPane.showMessageDialog(null, new JScrollPane(areaSaida), "Resultado " + hostIP, JOptionPane.INFORMATION_MESSAGE); //fonte:https://docs.oracle.com/javase/8/docs/api/javax/swing/JScrollPane.html
        }
    }
}