package TextProcessingExercise;

import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] usernamesArr = input.split(", ");

        for (int i = 0; i < usernamesArr.length; i++) {
            String currentUsername = usernamesArr[i];
            if(isValid(currentUsername)){
                System.out.println(currentUsername);
            }
        }
    }

    public static boolean isValid (String currentUsername){
        if(currentUsername.length() < 3 || currentUsername.length() > 16){
            return false;
        }

        for (Character symbol:currentUsername.toCharArray()) {

            if(symbol != '-' && symbol != '_' && !Character.isLetterOrDigit(symbol)){
                return false;
            }
        }
        return true;
    }
}
