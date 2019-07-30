package ml.work.main.dtos;

import java.util.Date;

import ml.work.main.entities.Domicilio;


public abstract class PersonaDTO {
	
	protected String nombre;
	
	protected String nombreUsuario;
	
	protected Long dni;
	
	protected String password;
	
	protected Long telefono;
	
	protected String email;
	
	protected Date alta;
	
	protected Date baja;
	
	protected Domicilio direccion;

	public PersonaDTO() {

	}

	public PersonaDTO(String nombre, String nombreUsuario, Long dni, String password, Long telefono, String email, Date alta, Date baja) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.dni = dni;
		this.password = password;
		this.telefono = telefono;
		this.email = email;
		//this.direccion = direccion;
		this.alta = alta;
		this.baja = baja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombreUsuario() {
		return nombre;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	public Date getAlta() {
		return alta;
	}

	public void setAlta(java.util.Date date) {
		this.alta = date;
	}

	public Date getBaja() {
		return baja;
	}

	public void setBaja(Date baja) {
		this.baja = baja;
	}

}
