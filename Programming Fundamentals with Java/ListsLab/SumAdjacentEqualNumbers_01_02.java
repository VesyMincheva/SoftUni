package ListsLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers_01_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());


        for (int i = 0; i < numbersList.size() - 1; i++) {
            double firstNum = numbersList.get(i);
            double secondNum = numbersList.get(i + 1);

            if(firstNum == secondNum){
                numbersList.set(i, firstNum + secondNum);
                numbersList.remove(i + 1);
                i = -1;
            }

        }
        DecimalFormat df = new DecimalFormat("0.#");
        for (double element:numbersList) {
            System.out.print(df.format(element) + " ");
        }
    }
}
