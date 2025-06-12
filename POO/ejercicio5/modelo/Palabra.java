package POO.ejercicio5.modelo;

public class Palabra {
      private String palabra;
      private Integer cantidadVeces;

      public Palabra(String palabra)
      {
         this.palabra = palabra;
         this.cantidadVeces = 0;
      }

      public String getPalabra() {
         return palabra;
      }
      public void setPalabra(String palabra) {
         this.palabra = palabra;
      }

      public Integer getCantidadVeces() {
         return cantidadVeces;
      }
      
      public void aumentarCantidadVeces() {
         this.cantidadVeces++;
      }
}
