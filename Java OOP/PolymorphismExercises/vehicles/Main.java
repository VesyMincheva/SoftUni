package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(carData[1]);
        double carFuelConsumption = Double.parseDouble(carData[2]);
        Vehicle car = new Car(carFuelQuantity, carFuelConsumption);

        String[] truckData = scanner.nextLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(truckData[1]);
        double truckFuelConsumption = Double.parseDouble(truckData[2]);
        Vehicle truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCommands; i++) {
            String[] commandsData = scanner.nextLine().split(" ");
            String commandName = commandsData[0];
            String vehicleType = commandsData[1];
            double argument = Double.parseDouble(commandsData[2]);

            switch (commandName){
                case "Drive":
                    System.out.println(vehicles.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    vehicles.get(vehicleType).refuel(argument);
                    break;
            }
        }

        vehicles.values().forEach(System.out::println);
    }
}
