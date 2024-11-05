package practica1_3;

public class Incremento extends Thread{
	
	public static int incremento=0;
	
	public static int devuelveValor() {
		
		return incremento;
		
	}
	
	public void incrementadoValor() {
		
		incremento++;
		
		System.out.println("Acumulador incrementado: "+incremento);
	}
	
	
	@Override
	public void run() {
		
		System.out.println("Ejecutandose Incremento...");
		incrementadoValor();
	}
	
	

}
