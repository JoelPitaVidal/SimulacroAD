import java.sql.Connection; // Importa la clase Connection de java.sql para manejar conexiones a la base de datos
import java.sql.ResultSet; // Importa la clase ResultSet de java.sql para manejar los resultados de consultas a la base de datos
import java.sql.SQLException; // Importa la clase SQLException de java.sql para manejar excepciones SQL
import java.sql.Statement; // Importa la clase Statement de java.sql para ejecutar consultas SQL
import java.util.ArrayList; // Importa la clase ArrayList de java.util para manejar listas dinámicas

public class CRUD { // Declara la clase CRUD
    private Connection connection; // Declara una variable privada de tipo Connection para manejar la conexión a la base de datos
    private Statement statement; // Declara una variable privada de tipo Statement para ejecutar consultas SQL
    private ResultSet resultSet; // Declara una variable privada de tipo ResultSet para almacenar los resultados de las consultas SQL

    // Constructor de la clase CRUD que recibe una consulta SQL como parámetro
    public CRUD(String query) throws SQLException {
        connection = Connexion.getConnection(); // Obtiene una conexión a la base de datos usando el método getConnection de la clase Connexion
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, // Tipo de ResultSet que permite desplazamiento y actualizaciones
                ResultSet.CONCUR_UPDATABLE // Permite actualizar el ResultSet
        );
        resultSet = statement.executeQuery(query); // Ejecuta la consulta SQL y almacena el resultado en resultSet
    }

    // Método para listar unidades según una lista de IDs
    public ArrayList<String> listarUnidades(ArrayList<Integer> ids) {
        ArrayList<String> unidades = new ArrayList<>(); // Crea una lista para almacenar las unidades encontradas
        try {
            resultSet.beforeFirst(); // Coloca el cursor antes del primer registro en el ResultSet
            while (resultSet.next()) { // Itera sobre cada registro en el ResultSet
                for (int i = 0; i < ids.size(); i++) { // Itera sobre cada ID en la lista de IDs
                    if (resultSet.getInt("cod") == ids.get(i)) { // Compara el valor de "cod" en el ResultSet con el ID actual
                        String nome = resultSet.getString("nome"); // Obtiene el valor de la columna "nome"
                        Integer puntos = resultSet.getInt("puntos"); // Obtiene el valor de la columna "puntos"
                        unidades.add(nome + " -  " + puntos); // Añade la unidad encontrada a la lista de unidades
                    }
                }
            }
        } catch (SQLException e) { // Captura excepciones SQL
            System.out.println("No se han encontrado resultados" + e.getMessage()); // Muestra un mensaje de error en caso de excepción
        }
        return unidades; // Retorna la lista de unidades encontradas
    }
}
