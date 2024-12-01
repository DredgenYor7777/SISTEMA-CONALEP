
package controlador.bd;

import modelo.Alumno;

public class Sql2 {
    
    public static String insertarAlumno(Alumno alumno){ //Devuelve la sentencia SQL para insertar en entidad alumno
       
       return "INSERT INTO alumno  VALUES (NULL"
               +",' "+alumno.getNombre()+" ', ' "
               +alumno.getApellido()  +" ', ' "
               +alumno.getCorreo()+" ',"
               +alumno.getTelefono()   +","    
               +alumno.getEdad()       +")";
   }
   
   public static String seleccionarAlumnos(){  //metodo para seleccionar un registro
       return "SELECT * FROM alumno";
   }
   
      public static String seleccionarAlumnos2(){  //metodo para seleccionar un registro
       return "SELECT id_alumno, nombreAlumno FROM alumno";
   }
   
   public static String eliminarAlumno(int id){  //metodo para eliminar un registro
      return "DELETE FROM alumno WHERE id_alumno = " +id;
   }
   
   public static String selectAlumno(int id){
         return "SELECT * FROM alumno WHERE id_alumno="+id;
   }
   
   public static String actualizarAlumno(Alumno alumno){
       
    return "UPDATE alumno SET " +
           "nombreAlumno = '" + alumno.getNombre() + "', " +
           "apeliidoAlumno = '" + alumno.getApellido() + "', " +
           "direccionAlumno = '" + alumno.getCorreo() + "', " +
           "telefonoAlumno = " + alumno.getTelefono() + ", " +
           "edadAlumno = " + alumno.getEdad() + 
           " WHERE id_alumno = " + alumno.getId_alumno() + ";";


       
//       return "UPDATE alumno SET id_alumno= "+"' "+alumno.getNombre()     +" ', ' "
//               +alumno.getApellido()  +" ', ' "
//               +alumno.getCorreo()+"',"
//               +alumno.getTelefono()+","+alumno.getEdad()+")"+" WHERE id_alumno=" +alumno.getId_alumno();
               
       
   }
    
}
