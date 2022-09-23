package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int toss = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        Arrays.stream(names).forEach(kid -> kidsQueue.offer(kid));

        while (kidsQueue.size() > 1) {
            for (int i = 0; i < toss - 1; i++) {
                if (!kidsQueue.isEmpty()){
                    String currentChild = kidsQueue.poll();
                    kidsQueue.offer(currentChild);
                }
            }
            String child = kidsQueue.poll();
            System.out.println("Removed " + child);
        }

        System.out.println("Last is " + kidsQueue.poll());
    }
}
