package ml.work.main.dtos;

import java.io.Serializable;
import java.util.Date;

import ml.work.main.entities.Cliente;

import java.time.*;

public class PedidoDTO extends ComprobanteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int numPedido;
	private float total;
	private String observaciones;
	private boolean estadoListo;
	private String nombreTemporal;
	private Cliente cliente;
	private String informe;
	private float demora;
	
	public PedidoDTO() {
		super();
	}
	
	public PedidoDTO(Date fecha, LocalTime hora, Cliente cliente, int numPedido, String nombreTemporal, 
			boolean estadoListo, float total, Date fechaAnulado, String observaciones, String informe, float demora) {
		super(fecha, hora, fechaAnulado);
		this.numPedido = numPedido;
		this.total = total;
		this.observaciones = observaciones;
		this.cliente = cliente;
		this.nombreTemporal = nombreTemporal;
		this.estadoListo = estadoListo;
		this.informe = informe;
		this.demora = demora;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isEstadoListo() {
		return estadoListo;
	}

	public void setEstadoListo(boolean estadoListo) {
		this.estadoListo = estadoListo;
	}

	public String getNombreTemporal() {
		return nombreTemporal;
	}

	public void setNombreTemporal(String nombreTemporal) {
		this.nombreTemporal = nombreTemporal;
	}

	public String getInforme() {
		return informe;
	}

	public void setInforme(String informe) {
		this.informe = informe;
	}

	public float getDemora() {
		return demora;
	}

	public void setDemora(float demora) {
		this.demora = demora;
	}		
}
