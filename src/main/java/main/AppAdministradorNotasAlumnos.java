package main;

import java.util.Scanner;

import servicios.AlumnoServicio;
import servicios.ArchivosServicio;
import vistas.Menu;

/**
 * Clase principal que inicia la aplicación de gestión de alumnos y materias.
 * Proporciona un menú interactivo para que el usuario pueda cargar datos,
 * crear alumnos, agregar materias y notas, calcular promedios y exportar datos.
 */
public class AppAdministradorNotasAlumnos {

	public static void main(String[] args) {
        Menu menu = new Menu(); // Se instancia el menú principal
        Scanner scanner = new Scanner(System.in);
        AlumnoServicio alumnoServicio = new AlumnoServicio();
        ArchivosServicio archivosServicio = new ArchivosServicio();
        int opcion;

        do {
            // Muestra el menú principal
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Cargar archivo de datos");
            System.out.println("2. Crear alumno");
            System.out.println("3. Agregar materia a un alumno");
            System.out.println("4. Agregar notas a una materia");
            System.out.println("5. Calcular promedios");
            System.out.println("6. Exportar datos a un archivo");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Lógica para manejar las opciones del menú
            switch (opcion) {
            case 1:
            	archivosServicio.exportarDatos(alumnoServicio.listarAlumnos(), "alumnos_exportados.txt");
  break;

                case 2:
                    menu.crearAlumno();
                    break;

                case 3:
                    menu.agregarMateria();
                    break;

                case 4:
                    menu.agregarNotaPasoUno();
                    break;

                case 5:
                    // Aquí puedes implementar la lógica para calcular promedios
                    System.out.println("Funcionalidad de cálculo de promedios aún no implementada.");
                    break;

                case 6:
                    menu.exportarDatos();
                    break;

                case 7:
                    menu.terminarPrograma();
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
    
}
}
