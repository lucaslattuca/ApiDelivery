package ml.work.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ml.work.main.entities.Distrito;

@Repository
public interface DistritoRepository  extends JpaRepository<Distrito, Integer>{

}
