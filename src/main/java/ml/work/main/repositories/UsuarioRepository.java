package ml.work.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.work.main.entities.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	boolean existsByNombreUsuario(String nombreUsuario);
	boolean existsByEmail(String email);
	Optional<Usuario> findByEmail(String email);
	
}
