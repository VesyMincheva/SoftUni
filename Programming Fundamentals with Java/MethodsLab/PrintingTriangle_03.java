package MethodsLab;

import java.util.Scanner;

public class PrintingTriangle_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        readNRows(n);

    }

    public static void readNRows(int rows) {
        for (int i = 1; i <= rows ; i++) {
            printNum(i);
        }
        for (int i = rows - 1; i >= 1; i--) {
            printRevers(i);
        }
    }

    public static void printNum (int columns) {
        for (int i = 1; i <= columns ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printRevers (int columns){
        for (int i = 1; i <= columns ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
