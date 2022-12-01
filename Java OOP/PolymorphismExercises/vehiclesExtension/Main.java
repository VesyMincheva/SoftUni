package vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", getVehicle(scanner));
        vehicles.put("Truck", getVehicle(scanner));
        vehicles.put("Bus", getVehicle(scanner));

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
                    try {
                        vehicles.get(vehicleType).refuel(argument);
                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    Bus bus = (Bus) vehicles.get(vehicleType);
                    System.out.println(bus.driveEmpty(argument));
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
        double capacity = Double.parseDouble(data[3]);

        switch (vehicleType){
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, capacity);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, capacity);
            case "Bus":
                return new Bus(fuelQuantity, fuelConsumption, capacity);
            default: throw new IllegalArgumentException("Missing vehicle");
        }
    }
}
