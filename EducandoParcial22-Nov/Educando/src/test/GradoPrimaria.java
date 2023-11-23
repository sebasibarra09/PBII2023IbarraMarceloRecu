package test;

import ar.edu.unlam.pb2.exception.DocenteNoTieneCompetencia;

public class GradoPrimaria {
	

	private String descripcion;
	private Integer cicloElectivo;
	private Integer edad;
	private Grado grado;
	private Docente docente;

	public GradoPrimaria(String descripcion, Integer cicloElectivo, Integer edad, Grado grado) {
		this.descripcion=descripcion;
		this.cicloElectivo=cicloElectivo;
		this.edad=edad;
		this.grado=grado;
		this.docente = docente;
	}

	public void setDocente(Docente docente) {
		this.docente= docente;
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCicloElectivo() {
		return cicloElectivo;
	}

	public void setCicloElectivo(Integer cicloElectivo) {
		this.cicloElectivo = cicloElectivo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setaCargo(Docente doc) throws DocenteNoTieneCompetencia {
		if (!doc.getGrado().equals(this.grado)) {
			throw new DocenteNoTieneCompetencia();
		}
		this.docente=doc;
		
	}

}
