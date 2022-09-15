package MapsLambdaAndStreamAPI_Exercise;

import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")){
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            productsPrice.put(product, price);

            if(!productsQuantity.containsKey(product)){
                productsQuantity.put(product, quantity);
            }else {
                productsQuantity.put(product, productsQuantity.get(product) + quantity);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry:productsPrice.entrySet()) {
            String productName = entry.getKey();
            double finalPrice = entry.getValue() * productsQuantity.get(productName);
            System.out.printf("%s -> %.2f%n", productName, finalPrice);
        }
    }
}
