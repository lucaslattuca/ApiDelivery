package ml.work.main.dtos;

import java.io.Serializable;

import ml.work.main.entities.Localidad;

public class DistritoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id_Distrito;
	
	private String nombreDistrito;
	
	private Localidad localidad;
	
	//private List<Domicilio> domicilios = new ArrayList<Domicilio>();
	
	public DistritoDTO() {
		
	}

	public DistritoDTO(int id_Distrito, String nombreDistrito, Localidad localidad) {
		this.id_Distrito = id_Distrito;
		this.nombreDistrito = nombreDistrito;
		this.localidad = localidad;
		//this.domicilios = domicilios;
	}

	public int getId_Distrito() {
		return id_Distrito;
	}

	public void setId_Distrito(int id_Distrito) {
		this.id_Distrito = id_Distrito;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

//	public List<Domicilio> getDomicilios() {
//		return domicilios;
//	}
//
//	public void setDomicilios(List<Domicilio> domicilios) {
//		this.domicilios = domicilios;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
