package ml.work.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apirest_unidad_medida")
public class UnidadMedida {
	
	@Id
	@Column(name = "tipo_medida_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_medida;
	
	@Column(name = "unidad_medida_tipo")
	private String tipo_medida;
		

	public UnidadMedida() {
	}

	public UnidadMedida(int id_medida, String tipo_medida) {
		this.id_medida = id_medida;
		this.tipo_medida = tipo_medida;
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
