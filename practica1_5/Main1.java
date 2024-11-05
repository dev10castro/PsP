package practica1_5;

public class Main1 {

	public static void main(String[] args) {
		
		ClaseHilo1 hilo = new ClaseHilo1("hilo1");
		ClaseHilo1 hilo2 = new ClaseHilo1("hilo2");
		ClaseHilo1 hilo3 = new ClaseHilo1("hilo3");
		
		hilo.start();
		hilo2.start();
		hilo3.start();

	}

}
