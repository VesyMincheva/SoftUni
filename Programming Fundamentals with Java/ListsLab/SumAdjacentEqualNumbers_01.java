package ListsLab;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numList.size() - 1; i++) {
            Double firstNum = numList.get(i);
            Double secondNum = numList.get(i + 1);

            if(firstNum.equals(secondNum)){
                numList.set(i, firstNum + secondNum);
                numList.remove(i + 1);
                i = -1;
            }

        }
        DecimalFormat df = new DecimalFormat("0.#");
        for (Double element:numList) {
            System.out.print(df.format(element) + " ");
        }

    }
}
