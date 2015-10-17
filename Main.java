package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.IntSummaryStatistics;

public class Main {

    public static class NegativeException extends RuntimeException {
        public NegativeException(String negatives) {
            super("Negatives not allowed: " + negatives);
        }
    }

    public static class delimBoolLength {
        public boolean bool;
        public String delim;
        public delimBoolLength(boolean b, String l) {
            bool = b;
            delim = l;
        }
    }

    public static delimBoolLength checkDelimiter(String string, String delimiter) {
        StringBuffer delim = new StringBuffer(delimiter);
        while (delim.toString().contains("]")) {
            int index = delim.toString().indexOf(']');
            try { String test = string.split("\\d")[1]; }
            catch (ArrayIndexOutOfBoundsException aie) { return new delimBoolLength(false, null); }
            if(string.split("\\d|-\\d")[1].contentEquals(delim.substring(0, index))) {
            return new delimBoolLength(true, delim.toString().substring(0, index));
            }
            delim.delete(0, index + 2);
        }
        return new delimBoolLength(false, null);
    }

    public static int Add(String numbers) throws NegativeException {
        StringBuffer nums = new StringBuffer(numbers);
        int sum = 0;
        String delimiter = ",][\\n]";
        String negatives = "";
        if (numbers.contains("//[")) {
            int index = nums.toString().indexOf('\\');
            delimiter = delimiter + numbers.substring(2, index);
            nums.delete(0, index + 2);
        }
        if (numbers.length() == 0) {}
        else {
            if (!checkDelimiter(nums.toString(), delimiter).bool) {
                if (Integer.parseInt(numbers) > 1000) {}
                else {
                   if (Integer.parseInt(numbers) < 0) {
                       throw new NegativeException(numbers);
                   }
                    sum = Integer.parseInt(numbers);
                }
            }
            while (checkDelimiter(nums.toString(), delimiter).bool) {
                delimBoolLength dbl = checkDelimiter(nums.toString(), delimiter);
                int findex = nums.indexOf(dbl.delim);
                int lindex = findex + dbl.delim.length();
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
        return sum;
    }

    public static void main(String[] args) {
        String numbers = "//[swanky][cool]\\n1swanky2cool3swanky4cool5,6\\n7";
        System.out.print(Add(numbers));
    }
}