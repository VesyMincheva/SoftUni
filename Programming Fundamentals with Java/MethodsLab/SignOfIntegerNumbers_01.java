package MethodsLab;

import java.util.Scanner;

public class SignOfIntegerNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printsTheSign(n);
    }

    public static void printsTheSign (int num){
        if(num > 0){
            System.out.printf("The number %d is positive.", num);
        }else if(num < 0){
            System.out.printf("The number %d is negative.", num);
        }else {
            System.out.println("The number 0 is zero.");
        }
    }
}
