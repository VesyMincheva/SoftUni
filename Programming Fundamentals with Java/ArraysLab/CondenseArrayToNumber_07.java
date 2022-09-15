package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (array.length >=2){
            int[] condensedArray = new int [array.length - 1];

            for (int i = 0; i < condensedArray.length; i++) {
                condensedArray[i] = array[i] + array[i + 1];
            }


        }
    }
}
