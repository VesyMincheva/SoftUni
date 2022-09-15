package RegularExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_04Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            String originalMessage = scanner.nextLine();
            int countSpecialLetters = 0;
            for (char symbol:originalMessage.toCharArray()) {
                if(symbol == 's' || symbol == 't' || symbol == 'a' || symbol == 'r'
                || symbol == 'S' || symbol == 'T' || symbol == 'A' || symbol == 'R'){
                    countSpecialLetters++;
                }
            }
            StringBuilder encryptedMessage = new StringBuilder();
            for (char symbol:originalMessage.toCharArray()) {
                char newSymbol = (char)(symbol - countSpecialLetters);
                encryptedMessage.append(newSymbol);
            }
            String regex = "@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<type>[AD])![^@\\-!:>]*->(?<soldiersCount>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(encryptedMessage.toString());
            if(matcher.find()){
                String planetName = matcher.group("planetName");
                long population = Long.parseLong(matcher.group("population"));
                String type = matcher.group("type");
                int soldiersCount = Integer.parseInt(matcher.group("soldiersCount"));
                if(type.equals("A")){
                    attackedPlanets.add(planetName);
                }else if (type.equals("D")) {
                    destroyedPlanets.add(planetName);
                }

            }

        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.println("Attacked planets: " + attackedPlanets.size());
        for (String element:attackedPlanets) {
            System.out.printf("-> %s%n",element);
        }
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        for (String element:destroyedPlanets) {
            System.out.printf("-> %s%n",element);
        }
    }
}
