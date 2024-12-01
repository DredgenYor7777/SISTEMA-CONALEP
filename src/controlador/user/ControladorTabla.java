
package controlador.user;


public class ControladorTabla {
    
    private static ControladorTabla instance;
    private int idSeleccionado;

    private ControladorTabla() {}

    public static ControladorTabla getInstance() {
        if (instance == null) {
            instance = new ControladorTabla();
        }
        return instance;
    }

    public int getIdSeleccionado() {
        return idSeleccionado;
    }

    public void setIdSeleccionado(int idSeleccionado) {
        this.idSeleccionado = idSeleccionado;
    }
    
}
