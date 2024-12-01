
package controlador.bd;

import modelo.InventarioLibros;
import modelo.Libro;

public class Sql4 {
    
    public static String insertarLibro(Libro libro){ //Devuelve la sentencia SQL para insertar en entidad alumno
       
       return "INSERT INTO libro  VALUES (NULL,"
               +" ' "+libro.getNombreLibro() +" ', ' "
               +libro.getCategoriaLibro()  +" ', ' "
               +libro.getEditorial()  +" ', ' "
               +libro.getAutor()  +" '," 
               +libro.getNumPagina() + ","
               +libro.getCantidad()+" )";
   }
   
   public static String seleccionarLibro(){  //metodo para seleccionar un registro
       return "SELECT * FROM libro";
   }
   
      public static String seleccionarLibro2(){  //metodo para seleccionar un registro
          Libro libro = new Libro(); // "+libro.getCantidad()+"
       return "SELECT id_libro, nombreLibro, cantidad FROM libro";
   }
      
            public static String seleccionarLibro3(){  //metodo para seleccionar un registro
       return "SELECT  id_libro, nombreLibro, autor, editorial , cantidad FROM libro";
   }
   
   
   public static String eliminarLibro(int id){  //metodo para eliminar un registro
      return "DELETE FROM libro WHERE id_libro = " +id;
   }
   
   public static String selectLibro(int id){
         return "SELECT * FROM libro WHERE id_libro="+id;
   }
   
   public static String actualizarLibro(Libro libro){
       
       return "UPDATE libro SET "
            + "nombreLibro = '" + libro.getNombreLibro() + "', "
            + "categoriaLibro = '" + libro.getCategoriaLibro() + "', "
            + "autor = '" + libro.getAutor() + "', "
            + "editorial = '" + libro.getEditorial() + "', "
            + "numeroPagina = " + libro.getNumPagina() + ", "
            + "cantidad = " + libro.getCantidad() + " "
            + "WHERE id_libro = " + libro.getId_libro();
   }
    
}
