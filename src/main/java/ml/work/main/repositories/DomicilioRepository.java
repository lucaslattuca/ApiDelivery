package ml.work.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ml.work.main.entities.Domicilio;

@Repository
public interface DomicilioRepository  extends JpaRepository<Domicilio, Integer>{

}
