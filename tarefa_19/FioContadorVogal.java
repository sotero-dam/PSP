package tarefa_19;

public class FioContadorVogal extends Thread {
    private final String texto;
    private final char vogal;
    private final contadorTotal contadorCompartido;

    public FioContadorVogal(String nome, String texto, char vogal, contadorTotal contadorCompartido) {
        super(nome);
        this.texto = texto;
        this.vogal = vogal;
        this.contadorCompartido = contadorCompartido;
    }
    private char obterVogalBase(char caracter) {
        char c = Character.toLowerCase(caracter);
        return switch (c) {
            case 'á' -> 'a';
            case 'é' -> 'e';
            case 'í' -> 'i';
            case 'ó' -> 'o';
            case 'ú', 'ü' -> 'u';
            default -> c;
        };
    }
    @Override
    public void run() {
        int conteoLocal = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracterBase = obterVogalBase(texto.charAt(i));
            if (caracterBase == vogal) {
                conteoLocal++;
            }
        }
        contadorCompartido.incrementar(conteoLocal);
        System.out.println(getName() + " rematou e contou " + conteoLocal + " veces a vogal '" + vogal + "'.");
    }
}