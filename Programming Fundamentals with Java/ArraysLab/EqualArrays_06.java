package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        boolean isDifferent = false;
        for (int i = 0; i < firstArray.length; i++) {
            int currentNumFirsArray = firstArray[i];
            int currentNumSecondArray = secondArray[i];

            if (currentNumFirsArray != currentNumSecondArray){
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isDifferent = true;
                break;
            }
            sum += currentNumFirsArray;
        }
        if(!isDifferent){
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
