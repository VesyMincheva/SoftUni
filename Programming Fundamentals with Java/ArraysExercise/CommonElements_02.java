package ArraysExercise;

import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstRow = scanner.nextLine();
        String secondRow = scanner.nextLine();

        String[] firstArray = firstRow.split(" ");
        String[] secondArray = secondRow.split(" ");

        for (int i = 0; i < secondArray.length; i++) {
           String elementFromSecond = secondArray[i];
            for (String elementFromFirst:firstArray) {
                if(elementFromSecond.equals(elementFromFirst)){
                    System.out.print(elementFromSecond + " ");
                }
            }
        }

    }
}
