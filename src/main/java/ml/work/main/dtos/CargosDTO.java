package ml.work.main.dtos;

import java.io.Serializable;
import java.util.List;

import ml.work.main.entities.Empleado;

public class CargosDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id_cargo;
	
	private String puesto;
	
	private List<Empleado> empleados;

	public CargosDTO(int id_cargo, String puesto, List<Empleado> empleados) {
		this.id_cargo = id_cargo;
		this.puesto = puesto;
		this.empleados = empleados;
	}

	public CargosDTO() {
	}

	public int getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	

}
