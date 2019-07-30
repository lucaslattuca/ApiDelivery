package ml.work.main.dtos;

import java.io.Serializable;
import java.util.Date;

import ml.work.main.entities.Domicilio;

public class ClienteDTO extends PersonaDTO implements Serializable{

	//private static final long serialVersionUID = 4968927794104447651L;
	
	private Long idCliente;
	

	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(String nombre, String nombreUsuario, Long dni, String password, Long telefono, String email,
			Domicilio direccion, Date alta, Date baja, Long idCliente) {
		super(nombre, nombreUsuario, dni, password, telefono, email, alta, baja);
		this.idCliente = idCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
