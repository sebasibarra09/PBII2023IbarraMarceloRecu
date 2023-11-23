package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.pb2.Escuela;
import ar.edu.unlam.pb2.alumno.AlumnoDePrimaria;
import ar.edu.unlam.pb2.alumno.AlumnoDeSecundaria;
import ar.edu.unlam.pb2.competencia.Anio;
import ar.edu.unlam.pb2.competencia.Grado;
import ar.edu.unlam.pb2.competencia.Materia;
import ar.edu.unlam.pb2.curso.CursoSecundaria;
import ar.edu.unlam.pb2.curso.GradoPrimaria;
import ar.edu.unlam.pb2.docente.Docente;
import ar.edu.unlam.pb2.evaluacion.Evaluacion;
import ar.edu.unlam.pb2.evaluacion.ResolucionDeEvaluacion;
import ar.edu.unlam.pb2.exception.DocenteNoTieneCompetencia;
import ar.edu.unlam.pb2.exception.NoEstaHabilitadoException;
import ar.edu.unlam.pb2.exception.SinCursosDisponiblesException;

public class TestCases {
	/*
		Se pide realizar un sistema gestión educativa.
		El mismo debe contar con la posibilidad de crear cursos, los cuales pueden ser grados en la Primaria, o años en la Secundaria.
		Además debe permitir la inscripción de alumnos de Primaria y de Secundaria
		En el caso de la Primaria tienen docentes a cargo en cada grado.
		Para poder estar a cargo, deben contar con la competencia para ese grado.
		Los alumnos pueden rendir pruebas, y los docentes corregirlas.
		En la Secundaria, se les exige a los docentes que cuenten con la competencia de la materia, para poder corregir las pruebas.
		El sistema debe permitir llevar un control de asistencia de los alumnos.
	 */
	
	@Test
	public void queUnAlumnoDePrimariaPuedaAsistir() throws SinCursosDisponiblesException, NoEstaHabilitadoException{
		//Preparacion
		final String NOMBRE_DE_LA_ESCUELA = "Escuela Unlam";
		
		final String DESCRIPCION_DEL_CURSO = "Cuarto grado 2023";
		final Integer CL = 2023, EDAD = 10;
		
		final String NOMBRE_DEL_ESTUDIANTE = "Fiorella Fonteveccia";
		final LocalDate FECHA_DE_NACIMIENTO = LocalDate.parse("2013-01-23");
		final Integer DNI = 49354752;
		
		final String NOMBRE_DEL_DOCENTE = "Susana";
		
		//Ejecucion
		Escuela unlam = new Escuela(NOMBRE_DE_LA_ESCUELA);
		
		GradoPrimaria cuartoGrado = new GradoPrimaria(DESCRIPCION_DEL_CURSO, CL, EDAD, Grado.CUARTO);
		unlam.crearCurso(cuartoGrado);
		
		AlumnoDePrimaria alumno = new AlumnoDePrimaria(DNI, NOMBRE_DEL_ESTUDIANTE, FECHA_DE_NACIMIENTO);
		unlam.inscribir(alumno, CL);
		
		Docente susana = new Docente(NOMBRE_DEL_DOCENTE);
		susana.agregarCompetencia(Grado.CUARTO);
		cuartoGrado.setDocente(susana);
		
		alumno.asistir(LocalDate.now());
		
		// Validacion
		assertTrue(alumno.asistio(LocalDate.now()));
	}


	
	
	@Test (expected = SinCursosDisponiblesException.class)
	public void queSiNoHayUnCursoSeArrojeLaExcepcionSinCursosDisponiblesException() throws SinCursosDisponiblesException, NoEstaHabilitadoException {
		// Preparacion
		final String NOMBRE_DE_LA_ESCUELA = "Escuela Unlam";
		
		final String DESCRIPCION_DEL_CURSO = "Cuarto grado 2023";
		final Integer CL = 2023, EDAD = 10;
		
		final String NOMBRE_DEL_ESTUDIANTE = "Fiorella Fonteveccia";
		final LocalDate FECHA_DE_NACIMIENTO = LocalDate.parse("1997-01-23");
		final Integer DNI = 49354752;
			
		// Ejecucion
		Escuela unlam = new Escuela(NOMBRE_DE_LA_ESCUELA);
		
		GradoPrimaria tercerGrado = new GradoPrimaria(DESCRIPCION_DEL_CURSO, CL, EDAD, Grado.TERCERO);
		unlam.crearCurso(tercerGrado);
		
		AlumnoDeSecundaria alumno = new AlumnoDeSecundaria(DNI, NOMBRE_DEL_ESTUDIANTE, FECHA_DE_NACIMIENTO);
		unlam.inscribir(alumno, CL);
		
	}
	
