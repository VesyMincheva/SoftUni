package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] command = input.split(" ");
            if (command[0].equals("decrease")) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i] - 1;
                }
                }else{
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    switch (command[0]) {
                        case "swap":
                            int firstElement = array[firstIndex];
                            array[firstIndex] = array[secondIndex];
                            array[secondIndex] = firstElement;
                            break;
                        case "multiply":
                            int multiply = array[firstIndex] * array[secondIndex];
                            array[firstIndex] = multiply;
                            break;
                    }
                }

            input = scanner.nextLine();
        }

        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length-1]);
    }
}
