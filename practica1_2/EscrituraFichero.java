package practica1_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class EscrituraFichero {

    public static void main(String[] args) {
        
        // Recibo la ruta del directorio desde los argumentos de entrada
        String ruta = args[0];
        
        // Creo una instancia de la clase para luego llamar al método escribirFichero
        EscrituraFichero nuevo = new EscrituraFichero();
        
        // Llamo al método escribirFichero pasando la ruta como parámetro
        nuevo.escribirFichero(ruta);

    }
    
    public void escribirFichero(String fichero) {
    	
    	System.out.println("Entrando a metodo escribir fichero.....");
        
        // Genero el nombre del archivo usando la fecha y la hora actuales para evitar duplicados
        String fechaHora = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date(System.currentTimeMillis()));
        
        // Combino la fecha y hora con un prefijo "content_" para formar el nombre del archivo .log
        String nombreFichero = "content_" + fechaHora + ".log";
        
        // Creo un objeto File para el archivo en la ruta especificada
        File archivo = new File("src/practica1_2/" + nombreFichero);
        int contador = 1;
        
        // Verifico si ya existe un archivo con el mismo nombre, y si es así, añado un número entre paréntesis
        while (archivo.exists()) {
            nombreFichero = "content_" + fechaHora + "(" + contador + ").log";
            archivo = new File("src/practica1_2/" + nombreFichero);
            contador++;
        }
        
        // Obtengo la lista de archivos dentro del directorio proporcionado
        File[] archivos = new File(fichero).listFiles();
        
        // Recorro cada archivo del directorio
        for (File file : archivos) {

            // Imprimo el nombre del archivo en la consola para verificar el contenido
            System.out.println(file.getName());
            
            try {    
                // Abro el archivo en modo append (añadir) para no sobrescribir el contenido existente
                FileWriter fw = new FileWriter(archivo, true);
                
                // Escribo el nombre del archivo en el archivo .log, añadiendo una nueva línea
                fw.write(file.getName() + "\n");
                
                // Cierro el FileWriter para liberar los recursos
                fw.close(); 
            } catch (IOException e) {
                // Si ocurre una excepción de E/S, imprimo la traza del error
                e.printStackTrace();
            }

        }

    }

}
