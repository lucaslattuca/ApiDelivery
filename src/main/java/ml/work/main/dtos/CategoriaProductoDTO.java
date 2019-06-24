package ml.work.main.dtos;

import java.io.Serializable;

public class CategoriaProductoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_categoria;
	private String nombre_categoria;
	private boolean esPlato;
	
	
	public CategoriaProductoDTO() {
		
	}

	public CategoriaProductoDTO(int id_categoria, String nombre_categoria, boolean esPlato) {
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
		this.esPlato = esPlato;
	}
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	public boolean isEsPlato() {
		return esPlato;
	}
	public void setEsPlato(boolean esPlato) {
		this.esPlato = esPlato;
	}	
}
