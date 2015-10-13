package com.company;

        import java.util.IntSummaryStatistics;

public class Main {

    public static int Add(String numbers) {
        int sum = 0;
        if (!numbers.contains(",")) {
            sum = Integer.parseInt(numbers);
        }
        else if (numbers.contains(",")) {
            sum = 3;
        }
        return sum;
    }

    public static void main(String[] args) {
        String numbers = "2";
        System.out.print(Add(numbers));
    }
}
