package ArraysExercise;

import java.util.Scanner;

public class TreasureHunt_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasureChest = scanner.nextLine().split("\\|");

        String input = scanner.nextLine();
        boolean isEmpty = false;

        while (!input.equals("Yohoho!")){
            String[] command = input.split(" ");
            switch (command[0]){
                case "Loot":
                    for (int i = 1; i < command.length ; i++) {
                       boolean alreadyExist = false;
                        for (int j = 0; j < treasureChest.length; j++) {
                            String currentLoot = command[i];
                            if (currentLoot.equals(treasureChest[j])){
                                alreadyExist = true;
                                break;
                            }
                        }
                        if(!alreadyExist){
                            String newTreasureChest = command[i] + " " + String.join(" ", treasureChest);
                            treasureChest = newTreasureChest.split(" ");
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(command[1]);
                    if(index >= 0 && index <= treasureChest.length-1){
                        String currentElement = treasureChest[index];
                        for (int i = index; i < treasureChest.length - 1; i++) {
                            treasureChest[i] = treasureChest[i + 1];
                        }
                        treasureChest[treasureChest.length-1] = currentElement;
                    }else{
                        break;
                    }
                    break;
                case "Steal":
                    int stealCount = Integer.parseInt(command[1]);
                    if(stealCount >= 0 && stealCount < treasureChest.length){
                        String[] newTreasureChest = new String [treasureChest.length-stealCount];
                        for (int i = 0; i < treasureChest.length-stealCount; i++) {
                            newTreasureChest[i] = treasureChest[i];
                        }
                        for (int i = treasureChest.length - stealCount; i < treasureChest.length - 1 ; i++) {
                            System.out.print(treasureChest[i] + ", ");
                        }
                        System.out.println(treasureChest[treasureChest.length-1]);
                        treasureChest = newTreasureChest;
                    }else if(stealCount >= 0) {
                        isEmpty = true;
                        for (int i = 0; i < treasureChest.length-1; i++) {
                            System.out.print(treasureChest[i] + ", ");
                        }
                        System.out.println(treasureChest[treasureChest.length-1]);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        if(isEmpty){
            System.out.println("Failed treasure hunt.");
        }else {
            int sum = 0;
            int count = treasureChest.length;
            for (int i = 0; i < treasureChest.length; i++) {
                int currentSum = treasureChest[i].length();
                sum += currentSum;
            }
            double result = sum * 1.0 / count;
            System.out.printf("Average treasure gain: %.2f pirate credits.", result);
        }
    }
}
