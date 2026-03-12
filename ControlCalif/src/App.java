import java.util.Scanner;

public class App {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
GradeService service = new GradeService();

//INPUT
String nombre = leerTextoNoVacio(sc, "Ingresa el nombre del alumno");

double p1 = leerDoubleEnRango(sc, "Parcial 1", 0, 100);
double p2 = leerDoubleEnRango(sc, "Parcial 2", 0, 100);
double p3 = leerDoubleEnRango(sc, "Parcial 3", 0, 100);

int asistencia = leerIntEnRango(sc, "Asistencia (%)", 0, 100);
boolean entregoProyecto = leerBoolean(sc, "Entrego proyecto? (true/false)");

//PROCESS
double promedio = service.calcularPromedio(p1, p2, p3);
double finalCal = service.calcularFinal(promedio, asistencia);
String estado = service.determinarEstado(finalCal, asistencia, entregoProyecto);

//OUTPUT
imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, finalCal, estado);

}

//---------------- INPUT ----------------

public static String leerTextoNoVacio(Scanner sc, String msg) {
String texto;
do {
System.out.println(msg);
texto = sc.nextLine();
if (texto.trim().isEmpty()) {
System.out.println("No puede estar vacio");
}
} while (texto.trim().isEmpty());
return texto;
}

public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
double value;
while (true) {
System.out.println(msg);
if (sc.hasNextDouble()) {
value = sc.nextDouble();
sc.nextLine();
if (value >= min && value <= max) {
return value;
}
System.out.println("Fuera de rango");
} else {
System.out.println("No es numero");
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
sc.nextLine();
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
boolean val = sc.nextBoolean();
sc.nextLine();
return val;
} else {
System.out.println("Solo true o false");
sc.next();
}
}
}

//---------------- OUTPUT ----------------

public static void imprimirReporte(String nombre, double p1, double p2, double p3,
                                   double promedio, int asistencia, boolean proyecto, double finalCal, String estado) {

System.out.println("----- REPORTE FINAL -----");
System.out.println("Alumno: " + nombre);
System.out.println("Parcial 1: " + p1);
System.out.println("Parcial 2: " + p2);
System.out.println("Parcial 3: " + p3);
System.out.println("Promedio: " + promedio);
System.out.println("Asistencia: " + asistencia + "%");
System.out.println("Entrego proyecto: " + proyecto);
System.out.println("Calificacion final: " + finalCal);
System.out.println("Estado: " + estado);

}

}
