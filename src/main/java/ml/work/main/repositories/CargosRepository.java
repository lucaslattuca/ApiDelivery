package ml.work.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.work.main.entities.Cargos;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Integer>{

}
