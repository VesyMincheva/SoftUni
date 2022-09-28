package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextLine());
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
