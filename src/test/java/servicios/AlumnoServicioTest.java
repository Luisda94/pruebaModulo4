package servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;

public class AlumnoServicioTest {
	private AlumnoServicio alumnoServicio;

    @BeforeEach
    void setUp() {
        // Configuración inicial, se ejecuta antes de cada prueba.
        alumnoServicio = new AlumnoServicio();
        Alumno alumno = new Alumno("12345678", "Juan", "Pérez", "Calle Falsa 123");
        alumnoServicio.agregarAlumno(alumno);
    }

    @Test
    void testAgregarAlumno() {
        // Prueba agregar un alumno
        Alumno alumno = new Alumno("87654321", "Ana", "González", "Calle Real 456");
        alumnoServicio.agregarAlumno(alumno);

        // Verifica si el alumno fue agregado correctamente
        assertEquals(2, alumnoServicio.listarAlumnos().size());
    }

    @Test
    void testAgregarMateria() {
        // Prueba agregar una materia a un alumno
        @SuppressWarnings("unused")
		Alumno alumno = alumnoServicio.listarAlumnos().get("12345678");
        Materia materia = new Materia(MateriaEnum.MATEMATICAS);
        alumnoServicio.agregarMateria("12345678", materia);

        // Verifica si la materia fue agregada correctamente
        List<Materia> materias = alumnoServicio.materiasPorAlumnos("12345678");
        assertTrue(materias.contains(materia));
    }

    @Test
    void testAgregarNota() {
        // Prueba agregar una nota a una materia de un alumno
        @SuppressWarnings("unused")
		Alumno alumno = alumnoServicio.listarAlumnos().get("12345678");
        Materia materia = new Materia(MateriaEnum.MATEMATICAS);
        alumnoServicio.agregarMateria("12345678", materia);
        alumnoServicio.agregarNota("12345678", materia.getNombre(), 7.0);

        // Verifica si la nota fue agregada correctamente
        assertEquals(1, materia.getNotas().size());
        assertEquals(7.0, materia.getNotas().get(0));
    }

	public static List<Materia> materiasPorAlumnos(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
