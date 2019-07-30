package ml.work.main.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//@Entity
//@Table(name = "elbuensabor_persona")
@MappedSuperclass
public abstract class Persona {
	
	@NotNull
	@Column(name = "persona_nombre")
	protected String nombre_persona;
	
	@NotNull
	@Column(name = "persona_nombreUsuario")
	protected String nombre_usuario;
	
	@NotNull
	@Size(max=8)
	@Column(name = "persona_dni")
	protected Long dni;
	
	@NotNull
	@Size(min=6)
	@Column(name = "persona_password")
	protected String password;
	
	@NotNull
	@Size(max=20)
	@Column(name = "persona_telefono")
	protected Long telefono;
	
	@NotNull
	@Size(max=60)
	@Column(name = "persona_email")
	protected String email;
	
	@Column(name = "persona_baja")
	protected Date baja;
	
	@Column(name = "persona_alta")
	protected Date alta;
	
	@ManyToOne
	@JoinColumn(name= "id_domicilio")
	protected Domicilio direccion;

	public Persona() {

	}

	public Persona(String nombre, String nombreUsuario, Long dni, String password, Long telefono, String email, Date baja, Date alta) {
		this.nombre_persona = nombre;
		this.nombre_usuario = nombreUsuario;
		this.dni = dni;
		this.password = password;
		this.telefono = telefono;
		this.email = email;
		//this.direccion = direccion;
		this.alta = alta;
		this.baja = baja;
	}

	public String getNombrePersona() {
		return nombre_persona;
	}

	public void setNombre(String nombre) {
		this.nombre_persona = nombre;
	}
	
	public String getNombre_Usuario() {
		return nombre_usuario;
	}

	public void setNombre_Usuario(String nombreUsuario) {
		this.nombre_usuario = nombreUsuario;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Domicilio getDireccion() {
		return direccion;
	}

	public void setDireccion(Domicilio direccion) {
		this.direccion = direccion;
	}

	public Date getBaja() {
		return baja;
	}

	public void setBaja(Date baja) {
		this.baja = baja;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}
	
}
