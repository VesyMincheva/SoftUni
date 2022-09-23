package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int toss = Integer.parseInt(scanner.nextLine());
        int round = 1;

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        Arrays.stream(names).forEach(kid -> kidsQueue.offer(kid));

        while (kidsQueue.size() > 1) {
            for (int i = 0; i < toss - 1; i++) {
                String currentChild = kidsQueue.poll();
                kidsQueue.offer(currentChild);
            }
            if (isPrime(round)) {
                String child = kidsQueue.peek();
                System.out.println("Prime " + child);
            } else {
                String child = kidsQueue.poll();
                System.out.println("Removed " + child);
            }
            round++;

        }
        System.out.println("Last is " + kidsQueue.poll());

    }
    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
