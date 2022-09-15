package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        Map<String, Integer> racersPointsMap = new LinkedHashMap<>();
        namesList.forEach(entry -> racersPointsMap.put(entry, 0));

        String input = scanner.nextLine();
        while (!input.equals("end of race")){
            StringBuilder name = new StringBuilder();
            int points = 0;
            String regexForLetters = "[A-Za-z]";
            String regexForDigits = "[0-9]";
            Pattern patternForLetters = Pattern.compile(regexForLetters);
            Pattern patternForDigits = Pattern.compile(regexForDigits);
            Matcher matcherForLetters = patternForLetters.matcher(input);
            Matcher matcherForDigits = patternForDigits.matcher(input);

            for (int i = 0; i < input.length(); i++) {
                if(matcherForLetters.find()){
                    name.append(matcherForLetters.group());
                }
            }
            for (int i = 0; i < input.length(); i++) {
                if (matcherForDigits.find()){
                    points += Integer.parseInt(matcherForDigits.group());
                }
            }

            if(racersPointsMap.containsKey(name.toString())){
                Integer currentPoints = racersPointsMap.get(name.toString());
                racersPointsMap.put(name.toString(), currentPoints + points);
            }
            input = scanner.nextLine();
        }
        List<String> namesOfFirstTree = racersPointsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("1st place: " + namesOfFirstTree.get(0));
        System.out.println("2nd place: " + namesOfFirstTree.get(1));
        System.out.println("3rd place: " + namesOfFirstTree.get(2));
    }
}
