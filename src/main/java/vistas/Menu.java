package vistas;
import java.util.Scanner;

import modelo.Alumno;
import modelo.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;
public class Menu extends PlantillaMenu {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivosServicio archivoServicio = new ArchivosServicio();

    @Override
    public void exportarDatos() {
        // Lógica de exportar promedios de datos (pendiente de implementar)
    	archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), "/ruta/donde/exportar.txt");
        System.out.println("--- Exportar Datos ---");
        // Llamar a archivoServicio para exportar datos
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
        Scanner por_teclado = new Scanner(System.in);
        System.out.print("Ingresa rut del Alumno: ");
        String rutAlumno1 = por_teclado.nextLine();
        // Aquí asumes que tienes el mecanismo para seleccionar materia (MateriaEnum)
        System.out.println("Selecciona una Materia:");
        System.out.println("1. MATEMATICAS");
        System.out.println("2. LENGUAJE");
        System.out.println("3. CIENCIA");
        System.out.println("4. HISTORIA");
        int opcion = por_teclado.nextInt();
        // Elige la materia según la opción y agrega la materia
        // Se usaría un método en AlumnoServicio que agrega la materia
        alumnoServicio.agregarMateria(rutAlumno1, opcion);
        System.out.println("--- Materia agregada ---");
        por_teclado.close();
    }

    @Override
    public void agregarNotaPasoUno() {
    	System.out.println("--- Agregar Materia ---");
        Scanner por_teclado = new Scanner(System.in);
        System.out.print("Ingresa rut del Alumno: ");
        String rutAlumno = por_teclado.nextLine();
        
        // Aquí asumes que tienes el mecanismo para seleccionar materia (MateriaEnum)
        System.out.println("Selecciona una Materia:");
        System.out.println("1. MATEMATICAS");
        System.out.println("2. LENGUAJE");
        System.out.println("3. CIENCIA");
        System.out.println("4. HISTORIA");
        int opcion = por_teclado.nextInt();
        
        MateriaEnum materiaEnum = null;
        switch (opcion) {
            case 1:
                materiaEnum = MateriaEnum.MATEMATICAS;
                break;
            case 2:
                materiaEnum = MateriaEnum.LENGUAJE;
                break;
            case 3:
                materiaEnum = MateriaEnum.CIENCIA;
                break;
            case 4:
                materiaEnum = MateriaEnum.HISTORIA;
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        
        // Usamos MateriaEnum directamente en lugar de un número
        alumnoServicio.agregarMateria(rutAlumno, materiaEnum);
        System.out.println("--- Materia agregada ---");
    }
    @Override
    public void listarAlumnos() {
        // Lógica para listar alumnos
        System.out.println("--- Listar Alumnos ---");
        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            // Listar materias y notas
            alumno.getMaterias().forEach(materia -> {
                System.out.println("Materia: " + materia.getNombre());
                System.out.println("Notas: " + materia.getNotas());
            });
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
		// TODO Auto-generated method stub
		
	}
}
