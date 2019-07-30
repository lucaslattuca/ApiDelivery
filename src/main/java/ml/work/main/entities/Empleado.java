package ml.work.main.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
//@Table(name = "apirest_empleado")
public  class Empleado extends Persona {

	@Id
	@Column(name = "empleado_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	@NotNull
	@Size(max=5,min=3)
	@Column(name = "empleado_codIngreso")
	private int codigoIngreso;
	@NotNull
	@Size(max=15,min=8)
	@Column(name = "empleado_cuil")
	private int cuil;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cargo")	
	@JsonBackReference
	private Cargos cargo = new Cargos();
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name= "id_domicilio")
//	@JsonBackReference
//	private Domicilio direccionEmpleado;

	public Empleado() {
		super();
	}

	public Empleado(String nombre, String nombreUsuario, Long dni, String password, Long telefono, String email, int cuil, 
			int codigoIngreso, Long idEmpleado, int cod_cargo, Cargos cargo, Date alta, Date baja) {
		super(nombre, nombreUsuario, dni, password, telefono, email, baja, alta);
		this.codigoIngreso = codigoIngreso;
		this.cuil = cuil;
		this.cargo = cargo;
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

	public void setId_empleado(Long idEmpleado) {
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

