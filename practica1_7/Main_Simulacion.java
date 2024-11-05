package practica1_7;

import java.util.ArrayList;

public class Main_Simulacion {

    public static void main(String[] args) {

        ArrayList<Paquete> lineaCarga = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            lineaCarga.add(new Paquete());
        }
      

        Vehiculo vehiculo1 = new Vehiculo("Vehiculo de reparto 1", lineaCarga);
        Vehiculo vehiculo2 = new Vehiculo("Vehiculo de reparto 2", lineaCarga);
        Vehiculo vehiculo3 = new Vehiculo("Vehiculo de reparto 3", lineaCarga);
    
        vehiculo1.start();
        vehiculo2.start();
        vehiculo3.start();
      

        try {
            vehiculo1.join();
            vehiculo2.join();
            vehiculo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (lineaCarga.isEmpty()) {
            System.out.println("Todos los paquetes han sido repartidos.");
        } else {
            System.out.println("Quedan paquetes por repartir.");
        }
    }
}
