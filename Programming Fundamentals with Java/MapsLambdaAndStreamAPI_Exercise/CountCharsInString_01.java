package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        for (char element :input.toCharArray()) {
            if(element == ' '){
                continue;
            }
            if(!charMap.containsKey(element)){
                charMap.put(element, 1);
            }else {
                int currentValue = charMap.get(element);
                charMap.put(element, currentValue + 1);
            }
        }
        charMap.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
