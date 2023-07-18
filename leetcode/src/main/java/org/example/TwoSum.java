package org.example;

import java.util.Arrays;
import java.util.Date;

//https://leetcode.com/problems/two-sum/submissions/828913998/
public class TwoSum {

    public static void main(String[] args)
    {
        foo(new int[]{2,7,111,15}, 9);
        foo(new int[]{3,2,4}, 6);
        foo(new int[]{3,3}, 6);
    }

    public static int[] foo(int [] nums, int target) {
        long start = new Date().getTime();
        boolean b = false;
        //method 1 - good but not exceptional
        int [] solution = new int[2];
        for (int i = 0; i<nums.length; i++)
        {
            if (Math.abs(i) > Math.abs(target))
                continue;
            for (int j=i+1; j<nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                    solution = new int[]{i, j};
            }
        }

        /*
        Method 1 - neetcode solution
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(nums[i])) {
                return new int[] { prevMap.get(num), i };
            }

            prevMap.put(diff, i);
        }

        solution = new int[] {};
         */


        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, %s, result %s, took %sms %n", Arrays.toString(nums), target, Arrays.toString(solution), elapsed);
        return solution;
    }
}
