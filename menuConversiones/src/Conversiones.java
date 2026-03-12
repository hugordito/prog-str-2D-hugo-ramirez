import java.util.Scanner;

public class Conversiones {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                int opcion;
                int totalConversiones = 0;
                int celsiusFahrenheit = 0;
                int fahrenheitCelsius = 0;
                int kmMillas = 0;
                int millasKm = 0;

                do {
                        System.out.println("\n--- MENU DE CONVERSIONES ---");
                        System.out.println("1) °C a °F");
                        System.out.println("2) °F a °C");
                        System.out.println("3) Km a Millas");
                        System.out.println("4) Millas a Km");
                        System.out.println("5) Salir");
                        System.out.print("Elige una opcion: ");

                        if (!sc.hasNextInt()) {
                                System.out.println("Opcion invalida, debes ingresar un numero.");
                                sc.next();
                                continue;
                        }

                        opcion = sc.nextInt();

                        if (opcion < 1 || opcion > 5) {
                                System.out.println("Opcion fuera de rango. Intenta de nuevo.");
                                continue;
                        }

                        if (opcion == 5) {
                                break;
                        }

                        double valor;

                        while (true) {
                                System.out.print("Ingresa el valor a convertir: ");
                                if (sc.hasNextDouble()) {
                                        valor = sc.nextDouble();
                                        break;
                                } else {
                                        System.out.println("Dato invalido, debe ser numerico.");
                                        sc.next();
                                }
                        }

                        switch (opcion) {
                                case 1:
                                        System.out.println("Resultado: " + ((valor * 9 / 5) + 32) + " °F");
                                        celsiusFahrenheit++;
                                        break;
                                case 2:
                                        System.out.println("Resultado: " + ((valor - 32) * 5 / 9) + " °C");
                                        fahrenheitCelsius++;
                                        break;
                                case 3:
                                        System.out.println("Resultado: " + (valor * 0.621371) + " Millas");
                                        kmMillas++;
                                        break;
                                case 4:
                                        System.out.println("Resultado: " + (valor / 0.621371) + " Km");
                                        millasKm++;
                                        break;
                        }

                        totalConversiones++;

                } while (true);

                System.out.println("\n--- RESUMEN ---");
                System.out.println("Total de conversiones: " + totalConversiones);
                System.out.println("°C a °F: " + celsiusFahrenheit);
                System.out.println("°F a °C: " + fahrenheitCelsius);
                System.out.println("Km a Millas: " + kmMillas);
                System.out.println("Millas a Km: " + millasKm);

                System.out.println("Programa finalizado.");
        }
}
