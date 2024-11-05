package practica1_7;

import java.util.ArrayList;


public class Vehiculo extends Thread {

    private String idVehiculo;
    private int capacidadPaquetes;
    private ArrayList<Paquete> lineaCarga;

    public Vehiculo(String id, ArrayList<Paquete> lineaCarga) {
        this.idVehiculo = id;
        this.capacidadPaquetes = 5 + (int) (Math.random() * 11);// Capacidad entre 5 y 15 aleatoria
        this.lineaCarga = lineaCarga;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public int getCapacidadPaquetes() {
        return capacidadPaquetes;
    }

    public ArrayList<Paquete> getLineaCarga() {
        return lineaCarga;
    }

    @Override
    public void run() {
        synchronized (lineaCarga) {
            System.out.println("El " + idVehiculo + " empieza a recibir paquetes de la línea de carga.");
            
            //asegura que el vehículo cargue tantos paquetes como le permita su capacidad restante o la cantidad
            //de paquetes disponibles en la línea de carga, lo que sea menor.
            int totalPaquetes = Math.min(capacidadPaquetes, lineaCarga.size());
            for (int i = 0; i < totalPaquetes; i++) {
                Paquete paquete = lineaCarga.remove(0);// eliminamos el primer elemento de la lista dq paquetes
                System.out.println("El " + idVehiculo + " cargando paquete " + (i + 1));
                try {
                    Thread.sleep(paquete.getTiempoCargaEnMilisegundos());//segun el tiempo de espera estaremos mas o menos en sleep.
                } catch (InterruptedException e) {
                    e.printStackTrace(); 
                }
                capacidadPaquetes--;
            }

            System.out.println(idVehiculo+" cargado!!!");
            System.out.println("El " + idVehiculo + " sale a reparto.");
            lineaCarga.notify();
        }
    }
}
