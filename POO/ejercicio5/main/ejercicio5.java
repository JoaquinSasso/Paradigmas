package POO.ejercicio5.main;
import POO.ejercicio5.modelo.ConjuntoPalabras;
import POO.ejercicio5.modelo.MiHilo;

public class ejercicio5 {
   public static void main(String[] args) {
      MiHilo hilo1 = new MiHilo("POO\\ejercicio5\\datos\\Texto1.txt");
      MiHilo hilo2 = new MiHilo("POO\\ejercicio5\\datos\\Texto2.txt");
      hilo1.start();
      hilo2.start();
      try {
         hilo1.join();
         hilo2.join();
      } catch (InterruptedException e) {
         System.err.println("Error al esperar por los hilos: " + e.getMessage());
      }
      ConjuntoPalabras total = hilo1.getResultado();
      total.unir(hilo2.getResultado());
      total.mostrar();
   }
}
