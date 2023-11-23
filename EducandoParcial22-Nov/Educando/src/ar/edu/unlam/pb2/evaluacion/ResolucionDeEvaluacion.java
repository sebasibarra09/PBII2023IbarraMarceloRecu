package ar.edu.unlam.pb2.evaluacion;

import java.io.File;

public class ResolucionDeEvaluacion {
	
	private File entrega;
	private Calificacion calificacion;
	
	public ResolucionDeEvaluacion(File entrega) {
		this.entrega = entrega;
	}
	
	public File getEntrega() {
		return entrega;
	}
	public void setEntrega(File entrega) {
		this.entrega = entrega;
	}
	public Calificacion getCalificacion() {
		return calificacion;
	}
	public void setNota(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
}
