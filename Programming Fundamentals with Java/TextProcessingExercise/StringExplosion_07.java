package TextProcessingExercise;

import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);

        int totalPower = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if(currentSymbol == '>'){
                int currentPower = Integer.parseInt(text.charAt(i + 1) + "");
                totalPower += currentPower;

            } else if (currentSymbol != '>' && totalPower > 0) {
                text.deleteCharAt(i);
                totalPower--;
                i--;
            }
        }
        System.out.println(text);
    }
}
