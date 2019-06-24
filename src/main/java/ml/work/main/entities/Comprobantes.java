package ml.work.main.entities;


import java.util.Date; 
import java.time.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Comprobantes{

	@Column(name ="comprobante_fecha")
	protected Date fecha;
	
	@Column(name="comprobante_hora")
	protected LocalTime hora;	
		
	@Column(name = "comprobante_fechaAnulado")
	protected Date fechaAnulado;
	
	

	public Comprobantes() {}


	public Comprobantes(Date fecha, LocalTime hora, Date fechaAnulado) {
		
		this.fecha = fecha;
		this.hora = hora;
		this.fechaAnulado = fechaAnulado;
	}

	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}	

	public Date getFechaAnulado() {
		return fechaAnulado;
	}

	public void setFechaAnulado(Date fechaAnulado) {
		this.fechaAnulado = fechaAnulado;
	}

}
