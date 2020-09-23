package modelos;

import java.util.ArrayList;

public class Materia {

	private MateriaEnum nombre;
	private ArrayList<Float> notas = new ArrayList<Float>();

	public Materia() {

	}

	public Materia(MateriaEnum nombre) {
		super();
		this.nombre = nombre;
	}

	public Materia(MateriaEnum nombre, ArrayList<Float> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;

	}

	public MateriaEnum getNombre() {
		return nombre;
	}

	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Float> getNotas() {
		return notas;
	}

	public void agregarNotas(Float nota) {
		this.notas.add(nota);
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
	}
}
