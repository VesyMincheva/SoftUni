package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                if (row == col){
//                    primaryDiagonal += matrix[row][col];
//                }
//            }
//        }
        for (int i = 0; i < size; i++) {
            primaryDiagonal += matrix[i][i];
        }
        for (int row = size - 1, col = 0; row >=0 ; row--, col++) {
            secondaryDiagonal += matrix[row][col];
        }

        int diff = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(diff);
    }
}
