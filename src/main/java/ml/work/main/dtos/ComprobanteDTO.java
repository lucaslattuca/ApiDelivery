package ml.work.main.dtos;

import java.util.Date;
import java.time.*;

public abstract class ComprobanteDTO {
		
	protected Date fecha;
		
	protected Date fechaAnulado;
	
	public ComprobanteDTO() {}

	public ComprobanteDTO(Date fecha, Date fechaAnulado) {		
		this.fecha = fecha;
		this.fechaAnulado = fechaAnulado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaAnulado() {
		return fechaAnulado;
	}

	public void setFechaAnulado(Date fechaAnulado) {
		this.fechaAnulado = fechaAnulado;
	}	
}
