package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entities.MatchProgress;

public interface MatchesProgressRepository extends JpaRepository<MatchProgress, Long> {
    MatchProgress findByTeam1AndTeam2(String team1, String team2);
}
