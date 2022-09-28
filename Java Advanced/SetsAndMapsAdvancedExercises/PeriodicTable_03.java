package SetsAndMapsAdvancedExercises;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] compounds = scanner.nextLine().split(" ");
            for (int j = 0; j < compounds.length; j++) {
                set.add(compounds[j]);
            }
        }
        for (String element : set) {
            System.out.print(element + " ");
        }
    }
}
