package ml.work.main.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.util.Set;

public class NuevoUsuarioDTO {
	
	private int id;
	
 	@NotBlank
    private String nombre;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nombreUsuario;

    @NotBlank
    private String password;
    
    private Long telefono;
    	    
    private Set<String> roles;

    	    
   public NuevoUsuarioDTO() {
    	
    }
    
    public NuevoUsuarioDTO(int id,@NotBlank String nombre, @NotBlank @Email String email, @NotBlank String nombreUsuario,
			@NotBlank String password, Long telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.telefono = telefono;
		//this.direccion = direccion;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
	
}
