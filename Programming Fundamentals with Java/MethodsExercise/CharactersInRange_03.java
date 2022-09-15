package MethodsExercise;

import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        printCharactersInRange(firstChar,secondChar);
    }

    private static void printCharactersInRange (char start, char stop){
        if(start < stop){
            for (int i = start + 1; i < stop ; i++) {
                System.out.printf("%c ",i);
            }
        }else if (stop < start) {
            for (int i = stop + 1; i < start; i++) {
                System.out.printf("%c ",i);
            }
        }
    }
}
