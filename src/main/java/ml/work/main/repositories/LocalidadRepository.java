package ml.work.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ml.work.main.entities.Localidad;

@Repository
public interface LocalidadRepository  extends JpaRepository<Localidad, Integer>{

}
