package org.example;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/submissions/
public class ContainsDuplicate {

    public static void main(String[] args)
    {
        //foo();
        containsDuplicate(new int[]{3,3});
        containsDuplicate(new int[]{1,2,3,1});
        containsDuplicate(new int[]{1,2,3,4});
        containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
    }

//    private static void foo()
//    {
//        // 2 ways to declare and define
//        int[] nums = new int[] {1,2,3,4};
//        int[] nums2 = {1,2,3,4};
//
//
//    }

    public static boolean containsDuplicate(int[] nums) {
        long start = new Date().getTime();
        boolean b = false;
        //method 1
        //b = IntStream.of(nums).distinct().count() != nums.length;
        //method 2
//        int[] sorted = IntStream.of(nums).sorted().toArray();
//        for (int i = 1; i<sorted.length; i++) {
//            if (sorted[i - 1] == sorted[i]) {
//                b = true;
//                break;
//            }
//        }
        //method 3
//        Arrays.sort(nums);
//        for (int i = 1; i<nums.length; i++) {
//            if (nums[i - 1] == nums[i]) {
//                b = true;
//                break;
//            }
//        }
        //method 4 - takes too long
//        loop:
//        for (int i = 0; i<nums.length; i++) {
//            for (int j = i+1; j<nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//            if (i > 0 && nums[i - 1] == nums[i]) {
//                b = true;
//                System.out.println(String.format("breaking on %d %d %d", i, nums[i], nums[i-1]));
//                break loop;
//            }
//        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                b = true;
                break;
            }
        }


        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, result %b, took %sms %n", Arrays.toString(nums), b, elapsed);
        return b;
    }
}
