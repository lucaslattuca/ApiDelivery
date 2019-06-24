package ml.work.main.dtos;

import java.io.Serializable;

public class LocalidadDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id_Localidad;

	private String nombre_localidad;
	
	//private List<Distrito> distritos = new ArrayList<Distrito>();
	

	public LocalidadDTO() {

	}

	public LocalidadDTO(int id_localidad, String nombre_localidad) {
		this.id_Localidad = id_localidad;
		this.nombre_localidad = nombre_localidad;
		//this.distritos = distritos;
	}

	public int getId_Localidad() {
		return id_Localidad;
	}

	public void setId_Localidad(int id_Localidad) {
		this.id_Localidad = id_Localidad;
	}

	public String getNombre_localidad() {
		return nombre_localidad;
	}

	public void setNombre_localidad(String nombre_localidad) {
		this.nombre_localidad = nombre_localidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	public List<Distrito> getDistritos() {
//		return distritos;
//	}
//
//	public void setDistritos(List<Distrito> distritos) {
//		this.distritos = distritos;
//	}

}
