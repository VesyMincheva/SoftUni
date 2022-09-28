package SetsAndMapsAdvancedExercises;

import java.util.*;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Set<String>> map = new LinkedHashMap<>();

        while (!input.equals("JOKER")){
            String name = input.split(": ")[0];
            String cards = input.split(": ")[1];
            String[] cardsArr = cards.split(", ");
            if (!map.containsKey(name)){
                map.put(name,new HashSet<>());
            }
            Collections.addAll(map.get(name), cardsArr);

            input = scanner.nextLine();
        }
        for (var entry : map.entrySet()) {
            int totalSum = result(entry.getValue());
            System.out.printf("%s: %d%n", entry.getKey(), totalSum);
        }
    }
    private static int result (Set<String> cards){
        int result = 0;
        for (String card : cards) {
            String currentCard = card;
            String power = currentCard.substring(0, currentCard.length() - 1);
            String paint = currentCard.substring(currentCard.length() - 1, currentCard.length());
            result += totalPower(power) * totalPowerPaint(paint);

        }
        return result;
    }
    private static int totalPower(String power){
        switch (power){
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
        }
        return 0;
    }
    private static int totalPowerPaint (String paint){
        switch (paint){
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
        }
        return 0;
    }
}
