package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = (scanner.nextLine()).replaceAll("\\s+", "").toCharArray();
        }

        char newColor = scanner.nextLine().charAt(0);
        int[] pixels = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int startRow = pixels[0];
        int startCol = pixels[1];
        char oldColor = matrix[startRow][startCol];

        paint(matrix, oldColor, newColor, startRow, startCol);
        print(matrix);

    }

    private static void paint(char[][] matrix, char oldColor, char newColor, int startRow, int startCol) {
        if (isOutOfBounds(matrix, startRow, startCol)){
            return;
        }else if (matrix[startRow][startCol] != oldColor){
            return;
        }

        matrix[startRow][startCol] = newColor;
        paint(matrix, oldColor, newColor, startRow + 1, startCol);
        paint(matrix, oldColor, newColor, startRow - 1, startCol);
        paint(matrix, oldColor, newColor, startRow, startCol + 1);
        paint(matrix, oldColor, newColor, startRow, startCol - 1);
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void print (char[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + "");
            }
            System.out.println();
        }
    }

}
