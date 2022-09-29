package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashSet<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")){
            String direction = input.split(", ")[0];
            String carNum = input.split(", ")[1];
            switch (direction){
                case "IN":
                    cars.add(carNum);
                    break;
                case "OUT":
                    cars.remove(carNum);
                    break;
            }
            input = scanner.nextLine();
        }

        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
