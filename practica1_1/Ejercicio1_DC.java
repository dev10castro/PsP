package practica1_1;

public class Ejercicio1_DC {

	public static void main(String[] args) {
		
		String ruta=
                "C:\\Program Files\\WindowsApps\\Microsoft.Paint_11.2406.42.0_x64__8wekyb3d8bbwe\\PaintApp\\mspaint.exe";
		System.out.println("Se inicia el proceso");
        LanzadorProcesos lp=new LanzadorProcesos();
        lp.ejecutar(ruta);
        System.out.println("Finalizado");

	}

	public static class LanzadorProcesos {
        public void ejecutar(String ruta){

                ProcessBuilder proceso;
                try {
                        proceso = new ProcessBuilder(ruta);
                        System.out.println("Se inicia el programa");
                        proceso.start();
                } catch (Exception e) {                     
                        e.printStackTrace();
                }

        }
	
	
	}
}
