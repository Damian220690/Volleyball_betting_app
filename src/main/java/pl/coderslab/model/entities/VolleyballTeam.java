package pl.coderslab.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VolleyballTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long placeInTable;
    private long numberOfMatches;
    private String teamMembers;
    private int  mainPoints;
    private String winSets;
    private String lostSets;

    public VolleyballTeam(long placeInTable, long numberOfMatches, String teamMembers, int mainPoints, String winSets, String lostSets) {
        this.placeInTable = placeInTable;
        this.numberOfMatches = numberOfMatches;
        this.teamMembers = teamMembers;
        this.mainPoints = mainPoints;
        this.winSets = winSets;
        this.lostSets = lostSets;
    }

    public VolleyballTeam() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlaceInTable() {
        return placeInTable;
    }

    public void setPlaceInTable(long placeInTable) {
        this.placeInTable = placeInTable;
    }

    public long getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(long numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public int getMainPoints() {
        return mainPoints;
    }

    public void setMainPoints(int mainPoints) {
        this.mainPoints = mainPoints;
    }

    public String getWinSets() {
        return winSets;
    }

    public void setWinSets(String winSets) {
        this.winSets = winSets;
    }

    public String getLostSets() {
        return lostSets;
    }

    public void setLostSets(String lostSets) {
        this.lostSets = lostSets;
    }
}
