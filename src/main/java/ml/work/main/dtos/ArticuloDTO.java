package ml.work.main.dtos;


import java.io.Serializable;

import ml.work.main.entities.CategoriaProducto;
import ml.work.main.entities.UnidadMedida;

public class ArticuloDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id_articulo;
	
	private String nombre_articulo;
	
	private float costo;
	
	private boolean esPrima;
	
	private double stock;
	
	private CategoriaProducto categoriaProd;
	
	private UnidadMedida medidaProd;
	
	private double stockMinimo;
	
	private boolean enLista;
	
	private String foto;
	
	private String detalle;	
	
	private float precioA;

	
	
	public ArticuloDTO() {
	}	

	public ArticuloDTO(int id_articulo, String nombre_articulo, float costo, boolean esPrima, double stock,
			CategoriaProducto categoriaProd, UnidadMedida medidaProd, 
//			List<DetalleFactura> detFactura, List<DetalleReceta> detReceta,  Set<Precios> precioArticulo,
			double stockMinimo, boolean enLista, String foto, String detalle, float precio) {
		this.id_articulo = id_articulo;
		this.nombre_articulo = nombre_articulo;
		this.costo = costo;
		this.esPrima = esPrima;
		this.stock = stock;
		this.categoriaProd = categoriaProd;
		this.medidaProd = medidaProd;		
		this.stockMinimo = stockMinimo;
		this.enLista = enLista;
		this.foto = foto;
		this.detalle = detalle;
		this.precioA = precio;
		//this.detFactura = detFactura;
		//this.detReceta = detReceta;
		//this.precioArticulo = precioArticulo;
	}

	
	public int getId_articulo() {
		return id_articulo;
	}
	
	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getNombre_articulo() {
		return nombre_articulo;
	}

	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
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
	
}
