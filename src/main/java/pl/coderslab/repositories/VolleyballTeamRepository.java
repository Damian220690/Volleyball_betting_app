package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.entities.VolleyballTeam;

import java.util.List;

@Repository
public interface VolleyballTeamRepository extends JpaRepository<VolleyballTeam, Long> {
    VolleyballTeam findByTeamMembers(String teamMembers);

    @Query(value = "SELECT * FROM volleyballTeams ORDER BY mainPoints DESC, (winSets - lostSets) DESC, winSets DESC ", nativeQuery = true)
    List<VolleyballTeam> findAllByOrderByMainPointsDescAndWinSetsDesc();
}
