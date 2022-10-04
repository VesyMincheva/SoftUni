package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Comparator<Integer> comparator = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0){
                return -1;
            } else if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }else {
                return n1.compareTo(n2);
            }
        };
        Integer[] arr = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(arr, comparator);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
