package practica1_5;

import java.io.File;
import java.util.ArrayList;

public class MainCaja {

	public static void main(String[] args) {
		
		String ruta = System.getProperty("user.home")+File.separator+"super.log";
		
		File file = new File(ruta);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		Cliente cliente1 = new Cliente("Cliente 1", 4);
		Cliente cliente2 = new Cliente("Cliente 2", 3);
		Cliente cliente3 = new Cliente("Cliente 3", 5);
		Cliente cliente4 = new Cliente("Cliente 4", 4);
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		
		Caja_Supermercado caja1 = new Caja_Supermercado("Caja 1", clientes, file);
		Caja_Supermercado caja2 = new Caja_Supermercado("Caja 2", clientes, file);
		
		caja1.start();
		caja2.start();
		
	}

}
