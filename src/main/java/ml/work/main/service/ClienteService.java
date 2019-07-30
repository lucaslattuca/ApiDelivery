package ml.work.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import ml.work.main.dtos.ClienteDTO;
import ml.work.main.entities.Cliente;
import ml.work.main.repositories.ClienteRepository;

@Service
public class ClienteService implements ObjectService<ClienteDTO> {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<ClienteDTO> getAll() {
		List<ClienteDTO> result = new ArrayList<>();
		for (Cliente cliente : clienteRepository.findAll()) {
			ClienteDTO temp = new ClienteDTO();
			//temp.setId_usuario(cliente.getId_usuario());
			temp.setNombreUsuario(cliente.getNombre_Usuario());
			temp.setDireccion(cliente.getDireccion());
			temp.setDni(cliente.getDni());
			temp.setEmail(cliente.getEmail());
			temp.setNombre(cliente.getNombrePersona());
			temp.setPassword(cliente.getPassword());
			temp.setTelefono(cliente.getTelefono());
			//temp.setFacturas(cliente.getFacturas());
			temp.setAlta(cliente.getAlta());
			temp.setBaja(cliente.getBaja());
			
			result.add(temp);
		}
		return result;
	}

	@Override
	public ClienteDTO getOne(int id) {
		Optional<Cliente> aOptional = clienteRepository.findById(id);
		ClienteDTO temp = new ClienteDTO();
		try {
			Cliente cliente = aOptional.get();
			temp.setNombreUsuario(cliente.getNombre_Usuario());
			//temp.setId_usuario(cliente.getId_usuario());
			temp.setDireccion(cliente.getDireccion());
			temp.setDni(cliente.getDni());
			temp.setEmail(cliente.getEmail());
			temp.setNombre(cliente.getNombrePersona());
			temp.setPassword(cliente.getPassword());
			temp.setTelefono(cliente.getTelefono());
			//temp.setFacturas(cliente.getFacturas());
			temp.setAlta(cliente.getAlta());
			temp.setBaja(cliente.getBaja());
			
		} catch (Exception e) {
			System.out.println("No existe el id");
		}
		return temp;
	}

	@Override
	public ClienteDTO save(ClienteDTO t) {
		Cliente cliente = new Cliente();
		cliente.setDireccion(t.getDireccion());
		cliente.setDni(t.getDni());
		cliente.setEmail(t.getEmail());
		cliente.setNombre(t.getNombre());
		cliente.setNombre_Usuario(t.getNombreUsuario());
		cliente.setPassword(t.getPassword());
		cliente.setTelefono(t.getTelefono());	
		//cliente.setFacturas(t.getFacturas());
		cliente.setAlta(t.getAlta());
		cliente.setBaja(t.getBaja());
		
		clienteRepository.save(cliente);
		//t.setId_usuario(cliente.getId_usuario());
		return t;
	}

	@Override
	public ClienteDTO update(ClienteDTO t, int id) {
		Optional<Cliente> pOptional = clienteRepository.findById(id);
		Cliente temp = new Cliente();

		try {
			temp = pOptional.get();
			temp.setDireccion(t.getDireccion());
			temp.setDni(t.getDni());
			temp.setEmail(t.getEmail());
			temp.setNombre(t.getNombre());
			temp.setNombre_Usuario(t.getNombreUsuario());
			temp.setPassword(t.getPassword());
			temp.setTelefono(t.getTelefono());	
			//temp.setFacturas(t.getFacturas());
			temp.setAlta(t.getAlta());
			temp.setBaja(t.getBaja());
			
			clienteRepository.save(temp);
			//t.setId_usuario(temp.getId_usuario());

		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {

		try {
			clienteRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
