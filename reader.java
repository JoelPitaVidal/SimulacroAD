package readerwriter; // Define el paquete 'readerwriter'

import java.io.BufferedReader; // Importa la clase BufferedReader de java.io para leer texto de una entrada de caracteres
import java.io.FileNotFoundException; // Importa la clase FileNotFoundException de java.io para manejar excepciones cuando un archivo no se encuentra
import java.io.FileReader; // Importa la clase FileReader de java.io para leer archivos
import java.util.ArrayList; // Importa la clase ArrayList de java.util para manejar listas dinámicas

public class Reader { // Declara la clase Reader
    String ruta; // Declara una variable de instancia para almacenar la ruta del archivo
    FileReader fileReader; // Declara una variable de instancia para manejar la lectura del archivo
    BufferedReader bufferedReader; // Declara una variable de instancia para leer el archivo de manera eficiente

    // Constructor de la clase Reader que recibe la ruta del archivo como parámetro
    public Reader(String ruta) {
        this.ruta = ruta; // Asigna la ruta del archivo a la variable de instancia
        this.fileReader = getFileReader(ruta); // Inicializa fileReader usando el método getFileReader
        this.bufferedReader = getBufferedReader(fileReader); // Inicializa bufferedReader usando el método getBufferedReader
    }

    // Método que devuelve un FileReader para la ruta del archivo especificada
    public FileReader getFileReader(String ruta) {
        try {
            return new FileReader(ruta); // Intenta abrir el archivo y devolver un FileReader
        } catch (FileNotFoundException e) { // Captura excepciones si el archivo no se encuentra
            System.out.println("Error al abrir el archivo: " + e.getMessage()); // Muestra un mensaje de error
            return null; // Devuelve null si ocurre una excepción
        }
    }

    // Método que devuelve un BufferedReader para un FileReader especificado
    public BufferedReader getBufferedReader(FileReader fileReader) {
        return new BufferedReader(fileReader); // Devuelve un BufferedReader para el FileReader dado
    }

    // Método para leer el archivo y devolver una lista de enteros
    public ArrayList<Integer> leerArchivo() {
        ArrayList<Integer> lista = new ArrayList<>(); // Crea una lista para almacenar los enteros leídos
        try {
            String linea; // Variable para almacenar cada línea leída
            while ((linea = bufferedReader.readLine()) != null) { // Lee cada línea del archivo
                lista.add(Integer.parseInt(linea)); // Convierte la línea a entero y la añade a la lista
            }
        } catch (Exception e) { // Captura cualquier excepción durante la lectura del archivo
            System.out.println("Error al leer el archivo: " + e.getMessage()); // Muestra un mensaje de error
        }
        return lista; // Devuelve la lista de enteros leídos
    }

    // Getter para la variable ruta
    public String getRuta() {
        return ruta; // Devuelve la ruta del archivo
    }

    // Setter para la variable ruta
    public void setRuta(String ruta) {
        this.ruta = ruta; // Establece la nueva ruta del archivo
    }

    // Getter para la variable fileReader
    public FileReader getFileReader() {
        return fileReader; // Devuelve el FileReader
    }

    // Setter para la variable fileReader
    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader; // Establece el nuevo FileReader
    }

    // Getter para la variable bufferedReader
    public BufferedReader getBufferedReader() {
        return bufferedReader; // Devuelve el BufferedReader
    }

    // Setter para la variable bufferedReader
    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader; // Establece el nuevo BufferedReader
    }
}
