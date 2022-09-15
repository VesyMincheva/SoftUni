package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> usersMap = new LinkedHashMap<>();
        for (int i = 1; i <= n ; i++) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];
            String userName = input.split(" ")[1];
            switch (command){
                case "register":
                    String licenseNumber = input.split(" ")[2];
                    if(!usersMap.containsKey(userName)){
                        usersMap.put(userName, licenseNumber);
                        System.out.printf("%s registered %s successfully%n", userName, usersMap.get(userName));
                    }else {
                        System.out.printf("ERROR: already registered with plate number %s%n", usersMap.get(userName));
                    }
                    break;
                case "unregister":
                    if(!usersMap.containsKey(userName)){
                        System.out.printf("ERROR: user %s not found%n", userName);
                    }else {
                        usersMap.remove(userName);
                        System.out.printf("%s unregistered successfully%n", userName);
                    }
                    break;
            }

        }

        usersMap.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
