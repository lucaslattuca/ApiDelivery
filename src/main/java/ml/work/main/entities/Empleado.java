package ml.work.main.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "apirest_empleado")
public  class Empleado extends Persona {

	//@Id
	//@Column(name = "empleado_id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int id_empleado;
	@EmbeddedId
	private GenerarId generarId;
	
	@Column(name = "empleado_codIngreso")
	private int codigo_ingreso;
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

	public Empleado(GenerarId generarId, String nombre_persona, int dni, String password, int telefono, String email, int cuil, 
			//Domicilio direccionEmpleado, 
			int codigo_ingreso, 
			int id_empleado, int cod_cargo, Cargos cargo, Date alta, Date baja) {
		super(nombre_persona, dni, password, telefono, email, baja, alta);
		this.generarId = generarId;
		this.codigo_ingreso = codigo_ingreso;
		this.cuil = cuil;
		//this.direccionEmpleado = direccionEmpleado;
		//this.id_empleado = id_empleado;
		//this.cod_cargo = cod_cargo;
		this.cargo = cargo;
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

	/*public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}*/

//	public int getCod_cargo() {
//		return cod_cargo;
//	}
//
//	public void setCod_cargo(int cod_cargo) {
//		this.cod_cargo = cod_cargo;
//	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}

	
	
	
}

