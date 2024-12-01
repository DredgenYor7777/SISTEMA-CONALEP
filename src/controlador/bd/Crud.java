
package controlador.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author berny
 */
public class Crud {
    
    PreparedStatement pst;
    Statement st;
    int filaAefctada;

    
    public Crud(){
        
        this.st = null;
        this.filaAefctada = 0;
    }
    
    public boolean insertar(String sql){  
        
        try{
            this.pst = (PreparedStatement) Conexion.conexion.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
            this.filaAefctada = pst.executeUpdate();  //este metodo devuelve el numero de filas afectadas
            System.out.println("Insertando correctamente...");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " +ex.getMessage());
            return false;
        }
    }//cierra llave insertar
    
    //metodo seleccionar 
    
     public ResultSet seleccionar (String sql){
        
        try {
            //preparando la conexion
            this.st = Conexion.conexion.createStatement();
            //ejecutamos el sql y obtenemos resultados
            return this.st.executeQuery(sql);
            
        } catch (SQLException | ClassCastException e) {
            
            System.err.println("Error al seleccionar: " +e.getMessage());
            return null;
        }
    }//cierra metodo seleccionar
    
    
 public boolean actualizarEliminar(String sql)   {   //metodo que permite actualizar y eliminar 
     
     try {
         this.st = Conexion.conexion.createStatement();
         this.st.executeUpdate(sql);
         
         return true;
     } catch (SQLException | ClassCastException e) {
         
         System.err.println("Error al realizar la accion: "+e.getMessage());
         return false;
     }
 }//cierra metodo 
 
 
 public PreparedStatement validar(String sql){
     
      try {
            //preparando la conexion
            this.st = Conexion.conexion.createStatement();
            //ejecutamos el sql y obtenemos resultados
            return (PreparedStatement) this.st.executeQuery(sql);
            
        } catch (SQLException | ClassCastException e) {
            
            System.err.println("Error al seleccionar: " +e.getMessage());
            return null;
        }
     

     
 }
 
 
 
 public int obtenerUltimoIdInsertado() {
        int ultimoId = -1;
        try (ResultSet rs = pst.getGeneratedKeys()) {
            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el último ID insertado: " + ex.getMessage());
        }
        return ultimoId;
    }
 
 
 
 public boolean actualizarCantidadLibro(int idLibro, int nuevaCantidad) {
    String sql = "UPDATE libro SET cantidad = ? WHERE id_libro = ?";
    try {
        pst = Conexion.conexion.prepareStatement(sql);
        pst.setInt(1, nuevaCantidad);
        pst.setInt(2, idLibro);
        filaAefctada = pst.executeUpdate();
        return filaAefctada > 0;
    } catch (SQLException ex) {
        System.out.println("Error al actualizar la cantidad en libro: " + ex.getMessage());
        return false;
    }
}

public boolean actualizarCantidadDisponibleInventario(int idLibro, int nuevaCantidadDisponible) {
    String sql = "UPDATE inventario SET cantidadDisponible = ? WHERE id_libro = ?";
    try {
        pst = Conexion.conexion.prepareStatement(sql);
        pst.setInt(1, nuevaCantidadDisponible);
        pst.setInt(2, idLibro);
        filaAefctada = pst.executeUpdate();
        return filaAefctada > 0;
    } catch (SQLException ex) {
        System.out.println("Error al actualizar la cantidad disponible en inventario: " + ex.getMessage());
        return false;
    }
}

    
}
