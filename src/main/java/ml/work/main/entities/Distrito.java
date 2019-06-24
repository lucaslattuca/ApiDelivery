package ml.work.main.entities;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="apirest_distrito")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Distrito {
	@Id
	@Column(name="distrito_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Distrito;
	
	@Column(name="nombreDistrito")
	private String nombreDistrito;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_Localidad")
	@JsonBackReference
	private Localidad localidad= new Localidad();
	
	@OneToMany(mappedBy = "distrito", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Domicilio> domicilios;
	
	public Distrito() {
		
	}

	public Distrito(int id_Distrito, String nombreDistrito, Localidad localidad, Set<Domicilio> domicilios) {
		this.id_Distrito = id_Distrito;
		this.nombreDistrito = nombreDistrito;
		this.localidad = localidad;
		this.domicilios = domicilios;
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

	public Set<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(Set<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}	
	
}
