package modelo;

import interfaces.IDeporte;
import java.util.ArrayList;
import java.util.List;

public class Equipo implements IDeporte {
   private String nombre;
   private List<Deportista> integrantes;

   public Equipo(String nombre) {
      this.nombre = nombre;
      this.integrantes = new ArrayList<>();
   }

   public String getNombre() {
      return nombre;
   }

   @Override
   public Boolean conformar(List<Deportista> integrantes) {
      if (integrantes.size() < cantidadMinima) {
         return false;
      }
      this.integrantes = new ArrayList<>(integrantes);
      for (int i = 0; i < integrantes.size(); i++) {
         integrantes.get(i).setNumeroJugador(i + 1); // Asignar número de jugador
      }
      System.out.println("Equipo " + nombre + " conformado con " + integrantes.size() + " integrantes.");
      return true;
   }

   @Override
   public void mostrar() {
      System.out.println("Equipo: " + nombre);
   }

   @Override
   public void numeroDeportista() {
      System.out.println("Los integrantes del equipo son:");
      for (Deportista deportista : integrantes) {
         System.out.println(deportista.getNumeroJugador() + " - " + deportista.getNombre() + " (" + deportista.getDni() + ")");
      } 
   }
}
