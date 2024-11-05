package practica1_3;

public class Concurrencia_DC {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Iniciando clase principal....");

		try {
			// Creo el primer hilo
			Incremento hilo1 = new Incremento();
			hilo1.start(); // Inicio la ejecuci�n del primer hilo
			System.out.println("Hilo 1 ejecutado");

			while (hilo1.isAlive()) {
				System.out.println("Esperando....");
			}

			// Imprimo el valor antes de la ejecuci�n completa de los hilos
			System.out.println("Valor antes de incrementar: " + Incremento.devuelveValor());

			// Creo el segundo hilo
			Incremento hilo2 = new Incremento();
			hilo2.start(); // Inicio la ejecuci�n del segundo hilo
			System.out.println("Hilo 2 ejecutado");

			while (hilo2.isAlive()) {
				System.out.println("Esperando....");
			}

			// Imprimo el valor despu�s de ejecutar los hilos
			System.out.println("Valor despu�s de incrementar: " + Incremento.devuelveValor());

		} catch (Exception e) {
			// Si ocurre alg�n error durante la ejecuci�n, se imprime la traza del error
			e.printStackTrace();
		} finally {
			// Al final del programa, independientemente de lo que ocurra, este mensaje se
			// imprimir�
			System.out.println("Finalizando programa");
		}

	}

}
