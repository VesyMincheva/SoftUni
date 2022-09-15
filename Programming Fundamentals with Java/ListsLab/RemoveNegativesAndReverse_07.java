package ListsLab;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numList.size(); i++) {
            int currentNum = numList.get(i);
            if(currentNum < 0){
                numList.remove(i);
                i = i - 1;
            }
        }
        if(numList.size() == 0){
            System.out.println("empty");
        }else {
            Collections.reverse(numList);
            for (int element:numList) {
                System.out.print(element + " ");
            }
        }


    }
}
