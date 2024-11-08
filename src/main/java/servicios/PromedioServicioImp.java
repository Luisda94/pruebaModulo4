package servicios;

import java.util.List;

public class PromedioServicioImp {
	 // Método que calcula el promedio de una lista de valores
    public double calcularPromedio(List<Double> valores) {
        if (valores == null || valores.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (double valor : valores) {
            suma += valor;
        }
        return suma / valores.size();
    }
}
