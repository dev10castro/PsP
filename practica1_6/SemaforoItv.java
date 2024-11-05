package practica1_6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SemaforoItv {

	public static void main(String[] args) {
	
	    // Creo una instancia del sem�foro, que permitir� que solo un hilo acceda a la cola de veh�culos a la vez.
	    Semaphore semaforo = new Semaphore(1);
	        
	    // Creo una lista de veh�culos que representar� la cola de veh�culos esperando la inspecci�n.
	    ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
	        
	    int vehiculo = 0; // Esta variable me servir� para determinar el tipo de veh�culo (1, 2, o 3).
	    int matricula = 0; // Esta variable contendr� una matr�cula aleatoria para cada veh�culo.
	        
	    Vehiculo nuevo = null; // Aqu� ir� almacenando temporalmente cada veh�culo antes de a�adirlo a la lista.
	        
	    // A�ado veh�culos a la lista de forma aleatoria, simulando la creaci�n de 24 veh�culos distintos.
	    for (int i = 0; i < 24; i++) {
			
	    	// Genero un n�mero aleatorio entre 1 y 3 para definir el tipo de veh�culo.
	    	vehiculo = (int) (Math.random() * 3 + 1);
	    	
	    	// Genero una matr�cula aleatoria (entre 1 y 9999).
	    	matricula = (int) (Math.random() * 9999 + 1);
	    	   
	    	// Seg�n el n�mero generado para el tipo de veh�culo, creo un veh�culo de ese tipo.
	    	switch (vehiculo) {
	    	   case 1: // Si el n�mero es 1, el veh�culo ser� un coche.
	    		   nuevo = new Vehiculo(Vehiculo_Tipo.Coche, matricula);
	    		   break;
	    	   case 2: // Si el n�mero es 2, el veh�culo ser� un cami�n.
	    		   nuevo = new Vehiculo(Vehiculo_Tipo.Camion, matricula);
	    		   break;
	    	   case 3: // Si el n�mero es 3, el veh�culo ser� una moto.
	    		   nuevo = new Vehiculo(Vehiculo_Tipo.Moto, matricula);
	    		   break;
	    	}
	    	
	    	// A�ado el veh�culo reci�n creado a la lista.
	    	lista.add(nuevo);
	    }
	        
	    // Creo una nueva instancia de la clase `ITV`, que ser� un hilo que gestionar� la inspecci�n en la l�nea 1.
	    ITV itv = new ITV(lista, semaforo, "Linea 1");
	        
	    // Inicio el hilo, lo que ejecutar� el m�todo `run()` de la clase ITV.
	    itv.start();
	        
	    try {
	    	// Hago que el hilo principal espere a que el hilo `itv` termine su trabajo (inspecci�n de todos los veh�culos).
	    	itv.join();
	    	
	    	// Una vez que el hilo `itv` termina, muestro un mensaje indicando que todas las inspecciones han finalizado.
	    	System.out.println("Ha terminado la inspecci�n de todos los veh�culos");
	    } catch (InterruptedException e) {
	    	// Si se produce alguna interrupci�n durante la espera, imprimo la traza del error.
	    	e.printStackTrace();
	    }
	}
}
