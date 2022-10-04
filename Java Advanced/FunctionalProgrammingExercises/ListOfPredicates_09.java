    package FunctionalProgrammingExercises;

    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;
    import java.util.function.Predicate;
    import java.util.stream.Collectors;

    public class ListOfPredicates_09 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> numbersToDivideTo = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());
            Predicate<Integer> isDivisible = number -> {
                for (Integer currentNumber:numbersToDivideTo) {
                    if (number % currentNumber != 0){
                        return false;
                    }
                }
                return  true;
            };
            for (int i = 1; i <= n; i++) {
                if (isDivisible.test(i)){
                    System.out.print(i + " ");
            }

            }
        }
    }
