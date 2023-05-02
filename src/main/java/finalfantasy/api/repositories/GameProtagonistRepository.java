package finalfantasy.api.repositories;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GameProtagonistRepository extends JpaRepository <GameProtagonist, Long> {

    Boolean findById (long id);
}
