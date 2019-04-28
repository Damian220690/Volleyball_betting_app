package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.entities.VolleyballTeam;

@Repository
public interface VolleyballTeamRepository extends JpaRepository<VolleyballTeam, Long> {
    VolleyballTeam findByTeamMembers(String teamMembers);
}
