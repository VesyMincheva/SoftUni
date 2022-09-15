package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05 {

    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String city;

        public Student (String firstName, String lastName, int age, String city){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public String getCity() {
            return this.city;
        }

        public int getAge() {
            return this.age;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> listOfStudents = new ArrayList<>();
        while (!input.equals("end")){
            String[] inputArr = input.split(" ");
            String firstName = inputArr[0];
            String lastName = inputArr[1];
            int age = Integer.parseInt(inputArr[2]);
            String city = inputArr[3];

            Student currentStudent = new Student(firstName, lastName, age, city);
            listOfStudents.add(currentStudent);

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        for (Student element:listOfStudents) {
            if(command.equals(element.getCity())){
                System.out.printf("%s %s is %d years old%n",element.getFirstName(),element.getLastName(),element.getAge());
            }
        }
    }
}
