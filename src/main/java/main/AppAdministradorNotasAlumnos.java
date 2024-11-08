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


        // Aquí agregarías lógica para manejar alumnos
        // Por ejemplo, agregar alumnos, asignar materias, calcular promedios, etc.

        // Al final, exportar datos usando el método de ArchivosServicio
        String contenido = "Alumno : 17.423.112-4 - Samuel\n" +
                           "Materia : MATEMATICAS - Promedio : 4.1\n" +
                           "Alumno : 18.546.232-1 - Pepe\n" +
                           "Materia : MATEMATICAS - Promedio : 4.4\n" +
                           "Materia : LENGUAJE - Promedio : 3.4.";

        // Llama al método para crear el archivo
        archivosServicio.crearArchivo("Notas_Promedio_Alumnos.txt", contenido);
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
            	  archivosServicio.exportarDatos(alumnoServicio.listarAlumnos(), "Notas_Promedio_Alumnos.txt");
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
