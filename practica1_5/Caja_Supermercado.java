package practica1_5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Caja_Supermercado extends Thread {

	private String nombreCaja;
	private ArrayList<Cliente> cola;
	private File file;

	public Caja_Supermercado(String nombreCaja, ArrayList<Cliente> cola, File file) {
		super();
		this.nombreCaja = nombreCaja;
		this.cola = cola;
		this.file = file;
	}

	public void run() {
		BufferedWriter writer = null;
		try {
			// creamos un buffered writer para escribir en el archivo
			writer = new BufferedWriter(new FileWriter(file, true));

			// instanciamos un cliente y un String auxiliar para la escritura
			Cliente cliente;
			String aux;

			// sincronizamos la lista hasta que quede vacía
			while (true) {

				synchronized (cola) {
					if (cola.isEmpty())
						break;
					cliente = cola.remove(0);
				}

				for (int i = 0; i < cliente.getProductos(); i++) {
					aux = this.nombreCaja + " : El cliente " + cliente.getId() + " ha pasado su producto " + (i + 1);
					System.out.println(aux);

					// Sincronizamos el acceso al BufferedWriter, no al File
					synchronized (writer) {
						writer.write(aux);
						writer.newLine();
					}
				}

				synchronized (writer) {
					writer.write("La " + this.nombreCaja + " ha terminado de atender a " + cliente.getId());
					writer.newLine();
					System.out.println("La " + this.nombreCaja + " ha terminado de atender a " + cliente.getId());
				}

				Thread.sleep(1000);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// cerramos el writer en el bloque finally
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
