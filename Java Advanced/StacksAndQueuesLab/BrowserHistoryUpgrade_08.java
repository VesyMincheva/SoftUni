package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        String currentURL = null;

        while (!input.equals("Home")){
            if (input.equals("back")){
                if(history.isEmpty()){
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }else {
                    forwardHistory.push(currentURL);
                    currentURL = history.pop();
                }
            } else if (input.equals("forward")) {
                if(forwardHistory.isEmpty()){
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                }else {
                    history.push(currentURL);
                    currentURL = forwardHistory.pop();
                }
            } else {
                if (currentURL != null){
                    history.push(currentURL);
                    if (!forwardHistory.isEmpty()){
                        forwardHistory.clear();
                    }
                }
                currentURL = input;
            }
            System.out.println(currentURL);


            input = scanner.nextLine();
        }
    }
}
