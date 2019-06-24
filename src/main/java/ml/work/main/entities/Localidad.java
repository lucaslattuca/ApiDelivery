package ml.work.main.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="apirest_localidad")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Localidad {

	@Id
	@Column(name = "localidad_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Localidad;
	
	@Column(name = "localidad_nombre")
	private String nombre_localidad;

	@OneToMany(mappedBy = "localidad", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Distrito> distritos;
		
	public Localidad() {

	}

	public Localidad(int id_localidad, String nombre_localidad, Set<Distrito> distritos) {
		this.id_Localidad = id_localidad;
		this.distritos = distritos;
		this.nombre_localidad = nombre_localidad;
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

	public Set<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(Set<Distrito> distritos) {
		this.distritos = distritos;
	}

	
}
