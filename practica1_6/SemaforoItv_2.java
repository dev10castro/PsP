package practica1_6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SemaforoItv_2 {

	public static void main(String[] args) {
		
		// Creo un semáforo que controla el acceso a la cola de vehículos entre varias líneas de inspección.
		Semaphore semaforo = new Semaphore(1);
        
        // Lista que contendrá los vehículos que van a ser inspeccionados.
        ArrayList<Vehiculo_2> lista2 = new ArrayList<Vehiculo_2>();
        
        int vehiculo = 0; 
        int matricula = 0; 
        
        Vehiculo_2 nuevo = null; 
       
        
        //añado vehiculos de forma aleatoria
       for (int i = 0; i < 64; i++) {
		
    	  
    	   vehiculo = (int) (Math.random() * 4 + 1);
    	   
    	  
    	   matricula = (int) (Math.random() * 9999 + 1);
    	   
    	  
    	   switch (vehiculo) {
    	   
    	   case 1: 
    		   nuevo = new Vehiculo_2(Vehiculo_Tipo_2.Coche, matricula);
    		   break;
    	   case 2: 
    		   nuevo = new Vehiculo_2(Vehiculo_Tipo_2.Camion, matricula);
    		   break;
    	   case 3: 
    		   nuevo = new Vehiculo_2(Vehiculo_Tipo_2.Moto, matricula);
    		   break;
    	   
    	   case 4: 
    		   nuevo = new Vehiculo_2(Vehiculo_Tipo_2.Vehiculo_Agricola, matricula);
    		   break;
    	   }
    	   
    	   // Añado el nuevo vehículo a la lista de vehículos para inspección.
    	   lista2.add(nuevo);
		}
        
        // Creo tres instancias del hilo ITV_2, cada una representando una línea de inspección.
        ITV_2 itv1 = new ITV_2(lista2, semaforo, "Linea 1");
        ITV_2 itv2 = new ITV_2(lista2, semaforo, "Linea 2");
        ITV_2 itv3 = new ITV_2(lista2, semaforo, "Linea 3");
        
        // Inicio los tres hilos para que comiencen a inspeccionar vehículos en paralelo.
        itv1.start();
        itv2.start();
        itv3.start();
        
        try {
        	
			itv1.join();
			itv2.join();
			itv3.join();
			
			
			System.out.println("Ha terminado la inspección de todos los vehículos");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
