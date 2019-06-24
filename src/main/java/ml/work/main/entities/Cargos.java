package ml.work.main.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "apirest_cargos")
public class Cargos {
	
	@Id
	@Column(name = "cargo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cargo;
	@Column(name = "cargo_puesto")
	private String puesto;
	@OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
	private List<Empleado> empleados;
		
	
	public Cargos() {
	}

	public Cargos(int id_cargo, String puesto, List<Empleado> empleados) {
		this.id_cargo = id_cargo;
		this.puesto = puesto;
		this.empleados = empleados;
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
