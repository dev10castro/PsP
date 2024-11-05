package practica1_8;

import java.util.concurrent.Semaphore;

public class Main_Simulacion {

    public static void main(String[] args) {

        LineaDeCarga lineaCarga1 = new LineaDeCarga("Línea de carga 1");
        for (int i = 0; i < 15; i++) {
            lineaCarga1.addPaquete(new Paquete());
        }
        
        LineaDeCarga lineaCarga2 = new LineaDeCarga("Línea de carga 2");
        for (int i = 0; i < 15; i++) {
            lineaCarga2.addPaquete(new Paquete());
        }
        
        LineaDeCarga lineaCarga3 = new LineaDeCarga("Línea de carga 3");
        for (int i = 0; i < 15; i++) {
            lineaCarga3.addPaquete(new Paquete());
        }

        Semaphore semaforoReparto = new Semaphore(0);

        
        // se crean 6 vehiculos
        Vehiculo vehiculo1 = new Vehiculo("Vehículo de reparto 1", lineaCarga1, semaforoReparto);
        Vehiculo vehiculo2 = new Vehiculo("Vehículo de reparto 2", lineaCarga1, semaforoReparto);
        Vehiculo vehiculo3 = new Vehiculo("Vehículo de reparto 3", lineaCarga2, semaforoReparto);
        Vehiculo vehiculo4 = new Vehiculo("Vehículo de reparto 4", lineaCarga2, semaforoReparto);
        Vehiculo vehiculo5 = new Vehiculo("Vehículo de reparto 5", lineaCarga3, semaforoReparto);
        Vehiculo vehiculo6 = new Vehiculo("Vehículo de reparto 6", lineaCarga3, semaforoReparto);

        vehiculo1.start();
        vehiculo2.start();
        vehiculo3.start();
        vehiculo4.start();
        vehiculo5.start();
        vehiculo6.start();

        try {
            vehiculo1.join();
            vehiculo2.join();
            vehiculo3.join();
            vehiculo4.join();
            vehiculo5.join();
            vehiculo6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Paquetes en reparto");
    }
}