	@Test
	public void queUnAlumnoDeSecundariaPuedaAsistir() throws SinCursosDisponiblesException, NoEstaHabilitadoException {
		// Preparacion
		final String NOMBRE_DE_LA_ESCUELA = "Escuela Unlam";
		
		final String DESCRIPCION_DEL_CURSO = "Cuarto año 2023";
		final Integer CL = 2023, EDAD = 16;
		
		final String NOMBRE_DEL_ESTUDIANTE = "Camila Martens";
		final LocalDate FECHA_DE_NACIMIENTO = LocalDate.parse("1997-07-14");
		final Integer DNI = 45312546;
		
		// Ejecucion
		Escuela unlam = new Escuela(NOMBRE_DE_LA_ESCUELA);
		
		CursoSecundaria cuartoAnio = new CursoSecundaria(DESCRIPCION_DEL_CURSO, CL, EDAD, Anio.CUARTO);
		unlam.crearCurso(cuartoAnio);
		
		AlumnoDeSecundaria alumno = new AlumnoDeSecundaria(DNI, NOMBRE_DEL_ESTUDIANTE, FECHA_DE_NACIMIENTO);
		unlam.inscribir(alumno, CL);
		
		alumno.asistir(LocalDate.now());
		
		// Validacion
		assertTrue(alumno.asistio(LocalDate.now()));
	}
	
	@Test
	public void queUnAlumnoDePrimariaPuedaRendirUnaPrueba() throws SinCursosDisponiblesException, NoEstaHabilitadoException, DocenteNoTieneCompetencia {
		// Preparacion
		final String NOMBRE_DE_LA_ESCUELA = "Escuela Unlam";
		
		final String DESCRIPCION_DEL_CURSO = "Cuarto grado 2023";
		final Integer CL = 2023, EDAD = 10;
		
		final String NOMBRE_DEL_ESTUDIANTE = "Fiorella Fonteveccia";
		final LocalDate FECHA_DE_NACIMIENTO = LocalDate.parse("2015-01-23");
		final Integer DNI = 49354752;
		
		final String NOMBRE_DEL_DOCENTE = "Susana";
		
		final String NOMBRE_ARCHIVO_EVALUACION = "PruebaCuartoGrado.pdf";
		final String NOMBRE_EVALUACION = "Evaluación Tercer trimestre";
		
		final String NOMBRE_ARCHIVO_RESOLUCION = "ResolucionEvaluacion.docx";
		
		
		// Ejecucion
		Escuela unlam = new Escuela(NOMBRE_DE_LA_ESCUELA);

		GradoPrimaria cuartoGrado = new GradoPrimaria(DESCRIPCION_DEL_CURSO, CL, EDAD, Grado.CUARTO);
		unlam.crearCurso(cuartoGrado);
		
		AlumnoDePrimaria alumno = new AlumnoDePrimaria(DNI, NOMBRE_DEL_ESTUDIANTE, FECHA_DE_NACIMIENTO);
		unlam.inscribir(alumno, CL);

		Docente lorusso = new Docente(NOMBRE_DEL_DOCENTE);
		lorusso.agregarCompetencia(Grado.CUARTO);
		cuartoGrado.setaCargo(lorusso);				
		
		File archivoEvaluacion = new File(NOMBRE_ARCHIVO_EVALUACION);
		File archivoResolucion = new File(NOMBRE_ARCHIVO_RESOLUCION);
		Evaluacion evaluacionTercerTrimestreCuartoGrado = new Evaluacion(Grado.CUARTO, NOMBRE_EVALUACION, archivoEvaluacion);
		alumno.rendir(evaluacionTercerTrimestreCuartoGrado, archivoResolucion);
		
		// Validacion
		ResolucionDeEvaluacion resolucion = alumno.getResolucion(evaluacionTercerTrimestreCuartoGrado);
		File verificacionArchivoResolucion = resolucion.getEntrega();
		assertEquals(verificacionArchivoResolucion, archivoResolucion);
	}
	
