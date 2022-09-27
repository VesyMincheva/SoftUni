package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String [][] matrix = new String[r][c];

        fillMatrix(matrix);
        printMatrix(matrix);
    }
    private static void fillMatrix(String[][] matrix){
        char firstAndFinalLetter = 'a';
        char middleLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = "" + firstAndFinalLetter + middleLetter + firstAndFinalLetter;
                middleLetter++;
            }

            firstAndFinalLetter++;
            middleLetter = firstAndFinalLetter;
        }
    }
    private static void printMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
