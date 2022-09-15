package TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split("\\\\");
        String fileNameAndExtension = inputArr[inputArr.length-1];
        String fileName = fileNameAndExtension.split("\\.")[0];
        String extension = fileNameAndExtension.split("\\.")[1];

        System.out.printf("File name: %s%n",fileName);
        System.out.printf("File extension: %s",extension);
    }
}
