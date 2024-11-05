package practica1_6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class ITV extends Thread{
  
	private ArrayList<Vehiculo> cola; // Lista de vehículos en espera de ser inspeccionados.
	private Semaphore semaforo; // Semáforo para controlar el acceso a la cola de manera concurrente.
	private String id; // Identificador de la línea de inspección (puede haber varias líneas, cada una con su propio hilo).

	/**
	 * Constructor de la clase ITV.
	 * @param cola Lista de vehículos que van a ser inspeccionados.
	 * @param semaforo Semáforo para gestionar la concurrencia en la cola de vehículos.
	 * @param id Identificador de la línea de inspección.
	 */
	public ITV(ArrayList<Vehiculo> cola, Semaphore semaforo, String id) {
		super();
		this.cola = cola; // Inicializo la cola con la lista de vehículos que recibo.
		this.semaforo = semaforo; // Asigno el semáforo para controlar el acceso.
		this.id = id; // Asigno el identificador de la línea de inspección.
	}
	
	public void run() {
	    Vehiculo vehiculoAux = null; // Vehículo auxiliar que iré usando para inspeccionar.
	    try {
	        while (true) { // Bucle que seguirá mientras haya vehículos en la cola.
	            semaforo.acquire(); // Adquiero el semáforo para asegurarme que soy el único hilo accediendo a la cola en este momento.
	            if (!cola.isEmpty()) { // Si la cola no está vacía:
	                vehiculoAux = cola.remove(0); // Saco el primer vehículo de la lista (FIFO).
	                semaforo.release(); // Libero el semáforo para que otros hilos puedan acceder a la cola.
	            } else {
	                semaforo.release(); // Si la cola está vacía, libero el semáforo y salgo del bucle.
	                break;
	            }
	            
	            // Dependiendo del tipo de vehículo, defino el comportamiento.
	            switch (vehiculoAux.getTipo()) {
	                case Coche: // Si es un coche:
	                	System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha entrado en la "+id);
	                    Thread.sleep(1000); // La inspección del coche toma 1 segundo.
	                    System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha salido de la "+id);
	                    break;
	                case Moto: // Si es una moto:
	                	System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha entrado en la "+id);
	                    Thread.sleep(500); // La inspección de la moto toma 0.5 segundos.
	                    System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha salido de la "+id);
	                    break;
	                case Camion: // Si es un camión:
	                	System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha entrado en la "+id);
	                    Thread.sleep(1500); // La inspección del camión toma 1.5 segundos.
	                    System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha salido de la "+id);
	                    break;
	                    
	                // Si se encuentra un tipo de vehículo desconocido, lanzo una excepción.
	                default:
	                    throw new IllegalArgumentException("Tipo de vehículo desconocido: " + vehiculoAux.getTipo());
	            }
	            
	            // Mensaje final indicando que se ha terminado la inspección del vehículo actual.
	            System.out.println("La línea de inspección " + id + " ha terminado de inspeccionar al vehículo " + vehiculoAux.getMatricula());
	            System.out.println("-------------------------------------------------------------------------------");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // En caso de error, imprimo la traza del error.
	    }
	}
}
