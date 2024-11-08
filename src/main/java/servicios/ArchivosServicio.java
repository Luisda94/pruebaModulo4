package servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import modelo.Alumno;
import modelo.Materia;

public class ArchivosServicio {
	   // Atributo donde se almacenarán los alumnos temporalmente mientras se itera un archivo.
    private List<Alumno> alumnosACargar;
    // Instancia de la clase PromedioServicioImp para calcular promedios.
    private PromedioServicioImp promediosServicioImp;
    public void crearArchivo(String nombreArchivo, String contenido) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenido);
            System.out.println("Archivo " + nombreArchivo + " creado y escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }
    }
    public void cargarDatosDesdeArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            while ((reader.readLine()) != null) {
                // Lógica para procesar la línea y convertirla en una instancia de Alumno
                // Aquí puedes usar delimitadores y parsing según el formato del archivo
            }
            System.out.println("Datos cargados desde: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al cargar datos desde el archivo: " + e.getMessage());
        }
    }

    public ArchivosServicio() {
        this.promediosServicioImp = new PromedioServicioImp(); }
    public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido());
                writer.newLine();
                if (alumno.getMaterias() != null) {
                    for (Materia materia : alumno.getMaterias()) {
                        double promedio = promediosServicioImp.calcularPromedio(materia.getNotas());
                        writer.write("Materia: " + materia.getNombre() + " - Promedio: " + promedio);
                        writer.newLine();
                    }
                }
                writer.newLine();
            }
            System.out.println("Datos exportados correctamente a: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar datos: " + e.getMessage());
        }
    }

	/**
	 * @return the alumnosACargar
	 */
	public List<Alumno> getAlumnosACargar() {
		return alumnosACargar;
	}

	/**
	 * @param alumnosACargar the alumnosACargar to set
	 */
	public void setAlumnosACargar(List<Alumno> alumnosACargar) {
		this.alumnosACargar = alumnosACargar;
	}
}
