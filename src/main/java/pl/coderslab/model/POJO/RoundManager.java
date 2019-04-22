package pl.coderslab.model.POJO;

import pl.coderslab.model.entities.VolleyballTeam;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.ArrayList;
import java.util.List;

public class RoundManager {

    private int roundCounter = 1;

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
                rounds.add(new Round(roundCounter++, match));
            }
        return rounds;
    }

}
