package finalfantasy.api.repositories;

import finalfantasy.api.IntermediateTables.GameSummon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GameSummonRepository extends JpaRepository <GameSummon, Long> {



}
