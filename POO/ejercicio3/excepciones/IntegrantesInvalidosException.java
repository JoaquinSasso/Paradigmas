package excepciones;

/** 
 *  Excepción personalizada para manejar casos de integrantes inválidos en un deporte.
 *  Esta excepción se lanza cuando la cantidad de integrantes no cumple con los requisitos mínimos.
 */
public class IntegrantesInvalidosException extends Exception {
      public IntegrantesInvalidosException(String message) {
         super(message);
      }
   
      public IntegrantesInvalidosException(String message, Throwable cause) {
         super(message, cause);
      }
   
      public IntegrantesInvalidosException(Throwable cause) {
         super(cause);
      }
}
