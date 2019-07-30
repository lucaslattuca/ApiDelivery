package ml.work.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.work.main.entities.ArticuloManufacturado;

@Repository
public interface ArticuloManufacturadoRepository extends JpaRepository<ArticuloManufacturado, Integer>{
	
	Optional<ArticuloManufacturado> findByNombreManufacturado(String nM);
	boolean existsByNombreManufacturado(String nM);
	
}
