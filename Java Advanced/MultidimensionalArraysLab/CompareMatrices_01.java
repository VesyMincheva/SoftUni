package MultidimensionalArraysLab;

import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(firstInput[0]);
        int cols = Integer.parseInt(firstInput[1]);

        int [][] firstMatrix = new int [rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentLine = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = Integer.parseInt(currentLine[col]);
            }
        }

        String[] secondInput = scanner.nextLine().split("\\s+");
        rows = Integer.parseInt(secondInput[0]);
        cols = Integer.parseInt(secondInput[1]);

        int [][] secondMatrix = new int [rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentLine2 = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = Integer.parseInt(currentLine2[col]);
            }
        }
        boolean areEqual = true;
        areEqual = areEqual(firstMatrix, secondMatrix);

        if (areEqual){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }


    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length == secondMatrix.length){
            for (int row = 0; row < firstMatrix.length; row++) {
                if (firstMatrix[row].length == secondMatrix[row].length){
                    for (int col = 0; col < firstMatrix[row].length; col++) {
                        if (firstMatrix[row][col] != secondMatrix[row][col]){
                            return false;
                        }
                    }
                }else {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
