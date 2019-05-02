package pl.coderslab.model.POJO;

import pl.coderslab.model.entities.MatchProgress;
import pl.coderslab.model.entities.VolleyballTeam;
import pl.coderslab.repositories.MatchesProgressRepository;
import pl.coderslab.repositories.VolleyballTeamRepository;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VolleyballMatch extends Thread {
    private String team1;
    private String team2;
    private int pointsTeam1;
    private int pointsTeam2;
    private int setsTeam1;
    private int setsTeam2;
    private String score;
    private MatchesProgressRepository matchesProgressRepository;
    private VolleyballTeamRepository volleyballTeamRepository;

    public VolleyballMatch(MatchesProgressRepository matchesProgressRepository, VolleyballTeamRepository volleyballTeamRepository,
                           String team1, String team2, int pointsTeam1, int pointsTeam2, int setsTeam1, int setsTeam2) {
        this.matchesProgressRepository = matchesProgressRepository;
        this.volleyballTeamRepository = volleyballTeamRepository;
        this.team1 = team1;
        this.team2 = team2;
        this.pointsTeam1 = pointsTeam1;
        this.pointsTeam2 = pointsTeam2;
        this.setsTeam1 = setsTeam1;
        this.setsTeam2 = setsTeam2;
    }

    @Override
    public void run() {
        while (this.getSetsTeam1() < 2 || this.getSetsTeam2() < 2) {
            synchronized (this) {
                score = pointsIncrement();
                MatchProgress matchProgress = matchesProgressRepository.findByTeam1AndTeam2(team1, team2);
                if (matchProgress == null) {
                    matchProgress = new MatchProgress();
                }
                matchProgress.setTeam1(team1);
                matchProgress.setTeam2(team2);
                matchProgress.setPointsTeam1(pointsTeam1);
                matchProgress.setPointsTeam2(pointsTeam2);
                matchProgress.setSetsTeam1(setsTeam1);
                matchProgress.setSetsTeam2(setsTeam2);
                matchesProgressRepository.save(matchProgress);

                if (matchProgress.getSetsTeam1() == 2 || matchProgress.getSetsTeam2()  == 2) {
                    if (setsTeam1 > setsTeam2) {
                        updateInformationAboutTeamInLeagueTable(matchProgress.getTeam1().trim(), setsTeam1, setsTeam2,true);
                        updateInformationAboutTeamInLeagueTable(matchProgress.getTeam2().trim(), setsTeam2, setsTeam1,false);
                    break;
                } else {
                        updateInformationAboutTeamInLeagueTable(matchProgress.getTeam2().trim(), setsTeam2, setsTeam1,true);
                        updateInformationAboutTeamInLeagueTable(matchProgress.getTeam1().trim(), setsTeam1, setsTeam2,false);
                    break;
                }
            }
        }
        sleep(1);
    }

}

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String pointsIncrement() {
        int serveNumber = (int) Math.round((Math.random() * 4));
        int defenceNumber = (int) Math.round((Math.random() * 2));
        int neutralNumber = (int) Math.round((Math.random() * 1));
        int offensiveNumber = (int) Math.round((Math.random() * 5));
        String result = pointsTeam1 + " - " + pointsTeam2;
        if (serveNumber == 2) {
            pointsTeam1++;
        } else if (serveNumber == 3 || serveNumber == 4) {
            pointsTeam2++;
        } else {
            if (defenceNumber == 2) {
                pointsTeam1++;
            } else {
                if (offensiveNumber == 3 || offensiveNumber == 4 || offensiveNumber == 5) {
                    pointsTeam2++;
                } else {
                    pointsTeam1++;
                }
            }
        }
        if (pointsTeam1 == 21 || pointsTeam2 == 21) {
            if (pointsTeam1 > pointsTeam2) {
                setsTeam1++;
            } else {
                setsTeam2++;
            }
            pointsTeam1 = 0;
            pointsTeam2 = 0;
        }
        return result;
    }


    public List<String[]> prepareVolleyballActions() {
        String[] offensiveActions = {"plas", "atak ze skrzydła", "atak ze środka", "atak w aut", "atak w siatke", "atak w antenke"};
        String[] neutralActions = {"wystawa górą", "wystawa dołem"};
        String[] defenceActions = {"odbiór piłki na palce", "odbiór piłki sposobem dolnym", "błąd przyjęcia"};
        String[] serveActions = {"serwis z wyskoku", "flot", "as serwisowy", "serwis w aut", "serwis w siatke"};

        List<String[]> actionGroups = Arrays.asList(serveActions, defenceActions, neutralActions, offensiveActions);
        return actionGroups;
    }

    public String getSingleVolleyballAction(int numberOfActionGroup, int numberOfAction) {
        List<String[]> volleyballAction = prepareVolleyballActions();
        String[] actionGroup = volleyballAction.get(numberOfActionGroup);
        return actionGroup[numberOfAction];
    }

    public synchronized void updateInformationAboutTeamInLeagueTable(String team, int setsWinnerTeam, int setsLoserTeam, boolean hasWon) {
        VolleyballTeam teamFromDB = volleyballTeamRepository.findByTeamMembers(team);
        if (hasWon == true) {
            teamFromDB.setMainPoints(teamFromDB.getMainPoints() + 2);
        } else {
            teamFromDB.setMainPoints(teamFromDB.getMainPoints());
        }
        teamFromDB.setNumberOfMatches(teamFromDB.getNumberOfMatches() + 1);
        teamFromDB.setWinSets(teamFromDB.getWinSets() + setsWinnerTeam);
        teamFromDB.setLostSets(teamFromDB.getLostSets() + setsLoserTeam);
        volleyballTeamRepository.save(teamFromDB);
    }

    public synchronized String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public synchronized String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public synchronized int getPointsTeam1() {
        return pointsTeam1;
    }

    public void setPointsTeam1(int pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
    }

    public synchronized int getPointsTeam2() {
        return pointsTeam2;
    }

    public void setPointsTeam2(int pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
    }

    public synchronized int getSetsTeam1() {
        return setsTeam1;
    }

    public void setSetsTeam1(int setsTeam1) {
        this.setsTeam1 = setsTeam1;
    }

    public synchronized int getSetsTeam2() {
        return setsTeam2;
    }

    public void setSetsTeam2(int setsTeam2) {
        this.setsTeam2 = setsTeam2;
    }

}
