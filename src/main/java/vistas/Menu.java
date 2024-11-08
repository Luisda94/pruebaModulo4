package vistas;
import modelo.Alumno;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;

public class Menu extends PlantillaMenu {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivosServicio archivoServicio = new ArchivosServicio();

    @Override
    public void exportarDatos() {
        // Lógica de exportar promedios de datos (pendiente de implementar)
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
    public void agregarMateria() {
        // Lógica para agregar una materia
        System.out.println("--- Agregar Materia ---");
    }

    @Override
    public void agregarNotaPasoUno() {
        // Lógica para agregar una nota
        System.out.println("--- Agregar Nota ---");
    }

    @Override
    public void listarAlumnos() {
        // Lógica para listar alumnos
        System.out.println("--- Listar Alumnos ---");
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
}
