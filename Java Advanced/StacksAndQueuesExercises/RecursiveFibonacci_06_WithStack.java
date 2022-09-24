package StacksAndQueuesExercises;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci_06_WithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);

        if (n < 2){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();
            stack.push(num1);
            stack.push(num2 + num1);
        }
        System.out.println(stack.pop());
    }
}
