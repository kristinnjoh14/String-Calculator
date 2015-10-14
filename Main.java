package com.company;

import java.util.IntSummaryStatistics;

public class Main {

    public static int Add(String numbers) {
        int sum = 0;
        if(numbers.length() == 0) {}
        else if (!numbers.contains(",")) {
            sum = Integer.parseInt(numbers);
        }
        else if (numbers.contains(",")) {
            int index = numbers.indexOf(',');
            int num1 = Integer.parseInt(numbers.substring(0,index));
            int num2 = Integer.parseInt(numbers.substring(index + 1));
            sum = num1 + num2;
            //System.out.print(index);
        }
        return sum;
    }

    public static void main(String[] args) {
        String numbers = "2,3";
        System.out.print(Add(numbers));
    }
}
