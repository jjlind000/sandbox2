package org.example;

import java.util.*;

//
public class TwoSum2 {

    public static void main(String[] args)
    {
        foo(new int[]{1,2,3,4}, 7);
    }

    public static void foo(int[] nums, int target) {
        long start = new Date().getTime();
        int [] result = new int[]{0,0};
        //method 1 brute force
//        for (int i=0; i<nums.length; i++)
//        {
//            for(int j=i+1;j<nums.length;j++)
//            {
//                if (nums[i] + nums[j] == target)
//                     result = new int[]{i,j};
//            }
//        }



        //method 2 hashmap
        // 1,2,3,4; 7
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++)
        {
            int neededValue = target - nums[i];
            // try to get from map
            if (map.get(neededValue) != null) {
                result = new int[]{i, map.get(neededValue)};
                break;
            }
            else
                map.put(nums[i], i);
        }

        if (result == new int[]{0, 0} )
            throw new IllegalArgumentException("no solution");

        long elapsed = new Date().getTime() - start;
        System.out.printf("result %s%n", Arrays.toString(result));
        System.out.printf("took %sms %n", elapsed);

    }


}
