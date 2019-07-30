package ml.work.main.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "apirest_cliente")
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Cliente extends Persona {
	@Id
	@Column(name="id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	//@EmbeddedId
	//private GenerarId generarId;
	
//	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<Factura> facturas;
	
//	@ManyToOne
//	@JoinColumn(name= "id_domicilio")
//	private Domicilio direccion;
	//@JsonBackReference
	
	
	public Cliente() {
		super();
	}	
	
	public Cliente(String nombre, Long dni, String password, Long telefono, String email, 
			//Domicilio direccion, 
			String nombreUsuario, 
			//List<Factura> facturas, 
			Date alta, Date baja) {
		super(nombre, nombreUsuario, dni, password, telefono, email, baja, alta);
		//this.generarId = generarId;
		//this.facturas = facturas;
		//this.direccion = direccion;
	}
	

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

//	public List<Factura> getFacturas() {
//		return facturas;
//	}
//
//	public void setFacturas(List<Factura> facturas) {
//		this.facturas = facturas;
//	}

	@Override
	public String getNombrePersona() {
		// TODO Auto-generated method stub
		return super.getNombrePersona();
	}

	@Override
	public void setNombre(String nombreCliente) {
		// TODO Auto-generated method stub
		super.setNombre(nombreCliente);
	}

	@Override
	public Long getDni() {
		// TODO Auto-generated method stub
		return super.getDni();
	}

	@Override
	public void setDni(Long dni) {
		// TODO Auto-generated method stub
		super.setDni(dni);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public Long getTelefono() {
		// TODO Auto-generated method stub
		return super.getTelefono();
	}

	@Override
	public void setTelefono(Long telefono) {
		// TODO Auto-generated method stub
		super.setTelefono(telefono);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public Domicilio getDireccion() {
		return direccion;
	}

	@Override
	public void setDireccion(Domicilio direccion) {
		this.direccion = direccion;
	}	
}
