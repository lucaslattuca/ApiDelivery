package ml.work.main.dtos;

import java.io.Serializable;
import java.util.Date;

import ml.work.main.entities.Cargos;
import ml.work.main.entities.Domicilio;

public class EmpleadoDTO extends PersonaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codigo_ingreso;
	
	private int cuil;
	
	private int id_empleado;
	
	//private int cod_cargo;
	
	private Cargos cargo;
	
	private Domicilio direccionEmpleado;

	public EmpleadoDTO() {
		super();
	}

	public EmpleadoDTO(String nombre_persona, int dni, String password, int telefono, String email,
			int codigo_ingreso, int cuil, Domicilio direccionEmpleado, int id_empleado, 
//			int cod_cargo, 
			Date baja, Date alta) {
		super(nombre_persona, dni, password, telefono, email, alta, baja);
		this.codigo_ingreso = codigo_ingreso;
		this.cuil = cuil;
		this.direccionEmpleado = direccionEmpleado;
//		this.cod_cargo = cod_cargo;
		this.id_empleado = id_empleado;
		this.alta = alta;
		this.baja = baja;
	}

	public int getCodigo_ingreso() {
		return codigo_ingreso;
	}

	public void setCodigo_ingreso(int codigo_ingreso) {
		this.codigo_ingreso = codigo_ingreso;
	}

	public int getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
		this.cuil = cuil;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

//	public int getCod_cargo() {
//		return cod_cargo;
//	}
//
//	public void setCod_cargo(int cod_cargo) {
//		this.cod_cargo = cod_cargo;
//	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public Date getBaja() {
		return baja;
	}

	public void setBaja(Date baja) {
		this.baja = baja;
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}

	public Domicilio getDireccionEmpleado() {
		return direccionEmpleado;
	}

	public void setDireccionEmpleado(Domicilio direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}		
	
	
}
