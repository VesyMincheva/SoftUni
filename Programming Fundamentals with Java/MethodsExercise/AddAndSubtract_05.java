package MethodsExercise;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sum = sum(firstNum, secondNum);
        System.out.println(subtract(sum,thirdNum));

    }

    private static int sum (int n1, int n2){

        return n1 + n2;
    }

    private static int subtract (int sum, int n3){
        return sum - n3;
    }
}
