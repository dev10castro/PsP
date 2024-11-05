package practica1_2;

import java.io.IOException;

public class Ejercicio2_DC {

    public static void main(String[] args) {
        
        // Defino la ruta del archivo carpetas.txt que se encuentra en el directorio src/practica1_2
        String archivo = "src/practica1_2/carpetas.txt";
        
        // Creo una instancia de Ejercicio2_DC para poder llamar al método lanzadorProceso
        Ejercicio2_DC lanzador = new Ejercicio2_DC();
        
        // Llamo al método lanzadorProceso, pasándole la ruta del archivo como argumento
        lanzador.lanzadorProceso(archivo);

    }

    public void lanzadorProceso(String archivo) {

        try {
            // Defino la clase que quiero ejecutar en el proceso externo, en este caso LecturaFichero
            String clase = "practica1_2.LecturaFichero";
            
            // Configuro el ProcessBuilder para ejecutar la clase LecturaFichero con la ruta del archivo carpetas.txt
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", clase, archivo);
            
            // Imprimo un mensaje para indicar que se está lanzando el proceso
            System.out.println("Lanzando proceso...");
            
            // Heredo la entrada y salida del proceso principal para que se vea la salida en la misma consola
            pb.inheritIO();
            
            // Inicio el proceso que ejecutará LecturaFichero
            pb.start();
            
        } catch (IOException e) {
            // Si ocurre una excepción de E/S, imprimo la traza del error
            e.printStackTrace();
        }
    }

}
