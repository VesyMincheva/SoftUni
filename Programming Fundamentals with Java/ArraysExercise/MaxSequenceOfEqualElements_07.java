package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int longestCount = 1;
        int bestLongestCount = 0;
        int startIndex = 0;
        int bestStartIndex = 0;
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            int nextElement = array[i-1];

            if(currentElement == nextElement){
                longestCount++;
            }else{
                longestCount = 1;
                startIndex = i;
            }
            if(longestCount > bestLongestCount){
                bestLongestCount = longestCount;
                bestStartIndex = startIndex;
            }
        }
        for (int i = bestStartIndex; i < bestStartIndex + bestLongestCount; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
