package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numInDecimal = Integer.parseInt(scanner.nextLine());

        if (numInDecimal == 0){
            System.out.println("0");
        }else {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            while (numInDecimal > 0){
                int remainder = numInDecimal % 2;
                stack.push(remainder);
                numInDecimal = numInDecimal / 2;
            }

            while (stack.size() > 0){
                System.out.print(stack.pop());
            }
        }
    }
}
