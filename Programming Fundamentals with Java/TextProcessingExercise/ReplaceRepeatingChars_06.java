package TextProcessingExercise;

import java.util.Scanner;

public class ReplaceRepeatingChars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder newText = new StringBuilder();
        newText.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            char nextSymbol = input.charAt(i - 1);

            if(currentSymbol != nextSymbol){
                newText.append(currentSymbol);
            }
        }
        System.out.println(newText);
    }
}
