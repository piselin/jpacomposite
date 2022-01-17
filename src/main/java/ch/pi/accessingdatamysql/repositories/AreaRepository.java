package ch.pi.accessingdatamysql.repositories;

import ch.pi.accessingdatamysql.model.Area;
import org.springframework.data.repository.CrudRepository;

public interface AreaRepository extends CrudRepository<Area, Integer> {
}
