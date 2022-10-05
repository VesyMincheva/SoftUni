package DefiningClassesLab.CarConstructors_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            if (inputLine.length == 3){
                Car car = new Car (inputLine[0], inputLine[1], Integer.parseInt(inputLine[2]));
                list.add(car);
                System.out.println(car.carInfo());
            }else if (inputLine.length == 1){
                Car car = new Car (inputLine[0]);
                list.add(car);
                System.out.println(car.carInfo());
            }

        }
    }
}
