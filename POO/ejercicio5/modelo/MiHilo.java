package POO.ejercicio5.modelo;

public class MiHilo extends Thread {
   
   private String rutaArchivo;
   private ConjuntoPalabras conjuntoPalabras;
   public MiHilo(String rutaArchivo) {
      this.rutaArchivo = rutaArchivo;
   }

   @Override
   public void run() {
      String texto;
      conjuntoPalabras = new ConjuntoPalabras();
      Palabra palabraActual;
      try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File(rutaArchivo))) {
         while (scanner.hasNext()) {
            texto = scanner.next().toLowerCase().replaceAll("[^a-z0-9áéíóúüñ]", "");
            palabraActual = conjuntoPalabras.buscar(texto);
            if (palabraActual != null) {
               palabraActual.aumentarCantidadVeces();
            } else {
               palabraActual = new Palabra(texto);
               conjuntoPalabras.agregarPalabra(palabraActual);
            }
         }
      } catch (java.io.FileNotFoundException e) {
         System.err.println("Archivo no encontrado: " + rutaArchivo);
      }
   }

   public ConjuntoPalabras getResultado() {
      return conjuntoPalabras;
  }
}
