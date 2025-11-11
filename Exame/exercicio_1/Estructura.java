package exercicio_1;

public class Estructura {
    public static void main(String args[]){
        Secuencia secuencia1=new Secuencia();
        Fio fio1= new Fio(1,secuencia1);
        Fio fio2= new Fio(2,secuencia1);
        Fio fio3= new Fio(3,secuencia1);

        try {
            fio1.start();
            fio1.join();
            fio2.start();
            fio2.join();
            fio3.start();
            fio3.join();

        }catch(InterruptedException e){
            System.out.println("Erro no fio");
            Thread.currentThread().interrupt();
        }
        System.out.println("Carreira de relevos rematada :)");
    }
}
