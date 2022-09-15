package TextProcessingExercise;

import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder newText = new StringBuilder();

        String input = scanner.nextLine();
        for (char symbol:input.toCharArray()) {
            int encryptedSymbol = (int)symbol + 3;
            newText.append((char) encryptedSymbol);
        }
        System.out.println(newText);
    }
}
