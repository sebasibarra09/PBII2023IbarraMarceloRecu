package test;

import java.io.File;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import ar.edu.unlam.pb2.evaluacion.Evaluacion;
import ar.edu.unlam.pb2.evaluacion.ResolucionDeEvaluacion;

public class AlumnoDePrimaria extends Alumno {
	
	private Integer dni;
	private String nombreEstudiandte;
	private LocalDate fechaDeNacimiento;
	private Map<Evaluacion, ResolucionDeEvaluacion> resoluciones;
	private Map<Evaluacion, String> notas;
	private Map<Evaluacion, String> devoluciones;
	
	
	

	public AlumnoDePrimaria(Integer dni, String nombreEstudiandte, LocalDate fechaDeNacimiento) {
		super(dni, nombreEstudiandte, fechaDeNacimiento);
		this.resoluciones=new TreeMap<>();
		this.notas=new TreeMap<>();
		this.devoluciones=new TreeMap<>();
	}

	public Map<Evaluacion, ResolucionDeEvaluacion> getResoluciones() {
		return resoluciones;
	}

	public void setResoluciones(Map<Evaluacion, ResolucionDeEvaluacion> resoluciones) {
		this.resoluciones = resoluciones;
	}

	public Map<Evaluacion, String> getNotas() {
		return notas;
	}

	public void setNotas(Evaluacion eva, String nota) {
		notas.put(eva, nota);
	}

	public Map<Evaluacion, String> getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(Evaluacion eva, String devo) {
		devoluciones.put(eva, devo);
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombreEstudiandte() {
		return nombreEstudiandte;
	}

	public void setNombreEstudiandte(String nombreEstudiandte) {
		this.nombreEstudiandte = nombreEstudiandte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoDePrimaria other = (AlumnoDePrimaria) obj;
		return Objects.equals(dni, other.dni); 
	}

	public void rendir(Evaluacion evaluacionTercerTrimestreCuartoGrado, File archivoResolucion) {
		ResolucionDeEvaluacion reso = new ResolucionDeEvaluacion(archivoResolucion);
		resoluciones.put(evaluacionTercerTrimestreCuartoGrado, reso);
	}

	public ResolucionDeEvaluacion getResolucion(Evaluacion evaluacionTercerTrimestreCuartoGrado) {
		for (Map.Entry<Evaluacion, ResolucionDeEvaluacion> entry : resoluciones.entrySet()) {
			Evaluacion key = entry.getKey();
			ResolucionDeEvaluacion val = entry.getValue();
			if (key.equals(evaluacionTercerTrimestreCuartoGrado)) {
				return val;
			}
		};
		return null;
	}

	public String getDevolucion(Evaluacion evaluacionTercerTrimestreCuartoGrado) {
		return devoluciones.get(evaluacionTercerTrimestreCuartoGrado);
	
	}


	

}
