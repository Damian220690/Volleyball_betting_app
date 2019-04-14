package pl.coderslab.model.POJO;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.model.entities.VolleyballTeam;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.ArrayList;
import java.util.List;

public class RoundManager {

    private int counter = 1;

    public List<Round> generateRounds(VolleyballTeamRepository volleyballTeamRepository){
        List<Round> rounds = new ArrayList<>();
        MatchesSchedule matchesSchedule = new MatchesSchedule();
        List<VolleyballTeam> teams = volleyballTeamRepository.findAll();
        List<String> teamMembers = new ArrayList<>();
        for(VolleyballTeam team : teams){
            teamMembers.add(team.getTeamMembers());
        }
        List<String[]> matches = matchesSchedule.generateMatchesSchedule(teamMembers);
        for(String[] match : matches) {
            rounds.add(new Round(counter++, match));
        }
        return rounds;
    }
}
