package practica1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Declaro la clase OrdenarDominiosThread que hereda de Thread, lo que permite ejecutar este c�digo en un hilo separado.
public class OrdenarDominiosThread extends Thread {
    // Defino una variable privada para almacenar el flujo de entrada (PipedInputStream) desde donde leer los datos.
    private PipedInputStream inputS;

    // Constructor que recibe un PipedInputStream como par�metro para inicializar la variable inputS.
    public OrdenarDominiosThread(PipedInputStream pis) {
        this.inputS = pis;
    }

    // Sobrescribo el m�todo run() que se ejecuta cuando el hilo es iniciado.
    @Override
    public void run() {
        try {
            // Utilizo BufferedReader para leer de manera m�s eficiente los datos del InputStream.
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputS));
            
            // Creo una lista para almacenar los dominios que voy a leer.
            List<String> dominios = new ArrayList<>();
            String linea;

            // Leo l�nea por l�nea los datos enviados desde el primer hilo.
            // Mientras haya l�neas para leer, el bucle continuar�.
            while ((linea = reader.readLine()) != null) {
                // Divido cada l�nea en partes usando espacios como separador.
                String[] partes = linea.trim().split(" "); // Separar por espacios.
                // Si la l�nea tiene m�s de una parte, a�ado el segundo elemento a la lista de dominios.
                if (partes.length > 1) {
                    dominios.add(partes[1]); // Agregar el segundo valor si existe.
                }
            }

            // Ordeno alfab�ticamente la lista de dominios.
            Collections.sort(dominios);

            // Muestro por pantalla los dominios ya ordenados.
            System.out.println("Dominios ordenados alfab�ticamente:");
            for (String dominio : dominios) {
                System.out.println(dominio);
            }

        } catch (IOException e) {
            // En caso de que ocurra un error de entrada/salida, imprimo la traza del error para poder identificar el problema.
            e.printStackTrace();
        }
    }
}
