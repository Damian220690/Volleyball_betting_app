package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entities.VolleyballTeam;

public interface VolleyballTeamRepository extends JpaRepository<VolleyballTeam, Long> {
}
