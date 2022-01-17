package ch.pi.jpaexample.repositories;

import ch.pi.jpaexample.model.Area;
import org.springframework.data.repository.CrudRepository;

public interface AreaRepository extends CrudRepository<Area, Integer> {
}
