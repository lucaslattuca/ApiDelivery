package ml.work.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apirest_categoria_producto")
public class CategoriaProducto {
	
	@Id
	@Column(name = "categoria_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_categoria;
	
	@Column(name = "categoria_nombre")
	private String nombre_categoria;
	
	@Column(name = "categoria_esPlato")
	private boolean esPlato;
		
	public CategoriaProducto() {
		
	}

	public CategoriaProducto(int id_categoria, String nombre_categoria, boolean esPlato
//			, List<ArticuloManufacturado> RubroManuf, List<Articulo> RubroArticulos
			) {
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
		this.esPlato = esPlato;
//		this.rubroArticulos = RubroArticulos;
//		this.rubroManuf = RubroManuf;
	}
	

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public boolean isEsPlato() {
		return esPlato;
	}

	public void setEsPlato(boolean esPlato) {
		this.esPlato = esPlato;
	}

//	public List<Articulo> getRubroArticulos() {
//		return rubroArticulos;
//	}
//
//	public void setRubroArticulos(List<Articulo> rubroArticulos) {
//		this.rubroArticulos = rubroArticulos;
//	}
//
//	public List<ArticuloManufacturado> getRubroManuf() {
//		return rubroManuf;
//	}
//
//	public void setRubroManuf(List<ArticuloManufacturado> rubroManuf) {
//		this.rubroManuf = rubroManuf;
//	}	
}
