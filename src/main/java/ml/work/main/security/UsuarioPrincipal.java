package ml.work.main.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ml.work.main.entities.Usuario;

public class UsuarioPrincipal implements UserDetails{

	//private static final long serialVersionUID = 6492543406772002604L;

	private int id;
	private String nombre;
	private String nombreUsuario;
	private String email;
	private String password;
	private Long telefono;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioPrincipal(int id, String nombre, String nombreUsuario, String email, String password, Long telefono, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.authorities = authorities;
    }

	//metodo donde se crea una lista de privilegios (GrantedAutority)
	//y se le asigna en el constructor al usuario principal que devuelve el metodo
	
    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getId(), usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), usuario.getTelefono(), authorities);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }
        
    public Long getTelefono() {
    	return telefono;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
 
}
