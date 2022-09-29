package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class LineNumbers_05 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("resources/inputLineNumbers.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("resources/output.txt"));

        String line = bf.readLine();
        int counter = 1;
        while (line != null){
            pw.println(counter + ". " + line);
            counter++;
            line = bf.readLine();
        }
        bf.close();
        pw.close();
    }
}
