package collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] word = scanner.nextLine().split(" ");
        int countRemoveOperations = Integer.parseInt(scanner.nextLine());

        addOperation(word, addCollection);
        addOperation(word, addRemoveCollection);
        addOperation(word, myList);
        removeOperations(countRemoveOperations, addRemoveCollection);
        removeOperations(countRemoveOperations, myList);
    }

    public static void addOperation (String[] words, Addable addable){
        for (String word : words) {
            System.out.print(addable.add(word) + " ");
        }
        System.out.println();
    }

    public static void removeOperations (int counter, AddRemovable addRemovable){
        for (int i = 0; i < counter; i++) {
            System.out.print(addRemovable.remove() + " ");
        }
        System.out.println();
    }
}
