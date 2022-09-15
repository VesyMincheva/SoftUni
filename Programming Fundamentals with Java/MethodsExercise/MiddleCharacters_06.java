package MethodsExercise;

import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        printMiddleChar(input);
    }

    private static void printMiddleChar (String text){
        char middle = text.charAt(text.length()/2);
        char beforeMiddle = text.charAt(text.length() / 2 - 1);
        if(text.length() % 2 == 0){
            System.out.printf("%c%c",beforeMiddle, middle);
        }else {
            System.out.println("" + middle);
        }

    }
}
