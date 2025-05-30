package main;

import modelo.GestorViajeros;
import java.util.Scanner;

public class ejercicio1 {

   public static void main(String[] args) {
      Integer opcion = 1;
      Scanner in = new Scanner(System.in);
      GestorViajeros gestor = new modelo.GestorViajeros(10);
      while (opcion != 0) {
         System.out.println(
               "Menu de opciones\n1)Cargar viajero\n2)Mostrar viajero\n3)Consultar Millas\n4)Acumular Millas\n5)Canjear Millas\n6)Mejor Viajero\n");
         opcion = in.nextInt();
         switch (opcion) {
            case 1:
               gestor.cargarViajero();
               break;
            case 2:
               gestor.mostrarViajero();
               break;
            case 3:
               gestor.mostrarMillas();
               break;
            case 4:
               gestor.acumularMillas();
               break;
            case 5:
               gestor.mejorViajero();
               break;
            default:
               System.out.println("Opcion incorrecta");
               break;
         }
      }
      in.close();
   }
}