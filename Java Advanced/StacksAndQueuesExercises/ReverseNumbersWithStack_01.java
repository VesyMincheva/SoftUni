package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(input).forEach(n -> stack.push(n));
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
