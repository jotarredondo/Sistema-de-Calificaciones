package servicios;

import java.util.ArrayList;

public class PromedioServicioImp {

	public static float calcularPromedio(ArrayList<Float> subEach) {

		float nota = 0, promedio = 0;
		for (int i = 0; i < subEach.size(); i++) {

			nota = nota + subEach.get(i);
			promedio = nota / subEach.size();
		}
		return promedio;
	}

}
