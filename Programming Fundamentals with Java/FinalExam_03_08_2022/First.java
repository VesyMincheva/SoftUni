package FinalExam_03_08_2022;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        StringBuilder passSB = new StringBuilder(password);

        String input = scanner.nextLine();

        int index = 0;
        boolean onlyLetterAndDigits = true;
        boolean consistUpper = false;
        boolean consistLower = false;
        boolean consistDigit = false;
        while (!input.equals("Complete")){
            if(input.contains("Make Upper")){
                index = Integer.parseInt(input.split(" ")[2]);
                char symbolToUpper = passSB.charAt(index);
                symbolToUpper = Character.toUpperCase(symbolToUpper);

                passSB.replace(index, index, symbolToUpper + "");
                passSB.deleteCharAt(index + 1);
                System.out.println(passSB);
            }else if (input.contains("Make Lower")){
                index = Integer.parseInt(input.split(" ")[2]);
                char symbolToLower = passSB.charAt(index);
                symbolToLower = Character.toLowerCase(symbolToLower);

                passSB.replace(index, index, symbolToLower + "");
                passSB.deleteCharAt(index + 1);
                System.out.println(passSB);
            }else if (input.contains("Insert")){
                index = Integer.parseInt(input.split(" ")[1]);
                String symbolToReplace = input.split(" ")[2];
                passSB.replace(index, index, symbolToReplace);
                System.out.println(passSB);
            }else if (input.contains("Replace")){
                String[] inputArr = input.split(" ");
                char currentChar = inputArr[1].charAt(0);
                int sumOfChars = (int) currentChar + Integer.parseInt(inputArr[2]);
                char charToReplace = (char) sumOfChars;

                for (char symbol:passSB.toString().toCharArray()) {
                    if(symbol == currentChar){
                        String newPass = passSB.toString().replace(currentChar, charToReplace);
                        passSB = new StringBuilder(newPass);
                    }
                }

                System.out.println(passSB);
            }else if (input.contains("Validation")) {
                if (passSB.length() < 8) {
                    System.out.println("Password must be at least 8 characters long!");
                    break;
                }

                for (Character symbol : passSB.toString().toCharArray()) {
                    if (!Character.isLetterOrDigit(symbol) && symbol != '_') {
                        onlyLetterAndDigits = false;
                    }
                    if (Character.isUpperCase(symbol)) {
                        consistUpper = true;
                    }
                    if (Character.isLowerCase(symbol)) {
                        consistLower = true;
                    }
                    if (Character.isDigit(symbol)) {
                        consistDigit = true;
                    }
                }

                if (!onlyLetterAndDigits) {
                    System.out.println("Password must consist only of letters, digits and _!");
                } else if (!consistUpper) {
                    System.out.println("Password must consist at least one uppercase letter!");
                } else if (!consistLower) {
                    System.out.println("Password must consist at least one lowercase letter!");
                } else if(!consistDigit) {
                    System.out.println("Password must consist at least one digit!");
                }
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();
        }
    }
}
