package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] inputArr = input.split("\\s+");
            String command = inputArr[0];

            switch (command){
                case "Add":
                    int num = Integer.parseInt(inputArr[1]);
                    numList.add(num);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(inputArr[1]);
                    int index = Integer.parseInt(inputArr[2]);
                    if(isIndexValid(numList,index)){
                        numList.add(index,numToInsert);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(inputArr[1]);
                    if(isIndexValid(numList,indexToRemove)){
                        numList.remove(indexToRemove);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(inputArr[2]);
                    if(inputArr[1].equals("left")){
                        for (int i = 1; i <= count; i++) {
                            numList.add(numList.get(0));
                            numList.remove(0);
                        }
                    } else if (inputArr[1].equals("right")) {
                        for (int i = 1; i <= count ; i++) {
                            numList.add(0,numList.get(numList.size()-1));
                            numList.remove(numList.size()-1);
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }

    public static boolean isIndexValid (List<Integer> numList, int index){
        return index >= 0 && index <= numList.size() - 1;
    }
}
