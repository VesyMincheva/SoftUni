package WorkingWithAbstractionLab;

import java.util.Scanner;

public class RhombusОfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printUp(n);
        printRow(n, n);
        printDown(n);
    }

    private static void printDown(int n) {
        for (int row = n - 1; row > 0 ; row--) {
            printRow(n, row);
        }
    }

    private static void printUp(int n) {
        for (int row = 1; row < n; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        for (int i = 0; i < n - row; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= row; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
