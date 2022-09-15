package articlesVol2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> listOfArticles = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            String inputData = scanner.nextLine();
            String title = inputData.split("\\, ")[0];
            String content = inputData.split("\\, ")[1];
            String author = inputData.split("\\, ")[2];

            Article article = new Article(title, content, author);
            listOfArticles.add(article);
        }

        String command = scanner.nextLine();

        for (Article article:listOfArticles) {
            System.out.println(article.toString());
        }
    }
}
