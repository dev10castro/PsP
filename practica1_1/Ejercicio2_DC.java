package practica1_1;

public class Ejercicio2_DC {

	public static void main(String[] args) {
		
		String ruta=
                "C:\\Users\\david\\Desktop\\GoogleChromePortable\\GoogleChromePortable.exe";
		System.out.println("Se inicia el proceso");
        LanzadorProcesos lp=new LanzadorProcesos();
        lp.ejecutar(ruta);
        System.out.println("Finalizado");

	}

	public static class LanzadorProcesos {
        public void ejecutar(String ruta){

                ProcessBuilder proceso;
                try {
                        proceso = new ProcessBuilder(ruta,"--incognito");
                        System.out.println("Se inicia el programa en modo incognito");
                        proceso.start();
                } catch (Exception e) {
                        e.printStackTrace();
                }

        }
	
	
	}
}