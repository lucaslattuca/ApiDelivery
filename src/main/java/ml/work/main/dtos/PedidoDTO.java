package ml.work.main.dtos;

import java.io.Serializable;
import java.util.Date;

import ml.work.main.entities.Usuario;


public class PedidoDTO extends ComprobanteDTO implements Serializable{

	//private static final long serialVersionUID = -3899598285715927457L;
	
	private boolean con_envio;
	private int numPedido;
	private float total;
	private String observaciones;
	private boolean estadoListo;
	private String nombreTemporal;
	private Usuario cliente;
	private String informe;
	private float demora;
	
	public PedidoDTO() {
		super();
	}
	
	public PedidoDTO(Date fecha, boolean con_envio, Usuario cliente, int numPedido, String nombreTemporal, 
			boolean estadoListo, float total, Date fechaAnulado, String observaciones, String informe, float demora) {
		super(fecha, fechaAnulado);
		this.numPedido = numPedido;
		this.total = total;
		this.con_envio = con_envio;
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

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
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

	public boolean isCon_envio() {
		return con_envio;
	}

	public void setCon_envio(boolean con_envio) {
		this.con_envio = con_envio;
	}		
	
}
