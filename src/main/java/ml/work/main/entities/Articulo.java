package ml.work.main.entities;

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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "apirest_articulos")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Articulo {
	
	@Id
	@Column(name = "articulo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_articulo;
	
	@NotBlank
	@Column(name = "articulo_nombre",unique = true)
	private String nombreArticulo;
	
	
	@Column(name = "articulo_costo")
	private float costo;
	
	@Column(name = "articulo_esPrima")
	private boolean esPrima;
	
	@Column(name = "articulo_stock")
	private double stock;	
	
	
	@Column(name = "stockMinimo")
	private double stockMinimo;
	
	@Column(name = "enLista")
	private boolean enLista;
	
	@Column(name = "articulo_foto")
	private String foto;
	
	@Column(name = "articulo_detalle")
	private String detalle;
	
	@NotNull
	@Column(name = "articulo_precio")
	private float precioA;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")	
	private CategoriaProducto categoriaProd;
	
	@ManyToOne
	@JoinColumn(name = "id_medida")	
	private UnidadMedida medidaProd;
	

	public Articulo() {
	}
		
	public Articulo(int id_articulo, String nombre_articulo, float costo, boolean esPrima, 
			double stock, CategoriaProducto categoriaProd, UnidadMedida medidaProd, 
//			List<DetalleFactura> detFactura, List<DetalleReceta> detReceta, Set<Precios> precioArticulo
			double stockMinimo, boolean enLista, String foto, String detalle, float precio) {
		this.id_articulo = id_articulo;
		this.nombreArticulo = nombre_articulo;
		this.costo = costo;
		this.esPrima = esPrima;
		this.stock = stock;
		this.categoriaProd = categoriaProd;
		this.medidaProd = medidaProd;
//		this.detFactura = detFactura;
//		this.detReceta = detReceta;
		this.stockMinimo = stockMinimo;
		this.enLista = enLista;
		this.foto = foto;
		this.detalle = detalle;
		this.precioA = precio;
//		this.precioArticulo = precioArticulo;
	}

	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getNombre_articulo() {
		return nombreArticulo;
	}

	public void setNombre_articulo(String nombre_articulo) {
		this.nombreArticulo = nombre_articulo;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}	

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public CategoriaProducto getCategoriaProd() {
		return categoriaProd;
	}

	public void setCategoriaProd(CategoriaProducto categoriaProd) {
		this.categoriaProd = categoriaProd;
	}

	public UnidadMedida getMedidaProd() {
		return medidaProd;
	}

	public void setMedidaProd(UnidadMedida medidaProd) {
		this.medidaProd = medidaProd;
	}

//	public List<DetalleReceta> getDetReceta() {
//		return detReceta;
//	}
//
//	public void setDetReceta(List<DetalleReceta> detReceta) {
//		this.detReceta = detReceta;
//	}
//
//	public List<DetalleFactura> getDetFactura() {
//		return detFactura;
//	}
//
//	public void setDetFactura(List<DetalleFactura> detFactura) {
//		this.detFactura = detFactura;
//	}

	public double getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(double stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public boolean isEnLista() {
		return enLista;
	}

	public void setEnLista(boolean enLista) {
		this.enLista = enLista;
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

	public boolean isEsPrima() {
		return esPrima;
	}

	public void setEsPrima(boolean esPrima) {
		this.esPrima = esPrima;
	}

	public float getPrecioA() {
		return precioA;
	}

	public void setPrecioA(float precioA) {
		this.precioA = precioA;
	}

	

//	public Set<Precios> getPrecioArticulo() {
//		return precioArticulo;
//	}
//
//	public void setPrecioArticulo(Set<Precios> precioArticulo) {
//		this.precioArticulo = precioArticulo;
//	}	
	
}
