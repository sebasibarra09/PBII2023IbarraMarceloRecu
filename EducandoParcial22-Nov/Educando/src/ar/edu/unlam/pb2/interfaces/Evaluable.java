package ar.edu.unlam.pb2.interfaces;

import java.io.File;

import ar.edu.unlam.pb2.evaluacion.Calificacion;
import ar.edu.unlam.pb2.evaluacion.Evaluacion;
import ar.edu.unlam.pb2.evaluacion.ResolucionDeEvaluacion;

public interface Evaluable {

	void rendir(Evaluacion evaluacion, File resolucion); 
	ResolucionDeEvaluacion getResolucion(Evaluacion evaluacion);
	void serEvaluado(Evaluacion evaluacion, Calificacion nota);
}
