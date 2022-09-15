package students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> listOfStudents = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String personalData = scanner.nextLine();
            String firstName = personalData.split(" ")[0];
            String lastName = personalData.split(" ")[1];
            double grade = Double.parseDouble(personalData.split(" ")[2]);

            Student student = new Student(firstName, lastName, grade);
            listOfStudents.add(student);
        }

        listOfStudents.sort(Comparator.comparingDouble(Student ::getGrade).reversed());

        for (Student element:listOfStudents) {
            System.out.println(element.toString());
        }
    }
}
