package finalfantasy.api.repositories;

import finalfantasy.api.models.Protagonist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProtagonistRepository extends JpaRepository <Protagonist, Long> {
}
