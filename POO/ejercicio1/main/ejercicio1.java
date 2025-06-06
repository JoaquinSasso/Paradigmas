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
               "Menu de opciones\n1)Cargar viajero\n2)Mostrar viajero\n3)Consultar Millas\n4)Acumular Millas\n5)Canjear Millas\n6)Mejor Viajero\n0)Salir");
         try {
            System.out.print("Ingrese una opcion: ");
            opcion = in.nextInt();
            in.nextLine();
         } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Ingrese una opcion valida: ");
            opcion = in.nextInt();
            in.nextLine();
         } finally {
         }
         switch (opcion) {
            case 1:
               gestor.cargarViajero(in);
               break;
            case 2:
               gestor.mostrarViajero(in);
               break;
            case 3:
               gestor.mostrarMillas(in);
               break;
            case 4:
               gestor.acumularMillas(in);
               break;
            case 5:
               gestor.canjearMillas(in);
               break;
            case 6:
               gestor.mejorViajero();
               break;
            case 0:
               System.out.println("Saliendo del programa...");
               break;
            default:
               System.out.println("Opcion incorrecta");
               break;
         }
      }
      in.close();
   }
}
/*Lote de prueba
1
1
44991289
Joaquin
Sasso
2000
1
2
45886734
Maria
Gomez
1500
1
3
45635995
Valentin
Vilches
700
1
4
45635647
Juan
Torti
1700
*/