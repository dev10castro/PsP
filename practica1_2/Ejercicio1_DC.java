package practica1_2;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1_DC {
    
    public static void main(String[] args) {
        // Indico que el programa se está ejecutando
        System.out.println("Ejecutando...");

        // Creo un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        
        // Solicito al usuario que introduzca un número para calcular su factorial
        System.out.println("Introduce un numero para calcular su factorial:");
        Integer num = sc.nextInt(); // Leo el número ingresado
        
        // Creo una instancia de Ejercicio1_DC para poder llamar al método ejecutarFactorial
        Ejercicio1_DC lanzador = new Ejercicio1_DC();
        
        // Llamo al método para ejecutar el cálculo del factorial pasando el número ingresado
        lanzador.ejecutarFactorial(num);
       
        sc.close(); 
    }
    
    public void ejecutarFactorial(Integer numero) {
        try {
            // Especifico la clase FactorialDC que se ejecutará en un nuevo proceso
            String clase = "practica1_2.FactorialDC";
            
            // Configuro el ProcessBuilder para ejecutar la clase FactorialDC con el número como argumento
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", clase, numero.toString());
         
            // Heredo la entrada/salida del proceso principal para ver la salida en la consola actual
            pb.inheritIO();
            
            // Inicio el proceso que ejecutará la clase FactorialDC
            pb.start();

        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }
}
