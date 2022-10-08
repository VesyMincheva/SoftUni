package DefiningClassesExercises.OpinionPoll_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Person person = new Person();
            person.setName(input[0]);
            person.setAge(Integer.parseInt(input[1]));
            people.add(person);
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted((left, right) -> left.getName().compareTo(right.getName()))
                .forEach(System.out::println);
    }
}
