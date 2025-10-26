package R1;

import java.util.Arrays;
import java.util.Random;
public class Afluencia {
    protected final int[] estadoTorno;
    protected int persoas_dentro;
    private final int capacidadeMaxima;

    public Afluencia (int capacidade){
        this.capacidadeMaxima = capacidade;
        this.estadoTorno = new int[4];
        Arrays.fill(estadoTorno,0);
        this.persoas_dentro = 0;
    }
    public synchronized  void entrarTorno(int idTorno){
        int numEspectador = this.persoas_dentro +1;
         try{
            int demora = new Random().nextInt(3)+3;
             System.out.println("[Torno " + idTorno + "] ➡️ **Espectador " + numEspectador + "** en fila.");
            Thread.sleep(demora);
             System.out.println("[Torno " + idTorno + "] ⏸️ Esperando (" + demora + "ms)...");
   }
        catch(InterruptedException e){
       Thread.currentThread().interrupt();
   }
        this.persoas_dentro++;
        System.out.println("[Torno " + idTorno + "] ✅ **ACCEDE** Espectador " + this.persoas_dentro + ".");
         if(estadoTorno[idTorno-1] == 1){

         }
    }
    protected int getPersoas_dentro(){
        return this.persoas_dentro;
    }
    protected void mostrarEstado(){
        System.out.println("Entradas finalizadas, estado do estadio:");
        System.out.println("Asitencia total"+getPersoas_dentro());
    }

}
