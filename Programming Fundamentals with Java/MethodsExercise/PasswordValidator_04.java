package MethodsExercise;

import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPass = scanner.nextLine();
        if (!passwordLength(inputPass)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if(!onlyLettersAndDigits(inputPass)){
            System.out.println("Password must consist only of letters and digits");
        }
        if(!consistTwoDigits(inputPass)){
            System.out.println("Password must have at least 2 digits");
        }
        if (passwordLength(inputPass) && onlyLettersAndDigits(inputPass) && consistTwoDigits(inputPass)){
            System.out.println("Password is valid");
        }

    }

    private static boolean passwordLength (String password){
        int passwordLength = password.length();

        if(passwordLength >= 6 && passwordLength <= 10 ){

            return true;
        }else {
            return false;
        }
    }

    private static boolean onlyLettersAndDigits (String password){
        boolean passOnlyLettersAndDigits = false;
        for (char symbol:password.toCharArray()) {
            if(!Character.isLetterOrDigit(symbol)){
                return false;
            }
        }
        return true;
    }

    private static boolean consistTwoDigits (String password){
        int digitCount = 0;
        for (char symbol:password.toCharArray()) {
            if (Character.isDigit(symbol)){
                digitCount++;
            }
        }
        if(digitCount >= 2){
            return true;
        }else {
            return false;
        }
    }
}
