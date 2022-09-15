package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms_05Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split("[,\\s]+");

        for (int i = 0; i < inputArr.length; i++) {
            String currentDemon = inputArr[i];

            String regexForHealth = "[^0-9+\\-*\\/.]";
            Pattern patternForHealth = Pattern.compile(regexForHealth);
            Matcher matcherForHealth = patternForHealth.matcher(currentDemon);
            int totalHealth = 0;

            while (matcherForHealth.find()){
                totalHealth += matcherForHealth.group().charAt(0);
            }

            String regexForDamage = "[+-]?\\d[.0-9]*";
            Pattern patternForDamage = Pattern.compile(regexForDamage);
            Matcher matcherForDamage = patternForDamage.matcher(currentDemon);

            double baseDamage = 0;
            while (matcherForDamage.find()){
                baseDamage+= Double.parseDouble(matcherForDamage.group());
            }

            String regexForAction = "[*\\/]";
            Pattern patternForAction = Pattern.compile(regexForAction);
            Matcher matcherForAction = patternForAction.matcher(currentDemon);

            double damage = baseDamage;
            while (matcherForAction.find()){
                if(matcherForAction.group().equals("*")){
                    damage = damage * 2;
                }else if (matcherForAction.group().equals("/")){
                    damage = damage / 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", currentDemon, totalHealth, damage);
        }

    }
}
