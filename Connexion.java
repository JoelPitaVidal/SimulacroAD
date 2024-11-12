package dao; // Define el paquete 'dao'

import java.sql.Connection; // Importa la clase Connection de java.sql para manejar conexiones a la base de datos
import java.sql.DriverManager; // Importa la clase DriverManager de java.sql para manejar controladores de base de datos
import java.sql.SQLException; // Importa la clase SQLException de java.sql para manejar excepciones SQL

public class Connexion { // Declara la clase Connexion
    /**
     * Datos de conexion
     */
    private static String driver = "jdbc:postgresql:"; // Define el controlador JDBC para PostgreSQL
    private static String host = "//localhost:"; // Define el host de la base de datos (localhost)
    private static String porto = "5432"; // Define el puerto para la conexión a la base de datos
    private static String sid = "adeptasoroitas"; // Define el identificador de la base de datos
    private static String usuario = "postgres"; // Define el nombre de usuario para la conexión
    private static String password = "postgres"; // Define la contraseña para la conexión
    private static String url = driver + host + porto + "/" + sid; // Combina todas las partes para formar la URL de conexión completa

    /**
     * Metodo que devuelve la conexion con la bd
     * @return Conexion
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, password); // Intenta establecer una conexión a la base de datos usando la URL, el usuario y la contraseña
        } catch (SQLException e) { // Captura cualquier excepción SQL que ocurra durante la conexión
            System.out.println("Error en la conexion a la base de datos: " + e.getMessage()); // Muestra un mensaje de error si ocurre una excepción
            return null; // Devuelve null si ocurre una excepción
        }
    }
}