	@Test
	public void queUnDocenteDePrimariaPuedaCorregirUnaEvaluacion() throws FileNotFoundException, DocenteNoTieneCompetencia, NoEstaHabilitadoException, SinCursosDisponiblesException {
		// Preparacion
		final String NOMBRE_DE_LA_ESCUELA = "Escuela Unlam";
		
		final String DESCRIPCION_DEL_CURSO = "Cuarto grado 2023";
		final Integer CL = 2023, EDAD = 10;
		
		final String NOMBRE_DEL_ESTUDIANTE = "Fiorella Fonteveccia";
		final LocalDate FECHA_DE_NACIMIENTO = LocalDate.parse("2015-01-23");
		final Integer DNI = 49354752;
		
		final String NOMBRE_DEL_DOCENTE = "Susana";
		
		final String NOMBRE_ARCHIVO_EVALUACION = "PruebaCuartoGrado.pdf";
		final String NOMBRE_EVALUACION = "Evaluación Tercer trimestre";
		
		final String NOMBRE_ARCHIVO_RESOLUCION = "ResolucionEvaluacion.docx";
		
		final String NOTA = "Muy Satisfactorio", DEVOLUCION = "Felicitaciones, a seguir aso";
		
		
		// Ejecucion
		Escuela unlam = new Escuela(NOMBRE_DE_LA_ESCUELA);

		GradoPrimaria cuartoGrado = new GradoPrimaria(DESCRIPCION_DEL_CURSO, CL, EDAD, Grado.CUARTO);
		unlam.crearCurso(cuartoGrado);
		
		AlumnoDePrimaria alumno = new AlumnoDePrimaria(DNI, NOMBRE_DEL_ESTUDIANTE, FECHA_DE_NACIMIENTO);
		unlam.inscribir(alumno, CL);

		Docente lorusso = new Docente(NOMBRE_DEL_DOCENTE);
		lorusso.agregarCompetencia(Grado.CUARTO);
		cuartoGrado.setaCargo(lorusso);				
		
		File archivoEvaluacion = new File(NOMBRE_ARCHIVO_EVALUACION);
		File archivoResolucion = new File(NOMBRE_ARCHIVO_RESOLUCION);
		Evaluacion evaluacionTercerTrimestreCuartoGrado = new Evaluacion(Grado.CUARTO, NOMBRE_EVALUACION, archivoEvaluacion);
		alumno.rendir(evaluacionTercerTrimestreCuartoGrado, archivoResolucion);
		lorusso.corregir(evaluacionTercerTrimestreCuartoGrado, alumno, NOTA, DEVOLUCION);
		
		// Validacion
		String devolucion = alumno.getDevolucion(evaluacionTercerTrimestreCuartoGrado);
		assertEquals(devolucion, DEVOLUCION);
	}
	
