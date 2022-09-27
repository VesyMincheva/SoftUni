package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] rowFromScanner = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(rowFromScanner[col]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

//                Alternative solution:

//                int sum = 0;
//                for (int currentRow = row; currentRow < row + 3; currentRow++) {
//                    for (int currentCol = col; currentCol < col + 3; currentCol++) {
//                        sum += matrix[currentRow][currentCol];
//                    }
//                }
                
                if (sum > maxSum){
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = startRow; row < startRow + 3 ; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
