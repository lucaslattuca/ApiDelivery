package ml.work.main.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "apirest_art_manufacturado")
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class ArticuloManufacturado {
	
	@Id
	@Column(name = "articuloManuf_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_artManuf;
	
	@NotBlank
	@Column(name = "articuloManuf_nombre", unique = true)
	private String nombreManufacturado;
	
	@Column(name = "articuloManuf_minutos")
	private int minutosPrep;
	
	@Column(name = "manuf_foto")
	private String foto;
	
	@Column(name = "articuloManuf_detalle")
	private String detalle;	
	
	@Column(name = "articuloManuf_enMenu")
	private boolean enMenu;
	
	@NotNull
	@Column(name = "articuloManuf_precio")
	private float precioM;
	
	
	/*@OneToMany(mappedBy = "articuloManuf", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<DetalleReceta> detalleRecetas;*/
		
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")	
	private CategoriaProducto categoriaManuf;
	
	
	
	public ArticuloManufacturado() {
	}

	public ArticuloManufacturado(int id_artManuf, String nombreManufacturado, int minutosPrep,
			Set<DetalleReceta> detalleRecetas, 
//			Set<Precios> precioDePlato,
			boolean enMenu, CategoriaProducto categoriaManuf, String foto, String detalle, float precio)  {
		this.id_artManuf = id_artManuf;
		this.nombreManufacturado = nombreManufacturado;
		this.minutosPrep = minutosPrep;
		//this.detalleRecetas = detalleRecetas;
//		this.dFactura = dFactura;
		this.enMenu = enMenu;
		this.categoriaManuf = categoriaManuf;
		this.foto = foto;
		this.detalle = detalle;		
		this.precioM = precio;
//		this.precioDePlato = precioDePlato;
	}

	public int getId_artManuf() {
		return id_artManuf;
	}

	public void setId_artManuf(int id_artManuf) {
		this.id_artManuf = id_artManuf;
	}

	public String getNombre_articuloM() {
		return nombreManufacturado;
	}

	public void setNombre_articuloM(String nombreManufacturado) {
		this.nombreManufacturado = nombreManufacturado;
	}

	public int getMinutosPrep() {
		return minutosPrep;
	}

	public void setMinutosPrep(int minutosPrep) {
		this.minutosPrep = minutosPrep;
	}
	
//	public List<DetalleFactura> getdFactura() {
//		return dFactura;
//	}
//
//	public void setdFactura(List<DetalleFactura> dFactura) {
//		this.dFactura = dFactura;
//	}

	public boolean isEnMenu() {
		return enMenu;
	}

	public void setEnMenu(boolean enMenu) {
		this.enMenu = enMenu;
	}

	public CategoriaProducto getCategoriaManuf() {
		return categoriaManuf;
	}

	public void setCategoriaManuf(CategoriaProducto categoriaManuf) {
		this.categoriaManuf = categoriaManuf;
	}	

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/*public Set<DetalleReceta> getDetalleRecetas() {
		return detalleRecetas;
	}

	public void setDetalleRecetas(Set<DetalleReceta> detalleRecetas) {
		this.detalleRecetas = detalleRecetas;
	}*/

	public float getPrecioM() {
		return precioM;
	}

	public void setPrecioM(float precioM) {
		this.precioM = precioM;
	}

	
		

//	public Set<Precios> getPrecioDePlato() {
//		return precioDePlato;
//	}
//
//	public void setPrecioDePlato(Set<Precios> precioDePlato) {
//		this.precioDePlato = precioDePlato;
//	}	
	
	
}
