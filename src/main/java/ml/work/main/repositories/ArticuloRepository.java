package ml.work.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.work.main.entities.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{

	Optional<Articulo> findByNombreArticulo(String nA);
	boolean existsByNombreArticulo(String nA);
	
}
