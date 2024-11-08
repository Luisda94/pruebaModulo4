package vistas;

import java.util.Scanner;

public abstract class PlantillaMenu {
	protected Scanner por_teclado;

	/**
	 * @param por_teclado
	 */
	public PlantillaMenu(/*Scanner por_teclado*/) {
		/*super();
		this.por_teclado = por_teclado;*/
		this.por_teclado = new Scanner(System.in);
	}
	// Métodos a sobrescribir en subclases
    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();

    // Método no sobrescribible
    public final void iniciarMenu() {
        int opcion;
        do {
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear Alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.print("Selecciona una opción: ");
            opcion = por_teclado.nextInt();
            por_teclado.nextLine(); // limpiar buffer
            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    agregarMateria();
                    break;
                case 4:
                    agregarNotaPasoUno();
                    break;
                case 5:
                    terminarPrograma();
                    break;
                case 6:
                    exportarDatos();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }
	/*public void agregarMateria(String rutAlumno, MateriaEnum materiaEnum) {
	}*/
}
