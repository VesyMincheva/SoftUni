package MethodsExercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        printSmallestNumber(n1,n2, n3);

    }
    private static void printSmallestNumber (int number1, int number2, int number3){
        if(number1 <= number2 && number1 <= number3){
            System.out.println(number1);
        } else if (number2 <= number1 && number2 <= number3) {
            System.out.println(number2);
        } else if (number3 <= number1 && number3 <= number2) {
            System.out.println(number3);
        }
    }
}
