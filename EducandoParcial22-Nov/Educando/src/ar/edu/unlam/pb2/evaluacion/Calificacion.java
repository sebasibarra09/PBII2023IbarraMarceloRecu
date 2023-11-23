package ar.edu.unlam.pb2.evaluacion;

public class Calificacion {

	String nota;
	String devolucion;
	
	public Calificacion(String nota, String devolucion) {
		setNota(nota);
		setDevolucion(devolucion);
	}
	
	public Calificacion(Double nota, String devolucion) {
		setNota(nota.toString());
		setDevolucion(devolucion);
	}
	
	public void setNota(Double nota) {
		this.nota = nota.toString();
	}
	
	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getNota() {
		return this.nota;
	}
	
	public String getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(String devolucion) {
		this.devolucion = devolucion;
	}
}
