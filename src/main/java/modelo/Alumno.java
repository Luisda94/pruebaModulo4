package modelo;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa un Alumno con atributos básicos y una lista de materias.
 */
public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> materias;

    /**
	 * @param rut
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 */
	public Alumno(String rut, String nombre, String apellido, String direccion) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.materias = new ArrayList<>(); 
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
    public void agregarMateria(Materia materia) {
        if (this.materias == null) {
            this.materias = new ArrayList<>();
        }
        this.materias.add(materia);
    }	
}
