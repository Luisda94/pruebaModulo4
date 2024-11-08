package modelo;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	private MateriaEnum nombre;
    private List<Double> notas;
    
    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }
    public MateriaEnum getNombre() {
		return nombre;
	}
	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
    @Override
    public String toString() {
        return nombre.name(); // Devuelve el nombre de la materia en formato String
    }
	public void agregarNota(double nota) {
		// TODO Auto-generated method stub
		
	}
}
