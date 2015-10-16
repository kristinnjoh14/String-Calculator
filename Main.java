package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.IntSummaryStatistics;

public class Main {

    public static int Add(String numbers) {
        StringBuffer nums = new StringBuffer(numbers);
        int sum = 0;
        String delimiter;
        if (numbers.contains("//")) {
            int index = nums.toString().indexOf('\\');
            //System.out.print(index);
            delimiter = numbers.substring(2,index);
            nums.delete(0,index + 2);
            //int index1 = 0;
            while (nums.toString().contains(delimiter)) {
                int findex = nums.indexOf(delimiter);
                int lindex = findex + delimiter.length();
                sum = sum + Integer.parseInt(nums.toString().substring(0,findex));
                nums.delete(0,lindex);
                //index1 = lindex;
               // System.out.print(sum + " " + lindex);
            }
            sum = sum + Integer.parseInt(nums.toString());
        }
        else {
            if (numbers.length() == 0) {
            } else if (!numbers.contains(",") && !numbers.contains("\\n")) {
                sum = Integer.parseInt(numbers);
            } else if (numbers.contains(",") || numbers.contains(("\\n"))) {
                int index1 = 0;
                while (nums.toString().contains(",") || nums.toString().contains("\\n") || index1 == -1) {
                    int index = nums.toString().indexOf(',');
                    int nindex = nums.toString().indexOf('\\');
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
        }
        return sum;
    }

    public static void main(String[] args) {
        String numbers = "//swanky\\n1swanky2swanky3swanky4";
        System.out.print(Add(numbers));
    }
}