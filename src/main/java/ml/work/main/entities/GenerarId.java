package ml.work.main.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class GenerarId implements Serializable{

	@NotNull
	public Long numero_id;
	@NotNull
	@Size(max=1)
	public String tipo_id;
	
	public GenerarId() {
		
	}
	
	public GenerarId(Long numero_id, String tipo_id) {
		this.numero_id = numero_id;
		this.tipo_id = tipo_id;
	}
	
	public Long getNumeroId() {
		return numero_id;
	}
	public void setNumeroId(Long numero_id) {
		this.numero_id = numero_id;
	}
	
	public String getTipoId() {
		return tipo_id;
	}
	public void setTipoId(String tipo_id) {
		this.tipo_id = tipo_id;
	}
	
	//equals() and hashcode()
	@Override
	public boolean equals(Object o) {
		if(this==o)return true;
		if (o==null || getClass()!= o.getClass()) return false;
		
		GenerarId that = (GenerarId) o;
		
		if(!numero_id.equals(that.numero_id)) return false;
		return tipo_id.equals(that.tipo_id);
	}
	
	 @Override
	 public int hashCode() {
		 int result = numero_id.hashCode();
		 result += tipo_id.hashCode();
		 return result;
	 }
}
