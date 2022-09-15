package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int capacityFull = 0;
        for (int i = 0; i < n; i++) {
            int littersIn = Integer.parseInt(scanner.nextLine());
            capacityFull = capacityFull + littersIn;

            if (capacityFull > 255){
                System.out.println("Insufficient capacity!");
                capacityFull = capacityFull - littersIn;
            }

        }
        System.out.printf("%d", capacityFull);
    }
}
