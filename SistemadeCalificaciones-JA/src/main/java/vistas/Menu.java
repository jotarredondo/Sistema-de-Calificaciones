package vistas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;
import servicios.PromedioServicioImp;

public class Menu extends MenuTemplate {

	AlumnoServicio alumnoServicio = new AlumnoServicio();
	ArchivosServicio archivosServicio = new ArchivosServicio();
	Alumno alumno = new Alumno();
	Scanner sc = new Scanner(System.in);

	public Menu() {

	}

	@Override
	public void cargarDatos() {

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Cargar Datos ~ ~ ~");
		System.out.println("Ingrese ruta del Archivo");
		String ruta = sc.nextLine();
		try {
			archivosServicio.cargaDatos(ruta);

		} catch (Exception e) {

			e.printStackTrace();

		}

		alumnoServicio.crearAlumno(archivosServicio.getListaRut(), archivosServicio.getAlumnosACargar());
		System.out.println("Datos cargados correctamente");
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ * ~ ~ ~");
		System.out.println(" ");

	}

	@Override
	public void exportarDatos() throws IOException {

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Exportar Datos ~ ~ ~");
		System.out.println();
		System.out.println("Ingrese la ruta donde se encuentra el archivo csv");
		String ruta = sc.nextLine();
		File f = new File(ruta + "/promedios.txt");
		FileWriter fw = new FileWriter(f);
		PrintWriter escritura = new PrintWriter(fw);

		for (Map.Entry<String, Alumno> listaClave : alumnoServicio.getListaAlumnos().entrySet()) {

			String clave = listaClave.getKey();

			String id = alumnoServicio.getListaAlumnos().get(clave).getRut();
			String name = alumnoServicio.getListaAlumnos().get(clave).getNombre();

			escritura.printf("\n\nAlumno : " + "%s" + " - " + "%s\n ", id, name);

			for (Materia subMate : alumnoServicio.getListaAlumnos().get(clave).getMaterias()) {
				String parMate = subMate.getNombre().name();

				ArrayList<Float> subEach = subMate.getNotas();

				escritura.printf("\n" + "Materia : " + "%s" + " - " + "Promedio : " + "%.1f\t", parMate,
						PromedioServicioImp.calcularPromedio(subEach));

				escritura.println(" ");
			}
		}
		escritura.close();

		System.out.println("Datos exportados correctamente");
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ * ~ ~ ~");
		System.out.println(" ");

	}

	@Override
	public void crearAlummno() {

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Crear Alumno ~ ~ ~");
		boolean in = false;
		while (!in) {
			System.out.println("Ingrese Rut ");
			String rutIn = sc.nextLine();
			if (alumnoServicio.getListaAlumnos().containsKey(rutIn)) {
				System.out.println("Este rut ya ha sido ingresado");
				System.out.println("Por favor intente nuevamente");
				System.out.println(" ");
				in = false;
			} else {

				System.out.println("Ingrese Nombre");
				String nombreIn = sc.nextLine();

				System.out.println("Ingrese Apellido");
				String apellidoIn = sc.nextLine();

				System.out.println("Ingrese Dirección");
				String direccionIn = sc.nextLine();

				System.out.println("Alumno creado");
				System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ * ~ ~ ~");
				System.out.println(" ");

				alumnoServicio.getListaAlumnos().put(rutIn, new Alumno(rutIn, nombreIn, apellidoIn, direccionIn));
				in = true;
			}
		}
	}

	public void agregarMateria() {

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Agregar Materia ~ ~ ~");
		System.out.println("");

		int in1 = 1;
		while (in1 == 1) {
			System.out.println("Ingrese rut del alumno");
			String rut = sc.nextLine();
			if (alumnoServicio.getListaAlumnos().containsKey(rut)) {
				System.out.println(" ");
				System.out.println("1.MATEMÁTICAS");
				System.out.println("2.LENGUAJE");
				System.out.println("3.CIENCIAS");
				System.out.println("4.HISTORIA");
				System.out.println("Seleccione una materia : ");
				alumnoServicio.agregarMateria(rut);

				in1 = 2;

			} else {
				System.out.println("Rut incorrecto");
				System.out.println(" ");
				in1 = 2;
			}

		}

	}

	public void notaPasoUno() {

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Agregar Nota ~ ~ ~");
		System.out.println("");
		int in1 = 1;
		while (in1 == 1) {
			System.out.println("Ingrese Rut de Alumno");
			String rut = sc.nextLine();

			if (alumnoServicio.getListaAlumnos().containsKey(rut)) {
				alumnoServicio.materiaPorAlumnos(rut);

				System.out.println("Alumno tiene las siguientes materias agregadas : ");
				System.out.println("");

				for (Materia value : alumnoServicio.getListaMateria()) {
					MateriaEnum materia = value.getNombre();
					if (materia.equals(MateriaEnum.MATEMATICAS)) {
						System.out.println("1. - MATEMATICAS");
					}
					if (materia.equals(MateriaEnum.LENGUAJE)) {
						System.out.println("2. - LENGUAJE");
					}
					if (materia.equals(MateriaEnum.CIENCIA)) {
						System.out.println("3. - CIENCIA");
					}
					if (materia.equals(MateriaEnum.HISTORIA)) {
						System.out.println("4. - HISTORIA");
					}
				}
				alumnoServicio.agregarNotaPasoDos(rut);
				in1 = 2;

			} else {
				System.out.println("Rut incorrecto");
				System.out.println(" ");
				in1 = 1;

			}

		}
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ * ~ ~ ~");
		System.out.println(" ");
	}

	public void listarAlumnos() {

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Listado Alumnos ~ ~ ~");

		alumnoServicio.listarAlumnos();

		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ * ~ ~ ~");
		System.out.println(" ");

	}

	@Override
	public void terminarPrograma() {

		System.out.println("Hasta Pronto");
	}

}
