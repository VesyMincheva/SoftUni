package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandLine = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!"End".equals(commandLine)){
            String[] commandData = commandLine.split(" ");
            String objectType = commandData[0];

            switch (objectType){
                case "Citizen":
                    String citizenName = commandData[1];
                    int age = Integer.parseInt(commandData[2]);
                    String id = commandData[3];
                    String birthDate = commandData[4];
                    Citizen citizen = new Citizen(citizenName, age, id, birthDate);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    String petName = commandData[1];
                    String birthDateOfPet = commandData[2];
                    Pet pet = new Pet(petName, birthDateOfPet);
                    birthables.add(pet);
                    break;
                case "Robot":
                    String model = commandData[1];
                    String idOfRobot = commandData[2];
                    Robot robot = new Robot(idOfRobot, model);
                    break;
            }


            commandLine = scanner.nextLine();
        }

        String date = scanner.nextLine();
        boolean isFound = false;
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(date)){
                System.out.println(birthable.getBirthDate());
                isFound = true;
            }
        }

        if (!isFound){
            System.out.println("<no output>");
        }
    }
}
