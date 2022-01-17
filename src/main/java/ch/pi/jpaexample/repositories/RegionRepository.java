package ch.pi.jpaexample.repositories;

import ch.pi.jpaexample.model.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Integer> {
}
