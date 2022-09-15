package TextProcessingExercise;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split("\\s+");

        double sum = 0;
        for (int i = 0; i < inputArr.length; i++) {
            String currentString = inputArr[i];
            char firstSymbol = currentString.charAt(0);
            char secondSymbol = currentString.charAt(currentString.length() - 1);
            double num = Integer.parseInt(currentString.replace(firstSymbol, ' ').replace(secondSymbol, ' ').trim());

            if(Character.isUpperCase(firstSymbol)){
                int positionInAlphabet = firstSymbol - 64;
                num = num / positionInAlphabet;
            }else {
                int positionInAlphabet = firstSymbol - 96;
                num = num * positionInAlphabet;
            }

            if(Character.isUpperCase(secondSymbol)){
                int positionInAlphabet = secondSymbol - 64;
                num = num - positionInAlphabet;
            }else {
                int positionInAlphabet = secondSymbol - 96;
                num = num + positionInAlphabet;
            }
            sum += num;
        }


        System.out.printf("%.2f", sum);
    }
}
