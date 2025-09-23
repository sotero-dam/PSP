import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * Este programa permíteme crear ou editar arquivos co Bloc de notas (Notepad).
 *
 * <p>Pido ao usuario a ruta ou nome do arquivo e intento abrilo en Notepad.
 * Cando pecho o arquivo, pregúntome se quero abrir outro ou saír.</p>
 *
 * <p>O programa vai repetíndose ata que eu decida saír. Se hai erro abrindo
 * o arquivo, móstrase unha mensaxe co motivo.</p>
 *
 * <b>Fluxo:</b>
 * <ol>
 *     <li>Escribo a ruta ou nome do arquivo.</li>
 *     <li>Abrimos o arquivo en Notepad.</li>
 *     <li>Agardo a que o usuario peche Notepad.</li>
 *     <li>Pregunto se quere outro arquivo ou saír.</li>
 * </ol>
 *
 * @autor Sofía Otero
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.println("CREA OU EDITA OS TEUS ARQUIVOS - Sofía Otero");
        while (true) {
            System.out.print("Escribe a ruta ou nome do teu arquivo: ");
            String rutaArquivo = lectorTeclado.nextLine().trim();//fonte:https://www.w3api.com/Java/String/trim/
            File ficheiro = new File(rutaArquivo);
            ProcessBuilder construtorProceso = new ProcessBuilder("notepad", ficheiro.getAbsolutePath());
            construtorProceso.inheritIO();//non ten sentido aquí, non é un programa de consola

            try {
                Process procesoNotepad = construtorProceso.start();
                procesoNotepad.waitFor();//fonte:https://www.tutorialspoint.com/java/lang/process_waitfor.htm
            } catch (IOException | InterruptedException e) {//fonte:https://www.baeldung.com/java-interrupted-exception
                System.out.println("Erro ao intentar abrir o arquivo: " + e.getMessage());
            }
            System.out.println("\nEi, pechaches o teu arquivo, qué queres facer agora?");
            System.out.println("1. Traballar noutro arquivo");
            System.out.println("2. Saír");
            System.out.print("Escolle unha opción: ");
            String opcionMenu = lectorTeclado.nextLine().trim();

            if (opcionMenu.equals("2")) {
                System.out.println("Pechando <3");
                break;
            }
        }
        lectorTeclado.close();
    }
}
