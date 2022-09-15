package MapsLambdaAndStreamAPI_Lab;

import java.util.*;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");
        Map<String, Integer> wordsMap = new LinkedHashMap<>();

        for (int i = 0; i < inputArr.length; i++) {
            String currentWord = inputArr[i].toLowerCase();
            Integer count = wordsMap.get(currentWord);

            if(wordsMap.containsKey(currentWord)){
                wordsMap.put(currentWord,count + 1);
            }else {
                wordsMap.put(currentWord, 1);
            }
        }

        List<String> validWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if(entry.getValue() % 2 != 0){
                validWords.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", validWords));

    }
}
