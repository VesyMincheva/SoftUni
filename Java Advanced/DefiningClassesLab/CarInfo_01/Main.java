package DefiningClassesLab.CarInfo_01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int n = Integer.parseInt(scanner.nextLine());
       Set<Car> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(inputLine[0]);
            car.setModel(inputLine[1]);
            car.setHorsePower(Integer.parseInt(inputLine[2]));
            set.add(car);
            System.out.println(car.carInfo());
        }
    }
}
