package ml.work.main.dtos;

import java.util.Date;
import java.time.*;

public abstract class ComprobanteDTO {
		
	protected Date fecha;
		
	protected LocalTime hora;
		
	protected Date fechaAnulado;
	
	public ComprobanteDTO() {}

	public ComprobanteDTO(Date fecha, LocalTime hora, Date fechaAnulado) {		
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
