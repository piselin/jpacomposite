package ch.pi.accessingdatamysql.repositories;

import ch.pi.accessingdatamysql.model.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Integer> {
}
