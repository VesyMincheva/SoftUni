package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        while (!input.equals("search")){
            String[] nameAndNumber = input.split("-");
            String name = nameAndNumber[0];
            String number = nameAndNumber[1];
//            if (!map.containsKey(name)){
//                map.put(name, number);
//            }
            map.put(name, number);

            input = scanner.nextLine();
        }
        String searchName = scanner.nextLine();
        while (!searchName.equals("stop")){
            if (map.containsKey(searchName)){
                System.out.printf("%s -> %s%n", searchName, map.get(searchName));
            }else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }
            searchName = scanner.nextLine();
        }
    }
}
