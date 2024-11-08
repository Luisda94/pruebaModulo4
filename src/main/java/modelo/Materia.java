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
      //  return nombre.name(); 
        return "Materia{" +
        "nombre=" + nombre +
        ", notas=" + notas +'}';}
	public void agregarNota(double nota) {
	    if (this.notas == null) {
	        this.notas = new ArrayList<>();
	    }
	    this.notas.add(nota);		// TODO Auto-generated method stub
		
	}
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Materia materia = (Materia) obj;
	    return nombre == materia.nombre; // `nombre` es de tipo MateriaEnum
	}

	@Override
	public int hashCode() {
	    return nombre != null ? nombre.hashCode() : 0;
	}
}
