package org.example;

import java.util.*;
import java.util.stream.Collectors;

//
public class NumbersDisappearedInArray {

    public static void main(String[] args)
    {
    }
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/904909228/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        //System.out.println(numSet);
        List<Integer> missing = new ArrayList<>();
        for (Integer i = 1; i<=nums.length; i++)
        {
            if (!numSet.contains(i))
            {
                //System.out.println("addding " + i);
                missing.add(i);
            }
        }

        return missing;
    }

    public static boolean foo(String s, String t) {
        long start = new Date().getTime();
        boolean b = false;
        //method 1


        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, %s, result %b, took %sms %n", s, t, b, elapsed);
        return b;
    }
}
