package practica1_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFichero {

    public static void main(String[] args) {
        // Obtengo la ruta del archivo desde los argumentos de entrada
        String archivo = args[0];
        
        // Creo una instancia de LecturaFichero para poder invocar el método leerFichero
        LecturaFichero lector = new LecturaFichero();
        
        // Llamo al método leerFichero y le paso la ruta del archivo a leer
        lector.leerFichero(archivo);
    }
    
    public void leerFichero(String archivo) {
        
        // Indico que voy a comenzar a leer el archivo
        System.out.println("Leyendo archivo...");
        
        try {
            // Creo un FileReader para leer el archivo de texto
            FileReader fr = new FileReader(archivo);
            
            // Envuelvo el FileReader en un BufferedReader para leerlo línea por línea
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            
            // Leo el archivo línea por línea mientras haya contenido
            while ((linea = br.readLine()) != null) {
                // Imprimo cada línea del archivo en la consola
                System.out.println(linea);
            }
            
            // Cierro los recursos BufferedReader y FileReader después de terminar la lectura
            br.close();
            fr.close();
            
        } catch (FileNotFoundException e) {
            // Si no se encuentra el archivo, imprimo la traza del error
            e.printStackTrace();
        } catch (IOException e) {
            // Si hay un error de entrada/salida, imprimo la traza del error
            e.printStackTrace();
        } finally {
            // Al finalizar la lectura, imprimo un mensaje indicando que ha terminado
            System.out.println("Lectura finalizada");
        }
    }
}
