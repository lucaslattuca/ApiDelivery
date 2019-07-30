package ml.work.main.dtos;

import java.io.Serializable;
import java.util.Date;

import ml.work.main.entities.Cargos;
import ml.work.main.entities.Domicilio;

public class EmpleadoDTO extends PersonaDTO implements Serializable{

	//private static final long serialVersionUID = -7120294417356785715L;

	private Long idEmpleado;

	private int codigoIngreso;
	
	private int cuil;
	
	private Cargos cargo;

	public EmpleadoDTO() {
		super();
	}

	public EmpleadoDTO(String nombre, String nombreUsuario, Long dni, String password, Long telefono, String email,
			int codigoIngreso, int cuil, Domicilio direccion, Long idEmpleado, 
			Date alta, Date baja) {
		super(nombre, nombreUsuario, dni, password, telefono, email, alta, baja);
		this.codigoIngreso = codigoIngreso;
		this.cuil = cuil;
		this.idEmpleado = idEmpleado;
	}

	
	public int getCodigoIngreso() {
		return codigoIngreso;
	}

	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}

	public int getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
		this.cuil = cuil;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}	
	
	/*public RolNombre getRolNombre() {
		return RolNombre.ROLE_EMPLEADO;
	}
	
	public void setRoles(RolNombre rol) {
		this.setRoles(RolNombre.ROLE_EMPLEADO);
	}*/
	
}
