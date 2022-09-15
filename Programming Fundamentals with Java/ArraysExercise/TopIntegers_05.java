package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[] array = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];

            int maxElement = Integer.MIN_VALUE;
            for (int j = i + 1; j < array.length; j++) {
                int secondElement = array[j];
                if (secondElement > maxElement){
                    maxElement = secondElement;
                }
            }

            if (currentElement > maxElement){
                System.out.print(currentElement + " ");
            }
        }

    }
}
