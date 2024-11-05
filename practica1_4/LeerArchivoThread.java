package practica1_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PipedOutputStream;

public class LeerArchivoThread extends Thread {
    
    // Defino una variable para almacenar el flujo de salida (PipedOutputStream).
    PipedOutputStream output;
    
    // Constructor que recibe un PipedOutputStream y lo asigna a la variable 'output'.
    public LeerArchivoThread(PipedOutputStream outs) {
        this.output = outs;
    }

    
    @Override
    public void run() {
        // Uso un BufferedReader para leer el archivo "hosts" ubicado en la ruta especificada.
        try (BufferedReader reader = new BufferedReader(new FileReader("src/practica1_4/hosts"))) {
            String linea;
            
            // Leo el archivo línea por línea. Mientras haya una línea que leer, el bucle continúa.
            while ((linea = reader.readLine()) != null) {
                // Escribo cada línea leída al flujo de salida (output), agregando un salto de línea.
                output.write((linea + "\n").getBytes());  // Enviar cada línea a través del PipedOutputStream
            }
            
            // Una vez que termino de leer todas las líneas del archivo, cierro el flujo de salida.
            output.close();
            
        } catch (IOException e) {
            // Si ocurre algún error durante la lectura del archivo o la escritura en el flujo, imprimo la traza del error.
            e.printStackTrace();
        }
    }
}
