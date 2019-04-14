package pl.coderslab.model.POJO;

import java.util.Arrays;
import java.util.List;

public class Player {

    static int setsTeam1 = 0;
    static int setsTeam2 = 0;
    static int pointsTeam1 = 0;
    static int pointsTeam2 = 0;

//    public void pointsIncrement() {
//        int serveNumber = (int) Math.round((Math.random() * 4));
//        int defenceNumber = (int) Math.round((Math.random() * 2));
//        int neutralNumber = (int) Math.round((Math.random() * 1));
//        int offensiveNumber = (int) Math.round((Math.random() * 5));
//
//        System.out.println("------------");
//        System.out.println(pointsTeam1 + " - " + pointsTeam2);
//
//        if (serveNumber == 2) {
//            pointsTeam1++;
//            System.out.println(getSingleVolleyballAction(0, serveNumber));
//        } else if (serveNumber == 3 || serveNumber == 4) {
//            System.out.println(getSingleVolleyballAction(0, serveNumber));
//            pointsTeam2++;
//        } else {
//            System.out.println(getSingleVolleyballAction(0, serveNumber));
//            if (defenceNumber == 2) {
//                System.out.println(getSingleVolleyballAction(1, defenceNumber));
//                pointsTeam1++;
//            } else {
//                System.out.println(getSingleVolleyballAction(1, defenceNumber));
//                System.out.println(getSingleVolleyballAction(2, neutralNumber));
//                if (offensiveNumber == 3 || offensiveNumber == 4 || offensiveNumber == 5) {
//                    System.out.println(getSingleVolleyballAction(3, offensiveNumber));
//                    pointsTeam2++;
//                } else {
//                    System.out.println(getSingleVolleyballAction(3, offensiveNumber));
//                    pointsTeam1++;
//                }
//            }
//        }
//        if (pointsTeam1 == 21 || pointsTeam2 == 21) {
//            if (pointsTeam1 > pointsTeam2) {
//                setsTeam1++;
//                System.out.println("sets for team1: " + setsTeam1);
//            } else {
//                setsTeam2++;
//                System.out.println("sets for team2: " + setsTeam2);
//            }
//            pointsTeam1 = 0;
//            pointsTeam2 = 0;
//            System.out.println(pointsTeam1);
//            System.out.println((pointsTeam2));
//        }
//        if (setsTeam1 == 2 || setsTeam2 == 2) {
//            if (setsTeam1 > setsTeam2) {
//                System.out.println("Team 1 win");
//            } else {
//                System.out.println("Team 2 wins");
//            }
//        }
//    }

    public String pointsIncrement() {
        int serveNumber = (int) Math.round((Math.random() * 4));
        int defenceNumber = (int) Math.round((Math.random() * 2));
        int neutralNumber = (int) Math.round((Math.random() * 1));
        int offensiveNumber = (int) Math.round((Math.random() * 5));

        String result = pointsTeam1 + " - " + pointsTeam2;

        System.out.println("------------");
        System.out.println(result);

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
            System.out.println(pointsTeam1 + " - " + pointsTeam2);
            if (pointsTeam1 > pointsTeam2) {
                setsTeam1++;
            } else {
                setsTeam2++;
            }
            pointsTeam1 = 0;
            pointsTeam2 = 0;
        }
        if (setsTeam1 == 2 || setsTeam2 == 2) {
            if (setsTeam1 > setsTeam2) {
                System.out.println("Team 1 win");
            } else {
                System.out.println("Team 2 wins");
            }
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
}
