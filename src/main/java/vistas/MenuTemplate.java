package vistas;

import java.util.Scanner;

import interfaces.IMenuAcciones;
import modelo.MateriaEnum;
/**
 * Clase abstracta que define el comportamiento general de un menú.
 * Implementa la interfaz IMenuAcciones, proporcionando un esqueleto para
 * la lógica de menú en aplicaciones que gestionan datos de alumnos y materias.
 * Las clases hijas deben sobrescribir los métodos para definir la lógica específica.
 */
public abstract class MenuTemplate implements IMenuAcciones {
	protected Scanner por_teclado;

	/**
	 * @param por_teclado
	 */
    /**
     * Constructor que inicializa el objeto Scanner por_teclado para leer entradas del usuario.
     */
	public MenuTemplate () {

		this.por_teclado = new Scanner(System.in);
	}
  
    public void exportarDatos() {}
    public void crearAlumno() {}
    public void agregarMateria() {}
    public void agregarNotaPasoUno() {}
    public void listarAlumnos() {}
    public void terminarPrograma() {}
    
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
	public void agregarMateria(String rutAlumno, MateriaEnum materiaEnum) {
	}
}
