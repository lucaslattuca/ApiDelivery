package ml.work.main.dtos;

import java.io.Serializable; 
import java.util.Date;
import java.time.*;

import ml.work.main.entities.Cliente;
import ml.work.main.entities.Pedido;



public class FacturaDTO extends ComprobanteDTO implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private int numFactura;
	private boolean esEfectivo;			
	private float total;
	private Pedido pedidoConfirmado;
	

	public FacturaDTO() {
		super();
	}

	public FacturaDTO(Date fecha, LocalTime hora, int numFactura, 
			boolean esEfectivo, float total, Date fechaAnulado, Pedido pedidoConfirmado) {
		super(fecha, hora, fechaAnulado);
		this.numFactura = numFactura;
		this.esEfectivo = esEfectivo;
		this.total = total;		
		this.pedidoConfirmado = pedidoConfirmado;
	}	

	public boolean isEsEfectivo() {
		return esEfectivo;
	}

	public void setEsEfectivo(boolean esEfectivo) {
		this.esEfectivo = esEfectivo;
	}

	public int getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
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
