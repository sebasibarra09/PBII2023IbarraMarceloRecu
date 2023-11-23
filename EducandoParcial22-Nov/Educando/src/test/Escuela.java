package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ar.edu.unlam.pb2.exception.NoEstaHabilitadoException;
import ar.edu.unlam.pb2.exception.SinCursosDisponiblesException;

public class Escuela {
	
	

	private String nombre;
	private Set<GradoPrimaria> gradosPrimaria;
	private Set<CursoSecundaria> gradosSecundaria;
	private Set<Alumno> alumnos;
	private Map<GradoPrimaria, Alumno> inscriptosPrimaria;
	private Map<CursoSecundaria, Alumno> inscriptosSecundaria;
	
	

	public Escuela(String nombre) {
		this.nombre=nombre;
		this.gradosPrimaria=new HashSet<>();
		this.gradosSecundaria=new HashSet<>();
		this.alumnos=new HashSet<>();
		this.inscriptosPrimaria = new HashMap<>();
		this.inscriptosSecundaria = new HashMap<>();
		
	}

	public void crearCurso(GradoPrimaria cuartoGrado) {
		gradosPrimaria.add(cuartoGrado);
		
	}

	public void inscribir(Alumno alumno, Integer cl) throws SinCursosDisponiblesException, NoEstaHabilitadoException {
		if (cl-alumno.getFechaDeNacimiento().getYear() < 11) {
			if (alumno instanceof AlumnoDeSecundaria) {
				throw new NoEstaHabilitadoException();
			}
			for (GradoPrimaria grado : gradosPrimaria) {
				inscriptosPrimaria.put(grado, alumno);
				return;
				}
		} else {
			if (alumno instanceof AlumnoDePrimaria) {
				throw new NoEstaHabilitadoException();
			}
			for (CursoSecundaria grado : gradosSecundaria) {
				inscriptosSecundaria.put(grado, alumno);
				return;
			}
		}
		
		throw new SinCursosDisponiblesException();		
		
	}

	public void crearCurso(CursoSecundaria cuartoAnio) {
			gradosSecundaria.add(cuartoAnio);
		
	}

}
