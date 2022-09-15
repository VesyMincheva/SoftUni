package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialYield = Integer.parseInt(scanner.nextLine());
        int collectedSpice = 0;
        int daysCount = 0;

        while (initialYield >= 100){
            collectedSpice += initialYield;
            daysCount++;
            collectedSpice -= 26;
            initialYield -= 10;
        }
        if (collectedSpice >= 26){
            collectedSpice -= 26;
        }
        System.out.println(daysCount);
        System.out.println(collectedSpice);

    }
}
