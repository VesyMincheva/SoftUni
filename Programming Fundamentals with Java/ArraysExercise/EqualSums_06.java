package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] array = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isSpecial = false;


        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];

            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }
            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                isSpecial = true;
            }
        }
        if(!isSpecial){
            System.out.println("no");
        }
    }
}
