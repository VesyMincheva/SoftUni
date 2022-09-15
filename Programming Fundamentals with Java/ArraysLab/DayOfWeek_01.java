package ArraysLab;

import java.util.Scanner;

public class DayOfWeek_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] daysOfWeek = new String[7];
        daysOfWeek [0] = "Monday";
        daysOfWeek [1] = "Tuesday";
        daysOfWeek [2] = "Wednesday";
        daysOfWeek [3] = "Thursday";
        daysOfWeek [4] = "Friday";
        daysOfWeek [5] = "Saturday";
        daysOfWeek [6] = "Sunday";

        int n = Integer.parseInt(scanner.nextLine());

        if (n >= 1 && n <= 7 ){
            System.out.println(daysOfWeek[n-1]);
        }else {
            System.out.println("Invalid day!");
        }

    }
}
