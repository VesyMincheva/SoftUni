package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagonsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] inputArr = input.split(" ");
            String command = inputArr[0];

            if(command.equals("Add")){
                int wagonsToAdd = Integer.parseInt(inputArr[1]);
                wagonsList.add(wagonsToAdd);
            }else {
                int passengersToAdd = Integer.parseInt(inputArr[0]);
                for (int i = 0; i < wagonsList.size(); i++) {
                    int currentWagonFreeSpace = maxCapacity - wagonsList.get(i);
                    if(currentWagonFreeSpace >= passengersToAdd){
                        wagonsList.set(i,wagonsList.get(i) + passengersToAdd);
                        break;
                    }

                }
            }

            input = scanner.nextLine();
        }

        System.out.println(wagonsList.toString().replaceAll("[\\[\\],]", ""));
    }
}
