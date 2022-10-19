import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(firstBox::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(secondBox::push);

        int sumOfWantedItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()){
            int numFromFirst = firstBox.peek();
            int numFromSecond = secondBox.peek();

            if ((numFromFirst + numFromSecond) % 2 == 0){
                sumOfWantedItems += numFromFirst + numFromSecond;
                firstBox.poll();
                secondBox.pop();
            }else {
                secondBox.pop();
                firstBox.offer(numFromSecond);
            }



        }

        if (firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }

        if (sumOfWantedItems >= 100){
            System.out.println("Your loot was epic! Value: " + sumOfWantedItems);
        }else {
            System.out.printf("Your loot was poor... Value: %d", sumOfWantedItems);
        }
    }
}
