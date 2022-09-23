package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stackOfIndex = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if(currentSymbol == '('){
                stackOfIndex.push(i);
            } else if (currentSymbol == ')') {
                if(!stackOfIndex.isEmpty()){
                    String expressionToPrint = input.substring(stackOfIndex.peek(), i + 1);
                    System.out.println(expressionToPrint);
                    stackOfIndex.pop();
                }
            }
        }
    }
}
