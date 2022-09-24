package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if(currentChar == '{' || currentChar == '[' || currentChar == '('){
                stack.push(currentChar);
            }else if (stack.isEmpty()){
                isBalanced = false;
                break;
            }
            else if (currentChar == '}'){
                char lastChar = stack.pop();
                if (lastChar == '{'){
                    isBalanced = true;
                }else {
                    isBalanced = false;
                    break;
                }
            }else if (currentChar == ']') {
                char lastChar = stack.pop();
                if (lastChar == '['){
                    isBalanced = true;
                }else {
                    isBalanced = false;
                    break;
                }
            }
            else if (currentChar == ')') {
                char lastChar = stack.pop();
                if (lastChar == '('){
                    isBalanced = true;
                }else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
