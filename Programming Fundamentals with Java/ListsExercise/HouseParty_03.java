package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> namesList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] commandArr = scanner.nextLine().split(" ");
            String name = commandArr[0];
            String isOrNotGoing = commandArr[2];

            if(isOrNotGoing.equals("going!")){
                if(!namesList.contains(name)){
                    namesList.add(name);
                }else {
                    System.out.printf("%s is already in the list!%n", name);
                }
            } else if (isOrNotGoing.equals("not")) {
                if(!namesList.contains(name)){
                    System.out.printf("%s is not in the list!%n", name);
                }else {
                    namesList.remove(String.valueOf(name));
                }
            }
        }

        for (String element:namesList) {
            System.out.println(element);
        }
    }
}
