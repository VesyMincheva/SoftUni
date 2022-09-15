package MethodsExercise;

import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String lowerCase = input.toLowerCase();

        printVowelsCount(lowerCase);
    }

    private static void printVowelsCount (String text){
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if(currentChar == 'a' || currentChar == 'e' || currentChar == 'o' || currentChar == 'u'
            || currentChar == 'i' || currentChar == 'y'){
                count++;
            }

        }
        System.out.println(count);
    }
}
