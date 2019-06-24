package ml.work.main.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import net.bytebuddy.asm.Advice.This;

@Entity
@Table(name = "apirest_cliente")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Cliente extends Persona {
	//@Id
	//@Column(name="id_usuario")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int id_usuario;
	@EmbeddedId
	private GenerarId generarId;
	
	@Column(name="nombre_usuario", unique = true)
	private String nombre_usuario;
	
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
	
	public Cliente(GenerarId  generarId,String nombre_persona, int dni, String password, int telefono, String email, 
			//Domicilio direccion, 
			String nombre_usuario, 
			//List<Factura> facturas, 
			Date alta, Date baja) {
		super(nombre_persona, dni, password, telefono, email, alta, baja);
		this.nombre_usuario = nombre_usuario;
		this.generarId = generarId;
		//this.facturas = facturas;
		//this.direccion = direccion;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	/*public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}*/

//	public List<Factura> getFacturas() {
//		return facturas;
//	}
//
//	public void setFacturas(List<Factura> facturas) {
//		this.facturas = facturas;
//	}

	@Override
	public String getNombre_persona() {
		// TODO Auto-generated method stub
		return super.getNombre_persona();
	}

	@Override
	public void setNombre_persona(String nombre_persona) {
		// TODO Auto-generated method stub
		super.setNombre_persona(nombre_persona);
	}

	@Override
	public int getDni() {
		// TODO Auto-generated method stub
		return super.getDni();
	}

	@Override
	public void setDni(int dni) {
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
	public int getTelefono() {
		// TODO Auto-generated method stub
		return super.getTelefono();
	}

	@Override
	public void setTelefono(int telefono) {
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
