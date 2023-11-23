package test;

public class CursoSecundaria {
	
	private String descripcion;
	private Integer cicloElectivo;
	private Integer edad;
	private Anio grado;
	private Docente docente;

	public CursoSecundaria(String descripcion, Integer cicloElectivo, Integer edad, Anio grado) {
		this.descripcion=descripcion;
		this.cicloElectivo=cicloElectivo;
		this.edad=edad;
		this.grado=grado;
		this.docente = docente;
	}


}
