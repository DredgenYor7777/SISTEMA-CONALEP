
package controlador.bd;

import modelo.Usuario;


public class Sql {
    
    
    public static String insertarUsuario(Usuario usuario){ //Devuelve la sentencia SQL para insertar en entidad alumno
       
       return "INSERT INTO encargado  VALUES (NULL"+",' "
               +usuario.getNombre()+" ', ' "
               +usuario.getApellido()  +" ', ' "
               +usuario.getCorreo()+" ',' "
               +usuario.getTelefono()+" ', "    
               +usuario.getEdad() +" ) ";
   }
   
   public static String seleccionarUsuarios(){  //metodo para seleccionar un registro
       return "SELECT * FROM encargado";
   }
   
   public static String eliminarUsuario(int id){  //metodo para eliminar un registro
      return "DELETE FROM alumnos WHERE id_encargado = " +id;
   }
   
   public static String selectUsuario(int id){
         return "SELECT * FROM encargado WHERE id_encargado="+id;
   }
   
   public static String actualizarUsuario(Usuario usuario){
       
       return "UPDATE encargado SET id_encargado= ' "
               +",' "+usuario.getNombre()     +" ', ' "
               +usuario.getApellido()  +" ', ' "
               +usuario.getCorreo()+"',"
               +usuario.getTelefono()   +")"    
               +usuario.getEdad()       +","+
               " ' WHERE id_encargado=" +usuario.getId_usuario();
               
       
   }
   
   public static String validar(String usuario, String contrasena){
       
        return "SELECT * FROM usuario WHERE "+usuario+" = ? AND"+ contrasena+" = ?";
       
   }
   
   
       
    public static String registroUsuarioL(Usuario usuario){ //Devuelve la sentencia SQL para insertar en entidad alumno
       
       return "INSERT INTO usuario  VALUES (NULL"+",' " +usuario.getNombreUsuario()
               +" ', ' "+usuario.getContrasenia()+" ' )";
   }
    
}
