public class ForzaBruta {
    static String hashMeta = "04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb";
    static boolean atopado = false;

    public void iniciar() throws Exception {
        atopado = false;
        Thread fio1 = new Thread(new Traballo('a', 'f'));
        Thread fio2 = new Thread(new Traballo('g', 'm'));
        Thread fio3 = new Thread(new Traballo('n', 's'));
        Thread fio4 = new Thread(new Traballo('t', 'z'));

        fio1.start(); fio2.start(); fio3.start(); fio4.start();
        fio1.join(); fio2.join(); fio3.join(); fio4.join();
    }

    static class Traballo implements Runnable {
        char inicio, fin;
        String letras = "abcdefghijklmnopqrstuvwxyz";

        public Traballo(char comezo, char remate) { this.inicio = comezo; this.fin = remate; }

        public void run() {
            for (char a = inicio; a <= fin; a++) {
                for (char b : letras.toCharArray()) {
                    for (char c : letras.toCharArray()) {
                        for (char d : letras.toCharArray()) {
                            if (atopado) return;

                            String proba = "" + a + b + c + d;
                            if (UtilHash.xerar(proba).equals(hashMeta)) {
                                System.out.println("atopado " + proba);
                                atopado = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
