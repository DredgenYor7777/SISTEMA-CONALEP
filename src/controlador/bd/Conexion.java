package controlador.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String USUARIO = "root";
    private static final String PASSWORD = "cayde";
    private static final String BD = "conalep";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true"; // host de la base de datos 
    
    public static Connection conexion;

    // Método para obtener una conexión a la base de datos
    public static Connection iniciar() throws SQLException {
        // Verificamos si la conexión está cerrada o es nula antes de crear una nueva
        if (conexion == null || conexion.isClosed()) {
            try {
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión a la base de datos exitosa.");
            } catch (SQLException e) {
                System.out.println("Error al establecer la conexión: " + e.getMessage());
                throw e; // Lanzamos la excepción para que pueda ser manejada externamente
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión a la base de datos
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Método para verificar el estado de la conexión
    public static boolean isConexionAbierta() {
        try {
            return conexion != null && !conexion.isClosed();
        } catch (SQLException e) {
            // En caso de que ocurra un error al verificar el estado de la conexión
            System.out.println("Error al verificar el estado de la conexión: " + e.getMessage());
            return false;
        }
    }
}
