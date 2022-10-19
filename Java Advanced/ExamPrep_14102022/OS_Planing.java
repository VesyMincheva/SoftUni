package ExamPrep_14102022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OS_Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(threads::offer);

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());
        boolean taskIsKilled = false;

        while (!taskIsKilled){
            int currentTask = tasks.peek();
            int currentThread = threads.peek();

            if (currentTask == taskToBeKilled){
                System.out.printf("Thread with value %d killed task %d%n", currentThread, taskToBeKilled);
                taskIsKilled = true;
                tasks.pop();
                break;
            }

            if (currentThread >= currentTask){
                tasks.pop();
                threads.poll();
            }else {
                threads.poll();
            }

        }
        for (Integer thread : threads) {
            System.out.print(thread + " ");
        }
    }
}
