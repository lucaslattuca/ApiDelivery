package ml.work.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ml.work.main.dtos.NuevoUsuarioDTO;
import ml.work.main.entities.Usuario;
import ml.work.main.repositories.UsuarioRepository;

@Service
@Transactional
public class UsuarioService implements ObjectService<NuevoUsuarioDTO>{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	
	public Optional<Usuario> getByNombreUsuario(String nu){
		return usuarioRepository.findByNombreUsuario(nu);
	}
	
	public boolean existePorNombre(String nu){
        return usuarioRepository.existsByNombreUsuario(nu);
    }

    public  boolean existePorEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void guardar(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    @Override
	public List<NuevoUsuarioDTO> getAll() {
		List<NuevoUsuarioDTO> result = new ArrayList<>();
		for (Usuario cliente : usuarioRepository.findAll()) {
			NuevoUsuarioDTO temp = new NuevoUsuarioDTO();
			temp.setId(cliente.getId());
			temp.setNombreUsuario(cliente.getNombreUsuario());
			//temp.setDireccion(cliente.getDireccion());
			//temp.setDni(cliente.getDni());
			temp.setEmail(cliente.getEmail());
			temp.setNombre(cliente.getNombre());
			temp.setPassword(cliente.getPassword());
			temp.setTelefono(cliente.getTelefono());
			//temp.setFacturas(cliente.getFacturas());
			//temp.setAlta(cliente.getAlta());
			////temp.setBaja(cliente.getBaja());
			
			result.add(temp);
		}
		return result;
	}

	public NuevoUsuarioDTO getOne(int id) {
		Optional<Usuario> aOptional = usuarioRepository.findById(id);
		NuevoUsuarioDTO temp = new NuevoUsuarioDTO();
		try {
			Usuario cliente = aOptional.get();
			temp.setNombreUsuario(cliente.getNombreUsuario());
			temp.setId(cliente.getId());
			//temp.setDireccion(cliente.getDireccion());
			//temp.setDni(cliente.getDni());
			temp.setEmail(cliente.getEmail());
			temp.setNombre(cliente.getNombre());
			temp.setPassword(cliente.getPassword());
			temp.setTelefono(cliente.getTelefono());
			//temp.setFacturas(cliente.getFacturas());
			//temp.setAlta(cliente.getAlta());
			//temp.setBaja(cliente.getBaja());
			
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return temp;
	}

	
	public NuevoUsuarioDTO save(NuevoUsuarioDTO t) {
		Usuario cliente = new Usuario();
		//cliente.setDireccion(t.getDireccion());
		//cliente.setDni(t.getDni());
		cliente.setEmail(t.getEmail());
		cliente.setNombre(t.getNombre());
		cliente.setNombreUsuario(t.getNombreUsuario());
		cliente.setPassword(t.getPassword());
		cliente.setTelefono(t.getTelefono());	
		//cliente.setFacturas(t.getFacturas());
		//cliente.setAlta(t.getAlta());
		//cliente.setBaja(t.getBaja());
		
	 usuarioRepository.save(cliente);
		//t.setId_usuario(cliente.getId_usuario());
		return t;
	}

	public NuevoUsuarioDTO update(NuevoUsuarioDTO t, int id) {
		Optional<Usuario> pOptional = usuarioRepository.findById(id);
		Usuario temp = new Usuario();

		try {
			temp = pOptional.get();
			//temp.setDireccion(t.getDireccion());
			//temp.setDni(t.getDni());
			temp.setEmail(t.getEmail());
			temp.setNombre(t.getNombre());
			temp.setNombreUsuario(t.getNombreUsuario());
			temp.setPassword(t.getPassword());
			temp.setTelefono(t.getTelefono());	
			//temp.setFacturas(t.getFacturas());
			//temp.setAlta(t.getAlta());
			//temp.setBaja(t.getBaja());
			
		 usuarioRepository.save(temp);
			//t.setId_usuario(temp.getId_usuario());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	public boolean delete(int id) {

		try {
	 usuarioRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}