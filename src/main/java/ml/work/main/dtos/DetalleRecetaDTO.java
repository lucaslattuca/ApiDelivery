package ml.work.main.dtos;

import java.io.Serializable;
import java.sql.Date;

import ml.work.main.entities.Articulo;
import ml.work.main.entities.ArticuloManufacturado;

public class DetalleRecetaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id_receta;
	
	private float cantidad;
	
	private Articulo articulo;	
	
	private ArticuloManufacturado articuloManuf;
	
	private Date fechaAnulado;
	

	public DetalleRecetaDTO() {
	}

	public DetalleRecetaDTO(int id_receta, float cantidad, Articulo articulo, ArticuloManufacturado articuloManuf, Date fechaAnulado) {
		this.id_receta = id_receta;
		this.cantidad = cantidad;
		this.articulo = articulo;
		this.articuloManuf = articuloManuf;
		this.fechaAnulado = fechaAnulado;
	}

	public int getId_receta() {
		return id_receta;
	}

	public void setId_receta(int id_receta) {
		this.id_receta = id_receta;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public ArticuloManufacturado getArticuloManuf() {
		return articuloManuf;
	}

	public void setArticuloManuf(ArticuloManufacturado articuloManuf) {
		this.articuloManuf = articuloManuf;
	}

	public Date getFechaAnulado() {
		return fechaAnulado;
	}

	public void setFechaAnulado(Date fechaAnulado) {
		this.fechaAnulado = fechaAnulado;
	}		
}
