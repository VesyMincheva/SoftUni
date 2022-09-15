package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distanceToPokemon = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        while (distanceToPokemon.size() != 0){
            int index = Integer.parseInt(scanner.nextLine());
            int elementToRemove = 0;


            if(index < 0){
                elementToRemove = distanceToPokemon.get(0);
                distanceToPokemon.remove(0);
                distanceToPokemon.add(0, distanceToPokemon.get(distanceToPokemon.size() - 1));
                for (int i = 0; i < distanceToPokemon.size(); i++) {
                    if(distanceToPokemon.get(i) <= elementToRemove){
                        distanceToPokemon.set(i, distanceToPokemon.get(i) + elementToRemove);
                    } else if (distanceToPokemon.get(i) > elementToRemove) {
                        distanceToPokemon.set(i, distanceToPokemon.get(i) - elementToRemove);
                    }
                }
            } else if(index > distanceToPokemon.size()-1){
                elementToRemove = distanceToPokemon.get(distanceToPokemon.size()-1);
                distanceToPokemon.remove(distanceToPokemon.size()-1);
                distanceToPokemon.add(distanceToPokemon.get(0));
                for (int i = 0; i < distanceToPokemon.size(); i++) {
                    if(distanceToPokemon.get(i) <= elementToRemove){
                        distanceToPokemon.set(i, distanceToPokemon.get(i) + elementToRemove);
                    } else if (distanceToPokemon.get(i) > elementToRemove) {
                        distanceToPokemon.set(i, distanceToPokemon.get(i) - elementToRemove);
                    }
                }
            }else {
                elementToRemove = distanceToPokemon.get(index);
                distanceToPokemon.remove(index);

                for (int i = 0; i < distanceToPokemon.size(); i++) {
                    if(distanceToPokemon.get(i) <= elementToRemove){
                        distanceToPokemon.set(i, distanceToPokemon.get(i) + elementToRemove);
                    } else if (distanceToPokemon.get(i) > elementToRemove) {
                        distanceToPokemon.set(i, distanceToPokemon.get(i) - elementToRemove);
                    }
                }
            }
            sum += elementToRemove;
        }

        System.out.println(sum);
    }
}
