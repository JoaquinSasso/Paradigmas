package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.util.Comparator.comparing;


public class GestorViajeros {
   private Integer cantidad;
   private List<Viajero> grViajeros; // Cambia el array por una lista

   public GestorViajeros(Integer cant) {
       this.cantidad = 0;
       this.grViajeros = new ArrayList<>();
   }

   private Integer leerEntero(Scanner in, String mensaje) {
       System.out.println(mensaje);
       while (!in.hasNextInt()) {
           System.out.println("Valor inválido. " + mensaje);
           in.next();
       }
       int valor = in.nextInt();
       in.nextLine();
       return valor;
   }

   private String leerLinea(Scanner in, String mensaje) {
       System.out.println(mensaje);
       return in.nextLine();
   }

   public void cargarViajero(Scanner in) {
       Integer numero = leerEntero(in, "Ingrese el numero de viajero: ");
       String dni = leerLinea(in, "Ingrese el DNI del viajero: ");
       String nombre = leerLinea(in, "Ingrese el nombre del viajero: ");
       String apellido = leerLinea(in, "Ingrese el apellido del viajero: ");
       Integer millas = leerEntero(in, "Ingrese las millas del viajero: ");

       Viajero nuevo = new Viajero(numero, dni, nombre, apellido, millas);
       grViajeros.add(nuevo);
       cantidad++;
   }

   public void mostrarViajero (Scanner in)
   {
      Integer numero, i;
      System.out.println("Ingrese el numero del viajero: ");
      try {
         numero = in.nextInt();
         in.nextLine();
      }
      catch (Exception e){
         System.out.println(e.getMessage());
         System.out.println("Ingrese el numero del viajero: ");
         numero = in.nextInt();
         in.nextLine();
      }
      finally{}
      i = this.buscar(numero);
      if (i != -1) {   
         System.out.println(grViajeros.get(i));
      }
   }

   public Integer buscar(Integer numero)
   {
      Integer i = 0;
      while ((i < this.cantidad) && (this.grViajeros.get(i).getNumero() != numero)) {
         i++;
      }
      if (i >= this.cantidad) {
         i = -1;
         System.out.println("Viajero no encontrado");
      }
      return i;
   }

   public void mostrarMillas(Scanner in)
   {
      Integer numero, i;
      System.out.println("Ingrese el numero del viajero: ");
      try {
         numero = in.nextInt();
         in.nextLine();
      } catch (Exception e) {
         System.out.println("Ingrese el numero del viajero: ");
         numero = in.nextInt();
         in.nextLine();
      } finally {
      }
      i = this.buscar(numero);
      if (i != -1) {
         System.out.println("El viajero: " + grViajeros.get(i).getNombre() + " tiene :" + grViajeros.get(i).getMillas() + " millas.");
      }
   }

   public void acumularMillas(Scanner in)
   {
      Integer numero, i, millas;
      System.out.println("Ingrese el numero del viajero: ");
      numero = in.nextInt();
      in.nextLine();
      i = buscar(numero);
      if (i != -1) {
         System.out.println("Ingrese las millas a acumular: ");
         millas = in.nextInt();
         in.nextLine();
         grViajeros.get(i).setMillas(grViajeros.get(i).getMillas() + millas);
      }
   }

   public void canjearMillas(Scanner in)
   {
      Integer numero, i, millas, aux;
      System.out.println("Ingrese el numero del viajero: ");
      try {
         numero = in.nextInt();
         in.nextLine();
      } catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("Ingrese el numero del viajero: ");
         numero = in.nextInt();
         in.nextLine();
      }
      finally {}
      i = buscar(numero);
      if (i != -1) {
         System.out.println("Ingrese las millas a canjear: ");
         millas = in.nextInt();
         in.nextLine();
         aux = grViajeros.get(i).getMillas();
         if (aux >= millas) {
            millas = aux - millas;
            grViajeros.get(i).setMillas(millas);
            System.out.println("Millas canjeadas correctamente. Ahora tiene: " + millas + " millas.");
         }
         else {
            System.out.println("No tiene suficientes millas para canjear.");
         }
      }
   }
   
   public void mejorViajero() {
      Integer max = 0, maxI = 0;
      for (Integer i = 0; i < cantidad; i++) {
         if (grViajeros.get(i).getMillas() > max) {
            max = grViajeros.get(i).getMillas();
            maxI = i;
         }
      }
      System.out.println("El mejor viajero es: " + grViajeros.get(maxI).getNombre() + " "
            + grViajeros.get(maxI).getApellido() + " tiene :" + grViajeros.get(maxI).getMillas() + " millas.");
   }
   
   public void mostrarOrdenado() {
      grViajeros.stream()
            .sorted(comparing(Viajero::getMillas).reversed())
            .forEach(System.out::println);
   }
   
   public void mas200millas() {
      grViajeros.stream()
            .filter(i -> i.getMillas() > 200)
            .forEach(i -> System.out.println(i.getNombre()));
   }

   public void masMillas() {
      grViajeros.stream()
      .sorted(comparing(Viajero::getMillas).reversed())
      .limit(1)
      .forEach(System.out::println);
   }
   
}
