package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> furnitureList = new ArrayList<>();


        double totalSum = 0;
        while (!input.equals("Purchase")){
            String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnitureList.add(matcher.group("furniture"));
                double currentPrice = price * quantity;
                totalSum += currentPrice;
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furnitureList.forEach(entry -> System.out.println(entry));
        System.out.printf("Total money spend: %.2f",totalSum);
    }
}
