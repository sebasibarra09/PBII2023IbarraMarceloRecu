package test;

import ar.edu.unlam.pb2.evaluacion.Evaluacion;

public class Docente {
	
	

	private String nombreDocente;
	private Grado grado;

	public Docente(String nombreDocente) {
		this.nombreDocente=nombreDocente;
		this.grado=grado;
		
	}

	public void agregarCompetencia(Grado cuarto) {
		this.grado=cuarto;
		
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public void corregir(Evaluacion evaluacionTercerTrimestreCuartoGrado, AlumnoDePrimaria alumno, String nota,
			String devolucion) {
		alumno.getResolucion(evaluacionTercerTrimestreCuartoGrado);
		alumno.setNotas(evaluacionTercerTrimestreCuartoGrado, nota);
		alumno.setDevoluciones(evaluacionTercerTrimestreCuartoGrado, devolucion);
	}


	
		
	}

	

