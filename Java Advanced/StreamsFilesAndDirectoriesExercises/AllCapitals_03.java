package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("resources/output.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));
        bufferedReader.lines().forEach(line -> printWriter.println(line.toUpperCase()));

        bufferedReader.close();
        printWriter.close();
    }
}
