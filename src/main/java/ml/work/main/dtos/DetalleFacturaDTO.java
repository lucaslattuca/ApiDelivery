package ml.work.main.dtos;


import java.io.Serializable;
import java.util.Date;

import ml.work.main.entities.Articulo;
import ml.work.main.entities.ArticuloManufacturado;
import ml.work.main.entities.Factura;
import ml.work.main.entities.Pedido;

public class DetalleFacturaDTO implements Serializable{

	private static final long serialVersionUID = -6374009544342054082L;
	
	private int idDetalle;
	private int cantidad;
	private float subtotal;
	//private Factura factura; 
	private Pedido pedido;
	private Articulo item;
	private ArticuloManufacturado manufacturado;
	//private Comanda comanda;
	private Date fechaAnulado;
	
	public DetalleFacturaDTO() {
		
	}
	
	
	public DetalleFacturaDTO(int idDetalle, int cantidad, float subtotal, Factura factura, Pedido pedido, Articulo item,
			ArticuloManufacturado manufacturado, 
//			Comanda comanda, 
			Date fechaAnulado) {
		this.idDetalle = idDetalle;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
//		this.factura = factura;
		this.pedido = pedido;
		this.item = item;
		this.manufacturado = manufacturado;
//		this.comanda = comanda;
		this.fechaAnulado = fechaAnulado;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

/*	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
*/
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Articulo getItem() {
		return item;
	}

	public void setItem(Articulo item) {
		this.item = item;
	}

	public ArticuloManufacturado getManufacturado() {
		return manufacturado;
	}

	public void setManufacturado(ArticuloManufacturado manufacturado) {
		this.manufacturado = manufacturado;
	}


//	public Comanda getComanda() {
//		return comanda;
//	}
//
//
//	public void setComanda(Comanda comanda) {
//		this.comanda = comanda;
//	}


	public Date getFechaAnulado() {
		return fechaAnulado;
	}


	public void setFechaAnulado(Date fechaAnulado) {
		this.fechaAnulado = fechaAnulado;
	}			
}
