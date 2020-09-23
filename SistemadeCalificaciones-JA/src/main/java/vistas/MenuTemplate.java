package vistas;

import java.io.IOException;
import java.util.Scanner;

public class MenuTemplate {

	Scanner sc = new Scanner(System.in);

	public MenuTemplate() {

	}

	public void cargarDatos() {

	}

	public void exportarDatos() throws IOException {

	}

	public void crearAlummno() {

	}

	public void agregarMateria() {

	}

	public void notaPasoUno() {

	}

	public void listarAlumnos() {

	}

	public void terminarPrograma() {

	}

	public void iniciarMenu() {

		System.out.println("Bienvenido a sistema de calificaciones");
		System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ * ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
		System.out.println("1. - Crear Alumnos");
		System.out.println("2. - Listar Alumnos");
		System.out.println("3. - Agregar Materias");
		System.out.println("4. - Agregar Notas");
		System.out.println("5. - Cargar Datos");
		System.out.println("6. - Exportar Datos");
		System.out.println("7. - Salir");
		System.out.println("Selección :");
		
		
	}
}
