package vistas;

import java.util.Scanner;

import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;

public class Menu extends MenuTemplate  {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivosServicio archivoServicio = new ArchivosServicio();
    private Scanner por_teclado = new Scanner(System.in); // Mantén una única instancia de Scanner


    public void exportarDatos() {
        // Lógica de exportar promedios de datos (pendiente de implementar)
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), "/ruta/donde/exportar.txt");
        System.out.println("--- Exportar Datos ---");
    }

    @Override
    public void crearAlumno() {
        System.out.println("--- Crear Alumno ---");
        System.out.print("Ingresa RUT: ");
        String rut = por_teclado.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = por_teclado.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = por_teclado.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = por_teclado.nextLine();

        Alumno nuevoAlumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.agregarAlumno(nuevoAlumno);
        System.out.println("--- ¡Alumno agregado! ---");
    }

    @Override
    public void agregarMateria(String rutAlumno, MateriaEnum materiaEnum) {
        // Lógica para agregar una materia
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rutAlumno1 = por_teclado.nextLine();

        // Aquí asumes que tienes el mecanismo para seleccionar materia (MateriaEnum)
        System.out.println("Selecciona una Materia:");
        System.out.println("1. MATEMATICAS");
        System.out.println("2. LENGUAJE");
        System.out.println("3. CIENCIA");
        System.out.println("4. HISTORIA");
        int opcion = por_teclado.nextInt();

        // Mapear la opción a un MateriaEnum
        MateriaEnum materiaEnumSeleccionada = obtenerMateriaEnum(opcion);

        if (materiaEnumSeleccionada != null) {
            Materia nuevaMateria = new Materia(materiaEnumSeleccionada);
            alumnoServicio.agregarMateria(rutAlumno1, nuevaMateria);
            System.out.println("--- Materia agregada ---");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    // Método para mapear la opción a un MateriaEnum
    private MateriaEnum obtenerMateriaEnum(int opcion) {
        switch (opcion) {
            case 1: return MateriaEnum.MATEMATICAS;
            case 2: return MateriaEnum.LENGUAJE;
            case 3: return MateriaEnum.CIENCIA;
            case 4: return MateriaEnum.HISTORIA;
            default: return null;  // Retorna null si la opción no es válida
        }
    }

    public void agregarNotaPasoUno() {
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa RUT del Alumno: ");
        String rutAlumno = por_teclado.nextLine();

        System.out.println("Selecciona una Materia:");
        System.out.println("1. MATEMATICAS");
        System.out.println("2. LENGUAJE");
        System.out.println("3. CIENCIA");
        System.out.println("4. HISTORIA");

        int opcion;
        try {
            opcion = por_teclado.nextInt();
            por_teclado.nextLine(); // Limpia el buffer después de nextInt
        } catch (Exception e) {
            System.out.println("Opción inválida. Inténtalo de nuevo.");
            por_teclado.nextLine(); // Limpia el buffer en caso de error
            return;
        }

        MateriaEnum materiaEnum = obtenerMateriaEnum(opcion);

        if (materiaEnum != null) {
            double nota;
            try {
                System.out.print("Ingresa la nota: ");
                nota = por_teclado.nextDouble();
                por_teclado.nextLine(); // Limpia el buffer después de nextDouble
            } catch (Exception e) {
                System.out.println("Nota inválida. Inténtalo de nuevo.");
                por_teclado.nextLine(); // Limpia el buffer en caso de error
                return;
            }

            alumnoServicio.agregarNota(rutAlumno, materiaEnum, nota);
            System.out.println("--- Nota agregada ---");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public void listarAlumnos() {
        // Lógica para listar alumnos
        System.out.println("--- Listar Alumnos ---");
        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            // Listar materias y notas
            if (alumno.getMaterias() != null && !alumno.getMaterias().isEmpty()) {
                alumno.getMaterias().forEach(materia -> {
                    System.out.println("Materia: " + materia.getNombre());
                    System.out.println("Notas: " + materia.getNotas());
                });
            } else {
                System.out.println("Este alumno no tiene materias asignadas.");
            }
        });
    }

    @Override
    public void terminarPrograma() {
        System.out.println("Finalizando programa...");
        System.exit(0);
    }

    /**
     * @return the archivoServicio
     */
    public ArchivosServicio getArchivoServicio() {
        return archivoServicio;
    }

    /**
     * @param archivoServicio the archivoServicio to set
     */
    public void setArchivoServicio(ArchivosServicio archivoServicio) {
        this.archivoServicio = archivoServicio;
    }

    @Override
    public void agregarMateria() {
        // Este método está vacio, ya que se reemplaza con el método sobrecargado.
    }
}
