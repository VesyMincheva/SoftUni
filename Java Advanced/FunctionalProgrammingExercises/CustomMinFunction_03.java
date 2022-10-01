package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();

        Function<int [], Integer> function = arr -> {
            int min = Integer.MAX_VALUE;
            for (int number : arr) {
                if (number < min){
                    min = number;
                }
            }
            return min;
        };


        int minValue = function.apply(numbers);
        System.out.println(minValue);
    }
}
