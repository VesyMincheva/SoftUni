package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] numbers = scanner.nextLine().split("\\s+");
        int elementsToPush = Integer.parseInt(numbers[0]);
        int elementsToPop = Integer.parseInt(numbers[1]);
        int elementToCheck = Integer.parseInt(numbers[2]);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(Integer.parseInt(input[i]));
        }
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }
        int minValue = Integer.MAX_VALUE;
        boolean numberIsInStack = false;
        for (Integer element : stack) {
            if (element == elementToCheck){
                System.out.println("true");
                numberIsInStack = true;
                break;
            }else {
                if (element < minValue){
                    minValue = element;
                }
            }
        }
        if (stack.isEmpty()){
            System.out.println(0);
        }else {
            if (!numberIsInStack){
                System.out.println(minValue);
            }

        }
    }
}
