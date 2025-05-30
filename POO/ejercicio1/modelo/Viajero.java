package modelo;

public class Viajero {

   private Integer numero;
   private String dni;
   private String nombre;
   private String apellido;
   private Integer millas;

   public Viajero(Integer numero, String dni, String nombre, String apellido, Integer millas)
   {
      this.numero = numero;
      this.dni = dni;
      this.nombre = nombre;
      this.apellido = apellido;
      this.millas = millas;
   }
   
   public Integer getNumero() {
      return numero;
   }

   public void setNumero(Integer numero) {
      this.numero = numero;
   }
   public String getDni() {
      return dni;
   }
   public void setDni(String dni) {
      this.dni = dni;
   }
   public String getNombre() {
      return nombre;
   }
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }
   public Integer getMillas() {
      return millas;
   }

   public void setMillas(Integer millas) {
      this.millas = millas;
   }

   @Override
   public String toString()
   {
      return "Viajero n: " + numero + ", nombre: " + nombre + " " + apellido + " tiene: " + millas + " millas.";
   }

}