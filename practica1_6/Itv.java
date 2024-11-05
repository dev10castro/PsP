package practica1_6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class ITV extends Thread{
  
	private ArrayList<Vehiculo> cola; // Lista de veh�culos en espera de ser inspeccionados.
	private Semaphore semaforo; // Sem�foro para controlar el acceso a la cola de manera concurrente.
	private String id; // Identificador de la l�nea de inspecci�n (puede haber varias l�neas, cada una con su propio hilo).

	/**
	 * Constructor de la clase ITV.
	 * @param cola Lista de veh�culos que van a ser inspeccionados.
	 * @param semaforo Sem�foro para gestionar la concurrencia en la cola de veh�culos.
	 * @param id Identificador de la l�nea de inspecci�n.
	 */
	public ITV(ArrayList<Vehiculo> cola, Semaphore semaforo, String id) {
		super();
		this.cola = cola; // Inicializo la cola con la lista de veh�culos que recibo.
		this.semaforo = semaforo; // Asigno el sem�foro para controlar el acceso.
		this.id = id; // Asigno el identificador de la l�nea de inspecci�n.
	}
	
	public void run() {
	    Vehiculo vehiculoAux = null; // Veh�culo auxiliar que ir� usando para inspeccionar.
	    try {
	        while (true) { // Bucle que seguir� mientras haya veh�culos en la cola.
	            semaforo.acquire(); // Adquiero el sem�foro para asegurarme que soy el �nico hilo accediendo a la cola en este momento.
	            if (!cola.isEmpty()) { // Si la cola no est� vac�a:
	                vehiculoAux = cola.remove(0); // Saco el primer veh�culo de la lista (FIFO).
	                semaforo.release(); // Libero el sem�foro para que otros hilos puedan acceder a la cola.
	            } else {
	                semaforo.release(); // Si la cola est� vac�a, libero el sem�foro y salgo del bucle.
	                break;
	            }
	            
	            // Dependiendo del tipo de veh�culo, defino el comportamiento.
	            switch (vehiculoAux.getTipo()) {
	                case Coche: // Si es un coche:
	                	System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha entrado en la "+id);
	                    Thread.sleep(1000); // La inspecci�n del coche toma 1 segundo.
	                    System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha salido de la "+id);
	                    break;
	                case Moto: // Si es una moto:
	                	System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha entrado en la "+id);
	                    Thread.sleep(500); // La inspecci�n de la moto toma 0.5 segundos.
	                    System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha salido de la "+id);
	                    break;
	                case Camion: // Si es un cami�n:
	                	System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha entrado en la "+id);
	                    Thread.sleep(1500); // La inspecci�n del cami�n toma 1.5 segundos.
	                    System.out.println("El vehiculo de tipo "+vehiculoAux.getTipo()+" con matricula "+vehiculoAux.getMatricula()+ " ha salido de la "+id);
	                    break;
	                    
	                // Si se encuentra un tipo de veh�culo desconocido, lanzo una excepci�n.
	                default:
	                    throw new IllegalArgumentException("Tipo de veh�culo desconocido: " + vehiculoAux.getTipo());
	            }
	            
	            // Mensaje final indicando que se ha terminado la inspecci�n del veh�culo actual.
	            System.out.println("La l�nea de inspecci�n " + id + " ha terminado de inspeccionar al veh�culo " + vehiculoAux.getMatricula());
	            System.out.println("-------------------------------------------------------------------------------");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // En caso de error, imprimo la traza del error.
	    }
	}
}
