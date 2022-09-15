package MapsLambdaAndStreamAPI_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class WordFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(e -> e.length() % 2 == 0)
                .toArray(String[]::new);

        for (String word:wordsArr) {
            System.out.println(word);
        }
    }
}
