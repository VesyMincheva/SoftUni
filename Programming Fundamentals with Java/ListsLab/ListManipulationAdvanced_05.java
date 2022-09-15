package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] inputArr = input.split(" ");

            String command = inputArr[0];

            switch (command){
                case "Contains":
                    int numContains = Integer.parseInt(inputArr[1]);

                    if(numList.contains(numContains)){
                        System.out.println("Yes");
                    }else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = inputArr[1];
                    if(evenOrOdd.equals("even")){
                        for (int i = 0; i < numList.size(); i++) {
                            int currentNum = numList.get(i);
                            if(currentNum % 2 == 0){
                                System.out.print(currentNum + " ");
                            }
                        }
                        System.out.println();
                    }else if(evenOrOdd.equals("odd")){
                        for (int i = 0; i < numList.size(); i++) {
                            int currentNum = numList.get(i);
                            if(currentNum % 2 != 0){
                                System.out.print(currentNum + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numList.size(); i++) {
                        int currentNum = numList.get(i);
                        sum += currentNum;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = inputArr[1];
                    int numToCompare = Integer.parseInt(inputArr[2]);

                    if(condition.equals("<")){
                        for (int element:numList) {
                            if(element < numToCompare){
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    } else if (condition.equals(">")) {
                        for (int element:numList) {
                            if(element > numToCompare){
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    } else if (condition.equals("<=")) {
                        for (int element:numList) {
                            if(element <= numToCompare){
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    } else if (condition.equals(">=")) {
                        for (int element:numList) {
                            if(element >= numToCompare){
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
