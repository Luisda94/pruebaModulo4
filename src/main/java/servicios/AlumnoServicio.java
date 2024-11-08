package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Alumno;
import modelo.Materia;

public class AlumnoServicio {
	// Mapa para almacenar alumnos, donde la clave es el RUT del alumno
	private Map<String, Alumno> listaAlumnos = new HashMap<>();

	// Método para agregar un alumno
	public void agregarAlumno(Alumno alumno) {
		if (listaAlumnos.containsKey(alumno.getRut())) {
			System.out.println("El alumno con RUT " + alumno.getRut() + " ya existe.");
		} else {
			listaAlumnos.put(alumno.getRut(), alumno);
			System.out.println("Alumno agregado con éxito.");
		}
	}


	public void agregarMateria(String rutAlumno, Materia materia, int opcio) {
		Alumno alumno = listaAlumnos.get(rutAlumno);
		if (alumno != null) {
			if (alumno.getMaterias() == null) {
				alumno.setMaterias(new ArrayList<>());
			}
			alumno.getMaterias().add(materia);
			System.out.println("Materia agregada con éxito al alumno con RUT: " + rutAlumno);
		} else {
			System.out.println("No se encontró un alumno con el RUT proporcionado.");
		}
	}

	// Método para obtener la lista de materias de un alumno por RUT
	public List<Materia> materiasPorAlumnos(String rutAlumno) {
		Alumno alumno = listaAlumnos.get(rutAlumno);
		if (alumno != null) {
			return alumno.getMaterias();
		} else {
			System.out.println("No se encontró un alumno con el RUT proporcionado.");
			return new ArrayList<>(); // Retornar lista vacía si no se encuentra el alumno
		}
	}

	// Método para listar todos los alumnos
	public Map<String, Alumno> listarAlumnos() {
		if (listaAlumnos.isEmpty()) {
			System.out.println("No hay alumnos registrados.");
		} else {
			for (Alumno alumno : listaAlumnos.values()) {
				System.out.println("RUT: " + alumno.getRut());
				System.out.println("Nombre: " + alumno.getNombre());
				System.out.println("Apellido: " + alumno.getApellido());
				System.out.println("Dirección: " + alumno.getDireccion());
				System.out.println("Materias:");
				if (alumno.getMaterias() != null) {
					for (Materia materia : alumno.getMaterias()) {
						System.out.println("- " + materia.getNombre());
					}
				} else {
					System.out.println("No tiene materias asignadas.");
				}
				System.out.println("------------------------");
			}
		}
		return listaAlumnos;
	}

	// Agregar una nota a una materia de un alumno
	public void agregarNota(String rutAlumno, Materia materia, double nota) {
		Alumno alumno = listaAlumnos.get(rutAlumno);
		if (alumno != null) {
			List<Materia> materias = alumno.getMaterias();
			for (Materia m : materias) {
				if (m.getNombre() == materia.getNombre()) {
					m.getNotas().add(nota); // Agregar la nota a la materia
					break;
				}
			}
		}
	}
}