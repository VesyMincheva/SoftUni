package foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countOfPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < countOfPeople; i++) {
            String[] personData = scanner.nextLine().split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            if (personData.length == 4){
                String id = personData[2];
                String birthDate = personData[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                buyers.put(name, citizen);
            } else if (personData.length == 3) {
                String group = personData[2];
                Rebel rebel = new Rebel(name, age, group);
                buyers.put(name, rebel);
            }
        }

        String command = scanner.nextLine();
        while (!"End".equals(command)){
            String buyerName = command;
            if (buyers.containsKey(buyerName)){

                buyers.get(buyerName).buyFood();
            }

            command = scanner.nextLine();
        }
        int totalFood = 0;
        for (Map.Entry<String, Buyer> entry : buyers.entrySet()) {
            int food = entry.getValue().getFood();
            totalFood += food;
        }
        System.out.println(totalFood);

    }
}
