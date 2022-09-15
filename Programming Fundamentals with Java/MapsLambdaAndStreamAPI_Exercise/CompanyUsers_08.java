package MapsLambdaAndStreamAPI_Exercise;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, java.util.List<String>> companiesMap = new LinkedHashMap<>();

        while (!input.equals("End")){
            String company = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];

            companiesMap.putIfAbsent(company, new ArrayList<>());
            boolean duplicateID = false;
            for (String element:companiesMap.get(company)) {
                if(element.equals(employeeId)){
                    duplicateID = true;
                }
            }
            if(!duplicateID){
                companiesMap.get(company).add(employeeId);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companiesMap.entrySet()) {
            String companyName = entry.getKey();
            System.out.println(companyName);
            for (int i = 0; i < companiesMap.get(companyName).size(); i++) {
                System.out.println("-- " + companiesMap.get(companyName).get(i));
            }
        }
    }
}
