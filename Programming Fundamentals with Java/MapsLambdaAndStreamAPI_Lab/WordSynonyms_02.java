package MapsLambdaAndStreamAPI_Lab;

import java.util.*;

public class WordSynonyms_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> wordsMap = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if(!wordsMap.containsKey(word)){
                wordsMap.put(word, new ArrayList<>());
                wordsMap.get(word).add(synonym);
            }else {
                wordsMap.get(word).add(synonym);
            }
        }

        for (Map.Entry<String, List<String>> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }

    }
}
