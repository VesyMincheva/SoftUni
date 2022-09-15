package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialSchedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")){
            String[] inputArr = input.split("\\:");
            String command = inputArr[0];
            String lessonTitle = inputArr[1];

            switch (command){
                case "Add":
                    if(!initialSchedule.contains(lessonTitle)){
                        initialSchedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(inputArr[2]);
                    if(!initialSchedule.contains(lessonTitle)){
                        initialSchedule.add(index, lessonTitle);
                    }
                    break;
                case "Remove":

                    if(initialSchedule.contains(lessonTitle)){
                        initialSchedule.remove(lessonTitle);
                    }
                    int indexToRemove = initialSchedule.indexOf(lessonTitle);
                    if(initialSchedule.get(indexToRemove + 1).equals(lessonTitle + "-Exercise")){
                        initialSchedule.remove(indexToRemove + 1);
                    }
                    break;
                case "Swap":
                    String lessonToSwap = inputArr[2];
                    if(initialSchedule.contains(lessonTitle) && initialSchedule.contains(lessonToSwap)){
                        int indexOfFirsLesson = initialSchedule.indexOf(lessonTitle);
                        int indexOfSecondLesson = initialSchedule.indexOf(lessonToSwap);
                        initialSchedule.set(indexOfFirsLesson, lessonToSwap);
                        initialSchedule.set(indexOfSecondLesson, lessonTitle);
                    }
                    break;
                case "Exercise":
                    if(initialSchedule.contains(lessonTitle) && !initialSchedule.contains(lessonTitle + "-Exercise")){
                        int indexOfLesson = initialSchedule.indexOf(lessonTitle);
                        initialSchedule.add(indexOfLesson + 1, lessonTitle + "-Exercise");
                    }else if(!initialSchedule.contains(lessonTitle)){
                        initialSchedule.add(lessonTitle);
                        initialSchedule.add(lessonTitle + "-Exercise");
                    }
                    break;
            }



            input = scanner.nextLine();
        }

        for (int i = 0; i < initialSchedule.size(); i++) {
            System.out.printf("%d.%s%n", i+1, initialSchedule.get(i));
        }
    }
}
