package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] firstArray = new String[n];
        String[] secondArray = new String[n];

        for (int i = 0; i < n ; i++) {
            String row = scanner.nextLine();
            String[] array = row.split(" ");

            if (i % 2 == 0){
                firstArray[i] = array[0];
                secondArray[i] = array[1];
            }else {
                firstArray[i] = array[1];
                secondArray[i] = array[0];
            }
        }
        for (String firstArrayElements:firstArray) {
            System.out.print(firstArrayElements + " ");
        }
        System.out.println();
        for (String secondArrayElement:secondArray) {
            System.out.print(secondArrayElement + " ");
        }
    }
}
