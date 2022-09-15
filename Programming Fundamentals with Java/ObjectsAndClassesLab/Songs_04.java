package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs_04 {

    static class Song {
        private String typeList;
        private String name;
        private String time;

        public void setTypeList (String typeList){
            this.typeList = typeList;
        }

        public String getTypeList(){
            return this.typeList;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setTime (String time){
            this.time = time;
        }

        public String getTime() {
            return time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int n = Integer.parseInt(scanner.nextLine());

        List<Song> listSongs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] inputArr = scanner.nextLine().split("_");
            String inputType = inputArr[0];
            String inputName = inputArr[1];
            String inputTime = inputArr[2];

            Song song = new Song();
            song.setTypeList(inputType);
            song.setName(inputName);
            song.setTime(inputTime);

            listSongs.add(song);

        }

        String command = scanner.nextLine();

        if(command.equals("all")){
            for (Song item:listSongs) {
                System.out.println(item.getName());
            }
        }else {
            for (Song item:listSongs) {
                if(item.getTypeList().equals(command)){
                    System.out.println(item.getName());
                }
            }
        }
    }
}
