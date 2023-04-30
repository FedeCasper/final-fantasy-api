package finalfantasy.api.repositories;

import finalfantasy.api.models.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnemyRepository extends JpaRepository <Enemy, Long> {
}
