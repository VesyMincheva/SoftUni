package MapsLambdaAndStreamAPI_Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");

        Map<String, Integer> numbersCountMap = new TreeMap<>();

        for (int i = 0; i < inputArr.length; i++) {
            String currentNum = inputArr[i];
            Integer numCount = numbersCountMap.get(currentNum);

            if(numbersCountMap.containsKey(currentNum)){
                numbersCountMap.put(currentNum, numCount + 1);
            }else {
                numbersCountMap.put(currentNum, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : numbersCountMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(),entry.getValue());
        }


    }
}
