package servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import servicios.PromedioServicioImp;

@SuppressWarnings("unused")
public class PromedioServicioImpTest {
	private final PromedioServicioImp promedioServicio = new PromedioServicioImp();

    @Test
    public void calcularPromedioTest() {
        // Caso con valores normales
    	var valores = Arrays.asList(5.0, 6.0, 7.0);
        assertEquals(6.0, promedioServicio.calcularPromedio(valores));

        // Caso con lista vacía
        assertEquals(0, promedioServicio.calcularPromedio(Arrays.asList()));

        // Caso con valores nulos
        assertEquals(0, promedioServicio.calcularPromedio(null));
    }
}
