package practica1_1;

public class FactorialDC {
    
    public static void main(String[] args) {
        // Verifica si se recibió un argumento
        if (args.length == 0) {
            System.out.println("Por favor, ingresa un número.");
            return;
        }
        
        try {
            Integer n = Integer.parseInt(args[0]); // Convierte el argumento a Integer
            calcularFactorial(n); // Llama al método para calcular el factorial
            System.out.println("Finalizado.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
        }
    }

    public static void calcularFactorial(Integer n) {
        Integer factorial = 1; // Inicializa en 1
        for (int i = 2; i <= n; i++) {
            factorial *= i; // Calcula el factorial
        }
        System.out.println("El Factorial de "+n+" es :"+factorial); // Muestra el resultado
    }
}