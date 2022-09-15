package MethodsExercise;

import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double result = calcolateFactorial(firstNum) * 1.0 / calcolateFactorial(secondNum);
        System.out.printf("%.2f", result);
    }

    private static long calcolateFactorial (int num){
        long factorial = 1;
        if (num != 0){
            for (int i = 1; i <= num ; i++) {
                factorial = factorial * i;
            }
        }
        return factorial;

    }
}
