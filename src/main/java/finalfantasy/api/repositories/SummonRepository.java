package finalfantasy.api.repositories;

import finalfantasy.api.models.Summon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SummonRepository extends JpaRepository <Summon, Long> {
}
