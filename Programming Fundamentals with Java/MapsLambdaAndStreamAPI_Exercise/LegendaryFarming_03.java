package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        Map<String , Integer> junk = new LinkedHashMap<>();
        boolean isWin = false;
        while (!isWin){
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            for (int i = 0; i <= inputArr.length - 1; i += 2) {
                String resource = inputArr[i + 1].toLowerCase();
                int quantity = Integer.parseInt(inputArr[i]);

                if(resource.equals("shards") || resource.equals("fragments") || resource.equals("motes")){
                    keyMaterials.put(resource, keyMaterials.get(resource) + quantity);
                }else {
                    if(!junk.containsKey(resource)){
                        junk.put(resource, quantity);
                    }else {
                        int currentQuantity = junk.get(resource);
                        junk.put(resource, currentQuantity + quantity);
                    }
                }

                if(keyMaterials.get("shards") >= 250){
                    System.out.println("Shadowmourne obtained!");
                    keyMaterials.put("shards", keyMaterials.get("shards") - 250);
                    isWin = true;
                    break;
                }else if(keyMaterials.get("fragments") >= 250){
                    System.out.println("Valanyr obtained!");
                    keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
                    isWin = true;
                    break;
                }else if (keyMaterials.get("motes") >= 250){
                    System.out.println("Dragonwrath obtained!");
                    keyMaterials.put("motes", keyMaterials.get("motes") - 250);
                    isWin = true;
                    break;
                }
            }

        if(isWin){
            break;
        }

        }
        keyMaterials.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        junk.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    }
}
