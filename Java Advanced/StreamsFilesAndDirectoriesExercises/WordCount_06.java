package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("resources/words.txt"));
        String[] wordsToSearch = scanner.nextLine().split(" ");
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : wordsToSearch) {
            wordsMap.put(word, 0);
        }

        Scanner textScanner = new Scanner(new FileReader("resources/text.txt"));

        String currentWord = textScanner.next();
        while (textScanner.hasNext()){
                if (wordsMap.containsKey(currentWord)){
                    wordsMap.put(currentWord, wordsMap.get(currentWord) + 1);
                }
            currentWord = textScanner.next();
        }

        PrintWriter printWriter = new PrintWriter(new FileWriter("resources/result.txt"));
        wordsMap.entrySet().stream()
                .sorted((f, s) -> s.getValue() - f.getValue())
                .forEach(e -> printWriter.printf("%s - %d%n", e.getKey(), e.getValue()));

        scanner.close();
        textScanner.close();
        printWriter.close();
    }
}
