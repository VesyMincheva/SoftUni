package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumEven = 0;
        int sumOdd = 0;

        for (int currentNum:arrayNumbers) {
            if (currentNum % 2 == 0){
                sumEven += currentNum;
            }else {
                sumOdd += currentNum;
            }
        }
        System.out.println(sumEven - sumOdd);
    }
}
