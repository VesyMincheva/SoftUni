package FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> invitations = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Set<String> filters = new HashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("Print")){
            String[] inputArr = input.split(";");
            String command = inputArr[0];
            String filterType = inputArr[1];
            String filterParameter = inputArr[2];
            if (command.equals("Add filter")){
                filters.add(filterType + ";" + filterParameter);
            }else {
                filters.remove(filterType + ";" + filterParameter);
            }

            input = scanner.nextLine();
        }
        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            invitations.removeIf(filterToApply);
        });
        invitations.forEach(name -> System.out.print(name + " "));
    }
    public static Predicate<String> getPredicate(String filter){
        String[] filterParts = filter.split(";");
        String filterType = filterParts[0];
        String filterParameter = filterParts[1];
        switch (filterType){
            case "Ends with":
                return s -> s.endsWith(filterParameter);
            case "Starts with":
                return s -> s.startsWith(filterParameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(filterParameter);
            case "Contains":
                return s -> s.contains(filterParameter);
        }
        return null;
    }
}
