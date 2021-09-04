package info.sandroalmeida.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        int highScore = 0;
        String currentChampion = "";
        Map<String, Integer> teams_score = new HashMap<>();
        for(int i = 0; i < competitions.size(); i++){
            String homeTeam = competitions.get(i).get(0);
            String awaitTeam = competitions.get(i).get(1);
            if(results.get(i) == 1){
                int homeTeamScore = teams_score.getOrDefault(homeTeam, 0) + 3;
                teams_score.put(homeTeam, homeTeamScore);
                if(highScore < homeTeamScore){
                    highScore = homeTeamScore;
                    currentChampion = homeTeam;
                }
            } else {
                int awaitTeamScore = teams_score.getOrDefault(awaitTeam, 0) + 3;
                teams_score.put(awaitTeam, awaitTeamScore);
                if(highScore < awaitTeamScore){
                    highScore = awaitTeamScore;
                    currentChampion = awaitTeam;
                }
            }
        }

        return currentChampion;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        System.out.println(tournamentWinner(competitions, results));
    }
}
