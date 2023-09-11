package finalfantasy.api.repositories;

import finalfantasy.api.models.Npc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NpcRepository extends JpaRepository<Npc, Long> {
}
