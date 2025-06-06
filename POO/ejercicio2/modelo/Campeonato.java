package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import interfaces.IDeporte;


public class Campeonato {
    public static final String SEPARADOR = ",";
	
    public static List<Deportista> leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader bufferLectura = null;
        List<Deportista> datos = new ArrayList<>();
        try {
            bufferLectura = new BufferedReader(new FileReader(nombreArchivo));
            String linea;                  

            while ((linea = bufferLectura.readLine()) != null) {
                // Separar la linea leída con el separador definido previamente
                String[] campos = linea.split(SEPARADOR);
                Deportista d = new Deportista(campos[0], campos[1]);
             datos.add(d);           
            }
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
         // Cierro el buffer de lectura
         if (bufferLectura != null) {
             bufferLectura.close();
         }
        }
        return datos;
    }
    /**
    * Crea los equipos con los datos pasados como parámetro
    * @param datos lista con todos los deportistas inscriptos
     * @param cantidadJugadores cantidad de jugadores que conforman un equipo
     * @return una lista de equipos
    */
    public static List<IDeporte> creaEquipos(List<Deportista> datos, int cantidadJugadores) {
        List<IDeporte> equipos = new ArrayList<>();
        List<Deportista> integrantes = new ArrayList<>();
        
        for (Deportista d : datos) {
            integrantes.add(d);
            if (integrantes.size() == cantidadJugadores) {
                Equipo equipo = new Equipo("Equipo " + (equipos.size() + 1));
                if (equipo.conformar(integrantes)) {
                    equipos.add(equipo);
                }
                integrantes.clear(); // Reiniciar la lista de integrantes para el próximo equipo
            }
        }
        
        return equipos;
        
    }
    /**
    Crea los equipos con los datos pasados como parámetro
     * @param datos es una lista con todos los deportitas inscriptos
     * @return una lista de Parejas formadas
    */
    public static List<IDeporte> creaParejas(List<Deportista> datos) {
        List<IDeporte> parejas = new ArrayList<>();
        List<Deportista> integrantes = new ArrayList<>();
        
        for (Deportista d : datos) {
            integrantes.add(d);
            if (integrantes.size() == 2) {
                Pareja pareja = new Pareja();
                if (pareja.conformar(integrantes)) {
                    parejas.add(pareja);
                }
                integrantes.clear(); // Reiniciar la lista de integrantes para la próxima pareja
            }
        }
        
        return parejas;
        
    }
    /**
    * Numera cada integrante del equipo o de la pareja
     * @param datos 
    */
    public static void numerar(List<IDeporte> datos) {
        for (IDeporte equipo : datos) {
            equipo.numeroDeportista();
        }
    }
    /**
    * Muestra los datos de cada equipo o de cada pareja
     * @param datos
    */
    public static void mostrar(List<IDeporte> datos){
          for (IDeporte equipo : datos) {
            equipo.mostrar();
          }
    }

//Parte del codigo para el metodo main() que debera estar definido en la clase principal.    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int cantidadJugadoresFutbol= 5;                  
        List<Deportista> datosFutbol= leerArchivo("d:/Github Repositories/Paradigmas/POO/ejercicio2/datos/inscriptosFutbol.csv");
        List<Deportista> datosPinPon = leerArchivo("d:/Github Repositories/Paradigmas/POO/ejercicio2/datos/inscriptosPinPon.csv");
        List<IDeporte> equiposFutbol = creaEquipos(datosFutbol, cantidadJugadoresFutbol);
        List<IDeporte> parejasPinPon = creaParejas(datosPinPon);
        System.out.println("Equipos de futbol:");
        mostrar(equiposFutbol);
        System.out.println("Parejas de Pin Pon:");
        mostrar(parejasPinPon);
        System.out.println("Numerando los integrantes de los equipos de futbol:");
        numerar(equiposFutbol);
        System.out.println("Numerando los integrantes de las parejas de Pin Pon:");
        numerar(parejasPinPon);
        System.out.println("Fin del campeonato.");
    }
}
