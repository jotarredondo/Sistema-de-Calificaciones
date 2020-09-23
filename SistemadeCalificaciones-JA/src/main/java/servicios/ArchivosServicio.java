package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;

public class ArchivosServicio {

	boolean mapMateria = false;
	Alumno alumno = new Alumno();
	Materia materias = new Materia();
	PromedioServicioImp promedioServicioImp = new PromedioServicioImp();

	private List<Alumno> alumnosACargar = new ArrayList<Alumno>();
	private List<String> listaRut = new ArrayList<String>();

	public ArchivosServicio() {

	}

	public ArchivosServicio(List<Alumno> alumnosACargar) {
		super();
		this.alumnosACargar = alumnosACargar;
	}

	public List<Alumno> getAlumnosACargar() {
		return alumnosACargar;
	}

	public void setAlumnosACargar(List<Alumno> alumnosACargar) {
		this.alumnosACargar = alumnosACargar;
	}

	public List<String> getListaRut() {
		return listaRut;
	}

	public void setListaRut(List<String> listaRut) {
		this.listaRut = listaRut;
	}

	public ArchivosServicio(List<Alumno> alumnosACargar, List<String> listaRut) {
		super();
		this.alumnosACargar = alumnosACargar;
		this.listaRut = listaRut;
	}

	public void cargaDatos(String ruta) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			br.lines().map(line -> line.split(",")).forEach(datos -> {
				if (!listaRut.contains(datos[0])) {
					alumnosACargar.add(new Alumno(datos[0], datos[1],
							(new ArrayList<Materia>(Arrays.asList(new Materia(MateriaEnum.valueOf(datos[2]),
									new ArrayList<Float>(Arrays.asList(Float.parseFloat(datos[3])))))))));
					listaRut.add(datos[0]);
				} else {

					for (int i = 0; i < alumnosACargar.size(); i++) {
						if (alumnosACargar.get(i).getRut().equals(datos[0])) {

							mapMateria = false;
							alumnosACargar.get(i).getMaterias().stream().forEach(materia -> {
								if (materia.getNombre().equals(MateriaEnum.valueOf(datos[2]))) {
									mapMateria = true;

								}

							});

							if (mapMateria) {
								for (int x = 0; x < alumnosACargar.get(i).getMaterias().size(); x++) {
									if (alumnosACargar.get(i).getMaterias().get(x).getNombre()
											.equals(MateriaEnum.valueOf(datos[2]))) {
										alumnosACargar.get(i).getMaterias().get(x)
												.agregarNotas(Float.parseFloat(datos[3]));
									}
								}

							} else {
								alumnosACargar.get(i).setMaterias(new Materia(MateriaEnum.valueOf(datos[2]),
										new ArrayList<Float>(Arrays.asList(Float.parseFloat(datos[3])))));
							}
						}
					}

				}
			});
		}

	}

	@Override
	public String toString() {
		return "ArchivosServicio [alumnosACargar=" + alumnosACargar + "]";
	}

}
