package pl.coderslab.model.POJO;

import java.util.Arrays;
import java.util.List;

public class MatchesSchedule {

    public List<String[]> generateMatchesSchedule(List<String> teams) {

        // Generate the schedule using round robin algorithm.
        int numberOfTeams = teams.size();
        int numberOfRounds = (numberOfTeams - 1) * 2;
        int matchesPerRound = numberOfTeams / 2;
        int halfRoundMark = (numberOfRounds / 2);
        String[][] rounds = new String[numberOfRounds][matchesPerRound];

        for (int round = 0; round < numberOfRounds; round++) {
            for (int match = 0; match < matchesPerRound; match++) {
                int home = (round + match) % (numberOfTeams - 1);
                int away = (numberOfTeams - 1 - match + round) % (numberOfTeams - 1);

                if (match == 0) {
                    away = numberOfTeams - 1;
                }
                String roundString;
                if (round < halfRoundMark) {
                    roundString = (teams.get(home) + " - " + teams.get(away));
                } else {
                    roundString = (teams.get(away) + " - " + teams.get(home));
                }
                rounds[round][match] = roundString;
            }
        };
//        List<String[]> matches = Arrays.asList(rounds);
//        for(String[] match : matches) {
//            for (int i = 0; i < match.length; i++) {
//                System.out.println(i +" "+match[i]);
//            }
//        }

        List<String[]> matches = Arrays.asList(rounds);
        return matches;

    }
}
