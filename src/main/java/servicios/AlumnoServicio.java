package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;
/**
 * Servicio para gestionar operaciones relacionadas con alumnos.
 */
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

    public void agregarMateria(String rutAlumno, Materia materia) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            if (alumno.getMaterias() == null) {
                alumno.setMaterias(new ArrayList<>());
            }
            alumno.getMaterias().add(materia);
            System.out.println("Materia agregada con éxito al alumno con RUT: " + rutAlumno);
            System.out.println("Materias actuales del alumno: " + alumno.getMaterias()); // Agregar esta línea para depurar
        } else {
            System.out.println("No se encontró un alumno con el RUT proporcionado.");
        }
    }

 // Método para agregar una nota a una materia de un alumno
    public void agregarNota(String rutAlumno, MateriaEnum materiaEnum, double nota) {
        // Busca al alumno por su RUT en el mapa
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno == null) {
            System.out.println("El alumno no existe.");
            return;
        }
        
        // Busca la materia dentro de la lista de materias del alumno
        for (Materia materia : alumno.getMaterias()) {
            if (materia.getNombre().equals(materiaEnum)) {
                materia.agregarNota(nota); // Asegúrate de que el método `agregarNota` exista en la clase `Materia`
                System.out.println("Nota agregada con éxito a la materia " + materiaEnum);
                return;
            }
        }
        
        // Si la materia no existe
        System.out.println("El alumno no tiene la materia " + materiaEnum);
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
}
