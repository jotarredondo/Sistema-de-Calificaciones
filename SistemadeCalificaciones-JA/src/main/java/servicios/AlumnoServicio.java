package servicios;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;

public class AlumnoServicio {

	Scanner sc = new Scanner(System.in);
	Materia materia = new Materia();

	private Map<String, Alumno> listaAlumnos = new LinkedHashMap<String, Alumno>();
	private List<Materia> listaMateria = new ArrayList<Materia>();
	private float nota;
	private boolean clave;

	public AlumnoServicio() {

	}

	public AlumnoServicio(Map<String, Alumno> listaAlumnos) {
		super();
		this.listaAlumnos = listaAlumnos;
	}

	public List<Materia> getListaMateria() {
		return listaMateria;
	}

	public void setListaMateria(List<Materia> listaMateria) {
		this.listaMateria = listaMateria;
	}

	public Map<String, Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(Map<String, Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public void crearAlumno (List<String> listaRut, List<Alumno> alumnosACargar) {
	
		for (int i = 0; i < listaRut.size(); i++) {
			String rutSet = listaRut.get(i);
			listaAlumnos.put(rutSet, null);
		}

		for (int i = 0; i < alumnosACargar.size(); i++) {
			if (listaAlumnos.containsKey(alumnosACargar.get(i).getRut())) {
				listaAlumnos.put(alumnosACargar.get(i).getRut(),
						new Alumno(alumnosACargar.get(i).getRut(), alumnosACargar.get(i).getNombre(), alumnosACargar.get(i).getMaterias()));
			}
		}
	}

	public void agregarMateria(String rut) {
		clave = false;

		int op1 = sc.nextInt();

		if (op1 == 0 || op1 > 4) {
			System.out.println("Opción inválida, vuelva a ingresar");
		}

		if (op1 == 1) {

			Materia mate = new Materia(MateriaEnum.MATEMATICAS);
			MateriaEnum nameM = MateriaEnum.MATEMATICAS;

			for (Materia materias : listaAlumnos.get(rut).getMaterias()) {

				if (materias.getNombre().equals(nameM)) {

					clave = true;
				}
			}
			if (clave == false) {

				listaAlumnos.get(rut).setMaterias(mate);
				System.out.println("Materia Agregada : MATEMATICAS ");

			} else {

				System.out.println("Esta materia ya está agregada");

			}
		}

		if (op1 == 2) {

			Materia leng = new Materia(MateriaEnum.LENGUAJE);
			MateriaEnum nameL = MateriaEnum.LENGUAJE;

			for (Materia materias : listaAlumnos.get(rut).getMaterias()) {

				if (materias.getNombre().equals(nameL)) {

					clave = true;
				}
			}
			if (clave == false) {

				listaAlumnos.get(rut).setMaterias(leng);
				System.out.println("Materia Agregada : LENGUAJE ");

			} else {

				System.out.println("Esta materia ya está agregada");
			}
		}

		if (op1 == 3) {

			Materia cien = new Materia(MateriaEnum.CIENCIA);
			MateriaEnum nameC = MateriaEnum.CIENCIA;

			for (Materia materias : listaAlumnos.get(rut).getMaterias()) {

				if (materias.getNombre().equals(nameC)) {

					clave = true;
				}
			}
			if (clave == false) {

				listaAlumnos.get(rut).setMaterias(cien);
				System.out.println("Materia Agregada : CIENCIA ");

			} else {

				System.out.println("Esta materia ya está agregada");
			}
		}

		if (op1 == 4) {

			Materia hist = new Materia(MateriaEnum.HISTORIA);
			MateriaEnum nameH = MateriaEnum.HISTORIA;

			for (Materia materias : listaAlumnos.get(rut).getMaterias()) {

				if (materias.getNombre().equals(nameH)) {

					clave = true;
				}
			}
			if (clave == false) {

				listaAlumnos.get(rut).setMaterias(hist);
				System.out.println("Materia Agregada : HISTORIA ");

			} else {

				System.out.println("Esta materia ya está agregada");
			}
		}

		System.out.println(" ");
	}

	public void listarAlumnos() {

		for (Map.Entry<String, Alumno> listaClave : listaAlumnos.entrySet()) {

			String clave = listaClave.getKey();
			

			String id = listaAlumnos.get(clave).getRut();
			String name = listaAlumnos.get(clave).getNombre();
			String surname = listaAlumnos.get(clave).getApellido();
			String adress = listaAlumnos.get(clave).getDireccion();

			System.out.printf("\nDatos del alumno\n" + "\tRUT:" + "%s\n" + "\tNombre:" + "%s\n " + "\tApellido:"
					+ "%s\n" + "\tDireccion:" + "%s\n", id, name, surname, adress);

			for (Materia subMate : listaAlumnos.get(clave).getMaterias()) {
				String parMate = subMate.getNombre().name();

				System.out.printf("\n" + "Materia \n" + "\t%s\n", parMate);

				System.out.printf("\n" + "\tNotas \n");

				for (Float subEach : subMate.getNotas()) {

					Float subNota = subEach.floatValue();

					System.out.printf("\t%s\t", subNota);
					System.out.println(" ");

				}
			}
		}
	}

	public List<Materia> materiaPorAlumnos(String rut) {

		listaMateria.clear();

		for (Map.Entry<String, Alumno> value : listaAlumnos.entrySet()) {
			String rutOut = value.getKey();

			for (Materia materiasNombres : listaAlumnos.get(rut).getMaterias())
				if (rutOut.equals(rut)) {
					listaMateria.add(materiasNombres);
				}
		}
		return listaMateria;
	}

	public void agregarNotaPasoDos(String rut) {

		int in = 1;
		while (in == 1) {

			System.out.println("Seleccione una materia : ");
			int op2 = sc.nextInt();

			if (op2 == 0 || op2 > 4) {
				System.out.println("Opción inválida, vuelva a ingresar");
				in = 1;
			}
			if (op2 == 1) {

				System.out.println("Ingrese nota, separada por una coma : ");

				nota = sc.nextFloat();

				for (Materia materia : listaAlumnos.get(rut).getMaterias()) {

					MateriaEnum mate = MateriaEnum.MATEMATICAS;

					if (materia.getNombre().equals(mate)) {
						materia.agregarNotas(nota);
						System.out.println("Nota ingresada a MATEMATICAS");
					}
				}
				in = 2;
			}

			if (op2 == 2) {

				System.out.println("Ingrese nota, separada por una coma : ");

				nota = sc.nextFloat();

				for (Materia materia : listaAlumnos.get(rut).getMaterias()) {

					MateriaEnum leng = MateriaEnum.LENGUAJE;

					if (materia.getNombre().equals(leng)) {
						materia.agregarNotas(nota);
						System.out.println("Nota ingresada a LENGUAJE");

					}
				}
				in = 2;
			}

			if (op2 == 3) {

				System.out.println("Ingrese nota, separada por una coma : ");

				nota = sc.nextFloat();

				for (Materia materia : listaAlumnos.get(rut).getMaterias()) {

					MateriaEnum cien = MateriaEnum.CIENCIA;

					if (materia.getNombre().equals(cien)) {
						materia.agregarNotas(nota);
						System.out.println("Nota ingresada a CIENCIA");

					}
				}
				in = 2;
			}

			if (op2 == 4) {

				System.out.println("Ingrese nota, separada por una coma : ");

				nota = sc.nextFloat();

				for (Materia materia : listaAlumnos.get(rut).getMaterias()) {

					MateriaEnum hist = MateriaEnum.HISTORIA;

					if (materia.getNombre().equals(hist)) {
						materia.agregarNotas(nota);
						System.out.println("Nota ingresada a HISTORIA");

					}
				}
				in = 2;
			}
		}
	}

	@Override
	public String toString() {
		return "AlumnoServicio [sc=" + sc + ", listaAlumnos=" + listaAlumnos + "]";
	}

}
