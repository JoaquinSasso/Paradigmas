package modelo;

public class Deportista {
      private String nombre;
      private String dni;
      private Integer numeroJugador;
   
      public Deportista(String nombre, String dni) {
         this.nombre = nombre;
         this.dni = dni;
         this.numeroJugador = -1; // Inicialmente no tiene número asignado
      }
   
      public String getNombre() {
         return nombre;
      }
   
      public String getDni() {
         return dni;
      }

      public Integer getNumeroJugador() {
         return numeroJugador;
      }

      public void setNumeroJugador(Integer numeroJugador) {
         this.numeroJugador = numeroJugador;
      }
   
      @Override
      public String toString() {
         return "Deportista{" +
                  "nombre='" + nombre + '\'' +
                  ", dni='" + dni + '\'' +
                  ", nro='" + numeroJugador + '\'' +
                  '}';
      }
}
