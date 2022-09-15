package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int[] bombArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bombNum = bombArr[0];
        int bombPower = bombArr[1];

        while(numList.contains(bombNum)){

            int left = Math.max(0, numList.indexOf(bombNum) - bombPower);
            int right = Math.min(numList.size() - 1, numList.indexOf(bombNum) + bombPower);

            for (int i = right; i >= left ; i--) {
                numList.remove(i);
            }



        }


        int sum = 0;
        for (int element:numList) {
            sum += element;
        }
        System.out.println(sum);
    }
}
