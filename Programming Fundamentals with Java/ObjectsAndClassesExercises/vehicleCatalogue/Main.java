package vehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> listOfVehicles = new ArrayList<>();

        while (!input.equals("End")){
            String type = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            double horsePower = Double.parseDouble(input.split(" ")[3]);

            Vehicle vehicle = new Vehicle(type, model,color,horsePower);
            listOfVehicles.add(vehicle);

            input = scanner.nextLine();
        }

        String commandModel = scanner.nextLine();
        while (!commandModel.equals("Close the Catalogue")){

            for (Vehicle element:listOfVehicles) {
                if(commandModel.equals(element.getModel())){
                    System.out.println(element.toString());
                    break;
                }
            }

            commandModel = scanner.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n",getAverageHP(listOfVehicles, "cars"));
        System.out.printf("Trucks have average horsepower of: %.2f.",getAverageHP(listOfVehicles, "trucks"));
    }

    private static double getAverageHP(List<Vehicle> listOfVehicles, String type) {
        double sum = 0;
        int count = 0;

        if(type.equals("cars")){
            for (Vehicle vehicle:listOfVehicles) {
                if(vehicle.getType().equals("car")){
                    sum += vehicle.getHorsePower();
                    count++;
                }
            }

        }else if (type.equals("trucks")){
            for (Vehicle vehicle:listOfVehicles) {
                if(vehicle.getType().equals("truck")){
                    sum += vehicle.getHorsePower();
                    count++;
                }
            }
        }
        if (sum == 0){
            return 0;
        }
        return sum / count;
    }
}
