
package modelo;

/**
 *
 * @author berny
 */
public class InventarioLibros extends Libro{
    private int id_inventario;
    private int stock;
    private int cantDisponible;
    private String estado;

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    @Override
      public int getId_libro() {
        return id_libro;
    }

    @Override
    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }
    
}
