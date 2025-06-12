package interfaces;
import java.util.List;
import excepciones.IntegrantesInvalidosException;

import modelo.Deportista;

public interface IDeporte {
   public Integer cantidadMinima = 2; // Cantidad mínima de integrantes para formar un equipo o pareja
   
   /**
   * Método para conformar un equipo o pareja con los integrantes pasados como parámetro.
   * @param integrantes una lista de deportistas que conforman el equipo o pareja.
   * @throws IntegrantesInvalidosException si la cantidad de integrantes no es válida.
   * @return el resultado de la operacion.
   */
   Boolean conformar(List<Deportista> integrantes) throws IntegrantesInvalidosException;
   /**
   * Método para mostrar los datos de cada equipo o pareja.
   */
   void mostrar();

   /**
   * Método para enumerar todos los deportistas del equipo o pareja.
   */
   void numeroDeportista();
}
