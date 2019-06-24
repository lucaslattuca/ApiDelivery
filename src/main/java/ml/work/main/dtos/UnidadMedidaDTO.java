package ml.work.main.dtos;

import java.io.Serializable;

public class UnidadMedidaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_medida;	
	private String tipo_medida;
	
	public UnidadMedidaDTO(int id_medida, String tipo_medida) {
		this.id_medida = id_medida;
		this.tipo_medida = tipo_medida;
	}

	public UnidadMedidaDTO() {
	}

	public int getId_medida() {
		return id_medida;
	}

	public void setId_medida(int id_medida) {
		this.id_medida = id_medida;
	}

	public String getTipo_medida() {
		return tipo_medida;
	}

	public void setTipo_medida(String tipo_medida) {
		this.tipo_medida = tipo_medida;
	}
}
