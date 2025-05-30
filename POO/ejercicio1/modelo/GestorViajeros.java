package modelo;

import java.util.Scanner;

public class GestorViajeros {
   private Integer cantidad;
   private Viajero[] grViajeros;

   public GestorViajeros(Integer cant)
   {
      this.cantidad = 0;
      this.grViajeros = new Viajero[cant];
   }
   
   public void cargarViajero ()
   {
      Integer numero, millas;
      String nombre, apellido, dni;
      Scanner in = new Scanner(System.in);
      System.out.println("Ingrese el numero de viajero: ");
      try{
         numero = in.nextInt();
      }
      catch (Exception e){
         System.out.println(e.getMessage());
         numero = in.nextInt();
      }
      finally{}
      System.out.println("Ingrese el DNI del viajero: ");
      dni = in.nextLine();
      System.out.println("Ingrese el nombre del viajero: ");
      nombre = in.nextLine();
      System.out.println("Ingrese el apellido del viajero: ");
      apellido = in.nextLine();
      System.out.println("Ingrese las millas del viajero: ");
      try{
         millas = in.nextInt();
      }
      catch (Exception e){
         System.out.println(e.getMessage());
         millas = in.nextInt();
      }
      finally{}
      this.grViajeros[this.cantidad] = new Viajero(numero, dni, nombre, apellido, millas);
      this.cantidad++;
      in.close();
   }
   
   public void mostrarViajero ()
   {
      Integer numero, i;
      Scanner in = new Scanner(System.in);
      System.out.println("Ingrese el numero del viajero: ");
      try{
         numero = in.nextInt();
      }
      catch (Exception e){
         System.out.println(e.getMessage());
         numero = in.nextInt();
      }
      finally{}
      i = this.buscar(numero);
      if (i != -1) {   
         System.out.println(grViajeros[i]);
      }

      in.close();
   }

   public Integer buscar(Integer numero)
   {
      Integer i = 0;
      while ((i < this.cantidad) && (this.grViajeros[i].getNumero() != numero)) {
         i++;
      }
      if (i >= this.cantidad) {
         i = -1;
         System.out.println("Viajero no encontrado");
      }
      return i;
   }

   public void mostrarMillas()
   {
      Integer numero, i;
      Scanner in = new Scanner(System.in);
      System.out.println("Ingrese el numero del viajero: ");
      try {
         numero = in.nextInt();
      } catch (Exception e) {
         System.out.println(e.getMessage());
         numero = in.nextInt();
      } finally {
      }
      i = this.buscar(numero);
      if (i != -1) {
         System.out.println("El viajero: " + grViajeros[i].getNombre() + " tiene :" + grViajeros[i].getMillas() + " millas.");
      }

      in.close();
   }
   
   public void acumularMillas()
   {
      Integer numero, i, millas;
      Scanner in = new Scanner(System.in);
      System.out.println("Ingrese el numero del viajero: ");
      numero = in.nextInt();
      i = buscar(numero);
      if (i != -1) {
         System.err.println("Ingrese las millas a acumular: ");
         millas = in.nextInt();
         grViajeros[i].setMillas(grViajeros[i].getMillas() + millas);
      }
      in.close();
   }

   public void canjearMillas()
   {
      Integer numero, i, millas, aux;
      Scanner in = new Scanner(System.in);
      System.out.println("Ingrese el numero del viajero: ");
      numero = in.nextInt();
      i = buscar(numero);
      if (i != -1) {
         System.err.println("Ingrese las millas a acumular: ");
         millas = in.nextInt();
         aux = grViajeros[i].getMillas();
         if (aux >= millas) {
            millas -= aux;
         }
         grViajeros[i].setMillas(millas);
      }
      in.close();
   }
   
   public void mejorViajero() {
      Integer max = 0, maxI = 0;
      for (Integer i = 0; i < cantidad; i++)
      {
         if (grViajeros[i].getMillas() > max) {
            max = grViajeros[i].getMillas();
            maxI = i;
         }
      }
      System.out.println("El mejor viajero: " + grViajeros[maxI].getNombre() + " tiene :" + grViajeros[maxI].getMillas() + " millas.");
   }
}
