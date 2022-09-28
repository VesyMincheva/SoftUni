package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char symbol:input.toCharArray()) {
            if (!map.containsKey(symbol)){
                map.put(symbol, 1);
            }else {
                int currentCount = map.get(symbol);
                map.put(symbol, currentCount + 1);
            }
        }
        for (var entry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(),entry.getValue());
        }
    }
}
