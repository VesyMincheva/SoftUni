package MethodsExercise;

import java.util.Scanner;

public class NxNMatrix_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printMatrix(n);

    }

    private static void printMatrix (int rows){
        for (int i = 1; i <= rows; i++) {

            printColumns(rows);
        }
    }

    private static void printColumns (int columns){
        for (int i = 1; i <= columns ; i++) {
            System.out.printf("%d ", columns);
        }
        System.out.println();
    }
}
