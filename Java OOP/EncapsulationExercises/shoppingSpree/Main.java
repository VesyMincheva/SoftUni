package shoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] names = getSplit(scanner);
        Map<String, Person> people = new LinkedHashMap<>();

        for (int i = 0; i < names.length; i++) {
            String personName = names[i].split("=")[0];
            double personMoney = Double.parseDouble(names[i].split("=")[1]);

            try{
                Person person = new Person(personName, personMoney);
                people.put(personName, person);
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
                return;
            }
        }

        String[] products = getSplit(scanner);
        Map<String, Product> productsMap = new LinkedHashMap<>();

        for (int i = 0; i < products.length; i++) {
            String productName = products[i].split("=")[0];
            double productCost = Double.parseDouble(products[i].split("=")[1]);
            try{
                Product product = new Product(productName, productCost);
                productsMap.put(productName, product);
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] data = command.split("\\s+");
            String buyerName = data[0];
            String productToBuy = data[1];
            Person buyer = people.get(buyerName);
            Product product = productsMap.get(productToBuy);

            try {
                buyer.buyProduct(product);

            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

            command = scanner.nextLine();
        }

        people.values().forEach(System.out::println);
    }

    private static String[] getSplit(Scanner scanner) {
        return scanner.nextLine().split(";");
    }

}
