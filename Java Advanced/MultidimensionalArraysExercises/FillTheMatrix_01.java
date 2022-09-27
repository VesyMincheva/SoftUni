package MultidimensionalArraysExercises;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int [][] matrix = new int[size][size];
        if (pattern.equals("A")){
            fillMatrixPatternA(matrix, size);
        }else if (pattern.equals("B")){
             fillMatrixPatternB(matrix, size);
        }
         printMatrix(matrix);
    }

    private static void fillMatrixPatternA (int [][] matrix, int size){
        int num = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = num;
                num++;
            }
        }
    }
    private static void fillMatrixPatternB (int [][] matrix, int size){
        int num = 1;
        for (int col = 0; col < size; col++) {
            if(col % 2 != 0){
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = num;
                    num++;
                }
            }else {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = num;
                    num++;
                }
            }

        }
    }
    private static void printMatrix(int [][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
