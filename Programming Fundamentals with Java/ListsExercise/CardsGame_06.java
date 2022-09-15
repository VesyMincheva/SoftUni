package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        

        while (firstPlayerCards.size()!= 0 && secondPlayerCards.size()!=0){

                int currentFirstPlayerHand = firstPlayerCards.get(0);
                int currentSecondPlayerHand = secondPlayerCards.get(0);
                
                if(currentFirstPlayerHand > currentSecondPlayerHand){
                    firstPlayerCards.add(currentFirstPlayerHand);
                    firstPlayerCards.add(currentSecondPlayerHand);
                    firstPlayerCards.remove(0);
                    secondPlayerCards.remove(0);


                } else if (currentFirstPlayerHand < currentSecondPlayerHand) {
                    secondPlayerCards.add(currentSecondPlayerHand);
                    secondPlayerCards.add(currentFirstPlayerHand);
                    firstPlayerCards.remove(0);
                    secondPlayerCards.remove(0);

                } else if (currentFirstPlayerHand == currentSecondPlayerHand) {
                    firstPlayerCards.remove(0);
                    secondPlayerCards.remove(0);
                }

        }
        int sum = 0;
        if(firstPlayerCards.size() > secondPlayerCards.size()){
            for (int element:firstPlayerCards) {
                sum += element;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }else {
            for (int element:secondPlayerCards) {
                sum += element;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
        
    }
}
