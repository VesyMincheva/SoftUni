package FinalExam_03_08_2022;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n ; i++) {
        String input = scanner.nextLine();
        String regex = "\\|(?<name>[A-Z]{4,})\\|:#(?<title>[A-Za-z]* [A-Za-z]*)#";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if(!matcher.find()){
            System.out.println("Access denied!");
        }else {
            String name = matcher.group("name");
            String title = matcher.group("title");
            System.out.println(name + ", The " + title);
            System.out.printf(">> Strength: %d%n", name.length());
            System.out.printf(">> Armor: %d%n", title.length());
        }


        }
    }
}
