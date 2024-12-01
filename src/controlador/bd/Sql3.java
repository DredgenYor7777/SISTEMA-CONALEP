
package controlador.bd;

import gui.Inventario;
import modelo.InventarioLibros;
import modelo.Libro;
import modelo.Prestamo;

public class Sql3 extends Libro{
    
    
    Prestamo prestamo;
    
    public static String insertarInventario(InventarioLibros inventario){ //Devuelve la sentencia SQL para insertar en entidad alumno
       
        Libro libro= new Libro();
       
       return "INSERT INTO inventario (id_libro, stock, cantidadDisponible) VALUES (" 
                + inventario.getId_libro() + ", " 
                + inventario.getStock() + ", " 
                + inventario.getCantDisponible() + ")";
       
       
//       +",  "
//               +inventario.getCantDisponible()+
   }
   
   public static String seleccionarInventario(){  //metodo para seleccionar un registro
       return "SELECT * FROM inventario";
   }
   
   public static String eliminarInventario(int id){  //metodo para eliminar un registro
      return "DELETE FROM inventario WHERE id_inventario = " +id;
   }
   
   public static String selectInventario(int id){
         return "SELECT * FROM inventario WHERE id_inventario="+id;
   }
   
   public static String actualizarinventario(InventarioLibros inventario){
       
       return "UPDATE inventario SET stock= " + inventario.getStock() + ", cantidadDisponible= " + inventario.getCantDisponible() + " WHERE id_inventario= " + inventario.getId_inventario();

   }
   
   
   
      public static String seleccionarInventario2(){  //metodo para seleccionar un registro
          Libro libro = new Libro();
          Prestamo prestamo = new Prestamo();
          InventarioLibros inventario = new InventarioLibros();
          
       return "SELECT "+libro.getId_libro()+", "+libro.getCantidad()+", "+inventario.getCantDisponible()
               +", "+ prestamo.getId_prestamo()
               +" FROM libro p " +" JOIN inventario l ON l.id_inventario ="+inventario.getId_inventario();
   }
      
       public static String seleccionarInventario3(){  //metodo para seleccionar un registro
  
           return "SELECT p.id_libro, p.cantidad, l.cantidadDisponible, l.estado FROM libro p JOIN inventario l ON l.id_inventario = l.id_inventario";
    
}
       
}