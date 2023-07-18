package org.example;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/single-number/submissions/852516073/
public class SingleNumber {

    public static void main(String[] args)
    {
        singleNumber(new int[]{2, 2, 1});
        singleNumber(new int[]{4,1,2,1,2});
        singleNumber(new int[]{1});


    }

    public static int singleNumber(int [] nums) {
        long start = new Date().getTime();
        int result = 0;
        //method 1
//        Set<Integer> ints = new HashSet<>();
//        for (int num : nums) {
//            boolean isNew = ints.add(num);
//            if (!isNew)
//                ints.remove(num);
//        }
//
//        Object[] objects = ints.toArray();
//        result = (int) objects[0];

        //method 2
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++)
            ans ^= nums[i];
        result = ans;


        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, result %s, took %sms %n", Arrays.toString(nums), result, elapsed);
        return result;
    }
}
