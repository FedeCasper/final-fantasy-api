package finalfantasy.api.repositories;

import finalfantasy.api.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LocationRepository extends JpaRepository <Location, Long> {
}
