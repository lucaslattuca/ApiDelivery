package ml.work.main.dtos;

import java.io.Serializable;

import ml.work.main.entities.CategoriaProducto;

public class ArticuloManufacturadoDTO implements Serializable{

	//private static final long serialVersionUID = 7402958955532521118L;

	private int id_artManuf;
	
	private String nombreManufacturado;
	
	private int minutosPrep;
	
	private boolean enMenu;
	
	private CategoriaProducto categoriaManuf;
	
	private String foto;
	
	private String detalle;	
	
	private float precioM;
	
	

	public ArticuloManufacturadoDTO() {
	}

	
	public ArticuloManufacturadoDTO(int id_artManuf, String nombreManufacturado, int minutosPrep, 
//			List<Precios> precioDePlato, List<DetalleReceta> detalleRecetas, List<DetalleFactura> dFactura, 
			boolean enMenu, CategoriaProducto categoriaManuf, String foto, String detalle, float precio) {
		this.id_artManuf = id_artManuf;
		this.nombreManufacturado = nombreManufacturado;
		this.minutosPrep = minutosPrep;
		this.enMenu = enMenu;
		this.categoriaManuf = categoriaManuf;
		this.foto = foto;
		this.detalle = detalle;
		this.precioM = precio;
//		this.precioDePlato = precioDePlato;
//		this.detalleRecetas = detalleRecetas;
//		this.dFactura = dFactura;		
	}


	public int getId_artManuf() {
		return id_artManuf;
	}

	public void setId_artManuf(int id_artManuf) {
		this.id_artManuf = id_artManuf;
	}

	public String getNombre_articuloM() {
		return nombreManufacturado;
	}

	public void setNombre_articuloM(String nombreManufacturado) {
		this.nombreManufacturado = nombreManufacturado;
	}

	public int getMinutosPrep() {
		return minutosPrep;
	}

	public void setMinutosPrep(int minutosPrep) {
		this.minutosPrep = minutosPrep;
	}

	public boolean isEnMenu() {
		return enMenu;
	}


	public void setEnMenu(boolean enMenu) {
		this.enMenu = enMenu;
	}


	public CategoriaProducto getCategoriaManuf() {
		return categoriaManuf;
	}


	public void setCategoriaManuf(CategoriaProducto categoriaManuf) {
		this.categoriaManuf = categoriaManuf;
	}

	
	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public float getPrecioM() {
		return precioM;
	}


	public void setPrecioM(float precioM) {
		this.precioM = precioM;
	}
	
}
