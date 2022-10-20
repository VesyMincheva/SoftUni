package ExamPrep_17102022;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }

        int beeRow = -1;
        int beeCol = -1;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (matrix[r][c] == 'B'){
                    beeRow = r;
                    beeCol = c;
                }
            }
        }

        int flowersCount = 0;
        boolean isBeeLost = false;
        String input = scanner.nextLine();
        while (!input.equals("End")){
            matrix[beeRow][beeCol] = '.';

            if (input.equals("up") && beeRow != 0){
                beeRow--;
            } else if (input.equals("down") && beeRow != size -1) {
                beeRow++;
            } else if (input.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (input.equals("right") && beeCol != size - 1) {
                beeCol++;
            }else {
                matrix[beeRow][beeCol] = '.';
                System.out.println("The bee got lost!");
                break;
            }

            if (matrix[beeRow][beeCol] == 'f'){
                flowersCount++;
            } else if (matrix[beeRow][beeCol] == 'O') {
                continue;
            }

            matrix[beeRow][beeCol] = 'B';

            input = scanner.nextLine();
        }

        if (flowersCount >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowersCount);

        }else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowersCount);
        }
        printMatrix(matrix);
    }
    private static void printMatrix (char[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + "");
            }
            System.out.println();
        }
    }
}
