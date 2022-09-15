package MapsLambdaAndStreamAPI_Exercise;

import java.sql.Array;
import java.util.*;

public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if(!studentsGrades.containsKey(studentName)){
                studentsGrades.put(studentName, new ArrayList<>());
                studentsGrades.get(studentName).add(grade);
            }else {
                studentsGrades.get(studentName).add(grade);
            }
        }

        Map<String, Double> studentsAverageGrades = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry: studentsGrades.entrySet()) {
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double averageGrade = getAverageGrade(grades);
            if(averageGrade >= 4.50){
                studentsAverageGrades.put(studentName, averageGrade);
            }
        }

        studentsAverageGrades.entrySet().forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }

    public static double getAverageGrade (List<Double> grades){
        double sum = 0;
        for (double grade:grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
