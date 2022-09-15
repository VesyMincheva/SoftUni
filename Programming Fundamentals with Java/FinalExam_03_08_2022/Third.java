package FinalExam_03_08_2022;

import java.util.*;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> followersMap = new LinkedHashMap<>();

        String user = "";
        while (!input.equals("Log out")){
            String command = input.split(": ")[0];
            switch (command){
                case "New follower":
                    user = input.split(": ")[1];

                    if(!followersMap.containsKey(user)){
                        followersMap.put(user, new ArrayList<>());
                        followersMap.get(user).add(0);
                        followersMap.get(user).add(0);
                    }

                    break;
                case "Like":
                    user = input.split(": ")[1];
                    int countOfLikes = Integer.parseInt(input.split(": ")[2]);

                    if(!followersMap.containsKey(user)){
                        followersMap.put(user, new ArrayList<>());
                        followersMap.get(user).add(countOfLikes);
                        followersMap.get(user).add(0);
                    }else {
                        int currentCountOfLikes = followersMap.get(user).get(0);
                        int newLikes = currentCountOfLikes + countOfLikes;
                        followersMap.get(user).set(0, newLikes);
                    }
                    break;
                case "Comment":
                    user = input.split(": ")[1];
                    if (!followersMap.containsKey(user)){
                        followersMap.put(user, new ArrayList<>());
                        followersMap.get(user).add(0);
                        followersMap.get(user).add(1);
                    }else {
                        int currentComments = followersMap.get(user).get(1);
                        followersMap.get(user).set(1, currentComments + 1);
                    }

                    break;
                case "Blocked":
                    user = input.split(": ")[1];
                    if(!followersMap.containsKey(user)){
                        System.out.println(user + " doesn't exist.");
                    }else {
                        followersMap.remove(user);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(followersMap.size() + " followers");
        for (Map.Entry<String, List<Integer>> entry : followersMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().get(0) + entry.getValue().get(1));
        }

    }
}
