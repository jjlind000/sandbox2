package org.example;

import java.util.Arrays;
import java.util.Date;

//https://leetcode.com/problems/binary-search/submissions/831049548/
public class BinarySearch {

    public static void main(String[] args)
    {
        //getIndex(new int[]{-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,49,50}, 39);
        //getIndex(new int[]{-1,0,1,2,3,4,5,6}, 4);
        //getIndex(new int[]{-1,0,3,5,9,12}, 9);
        //search(new int[]{-1,0,3,5,9,12}, 9);
        search(new int[]{-1,0,3,5,9,12}, 2);

    }

    public static int search(int[] nums, int target) {
        //return searchRecursively(nums, target, 0, nums.length-1);
        long start = new Date().getTime();
        int location = -1;
        int from = 0;
        int middle;
        int to = nums.length - 1;
        int i = 0;
        while (true)
        {
            if (to - from <= 1)
            {
                location = nums[from] == target ? from : nums[to] == target ? to : -1;
                break;
            }
            middle = from + ((to - from) / 2);
            if (target == nums[middle])
            {
                System.out.printf("found at = %d%n", middle);
                location = middle;
                break;
            }
            else if (target < nums[middle])
            { // is on LHS - need new middle between from and current middle, and "to" becomes current middle
                to = middle;
            }
            else
            { // is on RHS - need new middle between middle and to, and "from" becomes current middle
                from = middle;
            }
            if (++i > 5) break;
        }

        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, %s, result %d, took %sms %n", Arrays.toString(nums), target, location, elapsed);

        return location;
    }

    /*

    public static int getIndex(int[] nums, int target) {
        long start = new Date().getTime();
        //method 1 - recursive
        //int location = searchRecursively(nums, target, 0, nums.length-1);
        int location = -1;
        int from = 0;
        int middle;// = (nums.length-1)/2;
        int to = nums.length - 1;
        //int i = 0;
        while (true)
        {
            middle = from + ((to - from) / 2);
            System.out.printf("about to search: from=%d to=%d middle=%d%n", from, to, middle);
            int result = searchIteratively(nums, target, middle);
            if (result >= 0) {
                location = result;
                System.out.printf("found! at %d%n", location);
                break;
            } else if (result == -2) { // is on LHS - need new middle between from and current middle, and "to" becomes current middle
                System.out.printf("result -2 - not found at %d%n", middle);
                to = middle;
            } else { // is on RHS - need new middle between middle and to, and "from" becomes current middle
                System.out.printf("result -1 - not found at %d%n", middle);
                from = middle;
            }
            //if (++i > 3) break;
        }

        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, %s, result %d, took %sms %n", Arrays.toString(nums), target, location, elapsed);
        return location;
    }
*/

    //method 1 - recursive
    static int searchRecursively(int[] nums, int target, int from, int to)
    {
        /*
        You must write an algorithm with O(log n) runtime complexity.
        Precondition: array is sorted
        Start at middle
        Search criteria = middle item: Item Found
        Search criteria is less than middle item: Search the first half of the array
        Search criteria is larger than middle item: Search the upper half of the array
         */
        // identify middle
        System.out.printf("searching - from=%d, to=%d %n", from, to);
        int middle = from + ((to - from) / 2);
        System.out.printf("middle = %d%n", middle);
        if (target == nums[middle])
        {
            System.out.printf("found at = %d%n", middle);
            return middle;
        }
        if (to - from == 1) // last chance
        {
            return nums[from] == target ? from : nums[to] == target ? to : -1 ;
        }
        else
        {
            if (target < nums[middle])
                return searchRecursively(nums, target, from, middle);
            else
                return searchRecursively(nums, target, middle, to);
        }
    }
}
