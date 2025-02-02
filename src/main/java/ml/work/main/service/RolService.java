package ml.work.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ml.work.main.entities.Rol;
import ml.work.main.enums.RolNombre;
import ml.work.main.repositories.RolRepository;

@Service
@Transactional
public class RolService {
	
	@Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
	
}
