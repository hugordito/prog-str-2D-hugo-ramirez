import java.util.Scanner;

public class App {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
ShippingCalculator calculator = new ShippingCalculator();

//INPUT
double pesoKg = leerDoubleEnRango(sc, "Ingresa el peso en kg", 0.1, 50.0);
int distanciaKm = leerIntEnRango(sc, "Ingresa la distancia en km", 1, 2000);
int tipoServicio = leerIntEnRango(sc, "Tipo de servicio (1=Estandar, 2=Express)", 1, 2);
boolean zonaRemota = leerBoolean(sc, "Es zona remota? (true/false)");

//PROCESS
double subtotal = calculator.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, zonaRemota);
double iva = calculator.calcularIVA(subtotal);
double total = calculator.calcularTotal(subtotal, iva);

//OUTPUT
imprimirTicket(tipoServicio, pesoKg, distanciaKm, zonaRemota, subtotal, iva, total);

}

//METODOS INPUT
public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
double value;
while (true) {
    System.out.println(msg);
    if (sc.hasNextDouble()) {
        value = sc.nextDouble();
        if (value >= min && value <= max) {
            return value;
        }
        System.out.println("Fuera de rango");
    } else {
        System.out.println("No es decimal");
        sc.next();
    }
}
}

public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
int value;
while (true) {
    System.out.println(msg);
    if (sc.hasNextInt()) {
        value = sc.nextInt();
        if (value >= min && value <= max) {
            return value;
        }
        System.out.println("Fuera de rango");
    } else {
        System.out.println("No es entero");
        sc.next();
    }
}
}

public static boolean leerBoolean(Scanner sc, String msg) {
while (true) {
    System.out.println(msg);
    if (sc.hasNextBoolean()) {
        return sc.nextBoolean();
    } else {
        System.out.println("Solo true o false");
        sc.next();
    }
}
}

//OUTPUT
public static void imprimirTicket(int servicio, double peso, int distancia, boolean zona, double subtotal, double iva, double total) {

System.out.println("----- TICKET -----");
System.out.println("Servicio: " + (servicio == 1 ? "Estandar" : "Express"));
System.out.println("Peso: " + peso + " kg");
System.out.println("Distancia: " + distancia + " km");
System.out.println("Zona remota: " + zona);
System.out.println("Subtotal: " + subtotal);
System.out.println("IVA: " + iva);
System.out.println("Total: " + total);

}

}
