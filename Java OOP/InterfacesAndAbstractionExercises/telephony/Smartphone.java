package telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (onlyLetters(url)){
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private boolean onlyLetters (String url){
        for (char singleChar : url.toCharArray()) {
            if (Character.isDigit(singleChar)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (onlyDigit(number)){
                sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            }else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private boolean onlyDigit (String number){
        for (char num : number.toCharArray()) {
            if (!Character.isDigit(num)){
                return false;
            }
        }
        return true;
    }
}
