package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String [] inputArr = input.split(" ");
            String command = inputArr[0];

            int num = 0;
            int index = 0;
            switch (command){
                case "Add":
                    num = Integer.parseInt(inputArr[1]);
                    numList.add(num);
                    break;
                case "Remove":
                    num = Integer.parseInt(inputArr[1]);
                    numList.remove(Integer.valueOf(num));
                    break;
                case "RemoveAt":
                    index = Integer.parseInt(inputArr[1]);
                    numList.remove(index);
                    break;
                case "Insert":
                    num = Integer.parseInt(inputArr[1]);
                    index = Integer.parseInt(inputArr[2]);
                    numList.add(index, num);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
