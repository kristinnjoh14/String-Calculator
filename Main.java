package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.IntSummaryStatistics;

public class Main {

    public static int Add(String numbers) {
        int sum = 0;
        if(numbers.length() == 0) {}
        else if (!numbers.contains(",") && !numbers.contains("/n")) {
            sum = Integer.parseInt(numbers);
        }
        else if (numbers.contains(",") || numbers.contains(("/n"))) {
            int index1 = 0;
            StringBuffer nums = new StringBuffer(numbers);
            while (nums.toString().contains(",") || nums.toString().contains("/n") || index1 == -1) {
                int index = nums.toString().indexOf(',');
                int nindex = nums.toString().indexOf('/');
                if ((nindex < index || index == -1) && nindex != -1) {
                    index = nindex;
                    nums.deleteCharAt(index);
                }

                int num1 = Integer.parseInt(nums.substring(index1, index));
                //int num2 = Integer.parseInt(numbers.substring(index + 1));
                sum = sum + num1;
                //System.out.print(index);
                nums = nums.deleteCharAt(index);
                index1 = index;
                //System.out.print(nums.charAt(index));
            }
            int num1 = Integer.parseInt(nums.substring(index1));
            sum = sum + num1;
        }
        return sum;
    }

    public static void main(String[] args) {
        String numbers = "1,25/n3,7/n5,4/n5";
        System.out.print(Add(numbers));
    }
}
