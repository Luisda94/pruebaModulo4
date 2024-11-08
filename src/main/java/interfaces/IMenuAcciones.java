package interfaces;
/**
 * Interfaz que define las acciones básicas de un menú para la gestión de alumnos y materias.
 * Las clases que implementen esta interfaz deben proporcionar las implementaciones específicas
 * para cada una de las operaciones definidas.
 */
public interface IMenuAcciones {
	   /**
     * Exporta los datos a un formato específico.
     * La implementación concreta determinará el destino y formato de la exportación.
     */
void exportarDatos();
    
    void crearAlumno();
    
    void agregarMateria();
    
    void agregarNotaPasoUno();
    
    void listarAlumnos();
    
    void terminarPrograma();

}
