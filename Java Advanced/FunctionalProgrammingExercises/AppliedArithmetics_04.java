package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();

        UnaryOperator<int[]> add = arr -> Arrays.stream(arr).map(number ->number + 1).toArray();
        UnaryOperator<int[]> multiply = arr -> Arrays.stream(arr).map(number ->number * 2).toArray();
        UnaryOperator<int[]> subtract = arr -> Arrays.stream(arr).map(number ->number - 1).toArray();


        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
