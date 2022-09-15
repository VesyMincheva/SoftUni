package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage_01_Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phrases = new ArrayList<>();
        phrases.add("Excellent product.");
        phrases.add("Such a great product.");
        phrases.add("I always use that product.");
        phrases.add("Best product of its category.");
        phrases.add("Exceptional product.");
        phrases.add("I can’t live without this product.");

        List<String> events = new ArrayList<>();
        events.add("Now I feel good.");
        events.add("I have succeeded with this product.");
        events.add("Makes miracles. I am happy of the results!");
        events.add("I cannot believe but now I feel awesome.");
        events.add("Try it yourself, I am very satisfied.");
        events.add("I feel great!");

        List<String> authors = new ArrayList<>();
        authors.add("Diana");
        authors.add("Petya");
        authors.add("Stella");
        authors.add("Elena");
        authors.add("Katya");
        authors.add("Iva");
        authors.add("Annie");
        authors.add("Eva");

        List<String> cities = new ArrayList<>();
        cities.add("Burgas");
        cities.add("Sofia");
        cities.add("Plovdiv");
        cities.add("Varna");
        cities.add("Ruse");

        Random randomIndex = new Random();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {

            int randomPhraseIndex = randomIndex.nextInt(phrases.size());
            int randomEventIndex = randomIndex.nextInt(events.size());
            int randomAuthorIndex = randomIndex.nextInt(authors.size());
            int randomCityIndex = randomIndex.nextInt(cities.size());

            System.out.printf("%s %s %s – %s%n", phrases.get(randomPhraseIndex), events.get(randomEventIndex),
                    authors.get(randomAuthorIndex), cities.get(randomCityIndex));
        }
    }
}
