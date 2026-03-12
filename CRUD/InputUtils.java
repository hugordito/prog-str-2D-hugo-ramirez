package CRUD;

import java.util.Scanner;

public class InputUtils {
    
    /**
     * Método para solicitar un número entero con validación
     * @param scanner El scanner para leer entrada
     * @param mensaje El mensaje a mostrar al usuario
     * @return El número entero válido ingresado
     */
    public static int solicitarEntero(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
        }
        return numero;
    }
    
    /**
     * Método para solicitar un número entero positivo con validación
     * @param scanner El scanner para leer entrada
     * @param mensaje El mensaje a mostrar al usuario
     * @return El número entero positivo válido ingresado
     */
    public static int solicitarEnteroPositivo(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            numero = solicitarEntero(scanner, mensaje);
            if (numero > 0) {
                entradaValida = true;
            } else {
                System.out.println("Error: El número debe ser mayor que 0.");
            }
        }
        return numero;
    }
    
    /**
     * Método para solicitar un string no vacío con validación
     * @param scanner El scanner para leer entrada
     * @param mensaje El mensaje a mostrar al usuario
     * @return El string válido (no vacío) ingresado
     */
    public static String solicitarStringNoVacio(Scanner scanner, String mensaje) {
        String texto = "";
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                entradaValida = true;
            } else {
                System.out.println("Error: El texto no puede estar vacío.");
            }
        }
        return texto;
    }
    
    /**
     * Método para solicitar una opción de menú con validación
     * @param scanner El scanner para leer entrada
     * @param mensaje El mensaje a mostrar al usuario
     * @param min Opción mínima válida (inclusive)
     * @param max Opción máxima válida (inclusive)
     * @return La opción válida seleccionada
     */
    public static int solicitarOpcionMenu(Scanner scanner, String mensaje, int min, int max) {
        int opcion = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            opcion = solicitarEntero(scanner, mensaje);
            if (opcion >= min && opcion <= max) {
                entradaValida = true;
            } else {
                System.out.println("Error: Opción inválida. Seleccione una opción entre " + min + " y " + max + ".");
            }
        }
        return opcion;
    }
}