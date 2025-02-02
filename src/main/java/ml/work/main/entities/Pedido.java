package ml.work.main.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "apirest_pedido")
public class Pedido extends Comprobantes{

	@Id
	@Column(name = "pedido_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numPedido;
 
	@Column(name= "pedido_con_envio")
	private boolean con_envio;
	
	@Column(name = "pedido_total")
	private float total;
	
	@Column(name = "pedido_observaciones")
	private String observaciones;
	
	@Column(name = "pedido_nombreTemporal")
	private String nombreTemporal;
	
	@Column(name = "pedido_estadoListo")
	private boolean estadoListo;
	
	@Column(name = "pedido_demora")
	private float demora;
	
	@ManyToOne
	@JoinColumn(name = "id_comprador")	
	private Usuario cliente;

	public Pedido() {
		super();		
	}

	public Pedido(Date fecha, 
			boolean con_envio,
			String observaciones, String nombreTemporal,
			int numPedido, float total, Usuario cliente, Date fechaAnulado, boolean estadoListo, float demora) {
		super(fecha, fechaAnulado);
		this.numPedido = numPedido;
		this.total = total;
		this.cliente = cliente;		
		this.observaciones = observaciones;
		this.nombreTemporal = nombreTemporal;
		this.estadoListo = estadoListo;
		this.demora = demora;
		this.con_envio = con_envio;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public boolean isCon_envio() {
		return con_envio;
	}

	public void setCon_envio(boolean con_envio) {
		this.con_envio = con_envio;
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

	public String getNombreTemporal() {
		return nombreTemporal;
	}

	public void setNombreTemporal(String nombreTemporal) {
		this.nombreTemporal = nombreTemporal;
	}

	public boolean isEstadoListo() {
		return estadoListo;
	}

	public void setEstadoListo(boolean estadoListo) {
		this.estadoListo = estadoListo;
	}

	public float getDemora() {
		return demora;
	}

	public void setDemora(float demora) {
		this.demora = demora;
	}				
}
