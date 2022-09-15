package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String resourceName = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if(!resources.containsKey(resourceName)){
                resources.put(resourceName, quantity);
            }else {
                int currentQuantity = resources.get(resourceName);
                resources.put(resourceName, currentQuantity + quantity);
            }


            input = scanner.nextLine();
        }

       // resources.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
        resources.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
