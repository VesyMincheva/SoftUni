package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int numberOfRotations = numbersList.size() / 2;

        for (int i = 0; i < numberOfRotations; i++) {
            int firstNum = numbersList.get(i);
            int secondNum = numbersList.get(numbersList.size()-1);
            int sum = firstNum + secondNum;
            numbersList.set(i, sum);
            numbersList.remove(numbersList.size()-1);
        }

        for (int element:numbersList) {
            System.out.print(element + " ");
        }
    }
}
