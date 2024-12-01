
package controlador.bd;


import modelo.Libro;
import modelo.Prestamo;
import java.text.SimpleDateFormat;



public class Sql5 {
    
    public static String insertarPrestamo(Prestamo prestamo){ 
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fechaPres = sdf.format(prestamo.getFecPrestamo());
    String fechaDev = sdf.format(prestamo.getFecDev());

    // Construye la sentencia SQL para la inserción
    return "INSERT INTO prestamo VALUES (NULL, ' "
            + fechaPres + " ', '"
            + fechaDev + "', "
            + prestamo.getFkIdLibro() + ", "
            + prestamo.getFkIdAlumno() + ")";

   }
    

   public static String seleccionarPrestamo(){  //metodo para seleccionar un registro
       return "SELECT * FROM prestamo";
   }
   
   public static String eliminarPrestamo(int id){  //metodo para eliminar un registro
      return "DELETE FROM prestamo WHERE id_prestamo = " +id;
   }
   
   public static String selectLibro(int id){
         return "SELECT * FROM libro WHERE id_libro="+id;
   }
   
   public static String actualizarLibro(Libro libro){
       
       return "UPDATE libro SET id_libro= ' "
               +",' "+libro.getNombreLibro() +" ', ' "
               +libro.getCategoriaLibro()  +" ', ' "
               +libro.getAutor()  +" ', ' "
               +libro.getEditorial()  +" ', ' "
               +libro.getAutor()  +" ', ' "
               +libro.getNumPagina()  +" ', ' "
               +libro.getCantidad()+"'," +
               " ' WHERE id_libro=" +libro.getId_libro();
   }
    
}
