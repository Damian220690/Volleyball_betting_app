package pl.coderslab.model.POJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.entities.VolleyballTeam;
import pl.coderslab.repositories.MatchesProgressRepository;
import pl.coderslab.repositories.VolleyballTeamRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
public class RoundManager {

    @Autowired
    MatchesProgressRepository matchesProgressRepository;

    @Autowired
    VolleyballTeamRepository volleyballTeamRepository;

    private int roundCounter = 1;
    private List<Round> rounds = new ArrayList<>();

    @PostConstruct
    public synchronized void start() {
        generateRounds(volleyballTeamRepository, matchesProgressRepository);
    }

    private synchronized void generateRounds(VolleyballTeamRepository volleyballTeamRepository, MatchesProgressRepository matchesProgressRepository){
        System.out.println("matches" + this.matchesProgressRepository);

        MatchesSchedule matchesSchedule = new MatchesSchedule();
        List<VolleyballTeam> teams = volleyballTeamRepository.findAll();
        List<String> teamMembers = new ArrayList<>();
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(50);
        for(VolleyballTeam team : teams){
            teamMembers.add(team.getTeamMembers());
        }
        List<String[]> matches = matchesSchedule.generateMatchesSchedule(teamMembers);
        for(String[] match : matches) {
                rounds.add(new Round(roundCounter++, match, queue, this.matchesProgressRepository, this.volleyballTeamRepository));
            }
    }

    public synchronized List<Round> getRounds() {
        return rounds;
    }
}
