package test;

import java.io.File;
import java.time.LocalDate;
import java.util.Map;

import ar.edu.unlam.pb2.evaluacion.Evaluacion;
import ar.edu.unlam.pb2.evaluacion.ResolucionDeEvaluacion;

public class AlumnoDeSecundaria extends Alumno {
	
	private Map<Evaluacion, ResolucionDeEvaluacion> resoluciones;
	private Map<Evaluacion, String> notas;
	private Map<Evaluacion, String> devoluciones;

	public AlumnoDeSecundaria(Integer dni, String nombreEstudiandte, LocalDate fechaDeNacimiento) {
		super(dni, nombreEstudiandte, fechaDeNacimiento);
		// TODO Auto-generated constructor stub
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
