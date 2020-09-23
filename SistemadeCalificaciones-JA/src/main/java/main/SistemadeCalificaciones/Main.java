package main.SistemadeCalificaciones;

import java.util.Scanner;

import vistas.Menu;
import vistas.MenuTemplate;

public class Main {

	public static void main(String[] args) throws Throwable {

		Scanner sc = new Scanner(System.in);
		MenuTemplate menuTemplate = new MenuTemplate();
		Menu menu = new Menu();

		int in = 1;
		while (in == 1) {

			menuTemplate.iniciarMenu();

			int op = sc.nextInt();
			if (op > 7 || op == 0) {
				System.out.println("Ingrese una opcion válida");
				System.out.println(" ");
				in = 1;

			} else {

				if (op == 1) {
					menu.crearAlummno();
					in = 1;
				}
				if (op == 2) {
					menu.listarAlumnos();
					in = 1;
				}
				if (op == 3) {
					menu.agregarMateria();
					in = 1;
				}
				if (op == 4) {
					menu.notaPasoUno();
					in = 1;
				}
				if (op == 5) {
					menu.cargarDatos();
					in = 1;
				}
				if (op == 6) {
					menu.exportarDatos();
					in = 1;
				}
				if (op == 7) {
					menu.terminarPrograma();
					in = 2;
					sc.close();
				}
			}
		}
	}
}
