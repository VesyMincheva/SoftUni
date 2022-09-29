package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("resources/output.txt"));

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Vowels", 0);
        map.put("Consonants", 0);
        map.put("Punctuation", 0);

        String line = bufferedReader.readLine();
        while (line != null){
            for (char symbol: line.toCharArray()) {
                if (isVowel(symbol)){
                    int currentVowelsCount = map.get("Vowels");
                    map.put("Vowels", currentVowelsCount + 1);
                } else if (isPunctuation(symbol)) {
                    int currentPunctuationCount = map.get("Punctuation");
                    map.put("Punctuation", currentPunctuationCount + 1);
                }else if ( symbol == ' '){

                }else {
                    int currentConsonantsCount = map.get("Consonants");
                    map.put("Consonants", currentConsonantsCount + 1);
                }
            }

            line = bufferedReader.readLine();
        }
        for (var entry : map.entrySet()) {
            printWriter.println(entry.getKey() + ": " + entry.getValue());
        }
        bufferedReader.close();
        printWriter.close();

    }

    private static boolean isPunctuation(char symbol) {
        if (symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?'){
            return true;
        }else {
            return false;
        }
    }

    private static boolean isVowel(char symbol) {
        if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u'){
            return true;
        }else {
            return false;
        }
    }
}
