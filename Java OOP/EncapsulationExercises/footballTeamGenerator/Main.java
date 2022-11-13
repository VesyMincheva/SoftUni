package footballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String commandLine = scanner.nextLine();
        Map<String, Team> teamsMap = new LinkedHashMap<>();

        while (!"END".equals(commandLine)) {

            String[] commandData = commandLine.split(";");
            String command = commandData[0];
            String teamName = commandData[1];

            try {
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teamsMap.put(teamName, team);
                        break;
                    case "Add":
                        String playerName = commandData[2];
                        int endurance = Integer.parseInt(commandData[3]);
                        int sprint = Integer.parseInt(commandData[4]);
                        int dribble = Integer.parseInt(commandData[5]);
                        int passing = Integer.parseInt(commandData[6]);
                        int shooting = Integer.parseInt(commandData[7]);


                        if (teamsMap.containsKey(teamName)) {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teamsMap.get(teamName).addPlayer(player);
                        } else {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }
                        break;
                    case "Remove":
                        String playerToRemove = commandData[2];
                        teamsMap.get(teamName).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        if (teamsMap.containsKey(teamName)) {
                            System.out.printf("%s - %d%n", teamName, Math.round(teamsMap.get(teamName).getRating()));
                            break;
                        } else {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            commandLine = scanner.nextLine();
        }

    }
}
