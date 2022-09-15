package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class Courses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> courseMap = new LinkedHashMap<>();

        while (!input.equals("end")){
            String courseName = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];

            if(!courseMap.containsKey(courseName)){
                courseMap.put(courseName, new ArrayList<>());
            }
            courseMap.get(courseName).add(studentName);

            input = scanner.nextLine();
        }

        courseMap.entrySet()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    entry.getValue().forEach(student -> System.out.println("-- " + student));

                });

    }
}
