package ar.edu.unlam.pb2.evaluacion;

import java.io.File;

import ar.edu.unlam.pb2.interfaces.Competencia;
import test.Grado;

public class Evaluacion implements Comparable<Evaluacion> {

	private Competencia tema;
	private String titulo;
	private File examen;
	private Grado grado;
	
	public Evaluacion(Competencia tema, String titulo, File examen) {
		this.tema = tema;
		this.titulo = titulo;
		this.examen = examen;
	}
	
	public Evaluacion(Grado cuarto, String nombreEvaluacion, File archivoEvaluacion) {
		this.grado= cuarto;
		this.titulo=nombreEvaluacion;
		this.examen=archivoEvaluacion;
		
		
	}

	public Competencia getTema() {
		return tema;
	}

	public void setTema(Competencia tema) {
		this.tema = tema;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public File getExamen() {
		return examen;
	}

	public void setExamen(File examen) {
		this.examen = examen;
	}

	@Override
	public int compareTo(Evaluacion o) {	
		return this.titulo.compareTo(((Evaluacion)o).getTitulo());
	}
}
