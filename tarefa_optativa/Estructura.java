package tarefa_optativa;
public class Estructura {
    public static void main(String[] args) {
        System.out.println("Quen escribe a quen? Descubre as mensaxes entre lectoras? :)");
        Buzon buzonCompartido = new Buzon();

        Thread escritora1 = new Thread(new Escritor(buzonCompartido, "Escritora 1"));
        Thread escritora2 = new Thread(new Escritor(buzonCompartido, "Escritora 2"));
        Thread lectora1 = new Thread(new Lector(buzonCompartido, "Lectora 1"));
        Thread lectora2 = new Thread(new Lector(buzonCompartido, "Lectora 2"));

        escritora1.start();
        escritora2.start();
        lectora1.start();
        lectora2.start();
    }
}
