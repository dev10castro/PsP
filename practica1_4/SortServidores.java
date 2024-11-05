package practica1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortServidores implements Runnable{
	
	private String ruta_archivo;
	
	
	public SortServidores(String filePath) {
		this.ruta_archivo = filePath;
	}

	@Override
    public void run() {
        try {
        	
            // Comando de PowerShell para obtener y ordenar los dominios del archivo
            String psCommand = "Get-Content '" + ruta_archivo + "' | ForEach-Object { ($_ -split ' ')[1] } | Sort-Object";
            
            // Ejecutar el comando de PowerShell usando Runtime en lugar de ProcessBuilder
            Process process = Runtime.getRuntime().exec(new String[] {"powershell.exe", "/c", psCommand});

            // Leer la salida del comando de PowerShell
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            // Leer las líneas de la salida (que ya están ordenadas) y mostrarlas directamente
            System.out.println("Dominios ordenados alfabéticamente:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Imprimir cada dominio ordenado
            }

            reader.close();// cerramos el reader
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
