package trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] signals = scanner.nextLine().split("\\s+");
        List<TrafficLight> trafficLightList = new ArrayList<>();
        for (String signal : signals) {
            TrafficLight trafficLight = new TrafficLight(Color.valueOf(signal));
            trafficLightList.add(trafficLight);
        }
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLightList) {
                trafficLight.updateSignals();
            }
            trafficLightList.forEach(e -> System.out.print(e.getSignal() + " "));
            System.out.println();
        }
    }
}
