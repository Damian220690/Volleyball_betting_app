package pl.coderslab.model.POJO;


import org.springframework.stereotype.Component;
import pl.coderslab.model.entities.MatchProgress;
import pl.coderslab.repositories.MatchesProgressRepository;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Round extends Thread {
    private int roundNumber;
    private String[] match;
    private BlockingQueue<String> queue;

    private MatchesProgressRepository matchesProgressRepository;
    private VolleyballTeamRepository volleyballTeamRepository;

    public Round(int roundNumber, String[] match, BlockingQueue<String> queue, MatchesProgressRepository matchesProgressRepository, VolleyballTeamRepository volleyballTeamRepository) {
        this.roundNumber = roundNumber;
        this.match = match;
        this.queue = queue;
        this.matchesProgressRepository = matchesProgressRepository;
        this.volleyballTeamRepository = volleyballTeamRepository;
    }

    @Override
    public void run() {

        List<VolleyballMatch> volleyballMatches = getVolleyballMatches();

        System.out.println("Round " + roundNumber + " started");

        for (VolleyballMatch volleyballMatch : volleyballMatches) { ;
            MatchProgress matchProgress = new MatchProgress(volleyballMatch.getTeam1(),
                    volleyballMatch.getTeam2(), volleyballMatch.getPointsTeam1(), volleyballMatch.getPointsTeam2(),
            volleyballMatch.getSetsTeam1(),volleyballMatch.getSetsTeam2());
            volleyballMatch.start();
            System.out.println(volleyballMatch.getPointsTeam2());
        }

        for (VolleyballMatch volleyballMatch : volleyballMatches) {
            try {
                volleyballMatch.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add("round finished");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<VolleyballMatch> getVolleyballMatches() {
        List<VolleyballMatch> volleyballMatches = new ArrayList<>();
        for (String volleyballmatch : match) {
            String[] matchTeams = volleyballmatch.split("-");
            String firstTeam = matchTeams[0];
            String secondTeam = matchTeams[1];
            VolleyballMatch volleyballMatch = new VolleyballMatch(matchesProgressRepository, volleyballTeamRepository,
                    firstTeam, secondTeam, 0, 0, 0, 0);
            volleyballMatches.add(volleyballMatch);
        }
        return volleyballMatches;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String[] getMatch() {
        return match;
    }

    public void setMatch(String[] match) {
        this.match = match;
    }

    public BlockingQueue<String> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }
}
