package practica1_8;

import java.util.concurrent.Semaphore;

public class Vehiculo extends Thread {

	private String idVehiculo;
	private int capacidadPaquetes;
	private LineaDeCarga lineaCarga;
	private Semaphore semaforoReparto;
	private static int contadorVehiculosCargados = 0; // Contador estático para los vehículos que terminan de cargar

	// Constructor de la clase Vehiculo
	public Vehiculo(String id, LineaDeCarga lineaCarga, Semaphore semaforoReparto) {

		this.idVehiculo = id;
		this.capacidadPaquetes = 5 + (int) (Math.random() * 11);
		this.lineaCarga = lineaCarga;
		this.semaforoReparto = semaforoReparto;
	}

	@Override
	public void run() {
		// Bloqueo el acceso a la lista de paquetes de la línea de carga actual para que
		// solo este vehículo
		// pueda acceder a ella mientras está cargando
		synchronized (lineaCarga.getPaquetes()) {
			System.out.println("El " + idVehiculo + " empieza a recibir paquetes de la " + lineaCarga.getIdLinea());

			// Calculo el número de paquetes que puedo cargar, que es el mínimo entre mi
			// capacidad y la cantidad de paquetes disponibles
			int totalPaquetes = Math.min(capacidadPaquetes, lineaCarga.getPaquetes().size());

			// Bucle para cargar paquetes hasta que alcance mi capacidad o no haya más paquetes
			
			for (int i = 0; i < totalPaquetes; i++) {
				Paquete paquete = lineaCarga.getPaquetes().remove(0); // Remuevo un paquete de la línea de carga
				System.out.println(
						"El " + idVehiculo + " cargando paquete " + (i + 1) + " desde la " + lineaCarga.getIdLinea());

				// tiemp de espera segun paquetes
				try {
					Thread.sleep(paquete.getTiempoCargaEnMilisegundos());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Reduzco la capacidad restante del vehículo después de cargar el paquete
				capacidadPaquetes--;
			}

			System.out.println(idVehiculo + " completamente cargado desde la " + lineaCarga.getIdLinea());
		}

		// Incremento el contador de vehículos que han terminado de cargar usando sincronización estática
	
		synchronized (Vehiculo.class) {
			contadorVehiculosCargados++;
			// Cuando el último vehículo termina de cargar, libero un permiso en el semáforo
			// Esto permite que el primer vehículo salga a reparto
			if (contadorVehiculosCargados == 6) {
				System.out.println("Todos los vehículos han terminado de cargar. Iniciando salidas de uno en uno.");
				semaforoReparto.release(); // Libero el primer permiso
			}
		}

		// Cada vehículo adquiere el semáforo antes de salir a reparto, asegurando que salen de uno en uno
		 
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
