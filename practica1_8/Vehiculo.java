package practica1_8;

import java.util.concurrent.Semaphore;

public class Vehiculo extends Thread {

	private String idVehiculo;
	private int capacidadPaquetes;
	private LineaDeCarga lineaCarga;
	private Semaphore semaforoReparto;
	private static int contadorVehiculosCargados = 0; // Contador est�tico para los veh�culos que terminan de cargar

	// Constructor de la clase Vehiculo
	public Vehiculo(String id, LineaDeCarga lineaCarga, Semaphore semaforoReparto) {

		this.idVehiculo = id;
		this.capacidadPaquetes = 5 + (int) (Math.random() * 11);
		this.lineaCarga = lineaCarga;
		this.semaforoReparto = semaforoReparto;
	}

	@Override
	public void run() {
		// Bloqueo el acceso a la lista de paquetes de la l�nea de carga actual para que
		// solo este veh�culo
		// pueda acceder a ella mientras est� cargando
		synchronized (lineaCarga.getPaquetes()) {
			System.out.println("El " + idVehiculo + " empieza a recibir paquetes de la " + lineaCarga.getIdLinea());

			// Calculo el n�mero de paquetes que puedo cargar, que es el m�nimo entre mi
			// capacidad y la cantidad de paquetes disponibles
			int totalPaquetes = Math.min(capacidadPaquetes, lineaCarga.getPaquetes().size());

			// Bucle para cargar paquetes hasta que alcance mi capacidad o no haya m�s paquetes
			
			for (int i = 0; i < totalPaquetes; i++) {
				Paquete paquete = lineaCarga.getPaquetes().remove(0); // Remuevo un paquete de la l�nea de carga
				System.out.println(
						"El " + idVehiculo + " cargando paquete " + (i + 1) + " desde la " + lineaCarga.getIdLinea());

				// tiemp de espera segun paquetes
				try {
					Thread.sleep(paquete.getTiempoCargaEnMilisegundos());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Reduzco la capacidad restante del veh�culo despu�s de cargar el paquete
				capacidadPaquetes--;
			}

			System.out.println(idVehiculo + " completamente cargado desde la " + lineaCarga.getIdLinea());
		}

		// Incremento el contador de veh�culos que han terminado de cargar usando sincronizaci�n est�tica
	
		synchronized (Vehiculo.class) {
			contadorVehiculosCargados++;
			// Cuando el �ltimo veh�culo termina de cargar, libero un permiso en el sem�foro
			// Esto permite que el primer veh�culo salga a reparto
			if (contadorVehiculosCargados == 6) {
				System.out.println("Todos los veh�culos han terminado de cargar. Iniciando salidas de uno en uno.");
				semaforoReparto.release(); // Libero el primer permiso
			}
		}

		// Cada veh�culo adquiere el sem�foro antes de salir a reparto, asegurando que salen de uno en uno
		 
		try {
			semaforoReparto.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("El " + idVehiculo + " sale a reparto.");

		// se libera el semaforo
		semaforoReparto.release();
	}
}
