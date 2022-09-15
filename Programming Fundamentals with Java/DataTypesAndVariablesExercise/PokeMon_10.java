package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int powerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());

        int pokeCount = 0;
        int originPower = powerN;

        while (powerN >= distanceM){

            powerN -= distanceM;
            pokeCount++;

            if (powerN == (originPower * 0.5)){
                if (exhaustionFactorY != 0){
                    powerN = powerN / exhaustionFactorY;
                }
            }
        }
        System.out.println(powerN);
        System.out.println(pokeCount);
    }
}
