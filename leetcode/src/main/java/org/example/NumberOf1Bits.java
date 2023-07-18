package org.example;

import java.util.Arrays;
import java.util.Date;

//https://leetcode.com/problems/single-number/submissions/852516073/
public class NumberOf1Bits {

    public static void main(String[] args)
    {
        hammingWeight(0b00000000010000001000000000001011);

    }

    public static int hammingWeight(int n) {
        long start = new Date().getTime();
        int input = n;
        int result = 0;
        //method 1
//        int a = 3;
//        int b = 2;
//        System.out.printf("%s & %s = %s %s %n", Integer.toBinaryString(a), Integer.toBinaryString(b), a & b, Integer.toBinaryString(a & b));
//        result = (int) Integer.toBinaryString(n).chars().filter(c -> c == '1').count();


        int count = 0;
        for (int i=1; i<32; i++)
        {
            if ((n & 1) == 1)
            {
                count++;
            }
            n >>= 1;
        }
        result = count;




/*
        //method 2
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            n >>= 1;
        }
        result = count;
*/

        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, result %s, took %sms %n", Integer.toBinaryString(input), result, elapsed);
        return result;
    }
}
