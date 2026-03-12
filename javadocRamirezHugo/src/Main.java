import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");

            // Validamos que sea un entero
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingresa un número.");
                scanner.next(); // descartamos entrada inválida
                System.out.print("Elige una opción: ");
            }
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    calcularIMC(scanner);
                    break;
                case 2:
                    calcularAreaRectangulo(scanner);
                    break;
                case 3:
                    convertirCelsiusAFahrenheit(scanner);
                    break;
                case 4:
                    calcularAreaCirculo(scanner);
                    break;
                case 5:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor elige entre 1 y 5.");
            }
            System.out.println("----------------------------------------");

        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Muestra el menú de opciones en la consola
     */
    private static void mostrarMenu() {
        System.out.println("=== MENÚ DE CÁLCULOS ===");
        System.out.println("1. Calcular IMC");
        System.out.println("2. Calcular área de un rectángulo");
        System.out.println("3. Convertir °C a °F");
        System.out.println("4. Calcular área de un círculo");
        System.out.println("5. Salir");
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) a partir del peso y la estatura.
     *
     * @param scanner Objeto Scanner para leer los datos del usuario
     */
    private static void calcularIMC(Scanner scanner) {
        System.out.print("Ingresa tu peso en kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Ingresa tu estatura en metros (ej. 1.75): ");
        double estatura = scanner.nextDouble();

        double imc = peso / (estatura * estatura);

        System.out.printf("Tu IMC es: %.2f%n", imc);

        if (imc < 18.5) {
            System.out.println("Clasificación: Bajo peso");
        } else if (imc < 25) {
            System.out.println("Clasificación: Peso normal");
        } else if (imc < 30) {
            System.out.println("Clasificación: Sobrepeso");
        } else {
            System.out.println("Clasificación: Obesidad");
        }
    }

    /**
     * Calcula el área de un rectángulo dados su base y altura.
     *
     * @param scanner Objeto Scanner para leer los datos del usuario
     */
    private static void calcularAreaRectangulo(Scanner scanner) {
        System.out.print("Ingresa la base (en metros o cm): ");
        double base = scanner.nextDouble();

        System.out.print("Ingresa la altura (en metros o cm): ");
        double altura = scanner.nextDouble();

        double area = base * altura;

        System.out.printf("El área del rectángulo es: %.2f unidades²%n", area);
    }

    /**
     * Convierte una temperatura de grados Celsius a grados Fahrenheit.
     * Fórmula: F = (C × 1.8) + 32
     *
     * @param scanner Objeto Scanner para leer la temperatura en °C
     */
    private static void convertirCelsiusAFahrenheit(Scanner scanner) {
        System.out.print("Ingresa la temperatura en °C: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 1.8) + 32;

        System.out.printf("%.1f °C = %.1f °F%n", celsius, fahrenheit);
    }

    /**
     * Calcula el área de un círculo dado su radio.
     * Fórmula: A = π × r²
     *
     * @param scanner Objeto Scanner para leer el valor del radio
     */
    private static void calcularAreaCirculo(Scanner scanner) {
        System.out.print("Ingresa el radio del círculo: ");
        double radio = scanner.nextDouble();

        double area = Math.PI * radio * radio;

        System.out.printf("El área del círculo es: %.2f unidades²%n", area);
    }
}