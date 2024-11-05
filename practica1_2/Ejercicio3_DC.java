package practica1_2;

import java.io.IOException;

public class Ejercicio3_DC {

    public static void main(String[] args) {
        // Obtengo la ruta del directorio de inicio del usuario actual usando System.getProperty
        String ruta = System.getProperty("user.home");
        
        // Creo una instancia de la clase Ejercicio3_DC para invocar el método lanzadorProceso
        Ejercicio3_DC nuevo = new Ejercicio3_DC();
        
        try {
            // Intento lanzar el proceso que ejecutará la clase EscrituraFichero con la ruta obtenida
            nuevo.lanzadorProceso(ruta);
        } catch (IOException e) {
            // Si ocurre una excepción de E/S, imprimo la traza del error
            e.printStackTrace();
        }
    }
    
    public void lanzadorProceso(String ruta) throws IOException {
    	
    	System.out.println("Lanzando proceso...");
        // Especifico la clase que quiero ejecutar desde el proceso externo
        String clase = "practica1_2.EscrituraFichero";
        
        // Configuro el ProcessBuilder para ejecutar la clase EscrituraFichero con la ruta del directorio de inicio
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", clase, ruta);
        
        // Heredo la entrada/salida del proceso principal para ver la salida en la consola actual
        pb.inheritIO();
        
        // Inicio el proceso para ejecutar la clase EscrituraFichero
        pb.start();
        
        // Redirijo los errores para que también se impriman en la salida estándar
        pb.redirectErrorStream();
    }

}
