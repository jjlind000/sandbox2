package org.example;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//
public class ContainsDuplicate2 {

    public static void main(String[] args)
    {
        foo(new int[]{1,2,3,4});
    }

    public static boolean foo(int[] nums) {
        long start = new Date().getTime();
        boolean b = false;
        //method 1
        //b = Arrays.stream(nums).distinct().mapToObj(i -> i).collect(Collectors.toList()).size() != nums.length;
        //method 2
//        int length = nums.length;
//        Arrays.sort(nums);
//        int prev = -1;
//        for (int i : nums)
//        {
//            if (i == prev) {
//                b = true;
//                break;
//            }
//            prev = i;
//        }
//        b= false;
        // method 3
        final Set<Integer> s = new HashSet<>(nums.length);
        for (int i : nums)
        {
            if (!s.add(i)) {
                b = true;
                break;
            }
        }
        b = false;

        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, result %b, took %sms %n", nums, b, elapsed);
        return b;
    }


}
