import java.util.Scanner;

public class AppSeguridade {
    public static void main(String[] args) throws Exception {
        Scanner lector = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Diccionario\n2. Cesar Web\n3. Forza Bruta\n4. Saír");
            String opcion = lector.nextLine();

            if (opcion.equals("1")) {
                new BuscaDiccionario().buscar();
            } else if (opcion.equals("2")) {
                System.out.print("Mensaxe cifrada: ");
                new CesarWeb().descifrar(lector.nextLine());
            } else if (opcion.equals("3")) {
                new ForzaBruta().iniciar();
            } else if (opcion.equals("4")) {
                break;
            }
        }
    }
}