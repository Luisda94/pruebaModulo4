package modelo;

import java.util.List;

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
	}
}
