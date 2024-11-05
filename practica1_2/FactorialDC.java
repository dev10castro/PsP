package practica1_2;

public class FactorialDC {
    
    public static void main(String[] args) {
        // Verifico si se recibió un argumento al ejecutar el programa
        if (args.length == 0) {
            System.out.println("Por favor, ingresa un número.");
            return; // Salgo del programa si no hay argumento
        }
        
        try {
            // Convierte el argumento recibido a un número entero
            Integer n = Integer.parseInt(args[0]);
            // Llama al método calcularFactorial para obtener el factorial del número
            calcularFactorial(n);
            // Indico que el proceso ha finalizado
            System.out.println("Finalizado.");
        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir a entero, imprimo un mensaje de error
            System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
        }
    }

    public static void calcularFactorial(Integer n) {
        // Inicializo la variable factorial en 1, ya que el factorial de 0 y 1 es 1
        Integer factorial = 1;
        
        // Uso un bucle para calcular el factorial desde 2 hasta n
        for (int i = 2; i <= n; i++) {
            factorial *= i; // Multiplico el valor actual de factorial por i
        }
        
        // Muestro el resultado del factorial en la consola
        System.out.println("El Factorial de " + n + " es: " + factorial);
    }
}
