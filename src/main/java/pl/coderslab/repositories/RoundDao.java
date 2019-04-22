package pl.coderslab.repositories;

import pl.coderslab.model.POJO.Round;

import java.util.List;

public class RoundDao {

    public static String findMatchInSpecificRound(List<Round> rounds, long roundNumber, long matchNumber){
        Round round = rounds.get((int)roundNumber - 1);
        String[] matches = round.getMatch();
        return matches[(int)matchNumber - 1];
    }

}
