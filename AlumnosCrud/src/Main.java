import java.util.Scanner;

public class Main {

static Alumno[] alumnos = new Alumno[25];
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {

int opcion;

do {
System.out.println("\n--- MENU ---");
System.out.println("1) Alta alumno");
System.out.println("2) Buscar por ID");
System.out.println("3) Actualizar promedio");
System.out.println("4) Baja logica");
System.out.println("5) Listar activos");
System.out.println("6) Reportes");
System.out.println("0) Salir");
System.out.print("Opcion: ");
opcion = sc.nextInt();

switch (opcion) {
case 1: altaAlumno(); break;
case 2: buscarAlumno(); break;
case 3: actualizarPromedio(); break;
case 4: bajaLogica(); break;
case 5: listarActivos(); break;
case 6: reportes(); break;
case 0: System.out.println("Saliendo..."); break;
default: System.out.println("Opcion invalida");
}

} while (opcion != 0);
}

// ---------- ALTAS ----------
static void altaAlumno() {

System.out.print("ID: ");
int id = sc.nextInt();

if (id <= 0 || idExiste(id)) {
System.out.println("ID invalido o repetido");
return;
}

sc.nextLine();
System.out.print("Nombre: ");
String nombre = sc.nextLine();

if (nombre.isEmpty()) {
System.out.println("Nombre vacio");
return;
}

System.out.print("Promedio: ");
double promedio = sc.nextDouble();

if (promedio < 0 || promedio > 10) {
System.out.println("Promedio invalido");
return;
}

for (int i = 0; i < alumnos.length; i++) {
if (alumnos[i] == null) {
alumnos[i] = new Alumno(id, nombre, promedio);
System.out.println("Alumno registrado");
return;
}
}
}

// ---------- BUSCAR ----------
static void buscarAlumno() {
System.out.print("ID a buscar: ");
int id = sc.nextInt();

for (Alumno a : alumnos) {
if (a != null && a.id == id && a.activo) {
System.out.println("ID: " + a.id);
System.out.println("Nombre: " + a.nombre);
System.out.println("Promedio: " + a.promedio);
return;
}
}
System.out.println("Alumno no encontrado o inactivo");
}

// ---------- ACTUALIZAR ----------
static void actualizarPromedio() {
System.out.print("ID: ");
int id = sc.nextInt();

for (Alumno a : alumnos) {
if (a != null && a.id == id && a.activo) {
System.out.print("Nuevo promedio: ");
double p = sc.nextDouble();

if (p >= 0 && p <= 10) {
a.promedio = p;
System.out.println("Promedio actualizado");
} else {
System.out.println("Promedio invalido");
}
return;
}
}
System.out.println("Alumno no encontrado");
}

// ---------- BAJA ----------
static void bajaLogica() {
System.out.print("ID: ");
int id = sc.nextInt();

for (Alumno a : alumnos) {
if (a != null && a.id == id && a.activo) {
a.activo = false;
System.out.println("Baja realizada");
return;
}
}
System.out.println("Alumno no encontrado");
}

// ---------- LISTAR ----------
static void listarActivos() {
for (Alumno a : alumnos) {
if (a != null && a.activo) {
System.out.println(a.id + " - " + a.nombre + " - " + a.promedio);
}
}
}

// ---------- REPORTES ----------
static void reportes() {

double suma = 0;
int cont = 0;
Alumno mayor = null;
Alumno menor = null;
int mayores8 = 0;

for (Alumno a : alumnos) {
if (a != null && a.activo) {

suma += a.promedio;
cont++;

if (mayor == null || a.promedio > mayor.promedio) {
mayor = a;
}

if (menor == null || a.promedio < menor.promedio) {
menor = a;
}

if (a.promedio >= 8) {
mayores8++;
}
}
}

if (cont == 0) {
System.out.println("No hay alumnos activos");
return;
}

System.out.println("Promedio general: " + (suma / cont));
System.out.println("Mayor promedio: " + mayor.id + " " + mayor.nombre + " " + mayor.promedio);
System.out.println("Menor promedio: " + menor.id + " " + menor.nombre + " " + menor.promedio);
System.out.println("Alumnos >= 8: " + mayores8);
}

// ---------- VALIDACION ----------
static boolean idExiste(int id) {
for (Alumno a : alumnos) {
if (a != null && a.id == id) {
return true;
}
}
return false;
}
}
