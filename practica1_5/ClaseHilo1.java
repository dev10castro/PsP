package practica1_5;

public class ClaseHilo1 extends Thread {

	public static int contador;
	public String nombre;

	/**
	 * 
	 */
	public ClaseHilo1(String nombre) {
		this.nombre = nombre;
	}

	public void run() {

		add();
	}

	public void add() {

		synchronized (ClaseHilo1.class) {
			for (int i = 0; i < 5 && contador < 15; i++) {
				contador += 1;
				System.out.println(nombre + " - contador: " + contador);

			}
		}
	}

}
