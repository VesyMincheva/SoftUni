package ArraysLab;

import java.util.Scanner;

public class SumEvenNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arr = input.split(" ");

        int[] arrNumbers = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrNumbers[i] = Integer.parseInt(arr[i]);

            if (arrNumbers[i] % 2 == 0){
                sum += arrNumbers[i];
            }
        }
        System.out.println(sum);
    }
}
