package practica1_1;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3_DC {
    
    public static void main(String[] args) {
        System.out.println("Ejecutando...");

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero para calcular su factorial:");
        Integer num = sc.nextInt();
        
        Ejercicio3_DC lanzador = new Ejercicio3_DC();
        lanzador.ejecutarFactorial(num);
       
        sc.close();
    }
    
    public void ejecutarFactorial(Integer numero) {
        try {
        	
        	String clase= "practica1_1.FactorialDC";
        	//aqui definimos la clase a ejecutar y el numero de escaner que ira a args[0]
            ProcessBuilder pb = new ProcessBuilder("java","-cp","bin",clase,numero.toString());
         
            pb.inheritIO();
            pb.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
