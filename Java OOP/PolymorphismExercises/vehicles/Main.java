package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Vehicle car = getVehicle(scanner);
        Vehicle truck = getVehicle(scanner);

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

    private static Vehicle getVehicle (Scanner scanner){
        String[] data = scanner.nextLine().split("\\s+");
        String vehicleType = data[0];
        double fuelQuantity = Double.parseDouble(data[1]);
        double fuelConsumption = Double.parseDouble(data[2]);

        switch (vehicleType){
            case "Car":
                return new Car(fuelQuantity, fuelConsumption);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption);
            default: throw new IllegalArgumentException("Missing vehicle");
        }
    }
}
