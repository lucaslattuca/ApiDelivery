package ml.work.main.entities;

import java.util.Date; 

import java.time.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "apirest_factura")
public class Factura extends Comprobantes {	

	@Id
	@Column(name = "factura_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numFactura;

	@Column(name = "factura_esEfectivo")
	private boolean esEfectivo;

	@Column(name = "factura_total")
	private float total;		
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="numPedido")	
	private Pedido pedidoConfirmado;
	
	
		
	public Factura() {
		super();
	}

	public Factura(Date fecha, LocalTime hora,int numFactura, boolean esEfectivo,
			Pedido pedidoConfirmado, float total, Date fechaAnulado) {
		super(fecha, hora, fechaAnulado);
		this.numFactura = numFactura;
		this.esEfectivo = esEfectivo;		
		this.total = total;
		this.pedidoConfirmado = pedidoConfirmado;
	}

	public int getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}

	public boolean isEsEfectivo() {
		return esEfectivo;
	}

	public void setEsEfectivo(boolean esEfectivo) {
		this.esEfectivo = esEfectivo;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}	

	public Pedido getPedidoConfirmado() {
		return pedidoConfirmado;
	}

	public void setPedidoConfirmado(Pedido pedidoConfirmado) {
		this.pedidoConfirmado = pedidoConfirmado;
	}
	
}
