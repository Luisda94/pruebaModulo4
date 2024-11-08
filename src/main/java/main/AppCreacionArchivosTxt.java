package main;

import servicios.ArchivosServicio;

public class AppCreacionArchivosTxt {

	public static void main(String[] args) {
	
        ArchivosServicio archivoServicio = new ArchivosServicio();
        String contenido = "Contenido para el archivo.";
        archivoServicio.crearArchivo("miArchivo.txt", contenido);

	}

}
