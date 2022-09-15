package ListsLab;

import java.util.*;

public class ListOfProducts_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> namesList = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            namesList.add(scanner.nextLine());
        }

        Collections.sort(namesList);
        for (int i = 0; i < namesList.size() ; i++) {
            System.out.printf("%d.%s%n", i + 1, namesList.get(i));
        }
    }
}
