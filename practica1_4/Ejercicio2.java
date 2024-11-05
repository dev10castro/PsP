package practica1_4;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;



public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		
		try {
            // Creo las tuberías para comunicar los hilos
            PipedOutputStream outS = new PipedOutputStream();
            PipedInputStream inputS = new PipedInputStream(outS);

            // Creo los hilos
            LeerArchivoThread lector = new LeerArchivoThread(outS);
            OrdenarDominiosThread ordenador = new OrdenarDominiosThread(inputS);

            // Inicio los hilos
            lector.start();
            ordenador.start();

          
            

        } catch (IOException e) {
            e.printStackTrace();
        }
     

	}

}
