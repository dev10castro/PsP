package practica1_6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class ITV_2 extends Thread {
	  
	private ArrayList<Vehiculo_2> cola; 
	private Semaphore semaforo; 
	private String id; 
	
	
	/**
	 * Constructor de la clase ITV_2.
	 * @param cola Lista de vehículos para ser inspeccionados.
	 * @param semaforo Semáforo para gestionar el acceso concurrente.
	 * @param id Identificador de la línea de inspección.
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
	            semaforo.acquire(); // Adquiero el semáforo para asegurar que este hilo tiene acceso exclusivo a la cola.
	            if (!cola.isEmpty()) { 
	                vehiculoAux = cola.remove(0); // Extraigo el primer vehículo de la cola.
	                semaforo.release(); // Libero el semáforo para que otros hilos puedan acceder a la cola.
	            } else {
	                semaforo.release(); // Si la cola está vacía, libero el semáforo y salgo del bucle.
	                break; 
	            }
	            
	            // Según el tipo de vehículo, aplico un comportamiento específico.
	            switch (vehiculoAux.getTipo()) {
	                case Coche: // Si es un coche:
	                	System.out.println("El vehículo de tipo " + vehiculoAux.getTipo() + " con matrícula " + vehiculoAux.getMatricula() + " ha entrado en la " + id);
	                    Thread.sleep(1000); // La inspección del coche tarda 1 segundo.
	                    System.out.println("El vehículo de tipo " + vehiculoAux.getTipo() + " con matrícula " + vehiculoAux.getMatricula() + " ha salido de la " + id);
	                    break;
	                case Moto: // Si es una moto:
	                	System.out.println("El vehículo de tipo " + vehiculoAux.getTipo() + " con matrícula " + vehiculoAux.getMatricula() + " ha entrado en la " + id);
	                    Thread.sleep(500); // La inspección de la moto tarda 0.5 segundos.
	                    System.out.println("El vehículo de tipo " + vehiculoAux.getTipo() + " con matrícula " + vehiculoAux.getMatricula() + " ha salido de la " + id);
	                    break;
	                case Camion: // Si es un camión:
	                	System.out.println("El vehículo de tipo " + vehiculoAux.getTipo() + " con matrícula " + vehiculoAux.getMatricula() + " ha entrado en la " + id);
	                    Thread.sleep(1500); // La inspección del camión tarda 1.5 segundos.
	                    System.out.println("El vehículo de tipo " + vehiculoAux.getTipo() + " con matrícula " + vehiculoAux.getMatricula() + " ha salido de la " + id);
	                    break;
	                    
	                case Vehiculo_Agricola: // Si es un vehículo agrícola:
	                	System.out.println("El vehículo de tipo " + vehiculoAux.getTipo() + " con matrícula " + vehiculoAux.getMatricula() + " ha entrado en la " + id);
	                    Thread.sleep(2000); // La inspección del vehículo agrícola tarda 2 segundos.
	                    System.out.println("El vehículo de tipo " + vehiculoAux.getTipo() + " con matrícula " + vehiculoAux.getMatricula() + " ha salido de la " + id);
	                    break;

	            }
	            
	            // Mensaje final que indica que la línea de inspección ha terminado con el vehículo actual.
	            System.out.println("La línea de inspección " + id + " ha terminado de inspeccionar al vehículo " + vehiculoAux.getMatricula());
	            System.out.println("-------------------------------------------------------------------------------");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); //En caso de error, se mjuestra mensaje
	    }
	}
}
