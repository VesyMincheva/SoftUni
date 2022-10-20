package ExamPrep_14102022;

import java.util.Scanner;

public class ReVolt {
    public static int playerRow;
    public static int playerCol;

    public static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (matrix[r][c] == 'f'){
                    playerRow = r;
                    playerCol = c;
                }
            }
        }

        while (commandsCount-- > 0 && !hasWon){
            String command = scanner.nextLine();

            if (command.equals("up")){
                movePlayer(matrix, -1, 0);
            } else if (command.equals("down")) {
                movePlayer(matrix, 1, 0);
            } else if (command.equals("left")) {
                movePlayer(matrix, 0, -1);
            } else if (command.equals("right")) {
                movePlayer(matrix, 0, 1);
            }
        }

        if (hasWon){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playerRow + rowMutator;
        int nextCol = playerCol + colMutator;

        if (isPlayerOut(nextRow, nextCol, matrix)){
            if (nextRow < 0 || nextRow >= matrix.length){
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            }else {
                nextCol = nextCol < 0 ? matrix.length - 1 : 0;
            }
        }

        if (matrix[nextRow][nextCol] == 'T'){
            return;
        } else if (matrix[nextRow][nextCol] == 'B') {
            matrix[playerRow][playerCol] = '-';
            playerRow = nextRow;
            playerCol = nextCol;
            movePlayer(matrix, rowMutator, colMutator);
            return;
        } else if (matrix[nextRow][nextCol] == 'F') {
            hasWon = true;
        }

        if (matrix[playerRow][playerCol] != 'B'){
            matrix[playerRow][playerCol] = '-';
        }
        matrix[nextRow][nextCol] = 'f';
        playerRow = nextRow;
        playerCol = nextCol;

    }

    private static boolean isPlayerOut(int r, int c, char[][] matrix) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    public static void printMatrix(char[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + "");
            }
            System.out.println();
        }
    }
}
