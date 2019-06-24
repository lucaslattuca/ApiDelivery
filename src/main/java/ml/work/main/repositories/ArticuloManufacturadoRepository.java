package ml.work.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ml.work.main.entities.ArticuloManufacturado;

public interface ArticuloManufacturadoRepository extends JpaRepository<ArticuloManufacturado, Integer>{
	
	Optional<ArticuloManufacturado> findByNombreManufacturado(String nM);
	boolean existsByNombreManufacturado(String nM);
	
}
