package POO.ejercicio5.modelo;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoPalabras {
   private List<Palabra> grPalabras;

   public ConjuntoPalabras() {
      this.grPalabras = new ArrayList<>();
   }

   public void agregarPalabra(Palabra p) {
      this.grPalabras.add(p);
   }

   public Palabra buscar(String p) {
      Integer i = 0;
      while ((i < grPalabras.size()) && (!grPalabras.get(i).getPalabra().equals(p))) {
         i++;
      }
      if (i >= grPalabras.size()) {
         i = -1;
         return null;
      }
      return grPalabras.get(i);
   }

   public void mostrar() {
      for (Palabra palabra : grPalabras) {
         System.out.println(palabra);
      }
   }

   public void unir(ConjuntoPalabras otro) {
      for (Palabra palabra : otro.grPalabras) {
         Palabra encontrada = this.buscar(palabra.getPalabra());
         if (encontrada != null) {
            encontrada.setCantidadVeces(encontrada.getCantidadVeces() + palabra.getCantidadVeces());
         } else {
            this.agregarPalabra(palabra);
         }
      }
   }
}
