package practica1_4;

public class Ejercicio1 {

	public static void main(String[] args) {

		String ruta = "src\\practica1_4\\hosts";

		SortServidores run = new SortServidores(ruta);
		Thread hilo = new Thread(run);
		hilo.start();

	}

}
