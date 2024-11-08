package main;

import servicios.ArchivosServicio;

public class AppCreacionArchivosTxt {

	public static void main(String[] args) {
	
        ArchivosServicio archivoServicio = new ArchivosServicio();
        String contenido = "Alumno : 17.423.112-4 - Samuel\r\n"
        		+ "Materia : MATEMATICAS - Promedio : 4.1\r\n"
        		+ "Alumno : 18.546.232-1 - Pepe\r\n"
        		+ "Materia : MATEMATICAS - Promedio : 4.4\r\n"
        		+ "Materia : LENGUAJE - Promedio : 3.4.";
        archivoServicio.crearArchivo("Notas_Promedio_Alumnos.txt", contenido);

	}

}
