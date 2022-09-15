package MidExamJune2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Finish")){
            String[] inputArr = input.split(" ");
            String command = inputArr[0];
            int currentNum = Integer.parseInt(inputArr[1]);

            switch (command){
                case "Add":
                    numList.add(currentNum);
                    break;
                case "Remove":
                    if(numList.contains(currentNum)){
                        numList.remove(Integer.valueOf(currentNum));
                    }
                    break;
                case "Replace":
                    int numberForReplace = Integer.parseInt(inputArr[2]);
                    for (int i = 0; i < numList.size(); i++) {
                        if(numList.get(i) == currentNum){
                            numList.set(i, numberForReplace);
                            break;
                        }
                    }

                    break;
                case "Collapse":
                    for (int i = 0; i < numList.size(); i++) {
                        if(numList.get(i) < currentNum){
                            numList.remove(i);
                            i = -1;
                        }
                    }
                    break;
            }


            input = scanner.nextLine();
        }

        for (int element: numList) {
            System.out.print(element + " ");
        }
    }
}
