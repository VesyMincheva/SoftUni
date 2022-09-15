package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String firstString = input.split(" ")[0];
        String secondString = input.split(" ")[1];

        System.out.println(sumOfChars(firstString,secondString));
    }

    public static int sumOfChars (String firstString, String secondString){
        int sum = 0;
        if(firstString.length() == secondString.length()){
            for (int i = 0; i < firstString.length(); i++) {
                char fromFirstString = firstString.charAt(i);
                char fromSecondString = secondString.charAt(i);
                sum += fromFirstString * fromSecondString;
            }
        }else if (firstString.length() > secondString.length()){
            for (int i = 0; i < secondString.length(); i++) {
                char fromFirstString = firstString.charAt(i);
                char fromSecondString = secondString.charAt(i);
                sum += fromFirstString * fromSecondString;
            }
            for (int i = secondString.length(); i < firstString.length(); i++) {
                char currentSymbol = firstString.charAt(i);
                sum += currentSymbol;
            }
        }else if(secondString.length() > firstString.length()) {
            for (int i = 0; i < firstString.length(); i++) {
                char fromFirstString = firstString.charAt(i);
                char fromSecondString = secondString.charAt(i);
                sum += fromFirstString * fromSecondString;
            }
            for (int i = firstString.length(); i < secondString.length(); i++) {
                char currentSymbol = secondString.charAt(i);
                sum += currentSymbol;
            }
        }

        return sum;
    }
}
