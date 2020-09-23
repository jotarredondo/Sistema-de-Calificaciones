package servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import modelos.Alumno;
import modelos.Materia;
import servicios.AlumnoServicio;

public class AlumnosServicioTest {
	
	AlumnoServicio alumnoServicioTest = new AlumnoServicio ();
	Materia matematicas = new Materia();
	Materia lenguaje = new Materia();
	Alumno mapu = new Alumno();
	Alumno mapu2 = new Alumno();
	
	private static AlumnoServicio alumnoServicioMock = mock(AlumnoServicio.class);
	

	@Test
	@DisplayName("Test crearAlumnoTest ")
	public void crearAlumnoTest() {
	
	Map<String,Alumno> mapPrueba = new LinkedHashMap<String,Alumno>();
	
	List<String> listaRut = new ArrayList<String>();
	listaRut.add("1");
	
	for(int i=0; i < listaRut.size();i++) {
		String rutPrueba1 = listaRut.get(i);
		mapPrueba.put(rutPrueba1, mapu);
	}
	
	boolean esperada = mapPrueba.containsValue(mapu);
	
	assertTrue(esperada);	
	
	}
	
	@Test
	@DisplayName("Test agregarMateria")
	public void agregarMateriaTest () {
		
		Map<String,Alumno> mapPruebaMateria = new LinkedHashMap<String,Alumno>();
		
		String rutPrueba2 = "1524";
		mapPruebaMateria.put(rutPrueba2,mapu);
		
		mapPruebaMateria.get(rutPrueba2).setMaterias(matematicas);
		
		boolean esperada = mapPruebaMateria.get(rutPrueba2).getMaterias().contains(matematicas);
		
		assertTrue(esperada);	
		
	}
	
	
	@Test
	@DisplayName ("Test materiaporAlumnos")
	public void materiaPorAlumnosTest() {
		
		String k1 = "1";
		Map<String,Alumno> fixture = new LinkedHashMap<String,Alumno>();
		fixture.put(k1,mapu );
		fixture.get(k1).setMaterias(matematicas);
		
		List<Materia> listaMateriaPrueba = new ArrayList<Materia>();
		
		for (Map.Entry<String, Alumno> llave : fixture.entrySet()) {
			
			String rutPrueba = llave.getKey();

			for (Materia materiasNombres : fixture.get(rutPrueba).getMaterias())
				if (rutPrueba.equals(k1)) {
					listaMateriaPrueba.add(materiasNombres);	
				}
			boolean esperada = listaMateriaPrueba.contains(matematicas);
			
			assertTrue(esperada);
		}	
	}
	

	public  Map<String, Alumno>  setup () {
		
		String k1 = "1";
		String k2 = "2";
				
		Map<String,Alumno> listaReciclada = new LinkedHashMap<String,Alumno>();
		listaReciclada.put(k1, mapu);
		listaReciclada.put(k2, mapu2);	
		listaReciclada.get(k1).setMaterias(matematicas);
		listaReciclada.get(k2).setMaterias(lenguaje);
		return listaReciclada;	
	}

	
	@Test
	@DisplayName ("Test listarAlumnosTest ")
	public void listarAlumnosTest () {
		
		List<Alumno> listaPrueba = new ArrayList<Alumno>();
			
		for(Map.Entry<String, Alumno> iteracion : setup().entrySet()) {
				String llavePrueba = iteracion.getKey();
				
				Alumno values = setup().get(llavePrueba);	
					listaPrueba.add(values);
		}	
		
		int esperada = 2;
		int actual = listaPrueba.size();
		
		assertEquals(esperada, actual);			
		
	}
	
	@Test
	@DisplayName ("Test materiaPorAlumnos")
	public void materiasPorAlumnos ()	{
		
		String k1 = "1";		
		boolean esperada = alumnoServicioMock.materiaPorAlumnos(k1).isEmpty();
	
	assertTrue(esperada);
		
	}
	
	


}
