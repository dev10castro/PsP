package practica1_6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SemaforoItv {

	public static void main(String[] args) {
	
	    // Creo una instancia del semáforo, que permitirá que solo un hilo acceda a la cola de vehículos a la vez.
	    Semaphore semaforo = new Semaphore(1);
	        
	    // Creo una lista de vehículos que representará la cola de vehículos esperando la inspección.
	    ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
	        
	    int vehiculo = 0; // Esta variable me servirá para determinar el tipo de vehículo (1, 2, o 3).
	    int matricula = 0; // Esta variable contendrá una matrícula aleatoria para cada vehículo.
	        
	    Vehiculo nuevo = null; // Aquí iré almacenando temporalmente cada vehículo antes de añadirlo a la lista.
	        
	    // Añado vehículos a la lista de forma aleatoria, simulando la creación de 24 vehículos distintos.
	    for (int i = 0; i < 24; i++) {
			
	    	// Genero un número aleatorio entre 1 y 3 para definir el tipo de vehículo.
	    	vehiculo = (int) (Math.random() * 3 + 1);
	    	
	    	// Genero una matrícula aleatoria (entre 1 y 9999).
	    	matricula = (int) (Math.random() * 9999 + 1);
	    	   
	    	// Según el número generado para el tipo de vehículo, creo un vehículo de ese tipo.
	    	switch (vehiculo) {
	    	   case 1: // Si el número es 1, el vehículo será un coche.
	    		   nuevo = new Vehiculo(Vehiculo_Tipo.Coche, matricula);
	    		   break;
	    	   case 2: // Si el número es 2, el vehículo será un camión.
	    		   nuevo = new Vehiculo(Vehiculo_Tipo.Camion, matricula);
	    		   break;
	    	   case 3: // Si el número es 3, el vehículo será una moto.
	    		   nuevo = new Vehiculo(Vehiculo_Tipo.Moto, matricula);
	    		   break;
	    	}
	    	
	    	// Añado el vehículo recién creado a la lista.
	    	lista.add(nuevo);
	    }
	        
	    // Creo una nueva instancia de la clase `ITV`, que será un hilo que gestionará la inspección en la línea 1.
	    ITV itv = new ITV(lista, semaforo, "Linea 1");
	        
	    // Inicio el hilo, lo que ejecutará el método `run()` de la clase ITV.
	    itv.start();
	        
	    try {
	    	// Hago que el hilo principal espere a que el hilo `itv` termine su trabajo (inspección de todos los vehículos).
	    	itv.join();
	    	
	    	// Una vez que el hilo `itv` termina, muestro un mensaje indicando que todas las inspecciones han finalizado.
	    	System.out.println("Ha terminado la inspección de todos los vehículos");
	    } catch (InterruptedException e) {
	    	// Si se produce alguna interrupción durante la espera, imprimo la traza del error.
	    	e.printStackTrace();
	    }
	}
}
