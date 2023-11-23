package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Alumno {
	
	private Integer dni;
	private String nombreEstudiandte;
	private LocalDate fechaDeNacimiento;
	private Map<LocalDate, Boolean> presentes;

	public Alumno(Integer dni, String nombreEstudiandte, LocalDate fechaDeNacimiento) {
		this.dni=dni;
		this.nombreEstudiandte=nombreEstudiandte;
		this.fechaDeNacimiento=fechaDeNacimiento;
		this.presentes=new TreeMap <> ();
	}
	
	public void asistir(LocalDate now) {
		this.presentes.put(now, true);	
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

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}


	public Boolean asistio(LocalDate now) {
		for (Map.Entry<LocalDate, Boolean> entry : presentes.entrySet()) {
			LocalDate key = entry.getKey();
			Boolean val = entry.getValue();
			if (key.equals(now)) {
				return val;
			}
		}
		return false;
	}

}
