package pl.coderslab.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "matchesProgress")
public class MatchProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String team1;
    private String team2;
    private int pointsTeam1;
    private int pointsTeam2;
    private int setsTeam1;
    private int setsTeam2;
    private String matchStatus;

    public MatchProgress(String team1, String team2, int pointsTeam1, int pointsTeam2, int setsTeam1, int setsTeam2, String matchStatus) {
        this.team1 = team1;
        this.team2 = team2;
        this.pointsTeam1 = pointsTeam1;
        this.pointsTeam2 = pointsTeam2;
        this.setsTeam1 = setsTeam1;
        this.setsTeam2 = setsTeam2;
        this.matchStatus = matchStatus;
    }

    public MatchProgress() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getPointsTeam1() {
        return pointsTeam1;
    }

    public void setPointsTeam1(int pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
    }

    public int getPointsTeam2() {
        return pointsTeam2;
    }

    public void setPointsTeam2(int pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
    }

    public int getSetsTeam1() {
        return setsTeam1;
    }

    public void setSetsTeam1(int setsTeam1) {
        this.setsTeam1 = setsTeam1;
    }

    public int getSetsTeam2() {
        return setsTeam2;
    }

    public void setSetsTeam2(int setsTeam2) {
        this.setsTeam2 = setsTeam2;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }
}
