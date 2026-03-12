package CRUD;

import java.util.Scanner;

public class app {
    private static final int MAX_PERSONAS = 20;
    private static Persona[] personas = new Persona[MAX_PERSONAS];
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE PERSONAS ===");
        System.out.println("¡Bienvenido!");
        
        mostrarMenu();
    }
    
    /**
     * Muestra el menú principal y maneja las opciones
     */
    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID (solo activas)");
            System.out.println("0) Salir");
            
            opcion = InputUtils.solicitarOpcionMenu(scanner, "Seleccione una opción: ", 0, 5);
            
            switch (opcion) {
                case 1:
                    altaPersona();
                    break;
                case 2:
                    buscarPersonaPorId();
                    break;
                case 3:
                    bajaLogicaPersona();
                    break;
                case 4:
                    listarPersonasActivas();
                    break;
                case 5:
                    actualizarNombrePersona();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el sistema! ¡Hasta luego!");
                    break;
            }
        } while (opcion != 0);
    }
    
    /**
     * Da de alta una nueva persona
     */
    private static void altaPersona() {
        System.out.println("\n--- ALTA DE PERSONA ---");
        
        // Verificar si hay espacio disponible
        if (hayEspacioDisponible() == -1) {
            System.out.println("Error: No hay espacio disponible para más personas.");
            return;
        }
        
        int id = InputUtils.solicitarEnteroPositivo(scanner, "Ingrese el ID: ");
        
        // Verificar si el ID ya existe
        if (existeId(id)) {
            System.out.println("Error: Ya existe una persona con ese ID.");
            return;
        }
        
        String nombre = InputUtils.solicitarStringNoVacio(scanner, "Ingrese el nombre: ");
        
        // Buscar posición libre y crear persona
        int posicion = hayEspacioDisponible();
        personas[posicion] = new Persona(id, nombre);
        
        System.out.println("¡Persona creada exitosamente!");
        System.out.println(personas[posicion].toString());
    }
    
    /**
     * Busca una persona por ID (solo activas)
     */
    private static void buscarPersonaPorId() {
        System.out.println("\n--- BUSCAR PERSONA POR ID ---");
        
        int id = InputUtils.solicitarEnteroPositivo(scanner, "Ingrese el ID a buscar: ");
        
        Persona persona = buscarPersonaActivaPorId(id);
        if (persona != null) {
            System.out.println("Persona encontrada:");
            System.out.println(persona.toString());
        } else {
            System.out.println("Persona no encontrada o inactiva.");
        }
    }
    
    /**
     * Realiza baja lógica de una persona
     */
    private static void bajaLogicaPersona() {
        System.out.println("\n--- BAJA LÓGICA DE PERSONA ---");
        
        int id = InputUtils.solicitarEnteroPositivo(scanner, "Ingrese el ID de la persona a dar de baja: ");
        
        Persona persona = buscarPersonaPorId(id);
        if (persona == null) {
            System.out.println("Persona no encontrada.");
            return;
        }
        
        if (!persona.isActiva()) {
            System.out.println("La persona ya está inactiva.");
            return;
        }
        
        persona.setActiva(false);
        System.out.println("Persona dada de baja exitosamente.");
        System.out.println(persona.toString());
    }
    
    /**
     * Lista todas las personas activas
     */
    private static void listarPersonasActivas() {
        System.out.println("\n--- LISTA DE PERSONAS ACTIVAS ---");
        
        boolean hayActivas = false;
        for (int i = 0; i < MAX_PERSONAS; i++) {
            if (personas[i] != null && personas[i].isActiva()) {
                System.out.println(personas[i].toString());
                hayActivas = true;
            }
        }
        
        if (!hayActivas) {
            System.out.println("No hay personas activas registradas.");
        }
    }
    
    /**
     * Actualiza el nombre de una persona activa por ID
     */
    private static void actualizarNombrePersona() {
        System.out.println("\n--- ACTUALIZAR NOMBRE ---");
        
        int id = InputUtils.solicitarEnteroPositivo(scanner, "Ingrese el ID de la persona a actualizar: ");
        
        Persona persona = buscarPersonaActivaPorId(id);
        if (persona == null) {
            System.out.println("Persona no encontrada o inactiva.");
            return;
        }
        
        System.out.println("Persona actual: " + persona.toString());
        String nuevoNombre = InputUtils.solicitarStringNoVacio(scanner, "Ingrese el nuevo nombre: ");
        
        persona.setNombre(nuevoNombre);
        System.out.println("Nombre actualizado exitosamente:");
        System.out.println(persona.toString());
    }
    
    /**
     * Verifica si hay espacio disponible en el arreglo
     * @return La posición libre o -1 si no hay espacio
     */
    private static int hayEspacioDisponible() {
        for (int i = 0; i < MAX_PERSONAS; i++) {
            if (personas[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Verifica si ya existe un ID en el sistema
     * @param id El ID a verificar
     * @return true si existe, false en caso contrario
     */
    private static boolean existeId(int id) {
        for (int i = 0; i < MAX_PERSONAS; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Busca una persona por ID (sin importar si está activa)
     * @param id El ID a buscar
     * @return La persona encontrada o null si no existe
     */
    private static Persona buscarPersonaPorId(int id) {
        for (int i = 0; i < MAX_PERSONAS; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                return personas[i];
            }
        }
        return null;
    }
    
    /**
     * Busca una persona activa por ID
     * @param id El ID a buscar
     * @return La persona activa encontrada o null si no existe o está inactiva
     */
    private static Persona buscarPersonaActivaPorId(int id) {
        Persona persona = buscarPersonaPorId(id);
        return (persona != null && persona.isActiva()) ? persona : null;
    }
}
