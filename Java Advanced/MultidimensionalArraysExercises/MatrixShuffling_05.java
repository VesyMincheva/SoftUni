package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("END")){
            if (commandLine.split(" ").length != 5){
                System.out.println("Invalid input!");
                commandLine = scanner.nextLine();
                continue;
            }
            if (commandLine.contains("swap") && coordinatesAreValid(commandLine, rows, cols)){
                String[] commandArr = commandLine.split(" ");
                String command = commandArr[0];
                int row1 = Integer.parseInt(commandArr[1]);
                int col1 = Integer.parseInt(commandArr[2]);
                int row2 = Integer.parseInt(commandArr[3]);
                int col2 = Integer.parseInt(commandArr[4]);
                if (command.equals("swap")){
                    String currentCoordinates = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = currentCoordinates;
                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[row].length; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                }
            }else {
                System.out.println("Invalid input!");
//                commandLine = scanner.nextLine();
//                continue;
            }

            commandLine = scanner.nextLine();
        }
    }
    private static boolean coordinatesAreValid(String commandLine, int rows, int cols){
        String[] commandArr = commandLine.split(" ");
        String command = commandArr[0];
        int row1 = Integer.parseInt(commandArr[1]);
        int col1 = Integer.parseInt(commandArr[2]);
        int row2 = Integer.parseInt(commandArr[3]);
        int col2 = Integer.parseInt(commandArr[4]);
        if (row1 >= 0 && row1 < rows && col1 >= 0 && col1 < cols &&
            row2 >= 0 && row2 < rows && col2 >= 0 && col2 < cols){
            return true;
        }else {
            return false;
        }


    }
}
