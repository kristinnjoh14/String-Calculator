package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.IntSummaryStatistics;

public class Main {

    public static class NegativeException extends RuntimeException {
        public NegativeException(String negatives) {
            super("Negatives not allowed: " + negatives);
        }
    }

    public static int Add(String numbers) throws NegativeException {
        StringBuffer nums = new StringBuffer(numbers);
        int sum = 0;
        String delimiter;
        String negatives = "";
        if (numbers.contains("//")) {
            int index = nums.toString().indexOf('\\');
            delimiter = numbers.substring(3,index -1);
            nums.delete(0,index + 2);
            while (nums.toString().contains(delimiter)) {
                int findex = nums.indexOf(delimiter);
                int lindex = findex + delimiter.length();
                int num = Integer.parseInt(nums.toString().substring(0,findex));
                if (num > 1000) {}
                else {
                    if (num < 0) {
                        negatives = negatives + nums.toString().substring(0, findex);
                    }
                    sum = sum + num;
                }
                nums.delete(0,lindex);
            }
            if (Integer.parseInt(nums.toString()) < 0) {negatives = negatives + nums;}
            if (!negatives.isEmpty()) {
                throw new NegativeException(negatives);
            }
            sum = sum + Integer.parseInt(nums.toString());
        }
        else {
            if (numbers.length() == 0) {}
            else if (!numbers.contains(",") && !numbers.contains("\\n")) {
                if (Integer.parseInt(numbers) > 1000) {}
                else {
                    if (Integer.parseInt(numbers) < 0) {
                        throw new NegativeException(numbers);
                    }
                    sum = Integer.parseInt(numbers);
                }
            }
            else if (numbers.contains(",") || numbers.contains(("\\n"))) {
                int index1 = 0;
                while (nums.toString().contains(",") || nums.toString().contains("\\n") || index1 == -1) {
                    int index = nums.toString().indexOf(',');
                    int nindex = nums.toString().indexOf('\\');
                    if ((nindex < index || index == -1) && nindex != -1) {
                        index = nindex;
                        nums.deleteCharAt(index);
                    }
                    int num1 = Integer.parseInt(nums.substring(index1, index));
                    if (num1 > 1000) {}
                    else {
                        if (num1 < 0) {
                            negatives = negatives + Integer.parseInt(nums.substring(index1, index));
                        }
                        sum = sum + num1;
                    }
                    nums = nums.deleteCharAt(index);
                    index1 = index;
                }
                int num1 = Integer.parseInt(nums.substring(index1));
                if (num1 > 1000) {}
                else {
                    if (num1 < 0) {
                        negatives = negatives + Integer.parseInt(nums.substring(index1));
                    }
                    if (!negatives.isEmpty()) {
                        throw new NegativeException(negatives);
                    }
                    sum = sum + num1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String numbers = "//[swanky]\\n1swanky2swanky3";
        System.out.print(Add(numbers));
    }
}