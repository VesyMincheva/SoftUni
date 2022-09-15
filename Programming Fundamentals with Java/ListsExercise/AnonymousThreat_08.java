package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("3:1")){
            String[] commandArr = commandLine.split(" ");
            String command = commandArr[0];
            if(command.equals("merge")){
                int startIndex = Integer.parseInt(commandArr[1]);
                int endIndex = Integer.parseInt(commandArr[2]);

                if(startIndex < 0){
                    startIndex = 0;
                }

                if(endIndex > inputList.size()-1){
                    endIndex = inputList.size()-1;
                }

                boolean isValidIndexes =  startIndex <= inputList.size() - 1 && endIndex >= 0 && startIndex < endIndex;

                if(isValidIndexes){
                    String resultString = "";
                    for (int i = startIndex; i <= endIndex ; i++) {
                        String currentElement = inputList.get(i);
                        resultString += currentElement;
                    }
                    for (int i = startIndex; i <= endIndex ; i++) {
                        inputList.remove(startIndex);
                    }

                    inputList.add(startIndex, resultString);
                }


            } else if (command.equals("divide")) {
                int divideIndex = Integer.parseInt(commandArr[1]);
                int partitions = Integer.parseInt(commandArr[2]);
                String textToDivide = inputList.get(divideIndex);
                inputList.remove(divideIndex);


                int partSize = textToDivide.length() / partitions;

                int startIndexSubtract = 0;

                for (int i = 1; i < partitions; i++) {
                    inputList.add(divideIndex, textToDivide.substring(startIndexSubtract, startIndexSubtract + partSize));
                    divideIndex++;
                    startIndexSubtract += partSize;
                }
                inputList.add(divideIndex, textToDivide.substring(startIndexSubtract));

            }

            commandLine = scanner.nextLine();
        }

        System.out.println(String.join(" ", inputList));
    }

}
