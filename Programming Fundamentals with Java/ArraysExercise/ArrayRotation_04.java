package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rotations = Integer.parseInt(scanner.nextLine());

        int[] array = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 1; i <= rotations; i++) {
            int firstElement = array[0];
            for (int j = 0; j < array.length -1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstElement;
        }
        for (int elements:array) {
            System.out.print(elements + " ");
        }
    }
}
