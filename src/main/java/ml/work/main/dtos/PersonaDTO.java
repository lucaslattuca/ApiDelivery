package ml.work.main.dtos;

import java.util.Date;

import ml.work.main.entities.Domicilio;


public abstract class PersonaDTO {
	protected String nombre_persona;
	
	protected int dni;
	
	protected String password;
	
	protected int telefono;
	
	protected String email;
	
	protected Date alta;
	
	protected Date baja;
	
	protected Domicilio direccion;

	public PersonaDTO() {

	}

	public PersonaDTO(String nombre_persona, int dni, String password, int telefono, String email, Date alta, Date baja) {
		this.nombre_persona = nombre_persona;
		this.dni = dni;
		this.password = password;
		this.telefono = telefono;
		this.email = email;
		//this.direccion = direccion;
		this.alta = alta;
		this.baja = baja;
	}

	public String getNombre_persona() {
		return nombre_persona;
	}

	public void setNombre_persona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
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
