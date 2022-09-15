package MidExamJune2022;

import java.net.DatagramPacket;
import java.util.Scanner;

public class BurgerBus_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCities = Integer.parseInt(scanner.nextLine());
        double totalProfit = 0;
        boolean isRaining = false;

        for (int i = 1; i <= numberCities ; i++) {
            String cityName = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());

            if(i % 5 == 0){
                isRaining = true;
                income = income - income * 0.1;
            }else{
                isRaining = false;
            }

            if(i % 3 == 0 && !isRaining){
                expenses = expenses + expenses * 0.5;
            }

            double profitForTheCurrentCity = income - expenses;
            totalProfit += profitForTheCurrentCity;
            System.out.printf("In %s Burger Bus earned %.2f leva.%n", cityName, profitForTheCurrentCity);

        }

        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}
