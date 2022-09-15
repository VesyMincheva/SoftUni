package ListsExercise;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstList = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        Collections.reverse(firstList);

        System.out.print(firstList.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .trim()
                    .replaceAll(",", "")
                    .replaceAll("\\s+", " ") + " ");


    }
}
