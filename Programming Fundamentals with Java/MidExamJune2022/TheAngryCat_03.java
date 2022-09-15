package MidExamJune2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheAngryCat_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> ratingsList = Arrays.stream(scanner.nextLine().split(", "))
                                    .map(Integer::parseInt).collect(Collectors.toList());

        int entryPointIndex = Integer.parseInt(scanner.nextLine());
        String typeOfItems = scanner.nextLine();
        int valueOfEntryPoint = ratingsList.get(entryPointIndex);

        int leftSum = 0;
        int rightSum = 0;

        for (int left = 0; left < entryPointIndex; left++) {
            switch (typeOfItems){
                case "cheap":
                    if(ratingsList.get(left) < valueOfEntryPoint){
                        leftSum += ratingsList.get(left);
                    }
                    break;
                case "expensive":
                    if((ratingsList.get(left) >= valueOfEntryPoint)){
                        leftSum += ratingsList.get(left);
                    }
                    break;
            }
        }

        for (int right = entryPointIndex + 1; right < ratingsList.size() ; right++) {
            switch (typeOfItems){
                case "cheap":
                    if(ratingsList.get(right) < valueOfEntryPoint){
                        rightSum += ratingsList.get(right);
                    }
                    break;
                case "expensive":
                    if((ratingsList.get(right) >= valueOfEntryPoint)){
                        rightSum += ratingsList.get(right);
                    }
                    break;
            }
        }
        String biggerSide = "";
        if(leftSum >= rightSum){
            biggerSide = "Left";
            System.out.printf("%s - %d", biggerSide, leftSum);
        }else {
            biggerSide = "Right";
            System.out.printf("%s - %d", biggerSide, rightSum);
        }
    }
}
