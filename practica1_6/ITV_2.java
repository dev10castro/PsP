package practica1_6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class ITV_2 extends Thread {
	  
	private ArrayList<Vehiculo_2> cola; 
	private Semaphore semaforo; 
	private String id; 
	
	
	/**
	 * Constructor de la clase ITV_2.
	 * @param cola Lista de veh�culos para ser inspeccionados.
	 * @param semaforo Sem�foro para gestionar el acceso concurrente.
	 * @param id Identificador de la l�nea de inspecci�n.
	 */
	public ITV_2(ArrayList<Vehiculo_2> cola, Semaphore semaforo, String id) {
		super();
		this.cola = cola; 
		this.semaforo = semaforo; 
		this.id = id; 
	}
	
	public void run() {
	    Vehiculo_2 vehiculoAux = null; 
	    try {
	        while (true) { 
	            semaforo.acquire(); // Adquiero el sem�foro para asegurar que este hilo tiene acceso exclusivo a la cola.
	            if (!cola.isEmpty()) { 
	                vehiculoAux = cola.remove(0); // Extraigo el primer veh�culo de la cola.
	                semaforo.release(); // Libero el sem�foro para que otros hilos puedan acceder a la cola.
	            } else {
	                semaforo.release(); // Si la cola est� vac�a, libero el sem�foro y salgo del bucle.
	                break; 
	            }
	            
	            // Seg�n el tipo de veh�culo, aplico un comportamiento espec�fico.
	            switch (vehiculoAux.getTipo()) {
	                case Coche: // Si es un coche:
	                	System.out.println("El veh�culo de tipo " + vehiculoAux.getTipo() + " con matr�cula " + vehiculoAux.getMatricula() + " ha entrado en la " + id);
	                    Thread.sleep(1000); // La inspecci�n del coche tarda 1 segundo.
	                    System.out.println("El veh�culo de tipo " + vehiculoAux.getTipo() + " con matr�cula " + vehiculoAux.getMatricula() + " ha salido de la " + id);
	                    break;
	                case Moto: // Si es una moto:
	                	System.out.println("El veh�culo de tipo " + vehiculoAux.getTipo() + " con matr�cula " + vehiculoAux.getMatricula() + " ha entrado en la " + id);
	                    Thread.sleep(500); // La inspecci�n de la moto tarda 0.5 segundos.
	                    System.out.println("El veh�culo de tipo " + vehiculoAux.getTipo() + " con matr�cula " + vehiculoAux.getMatricula() + " ha salido de la " + id);
	                    break;
	                case Camion: // Si es un cami�n:
	                	System.out.println("El veh�culo de tipo " + vehiculoAux.getTipo() + " con matr�cula " + vehiculoAux.getMatricula() + " ha entrado en la " + id);
	                    Thread.sleep(1500); // La inspecci�n del cami�n tarda 1.5 segundos.
	                    System.out.println("El veh�culo de tipo " + vehiculoAux.getTipo() + " con matr�cula " + vehiculoAux.getMatricula() + " ha salido de la " + id);
	                    break;
	                    
	                case Vehiculo_Agricola: // Si es un veh�culo agr�cola:
	                	System.out.println("El veh�culo de tipo " + vehiculoAux.getTipo() + " con matr�cula " + vehiculoAux.getMatricula() + " ha entrado en la " + id);
	                    Thread.sleep(2000); // La inspecci�n del veh�culo agr�cola tarda 2 segundos.
	                    System.out.println("El veh�culo de tipo " + vehiculoAux.getTipo() + " con matr�cula " + vehiculoAux.getMatricula() + " ha salido de la " + id);
	                    break;

	            }
	            
	            // Mensaje final que indica que la l�nea de inspecci�n ha terminado con el veh�culo actual.
	            System.out.println("La l�nea de inspecci�n " + id + " ha terminado de inspeccionar al veh�culo " + vehiculoAux.getMatricula());
	            System.out.println("-------------------------------------------------------------------------------");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); //En caso de error, se mjuestra mensaje
	    }
	}
}
