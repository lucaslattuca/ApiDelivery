package ml.work.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ml.work.main.dtos.EmpleadoDTO;
import ml.work.main.entities.Empleado;
import ml.work.main.repositories.EmpleadoRepository;

@Service
public class EmpleadoService implements ObjectService<EmpleadoDTO>  {

	private EmpleadoRepository empleadoRepository;
	
	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	
	@Override
	public List<EmpleadoDTO> getAll() {
		List<EmpleadoDTO> result = new ArrayList<>();
		
		for(Empleado empleado : empleadoRepository.findAll()) {
			EmpleadoDTO temp = new EmpleadoDTO(); 
			
			temp.setAlta(empleado.getAlta());
			temp.setBaja(empleado.getBaja());
			temp.setCargo(empleado.getCargo());
//			temp.setCod_cargo(empleado.getCod_cargo());
			temp.setCodigo_ingreso(empleado.getCodigo_ingreso());
			temp.setCuil(empleado.getCuil());
			temp.setDireccion(empleado.getDireccion());
			temp.setDni(empleado.getDni());
			temp.setEmail(empleado.getEmail());
			//temp.setId_empleado(empleado.getId_empleado());
			temp.setNombre_persona(empleado.getNombre_persona());
			temp.setPassword(empleado.getPassword());
			temp.setTelefono(empleado.getTelefono());
			
			result.add(temp);
		}
		return result;
	}

	@Override
	public EmpleadoDTO getOne(int id) {
		Optional<Empleado> temp = empleadoRepository.findById(id);
		
		EmpleadoDTO result = new EmpleadoDTO();
		
		try {
			Empleado resultBD = temp.get();
			
			result.setAlta(resultBD.getAlta());
			result.setBaja(resultBD.getBaja());
			result.setCargo(resultBD.getCargo());
//			result.setCod_cargo(resultBD.getCod_cargo());
			result.setCodigo_ingreso(resultBD.getCodigo_ingreso());
			result.setCuil(resultBD.getCuil());
			result.setDireccion(resultBD.getDireccion());
			result.setDni(resultBD.getDni());
			result.setEmail(resultBD.getEmail());
			//result.setId_empleado(resultBD.getId_empleado());
			result.setPassword(resultBD.getPassword());
			result.setTelefono(result.getTelefono());
			result.setNombre_persona(resultBD.getNombre_persona());

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public EmpleadoDTO save(EmpleadoDTO t) {
		Empleado guardado = new Empleado();
		
		guardado.setAlta(t.getAlta());
		guardado.setBaja(t.getBaja());
		guardado.setCargo(t.getCargo());
//		guardado.setCod_cargo(t.getCod_cargo());
		guardado.setCodigo_ingreso(t.getCodigo_ingreso());
		guardado.setCuil(t.getCuil());
		guardado.setDireccion(t.getDireccion());
		guardado.setDni(t.getDni());
		guardado.setEmail(t.getEmail());
		guardado.setPassword(t.getPassword());
		guardado.setNombre_persona(t.getNombre_persona());
		guardado.setTelefono(t.getTelefono());
		
		try {
			empleadoRepository.save(guardado);
			//t.setId_empleado(guardado.getId_empleado());
		} catch (Exception e) {
			System.out.println("Error al guardar");
		}
		
		return t;
	}

	@Override
	public EmpleadoDTO update(EmpleadoDTO t, int id) {
		Optional<Empleado> pOptional = empleadoRepository.findById(id);
		
		Empleado temp = new Empleado();
		
		try {
			temp = pOptional.get();
			
			temp.setAlta(t.getAlta());
			temp.setBaja(t.getBaja());
			temp.setCargo(t.getCargo());
//			temp.setCod_cargo(t.getCod_cargo());
			temp.setCodigo_ingreso(t.getCodigo_ingreso());
			temp.setCuil(t.getCuil());
			temp.setDireccion(t.getDireccion());
			temp.setDni(t.getDni());
			temp.setEmail(t.getEmail());
			temp.setNombre_persona(t.getNombre_persona());
			temp.setPassword(t.getPassword());
			temp.setTelefono(t.getTelefono());
			
			empleadoRepository.save(temp);
			//t.setId_empleado(temp.getId_empleado());
		} catch (Exception e) {
			System.out.println("No existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			empleadoRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
