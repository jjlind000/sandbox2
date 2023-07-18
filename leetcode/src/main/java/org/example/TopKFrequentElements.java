package org.example;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/top-k-frequent-elements/submissions/906164581/
public class TopKFrequentElements {

    public static void main(String[] args)
    {

        int[] nums = new int[] {1,1,1,2,2,3};

        foo(nums, 2);

    }

    public static int[] foo(int[] nums, int k) {
        long start = new Date().getTime();
        //method 1
        //not good: indexes by num not count;
        Map<Integer, Long> counts = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        Set<Long> topK = counts.values().stream().sorted(Comparator.reverseOrder()).limit(k).collect(Collectors.toSet());
        int[] ints = counts.entrySet().stream().filter(entry -> topK.contains(entry.getValue())).map(e -> e.getKey()).mapToInt(i -> i).toArray();

        Map<Integer, Long> countsSorted = new LinkedHashMap<>();
        counts.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .forEachOrdered(e-> countsSorted.put(e.getKey(), e.getValue()));

        int[] ints1 = countsSorted.entrySet().stream().limit(k).mapToInt(e -> e.getKey()).toArray();


        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, result %s, took %sms %n", nums, Arrays.toString(ints), elapsed);
        System.out.printf("got %s, result %s, took %sms %n", nums, Arrays.toString(ints1), elapsed);
        return ints;
    }
}
