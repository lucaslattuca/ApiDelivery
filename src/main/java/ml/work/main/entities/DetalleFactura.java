package ml.work.main.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="apirest_detalles_factura")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class DetalleFactura {
	
	@Id
	@Column(name="detalleF_id")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	@Column(name="detalleFacCantidad")
	private int cantidad;
	
	@Column(name="detalleFacSubtotal")
	private float subtotal;
	
	@Column(name="detalleAnulado")
	private Date fechaAnulado;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "numPedido")	
	private Pedido pedido;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_articulo")
	private Articulo item;
	
	@ManyToOne
	@JoinColumn(name = "id_artManuf")
	private ArticuloManufacturado manufacturado;
	
	
	
	
	
	public DetalleFactura() {
		
	}	
	
	

	public DetalleFactura(int idDetalle, int cantidad, float subtotal, Pedido pedido, 
//			Comanda comanda, Factura factura, 
			Articulo item, ArticuloManufacturado manufacturado, Date fechaAnulado) {
		this.idDetalle = idDetalle;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
//		this.factura = factura;
		this.pedido = pedido;
//		this.comanda = comanda;
		this.item = item;
		this.manufacturado = manufacturado;
		this.fechaAnulado = fechaAnulado;
	}



	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
