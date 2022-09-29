package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("resources/input.txt"));

        String line = bf.readLine();
        while (line != null){
            int sum = 0;
            char[] symbolsFromLine = line.toCharArray();
            for (char symbol : symbolsFromLine) {
                sum += symbol;
            }
            System.out.println(sum);
            line = bf.readLine();
        }
        bf.close();
    }
}
