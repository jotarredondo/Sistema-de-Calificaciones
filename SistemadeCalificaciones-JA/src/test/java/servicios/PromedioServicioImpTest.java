package servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


	@DisplayName("Test Clase PromedioServicioImp")
	
	
public class PromedioServicioImpTest {
		
		
		
	@Test
	@DisplayName("Test calcularPromediotest ")
	public void calcularPromedio () {
		
		float a = 5;
		float b = 15;
		
		ArrayList<Float> listaPrueba = new ArrayList<Float>();
		listaPrueba.add(a);
		listaPrueba.add(b);
		
		PromedioServicioImp.calcularPromedio(listaPrueba);	
		float esperado = 10;
		
		assertEquals(esperado,PromedioServicioImp.calcularPromedio(listaPrueba));		
		
	}
}
