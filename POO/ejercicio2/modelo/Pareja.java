package modelo;

import java.util.List;
import interfaces.IDeporte;
import java.util.ArrayList;

public class Pareja implements IDeporte {
   private String nombre;
   private List<Deportista> integrantes;

   public Pareja() {
      this.nombre = "Pareja sin nombre";
      this.integrantes = new ArrayList<>();
   }

   public String getNombre() {
      return nombre;
   }

   @Override
   public Boolean conformar(List<Deportista> integrantes) {
      if (integrantes.size() != 2) {
         return false;
      }
      this.integrantes = new ArrayList<>(integrantes);
      for (int i = 0; i < integrantes.size(); i++) {
         integrantes.get(i).setNumeroJugador(i + 1); // Asignar número de jugador
      }
      System.out.println("Pareja " + nombre + " conformada con " + integrantes.size() + " integrantes.");
      this.nombre = integrantes.get(0).getNombre() + " y " + integrantes.get(1).getNombre();
      return true;
   }

   @Override
   public void mostrar() {
      System.out.println("Pareja: " + nombre);
   }

   @Override
   public void numeroDeportista() {
      System.out.println("Los integrantes de la pareja son:");
      for (Deportista deportista : integrantes) {
         System.out.println(deportista.getNumeroJugador() + " - " + deportista.getNombre() + " (" + deportista.getDni() + ")");
      }
   }
}