	@Test
	public void queUnAlumnoDeSecundariaPuedaRendirUnaEvaluacion() throws SinCursosDisponiblesException, NoEstaHabilitadoException {
		
		// Preparacion
		final String NOMBRE_DE_LA_ESCUELA = "Escuela Unlam";
		
		final String DESCRIPCION_DEL_CURSO = "Cuarto año 2023";
		final Integer CL = 2023, EDAD = 16;
		
		final String NOMBRE_DEL_ESTUDIANTE = "Camila Martens";
		final LocalDate FECHA_DE_NACIMIENTO = LocalDate.parse("2007-07-14");
		final Integer DNI = 45312546;
		
		final String MATERIA = "Biologia"; 
		
		final String NOMBRE_ARCHIVO_EVALUACION = "EvaluacionBiologia.pdf";
		final String NOMBRE_EVALUACION = "Sistema respiratorio";
		
		final String NOMBRE_ARCHIVO_RESOLUCION = "ResolucionEvaluacion.docx";
				
		// Ejecucion
		Escuela unlam = new Escuela(NOMBRE_DE_LA_ESCUELA);
		
		Materia biologia = new Materia(MATERIA);
		
		CursoSecundaria cuartoAnio = new CursoSecundaria(DESCRIPCION_DEL_CURSO, CL, EDAD, Anio.CUARTO);
		unlam.crearCurso(cuartoAnio);
		
		Docente lorusso = new Docente("Liliana Loruso");
		lorusso.agregarCompetencia(biologia);
		
		AlumnoDeSecundaria alumno = new AlumnoDeSecundaria(DNI, NOMBRE_DEL_ESTUDIANTE, FECHA_DE_NACIMIENTO);
		
		unlam.inscribir(alumno, CL);
		
		File archivoEvaluacion = new File(NOMBRE_ARCHIVO_EVALUACION);
		Evaluacion sistemaRespiratorio = new Evaluacion(biologia, NOMBRE_EVALUACION, archivoEvaluacion);
		
		File archivoResolucion = new File(NOMBRE_ARCHIVO_RESOLUCION);
		alumno.rendir(sistemaRespiratorio, archivoResolucion);
			
		// Validacion
		assertEquals(archivoResolucion, alumno.getResolucion(sistemaRespiratorio).getEntrega());
	}
	/*
	@Test
	public void queUnDocenteDeSecundariaPuedaCorregirUnaEvaluacion() throws FileNotFoundException, DocenteNoTieneCompetencia, SinCursosDisponiblesException, NoEstaHabilitadoException {
		// Preparacion
		final String NOMBRE_DE_LA_ESCUELA = "Escuela Unlam";
		
		final String DESCRIPCION_DEL_CURSO = "Cuarto año 2023";
		final Integer CL = 2023, EDAD = 16;
		
		final String NOMBRE_DEL_ESTUDIANTE = "Camila Martens";
		final LocalDate FECHA_DE_NACIMIENTO = LocalDate.parse("2007-07-14");
		final Integer DNI = 45312546;
		
		final String MATERIA = "Biologia"; 
		
		final String NOMBRE_ARCHIVO_EVALUACION = "EvaluacionBiologia.pdf";
		final String NOMBRE_EVALUACION = "Sistema respiratorio";
		
		final String NOMBRE_ARCHIVO_RESOLUCION = "ResolucionEvaluacion.docx";
		
		final Double NOTA = 2.0;
		final String DEVOLUCION = "Una verguenza de examen";
		
		
		// Ejecucion
		Escuela unlam = new Escuela(NOMBRE_DE_LA_ESCUELA);
				
		CursoSecundaria cuartoAnio = new CursoSecundaria(DESCRIPCION_DEL_CURSO, CL, EDAD, Anio.CUARTO);
		unlam.crearCurso(cuartoAnio);
		
		Materia biologia = new Materia(MATERIA);
		Docente lorusso = new Docente("Liliana Loruso");
		lorusso.agregarCompetencia(biologia);
		
		AlumnoDeSecundaria alumno = new AlumnoDeSecundaria(DNI, NOMBRE_DEL_ESTUDIANTE, FECHA_DE_NACIMIENTO);
		
		unlam.inscribir(alumno, CL);
		
		File archivoEvaluacion = new File(NOMBRE_ARCHIVO_EVALUACION);
		Evaluacion sistemaRespiratorio = new Evaluacion(biologia, NOMBRE_EVALUACION, archivoEvaluacion);
		
		File archivoResolucion = new File(NOMBRE_ARCHIVO_RESOLUCION);
		alumno.rendir(sistemaRespiratorio, archivoResolucion);
		
		lorusso.corregir(sistemaRespiratorio, alumno, NOTA, DEVOLUCION);
	
		// Validacion
		assertEquals(DEVOLUCION, alumno.getDevolucion(sistemaRespiratorio));
	}
	
	@Test
	public void queSePuedaObtenerUnListadoDeAlumnosOrdenadosPorDni()  {

	}

	@Test
	public void queAlFinalizarUnCicloLectivoSeActualicenLosListadosDeAlumnos() throws FileNotFoundException, DocenteNoTieneCompetencia {

	}
	*/
}