package pl.coderslab.model.POJO;


public class Round {
    private int roundNumber;
    private String[] match;


    public Round(int roundNumber, String[] match) {
        this.roundNumber = roundNumber;
        this.match = match;
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

}
